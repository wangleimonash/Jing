package com.welleplus.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.Company;
import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.AppThreeService;

@Controller
@RequestMapping("drop")
public class AppThreeController {
	@Resource
	private AppThreeService appThreeService;
	//工种  查询
		@RequestMapping("getboxone.do")
		@ResponseBody
		public Result addCompanyInfo(@RequestBody UserInfo info){
			Result result = new Result();
			Long rid = info.getRid();
			String role = info.getRole();
			Long uid = info.getId();
			if("0".equals(role)){
				result = appThreeService.getrootdataone();
			}
			if("1".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("id", rid);
				result = appThreeService.getrootdataone1(map);
			}
			if("2".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getSectordataone2(map);
				
			}else if("3".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getProjectdataone3(map);
			}else if("4".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getProjectdataone4(map);
			}
			return result;
		}
		
		
	
		
		
		
//	这是表单数据
     @RequestMapping("getsurfacedata.do")
     @ResponseBody
     public Result getsurfacedata(@RequestBody UserInfo info){
    	 Result result = new Result();
			Long rid = info.getRid();
			String role = info.getRole();
			Long uid = info.getId();
    	 if("0".equals(role)){
				result = appThreeService.getrootsurfacedata();
			}
			if("1".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("id", rid);
				result = appThreeService.getCompanydataone(map);
			}
			if("2".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getSectordataone(map);
				
			}else if("3".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getProjectdataone(map);
			}
			return result;
     }
     
     @RequestMapping("getengineering.do")
     @ResponseBody
     public Result getetengineering(@RequestBody UserInfo info){
    	 Result result = new Result();
			Long rid = info.getRid();
			String role = info.getRole();
			Long uid = info.getId();
    	 if("0".equals(role)){
				result = appThreeService.getRootEtengineering();
			}
			if("1".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("id", rid);
				result = appThreeService.getCompanydataone(map);
			}
			if("2".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getSectordataone(map);
				
			}else if("3".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getProjectdataone(map);
			}
			return result;
     }
	
     
     @RequestMapping("getconstruction.do")
     @ResponseBody
     public Result getConstruction(@RequestBody UserInfo info){
    	 Result result = new Result();
			Long rid = info.getRid();
			String role = info.getRole();
			Long uid = info.getId();
    	 if("0".equals(role)){
				result = appThreeService.getRootConstruction();
			}
			if("1".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("id", rid);
				result = appThreeService.getCompanydataone(map);
			}
			if("2".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getSectordataone(map);
				
			}else if("3".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getProjectdataone(map);
			}
			return result;
     }
     
     
     @RequestMapping("getteam.do")
     @ResponseBody
     public Result geTteam(@RequestBody UserInfo info){
    	 Result result = new Result();
			Long rid = info.getRid();
			String role = info.getRole();
			Long uid = info.getId();
    	 if("0".equals(role)){
				result = appThreeService.getRootTteam();
			}
			if("1".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("id", rid);
				result = appThreeService.getCompanydataone(map);
			}
			if("2".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getSectordataone(map);
				
			}else if("3".equals(role)){
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("rid", rid);
				map.put("role", role);
				map.put("id", uid);
				result = appThreeService.getProjectdataone(map);
			}
			return result;
     }
     /**
 	 * 点击树加载定位类型数据
 	 * @param info
 	 * @return
 	 */
//	getliststree.do
     @RequestMapping("getliststree.do")
     @ResponseBody
     public Result getliststree(@RequestBody UserInfo info){
    	 Result result = new Result();
 		Long rid = info.getRid();
 		String role = info.getRole();
 		Long uid = info.getId();
 		String start = info.getStartdate();
 		String end = info.getEnddate();
 		long descId = info.getDescId();
 		int desc = info.getDesc();
 		int page = info.getPage();
 		int worktype = info.getWorktype();
 		int equiptype = info.getEquiptype();
 		String type2 = info.getType2();
 		Map<String, Object> map =new HashMap<String, Object>();
 		map.put("descId", descId);
 		map.put("desc", desc);
 		map.put("start", start);
 		map.put("end", end);
 		map.put("npe", type2);
 		if(worktype==0){
 			map.put("work", null);;
 		}else{
 			map.put("work", worktype-1);
 		}
 		if(equiptype==0){
 			map.put("equiptype", null);;
 		}else{
 			map.put("equiptype", equiptype);
 		}
 		//map.put("work", worktype);
 		map.put("page", page);
 		//System.out.println(map);
 		result = appThreeService.getListBytree(map);
 		return result;
     }
}
