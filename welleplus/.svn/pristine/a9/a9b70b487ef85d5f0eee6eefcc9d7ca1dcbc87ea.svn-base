package com.welleplus.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.Company;
import com.welleplus.result.Result;
import com.welleplus.server.CompanyServer;

@Controller
@RequestMapping("company")
public class CompanyController {
	@Resource
	private CompanyServer companyServer;
	
	//添加公司
	@RequestMapping("addinfo.do")
	@ResponseBody
	public Result addCompanyInfo(@RequestBody Company info){
		Result result = new Result();
		info.setCreatDate(new Timestamp(System.currentTimeMillis()));
		result = companyServer.addCompanyInfo(info);
		return result;
	}
	
	@RequestMapping("getinfos.do")
	@ResponseBody
	public Result getCompanyInfos(){
		long id = 1;
		Result result = new Result();
		result = companyServer.getCompanyInfo(id);
		return result;
	}

}
