package com.accp.vo.cm;

import com.accp.pojo.Post;

public class PostVoCm extends Post {
	private String username;

	public PostVoCm() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
