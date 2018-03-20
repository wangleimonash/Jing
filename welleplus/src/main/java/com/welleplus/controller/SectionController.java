package com.welleplus.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.Section;
import com.welleplus.result.Result;
import com.welleplus.server.SectionServer;

@Controller
@RequestMapping("section")
public class SectionController {
	@Resource
	private SectionServer sectonServer;
	
	//添加部门
	@RequestMapping("addinfo.do")
	@ResponseBody
	public Result addSectionInfo(@RequestBody Section info){
		Result result = new Result();
		info.setCreatDate(new Timestamp(System.currentTimeMillis()));
		result = sectonServer.addSectionInfo(info);
		return result;
	}

}
