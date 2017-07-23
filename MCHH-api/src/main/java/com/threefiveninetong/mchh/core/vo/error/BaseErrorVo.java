package com.threefiveninetong.mchh.core.vo.error;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/** 
 * @ClassName: BaseErrorVo 
 * @Description: TODO 验证错误baseVo
 * @author: jixf
 * @date: 2016年1月14日 下午1:19:49  
 */
public class BaseErrorVo extends BaseVo{
	private List<ErrorVo> errors; 
	public BaseErrorVo(String errCode,String errMsg){
		super(errCode,errMsg);
	}
	public BaseErrorVo(String errCode,String errMsg,List<ErrorVo> errors){
		super(errCode,errMsg);
		this.errors = errors;
	}
	public List<ErrorVo> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorVo> errors) {
		this.errors = errors;
	}

	public class ErrorVo{
		/**
		 * @Fields key : TODO 错误的属性值
		 */
		private String key;
		/**
		 * @Fields tip : TODO 错误的属性提示
		 */
		private String tip;
		public ErrorVo(){}
		public ErrorVo(String key,String tip){
			this.key = key;
			this.tip = tip;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getTip() {
			return tip;
		}
		public void setTip(String tip) {
			this.tip = tip;
		}
	}
}