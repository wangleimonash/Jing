package com.welleplus.dao;

import java.util.List;

import com.welleplus.entity.WorkSetting;

public interface WorkSettingDao {
	int addWorkSetting(WorkSetting info) throws Exception;
	int updateWorkSetting(WorkSetting info) throws Exception;
	long getWorkSettingCount() throws Exception;
	List<WorkSetting> getWorkSetting() throws Exception;

}
