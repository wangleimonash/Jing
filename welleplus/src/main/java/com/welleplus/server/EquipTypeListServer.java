package com.welleplus.server;

import java.util.Map;

import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;

public interface EquipTypeListServer {

	Result getListBy0(Map<String, Object> param);
	Result getNpeBy0(Map<String, Object> param);
	Result getListBy1(Map<String, Object> param);
	Result getNpeBy1(Map<String, Object> param);
	Result getListBy2(Map<String, Object> param);
	Result getNpeBy2(Map<String, Object> param);
	Result getListBy3(Map<String, Object> param);
	Result getNpeBy3(Map<String, Object> param);
	Result getListBy4(Map<String, Object> param);
	Result getNpeBy4(Map<String, Object> param);
	Result getListBytree(Map<String, Object> param);
}
