package com.welleplus.serverImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.CompanyDao;
import com.welleplus.entity.Company;
import com.welleplus.result.Result;
import com.welleplus.server.CompanyServer;

@Service
public class CompanyServerImpl implements CompanyServer{
	@Resource
	private CompanyDao companyDao;

	public Result addCompanyInfo(Company info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		int id = companyDao.addCompanyInfo(info);
		result.setId(info.getId());
		result.setState(true);
		result.setMessage("添加成功");
		return result;
	}

	public Result getCompanyInfo(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		List<Company> infos = companyDao.getCompanyInfo(id);
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result getCompanyInfoForId(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Company info = companyDao.getCompanyInfoForId(id);
		result.setData(info);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}

	@Override
	public Result updateCompanyName(Long id, String name) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Company info = new Company();
		info.setId(id);
		info.setName(name);
		try {
			companyDao.updateCompanyName(info);
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
	public Result deleteCompanyInfo(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			companyDao.deleteCompanyInfo(id);
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
