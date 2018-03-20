package com.welleplus.serverImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.SectionDao;
import com.welleplus.entity.Section;
import com.welleplus.result.Result;
import com.welleplus.server.SectionServer;

@Service
public class SectionServerImpl implements SectionServer{
	@Resource
	private SectionDao sectionDao;

	public Result addSectionInfo(Section info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			int id = sectionDao.addSectionInfo(info);
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

	public Result getSectionInfo(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		List<Section> infos;
		try {
			infos = sectionDao.getSectionInfo(id);
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
	public Result getSectionInfoForId(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Section info = sectionDao.getSectionInfoForId(id);
		result.setData(info);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getSectionAsMap(Long id, Long cid) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("cid", cid);
		Section info = sectionDao.getSectionAsMap(map);
		result.setData(info);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result updateSectionName(Long id, String name) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Section info = new Section();
		info.setId(id);
		info.setName(name);
		try {
			sectionDao.updateSectionName(info);
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
	public Result deleteSectionInfo(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			sectionDao.deleteSectionInfo(id);
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
