package com.welleplus.serverImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welleplus.dao.AppTwoOnceDao;
import com.welleplus.entity.App_Attendance;
import com.welleplus.entity.LocationData;
import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.AppThreeService;
import com.welleplus.server.AppTwoOnceService;
import com.welleplus.util.EquipType;

@Service
public class AppTwoOnceServiceImpl implements AppTwoOnceService{
   @Autowired
	private AppTwoOnceDao appTwoOnceDao;
	@Override
	public Result getRootOncedata() {
		Result result = new Result();
		List<String> infos = appTwoOnceDao.getrootdataone();
		infos.add(0, "定位设备");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
		
	}

	@Override
	public Result getCompanydataone(Map<String, Object> map) {
		return null;
	}

	@Override
	public Result getRootTwoForm(Map<String, Object> param) {
//		Result result = new Result();
//		List<App_Attendance> infos = appTwoOnceDao.getRootTwoForm();
//		System.out.println(infos);
//		result.setData(infos);
//		result.setState(true);
//		result.setMessage("查询成功");
//		return result;
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = appTwoOnceDao.getRootTwoForm(param);
            Long count = appTwoOnceDao.getCountBy0(param);
//            List<Map<String, Object>> info = EquipType.getLists(infos);
            result.setData(infos);
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
	public Result getOneType(Map<String, Object> map) {
		Result result = new Result();
        try {
        	 
            List<String> infos = appTwoOnceDao.getOneType(map);
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
        } catch (Exception e) {
             result.setState(false);
             result.setMessage("查询失败");
        }
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: getRootTwoForm1</p> 
	* <p>Description: </p> 
	* @param map
	* @return 表单数据一
	* @see com.welleplus.server.AppTwoOnceService#getRootTwoForm1(java.util.Map) 
	*/ 
	@Override
	public Result getRootTwoForm1(Map<String, Object> map) {
		Result result = new Result();
        try {
            List<String> infos = appTwoOnceDao.getRootTwoForm1(map);
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
            
        } catch (Exception e) {
             result.setState(false);
             result.setMessage("查询失败");
        }
		return result;
	}



	@Override
	public Result getAttendanceinfo(Map<String, Object> param) {
		 Result result = new Result();
	        try {
	            List<Map<String, Object>> infos = appTwoOnceDao.getAttendanceListBytree(param);
	             System.out.println(infos);
	            Long count = appTwoOnceDao.getAttendanceCountBytree(param);
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
	public Result getRootTwoForm2(Map<String, Object> param) {
	      Result result = new Result();
	        try {
	            List<Map<String, Object>> infos = appTwoOnceDao.getRootTwoForm2(param);
	            Long count = appTwoOnceDao.getCountBy2(param);
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
	public Result getRootTwoForm3(Map<String, Object> map) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = appTwoOnceDao.getRootTwoForm2(map);
            Long count = appTwoOnceDao.getCountBy3(map);
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
	public Result getRootTwoForm4(Map<String, Object> map) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = appTwoOnceDao.getRootTwoForm4(map);
            Long count = appTwoOnceDao.getCountBy4(map);
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
//表单二             1111111111111111111111
	@Override
	public Result getworkdata(Map<String, Object> map) {
		Result result = new Result();
        try {
            List<String> infos = appTwoOnceDao.getworkdata(map);
            Long count = appTwoOnceDao.getcilckeCountBy0(map);
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
            result.setCount(count);
        } catch (Exception e) {
             result.setState(false);
             result.setMessage("查询失败");
        }
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: getListBytree</p> 
	* <p>Description:点击树查询 </p> 
	* @param param
	* @return 
	* @see com.welleplus.server.AppTwoOnceService#getListBytree(java.util.Map) 
	*/ 
	@Override
	public Result getListBytree(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = appTwoOnceDao.getListBytree(param);
            System.out.println(infos.get(1)+"123");
            Long count = appTwoOnceDao.getCountBytree(param);
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

	/* (非 Javadoc) 
	* <p>Title: getListBy0</p> 
	* <p>Description:没选中树型结构的时候 </p> 
	* @param map
	* @return 
	* @see com.welleplus.server.AppTwoOnceService#getListBy0(java.util.Map) 
	*/ 
	@Override
	public Result getListBy0(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Result result = new Result();
        try {
//        	查数据
        	System.out.println("进入");
            List<Map<String, Object>> infos = appTwoOnceDao.getListBy0(map);
//            查总数
            Long count = appTwoOnceDao.getCountBy0(map);
            System.out.println(count);
//            List<Map<String, Object>> info = EquipType.getLists(infos);
            result.setData(infos);
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
	public Result getListBy1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getListBy2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getListBy3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getListBy4(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result gettwolists(Map<String, Object> map) {
		// TODO Auto-generated method stub
				Result result = new Result();
		        try {
//		        	查数据
		        	System.out.println("进入");
		            List<Map<String, Object>> infos = appTwoOnceDao.gettwolists(map);
//		            查总数
		            Long count = appTwoOnceDao.gettwoCountBy0(map);
		            System.out.println(count);
//		            List<Map<String, Object>> info = EquipType.getLists(infos);
		            result.setData(infos);
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
	

}
