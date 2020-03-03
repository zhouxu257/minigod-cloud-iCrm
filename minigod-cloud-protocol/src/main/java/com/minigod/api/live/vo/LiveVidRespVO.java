/**
 * @Title: IMFetchGroupListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.live.vo;

import com.minigod.api.live.vo.LiveVidVO;
import com.minigod.common.anno.TransferBean;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author huhu
 * @date 2015-8-21 下午3:53:10
 * @version v1.0
 */
@TransferBean
public class LiveVidRespVO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	private List<LiveVidVO> liveVidVOList;

	public List<LiveVidVO> getLiveVidVOList() {
		return liveVidVOList;
	}

	public void setLiveVidVOList(List<LiveVidVO> liveVidVOList) {
		this.liveVidVOList = liveVidVOList;
	}
}
