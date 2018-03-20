package com.welleplus.server;

import java.util.List;
import java.util.Map;

import com.welleplus.entity.Fence;
import com.welleplus.result.Result;

public interface FenceServer {
	Result addFenceInfo(Fence info);
	Result getFenceInfoFromPid(Long pid);
	Result updateFenceInfoFromPid(Fence info);
	Result deleteFenceInfo(Long pid);
	Result getFenceInfoFromFirmId(Long id);
	Result getFenceInfoFromCompanyId(Long id,Long uid);
	Result getFenceInfoFromSectionId(Long id,Long uid);
	Result getCountUserInFence(Long id);
	
	Result getFenceInfos();
	
	List<Map<String,String>> getFenceWorkInfos(String imei,String startDate,String endDate);
	
	List<Map<String,String>> getFenceWorkInfosLaterWork(String imei,String startDate,String endDate);
	List<Map<String,String>> getFenceWorkInfosBeforWork(String imei,String startDate,String endDate);
	
	Map<String,String> getWorkDateById(Long id);
	Map<String,String> getWorkDateByPid(Long id);
	
	Map<String,String> getOrgan(Long id);
	
	Map<String,Long> getWorkPie();
	
	List<String> getFenceName();

}
