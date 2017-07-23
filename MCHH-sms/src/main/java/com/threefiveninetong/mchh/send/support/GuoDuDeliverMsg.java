//package com.threefiveninetong.mchh.send.support;
//
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URLDecoder;
//import java.util.Date;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.threefiveninetong.mchh.po.SmsDownstatePO;
//import com.threefiveninetong.mchh.po.SmsReceivedPO;
//import com.threefiveninetong.mchh.service.SmsDownstateService;
//import com.threefiveninetong.mchh.service.SmsReceivedService;
//import com.threefiveninetong.mchh.core.util.ApplicationContextUtil;
//import com.threefiveninetong.mchh.core.util.DateUtil;
//import com.threefiveninetong.mchh.core.util.PropertyUtil;
//
//
//public class GuoDuDeliverMsg extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -7140975418880509076L;
//	
//	Logger log=LoggerFactory.getLogger(GuoDuDeliverMsg.class);
//
//	public GuoDuDeliverMsg() {
//		super();
//	}
//
//	
//	public void destroy() {
//		super.destroy(); // Just puts "destroy" string in log
//		// Put your code here
//	}
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//				doPost(request,response);
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		// http://192.168.3.16:8686/stsf/deliverMessage?SmsType=123&SrcMobile=18210057468&AppendID=88&Content=我爱你&Status=0
//		// SmsType 短信类型 0:上行短信; 1－提交网关状态报告（企信通平台提交到运营商网关的状态报告）
//		// 2－手机接收状态报告
//		// SrcMobile 发送手机号 以13等开头的11位号码
//		// （SmsType=0时有效）
//		// AppendID 附加号码 附加号码（SmsType=0时有效）
//		// Content 消息内容 最长62个字符,当SmsType=1,2时，该字段的值为提交序号等
//		// RecvTime 消息收到时间 YYYYMMDDHHMMSS格式
//		// SendTime 消息发送时间 YYYYMMDDHHMMSS格式
//		// 对联通手机，值为消息提交时间
//		// （SmsType=1,2时有效）
//		// Status 消息状态 0为发送成功，其它值为错误码
//		// （SmsType=1,2时有效）
//
//		// 当短信类型（SmsType=0）为上行短信时，SrcMobile、AppendID、Content、RecvTime有效
//		// 当短信类型（SmsType=1,2）为回复报告时，Content、RecvTime、SendTime、Status有效
//		// String SmsType =request.getParameter("SmsType");
//		// String SrcMobile=request.getParameter("SrcMobile");
//		// String AppendID =request.getParameter("AppendID");
//		// String Content =request.getParameter("Content");
//		// String RecvTime =request.getParameter("RecvTime");
//		// String SendTime =request.getParameter("SendTime");
//		// String Status =request.getParameter("Status");
//		InputStream input = request.getInputStream();
//		StringBuffer sb = new StringBuffer();
//		int len = 0;
//		byte[] buf = new byte[1024];
//		if (input != null) {
//			while ((len = input.read(buf)) != -1) {
//				sb.append(new String(buf, 0, len));
//			}
//			input.close();
//			if (!"".equals(sb.toString())
//					&& sb.toString().indexOf("args") != -1) {
//				String result = URLDecoder.decode(sb.toString(), "GBK");
//				log.info("国都下行返回结果："+result);
//				
//				result = result.replace("args=", "");
//				String[] fenli = result.split(";");
//				if (fenli != null && fenli.length > 0) {
//					for (int i = 0; i < fenli.length; i++) {
//						String[] contents = fenli[i].split(",");
//						if (contents != null && contents.length != 5) {
//							return;
//						}
//						String SmsType = contents[0];
//						String SrcMobile = contents[1];
//						String AppendID = contents[2];
//						String Content = contents[3];
//						String RecvTime = contents[4];
//
//						// args=2,18298992857,0,20121204151304474571,20121204151303;
//						// 20121128221715928058
//						if ("2".equals(SmsType)) {
//							GuoduSecondReportService service =ApplicationContextUtil
//							.getBean("guoduSecondReportService");
//							service.updateSmsTypeAndSendSecond(AppendID,
//									Content);
//							SmsDownstatePO masDeliver = new SmsDownstatePO();
//							masDeliver.setMasdownmsgid(Content);
//							masDeliver.setPalteformcode(PropertyUtil
//									.getProperty().getString("GUODUMARK"));// ("GuoDuDelever");
//							masDeliver.setDownstate(AppendID);
//							masDeliver.setIsresend("0");
//							masDeliver.setReceivetime(new Date());
//							masDeliver.setPhone(SrcMobile);
//							try {
//								SmsDownstateService mas = ApplicationContextUtil
//										.getBean("smsDownstateServiceImpl");
//								mas.create(masDeliver);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						} else if ("0".equals(SmsType)) {
//							SmsReceivedPO message = new SmsReceivedPO();
//							message.setSender(SrcMobile);
//							message.setContent(URLDecoder
//									.decode(Content, "GBK"));
//							try {
//								message.setCreatetime(DateUtil
//										.string2Date(RecvTime));
//								message.setIsdealed("0");// 未处理状态
//
//								if (!StringUtils.isEmpty(message.getContent())) {
//									SmsReceivedService receive = ApplicationContextUtil
//											.getBean("smsReceivedServiceImpl");
//									receive.create(message);
//								} else {
//									message.setContent("短信发送者回复的信息为空：系统自动添加内容");
//									SmsReceivedService receive = ApplicationContextUtil
//											.getBean("smsReceivedServiceImpl");
//									receive.create(message);
//								}
//							} catch (Exception e) {
//								log.error("请求失败参数"+e.getMessage());
//								e.printStackTrace();
//							}
//						}
//					}
//				}
//			}
//		}
//
//	}
//	/**
//	 * Initialization of the servlet. <br>
//	 * @throws ServletException if an error occurs
//	 */
//	public void init() throws ServletException {
//		// Put your code here
//	}
//
//}
