/**
 * @Title: ViewpointSelectionReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-5 下午1:58:11
 * @version v1.0
 */

public class MyMediaListReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private MyMediaListVO params;

	public MyMediaListVO getParams() {
		return params;
	}

	public void setParams(MyMediaListVO params) {
		this.params = params;
	}


}
