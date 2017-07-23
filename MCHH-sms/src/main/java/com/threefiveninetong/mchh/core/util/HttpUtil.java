package com.threefiveninetong.mchh.core.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.crypto.Cipher;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class HttpUtil {
	private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

	public static <T> T postXmlData(Object obj, String url, Class<T> c) {

		String data = XMLJaxbUtil.convertToXml(obj);
		System.out.println(data);
		HttpParams mHttpParams = new BasicHttpParams();
		// 设置网络链接超时
		// 即:Set the timeout in milliseconds until a connection is established.
		HttpConnectionParams.setConnectionTimeout(mHttpParams, 20 * 1000);
		// 设置socket响应超时
		// 即:in milliseconds which is the timeout for waiting for data.
		HttpConnectionParams.setSoTimeout(mHttpParams, 20 * 1000);
		// 设置socket缓存大小
		HttpConnectionParams.setSocketBufferSize(mHttpParams, 8 * 1024);
		// 设置是否可以重定向
		HttpClientParams.setRedirecting(mHttpParams, true);

		HttpClient httpclient = new DefaultHttpClient(mHttpParams);

		HttpPost httppost = new HttpPost(url);
		// PostMethod post = new
		// PostMethod("http://localhost:8080/Test/ReceiveXmlHttpServlet");
		httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
		// httppost.setHeader("Content-type", "text/xml; charset=UTF-8");
		try {
			StringEntity myEntity = new StringEntity(data, "UTF-8");
			httppost.setEntity(myEntity);
			HttpResponse response = httpclient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				String responedata = EntityUtils.toString(response.getEntity());
				log.info(responedata);
				httpclient.getConnectionManager().shutdown();
				return XMLJaxbUtil.converyToJavaBean(responedata, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("HttpUtil", e);
			throw new SystemException(e);
		}
		return null;
	}

	public static <T> T postAESXmlData(Object obj, String url, Class<T> c) {

		String data = XMLJaxbUtil.convertToXml(obj);
		System.out.println(data);
		HttpParams mHttpParams = new BasicHttpParams();
		// 设置网络链接超时
		// 即:Set the timeout in milliseconds until a connection is established.
		HttpConnectionParams.setConnectionTimeout(mHttpParams, 20 * 1000);
		// 设置socket响应超时
		// 即:in milliseconds which is the timeout for waiting for data.
		HttpConnectionParams.setSoTimeout(mHttpParams, 20 * 1000);
		// 设置socket缓存大小
		HttpConnectionParams.setSocketBufferSize(mHttpParams, 8 * 1024);
		// 设置是否可以重定向
		HttpClientParams.setRedirecting(mHttpParams, true);

		HttpClient httpclient = new DefaultHttpClient(mHttpParams);

		HttpPost httppost = new HttpPost(url);
		// PostMethod post = new
		// PostMethod("http://localhost:8080/Test/ReceiveXmlHttpServlet");
		httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
		// httppost.setHeader("Content-type", "text/xml; charset=UTF-8");
		try {

			String keys = ConfigUtils.getStringByKey("SEKey");
			CryptAES aes = new CryptAES(keys, 128);
			byte[] encryptByte = aes.encrypt(data.getBytes("UTF-8"));
			String out = new String(Base64
					.encodeBase64URLSafeString(encryptByte));
			StringEntity myEntity = new StringEntity(out, "UTF-8");
			httppost.setEntity(myEntity);
			HttpResponse response = httpclient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				String body = EntityUtils.toString(response.getEntity());
		        byte[] decrypt = aes.decrypt(Base64.decodeBase64(body));
		        	String	responedata =new String(decrypt, "UTF-8");
		        	log.info(responedata);
		        	httpclient.getConnectionManager().shutdown();
					return XMLJaxbUtil.converyToJavaBean(responedata, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("HttpUtil", e);
			throw new SystemException(e);
		}
		return null;
	}

	public static String post(String url, Map<String, String> params) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		log.info("create httppost:" + url);
		HttpPost post = postForm(url, params);

		body = invoke(httpclient, post);

		httpclient.getConnectionManager().shutdown();
		return body;
	}

	public static <T> T postFormDataJson(String url,
			Map<String, String> params, Class<T> c) {

		return JSON.parseObject(post(url, params), c);
	}

	public static <T> T postFormDataXml(String url, Map<String, String> params,
			Class<T> c) {

		try {
			return XMLJaxbUtil.converyToJavaBean(post(url, params), c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String get(String url) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		log.info("create httppost:" + url);
		HttpGet get = new HttpGet(url);
		body = invoke(httpclient, get);

		httpclient.getConnectionManager().shutdown();

		return body;
	}

	private static String invoke(DefaultHttpClient httpclient,
			HttpUriRequest httpost) {

		HttpResponse response = sendRequest(httpclient, httpost);
		String body = paseResponse(response);

		return body;
	}

	private static String paseResponse(HttpResponse response) {
		log.info("get response from http server..");
		HttpEntity entity = response.getEntity();

		log.info("response status: " + response.getStatusLine());
		String charset = EntityUtils.getContentCharSet(entity);
		log.info(charset);

		String body = null;
		try {
			body = EntityUtils.toString(entity);
			log.info(body);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} 
		return body;
	}

	private static HttpResponse sendRequest(DefaultHttpClient httpclient,
			HttpUriRequest httpost) {
		log.info("execute post...");
		HttpResponse response = null;

		try {
			response = httpclient.execute(httpost);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} 
		return response;
	}

	private static HttpPost postForm(String url, Map<String, String> params) {

		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}

		try {
			log.info("set utf-8 form entity to httppost");
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		}

		return httpost;
	}

	public static <T> T postJsonData(Object obj, String url, Class<T> c) {

		String data = JSON.toJSONString(obj);
		HttpParams mHttpParams = new BasicHttpParams();
		// 设置网络链接超时
		// 即:Set the timeout in milliseconds until a connection is established.
		HttpConnectionParams.setConnectionTimeout(mHttpParams, 20 * 1000);
		// 设置socket响应超时
		// 即:in milliseconds which is the timeout for waiting for data.
		HttpConnectionParams.setSoTimeout(mHttpParams, 20 * 1000);
		// 设置socket缓存大小
		HttpConnectionParams.setSocketBufferSize(mHttpParams, 8 * 1024);
		// 设置是否可以重定向
		HttpClientParams.setRedirecting(mHttpParams, true);

		HttpClient httpclient = new DefaultHttpClient(mHttpParams);

		HttpPost httppost = new HttpPost(url);
		httppost.setHeader("Content-type", "application/json; charset=UTF-8");
		try {
			StringEntity myEntity = new StringEntity(data, "UTF-8");
			httppost.setEntity(myEntity);
			HttpResponse response = httpclient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				String responedata = EntityUtils.toString(response.getEntity());
				log.info(responedata);
				return JSON.parseObject(responedata, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("HttpUtil", e);
			throw new SystemException(e);
		}
		return null;
	}
	
	
	private enum RequestMethod {
		GET, POST
	}

	public static class SSLCert {

		private SSLCert(String path, String password, String trustPath, String trustPassword) {
			this.path = path;
			this.password = password;
			this.trustPath = trustPath;
			this.trustPassword = trustPassword;
		}

		/** KeyStore路径 */
		private String path;
		/** KeyStore密码 */
		private String password;
		/** 信任KeyStore路径 */
		private String trustPath;
		/** 信任KeyStore密码 */
		private String trustPassword;

		private String getPath() {
			return path;
		}

		private String getPassword() {
			return password;
		}

		private String getTrustPath() {
			return trustPath;
		}

		private String getTrustPassword() {
			return trustPassword;
		}

		/**
		 * 由 KeyStore获得私钥
		 * @param keyStorePath
		 * @param keyStorePassword
		 * @param alias
		 * @param aliasPassword
		 * @return
		 * @throws Exception
		 */
		private static PrivateKey getPrivateKey(String keyStorePath, String keyStorePassword, String alias, String aliasPassword)
				throws Exception {
			KeyStore ks = getKeyStore(keyStorePath, keyStorePassword);
			PrivateKey key = (PrivateKey) ks.getKey(alias, aliasPassword.toCharArray());
			return key;
		}

		/**
		 * 由 Certificate获得公钥
		 * @param certificatePath
		 * @return
		 * @throws Exception
		 */
		private static PublicKey getPublicKey(String certificatePath) throws Exception {
			Certificate certificate = getCertificate(certificatePath);
			PublicKey key = certificate.getPublicKey();
			return key;
		}

		/**
		 * 获得Certificate
		 * @param certificatePath
		 * @return
		 * @throws Exception
		 */
		private static Certificate getCertificate(String certificatePath) throws Exception {
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			FileInputStream in = new FileInputStream(certificatePath);

			Certificate certificate = certificateFactory.generateCertificate(in);
			in.close();
			return certificate;
		}

		/**
		 * 获得Certificate
		 * @param keyStorePath
		 * @param keyStorePassword
		 * @param alias
		 * @return
		 * @throws Exception
		 */
		private static Certificate getCertificate(String keyStorePath, String keyStorePassword, String alias) throws Exception {
			KeyStore ks = getKeyStore(keyStorePath, keyStorePassword);
			Certificate certificate = ks.getCertificate(alias);
			return certificate;
		}

		/**
		 * 获得KeyStore
		 * @param keyStorePath
		 * @param password
		 * @return
		 * @throws Exception
		 */
		private static KeyStore getKeyStore(String keyStorePath, String password) throws Exception {
			FileInputStream is = new FileInputStream(keyStorePath);
			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(is, password.toCharArray());
			is.close();
			return ks;
		}

		/**
		 * 私钥加密
		 * @param data
		 * @param keyStorePath
		 * @param keyStorePassword
		 * @param alias
		 * @param aliasPassword
		 * @return
		 * @throws Exception
		 */
		public static byte[] encryptByPrivateKey(byte[] data, String keyStorePath, String keyStorePassword, String alias,
				String aliasPassword) throws Exception {
			// 取得私钥
			PrivateKey privateKey = getPrivateKey(keyStorePath, keyStorePassword, alias, aliasPassword);
			// 对数据加密
			Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		}

		/**
		 * 私钥解密
		 * @param data
		 * @param keyStorePath
		 * @param alias
		 * @param keyStorePassword
		 * @param aliasPassword
		 * @return
		 * @throws Exception
		 */
		public static byte[] decryptByPrivateKey(byte[] data, String keyStorePath, String alias, String keyStorePassword,
				String aliasPassword) throws Exception {
			// 取得私钥
			PrivateKey privateKey = getPrivateKey(keyStorePath, keyStorePassword, alias, aliasPassword);
			// 对数据加密
			Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		}

		/**
		 * 公钥加密
		 * @param data
		 * @param certificatePath
		 * @return
		 * @throws Exception
		 */
		public static byte[] encryptByPublicKey(byte[] data, String certificatePath) throws Exception {
			// 取得公钥
			PublicKey publicKey = getPublicKey(certificatePath);
			// 对数据加密
			Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return cipher.doFinal(data);
		}

		/**
		 * 公钥解密
		 * @param data
		 * @param certificatePath
		 * @return
		 * @throws Exception
		 */
		public static byte[] decryptByPublicKey(byte[] data, String certificatePath) throws Exception {
			// 取得公钥
			PublicKey publicKey = getPublicKey(certificatePath);
			// 对数据加密
			Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			return cipher.doFinal(data);
		}

		/**
		 * 验证Certificate
		 * @param certificatePath
		 * @return
		 */
		public static boolean verifyCertificate(String certificatePath) {
			return verifyCertificate(new Date(), certificatePath);
		}

		/**
		 * 验证Certificate是否过期或无效
		 * @param date
		 * @param certificatePath
		 * @return
		 */
		public static boolean verifyCertificate(Date date, String certificatePath) {
			boolean status = true;
			try {
				// 取得证书
				Certificate certificate = getCertificate(certificatePath);
				// 验证证书是否过期或无效
				status = verifyCertificate(date, certificate);
			} catch (Exception e) {
				status = false;
			}
			return status;
		}

		/**
		 * 验证证书是否过期或无效
		 * @param date
		 * @param certificate
		 * @return
		 */
		private static boolean verifyCertificate(Date date, Certificate certificate) {
			boolean status = true;
			try {
				X509Certificate x509Certificate = (X509Certificate) certificate;
				x509Certificate.checkValidity(date);
			} catch (Exception e) {
				status = false;
			}
			return status;
		}

		/**
		 * 签名
		 * @param keyStorePath
		 * @param alias
		 * @param keyStorePassword
		 * @param aliasPassword
		 * @return
		 * @throws Exception
		 */
		public static byte[] sign(byte[] sign, String keyStorePath, String alias, String keyStorePassword, String aliasPassword)
				throws Exception {
			// 获得证书
			X509Certificate x509Certificate = (X509Certificate) getCertificate(keyStorePath, keyStorePassword, alias);
			// 取得私钥
			PrivateKey privateKey = getPrivateKey(keyStorePath, keyStorePassword, alias, aliasPassword);
			// 构建签名
			Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
			signature.initSign(privateKey);
			signature.update(sign);
			return signature.sign();
		}

		/**
		 * 验证签名
		 * @param data
		 * @param sign
		 * @param certificatePath
		 * @return
		 * @throws Exception
		 */
		public static boolean verify(byte[] data, byte[] sign, String certificatePath) throws Exception {
			// 获得证书
			X509Certificate x509Certificate = (X509Certificate) getCertificate(certificatePath);
			// 获得公钥
			PublicKey publicKey = x509Certificate.getPublicKey();
			// 构建签名
			Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
			signature.initVerify(publicKey);
			signature.update(data);
			return signature.verify(sign);
		}

		/**
		 * 验证Certificate
		 * @param keyStorePath
		 * @param keyStorePassword
		 * @param alias
		 * @return
		 */
		public static boolean verifyCertificate(Date date, String keyStorePath, String keyStorePassword, String alias) {
			boolean status = true;
			try {
				Certificate certificate = getCertificate(keyStorePath, keyStorePassword, alias);
				status = verifyCertificate(date, certificate);
			} catch (Exception e) {
				status = false;
			}
			return status;
		}

		/**
		 * 验证Certificate
		 * @param keyStorePath
		 * @param keyStorePassword
		 * @param alias
		 * @return
		 */
		public static boolean verifyCertificate(String keyStorePath, String keyStorePassword, String alias) {
			return verifyCertificate(new Date(), keyStorePath, keyStorePassword, alias);
		}
	}

	public static String doGet(String url, String param) throws Exception {
		return doGet(url, param, new Encoding().javaname[3], null);
	}

	public static String doGet(String url, Map<String, Object> param) throws Exception {
		return doGet(url, param, new Encoding().javaname[3], null);
	}

	public static String doGet(String url, Object param) throws Exception {
		return doGet(url, param, new Encoding().javaname[3], null);
	}

	public static String doGet(String url, String param, String encoding, Map<String, String> properties) throws Exception {
		if (param != null) {
			url = url + "?" + param;
		}
		HttpURLConnection conn = createConnection(url, RequestMethod.GET, param, null, properties);
		return connect(conn, encoding);
	}

	public static String doGet(String url, Map<String, Object> param, String encoding, Map<String, String> properties) throws Exception {
		return doGet(url, paramMapToString(param, encoding), encoding, properties);
	}

	public static String doGet(String url, Object param, String encoding, Map<String, String> properties) throws Exception {
		return doGet(url, BeanUtil.beanToMap(param, BeanMapStyle.TOGETHER), encoding, properties);
	}

	public static String doPost(String url, String param) throws Exception {
		return doPost(url, param,new Encoding().javaname[3], null);
	}

	public static String doPost(String url, Map<String, Object> param) throws Exception {
		return doPost(url, param, new Encoding().javaname[3], null);
	}

	public static String doPost(String url, Object param) throws Exception {
		return doPost(url, param, new Encoding().javaname[3], null);
	}

	public static String doPost(String url, String param, String encoding, Map<String, String> properties) throws Exception {
		HttpURLConnection conn = createConnection(url, RequestMethod.POST, param, null, properties);
		return connect(conn, encoding);
	}

	public static String doPost(String url, Map<String, Object> param, String encoding, Map<String, String> properties) throws Exception {
		return doPost(url, paramMapToString(param, encoding), encoding, properties);
	}

	public static String doPost(String url, Object param, String encoding, Map<String, String> properties) throws Exception {
		return doPost(url, BeanUtil.beanToMap(param, BeanMapStyle.TOGETHER), encoding, properties);
	}

	public static String doGetSSL(String url, String param, String certPath, String certPassword) throws Exception {
		return doGetSSL(url, param, certPath, certPassword, certPath, certPassword, new Encoding().javaname[3], null);
	}

	public static String doGetSSL(String url, Map<String, Object> param, String certPath, String certPassword) throws Exception {
		return doGetSSL(url, param, certPath, certPassword, certPath, certPassword, new Encoding().javaname[3], null);
	}

	public static String doGetSSL(String url, Object param, String certPath, String certPassword) throws Exception {
		return doGetSSL(url, param, certPath, certPassword, certPath, certPassword, new Encoding().javaname[3], null);
	}

	public static String doGetSSL(String url, String param, String certPath, String certPassword, String certTrustPath,
			String certTrustPassword, String encoding, Map<String, String> properties) throws Exception {
		if (certPath == null || certPath.equals("") || certPassword == null || certPath.equals("")) {
			throw new RuntimeException("certPath and certPassword is not allow Null or Blank");
		}
		if (param != null) {
			url = url + "?" + param;
		}
		if (certTrustPath == null) {
			certTrustPath = certPath;
		}
		if (certTrustPassword == null) {
			certTrustPassword = certPassword;
		}
		HttpURLConnection conn = createConnection(url, RequestMethod.GET, param, new SSLCert(certPath, certPassword, certTrustPath,
				certTrustPassword), properties);
		return connect(conn, encoding);
	}

	public static String doGetSSL(String url, Map<String, Object> param, String certPath, String certPassword, String certTrustPath,
			String certTrustPassword, String encoding, Map<String, String> properties) throws Exception {
		return doGetSSL(url, paramMapToString(param, encoding), certPath, certPassword, certTrustPath, certTrustPassword, encoding,
				properties);
	}

	public static String doGetSSL(String url, Object param, String certPath, String certPassword, String certTrustPath,
			String certTrustPassword, String encoding, Map<String, String> properties) throws Exception {
		return doGetSSL(url, BeanUtil.beanToMap(param, BeanMapStyle.TOGETHER), certPath, certPassword, certTrustPath, certTrustPassword,
				encoding, properties);
	}

	public static String doPostSSL(String url, String param, String certPath, String certPassword) throws Exception {
		return doPostSSL(url, param, certPath, certPassword, certPath, certPassword, new Encoding().javaname[3], null);
	}

	public static String doPostSSL(String url, Map<String, Object> param, String certPath, String certPassword) throws Exception {
		return doPostSSL(url, param, certPath, certPassword, certPath, certPassword, new Encoding().javaname[3], null);
	}

	public static String doPostSSL(String url, Object param, String certPath, String certPassword) throws Exception {
		return doPostSSL(url, param, certPath, certPassword, certPath, certPassword, new Encoding().javaname[3], null);
	}

	public static String doPostSSL(String url, String param, String certPath, String certPassword, String certTrustPath,
			String certTrustPassword, String encoding, Map<String, String> properties) throws Exception {
		if (certPath == null || certPath.equals("") || certPassword == null || certPath.equals("")) {
			throw new RuntimeException("certPath and certPassword is not allow Null or Blank");
		}
		HttpURLConnection conn = createConnection(url, RequestMethod.POST, param, new SSLCert(certPath, certPassword, certTrustPath,
				certTrustPassword), properties);
		return connect(conn, encoding);
	}

	public static String doPostSSL(String url, Map<String, Object> param, String certPath, String certPassword, String certTrustPath,
			String certTrustPassword, String encoding, Map<String, String> properties) throws Exception {
		return doPostSSL(url, paramMapToString(param, encoding), certPath, certPassword, certTrustPath, certTrustPassword, encoding,
				properties);
	}

	public static String doPostSSL(String url, Object param, String certPath, String certPassword, String certTrustPath,
			String certTrustPassword, String encoding, Map<String, String> properties) throws Exception {
		return doPostSSL(url, BeanUtil.beanToMap(param, BeanMapStyle.TOGETHER), certPath, certPassword, certTrustPath, certTrustPassword,
				encoding, properties);
	}

	public static void download(String url, String serverPath, String fileName) throws Exception {
		FileOutputStream fs = null;
		InputStream in = null;
		try {
			HttpURLConnection conn = createConnection(url, RequestMethod.GET, null, null, null);
			int state = conn.getResponseCode();
			if (state == 200) {
				in = conn.getInputStream();
				File targetFile = new File(serverPath);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				fs = new FileOutputStream(targetFile.getPath() + File.separator + fileName);
				byte[] buffer = new byte[1024 * 1024];
				int bytesum = 0;
				int byteread = 0;
				while ((byteread = in.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
					fs.flush();
				}
			} else {
				throw new IOException("Download fail. The response code is " + state + " and the url is " + url);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (fs != null) {
				fs.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}

	public static String readRequest(HttpServletRequest request, String encoding) throws Exception {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			// TODO: 文件上传、POST无参格式
			in = new BufferedReader(new InputStreamReader(request.getInputStream(), encoding));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return result.toString();
	}

	public static Map<String, Object> getParameterMap(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<?, ?> properties = request.getParameterMap();
		Iterator<?> entries = properties.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>) entries.next();
			String key = entry.getKey().toString();
			String[] values = (String[]) entry.getValue();
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = values[i] + ",";
			}
			valueStr = valueStr.substring(0, valueStr.length() - 1);
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			returnMap.put(key, valueStr);
		}
		return returnMap;
	}

	public static void writeResponse(String value, HttpServletResponse response, String encoding) throws Exception {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), encoding));
			writer.write(value);
		} catch (Exception e) {
			throw e;
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static String paramMapToString(Map<String, Object> param, String encoding) {
		StringBuffer paramStr = new StringBuffer();
		if (param != null && !param.isEmpty()) {
			for (Map.Entry<String, Object> entry : param.entrySet()) {
				try {
					paramStr.append(entry.getKey()).append("=");
					Object value = entry.getValue();
					if (value != null) {
						paramStr.append(URLEncoder.encode(value.toString(), encoding));
					} else {
						paramStr.append("");
					}
					paramStr.append("&");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			paramStr.deleteCharAt(paramStr.length() - 1);
		}
		return paramStr.toString();
	}

	public static Map<String, Object> paramStringToMap(String param, String encoding) {
		return paramStringToMap(param, encoding, true);
	}

	private static Map<String, Object> paramStringToMap(String param, String encoding, boolean isDecode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (param != null && !param.isEmpty() && param.indexOf("=") != -1) {
			String[] params = param.split("&");
			for (String paramStr : params) {
				int index = paramStr.indexOf("=");
				String key = paramStr.substring(0, index);
				try {
					String value = paramStr.substring(index + 1, paramStr.length());
					if (isDecode) {
						value = URLDecoder.decode(value, encoding);
					}
					paramMap.put(key, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return paramMap;
	}

	private static HttpURLConnection createConnection(String url, RequestMethod method, String param, SSLCert cert,
			Map<String, String> properties) throws Exception {
		HttpURLConnection conn = null;
		OutputStream out = null;

		if (url == null) {
			throw new NullPointerException("url is null.");
		}
		try {
			URL realUrl = new URL(url);
			conn = (HttpURLConnection) realUrl.openConnection();
			conn.setRequestMethod(method.toString());

			if (cert != null) {
				String password = cert.getPassword();
				String trustPassword = cert.getTrustPassword();

				// 初始化密钥KeyStore库
				KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
				KeyStore keyStore = SSLCert.getKeyStore(cert.getPath(), password);
				keyManagerFactory.init(keyStore, password.toCharArray());
				KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

				// 初始化信任KeyStore库
				TrustManager[] trustManagers;
				if (cert.getTrustPath() != null && trustPassword != null) {
					TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
					KeyStore trustkeyStore = SSLCert.getKeyStore(cert.getTrustPath(), trustPassword);
					trustManagerFactory.init(trustkeyStore);
					trustManagers = trustManagerFactory.getTrustManagers();
				} else {
					trustManagers = trustAllCerts();
				}

				// 初始化SSL上下文
				SSLContext sslContext = SSLContext.getInstance("SSL");
				sslContext.init(keyManagers, trustManagers, null);
				SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
				((HttpsURLConnection) conn).setSSLSocketFactory(sslSocketFactory);
			} else if (conn instanceof HttpsURLConnection) {
				// 如果没有证书的https请求，则绕过证书验证
				HttpsURLConnection httpsConn = ((HttpsURLConnection) conn);
				httpsConn.setHostnameVerifier(new HostnameVerifier() {

					@Override
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				});
				
				TrustManager[] trustManagers = trustAllCerts();
				// TODO: 优化
				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, trustManagers, null);
				SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
				httpsConn.setSSLSocketFactory(sslSocketFactory);
			}

			if (properties != null) {
				Set<Entry<String, String>> entrySet = properties.entrySet();
				for (Entry<String, String> entry : entrySet) {
					conn.addRequestProperty(entry.getKey(), entry.getValue());
				}
			}

			if (method == RequestMethod.POST) {
				conn.setDoOutput(true);
				if (param != null) {
					out = conn.getOutputStream();
					out.write(param.getBytes());
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return conn;
	}

	private static String connect(HttpURLConnection conn, String encoding) throws IOException {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return result.toString();
	}
	
	private static TrustManager[] trustAllCerts () {
		TrustManager[] trustManagers = new TrustManager[1];
		TrustManager myTrustManager = new X509TrustManager() {

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[0];
			}

			@Override
			public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
					throws CertificateException {
			}

			@Override
			public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
					throws CertificateException {
			}
		};
		trustManagers[0] = myTrustManager;
		return trustManagers;
	}
}
