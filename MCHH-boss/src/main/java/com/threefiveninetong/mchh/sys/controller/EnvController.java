package com.threefiveninetong.mchh.sys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.threefiveninetong.mchh.sys.common.CodeDict;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.service.OperatorService;

@Controller("commonEnvController")
@RequestMapping("/s/common/env")
public class EnvController {

	private final static String UI_PREFIX = "ui.";

	private final static String ERROR_PREFIX = "error.";

	private final static Log logger = LogFactory.getLog(EnvController.class);

	@Resource
	private CodeDict codeDict = null;

	@Resource
	private OperatorService operatorService = null;

	private static Map<String, Map<String, String>> codes = null;


	/**
	 * 系统环境
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/env.js")
	public void env(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/javascript");
		PrintWriter out = response.getWriter();
		// TODO 缓存
		out.println("jcl.env.contextPath='" + request.getContextPath() + "';");
		// 2011-5-10 加入 profile 功能
		// 数据存放在session中
		HttpSession session = request.getSession();
		Object profileObject = session
				.getAttribute(Constant.SESSION_KEY_PROFILE);
		Map<String, String> profile = new HashMap<String, String>();
		if (profileObject != null && profileObject instanceof Map) {
			profile = (Map<String, String>) profileObject;
		}
		printProfile(out, profile);
		out.flush();
	}

	/**
	 * 将国际化字符发送到前端
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/message.js")
	public void message(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (codeDict != null) {
			codes = codeDict.getAllCodes();
			codes.put("operator", getAllOperator());
		}
		PrintWriter out = response.getWriter();
		printCode(out, codes);
		out.flush();
	}


	/**
	 * 查询操作员信息
	 * 
	 * @return
	 */
	private Map<String, String> getAllOperator() {
		List<OperatorPO> pos = operatorService.findAll();
		Map<String, String> map = new HashMap<String, String>();
		for (OperatorPO po : pos) {
			map.put(po.getId(), po.getLoginName());
		}
		return map;
	}

	private String keyValuePair(String key, String value) {
		// TODO 对字符进行转义
		return "    '" + key + "': '" + value + "'";
	}

