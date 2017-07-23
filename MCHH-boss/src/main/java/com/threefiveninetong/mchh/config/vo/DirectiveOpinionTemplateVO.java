/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DirectiveOpinionTemplateVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: DirectiveOpinionTemplatevo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
public class DirectiveOpinionTemplateVO {

	/** 主键ID **/ 
	private String id;
	
    /** 0：婚姻保健
            1：孕产保健
            2：高危妊娠保健
            3：儿童保健
            4：高危儿保健
             **/ 
	private String modularType;
	
    /** 模块类型为0时：
            0：女性婚前检查
            1：男性婚前检查
            
            模块类型为1时：
            0：妊娠06-13+6周
            1：妊娠14-19+6周
            2：妊娠20-23+6周
            3：妊娠24-27+6周
            
            模块类型为2时：
            0： 高血压
            1： 贫血
            2：糖尿病 **/ 
	private String tgd;

    /** 
     * 可用标识
     * 0：不可用
        1：可用
      **/ 
	
    /** 内容 **/ 
	private String content;
	
    /** 模块类型为1时使用 **/ 
	private String startWeek;
	
    /** 模块类型为1时使用 **/ 
	private String endWeek;
	
	/** 可用标识，0：不可以，1：可用 **/
	private String useSign;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
	
	

	/**
	 * 构造 
	 */
	public DirectiveOpinionTemplateVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModularType() {
		return modularType;
	}

	public void setModularType(String modularType) {
		this.modularType = modularType;
	}
	public String getTgd() {
		return tgd;
	}

	public void setTgd(String tgd) {
		this.tgd = tgd;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(String startWeek) {
		this.startWeek = startWeek;
	}
	public String getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(String endWeek) {
		this.endWeek = endWeek;
	}
	
	public String getUseSign() {
		return useSign;
	}

	public void setUseSign(String useSign) {
		this.useSign = useSign;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}