package com.accp.vo.xzc;

import com.accp.pojo.Appraisalapply;

public class appVo extends Appraisalapply {
	private String username;
	private Integer merchantType;
	
	public Integer getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(Integer merchantType) {
		this.merchantType = merchantType;
	}

	public appVo() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
