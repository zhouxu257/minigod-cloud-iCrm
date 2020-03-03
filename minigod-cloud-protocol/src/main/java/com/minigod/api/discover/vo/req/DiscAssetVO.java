
package com.minigod.api.discover.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * <code>DiscAssetVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-04)
 *
 */
public class DiscAssetVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;
	
	private Integer cId; // 概念ID

	/**
	 * @return the cId
	 */
	public Integer getcId() {
		return cId;
	}

	/**
	 * @param cId the cId to set
	 */
	public void setcId(Integer cId) {
		this.cId = cId;
	}


}
