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
import com.welleplus.server.CorrelationServer;
import com.welleplus.server.RfidServer;

@Controller
@RequestMapping("rfid")
public class RfidInfoController {

	@Resource
	private RfidServer rfidServer;
	
	@Resource
	private CorrelationServer corrServer;
	
	/**
	 * 查询用户和对应的RFID信息
	 * @param info
	 * @return
	 */
	@RequestMapping("getrfids.do")
	@ResponseBody
	public Result getRfidInfo(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = info.getStartdate();
		String end = info.getEnddate();
		String npe = info.getType2();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("npe", npe);
			result = rfidServer.getInfos(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", rid);
			map.put("start", start);
			map.put("end", end);
			map.put("npe", npe);
			result = rfidServer.getRfidInfo(map);
		}
		if("2".equals(role)||"3".equals(role)){
			Result re = new Result();
			Map<String, Object> m =new HashMap<String, Object>();
			m.put("rid", rid);
			m.put("role", role);
			re = rfidServer.getfirm(m);
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", re.getData());
			map.put("start", start);
			map.put("end", end);
			map.put("npe", npe);
			result = rfidServer.getRfidInfo(map);
			
		}
		return result;
	}
	
	/**
	 * 查询最近用户和对应的RFID信息
	 * @param info
	 * @return
	 */
	@RequestMapping("getmaxrfid.do")
	@ResponseBody
	public Result getMaxRfidInfo(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = info.getStartdate();
		String end = info.getEnddate();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			result = rfidServer.getMaxInfos(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", rid);
			map.put("start", start);
			map.put("end", end);
			result = rfidServer.getMaxRfidInfo(map);
		}
		if("2".equals(role)||"3".equals(role)){
			Result re = new Result();
			Map<String, Object> m =new HashMap<String, Object>();
			m.put("rid", rid);
			m.put("role", role);
			re = rfidServer.getfirm(m);
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", re.getData());
			map.put("start", start);
			map.put("end", end);
			result = rfidServer.getMaxRfidInfo(map);
			
		}
		return result;
	}
	
	//获取不重复的设备数量
	@RequestMapping("getCount.do")
	@ResponseBody
	public Result getCount(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			result = rfidServer.getCount(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", rid);
			result = rfidServer.getCount(map);
		}
		if("2".equals(role)||"3".equals(role)){
			Result re = new Result();
			Map<String, Object> m =new HashMap<String, Object>();
			m.put("rid", rid);
			m.put("role", role);
			re = rfidServer.getfirm(m);
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", re.getData());
			result = rfidServer.getCount(map);
			
		}
		return result;
	}
	
	/**
	 * 查询用户和对应的RFID信息 用于搜索
	 * @param info
	 * @return
	 */
	@RequestMapping("getUserRfidInfo.do")
	@ResponseBody
	public Result getUserRfidInfo(@RequestBody UserInfo info){
		Result result = new Result();
		Long rid = info.getRid();
		String role = info.getRole();
		Long uid = info.getId();
		String start = info.getStartdate();
		String end = info.getEnddate();
		if("0".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			result = rfidServer.getUserRfidInfo(map);
		}
		if("1".equals(role)){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", rid);
			result = rfidServer.getUserRfidInfo(map);
		}
		if("2".equals(role)||"3".equals(role)){
			Result re = new Result();
			Map<String, Object> m =new HashMap<String, Object>();
			m.put("rid", rid);
			m.put("role", role);
			re = rfidServer.getfirm(m);
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("id", re.getData());
			result = rfidServer.getUserRfidInfo(map);
			
		}
		return result;
	}
}
