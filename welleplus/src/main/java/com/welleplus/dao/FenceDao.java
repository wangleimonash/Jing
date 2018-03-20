package com.welleplus.dao;


import java.util.List;
import java.util.Map;

import com.welleplus.entity.Fence;

public interface FenceDao {
	int addFenceInfo(Fence info) throws Exception;
	Fence getFenceInfoFromPid(Long pid) throws Exception;
	int updateFenceInfoFromPid(Fence info) throws Exception;
	int deleteFenceInfo(Long pid) throws Exception;
	List<Fence> getFenceInfoFromFirmId(Long id) throws Exception;
	List<Fence> getFenceInfoFromCompanyId(Map<String,Long> map) throws Exception;
	List<Fence> getFenceInfoFromSectionId(Map<String,Long> map) throws Exception;
	Long getCountUserInFence(Long id) throws Exception;
	
	List<Fence> getFenceInfos() throws Exception;
	
	List<Map<String,String>> getFenceWorkInfos(Map<String,Object> map) throws Exception;
	
//	出勤统计
	List<Map<String,String>> getFenceWorkInfosLaterWork(Map<String,Object> map) throws Exception;
	List<Map<String,String>> getFenceWorkInfosBeforWork(Map<String,Object> map) throws Exception;
	
	Map<String,String> getWorkDateById(Long id) throws Exception;
	Map<String,String> getWorkDateByPid(Long id) throws Exception;
	
	Map<String,String> getOrgan(Long id) throws Exception;
	
//	获取考勤统计
	Map<String,Long> getWorkPie() throws Exception;
	
	List<String> getFenceName() throws Exception;

}
