package com.welleplus.serverImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.RfidDao;
import com.welleplus.dao.UserDao;
import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.RfidServer;

@Service
public class RfidServerImpl implements RfidServer {

	@Resource
    private RfidDao rfidDao;
	
	@Override
	public Result getInfos(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = rfidDao.getInfos(param);
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
	public Result getMaxInfos(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = rfidDao.getMaxInfos(param);
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
	public Result getRfidInfo(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = rfidDao.getRfidInfo(param);
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
	public Result getMaxRfidInfo(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = rfidDao.getMaxRfidInfo(param);
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
	public Result getfirm(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            long infos = rfidDao.getfirm(param);
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
	public Result getCount(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            long infos = rfidDao.getCount(param);
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
	public Result getUserRfidInfo(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
        	List<Map<String, Object>>  infos = rfidDao.getUserRfidInfo(param);
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
