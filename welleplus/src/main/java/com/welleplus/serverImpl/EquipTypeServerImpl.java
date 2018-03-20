package com.welleplus.serverImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.EquipTypeDao;
import com.welleplus.result.Result;
import com.welleplus.server.EquipTypeServer;
import com.welleplus.util.EquipType;

@Service
public class EquipTypeServerImpl implements EquipTypeServer {

	@Resource
    private EquipTypeDao euipTypeDao;
	
	@Override
	public Result getCountBy0(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = EquipType.getList(euipTypeDao.getCountBy0(param));
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}
	
	@Override
	public Result getCountBy1(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = EquipType.getList(euipTypeDao.getCountBy1(param));
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}
	
	@Override
	public Result getCountBy2(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = EquipType.getList(euipTypeDao.getCountBy2(param));
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}
	
	@Override
	public Result getCountBy3(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = EquipType.getList(euipTypeDao.getCountBy3(param));
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}
	
	@Override
	public Result getCountBy4(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = EquipType.getList(euipTypeDao.getCountBy4(param));
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public Result getCountBytree(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = EquipType.getList(euipTypeDao.getCountBytree(param));
            result.setData(infos);
            result.setState(true);
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
