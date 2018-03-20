package com.welleplus.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.welleplus.entity.App_Code;



public interface AppThreeServiceDao {

	List<String> getrootdataone();

	List<App_Code> getrootsurfacedata();

	List<String> getsectiondata();

	List<String> getrootetengineering();

	List<String> getrootconstruction();

	List<String> getroottteam();

	List<String> getrootdataone1(Map<String, Object> map);

	List<String> getrootdataone2(Map<String, Object> map);

	List<String> getrootdataone3(Map<String, Object> map);

	List<String> getrootdataone4(Map<String, Object> map);

	List<Map<String, Object>> getListBytree(Map<String, Object> param);

	Long getCountBytree(Map<String, Object> param);
	
	
}
