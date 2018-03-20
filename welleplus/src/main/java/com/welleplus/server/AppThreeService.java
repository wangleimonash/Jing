package com.welleplus.server;

import java.util.Map;

import com.welleplus.result.Result;

public interface AppThreeService {

	// 工种 权限0下拉框
	public Result getrootdataone();
	// 工种 权限1下拉框
	public Result getrootdataone1(Map<String, Object> map);
	// 工种 权限2下拉框
	public Result getSectordataone2(Map<String, Object> map);
	// 工种 权限3下拉框
	public Result getProjectdataone3(Map<String, Object> map);
	// 工种 权限4下拉框
	public Result getProjectdataone4(Map<String, Object> map);
	
	public Result getCompanydata(Map<String, Object> map);

	public Result getCompanydataone(Map<String, Object> map);

	public Result getSectordataone(Map<String, Object> map);

	public Result getProjectdataone(Map<String, Object> map);

	// 表单 权限0
	public Result getrootsurfacedata();

	// 标段
	public Result getsectiondata();
//工程部
	public Result getRootEtengineering();
//施工队
	public Result getRootConstruction();
//班组
	public Result getRootTteam();
//	点击出查询
	public Result getListBytree(Map<String, Object> map);
	
	
	

	

}
