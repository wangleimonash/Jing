package com.welleplus.dao;

import java.util.List;
import java.util.Map;

import com.welleplus.entity.Firm;
import com.welleplus.entity.FirmInfo;
import com.welleplus.entity.UserInfo;

public interface FirmDao {
	FirmInfo getFirmInfo(Long id);
	List<FirmInfo> getFirmInfos();
	int updateFirmName(FirmInfo info) throws Exception;
	int deleteFirmInfo(Long id) throws Exception;

	/**
	 * 获取组织信息
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getOrg(UserInfo userInfo) throws Exception;
}
