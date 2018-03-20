package com.welleplus.dao;

import java.util.List;

import com.welleplus.entity.Correlation;
import com.welleplus.entity.UserInfo;

public interface CorrelationDao {
	int addCorrelationInfo(Correlation info) throws Exception;
	List<Correlation> getCorrelationInfo(Correlation info);

	/**
	 * 通过用户id获取关联信息
	 * @param correlation
	 * @return
	 */
	List<Correlation> getCorrelation(Correlation correlation);

	/**
	 * 通过用户id获取关联信息
	 * @param userInfo
	 * @return
	 */
	Correlation getCorrelationByUid(UserInfo userInfo);
	int deleteCorrelationInfo(Correlation info) throws Exception;
	int deleteCorrelationInfoFromUid(Long uid) throws Exception;
}
