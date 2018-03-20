package com.welleplus.serverImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.EquipLocationDao;
import com.welleplus.result.Result;
import com.welleplus.server.EquipLocationServer;
import com.welleplus.util.EquipType;

@Service
public class EquipLocationServerImpl implements EquipLocationServer {

	@Resource
    private EquipLocationDao euipLocationDao;
	
	@Override
	public Result getListBy0(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipLocationDao.getListBy0(param);
            Long count = euipLocationDao.getCountBy0(param);
            List<Map<String, Object>> info = EquipType.getLists(infos);
            result.setData(info);
            result.setState(true);
            result.setMessage("查询成功");
            result.setCount(count);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public Result getListBy1(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipLocationDao.getListBy1(param);
            Long count = euipLocationDao.getCountBy1(param);
            List<Map<String, Object>> info = EquipType.getLists(infos);
            result.setData(info);
            result.setState(true);
            result.setMessage("查询成功");
            result.setCount(count);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public Result getListBy2(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipLocationDao.getListBy2(param);
            Long count = euipLocationDao.getCountBy2(param);
            List<Map<String, Object>> info = EquipType.getLists(infos);
            result.setData(info);
            result.setState(true);
            result.setMessage("查询成功");
            result.setCount(count);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public Result getListBy3(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipLocationDao.getListBy3(param);
            Long count = euipLocationDao.getCountBy3(param);
            List<Map<String, Object>> info = EquipType.getLists(infos);
            result.setData(info);
            result.setState(true);
            result.setMessage("查询成功");
            result.setCount(count);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public Result getListBy4(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipLocationDao.getListBy4(param);
            Long count = euipLocationDao.getCountBy4(param);
            List<Map<String, Object>> info = EquipType.getLists(infos);
            result.setData(info);
            result.setState(true);
            result.setMessage("查询成功");
            result.setCount(count);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public Result getListBytree(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipLocationDao.getListBytree(param);
            Long count = euipLocationDao.getCountBytree(param);
            List<Map<String, Object>>info = EquipType.getLists(infos);
            result.setData(info);
            result.setState(true);
            result.setMessage("查询成功");
            result.setCount(count);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public Result getWorkPosition(String imei,String startDate,String endDate) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("imei", imei);
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			List<Map<String,Object>> infos = euipLocationDao.getWorkPosition(map);
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
