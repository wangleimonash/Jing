package com.welleplus.serverImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.FirmDao;
import com.welleplus.entity.FirmInfo;
import com.welleplus.result.Result;
import com.welleplus.server.FirmServer;

@Service
public class FirmServerImpl implements FirmServer{
	@Resource
	private FirmDao firmDao;

	public Result getFirmInfo(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		FirmInfo info = firmDao.getFirmInfo(id);
		result.setData(info);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getFirmInfos() {
		// TODO Auto-generated method stub
		Result result = new Result();
		List<FirmInfo> infos = firmDao.getFirmInfos();
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result updateFirmName(Long id, String name) {
		// TODO Auto-generated method stub
		Result result = new Result();
		FirmInfo info = new FirmInfo();
		info.setId(id);
		info.setName(name);
		try {
			firmDao.updateFirmName(info);
			result.setState(true);
			result.setMessage("更新成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("更新失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result deleteFirmInfo(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			firmDao.deleteFirmInfo(id);
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

}
