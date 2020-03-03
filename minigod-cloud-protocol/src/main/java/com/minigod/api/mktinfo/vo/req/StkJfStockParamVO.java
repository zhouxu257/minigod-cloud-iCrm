/**
 * @Title: StkFiveBetsVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.mktinfo.vo.enums.ESortDirection;
import com.minigod.api.vo.BaseVO;

/**
 * @description 获取行业成分股
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午4:28:34
 * @version v1.0
 */
public class StkJfStockParamVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String indexId;
	private Integer count;
	private String assetId;
	private Integer sortField;
	private ESortDirection sortDir;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Integer getSortField() {
		return sortField;
	}

	public void setSortField(Integer sortField) {
		this.sortField = sortField;
	}

	public ESortDirection getSortDir() {
		return sortDir;
	}

	public void setSortDir(ESortDirection sortDir) {
		this.sortDir = sortDir;
	}

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
