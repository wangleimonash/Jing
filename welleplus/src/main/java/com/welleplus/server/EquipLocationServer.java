package com.welleplus.server;

import java.util.Map;

import com.welleplus.result.Result;

public interface EquipLocationServer {

	Result getListBy0(Map<String, Object> param);
	Result getListBy1(Map<String, Object> param);
	Result getListBy2(Map<String, Object> param);
	Result getListBy3(Map<String, Object> param);
	Result getListBy4(Map<String, Object> param);
	Result getListBytree(Map<String, Object> param);
	
	Result getWorkPosition(String imei,String startDate,String endDate);
}
