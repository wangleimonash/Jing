package com.welleplus.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EquipLocationDao {

	List<Map<String, Object>> getListBy0(@Param("param") Map<String, Object> param) throws Exception;
	long getCountBy0(@Param("param") Map<String, Object> param) throws Exception;
	List<Map<String, Object>> getListBy1(@Param("param") Map<String, Object> param) throws Exception;
	long getCountBy1(@Param("param") Map<String, Object> param) throws Exception;
	List<Map<String, Object>> getListBy2(@Param("param") Map<String, Object> param) throws Exception;
	long getCountBy2(@Param("param") Map<String, Object> param) throws Exception;
	List<Map<String, Object>> getListBy3(@Param("param") Map<String, Object> param) throws Exception;
	long getCountBy3(@Param("param") Map<String, Object> param) throws Exception;
	List<Map<String, Object>> getListBy4(@Param("param") Map<String, Object> param) throws Exception;
	long getCountBy4(@Param("param") Map<String, Object> param) throws Exception;
	List<Map<String, Object>> getListBytree(@Param("param") Map<String, Object> param) throws Exception;
	long getCountBytree(@Param("param") Map<String, Object> param) throws Exception;
	
	List<Map<String,Object>> getWorkPosition(Map<String,Object> map) throws Exception;
}
