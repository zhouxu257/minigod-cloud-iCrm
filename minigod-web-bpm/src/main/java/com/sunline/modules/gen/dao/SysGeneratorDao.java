package com.sunline.modules.gen.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 类SysGeneratorDao的功能描述:
 *  代码生成器
 * @auther hxy
 * @date 2017-08-25 16:19:43
 */
@Mapper
public interface SysGeneratorDao {
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(String tableName);
	
	List<Map<String, String>> queryColumns(String tableName);
}
