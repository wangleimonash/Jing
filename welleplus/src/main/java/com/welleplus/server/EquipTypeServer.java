package com.welleplus.server;

import java.util.Map;

import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;

public interface EquipTypeServer {

	Result getCountBy0(Map<String, Object> param);
	Result getCountBy1(Map<String, Object> param);
	Result getCountBy2(Map<String, Object> param);
	Result getCountBy3(Map<String, Object> param);
	Result getCountBy4(Map<String, Object> param);
	Result getCountBytree(Map<String, Object> param);
}
