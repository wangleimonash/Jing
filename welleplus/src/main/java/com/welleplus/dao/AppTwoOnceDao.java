package com.welleplus.dao;

import java.util.List;
import java.util.Map;

import com.welleplus.entity.App_Attendance;
import com.welleplus.entity.LocationData;
import com.welleplus.entity.UserInfo;

public interface AppTwoOnceDao {

	public List<String> getrootdataone();

	public List<App_Attendance> getRootTwoForm();

	// 表单数据二权限0
	public List<Map<String, Object>> getRootTwoForm(Map<String, Object> param);

	// 页数0
	public Long getCountBy0(Map<String, Object> param);

	public List<String> getOneType(Map<String, Object> map);

	// 表单数据一
	public List<String> getRootTwoForm1(Map<String, Object> map);

	// 树加载。
	public List<Map<String, Object>> getAttendanceListBytree(
			Map<String, Object> param);

	// 树加载之页数
	public Long getAttendanceCountBytree(Map<String, Object> param);

	public List<Map<String, Object>> getListBytree(Map<String, Object> param);

	public Long getCountBytree(Map<String, Object> param);

	public List<Map<String, Object>> getRootTwoForm2(Map<String, Object> param);

	public Long getCountBy2(Map<String, Object> param);

	public Long getCountBy3(Map<String, Object> map);

	public List<Map<String, Object>> getRootTwoForm4(Map<String, Object> map);

	public Long getCountBy4(Map<String, Object> map);

	public List<String> getworkdata(Map<String, Object> phonenumber);
//点击之后的总数
	public Long getcilckeCountBy0(Map map);

	public List<Map<String, Object>> getListBy0(Map<String, Object> map);
//数据二未选中树
	public List<Map<String, Object>> gettwolists(Map<String, Object> map);
	//数据二未选中树总数
	public Long gettwoCountBy0(Map<String, Object> map);

}
