package com.welleplus.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.EquipTypeServer;

@Controller
@RequestMapping("equiptype")
public class EquipTypeController {

	@Resource
	private EquipTypeServer equipTypeServer;
	
	/**
	 * 初始加载定位类型
	 * @param info
	 * @return
	 */
	@RequestMapping("gettypes.do")
	@ResponseBody
	public Result gettypes(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = null;
		String end = null;
		String type = info.getType2();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Date da = calendar.getTime();
		end = sdf1.format(da);
		if("1".equals(type)){
			Date date = calendar.getTime();
			start = sdf.format(date);
		}
		if("2".equals(type)){
			calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()+1);
			Date date = calendar.getTime();
			start = sdf.format(date);
		}
		if("3".equals(type)){
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			Date date = calendar.getTime();
			start = sdf.format(date);
		}
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			result = equipTypeServer.getCountBy0(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", rid);
			map.put("start", start);
			map.put("end", end);
			result = equipTypeServer.getCountBy1(map);
		}
		if("2".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", uid);
			map.put("rid", rid);
			map.put("start", start);
			map.put("end", end);
			result = equipTypeServer.getCountBy2(map);
			
		}
		if("3".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", uid);
			map.put("rid", rid);
			map.put("start", start);
			map.put("end", end);
			result = equipTypeServer.getCountBy3(map);
			
		}
		if("4".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("rid", rid);
			map.put("start", start);
			map.put("end", end);
			result = equipTypeServer.getCountBy4(map);
		}
		return result;
	}
	
	/**
	 * 点击树加载定位类型
	 * @param info
	 * @return
	 */
	@RequestMapping("gettypestree.do")
	@ResponseBody
	public Result gettypestree(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = null;
		String end = null;
		long descId = info.getDescId();
		int desc = info.getDesc();
		String type = info.getType2();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Date da = calendar.getTime();
		end = sdf1.format(da);
		if("1".equals(type)){
			Date date = calendar.getTime();
			start = sdf.format(date);
		}
		if("2".equals(type)){
			calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()+1);
			Date date = calendar.getTime();
			start = sdf.format(date);
		}
		if("3".equals(type)){
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			Date date = calendar.getTime();
			start = sdf.format(date);
		}
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("descId", descId);
		map.put("desc", desc);
		map.put("start", start);
		map.put("end", end);
		result = equipTypeServer.getCountBytree(map);
		return result;
	}
	
}
