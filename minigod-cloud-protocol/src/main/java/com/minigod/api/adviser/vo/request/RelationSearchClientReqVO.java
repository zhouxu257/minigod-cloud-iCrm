/**
 * @Title: RelationDelClientReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-16 上午10:27:37
 * @version v1.0
 */
@TransferBean
public class RelationSearchClientReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@TransferID
	private RelationSearchClientVO params;

	public RelationSearchClientVO getParams() {
		return params;
	}

	public void setParams(RelationSearchClientVO params) {
		this.params = params;
	}

	@TransferBean
	public static class RelationSearchClientVO extends QNAdviserBase {

		private static final long serialVersionUID = 1L;

		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}
}
