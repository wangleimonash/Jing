package com.welleplus.serverImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.FenceDao;
import com.welleplus.entity.Fence;
import com.welleplus.result.Result;
import com.welleplus.server.FenceServer;

@Service
public class FenceServerImpl implements FenceServer{
	@Resource
	private FenceDao fenceDao;

	@Override
	public Result addFenceInfo(Fence info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		if(info.getName()==null||info.getName().isEmpty()
				||info.getState()==null||info.getState().isEmpty()
				||info.getCreatDate()==null
				||info.getWarningType()==null||info.getWarningType().isEmpty()
				||info.getPid()==null||info.getPid()==0){
			result.setState(false);
			result.setMessage("参数不能为空");
			return result;
		}
		try {
			fenceDao.addFenceInfo(info);
			result.setId(info.getId());
			result.setState(true);
			result.setMessage("添加成功");
			result.setData(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("添加失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result getFenceInfoFromPid(Long pid) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			Fence info = fenceDao.getFenceInfoFromPid(pid);
			result.setState(true);
			result.setData(info);
			result.setMessage("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setData(null);
			result.setMessage("查询失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result updateFenceInfoFromPid(Fence info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		if(info.getName()==null||info.getName().isEmpty()
				||info.getState()==null||info.getState().isEmpty()
				||info.getWarningType()==null||info.getWarningType().isEmpty()
				||info.getPid()==null||info.getPid()==0){
			result.setState(false);
			result.setMessage("参数不能为空");
			return result;
		}
		try {
			fenceDao.updateFenceInfoFromPid(info);
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
	public Result deleteFenceInfo(Long pid) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			fenceDao.deleteFenceInfo(pid);
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
	public Result getFenceInfoFromFirmId(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			List<Fence> infos = fenceDao.getFenceInfoFromFirmId(id);
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
	public Result getFenceInfoFromCompanyId(Long id, Long uid) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Map<String,Long> map = new HashMap<String,Long>();
		map.put("id", id);
		map.put("uid", uid);
		try {
			List<Fence> infos = fenceDao.getFenceInfoFromCompanyId(map);
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
	public Result getFenceInfoFromSectionId(Long id, Long uid) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Map<String,Long> map = new HashMap<String,Long>();
		map.put("id", id);
		map.put("uid", uid);
		try {
			List<Fence> infos = fenceDao.getFenceInfoFromSectionId(map);
			result.setState(true);
			result.setData(infos);
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
	public Result getCountUserInFence(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Long count;
		try {
			count = fenceDao.getCountUserInFence(id);
			if(count==null){
				count = 0L;
			}
			result.setId(count);
			result.setState(true);
			result.setMessage("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setId(0L);
			result.setState(false);
			result.setMessage("查询失败");
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 获取所有的电子围栏
	 */
	@Override
	public Result getFenceInfos() {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			List<Fence> infos = fenceDao.getFenceInfos();
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
	public List<Map<String, String>> getFenceWorkInfos(String imei,String startDate,String endDate) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("imei", imei);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<Map<String, String>> infos = new ArrayList<Map<String,String>>();
		try {
			infos = fenceDao.getFenceWorkInfos(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public List<Map<String, String>> getFenceWorkInfosLaterWork(String imei,String startDate,String endDate) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("imei", imei);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<Map<String,String>> infos = new ArrayList<Map<String,String>>();
		try {
			infos = fenceDao.getFenceWorkInfosLaterWork(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return infos;
	}

	@Override
	public List<Map<String, String>> getFenceWorkInfosBeforWork(String imei,String startDate,String endDate) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("imei", imei);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<Map<String,String>> infos = new ArrayList<Map<String,String>>();
		try {
			infos = fenceDao.getFenceWorkInfosBeforWork(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return infos;
	}

	@Override
	public Map<String, String> getWorkDateById(Long id) {
		// TODO Auto-generated method stub
		Map<String,String> infos = new HashMap<String,String>();
		try {
			infos = fenceDao.getWorkDateById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			infos = null;
		}
		return infos;
	}

	@Override
	public Map<String, String> getOrgan(Long id) {
		// TODO Auto-generated method stub
		Map<String,String> infos = new HashMap<String,String>();
		try {
			infos = fenceDao.getOrgan(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public Map<String, String> getWorkDateByPid(Long id) {
		// TODO Auto-generated method stub
		Map<String,String> infos = new HashMap<String,String>();
		try {
			infos = fenceDao.getWorkDateByPid(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public Map<String, Long> getWorkPie() {
		// TODO Auto-generated method stub
		Map<String,Long> map = new HashMap<String,Long>();
		try {
			map = fenceDao.getWorkPie();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<String> getFenceName() {
		// TODO Auto-generated method stub
		List<String> infos = new ArrayList<String>();
		try {
			infos = fenceDao.getFenceName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

}
