package com.welleplus.serverImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.EquipTypeListDao;
import com.welleplus.result.Result;
import com.welleplus.server.EquipTypeListServer;
import com.welleplus.util.EquipType;

@Service
public class EquipTypeListServerImpl implements EquipTypeListServer {

	@Resource
    private EquipTypeListDao euipTypeListDao;
	
	@Override
	public Result getListBy0(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipTypeListDao.getListBy0(param);
            Long count = euipTypeListDao.getCountBy0(param);
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
            List<Map<String, Object>> infos = euipTypeListDao.getListBy1(param);
            Long count = euipTypeListDao.getCountBy1(param);
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
            List<Map<String, Object>> infos = euipTypeListDao.getListBy2(param);
            Long count = euipTypeListDao.getCountBy2(param);
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
            List<Map<String, Object>> infos = euipTypeListDao.getListBy3(param);
            Long count = euipTypeListDao.getCountBy3(param);
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
            List<Map<String, Object>> infos = euipTypeListDao.getListBy4(param);
            Long count = euipTypeListDao.getCountBy4(param);
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
            List<Map<String, Object>> infos = euipTypeListDao.getListBytree(param);
            Long count = euipTypeListDao.getCountBytree(param);
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
	public Result getNpeBy0(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipTypeListDao.getNpeBy0(param);
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
	public Result getNpeBy1(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipTypeListDao.getNpeBy1(param);
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
	public Result getNpeBy2(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipTypeListDao.getNpeBy2(param);
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
	public Result getNpeBy3(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipTypeListDao.getNpeBy3(param);
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
	public Result getNpeBy4(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = euipTypeListDao.getNpeBy4(param);
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
