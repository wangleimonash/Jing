package com.welleplus.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.AppThreeService;
import com.welleplus.server.AppTwoOnceService;

@Controller
@RequestMapping("once")
public class AppTwoOnceController {

	@Resource
	private AppTwoOnceService appTwoOnceService;
//	gettwolists
	/**
	 * 初始加载定位类型数据
	 * @param info
	 * @return
	 */
	@RequestMapping("gettwolists.do")
	@ResponseBody
	public Result gettwolists(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = info.getStartdate();
		String end = info.getEnddate();
		String type2 = info.getType2();
		int page = info.getPage();
		int worktype = info.getWorktype();
		int equiptype = info.getEquiptype();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1.0);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("page", page);
			result = appTwoOnceService.gettwolists(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("id", rid);
			map.put("page", page);
			result = appTwoOnceService.gettwolists(map);
		}
		if("2".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("id", uid);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.gettwolists(map);
		}
		if("3".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("id", uid);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.gettwolists(map);
		}
		if("4".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.gettwolists(map);
		}
		return result;
	}
	
	@RequestMapping("getlocation.do")
	@ResponseBody
	public Result getSectionData(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		if("0".equals(role)){
			result = appTwoOnceService.getRootOncedata();
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", rid);
			result = appTwoOnceService.getOneType(map);
		}
		if("2".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("rid", rid);
			map.put("role", role);
			map.put("id", uid);
			result = appTwoOnceService.getCompanydataone(map);
			
		}else if("3".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("rid", rid);
			map.put("role", role);
			map.put("id", uid);
			result = appTwoOnceService.getCompanydataone(map);
		}
		return result;
	}
	
//	getAttendanceinfo
		
	/** 
	* @Title: gettwohistorydata 
	* @Description: TODO(gettwohistorydata表单) 
	* @param @param info
	* @param @return 设定文件 
	* @return Result 返回类型 
	* @throws 
	*/ 
	@RequestMapping("gettwohistorydata.do")
	@ResponseBody
	public Result gettwohistorydata(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = info.getStartdate();
		String end = info.getEnddate();
		String type2 = info.getType2();
		int page = info.getPage();
		int worktype = info.getWorktype();
		int equiptype = info.getEquiptype();
		String  phonenumber =  info.getPhonenumber();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
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
			map.put("npe", type2);
			map.put("page", page);
			map.put("phonenumber", phonenumber);
			result = appTwoOnceService.getRootTwoForm(map);
//		}
//			result = AppTwoOnceService.getRootTwoForm();
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);;
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);;
			}else{
				map.put("equiptype", equiptype-1);
			}
			map.put("npe", type2);
			map.put("id", rid);
			map.put("page", page);
			result = appTwoOnceService.getRootTwoForm1(map);
		}
		if("2".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
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
			map.put("npe", type2);
			map.put("id", uid);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.getRootTwoForm2(map);
			
		}else if("3".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
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
			map.put("npe", type2);
			map.put("id", uid);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.getRootTwoForm3(map);
		}
		if("4".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
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
			map.put("npe", type2);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.getRootTwoForm4(map);
		}
		return result;
	}
//	getworkdata.do
	/** 
	* @Title: gettwohistorydata 
	* @Description: TODO(gettwohistorydata表单) 
	* @param @param info
	* @param @return 设定文件 
	* @return Result 返回类型 
	* @throws 
	*/ 
	@RequestMapping("getworkdata.do")
	@ResponseBody
	public Result getworkdata(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = info.getStartdate();
		String end = info.getEnddate();
		String type2 = info.getType2();
		int page = info.getPage();
		int worktype = info.getWorktype();
		int equiptype = info.getEquiptype();
		String  phonenumber =  info.getPhonenumber();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);;
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("phonenumber", phonenumber);
			map.put("npe", type2);
			map.put("page", page);
			System.out.println(String.valueOf(page));
			result = appTwoOnceService.getworkdata(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", rid);
			result = appTwoOnceService.getRootTwoForm1(map);
		}
		if("2".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("rid", rid);
			map.put("role", role);
			map.put("id", uid);
			result = appTwoOnceService.getCompanydataone(map);
			
		}else if("3".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("rid", rid);
			map.put("role", role);
			map.put("id", uid);
			result = appTwoOnceService.getCompanydataone(map);
		}
		return result;
	}
	
	
//	点击树加载getAttendanceinfo
	@RequestMapping("getAttendanceinfo.do")
	@ResponseBody
	public Result getAttendanceinfo(@RequestBody UserInfo info){
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
//		点击的时候
		result=appTwoOnceService.getAttendanceinfo(map);
		
		return result;
	}
//	getliststree
	/**
	 * 点击树加载定位类型数据
	 * @param info
	 * @return
	 */
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
		result = appTwoOnceService.getListBytree(map);
		return result;
	}
	
	
	/**
	 * 初始加载定位类型数据
	 * @param info
	 * @return
	 */
	@RequestMapping("getlists.do")
	@ResponseBody
	public Result getlists(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = info.getStartdate();
		String end = info.getEnddate();
		String type2 = info.getType2();
		int page = info.getPage();
		int worktype = info.getWorktype();
		int equiptype = info.getEquiptype();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1.0);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("page", page);
			result = appTwoOnceService.getListBy0(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("id", rid);
			map.put("page", page);
			result = appTwoOnceService.getListBy1(map);
		}
		if("2".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("id", uid);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.getListBy2(map);
		}
		if("3".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("id", uid);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.getListBy3(map);
		}
		if("4".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			if(worktype==0){
				map.put("work", null);
			}else{
				map.put("work", worktype-1);
			}
			if(equiptype==0){
				map.put("equiptype", null);
			}else{
				map.put("equiptype", equiptype);
			}
			map.put("npe", type2);
			map.put("rid", rid);
			map.put("page", page);
			result = appTwoOnceService.getListBy4(map);
		}
		return result;
	}
	
}
