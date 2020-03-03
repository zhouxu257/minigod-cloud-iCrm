/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNUserBase;

public class ReqTrdAccount extends SNUserBase {

	private static final long serialVersionUID = 5314645956455617563L;

	private String trdAccount;
	private String pwd;
	private String key;
	public String getTrdAccount() {
		return trdAccount;
	}

	public void setTrdAccount(String trdAccount) {
		this.trdAccount = trdAccount;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
