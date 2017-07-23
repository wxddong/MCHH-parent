package com.threefiveninetong.mchh.util;

import java.io.InputStream;

public class UploadFileReq {
	/** 名称 */
	private String name;
	/** 类型 */
	private String type;
	/** 大小 */
	private long size;
	/** 输入流 */
	private InputStream input;
	/** 服务器路径 */
	private String serverPath;
	/** 上传类型 ****/
	private int refType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public String getServerPath() {
		return serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	public int getRefType() {
		return refType;
	}

	public void setRefType(int refType) {
		this.refType = refType;
	}
}
