package com.welleplus.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.WorkSetting;
import com.welleplus.result.Result;
import com.welleplus.server.WorkSettingServer;

@Controller
@RequestMapping("work")
public class WorkSettingController {
	@Resource
	private WorkSettingServer server;
	
	@RequestMapping("addinfo.do")
	@ResponseBody
	public Result addWorkSetting(@RequestBody WorkSetting info){
		Result result =  new Result();
		result = server.addWorkSetting(info);
		return result;
	}
	
	@RequestMapping("updateinfo.do")
	@ResponseBody
	public Result updateWorkSetting(@RequestBody WorkSetting info){
		Result result = new Result();
		result = server.updateWorkSetting(info);
		return result;
	}
	
	@RequestMapping("getinfos.do")
	@ResponseBody
	public Result getWorkSetting(){
		Result result = new Result();
		result = server.getWorkSetting();
		return result;
	}

}
