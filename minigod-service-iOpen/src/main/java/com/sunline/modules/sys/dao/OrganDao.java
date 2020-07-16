package com.sunline.modules.sys.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.sys.entity.OrganEntity;
import com.sunline.modules.sys.entity.UserWindowDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 组织表
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-07-14 13:42:42
 */
@Mapper
public interface OrganDao extends BaseDao<OrganEntity> {
    /**
     * 根据实体条件查询
     * @return
     */
    List<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto);
}
