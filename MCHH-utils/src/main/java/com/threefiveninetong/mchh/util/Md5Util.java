package com.threefiveninetong.mchh.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	public static String signiture(Map<String,String> params,String key){
		List<Map.Entry<String, String>> mappingList = new ArrayList<Map.Entry<String, String>>(params.entrySet());
		Collections.sort(mappingList, new Comparator<Map.Entry<String, String>>() {  
            public int compare(Map.Entry<String, String> o1,  
                    Map.Entry<String, String> o2) {  
                return o1.getKey().toString().compareToIgnoreCase(o2.getKey().toString());  
            }  
        }); 
		StringBuffer sb=new StringBuffer();
		for(Map.Entry<String,String>mapping:mappingList){
			System.out.println(mapping.getKey()+":"+mapping.getValue());
			sb.append(mapping.getKey().toLowerCase()+"="+mapping.getValue()+"&");
		}
		String data=sb.toString().substring(0, sb.toString().length()-1)+key;
		return DigestUtils.md5Hex(data);
	}
}
