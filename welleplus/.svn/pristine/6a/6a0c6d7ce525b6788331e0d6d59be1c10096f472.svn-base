package com.welleplus.serverImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.ProjectDao;
import com.welleplus.entity.Project;
import com.welleplus.result.Result;
import com.welleplus.server.ProjectServer;

@Service
public class ProjectServerImpl implements ProjectServer{
	@Resource
	private ProjectDao projectDao;

	public Result addProjectInfo(Project info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			int id = projectDao.addProjectInfo(info);
			result.setId(info.getId());
			result.setState(true);
			result.setMessage("添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("添加失败");
			e.printStackTrace();
		}
		return result;
	}

	public Result getProjectInfo(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			List<Project> infos = projectDao.getProjectInfo(id);
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
	public Result getProjectInfoForId(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Project info = projectDao.getProjectInfoForId(id);
		result.setData(info);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getProjectInfoAsMap(Long id, Long sid) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("sid", sid);
		Project info = projectDao.getProjectInfoAsMap(map);
		result.setData(info);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result updateProjectName(Long id, String name) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Project info = new Project();
		info.setId(id);
		info.setName(name);
		try {
			projectDao.updateProjectName(info);
			result.setState(true);
			result.setMessage("修改成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("修改失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result deleteProjectInfo(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			projectDao.deleteProjectInfo(id);
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
