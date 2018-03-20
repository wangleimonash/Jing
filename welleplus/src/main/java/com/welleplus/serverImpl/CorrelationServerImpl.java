package com.welleplus.serverImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.CorrelationDao;
import com.welleplus.entity.Correlation;
import com.welleplus.result.Result;
import com.welleplus.server.CorrelationServer;

@Service
public class CorrelationServerImpl implements CorrelationServer{
	@Resource
	private CorrelationDao cDao;

	public Result addCorrelationInfo(Correlation info) throws Exception {
		// TODO Auto-generated method stub
		Result result = new Result();
		int i = cDao.addCorrelationInfo(info);
		result.setId(info.getId());
		result.setState(true);
		result.setMessage("添加成功");
		return result;
	}

	@Override
	public Result getCorrelationInfo(Correlation info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		List<Correlation> infos = cDao.getCorrelationInfo(info);
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	/**
	 * 通过用户id获取关联信息
	 * @param correlation
	 * @return
	 * @throws Exception
	 */
	@Override
	public Result getCorrelation(Correlation correlation) throws Exception {
		Result result = new Result();
		List<Correlation> infos = cDao.getCorrelation(correlation);
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result deleteCorrelationInfo(Long grade, Long gradeid) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Correlation info = new Correlation();
		info.setGrade(grade);
		info.setGradeid(gradeid);
		try {
			cDao.deleteCorrelationInfo(info);
			result.setState(true);
			result.setMessage("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("删除失败");
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public Result deleteCorrelationInfoFromUid(Long uid) throws Exception {
		// TODO Auto-generated method stub
		Result result = new Result();
		cDao.deleteCorrelationInfoFromUid(uid);
		result.setState(true);
		result.setMessage("删除成功");
		return result;
	}

}
