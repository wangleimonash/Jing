package com.welleplus.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.Company;
import com.welleplus.entity.Correlation;
import com.welleplus.entity.Firm;
import com.welleplus.entity.FirmInfo;
import com.welleplus.entity.ImageInfo;
import com.welleplus.entity.UserInfo;
import com.welleplus.entity.UserInfoQuery;
import com.welleplus.entity.WatchWarning;
import com.welleplus.entity.WorkTypeBar;
import com.welleplus.result.Result;
import com.welleplus.server.CompanyServer;
import com.welleplus.server.CorrelationServer;
import com.welleplus.server.FirmServer;
import com.welleplus.server.ProjectServer;
import com.welleplus.server.SectionServer;
import com.welleplus.server.UserServer;
import com.welleplus.util.Md5Util;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserServer userServer;
	
	@Resource
	private CorrelationServer corrServer;
	
	@Resource
	private CompanyServer companyServer;
	
	@Resource
	private SectionServer sectionServer;
	
	@Resource
	private ProjectServer projectServer;
	
	@Resource
	private FirmServer firmServer;
	
	@RequestMapping("getinfos.do")
	@ResponseBody
	public Result getInfos(){
		Result result = new Result();
		result = userServer.getInfos();
		return result;
	}

	/**
	 * 添加用户信息
	 * @param info
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addinfo.do")
	@ResponseBody
	@Transactional(value="transactionManager",rollbackFor=java.lang.Exception.class)
	public Result addUserInfo(@RequestBody UserInfo info) throws Exception{
		Result result = new Result();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		info.setCreatdate(df.format(new Timestamp(System.currentTimeMillis())));
		if(info.getPassword()!=null&&!info.getPassword().isEmpty()){
			info.setPassword(Md5Util.md5String(info.getPassword()));
		}
		
//		if(info.getGetdate().isEmpty()){
//			info.setGetdate(null);
//		}
		if(info.getPhonenumber()!=null&&!info.getPhonenumber().isEmpty()){
			UserInfo queryInfo = new UserInfo();
			queryInfo.setPhonenumber(info.getPhonenumber());
			UserInfo resultInfo = userServer.getuserinfoforuniq(queryInfo);
			if(resultInfo!=null){
				result.setState(false);
				result.setMessage("电话号码已存在");
				return result;
			}
		}
		if(info.getUserName()!=null&&!info.getUserName().isEmpty()){
			UserInfo queryInfo = new UserInfo();
			queryInfo.setUserName(info.getUserName());
			UserInfo resultInfo = userServer.getuserinfoforuniq(queryInfo);
			if(resultInfo!=null){
				result.setState(false);
				result.setMessage("登录账户名已存在");
				return result;
			}
		}
		if(info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
			UserInfo queryInfo = new UserInfo();
			queryInfo.setEquipnumber(info.getEquipnumber());
			UserInfo resultInfo = userServer.getuserinfoforuniq(queryInfo);
			if(resultInfo!=null){
				result.setState(false);
				result.setMessage("设备编号已存在");
				return result;
			}
		}
		
		if(info.getEquiptype()!=null&&info.getEquiptype()!=0&&info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			info.setGetdate(sdf.format(new Timestamp(System.currentTimeMillis())));
		}

		result = userServer.addUserInfo(info);
		Long id = result.getId();
		List<Long> ids = info.getIds();
		if(ids!=null&&info.getGrade()!=null&&!("1".equals(info.getRole()))){
			for (Long id1 : ids) {
				Correlation co = new Correlation();
				co.setUid(id);
				co.setGrade(info.getGrade());
				co.setGradeid(id1);
				result = corrServer.addCorrelationInfo(co);
			}
		}
		return result;
	}

	/**
	 * 查询用户信息
	 * @param info
	 * @return
	 */
	@RequestMapping("getinfo.do")
	@ResponseBody
	public Result getUserInfo(@RequestBody UserInfo info){
		Result result = new Result();
		result = userServer.getInfo(info);
		if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
			List<UserInfo> infos = (ArrayList)result.getData();
			for (UserInfo userInfo : infos) {
				Long id = userInfo.getId();
				Correlation cinfo = new Correlation();
				cinfo.setUid(id);
				Result cresult = corrServer.getCorrelationInfo(cinfo);
				if(cresult.getData()!=null){
					List<Correlation> cInfos = (ArrayList)cresult.getData();
					userInfo.setCorrelations(cInfos);
				}
			}
			result.setData(infos);
		}
		return result;
	}

	/**
	 * 修改用户信息
	 * @param userInfo
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("editUser.do")
	@ResponseBody
	@Transactional(value="transactionManager",rollbackFor=java.lang.Exception.class)
	public Result editUser(@RequestBody UserInfo userInfo) throws Exception{
		Result result = new Result();
		if(userInfo.getPassword()!=null&&!userInfo.getPassword().isEmpty()&&userInfo.getPassword().length()!=24){
			userInfo.setPassword(Md5Util.md5String(userInfo.getPassword()));
		}
		if(userInfo.getPhonenumber()!=null&&!userInfo.getPhonenumber().isEmpty()&&!userInfo.getPhonenumber().equals(userInfo.getEditphonenumber())){
			UserInfo queryInfo = new UserInfo();
			queryInfo.setPhonenumber(userInfo.getPhonenumber());
			UserInfo resultInfo = userServer.getuserinfoforuniq(queryInfo);
			if(resultInfo!=null){
				result.setState(false);
				result.setMessage("电话号码已存在");
				return result;
			}
		}
		if(userInfo.getUserName()!=null&&!userInfo.getUserName().isEmpty()&&!userInfo.getUserName().equals(userInfo.getEdituserName())){
			UserInfo queryInfo = new UserInfo();
			queryInfo.setUserName(userInfo.getUserName());
			UserInfo resultInfo = userServer.getuserinfoforuniq(queryInfo);
			if(resultInfo!=null){
				result.setState(false);
				result.setMessage("用户名已存在");
				return result;
			}
		}
		if(userInfo.getEquipnumber()!=null&&!userInfo.getEquipnumber().isEmpty()&&!userInfo.getEquipnumber().equals(userInfo.getEditequipnumber())){
			UserInfo queryInfo = new UserInfo();
			queryInfo.setEquipnumber(userInfo.getEquipnumber());
			UserInfo resultInfo = userServer.getuserinfoforuniq(queryInfo);
			if(resultInfo!=null){
				result.setState(false);
				result.setMessage("设备编号已存在");
				return result;
			}
		}
		result = userServer.editUser(userInfo);
		List<Long> ids = userInfo.getIds();
		if(ids!=null&&!("1".equals(userInfo.getRole()))){
			corrServer.deleteCorrelationInfoFromUid(userInfo.getId());
			for (Long id1 : ids) {
				Correlation co = new Correlation();
				co.setUid(userInfo.getId());
				co.setGrade((long)(Integer.valueOf(userInfo.getRole())+1));
				co.setGradeid(id1);
				result = corrServer.addCorrelationInfo(co);
			}
		}
		result.setMessage("编辑成功");
		return result;
	}
	/**
	 * 删除用户信息
	 * @param userInfo
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("delUser.do")
	@ResponseBody
	@Transactional(value="transactionManager",rollbackFor=java.lang.Exception.class)
	public Result delUser(Long id) throws Exception{
		Result result = new Result();
		result = userServer.delUser(id);
		result = corrServer.deleteCorrelationInfoFromUid(id);
		return result;
	}
	/**
	 * 登录
	 * @param info
	 * @return
	 */
	@RequestMapping("login.do")
	@ResponseBody
	public Result login(UserInfo info,HttpServletRequest request){
		Result result = new Result();
		if(info.getUserName()==null||info.getUserName().isEmpty()
				||info.getPassword()==null||info.getPassword().isEmpty()){
			result.setState(false);
			result.setMessage("参数不能为空");
			return result;
		}
		
		info.setPassword(Md5Util.md5String(info.getPassword()));
		
//		result = userServer.getInfo(info);
		result = userServer.login(info);
		
//		String ip = request.getHeader("x-forwarded-for");  
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//            ip = request.getHeader("Proxy-Client-IP");  
//        }  
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//            ip = request.getHeader("WL-Proxy-Client-IP");  
//        }  
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//            ip = request.getHeader("HTTP_CLIENT_IP");  
//        }  
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
//        }  
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//            ip = request.getRemoteAddr();  
//        }
//        if (ip.equals("0:0:0:0:0:0:0:1")) {
//        	ip = "本地";
//        }
//        result.setTempip(ip);
		
		return result;
	}
	
	@RequestMapping("getuserinfos.do")
	@ResponseBody
	public Result getUserInfos(@RequestBody UserInfo info){
		Result result = new Result();
		String role = info.getRole();
		if("4".equals(role)){
			List<UserInfo> infos = userServer.getUserInfoForRole(info);
			result.setData(infos);
		}else if("3".equals(role)){
			List<UserInfo> infos = new ArrayList<UserInfo>();
			List<UserInfo> role3s = userServer.getUserInfoForRole(info);
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
			List<UserInfo> role4s = userServer.getUserInfoFromCorrelation(4L, info.getId());
			for (UserInfo role4 : role4s) {
				infos.add(role4);
			}
			result.setData(infos);
		}else if("2".equals(role)){
			List<UserInfo> infos = new ArrayList<UserInfo>();
			List<UserInfo> role2s = userServer.getUserInfoForRole(info);
			for (UserInfo role2 : role2s) {
				infos.add(role2);
			}
			List<UserInfo> role3s = userServer.getUserInfoFromCorrelation(3L, info.getId());
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
			for (UserInfo role3 : role3s) {
				List<UserInfo> role4s = userServer.getUserInfoForRole(info);
				for (UserInfo role4 : role4s) {
					infos.add(role4);
				}
			}
			
			result.setData(infos);
		}else if("1".equals(role)){
			List<UserInfo> infos = new ArrayList<UserInfo>();
			List<UserInfo> role1s = userServer.getUserInfoForRole(info);
			for (UserInfo role1 : role1s) {
				infos.add(role1);
			}
			List<UserInfo> role2s = userServer.getUserInfoOfRole2FromRole1(info);
			for (UserInfo role2 : role2s) {
				infos.add(role2);
			}
			List<UserInfo> role3s = userServer.getUserInfoOfRole3FromRole1(info);
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
			List<UserInfo> role4s = userServer.getUserInfoOfRole4FromRole1(info);
			for (UserInfo role4 : role4s) {
				infos.add(role4);
			}
			List<UserInfo> resultInfos = new ArrayList<UserInfo>();
			int page = info.getPage();
			for(int i=page*10;i<page*10+10;i++){
				resultInfos.add(infos.get(i));
				if(i==infos.size()-1){
					break;
				}
			}
			result.setData(resultInfos);
			result.setCount((long)infos.size());
		}else if("0".equals(role)){
				List<UserInfo> infos = userServer.getUserInfoFromRole0(info);
				List<UserInfo> resultInfos = new ArrayList<UserInfo>();
				int page = info.getPage();
				for(int i=page*10;i<page*10+10;i++){
					resultInfos.add(infos.get(i));
					if(i==infos.size()-1){
						break;
					}
				}
				result.setData(resultInfos);
				result.setCount((long)infos.size());
		}
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	@RequestMapping("getcount.do")
	@ResponseBody
	public Result getUserInfoCountFromRole2Id(Long fid,Long role){
		Result result = new Result();
		if(role == 1L){
			List<WorkTypeBar> workinfos = new ArrayList<WorkTypeBar>();
			Result cinfos = companyServer.getCompanyInfo(fid);
			if(cinfos!=null&&cinfos.getData()!=null){
				List<Company> companys = (ArrayList<Company>)cinfos.getData();
				
				for (Company company : companys) {
					WorkTypeBar workTypeBar = new WorkTypeBar();
					workTypeBar.setName(company.getName());
					Map<String,Long> resultmap = new HashMap<String,Long>();
					List<Map<String, Object>> countmaps = userServer.getUserInfoCountFromRole2Id(fid, company.getId());
					for (Map<String, Object> map : countmaps) {
						resultmap.put(String.valueOf(map.get("worktypeStr")), (Long)map.get("worktypecount"));
					}
					workTypeBar.setData(resultmap);
					
					workinfos.add(workTypeBar);
				}
				
			}
			result.setData(workinfos);
		}else if(role == 0L){
			List<WorkTypeBar> workinfos = new ArrayList<WorkTypeBar>();
			Result finfos = firmServer.getFirmInfos();
			if(finfos!=null&&finfos.getData()!=null){
				List<FirmInfo> firms = (ArrayList<FirmInfo>)finfos.getData();
				
				for (FirmInfo firm : firms) {
					WorkTypeBar workTypeBar = new WorkTypeBar();
					workTypeBar.setName(firm.getName());
					Map<String,Long> resultmap = new HashMap<String,Long>();
					List<Map<String,Object>> countmaps = userServer.getUserInfoCountFromRole1Id(firm.getId());
					for(Map<String,Object> map : countmaps){
						resultmap.put(String.valueOf(map.get("worktypeStr")), (Long)map.get("worktypecount"));
					}
					workTypeBar.setData(resultmap);
					
					workinfos.add(workTypeBar);
				}
			}
			result.setData(workinfos);
		}
		
		result.setState(true);
		result.setMessage("查询成功");
		
		return result;
		
	}
	
	@RequestMapping("getjourinfo.do")
	@ResponseBody
	public Result getJournalInfo(@RequestBody UserInfoQuery info){
		Result result = new Result();
		if(info.getRole()==null||info.getDesc()==null
				||info.getDescId()==null){
			result.setState(false);
			result.setData(null);
			return result;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Map<String,Object>> infos = new ArrayList<Map<String,Object>>();
		switch (info.getRole().intValue()) {
		case 0:
			
		case 1:
			if(info.getDesc() == 1L){
				Long count = userServer.getCountJournalInfoFromRole1Click1(info);
				infos = userServer.getJournalInfoFromRole1Click1(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}else if(info.getDesc() == 2L){
				Long count = userServer.getCountJournalInfoFromRole1Click2(info);
				infos = userServer.getJournalInfoFromRole1Click2(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}else if(info.getDesc() == 3L){
				Long count = userServer.getCountJournalInfoFromRole1Click3(info);
				infos = userServer.getJournalInfoFromRole1Click3(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}else if(info.getDesc() == 4L){
				Long count = userServer.getCountJournalInfoFromRole1Click4(info);
				infos = userServer.getJournalInfoFromRole1Click4(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}
			break;
			
		case 2:
			if(info.getDesc() == 1L || info.getDesc() == 2L){
				Long count = userServer.getCountJournalInfoFromRole2Click2(info);
				infos = userServer.getJournalInfoFromRole2Click2(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}else if(info.getDesc() == 3L){
				Long count = userServer.getCountJournalInfoFromRole2Click3(info);
				infos = userServer.getJournalInfoFromRole2Click3(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}else{
				Long count = userServer.getCountJournalInfoFromRole1Click4(info);
				infos = userServer.getJournalInfoFromRole1Click4(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}
			break;
			
		case 3:
			if(info.getDesc() == 1L || info.getDesc() ==2L || info.getDesc() == 3L){
				Long count = userServer.getCountJournalInfoFromRole3Click3(info);
				infos = userServer.getJournalInfoFromRole3Click3(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}else{
				Long count = userServer.getCountJournalInfoFromRole1Click4(info);
				infos = userServer.getJournalInfoFromRole1Click4(info);
				for (Map<String, Object> map : infos) {
					Object watchtime = map.get("watchtime");
					map.put("watchtimestr", sdf.format(watchtime));
					
					String title = String.valueOf(map.get("title"));
					List<ImageInfo> imageInfos = userServer.getImageInfo(title);
					if(imageInfos!=null&&imageInfos.size()!=0){
						map.put("havephone", "有");
					}else{
						map.put("havephone", "无");
					}
					map.put("imageinfos", imageInfos);
				}
				result.setCount(count);
			}
			break;
			
		case 4:
			info.setDescId(info.getRid());
			Long count = userServer.getCountJournalInfoFromRole1Click4(info);
			infos = userServer.getJournalInfoFromRole1Click4(info);
			for (Map<String, Object> map : infos) {
				Object watchtime = map.get("watchtime");
				map.put("watchtimestr", sdf.format(watchtime));
				
				String title = String.valueOf(map.get("title"));
				List<ImageInfo> imageInfos = userServer.getImageInfo(title);
				if(imageInfos!=null&&imageInfos.size()!=0){
					map.put("havephone", "有");
				}else{
					map.put("havephone", "无");
				}
				map.put("imageinfos", imageInfos);
			}
			result.setCount(count);
			break;

		default:
			break;
		}
		result.setData(infos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	@RequestMapping("getinfobyroleandridnew")
	@ResponseBody
	public Result getUserInfoByRoleAndRidNew(@RequestBody Long[][] ids){
		Result result = new Result();
		UserInfoQuery queryInfo = new UserInfoQuery();
		queryInfo.setIds(ids);
		
		List<UserInfo> infos = userServer.getUserInfoByIdsNew(queryInfo);
		for (UserInfo info : infos) {
			if(info.getEquiptype()!=null&&info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
				if(info.getEquiptype()==0){
					//手表
					String imei = info.getEquipnumber();
					Map<String,Object> map = userServer.getwatchgpsByImei(imei);
					if(map!=null){
						if(map.get("date")!=null&&map.get("time")!=null){
							StringBuffer sb = new StringBuffer(String.valueOf(map.get("date")));
							sb.insert(6, "-");
							sb.insert(4, "-");
							String positiontime = sb.toString();
							sb = new StringBuffer(String.valueOf(map.get("time")));
							sb.insert(4, ":");
							sb.insert(2, ":");
							positiontime = positiontime + " " + sb.toString();
							info.setPositiontime(positiontime);
						}
						
						if(map.get("longitude")!=null){
							info.setxLoc(String.valueOf(map.get("longitude")));
						}
						if(map.get("latitude")!=null){
							info.setyLoc(String.valueOf(map.get("latitude")));
						}
						if(map.get("altitude")!=null){
							info.setAltitude(String.valueOf(map.get("altitude")));
						}
						if(map.get("address")!=null){
							info.setAddress(String.valueOf(map.get("address")));
						}
						if(map.get("elec")!=null){
							info.setElec(String.valueOf(map.get("elec")));
						}
					}
					
					Map<String,Object> hmap = userServer.getwatchheartByImei(imei);
					if(hmap!=null&&hmap.get("heartrate")!=null){
						info.setHeartRate((int)hmap.get("heartrate"));
					}
					
				}else if(info.getEquiptype()==1){
					//安全帽
					String imei = info.getEquipnumber();
					Map<String,Object> map = userServer.getwatchdataByImei(imei);
					if(map!=null){
						if(map.get("xloc")!=null){
							info.setxLoc(String.valueOf(map.get("xloc")));
						}
						if(map.get("yloc")!=null){
							info.setyLoc(String.valueOf(map.get("yloc")));
						}
						if(map.get("watchdate")!=null){
							info.setPositiontime(String.valueOf(map.get("watchdate")));
						}
						if(map.get("address")!=null){
							info.setAddress(String.valueOf(map.get("address")));
						}
						if(map.get("bat")!=null){
							info.setElec(String.valueOf(map.get("bat")));
						}
					}
					
					
				}else if(info.getEquiptype()==2){
					//app
					String imei = info.getPhonenumber();
					Map<String,Object> map = userServer.getappdataByImei(imei);
					if(map!=null){
						if(map.get("xloc")!=null){
							info.setxLoc(String.valueOf(map.get("xloc")));
						}
						if(map.get("yloc")!=null){
							info.setyLoc(String.valueOf(map.get("yloc")));
						}
						if(map.get("watchtime")!=null){
							info.setPositiontime(String.valueOf(map.get("watchtime")));
						}
						if(map.get("address")!=null){
							info.setAddress(String.valueOf(map.get("address")));
						}
					}
					
				}else{
					//rfid
					
				}
			}
			
		}
		return result;
	}
	
	@RequestMapping("getinfobyroleid")
	@ResponseBody
	public Result getUserInfoByRoleAndRid(@RequestBody Long[][] ids){
		Result result = new Result();
		List<UserInfo> infoss = new ArrayList<UserInfo>();
		for (Long[] id : ids) {
			Long role = id[0];
			Long rid = id[1];
			List<UserInfo> infos = userServer.getUserInfoByRoleAndRid(role, rid);
			for (UserInfo info : infos) {
				if(info.getEquiptype()!=null&&info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
					if(info.getEquiptype()==0){
						//手表
						String imei = info.getEquipnumber();
						Map<String,Object> map = userServer.getwatchgpsByImei(imei);
						if(map!=null){
							if(map.get("date")!=null&&map.get("time")!=null){
								StringBuffer sb = new StringBuffer(String.valueOf(map.get("date")));
								sb.insert(6, "-");
								sb.insert(4, "-");
								String positiontime = sb.toString();
								sb = new StringBuffer(String.valueOf(map.get("time")));
								sb.insert(4, ":");
								sb.insert(2, ":");
								positiontime = positiontime + " " + sb.toString();
								info.setPositiontime(positiontime);
							}
							
							if(map.get("longitude")!=null){
								info.setxLoc(String.valueOf(map.get("longitude")));
							}
							if(map.get("latitude")!=null){
								info.setyLoc(String.valueOf(map.get("latitude")));
							}
							if(map.get("altitude")!=null){
								info.setAltitude(String.valueOf(map.get("altitude")));
							}
							if(map.get("address")!=null){
								info.setAddress(String.valueOf(map.get("address")));
							}
							if(map.get("elec")!=null){
								info.setElec(String.valueOf(map.get("elec")));
							}
						}
						
						Map<String,Object> hmap = userServer.getwatchheartByImei(imei);
						if(hmap!=null&&hmap.get("heartrate")!=null){
							info.setHeartRate((int)hmap.get("heartrate"));
						}
						
					}else if(info.getEquiptype()==1){
						//安全帽
						String imei = info.getEquipnumber();
						Map<String,Object> map = userServer.getwatchdataByImei(imei);
						if(map!=null){
							if(map.get("xloc")!=null){
								info.setxLoc(String.valueOf(map.get("xloc")));
							}
							if(map.get("yloc")!=null){
								info.setyLoc(String.valueOf(map.get("yloc")));
							}
							if(map.get("watchdate")!=null){
								info.setPositiontime(String.valueOf(map.get("watchdate")));
							}
							if(map.get("address")!=null){
								info.setAddress(String.valueOf(map.get("address")));
							}
							if(map.get("bat")!=null){
								info.setElec(String.valueOf(map.get("bat")));
							}
						}
						
						
					}else if(info.getEquiptype()==2){
						//app
						String imei = info.getPhonenumber();
						Map<String,Object> map = userServer.getappdataByImei(imei);
						if(map!=null){
							if(map.get("xloc")!=null){
								info.setxLoc(String.valueOf(map.get("xloc")));
							}
							if(map.get("yloc")!=null){
								info.setyLoc(String.valueOf(map.get("yloc")));
							}
							if(map.get("watchtime")!=null){
								info.setPositiontime(String.valueOf(map.get("watchtime")));
							}
							if(map.get("address")!=null){
								info.setAddress(String.valueOf(map.get("address")));
							}
						}
						
					}else{
						//rfid
						
					}
					infoss.add(info);
				}
				
			}
		}
		
		result.setData(infoss);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	/**
	 * 实时监控查询安全帽位置信息
	 */
	@RequestMapping("getuserandpositionbyids.do")
	@ResponseBody
	public Result getUserAndPositionByIds(@RequestBody Object[][] ids){
		Result result = new Result();
		if(ids==null||ids.length==0){
			result.setState(true);
			result.setMessage("查询成功");
			result.setData(new ArrayList<UserInfo>());
			return result;
		}
		UserInfoQuery queryInfo = new UserInfoQuery();
		queryInfo.setIds(ids);
		result = userServer.getUserAndPositionByIds(queryInfo);
		
		return result;
	}
	
	/**
	 * 实时监控页面，根据ids查询用户位置及定位信息
	 * @param ids
	 * @return
	 */
	@RequestMapping("getinfobyidsnew.do")
	@ResponseBody
	public Result getUserInfoByIdsNew(@RequestBody Object[][] ids){
		Result result = new Result();
		
		if(ids==null||ids.length==0){
			result.setState(true);
			result.setMessage("查询成功");
			result.setData(new ArrayList<UserInfo>());
			return result;
		}
		UserInfoQuery queryInfo = new UserInfoQuery();
		queryInfo.setIds(ids);
		List<UserInfo> infos = userServer.getUserInfoByIdsNew(queryInfo);
		List<UserInfo> pInfos = new ArrayList<UserInfo>();
		for (UserInfo info:infos){
			if(info.getEquiptype()!=null&&info.getEquiptype()==1&&info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
				pInfos.add(info);
			}
		}
		
		for(UserInfo pInfo : pInfos){
			String imei = pInfo.getEquipnumber();
			Map<String,Object> map = userServer.getwatchdataByImei(imei);
			if(map!=null){
				if(map.get("xloc")!=null){
					pInfo.setxLoc(String.valueOf(map.get("xloc")));
				}
				if(map.get("yloc")!=null){
					pInfo.setyLoc(String.valueOf(map.get("yloc")));
				}
				if(map.get("watchdate")!=null){
					pInfo.setPositiontime(String.valueOf(map.get("watchdate")));
				}
				if(map.get("address")!=null){
					pInfo.setAddress(String.valueOf(map.get("address")));
				}
				if(map.get("bat")!=null){
					pInfo.setElec(String.valueOf(map.get("bat")));
				}
			}
		}
		
		
		
//		for (UserInfo info : infos) {
//			if(info.getEquiptype()!=null&&info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
//				if(info.getEquiptype()==0){
//					//手表
//					String imei = info.getEquipnumber();
//					Map<String,Object> map = userServer.getwatchgpsByImei(imei);
//					if(map!=null){
//						if(map.get("date")!=null&&map.get("time")!=null){
//							StringBuffer sb = new StringBuffer(String.valueOf(map.get("date")));
//							sb.insert(6, "-");
//							sb.insert(4, "-");
//							String positiontime = sb.toString();
//							sb = new StringBuffer(String.valueOf(map.get("time")));
//							sb.insert(4, ":");
//							sb.insert(2, ":");
//							positiontime = positiontime + " " + sb.toString();
//							info.setPositiontime(positiontime);
//						}
//						
//						if(map.get("longitude")!=null){
//							info.setxLoc(String.valueOf(map.get("longitude")));
//						}
//						if(map.get("latitude")!=null){
//							info.setyLoc(String.valueOf(map.get("latitude")));
//						}
//						if(map.get("altitude")!=null){
//							info.setAltitude(String.valueOf(map.get("altitude")));
//						}
//						if(map.get("address")!=null){
//							info.setAddress(String.valueOf(map.get("address")));
//						}
//						if(map.get("elec")!=null){
//							info.setElec(String.valueOf(map.get("elec")));
//						}
//					}
//					
//					Map<String,Object> hmap = userServer.getwatchheartByImei(imei);
//					if(hmap!=null&&hmap.get("heartrate")!=null){
//						info.setHeartRate((int)hmap.get("heartrate"));
//					}
//					
//				}else if(info.getEquiptype()==1){
//					//安全帽
//					String imei = info.getEquipnumber();
//					Map<String,Object> map = userServer.getwatchdataByImei(imei);
//					if(map!=null){
//						if(map.get("xloc")!=null){
//							info.setxLoc(String.valueOf(map.get("xloc")));
//						}
//						if(map.get("yloc")!=null){
//							info.setyLoc(String.valueOf(map.get("yloc")));
//						}
//						if(map.get("watchdate")!=null){
//							info.setPositiontime(String.valueOf(map.get("watchdate")));
//						}
//						if(map.get("address")!=null){
//							info.setAddress(String.valueOf(map.get("address")));
//						}
//						if(map.get("bat")!=null){
//							info.setElec(String.valueOf(map.get("bat")));
//						}
//					}
//					
//					
//				}else if(info.getEquiptype()==2){
//					//app
//					String imei = info.getPhonenumber();
//					Map<String,Object> map = userServer.getappdataByImei(imei);
//					if(map!=null){
//						if(map.get("xloc")!=null){
//							info.setxLoc(String.valueOf(map.get("xloc")));
//						}
//						if(map.get("yloc")!=null){
//							info.setyLoc(String.valueOf(map.get("yloc")));
//						}
//						if(map.get("watchtime")!=null){
//							info.setPositiontime(String.valueOf(map.get("watchtime")));
//						}
//						if(map.get("address")!=null){
//							info.setAddress(String.valueOf(map.get("address")));
//						}
//					}
//					
//				}else{
//					//rfid
//					
//				}
//			}
//			
//		}
		
		result.setData(pInfos);
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	/**
	 * 根据ids查询用户信息和描述
	 */
	@RequestMapping("getdescbyids.do")
	@ResponseBody
	public Result getUserInfoDescByIds(@RequestBody UserInfoQuery queryInfo){
		Result result = new Result();
		Object[][] ids = queryInfo.getIds();
		if(ids.length==0){
			result.setState(true);
			result.setData(new ArrayList<UserInfo>());
			result.setMessage("查询成功");
			return result;
		}else{
			result.setCount(userServer.getUserCountByIds(queryInfo));
			List<UserInfo> infos = userServer.getUserInfoByIds(queryInfo);
			
			for(UserInfo info:infos){
				for(Object[] id:ids){
//					int id0 = (int)id[0];
//					 role = (long)id0;
					String role = id[0].toString();
					int id1 = (int)id[1];
					Long rid = (long)id1;
					String name = id[2].toString();
					if(info.getRole().equals(role)&&info.getRid()==rid){
						info.setDescribe(name);
						continue;
					}
				}
				
//				if(info.getEquiptype()!=null&&info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
//					if(info.getEquiptype()==0){
//						//手表
//						String imei = info.getEquipnumber();
//						Map<String,Object> map = userServer.getwatchgpsByImei(imei);
//						if(map!=null){
//							if(map.get("date")!=null&&map.get("time")!=null){
//								StringBuffer sb = new StringBuffer(String.valueOf(map.get("date")));
//								sb.insert(6, "-");
//								sb.insert(4, "-");
//								String positiontime = sb.toString();
//								sb = new StringBuffer(String.valueOf(map.get("time")));
//								sb.insert(4, ":");
//								sb.insert(2, ":");
//								positiontime = positiontime + " " + sb.toString();
//								info.setPositiontime(positiontime);
//							}
//							
//							if(map.get("longitude")!=null){
//								info.setxLoc(String.valueOf(map.get("longitude")));
//							}
//							if(map.get("latitude")!=null){
//								info.setyLoc(String.valueOf(map.get("latitude")));
//							}
//							if(map.get("altitude")!=null){
//								info.setAltitude(String.valueOf(map.get("altitude")));
//							}
//							if(map.get("address")!=null){
//								info.setAddress(String.valueOf(map.get("address")));
//							}
//							if(map.get("elec")!=null){
//								info.setElec(String.valueOf(map.get("elec")));
//							}
//						}
//						
//						Map<String,Object> hmap = userServer.getwatchheartByImei(imei);
//						if(hmap!=null&&hmap.get("heartrate")!=null){
//							info.setHeartRate((int)hmap.get("heartrate"));
//						}
//						
//					}else if(info.getEquiptype()==1){
//						//安全帽
//						String imei = info.getEquipnumber();
//						Map<String,Object> map = userServer.getwatchdataByImei(imei);
//						if(map!=null){
//							if(map.get("xloc")!=null){
//								info.setxLoc(String.valueOf(map.get("xloc")));
//							}
//							if(map.get("yloc")!=null){
//								info.setyLoc(String.valueOf(map.get("yloc")));
//							}
//							if(map.get("watchdate")!=null){
//								info.setPositiontime(String.valueOf(map.get("watchdate")));
//							}
//							if(map.get("address")!=null){
//								info.setAddress(String.valueOf(map.get("address")));
//							}
//							if(map.get("bat")!=null){
//								info.setElec(String.valueOf(map.get("bat")));
//							}
//						}
//						
//						
//					}else if(info.getEquiptype()==2){
//						//app
//						String imei = info.getPhonenumber();
//						Map<String,Object> map = userServer.getappdataByImei(imei);
//						if(map!=null){
//							if(map.get("xloc")!=null){
//								info.setxLoc(String.valueOf(map.get("xloc")));
//							}
//							if(map.get("yloc")!=null){
//								info.setyLoc(String.valueOf(map.get("yloc")));
//							}
//							if(map.get("watchtime")!=null){
//								info.setPositiontime(String.valueOf(map.get("watchtime")));
//							}
//							if(map.get("address")!=null){
//								info.setAddress(String.valueOf(map.get("address")));
//							}
//						}
//						
//					}else{
//						//rfid
//						
//					}
////					infoss.add(info);
//				}
				
			}
			result.setData(infos);
			result.setState(true);
			result.setMessage("查询成功");
			
		}
		return result;
	}
	
	/**
	 * 根据role和rid查询用户信息和描述
	 * @param ids
	 * @return
	 */
	@RequestMapping("getdescbyroleid.do")
	@ResponseBody
	public Result getUserInfoDescByRoleAndRid(@RequestBody UserInfoQuery queryInfo){
		Result result = new Result();
		List<UserInfo> infoss = new ArrayList<UserInfo>();
		if(queryInfo.getPage()==null){
			queryInfo.setPage(0L);
		}
		Object[][] ids = queryInfo.getIds();
		for (Object[] id : ids) {
			int id0 = (int)id[0];
			Long role = (long)id0;
			int id1 = (int)id[1];
			Long rid = (long)id1;
			String name = id[2].toString();
			List<UserInfo> infos = userServer.getUserInfoByRoleAndRidAndInfo(role, rid, queryInfo.getInfo());
			for (UserInfo info : infos) {
				info.setDescribe(name);
				if(info.getEquiptype()!=null&&info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
					if(info.getEquiptype()==0){
						//手表
						String imei = info.getEquipnumber();
						Map<String,Object> map = userServer.getwatchgpsByImei(imei);
						if(map!=null){
							if(map.get("date")!=null&&map.get("time")!=null){
								StringBuffer sb = new StringBuffer(String.valueOf(map.get("date")));
								sb.insert(6, "-");
								sb.insert(4, "-");
								String positiontime = sb.toString();
								sb = new StringBuffer(String.valueOf(map.get("time")));
								sb.insert(4, ":");
								sb.insert(2, ":");
								positiontime = positiontime + " " + sb.toString();
								info.setPositiontime(positiontime);
							}
							
							if(map.get("longitude")!=null){
								info.setxLoc(String.valueOf(map.get("longitude")));
							}
							if(map.get("latitude")!=null){
								info.setyLoc(String.valueOf(map.get("latitude")));
							}
							if(map.get("altitude")!=null){
								info.setAltitude(String.valueOf(map.get("altitude")));
							}
							if(map.get("address")!=null){
								info.setAddress(String.valueOf(map.get("address")));
							}
							if(map.get("elec")!=null){
								info.setElec(String.valueOf(map.get("elec")));
							}
						}
						
						Map<String,Object> hmap = userServer.getwatchheartByImei(imei);
						if(hmap!=null&&hmap.get("heartrate")!=null){
							info.setHeartRate((int)hmap.get("heartrate"));
						}
						
					}else if(info.getEquiptype()==1){
						//安全帽
						String imei = info.getEquipnumber();
						Map<String,Object> map = userServer.getwatchdataByImei(imei);
						if(map!=null){
							if(map.get("xloc")!=null){
								info.setxLoc(String.valueOf(map.get("xloc")));
							}
							if(map.get("yloc")!=null){
								info.setyLoc(String.valueOf(map.get("yloc")));
							}
							if(map.get("watchdate")!=null){
								info.setPositiontime(String.valueOf(map.get("watchdate")));
							}
							if(map.get("address")!=null){
								info.setAddress(String.valueOf(map.get("address")));
							}
							if(map.get("bat")!=null){
								info.setElec(String.valueOf(map.get("bat")));
							}
						}
						
						
					}else if(info.getEquiptype()==2){
						//app
						String imei = info.getPhonenumber();
						Map<String,Object> map = userServer.getappdataByImei(imei);
						if(map!=null){
							if(map.get("xloc")!=null){
								info.setxLoc(String.valueOf(map.get("xloc")));
							}
							if(map.get("yloc")!=null){
								info.setyLoc(String.valueOf(map.get("yloc")));
							}
							if(map.get("watchtime")!=null){
								info.setPositiontime(String.valueOf(map.get("watchtime")));
							}
							if(map.get("address")!=null){
								info.setAddress(String.valueOf(map.get("address")));
							}
						}
						
					}else{
						//rfid
						
					}
					infoss.add(info);
				}
				
			}
		}
		List<UserInfo> resultList = new ArrayList<UserInfo>();
		for(long i=queryInfo.getPage()*10;i<queryInfo.getPage()*10+10;i++){
			if(i>=infoss.size()){
				break;
			}
			resultList.add(infoss.get((int)i));
		}
		result.setData(resultList);
		result.setCount((long)infoss.size());
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	
	@RequestMapping("getwarninguserinfos.do")
	@ResponseBody
	public Result getWarningUserInfos(@RequestBody UserInfo info){
		Result result = new Result();
		String role = info.getRole();
		List<UserInfo> infos = new ArrayList<UserInfo>();
		List<UserInfo> rinfos = new ArrayList<UserInfo>();
		if("4".equals(role)){
			infos = userServer.getUserInfoForRole(info);
		}else if("3".equals(role)){
			infos = new ArrayList<UserInfo>();
			List<UserInfo> role3s = userServer.getUserInfoForRole(info);
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
			List<UserInfo> role4s = userServer.getUserInfoFromCorrelation(4L, info.getId());
			for (UserInfo role4 : role4s) {
				infos.add(role4);
			}
		}else if("2".equals(role)){
			infos = new ArrayList<UserInfo>();
			List<UserInfo> role2s = userServer.getUserInfoForRole(info);
			for (UserInfo role2 : role2s) {
				infos.add(role2);
			}
			List<UserInfo> role3s = userServer.getUserInfoFromCorrelation(3L, info.getId());
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
//			for (UserInfo role3 : role3s) {
			List<UserInfo> role4s = userServer.getUserInfoForRole(info);
			for (UserInfo role4 : role4s) {
				infos.add(role4);
			}
//			}
			
		}else if("1".equals(role)){
			infos = new ArrayList<UserInfo>();
			List<UserInfo> role1s = userServer.getUserInfoForRole(info);
			for (UserInfo role1 : role1s) {
				infos.add(role1);
			}
			List<UserInfo> role2s = userServer.getUserInfoOfRole2FromRole1(info);
			for (UserInfo role2 : role2s) {
				infos.add(role2);
			}
			List<UserInfo> role3s = userServer.getUserInfoOfRole3FromRole1(info);
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
			List<UserInfo> role4s = userServer.getUserInfoOfRole4FromRole1(info);
			for (UserInfo role4 : role4s) {
				infos.add(role4);
			}
		}else if("0".equals(role)){
			infos = userServer.getUserInfoFromRole0(info);
		}
		for(UserInfo uinfo:infos){
			if(uinfo.getEquiptype()!=null&&uinfo.getEquiptype()==0){
				String imei = uinfo.getEquipnumber();
				if(imei!=null&&!imei.isEmpty()){
					Map<String,Object> wmap = userServer.getwatchwarningByImei(imei);
					if(wmap!=null){
						if(wmap.get("datecreated")!=null){
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
							String date = sdf.format(wmap.get("datecreated"));
							sdf = new SimpleDateFormat("HHmmss");
							String time = sdf.format(wmap.get("datecreated"));
							sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							uinfo.setWarningDate(sdf.format(wmap.get("datecreated")));
							
							Map<String,Object> gpsmap = userServer.getwatchgpsByImeiAndDateTime(imei, date, time);
							if(gpsmap!=null){
								if(gpsmap.get("longitude")!=null){
									uinfo.setxLoc(String.valueOf(gpsmap.get("longitudeconv")));
								}
								if(gpsmap.get("latitude")!=null){
									uinfo.setyLoc(String.valueOf(gpsmap.get("latitudeconv")));
								}
								if(gpsmap.get("altitude")!=null){
									uinfo.setAltitude(String.valueOf(gpsmap.get("altitude")));
								}
								if(gpsmap.get("address")!=null){
									uinfo.setAddress(String.valueOf(gpsmap.get("address")));
								}
								if(gpsmap.get("elec")!=null){
									uinfo.setElec(String.valueOf(gpsmap.get("elec")));
								}
							}
							
							Map<String,Object> hmap = userServer.getwatchheartByImei(imei);
							if(hmap!=null&&hmap.get("heartrate")!=null){
								uinfo.setHeartRate((int)hmap.get("heartrate"));
							}
						}
						
						if(wmap.get("type")!=null){
							uinfo.setType((int)wmap.get("type"));
						}
						
						if(wmap.get("typeStr")!=null){
							uinfo.setTypeStr(String.valueOf(wmap.get("typeStr")));
						}
						
						rinfos.add(uinfo);
						
					}
					
				}
			}
		}
		
		result.setData(rinfos);
		
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	
	
	@RequestMapping("getwarninglist.do")
	@ResponseBody
	public Result getWarningList(@RequestBody UserInfo info){
		Result result = new Result();
		String role = info.getRole();
		List<UserInfo> infos = new ArrayList<UserInfo>();
		
		if("4".equals(role)){
			infos = userServer.getUserInfoForRole(info);
		}else if("3".equals(role)){
			infos = new ArrayList<UserInfo>();
			List<UserInfo> role3s = userServer.getUserInfoForRole(info);
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
			List<UserInfo> role4s = userServer.getUserInfoFromCorrelation(4L, info.getId());
			for (UserInfo role4 : role4s) {
				infos.add(role4);
			}
		}else if("2".equals(role)){
			infos = new ArrayList<UserInfo>();
			List<UserInfo> role2s = userServer.getUserInfoForRole(info);
			for (UserInfo role2 : role2s) {
				infos.add(role2);
			}
			List<UserInfo> role3s = userServer.getUserInfoFromCorrelation(3L, info.getId());
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
//			for (UserInfo role3 : role3s) {
			List<UserInfo> role4s = userServer.getUserInfoForRole(info);
			for (UserInfo role4 : role4s) {
				infos.add(role4);
			}
//			}
			
		}else if("1".equals(role)){
			infos = new ArrayList<UserInfo>();
			List<UserInfo> role1s = userServer.getUserInfoForRole(info);
			for (UserInfo role1 : role1s) {
				infos.add(role1);
			}
			List<UserInfo> role2s = userServer.getUserInfoOfRole2FromRole1(info);
			for (UserInfo role2 : role2s) {
				infos.add(role2);
			}
			List<UserInfo> role3s = userServer.getUserInfoOfRole3FromRole1(info);
			for (UserInfo role3 : role3s) {
				infos.add(role3);
			}
			List<UserInfo> role4s = userServer.getUserInfoOfRole4FromRole1(info);
			for (UserInfo role4 : role4s) {
				infos.add(role4);
			}
		}else if("0".equals(role)){
			infos = userServer.getUserInfoFromRole0(info);
		}
		List<UserInfo> rinfos = new ArrayList<UserInfo>();
		for(UserInfo uinfo:infos){
			if(uinfo.getEquiptype()!=null&&uinfo.getEquiptype()==0){
				String imei = uinfo.getEquipnumber();
				if(imei!=null&&!imei.isEmpty()){
//					Map<String,Object> wmap = userServer.getwatchwarningByImei(imei);
					List<WatchWarning> wwinfos = userServer.getwatchwarningByDate(info.getStartdate(), info.getEnddate(), imei);
					for(WatchWarning winfo:wwinfos){
						UserInfo wuinfo = new UserInfo();
//						wuinfo = uinfo;
//						wuinfo.setElec("");
//						wuinfo.setType(11);
//						wuinfo.setTypeStr("");
//						wuinfo.setHeartRate(null);
//						wuinfo.setWarningDate("");
						
						wuinfo.setId(uinfo.getId());
						wuinfo.setName(uinfo.getName());
						wuinfo.setPhonenumber(uinfo.getPhonenumber());
						wuinfo.setEquipnumber(uinfo.getEquipnumber());
						wuinfo.setWorktype(uinfo.getWorktype());
						wuinfo.setWorktypeStr(uinfo.getWorktypeStr());
						
						wuinfo.setWarningDate(winfo.getDateCreated());
//						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//						String date = sdf.format(new Timestamp(winfo.getDateCreated()));
//						sdf = new SimpleDateFormat("HHmmss");
//						String time = sdf.format(winfo.getDateCreated());
//						sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String datecreated = winfo.getDateCreated();
						datecreated = datecreated.replace("-", ":");
						datecreated = datecreated.replace(":", "");
						String date = datecreated.substring(0,datecreated.indexOf(" "));
						String time = datecreated.substring(datecreated.indexOf(" ")+1);
						
						wuinfo.setType(winfo.getType());
						wuinfo.setTypeStr(winfo.getTypeStr());
						
						Map<String,Object> gpsmap = userServer.getwatchgpsByImeiAndDateTime(imei, date, time);
						if(gpsmap!=null){
							if(gpsmap.get("longitude")!=null){
								wuinfo.setxLoc(String.valueOf(gpsmap.get("longitudeconv")));
							}
							if(gpsmap.get("latitude")!=null){
								wuinfo.setyLoc(String.valueOf(gpsmap.get("latitudeconv")));
							}
							if(gpsmap.get("altitude")!=null){
								wuinfo.setAltitude(String.valueOf(gpsmap.get("altitude")));
							}
							if(gpsmap.get("address")!=null){
								wuinfo.setAddress(String.valueOf(gpsmap.get("address")));
							}
							if(gpsmap.get("elec")!=null){
								wuinfo.setElec(String.valueOf(gpsmap.get("elec")));
							}
						}
						
						Map<String,Object> hmap = userServer.getwatchheartByImei(imei);
						if(hmap!=null&&hmap.get("heartrate")!=null){
							wuinfo.setHeartRate((int)hmap.get("heartrate"));
						}
						
						rinfos.add(wuinfo);
						
					}
						
				}
			}
		}
		
		List<UserInfo> resultinfo = new ArrayList<UserInfo>();
		int page = info.getPage();
		for(int i=page*10;i<(page+1)*10;i++){
			resultinfo.add(rinfos.get(i));
			if(i==rinfos.size()-1){
				break;
			}
		}
		result.setData(resultinfo);
		result.setCount((long)rinfos.size());
		
		result.setState(true);
		result.setMessage("查询成功");
		return result;
	}
	
	
	/**
	 * 位置分析统计
	 */
	@RequestMapping("getuserinfoandposition")
	@ResponseBody
	public Result getUserInfoAndPosition(@RequestBody UserInfoQuery info){
		Result result = new Result();
		result = userServer.getUserInfoAndPosition(info);
		return result;
	}
	
	/**
	 * 查询出勤人数
	 */
	@RequestMapping("getshouldworkuser")
	@ResponseBody
	public Result getShouldWorkUser(Long id,Long role){
		Result result = new Result();
		List<UserInfo> infos = new ArrayList<UserInfo>();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		if(role==1){
			infos = userServer.getShouldWorkUser(map);
		}else if(role==2){
			infos = userServer.getShouldWorkUserFromCompany(map);
		}else if(role==3){
			infos = userServer.getShouldWorkUserFromSection(map);
		}else if(role==4){
			infos = userServer.getShouldWorkUserFromProject(map);
		}else{
			
		}
		
		//应到人数
		Map<String,Object> countMap = new HashMap<String,Object>();
		if(infos!=null){
			countMap.put("shouldcount", infos.size());
			
			//获取出勤人数
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("infos", infos);
			Long count = userServer.getActWorkCount(paramMap);
			countMap.put("workcount", count);
			
			//获取迟到人数
//			paramMap = new HashMap<String,Object>();
//			paramMap.put("infos", infos);
//			paramMap.put("date", new Date());
//			Long laterCount = userServer.getlateWorkCount(paramMap);
//			countMap.put("latercount", laterCount);
		}else{
			//应出勤人数
			countMap.put("shouldcount", 0);
			
			//实际出勤人数
			countMap.put("workcount", 0);
			
			//迟到人数
//			countMap.put("latercount", 0);
		}
		
		
		
		result.setData(countMap);
		result.setState(true);
		result.setMessage("查询成功");
		
		return result;
	}
	

}
