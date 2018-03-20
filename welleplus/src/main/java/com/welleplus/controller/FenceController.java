package com.welleplus.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.Fence;
import com.welleplus.entity.FenceQuery;
import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.FenceServer;
import com.welleplus.server.UserServer;
import com.welleplus.server.WarningServer;

@Controller
@RequestMapping("fence")
public class FenceController {
	@Resource
	private FenceServer fenceServer;
	
	@Resource
	private WarningServer warningServer;
	
	@Resource
	private UserServer userServer;
	
	@RequestMapping("addinfo.do")
	@ResponseBody
	public Result addFenceInfo(@RequestBody Fence info){
		Result result = new Result();
		Long pid = info.getPid();
//		List<String> flnglat = info.getLnglat();
//		flnglat.remove(7);
//		flnglat.remove(5);
//		flnglat.remove(3);
//		flnglat.remove(1);
//		info.setLnglat(flnglat);
		result = fenceServer.getFenceInfoFromPid(pid);
		if(result.getData()!=null){
			result.setState(false);
			result.setMessage("电子围栏已存在");
			return result;
		}
		if(info.getStartDate().isEmpty()){
			info.setStartDate(null);
		}
		if(info.getEndDate().isEmpty()){
			info.setEndDate(null);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		info.setCreatDate(sdf.format(new Timestamp(System.currentTimeMillis())));
		info.setUpdateDate(sdf.format(new Timestamp(System.currentTimeMillis())));
		if(info.getLnglat()!=null&&info.getLnglat().size()!=0){
			List<String> lnglat = info.getLnglat();
			info.setXloc((lnglat.get(0).split(","))[0]);
			info.setYloc(lnglat.get(0).split(",")[1]);
			info.setXloc1(lnglat.get(1).split(",")[0]);
			info.setYloc1(lnglat.get(1).split(",")[1]);
			info.setXloc2(lnglat.get(2).split(",")[0]);
			info.setYloc2(lnglat.get(2).split(",")[1]);
			if(lnglat.size()>3){
				info.setXloc3(lnglat.get(3).split(",")[0]);
				info.setYloc3(lnglat.get(3).split(",")[1]);
			}
			if(lnglat.size()>4){
				info.setXloc4(lnglat.get(4).split(",")[0]);
				info.setYloc4(lnglat.get(4).split(",")[1]);
			}
			if(lnglat.size()>5){
				info.setXloc5(lnglat.get(5).split(",")[0]);
				info.setYloc5(lnglat.get(5).split(",")[1]);
			}
			if(lnglat.size()>6){
				info.setXloc6(lnglat.get(6).split(",")[0]);
				info.setYloc6(lnglat.get(6).split(",")[1]);
			}
			
		}
		result = fenceServer.addFenceInfo(info);
		return result;
	}
	
	@RequestMapping("updateinfo.do")
	@ResponseBody
	public Result updateFenceInfo(@RequestBody Fence info){
		Result result = new Result();
		Long pid = info.getPid();
		result = fenceServer.getFenceInfoFromPid(pid);
		if(result.getData()==null){
			result.setState(false);
			result.setMessage("电子围栏不存在");
			return result;
		}
		if(info.getStartDate().isEmpty()){
			info.setStartDate(null);
		}
		if(info.getEndDate().isEmpty()){
			info.setEndDate(null);
		}
//		List<String> flnglat = info.getLnglat();
//		flnglat.remove(7);
//		flnglat.remove(5);
//		flnglat.remove(3);
//		flnglat.remove(1);
//		info.setLnglat(flnglat);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		info.setUpdateDate(sdf.format(new Timestamp(System.currentTimeMillis())));
		if(info.getLnglat()!=null&&info.getLnglat().size()!=0){
			List<String> lnglat = info.getLnglat();
			info.setXloc((lnglat.get(0).split(","))[0]);
			info.setYloc(lnglat.get(0).split(",")[1]);
			info.setXloc1(lnglat.get(1).split(",")[0]);
			info.setYloc1(lnglat.get(1).split(",")[1]);
			info.setXloc2(lnglat.get(2).split(",")[0]);
			info.setYloc2(lnglat.get(2).split(",")[1]);
			if(lnglat.size()>3){
				info.setXloc3(lnglat.get(3).split(",")[0]);
				info.setYloc3(lnglat.get(3).split(",")[1]);
				info.setXloc4("");
				info.setYloc4("");
				info.setXloc5("");
				info.setYloc5("");
				info.setXloc6("");
				info.setYloc6("");
			}
			if(lnglat.size()>4){
				info.setXloc4(lnglat.get(4).split(",")[0]);
				info.setYloc4(lnglat.get(4).split(",")[1]);
				info.setXloc5("");
				info.setYloc5("");
				info.setXloc6("");
				info.setYloc6("");
			}
			if(lnglat.size()>5){
				info.setXloc5(lnglat.get(5).split(",")[0]);
				info.setYloc5(lnglat.get(5).split(",")[1]);
				info.setXloc6("");
				info.setYloc6("");
			}
			if(lnglat.size()>6){
				info.setXloc6(lnglat.get(6).split(",")[0]);
				info.setYloc6(lnglat.get(6).split(",")[1]);
			}
			
		}
		result = fenceServer.updateFenceInfoFromPid(info);
		return result;
	}
	
	@RequestMapping("getinfofrompid.do")
	@ResponseBody
	public Result getFenceInfoFromPid(Long pid){
		Result result = new Result();
		result = fenceServer.getFenceInfoFromPid(pid);
		return result;
	}
	
	@RequestMapping("deleteinfo.do")
	@ResponseBody
	public Result deleteFenceInfo(Long pid){
		Result result = new Result();
		result = fenceServer.deleteFenceInfo(pid);
		return result;
	}
	
	@RequestMapping("getinfofromid.do")
	@ResponseBody
	public Result getFenceInfoFromId(Long role,Long rid,Long uid,Long desc,Long descId){
		Result result = new Result();
		switch (role.intValue()) {
		case 0:
//			result = fenceServer.getFenceInfoFromFirmId(null);
//			break;
		case 1:
			if(desc == 1L){
				result = fenceServer.getFenceInfoFromFirmId(descId);
			}else if(desc == 2L){
				result = fenceServer.getFenceInfoFromCompanyId(descId, null);
			}else if(desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(descId, null);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}else{
				
			}
			
			break;
		case 2:
			if(desc == 1L || desc == 2L){
				result = fenceServer.getFenceInfoFromCompanyId(rid, uid);
			}else if(desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(descId, null);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}else{
				
			}
//			result = fenceServer.getFenceInfoFromCompanyId(rid, uid);
			break;
		case 3:
			if(desc == 1L || desc == 2L || desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(rid, uid);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}
//			result = fenceServer.getFenceInfoFromSectionId(rid, uid);
			break;
		case 4:
			result = fenceServer.getFenceInfoFromPid(rid);
			List<Fence> infos = new ArrayList<Fence>();
			Fence info = (Fence)result.getData();
			infos.add(info);
			result.setData(infos);
			break;

		default:
			break;
		}
		return result;
	}
	
	/**
	 * 出勤统计新
	 */
	@RequestMapping("getnewworkinfos.do")
	@ResponseBody
	public Result getNewWorkInfos(@RequestBody FenceQuery fence){
		Result result = new Result();
		List<UserInfo> infos = userServer.getUserInfosByIds(fence.getIds(),fence.getPage(),fence.getInfo());
		result.setCount(userServer.getUserInfosCountByIds(fence.getIds(),fence.getInfo()));
		for (UserInfo userInfo : infos) {
			List<Map<String,String>> fences = fenceServer.getFenceWorkInfos(userInfo.getEquipnumber(),fence.getStartDate()+" 00:00:00",fence.getEndDate()+" 23:59:59");
			//设置出勤天数
			userInfo.setWorkdays(fences.size());
			
			//初始化迟到天数和早退天数
			int laterdays = 0;//迟到天数
			int befordays = 0;//早退天数
			
			if(fences.size()==0){
				userInfo.setLaterdays(0);
				userInfo.setBefordays(0);
			}else{
//				获取迟到天数
				Map<String,String> map = fenceServer.getWorkDateByPid(userInfo.getRid());
				String workstartdate = map.get("workstartdate");
				String workenddate = map.get("workenddate");
				workstartdate = workstartdate + " 00:00:00";
				workenddate = workenddate + " 23:59:59";
				if(workstartdate!=null&&!workstartdate.isEmpty()&&workenddate!=null&&!workenddate.isEmpty()){
					List<Map<String,String>> laters = fenceServer.getFenceWorkInfosLaterWork(userInfo.getEquipnumber(),workstartdate,workenddate);
					for(Map<String,String> laterday:laters){
						String start = laterday.get("start");
						if(isLater(start,workstartdate)){
							laterdays += 1;
						}
					}
					
//					获取早退天数
					List<Map<String,String>> befors = fenceServer.getFenceWorkInfosBeforWork(userInfo.getEquipnumber(),workstartdate,workenddate);
					for(Map<String,String> beforday:befors){
						String end = beforday.get("end");
						if(isBefor(end,workenddate)){
							befordays += 1;
						}
					}
//					
					userInfo.setLaterdays(laterdays);
					userInfo.setBefordays(befordays);
				}
				
				
			}
		}
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	/**
	 * 出勤统计
	 */
	@RequestMapping("getworkinfos.do")
	@ResponseBody
	public Result getWorkInfos(Long role,Long rid,Long uid,Long desc,Long descId){
		Result result = new Result();
		switch (role.intValue()) {
		case 0:
//			result = fenceServer.getFenceInfoFromFirmId(null);
//			break;
		case 1:
			if(desc == 1L){
				result = fenceServer.getFenceInfoFromFirmId(descId);
			}else if(desc == 2L){
				result = fenceServer.getFenceInfoFromCompanyId(descId, null);
			}else if(desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(descId, null);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}else{
				
			}
			
			break;
		case 2:
			if(desc == 1L || desc == 2L){
				result = fenceServer.getFenceInfoFromCompanyId(rid, uid);
			}else if(desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(descId, null);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}else{
				
			}
//			result = fenceServer.getFenceInfoFromCompanyId(rid, uid);
			break;
		case 3:
			if(desc == 1L || desc == 2L || desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(rid, uid);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}
//			result = fenceServer.getFenceInfoFromSectionId(rid, uid);
			break;
		case 4:
			result = fenceServer.getFenceInfoFromPid(rid);
			List<Fence> infos = new ArrayList<Fence>();
			Fence info = (Fence)result.getData();
			infos.add(info);
			result.setData(infos);
			break;

		default:
			break;
		}
		
		//获取到所有围栏信息
//		if(result.isState()){
//			List<Fence> infos = (ArrayList<Fence>)result.getData();
//			for(Fence fence:infos){
//				List<UserInfo> userinfos = userServer.getUserInfoByRoleAndRid(4L, fence.getPid());
//				for(int i=0;i<userinfos.size();i++){
//					if(userinfos.get(i).getEquiptype()==1){
//						String equipnumber = userinfos.get(i).getEquipnumber();
//						if(equipnumber==null||equipnumber.isEmpty()){
//							userinfos.remove(i);
//						}else{
//							List<Map<String,String>> fences = fenceServer.getFenceWorkInfos(userinfos.get(i).getEquipnumber());
//							//设置出勤天数
//							userinfos.get(i).setWorkdays(fences.size());
//							
//							//初始化迟到天数和早退天数
//							int laterdays = 0;//迟到天数
//							int befordays = 0;//早退天数
//							
//							if(fences.size()==0){
//								userinfos.get(i).setLaterdays(0);
//								userinfos.get(i).setBefordays(0);
//							}else{
////								获取迟到天数
//								Map<String,String> map = fenceServer.getWorkDateById(fence.getId());
//								String workstartdate = map.get("workstartdate");
//								String workenddate = map.get("workenddate");
//								if(workstartdate!=null&&!workstartdate.isEmpty()&&workenddate!=null&&!workenddate.isEmpty()){
//									List<Map<String,String>> laters = fenceServer.getFenceWorkInfosLaterWork(userinfos.get(i).getEquipnumber());
//									for(Map<String,String> laterday:laters){
//										String start = laterday.get("start");
//										if(isLater(start,workstartdate)){
//											laterdays += 1;
//										}
//									}
//									
////									获取早退天数
//									List<Map<String,String>> befors = fenceServer.getFenceWorkInfosBeforWork(userinfos.get(i).getEquipnumber());
//									for(Map<String,String> beforday:befors){
//										String end = beforday.get("end");
//										if(isBefor(end,workenddate)){
//											befordays += 1;
//										}
//									}
////									
//									userinfos.get(i).setLaterdays(laterdays);
//									userinfos.get(i).setBefordays(befordays);
//								}
//								
//								
//							}
//							
////							
//						}
//					}
//					
//				}
//				
//				result.setData(userinfos);
//				result.setState(true);
//				result.setMessage("查询成功");
//			}
//		}
		
		
		return result;
	}
	
	/**
	 * 电子围栏信息
	 * @param id
	 * @return
	 */
	@RequestMapping("getFenceInfos.do")
	@ResponseBody
	public Result getFenceInfos(Long role,Long rid,Long uid,Long desc,Long descId,int page){
		Result result = new Result();
		switch (role.intValue()) {
		case 0:
//			result = fenceServer.getFenceInfoFromFirmId(null);
//			break;
			result = fenceServer.getFenceInfos();
			break;
		case 1:
			if(desc == 1L){
				result = fenceServer.getFenceInfoFromFirmId(descId);
			}else if(desc == 2L){
				result = fenceServer.getFenceInfoFromCompanyId(descId, null);
			}else if(desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(descId, null);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}else{
				
			}
			
			break;
		case 2:
			if(desc == 1L || desc == 2L){
				result = fenceServer.getFenceInfoFromCompanyId(rid, uid);
			}else if(desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(descId, null);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}else{
				
			}
//			result = fenceServer.getFenceInfoFromCompanyId(rid, uid);
			break;
		case 3:
			if(desc == 1L || desc == 2L || desc == 3L){
				result = fenceServer.getFenceInfoFromSectionId(rid, uid);
			}else if(desc == 4L){
				result = fenceServer.getFenceInfoFromPid(descId);
				List<Fence> infos = new ArrayList<Fence>();
				Fence info = (Fence)result.getData();
				infos.add(info);
				result.setData(infos);
			}
//			result = fenceServer.getFenceInfoFromSectionId(rid, uid);
			break;
		case 4:
			result = fenceServer.getFenceInfoFromPid(rid);
			List<Fence> infos = new ArrayList<Fence>();
			Fence info = (Fence)result.getData();
			infos.add(info);
			result.setData(infos);
			break;

		default:
			break;
		}
		
		List<Fence> resultList = new ArrayList<Fence>();
		
		List<Fence> infos = (List<Fence>)result.getData();
		result.setCount((long)infos.size());
		for(int i=page*10;i<page*10+10;i++){
			if(i>=infos.size()){
				break;
			}
			Map<String,String> map = fenceServer.getOrgan(infos.get(i).getId());
			String fname = map.get("fname");
			String cname = map.get("cname");
			String sname = map.get("sname");
			String pname = map.get("pname");
			infos.get(i).setDiscribe(fname + " > " + cname + " > " + sname + " > " + pname);
			
			resultList.add(infos.get(i));
		}
		result.setData(resultList);
//		for (Fence fence : infos) {
//			Map<String,String> map = fenceServer.getOrgan(fence.getId());
//			String fname = map.get("fname");
//			String cname = map.get("cname");
//			String sname = map.get("sname");
//			String pname = map.get("pname");
//			fence.setDiscribe(fname + " > " + cname + " > " + sname + " > " + pname);
//		}
		
		return result;
	}
	
	@RequestMapping("getcount.do")
	@ResponseBody
	public Result getCount(Long id){
		Result result = new Result();
		Map<String,Long> map = new HashMap<String,Long>();
		//查询围栏中的人数
		result = fenceServer.getCountUserInFence(id);
		map.put("userCount", result.getId());
		
		result = warningServer.getCountWarning(id);
		map.put("warningCount", result.getId());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result.setMessage(sdf.format(new Timestamp(System.currentTimeMillis())));
		result.setData(map);
		return result;
	}
	
	@RequestMapping("getworkpie.do")
	@ResponseBody
	public Result getWorkPie(){
		Result result = new Result();
		Map<String,Long> map = new HashMap<String,Long>();
		map = fenceServer.getWorkPie();
		List<String> names = fenceServer.getFenceName();
		if(map==null){
			map = new HashMap<String,Long>();
		}
		for (String name : names) {
			if(map.get(name)==null){
				map.put(name, 0L);
			}
		}
		result.setData(map);
		result.setMessage("查询成功");
		result.setState(true);
		return result;
	}
	
	
	/**
	 * 判断是否迟到
	 */
	private boolean isLater(String time,String startdate){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			Long starttime = sdf.parse(time).getTime();
			if(starttime>sdf.parse(startdate).getTime()){
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	/**
	 * 判断是否早退
	 */
	private boolean isBefor(String time,String enddate){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			Long endtime = sdf.parse(time).getTime();
			if(endtime<sdf.parse(enddate).getTime()){
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	

}
