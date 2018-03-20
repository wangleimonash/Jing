package com.welleplus.serverImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.WorkSettingDao;
import com.welleplus.entity.WorkSetting;
import com.welleplus.result.Result;
import com.welleplus.server.WorkSettingServer;

@Service
public class WorkSettingServerImpl implements WorkSettingServer{
	
	@Resource
	private WorkSettingDao dao;

	@Override
	public Result addWorkSetting(WorkSetting info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			dao.addWorkSetting(info);
			result.setState(true);
			result.setMessage("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("保存失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result updateWorkSetting(WorkSetting info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			dao.updateWorkSetting(info);
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
	public Result getWorkSetting() {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			List<WorkSetting> infos = dao.getWorkSetting();
			result.setState(true);
			result.setData(infos);
			result.setCount((long)infos.size());
			result.setMessage("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("查询失败");
			e.printStackTrace();
		}
		return result;
	}

}
