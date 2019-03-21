package com.accp.vo.cm;

import com.accp.pojo.Refund;

public class RefVo extends Refund{
	private String username;

	public RefVo() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
