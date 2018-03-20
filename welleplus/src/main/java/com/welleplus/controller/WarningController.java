package com.welleplus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.Fence;
import com.welleplus.entity.FenceQuery;
import com.welleplus.entity.Warning;
import com.welleplus.result.Result;
import com.welleplus.server.WarningServer;

@Controller
@RequestMapping("warning")
public class WarningController {
	@Resource
	private WarningServer wServer;
	
	@RequestMapping("getinfo.do")
	@ResponseBody
	/**
	 * 查询报警信息
	 * @return
	 */
	public Result getWarningInfo(@RequestBody Fence info){
		Result result = new Result();
		List<Warning> infos = new ArrayList<Warning>();
		List<Long> ids = info.getIds();
		if(ids!=null&&ids.size()!=0){
			for (Long id : ids) {
				result = wServer.getWarningInfo(id);
				if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
					List<Warning> wInfos = (ArrayList<Warning>)result.getData();
					for (Warning warning : wInfos) {
						infos.add(warning);
						if(infos.size()>2){
							result.setData(infos);
							return result;
						}
					}
				}
			}
			result.setData(infos);
		}else{
			result.setData(null);
		}
		
		return result;
	}
	
	/**
	 * 根据围栏id查询报警信息
	 * @param info
	 * @return
	 */
	@RequestMapping("getwarningbyfenceid")
	@ResponseBody
	public Result getWarningByFenceId(@RequestBody FenceQuery info){
		Result result = new Result();
		result = wServer.getWarningInfoFromQuery(info);
		return result;
	}
	
	@RequestMapping("getinfoforinfo.do")
	@ResponseBody
	public Result getWarningInfoForInfo(@RequestBody Warning info){
		Result result = new Result();
		String role = info.getUser().getRole();
		if("0".equals(role)){
			result = wServer.getWarningInfos(info);
		}else if("1".equals(role)){
			result = wServer.getWarningInfoAsRole1(info);
		}else if("2".equals(role)){
			result = wServer.getWarningInfoAsRole2(info);
		}else if("3".equals(role)){
			result = wServer.getWarningInfoAsRole3(info);
		}else if("4".equals(role)){
			result = wServer.getWarningInfoAsRole4(info);
		}else{
			
		}
		return result;
	}

}
