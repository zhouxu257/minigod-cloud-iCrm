package com.sunline.modules.sys.service;


import com.sunline.modules.common.page.Page;
import com.sunline.modules.sys.entity.OrganEntity;
import com.sunline.modules.sys.entity.UserWindowDto;

import java.util.List;
import java.util.Map;

/**
 * 组织表
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-07-14 13:42:42
 */
public interface OrganService {
	
	OrganEntity queryObject(String id);
	
	List<OrganEntity> queryList(Map<String, Object> map);

	List<OrganEntity> queryListByBean(OrganEntity organEntity);
	
	int queryTotal(Map<String, Object> map);
	
	String save(OrganEntity organ);

	int update(OrganEntity organ);

	int delete(String id);

	int deleteBatch(String[] ids);

	/**
	 * 根据code查询可能的组织
	 * @param code
	 * @return
	 */
	List<OrganEntity> queryListByCode(String code);

	/**
	 * 更新机构状态
	 * @param ids
	 * @param type
	 * @return
	 */
	void updateIsdel(String ids, String type);

	/**
	 * 分页查询组织审批选择范围
	 * @return
	 */
	Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum);

}