	private String keyValuePair(String key, Map<String, String> map) {
		// TODO 对字符进行转义
		StringBuffer sb = new StringBuffer();
		for (String k : map.keySet()) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append("'").append(k).append("': '").append(map.get(k))
					.append("'");
		}
		return "    '" + key + "': {" + sb.toString() + "}";
	}

	private void printMessage(PrintWriter out, Properties messages,
			Locale locale) {
		// TODO 缓存
		out.println("$.extend(jcl.message, {");
		out.print("    'lang': '" + locale + "'");
		for (Object key : messages.keySet()) {
			// 过滤只有视图端的消息映射到
			String key0 = (String) key;
			if (key0.startsWith(UI_PREFIX) || key0.startsWith(ERROR_PREFIX)) {
				out.println(",");
				out.print(keyValuePair(key0, messages.getProperty(key0)));
			}
		}
		out.println();
		out.println("});");
	}

	/**
	 * 映射代码表到前端js
	 * 
	 * @param out
	 */
	private void printCode(PrintWriter out,
			Map<String, Map<String, String>> codes) {
		out.println("$.extend(boss.code, {");
		boolean begin = true;
		for (String key : codes.keySet()) {
			if (!begin) {
				out.println(",");
			}
			out.print(keyValuePair(key, codes.get(key)));
			begin = false;
		}
		out.println();
		out.println("});");
	}

	/**
	 * 输出前台信息
	 * 
	 * @Title: printChannel
	 * @Description: TODO
	 * @param: @param out
	 * @param: @param city
	 * @return: void
	 * @throws
	 */
	private void printCity(PrintWriter out, List<Continents> continents) {
		// 洲信息
		out.println("$.extend(boss.continents,{'continents':[");
		boolean begin0 = true;
		for (Continents p : continents){
			if (!begin0) {
				out.println(",");
			}
			out.print("    {'" +p.getContinentsCode()+"':'"+p.getContinentsName()
					+ "',");
			// 国家集合
			out.print("'country':[");
			boolean begin1 = true;
			if(p.getCountry()!=null){
				for (Country c : p.getCountry()) {
					if (!begin1) {
						out.println(",");
					}
					out.println();
					out.print("{'"+c.getCountryCode()+"':'"+c.getCountryName() + "',");
					// 城市集合
					out.print("'city': [");
					boolean begin2 = true;
					if(c.getCity()!=null){
						for (City d : c.getCity()) {
							if (!begin2) {
								out.print(",");
							}
							out.println();
							out.print("{'" + d.getCityCode()+"':'"+d.getCityName() + "'}");
							begin2 = false;
						}
					}
					begin1 = false;
					out.print("]}");
				}
			}
			out.println();
			out.print("]}");
			begin0 = false;
		}
		out.println();
		out.println("]});");
	}

	
	
	/**
	 * 渠道版本映射到前端
	 * 
	 * @param out
	 */
	private void printVersion(PrintWriter out, List<Channel> channel) {
		out.println("$.extend(boss.channel, {'channel':[");
		boolean begin0 = true;
		for (Channel c : channel) {
			if (!begin0) {
				out.println(",");
			}
			out.print("{'" +c.getChannelCode()+"':'"+c.getChannelName()+"',");
			out.print("'version': [");
			boolean begin1 = true;
				if(c.getVersion()!=null){
					for (Version v : c.getVersion()) {
						out.println();
						if (!begin1) {
							out.println(",");
						}
						out.print("{'"+v.getVersionCode()+"':'"+v.getVersionName()+"'}");
						begin1 = false;
					}	
				}
			out.println();
			out.print("]}");
			begin0 = false;
		}
		out.println();
		out.println("]});");
	}
	
	
	private void printProfile(PrintWriter out, Map<String, String> profile) {
		out.println("boss.env.profile={");
		boolean begin = true;
		for (String key : profile.keySet()) {
			if (!begin) {
				out.println(",");
			}
			out.print(keyValuePair(key, profile.get(key)));
			begin = false;
		}
		out.println("};");
	}

	public static Map<String, Map<String, String>> getCodes() {
		return codes;
	}

}


/**
 * 洲信息
 * 
 * @ClassName: Continents
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016年3月14日 上午11:40:42
 */
final class Continents {
	private String continentsCode;

	private String continentsName;

	private List<Country> country;

	public String getContinentsCode() {
		return continentsCode;
	}

	public void setContinentsCode(String continentsCode) {
		this.continentsCode = continentsCode;
	}

	public String getContinentsName() {
		return continentsName;
	}

	public void setContinentsName(String continentsName) {
		this.continentsName = continentsName;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}
	
	

}

/**
 * 国家信息
 * 
 * @author 周照
 * 
 * @ClassName: Channel
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016年3月14日 上午11:40:42
 */
final class Country {
	private String countryCode;
	private String countryName;
	private List<City> city;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city) {
		this.city = city;
	}
}

/**
 * 城市信息
 * 
 * @author 周照
 *
 */
final class City {
	private String cityCode;
	private String cityName;
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}

/**
 * 渠道信息
 * @author Administrator
 *
 */
final class Channel{
	//渠道号
	private String channelCode;
	//渠道名称
	private String ChannelName;
	private List<Version> version;
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getChannelName() {
		return ChannelName;
	}
	public void setChannelName(String channelName) {
		ChannelName = channelName;
	}
	public List<Version> getVersion() {
		return version;
	}
	public void setVersion(List<Version> version) {
		this.version = version;
	}
	
}
/**
 * 版本信息
 * @author Administrator
 *
 */
final class Version{
	//版本号
	private String versionCode;
	//版本名称
	private String versionName;
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	
}

