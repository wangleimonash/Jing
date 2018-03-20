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
import com.welleplus.server.EquipTypeListServer;

@Controller
@RequestMapping("equiptypelist")
public class EquipTypeListController {

	@Resource
	private EquipTypeListServer equipTypeListServer;
	
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
			result = equipTypeListServer.getListBy0(map);
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
			result = equipTypeListServer.getListBy1(map);
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
			result = equipTypeListServer.getListBy2(map);
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
			result = equipTypeListServer.getListBy3(map);
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
			result = equipTypeListServer.getListBy4(map);
		}
		return result;
	}
	/**
	 * 初始加载定位类型数据  用于提示
	 * @param info
	 * @return
	 */
	@RequestMapping("getNpes.do")
	@ResponseBody
	public Result getNpes(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			result = equipTypeListServer.getNpeBy0(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", rid);
			result = equipTypeListServer.getNpeBy1(map);
		}
		if("2".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", uid);
			map.put("rid", rid);
			result = equipTypeListServer.getNpeBy2(map);
		}
		if("3".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", uid);
			map.put("rid", rid);
			result = equipTypeListServer.getNpeBy3(map);
		}
		if("4".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("rid", rid);
			result = equipTypeListServer.getNpeBy4(map);
		}
		return result;
	}
	
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
			map.put("work", null);
		}else{
			map.put("work", worktype-1);
		}
		if(equiptype==0){
			map.put("equiptype", null);
		}else{
			map.put("equiptype", equiptype);
		}
		//map.put("work", worktype);
		map.put("page", page);
		//System.out.println(map);
		result = equipTypeListServer.getListBytree(map);
		return result;
	}
	
}
