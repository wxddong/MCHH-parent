package com.threefiveninetong.mchh.appMember;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.threefiveninetong.mchh.appMember.vo.resp.MemberLoginRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberRegisterRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberSearchBasicInfoRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberSearchExpertGuidanceRespVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.APISignUtils;
import com.threefiveninetong.mchh.util.HttpUtil;
import com.threefiveninetong.mchh.util.StringUtil;

public class AppMemberControllerTest {
	
	/**
	 * 会员注册
	 */
	@Test
	public void memberRegisterTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/memberRegister";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("userName", "zhanght");
        params.put("password", "123456");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        MemberRegisterRespVo vo = HttpUtil.postFormDataJson(url, params, MemberRegisterRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 会员登录
	 */
	@Test
	public void memberLoginTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/memberLogin";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("userName", "zhanght");
        params.put("password", "123456");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        MemberLoginRespVo vo = HttpUtil.postFormDataJson(url, params, MemberLoginRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 会员修改密码
	 */
	@Test
	public void resetPasswordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/resetPassword";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("userName", "zhanght");
        params.put("oldPwd", "123456");
        params.put("newPwd", "111111");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 意见反馈
	 */
	@Test
	public void feedbackTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/feedback";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("content", "张海涛测试");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 会员添加心情语录
	 */
	@Test
	public void addMoodRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addMoodRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("content", "今晚打老虎");
        params.put("type", "0");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 会员查询心情语录信息
	 */
	@Test
	public void getMoodRecordListTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/getMoodRecordList";
		Map<String,Object> packetReq = new HashMap<String,Object>();
		packetReq.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
		packetReq.put("page", "1");
		packetReq.put("rows", "10");
		packetReq.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
		packetReq.put("type", "0");
		packetReq.put("sign", APISignUtils.getSign(packetReq, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
		String resStr = "";
        try {
        	resStr = HttpUtil.doPost(url, packetReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改心情语录信息
	 */
	@Test
	public void updateMoodRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/updateMoodRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("moodId", "8E6F194A19FC4FCE8A39D53FC4E12B86");
        params.put("content", "今晚吃饭");
        params.put("type", "0");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 删除心情语录信息
	 */
	@Test
	public void deleteMoodRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/deleteMoodRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("moodId", "8E6F194A19FC4FCE8A39D53FC4E12B86");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询会员接受的通知接口
	 */
	@Test
	public void searchMbrMessageListTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchMbrMessageList";
		Map<String,Object> packetReq = new HashMap<String,Object>();
		packetReq.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
		packetReq.put("page", "1");
		packetReq.put("rows", "10");
		packetReq.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
		packetReq.put("type", "0");
		packetReq.put("sign", APISignUtils.getSign(packetReq, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
		String resStr = "";
        try {
        	resStr = HttpUtil.doPost(url, packetReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询专家指导信息
	 */
	@Test
	public void searchExpertGuidanceTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchExpertGuidance";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("classification", "3");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        MemberSearchExpertGuidanceRespVo vo = HttpUtil.postFormDataJson(url, params, MemberSearchExpertGuidanceRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询会员基本信息
	 */
	@Test
	public void searchMemberBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchMemberBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        MemberSearchBasicInfoRespVo vo = HttpUtil.postFormDataJson(url, params, MemberSearchBasicInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 修改会员基本信息
	 */
	@Test
	public void updatMmemberBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/updatMmemberBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("nickName", "你张哥");
        params.put("sex", "0");
        params.put("bloodType", "1");
        params.put("birthday", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("signature", "测试");
       // params.put("image", "1123213213");
        params.put("type", "4");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
}
