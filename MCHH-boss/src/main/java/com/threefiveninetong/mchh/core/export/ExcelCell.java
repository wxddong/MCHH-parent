/**
 * 
 */
package com.threefiveninetong.mchh.core.export;

/**
 * @author xuyh
 * @date 2013-12-28下午04:46:04
 * @description
 */
public class ExcelCell {
	private String title;
	private String field;
	private String render;
	private String format;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getRender() {
		return render;
	}
	public void setRender(String render) {
		this.render = render;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
}
