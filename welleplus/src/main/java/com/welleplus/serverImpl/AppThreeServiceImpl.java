package com.welleplus.serverImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.AppThreeServiceDao;
import com.welleplus.entity.FirmInfo;
import com.welleplus.entity.App_Code;
import com.welleplus.result.Result;
import com.welleplus.server.AppThreeService;
import com.welleplus.util.EquipType;
@Service
public class AppThreeServiceImpl implements AppThreeService{
@Resource
private AppThreeServiceDao appThreeServiceDao;
	@Override
	public Result getrootdataone() {
		// TODO Auto-generated method stub
				Result result = new Result();
				List<String> infos = appThreeServiceDao.getrootdataone();
				infos.add(0, "工种");
				result.setData(infos);
				result.setState(true);
				result.setMessage("查询成功");
				return result;
	}

	@Override
	public Result getCompanydata(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getCompanydataone(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getSectordataone(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getProjectdataone(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
//这是表单0
	@Override
	public Result getrootsurfacedata() {
		// TODO Auto-generated method stub
		Result result = new Result();
		List<App_Code> infos = appThreeServiceDao.getrootsurfacedata();
		for (App_Code app_Code : infos) {
			
		}
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getsectiondata() {
		Result result = new Result();
		List<String> infos = appThreeServiceDao.getsectiondata();
		infos.add(0, "标段");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getRootEtengineering() {
		Result result = new Result();
		List<String> infos = appThreeServiceDao.getrootetengineering();
		infos.add(0, "工程部");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getRootConstruction() {
		Result result = new Result();
		List<String> infos = appThreeServiceDao.getrootconstruction();
		infos.add(0, "施工队");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getRootTteam() {
		Result result = new Result();
		List<String> infos = appThreeServiceDao.getroottteam();
		infos.add(0, "班组");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
//工种1 的权限 。。
	@Override
	public Result getrootdataone1(Map<String, Object> map) {
		Result result = new Result();
		List<String> infos = appThreeServiceDao.getrootdataone1(map);
		infos.add(0, "工种");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	//工种2 的权限 。。
	@Override
	public Result getSectordataone2(Map<String, Object> map) {
		Result result = new Result();
		List<String> infos = appThreeServiceDao.getrootdataone2(map);
		infos.add(0, "工种");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getProjectdataone3(Map<String, Object> map) {
		Result result = new Result();
		List<String> infos = appThreeServiceDao.getrootdataone3(map);
		infos.add(0, "工种");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getProjectdataone4(Map<String, Object> map) {
		Result result = new Result();
		List<String> infos = appThreeServiceDao.getrootdataone4(map);
		infos.add(0, "工种");
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	@Override
	public Result getListBytree(Map<String, Object> param) {
		// TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<Map<String, Object>> infos = appThreeServiceDao.getListBytree(param);
            Long count = appThreeServiceDao.getCountBytree(param);
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

}
