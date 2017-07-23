package com.threefiveninetong.mchh.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @ClassName: ValidateSignUtils
 * @Description: TODO
 * @author: dingjh
 * @date: 2016年1月9日 上午10:25:37
 */
public class APISignUtils {

	/**
     * @Title: validateSign 验证签名 @Description: TODO @param: @param mapParam
     *         请求参数集合，其中包涵sign参数 @param: @param key @param: @return @return:
     *         boolean @throws
     */
    public static boolean validateSign(Map mapParam, String sign,String key) {

        return sign.equals(getSign(mapParam, key));
    }

    // 参数排序，拼接sign
    public static String getSign(Map mapParam, String key) {
        Set keySet = mapParam.keySet();

        String[] paramNames = new String[keySet.size()];
        int index = 0;
        for (Object keyName : keySet) {
            paramNames[index] = StringUtil.valueOf(keyName);
            index++;
        }

        Arrays.sort(paramNames);// 参数名排序
        String sign = "";
        for (int i = 0; i < paramNames.length; i++) {
            if (!paramNames[i].equals("sign")) {// 非签名参数
                sign += mapParam.get(paramNames[i]);
            }
        }
        try {
        	// return MD5_ThirtyTwo.getMD5Message(sign + key).toUpperCase();
			return CryptUtil.MD5.encrypt(sign + key, Encoding.UTF_8).toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public static String getPaySign(Map<String,Object> mapParam,String key) {
    	Set keySet = mapParam.keySet();
        String[] paramNames = new String[keySet.size()];
        int index = 0;
        for (Object keyName : keySet) {
            paramNames[index] = StringUtil.valueOf(keyName);
            index++;
        }

        Arrays.sort(paramNames);// 参数名排序
        String sign = "";
        for (int i = 0; i < paramNames.length; i++) {
        	sign += mapParam.get(paramNames[i]);
        	if (i != paramNames.length-1) {
        		sign += "#";
        	}
        }
        String res = null;
        try {
        	res = CryptUtil.MD5.encrypt(sign +"#"+ key, Encoding.UTF_8).toUpperCase();
        	if (!StringUtil.isNullOrBlank(res)) {
        		res = sign + "#" + res;
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return res;
    }
}
