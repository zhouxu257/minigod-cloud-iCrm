/**
 * @Title: MarketIndexReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author 谢尚河
 * @date 2015-8-27 下午9:20:33
 * @version v1.0
 */

public class MarketIndexReqVO extends SNVersion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MarketIndexVO params;
	
	public MarketIndexVO getParams() {
		return params;
	}
	public void setParams(MarketIndexVO params) {
		this.params = params;
	}
}
