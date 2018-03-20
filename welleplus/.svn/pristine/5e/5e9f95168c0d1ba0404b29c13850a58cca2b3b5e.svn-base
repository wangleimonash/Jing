package com.welleplus.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.Company;
import com.welleplus.entity.Correlation;
import com.welleplus.entity.DownMenuInfo;
import com.welleplus.entity.FirmInfo;
import com.welleplus.entity.Project;
import com.welleplus.entity.Section;
import com.welleplus.entity.TreeInfo;
import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.CompanyServer;
import com.welleplus.server.CorrelationServer;
import com.welleplus.server.FirmServer;
import com.welleplus.server.ProjectServer;
import com.welleplus.server.SectionServer;
import com.welleplus.server.UserServer;

@Controller
@RequestMapping("project")
public class ProjectController {
	@Resource
	private FirmServer firmServer;
	
	@Resource
	private CompanyServer companyServer;
	
	@Resource
	private SectionServer sectionServer;
	
	@Resource
	private ProjectServer projectServer;
	
	@Resource
	private UserServer userServer;
	
	@Resource
	private CorrelationServer cServer;
	
	
	
	//树形结构
	@RequestMapping("gettree.do")
	@ResponseBody
	public List<TreeInfo> getTreeInfos(@RequestBody UserInfo userInfo){
		Long rid = userInfo.getRid();
		String role = userInfo.getRole();
		Long uid = userInfo.getId();
		int id = 1;
//		int pId = 1;
		List<TreeInfo> infos = new ArrayList<TreeInfo>();
//		long fid = 1;
		
		if("0".equals(role)){
			Result result = firmServer.getFirmInfos();
			if(result.getData()!=null){
				List<FirmInfo> firmInfos = (ArrayList<FirmInfo>)result.getData();
				for (FirmInfo firmInfo : firmInfos) {
					TreeInfo info = new TreeInfo();
					info.setId(id);
					info.setName(firmInfo.getName());
					info.setDesc(Integer.parseInt(firmInfo.getGrade()));
					info.setDescId(firmInfo.getId());
					info.setIconOpen("css/zTreeStyle/img/diy/1_open.png");
					info.setIconClose("css/zTreeStyle/img/diy/1_close.png");
					info.setOpen(true);
					infos.add(info);
					
					id++;
					
					result = companyServer.getCompanyInfo(firmInfo.getId());
					if(result.getData()!=null){
						int pId = id - 1;
						List<Company> companys = (ArrayList<Company>)result.getData();
						for (Company company : companys) {
							TreeInfo cInfo = new TreeInfo();
							cInfo.setName(company.getName());
							cInfo.setDesc(Integer.parseInt(company.getGrade()));
							cInfo.setDescId(company.getId());
							cInfo.setId(id);
							cInfo.setpId(pId);
							cInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
							cInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
							cInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
							infos.add(cInfo);
							
//							pId = id;
							id++;
							result = sectionServer.getSectionInfo(company.getId());
							if(result.getData()!=null){
								int sid = id-1;
								List<Section> sections = (ArrayList<Section>)result.getData();
								for (Section section : sections) {
									TreeInfo sInfo = new TreeInfo();
									sInfo.setName(section.getName());
									sInfo.setDesc(Integer.parseInt(section.getGrade()));
									sInfo.setDescId(section.getId());
									sInfo.setId(id);
									sInfo.setpId(sid);
									sInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
									sInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
									sInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
									infos.add(sInfo);
									id++;
									
									result = projectServer.getProjectInfo(section.getId());
									if(result.getData()!=null){
										int prid = id-1;
										List<Project> projects = (ArrayList<Project>)result.getData();
										for (Project project : projects) {
											TreeInfo pInfo = new TreeInfo();
											pInfo.setName(project.getName());
											pInfo.setDesc(Integer.parseInt(project.getGrade()));
											pInfo.setDescId(project.getId());
											pInfo.setId(id);
											pInfo.setpId(prid);
											pInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
											pInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
											pInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
											infos.add(pInfo);
											id++;
										}
									}
									
								}
							}
							
							
							
						}
					}
					
				}
			}
		}else if("1".equals(role)){
			Result result = firmServer.getFirmInfo(rid);
			if(result.getData()!=null){
//				List<FirmInfo> firmInfos = (ArrayList<FirmInfo>)result.getData();
//				for (FirmInfo firmInfo : firmInfos) {
//					TreeInfo info = new TreeInfo();
//					info.setId(id);
//					info.setName(firmInfo.getName());
//					info.setDesc(Integer.parseInt(firmInfo.getGrade()));
//					info.setDescId(firmInfo.getId());
//					infos.add(info);
//					
//					id++;
					
					TreeInfo info = new TreeInfo();
					info.setId(id);
					FirmInfo firmInfo = (FirmInfo)result.getData();
					info.setName(firmInfo.getName());
					info.setDesc(Integer.parseInt(firmInfo.getGrade()));
					info.setDescId(firmInfo.getId());
					info.setIconOpen("css/zTreeStyle/img/diy/1_open.png");
					info.setIconClose("css/zTreeStyle/img/diy/1_close.png");
					info.setOpen(true);
					infos.add(info);
					id++;
					
					result = companyServer.getCompanyInfo(firmInfo.getId());
					if(result.getData()!=null){
						int pId = id - 1;
						List<Company> companys = (ArrayList<Company>)result.getData();
						for (Company company : companys) {
							TreeInfo cInfo = new TreeInfo();
							cInfo.setName(company.getName());
							cInfo.setDesc(Integer.parseInt(company.getGrade()));
							cInfo.setDescId(company.getId());
							cInfo.setId(id);
							cInfo.setpId(pId);
							cInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
							cInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
							cInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
							infos.add(cInfo);
							
//							pId = id;
							id++;
							result = sectionServer.getSectionInfo(company.getId());
							if(result.getData()!=null){
								int sid = id-1;
								List<Section> sections = (ArrayList<Section>)result.getData();
								for (Section section : sections) {
									TreeInfo sInfo = new TreeInfo();
									sInfo.setName(section.getName());
									sInfo.setDesc(Integer.parseInt(section.getGrade()));
									sInfo.setDescId(section.getId());
									sInfo.setId(id);
									sInfo.setpId(sid);
									sInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
									sInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
									sInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
									
									infos.add(sInfo);
									id++;
									
									result = projectServer.getProjectInfo(section.getId());
									if(result.getData()!=null){
										int prid = id-1;
										List<Project> projects = (ArrayList<Project>)result.getData();
										for (Project project : projects) {
											TreeInfo pInfo = new TreeInfo();
											pInfo.setName(project.getName());
											pInfo.setDesc(Integer.parseInt(project.getGrade()));
											pInfo.setDescId(project.getId());
											pInfo.setId(id);
											pInfo.setpId(prid);
											pInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
											pInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
											pInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
											infos.add(pInfo);
											id++;
										}
									}
									
								}
							}
							
						}
					}
					
				}
//			}
		}else if("2".equals(role)){
			Result result = new Result();
			
			result = companyServer.getCompanyInfoForId(rid);
			
			Company company = (Company)result.getData();
			Long fid = company.getFid();
			Result fResult = firmServer.getFirmInfo((long)fid);
			TreeInfo fInfo = new TreeInfo();
			fInfo.setId(id);
			FirmInfo firmInfo = (FirmInfo)fResult.getData();
			fInfo.setDesc(Integer.parseInt(firmInfo.getGrade()));
			fInfo.setName(firmInfo.getName());
			fInfo.setDescId(firmInfo.getId());
			fInfo.setIconOpen("css/zTreeStyle/img/diy/1_open.png");
			fInfo.setIconClose("css/zTreeStyle/img/diy/1_close.png");
			fInfo.setOpen(true);
			infos.add(fInfo);
			id++;
			
			TreeInfo tInfo = new TreeInfo();
			tInfo.setId(id);
			tInfo.setName(company.getName());
			tInfo.setDesc(Integer.parseInt(company.getGrade()));
			tInfo.setDescId(company.getId());
			tInfo.setpId(id-1);
			tInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
			tInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
			tInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
			tInfo.setOpen(true);
			infos.add(tInfo);
			id++;
			
			Correlation info = new Correlation();
			info.setUid(uid);
			info.setGrade(3L);
			result = cServer.getCorrelationInfo(info);
			if(result.getData()!=null){
				int sid = id-1;
				List<Correlation> cInfos = (ArrayList<Correlation>)result.getData();
				for (Correlation correlation : cInfos) {
					result = sectionServer.getSectionInfoForId(correlation.getGradeid());
//					result = sectionServer.getSectionAsMap(correlation.getGradeid(), company.getId());
					if(result.getData()!=null){
						TreeInfo seInfo = new TreeInfo();
						seInfo.setId(id);
						Section section = (Section)result.getData();
						seInfo.setName(section.getName());
						seInfo.setDesc(Integer.parseInt(section.getGrade()));
						seInfo.setDescId(section.getId());
						seInfo.setpId(sid);
						seInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
						seInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
						seInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
						infos.add(seInfo);
						id++;
						
						result = projectServer.getProjectInfo(section.getId());
						if(result.getData()!=null){
							int prid = id-1;
							List<Project> projects = (ArrayList<Project>)result.getData();
							for (Project project : projects) {
								TreeInfo pInfo = new TreeInfo();
								pInfo.setName(project.getName());
								pInfo.setDesc(Integer.parseInt(project.getGrade()));
								pInfo.setDescId(project.getId());
								pInfo.setId(id);
								pInfo.setpId(prid);
								pInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
								pInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
								pInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
								infos.add(pInfo);
								id++;
							}
						}
					}
					
					
				}
			}
			
		}else if("3".equals(role)){
			Result result = new Result();
			
			result = sectionServer.getSectionInfoForId(rid);
			
			Section section = (Section)result.getData();
			Long cid = section.getCid();
			Result coResult = companyServer.getCompanyInfoForId(cid);
			Company company = (Company)coResult.getData();
			Long fid = company.getFid();
			Result fResult = firmServer.getFirmInfo((long)fid);
			FirmInfo firmInfo = (FirmInfo)fResult.getData();
			TreeInfo fInfo = new TreeInfo();
			fInfo.setId(id);
			fInfo.setName(firmInfo.getName());
			fInfo.setDesc(Integer.parseInt(firmInfo.getGrade()));
			fInfo.setDescId(firmInfo.getId());
			fInfo.setIconOpen("css/zTreeStyle/img/diy/1_open.png");
			fInfo.setIconClose("css/zTreeStyle/img/diy/1_close.png");
			fInfo.setOpen(true);
			infos.add(fInfo);
			id++;
			
			TreeInfo cInfo = new TreeInfo();
			cInfo.setId(id);
			cInfo.setName(company.getName());
			cInfo.setDesc(Integer.parseInt(company.getGrade()));
			cInfo.setDescId(company.getId());
			cInfo.setpId(id-1);
			cInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
			cInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
			cInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
			cInfo.setOpen(true);
			infos.add(cInfo);
			id++;
			
			TreeInfo sInfo = new TreeInfo();
			sInfo.setId(id);
			sInfo.setName(section.getName());
			sInfo.setDesc(Integer.parseInt(section.getGrade()));
			sInfo.setDescId(section.getId());
			sInfo.setpId(id-1);
			sInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
			sInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
			sInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
			sInfo.setOpen(true);
			infos.add(sInfo);
			id++;
			
			Correlation info = new Correlation();
			info.setUid(uid);
			info.setGrade(4L);
			result = cServer.getCorrelationInfo(info);
			if(result.getData()!=null){
				int pid = id-1;
				List<Correlation> cInfos = (ArrayList<Correlation>)result.getData();
				for (Correlation correlation : cInfos) {
					result = projectServer.getProjectInfoForId(correlation.getGradeid());
//					result = projectServer.getProjectInfoAsMap(correlation.getGradeid(), section.getId());
					Project project = (Project)result.getData();
					TreeInfo pInfo = new TreeInfo();
					pInfo.setId(id);
					pInfo.setName(project.getName());
					pInfo.setDesc(Integer.parseInt(project.getGrade()));
					pInfo.setDescId(project.getId());
					pInfo.setpId(pid);
					pInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
					pInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
					pInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
					infos.add(pInfo);
				}
			}
		}else if("4".equals(role)){
			Result result = new Result();
			result = projectServer.getProjectInfoForId(rid);
			Project project = (Project)result.getData();
			
			Long sid = project.getSid();
			result = sectionServer.getSectionInfoForId(sid);
			Section section = (Section)result.getData();
			
			Long cid = section.getCid();
			result = companyServer.getCompanyInfoForId(cid);
			Company company = (Company)result.getData();
			
			Long fid = company.getFid();
			result = firmServer.getFirmInfo(fid);
			FirmInfo firm = (FirmInfo)result.getData();
			
			TreeInfo fInfo = new TreeInfo();
			fInfo.setId(id);
			fInfo.setName(firm.getName());
			fInfo.setDesc(1);
			fInfo.setDescId(firm.getId());
			fInfo.setIconOpen("css/zTreeStyle/img/diy/1_open.png");
			fInfo.setIconClose("css/zTreeStyle/img/diy/1_close.png");
			fInfo.setOpen(true);
			id++;
			infos.add(fInfo);
			
			TreeInfo cInfo = new TreeInfo();
			cInfo.setId(id);
			cInfo.setpId(id-1);
			cInfo.setName(company.getName());
			cInfo.setDesc(2);
			cInfo.setDescId(company.getId());
			cInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
			cInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
			cInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
			cInfo.setOpen(true);
			id++;
			infos.add(cInfo);
			
			TreeInfo sInfo = new TreeInfo();
			sInfo.setId(id);
			sInfo.setpId(id-1);
			sInfo.setName(section.getName());
			sInfo.setDesc(3);
			sInfo.setDescId(section.getId());
			sInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
			sInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
			sInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
			sInfo.setOpen(true);
			id++;
			infos.add(sInfo);
			
			TreeInfo pInfo = new TreeInfo();
			pInfo.setId(id);
			pInfo.setpId(id-1);
			pInfo.setName(project.getName());
			pInfo.setDesc(4);
			pInfo.setDescId(project.getId());
			pInfo.setIconOpen("css/zTreeStyle/img/diy/10_open.png");
			pInfo.setIconClose("css/zTreeStyle/img/diy/10_close.png");
			pInfo.setIcon("css/zTreeStyle/img/diy/10_close.png");
			pInfo.setOpen(true);
			infos.add(pInfo);
			
		}else{
			
		}
		
		
			
//			TreeInfo info = new TreeInfo();
//			info.setId(id);
//			FirmInfo firmInfo = (FirmInfo)result.getData();
//			info.setName(firmInfo.getName());
//			info.setDesc(Integer.parseInt(firmInfo.getGrade()));
//			info.setDescId(firmInfo.getId());
//			infos.add(info);
//			id++;
			
			
			
		
		
		return infos;
	}
	
	//添加项目组
	@RequestMapping("addinfo.do")
	@ResponseBody
	public Result addProjectInfo(@RequestBody Project info){
		Result result = new Result();
		info.setCreatDate(new Timestamp(System.currentTimeMillis()));
		result = projectServer.addProjectInfo(info);
		return result;
	}
	
	//获取下级信息
	@RequestMapping("getdownmenu.do")
	@ResponseBody
	public Result getDownMenu(Long desc,Long descId,Long role,Long id,Long rid){
		Result result = new Result();
		List<DownMenuInfo> infos = new ArrayList<DownMenuInfo>();
		if(desc==null||descId==null){
			result.setState(false);
			result.setMessage("参数为空");
			return result;
		}
		
		switch (desc.intValue()) {
		case 1:
			if(role==1L || role==0L){
				result = companyServer.getCompanyInfo(descId);
				List<Company> companys = (ArrayList<Company>)result.getData();
				Long rcount = userServer.getCountFromRoleAndRid(1L, descId).getId();
				result.setCount(rcount);
				for (Company company : companys) {
					DownMenuInfo info = new DownMenuInfo();
					info.setId(company.getId());
					info.setName(company.getName());
					info.setGrade((long)2);
					
					Long count = userServer.getCountFromRoleAndRid(2L, company.getId()).getId();
					info.setCount(count);
					
					infos.add(info);
				}
				result.setData(infos);
			}else if(role==2L){
				result = companyServer.getCompanyInfoForId(rid);
				result.setCount(0L);
				Company company = (Company)result.getData();
				DownMenuInfo info = new DownMenuInfo();
				info.setId(company.getId());
				info.setName(company.getName());
				info.setGrade(2L);
				Long count = userServer.getCountFromRoleAndRid(2L, company.getId()).getId();
				info.setCount(count);
				
				infos.add(info);
				
				result.setData(infos);
			}else if(role==3L){
				result = sectionServer.getSectionInfoForId(rid);
				result.setCount(0L);
				Section section = (Section)result.getData();
				Long cId = section.getCid();
				
				result = companyServer.getCompanyInfoForId(cId);
				Company company = (Company)result.getData();
				DownMenuInfo info = new DownMenuInfo();
				info.setId(company.getId());
				info.setName(company.getName());
				info.setGrade(2L);
				info.setCount(0L);
				
				infos.add(info);
				
				result.setData(infos);
			}else{
				result.setData(null);
				result.setCount(0L);
			}
			
			break;
			
		case 2:
			if(role==1L || role==0L){
				result = sectionServer.getSectionInfo(descId);
				Long rcount = userServer.getCountFromRoleAndRid(2L, descId).getId();
				result.setCount(rcount);
				if(result.getData()!=null){
					List<Section> sections = (ArrayList<Section>)result.getData();
					for (Section section : sections) {
						DownMenuInfo info = new DownMenuInfo();
						info.setId(section.getId());
						info.setName(section.getName());
						info.setGrade((long)3);
						Long count = userServer.getCountFromRoleAndRid(3L, section.getId()).getId();
						info.setCount(count);
						
						infos.add(info);
					}
					result.setData(infos);
				}else{
					result.setData(null);
				}
				
			}else if(role == 2L){
				Correlation cInfo = new Correlation();
				cInfo.setUid(id);
				cInfo.setGrade(3L);
				result = cServer.getCorrelationInfo(cInfo);
				Long rcount = userServer.getCountFromRoleAndRid(2L, descId).getId();
				result.setCount(rcount);
				if(result.getData()!=null){
					List<Correlation> cInfos = (ArrayList<Correlation>)result.getData();
					for (Correlation correlation : cInfos) {
						result = sectionServer.getSectionInfoForId(correlation.getGradeid());
						Section section = (Section)result.getData();
						DownMenuInfo info = new DownMenuInfo();
						info.setId(section.getId());
						info.setName(section.getName());
						info.setGrade(3L);
						Long count = userServer.getCountFromRoleAndRid(3L, section.getId()).getId();
						info.setCount(count);
						
						infos.add(info);
					}
					
					result.setData(infos);
				}else{
					result.setData(null);
				}
			}else if(role == 3L){
				result = sectionServer.getSectionInfoForId(rid);
				result.setCount(0L);
				Section section = (Section)result.getData();
				DownMenuInfo info = new DownMenuInfo();
				info.setId(section.getId());
				info.setName(section.getName());
				info.setGrade(3L);
				Long count = userServer.getCountFromRoleAndRid(3L, section.getId()).getId();
				info.setCount(count);
				
				infos.add(info);
				
				result.setData(infos);
			}else{
				result.setData(null);
				result.setCount(0L);
			}
			
			break;
			
		case 3:
			if(role == 1L || role == 2L || role == 0L){
				result = projectServer.getProjectInfo(descId);
				Long rcount = userServer.getCountFromRoleAndRid(3L, descId).getId();
				result.setCount(rcount);
				List<Project> projects = (ArrayList<Project>)result.getData();
				for (Project project : projects) {
					DownMenuInfo info = new DownMenuInfo();
					info.setId(project.getId());
					info.setName(project.getName());
					info.setGrade((long)4);
					Long count = userServer.getCountFromRoleAndRid(4L, project.getId()).getId();
					info.setCount(count);
					
					infos.add(info);
				}
				
				result.setData(infos);
			}else if(role == 3L){
				Correlation cInfo = new Correlation();
				cInfo.setUid(id);
				cInfo.setGrade(4L);
				result = cServer.getCorrelationInfo(cInfo);
				Long rcount = userServer.getCountFromRoleAndRid(3L, descId).getId();
				result.setCount(rcount);
				if(result.getData()!=null){
					List<Correlation> cInfos = (ArrayList<Correlation>)result.getData();
					for (Correlation correlation : cInfos) {
						result = projectServer.getProjectInfoForId(correlation.getGradeid());
						Project project = (Project)result.getData();
						DownMenuInfo info = new DownMenuInfo();
						info.setId(project.getId());
						info.setName(project.getName());
						info.setGrade(4L);
						Long count = userServer.getCountFromRoleAndRid(4L, project.getId()).getId();
						info.setCount(count);
						
						infos.add(info);
					}
					result.setData(infos);
				}
			}else if(role == 4L){
				result = projectServer.getProjectInfoForId(rid);
				Project project = (Project)result.getData();
				result.setCount(0L);
				DownMenuInfo info = new DownMenuInfo();
				info.setId(project.getId());
				info.setName(project.getName());
				info.setGrade(4L);
				Long count = userServer.getCountFromRoleAndRid(4L, project.getId()).getId();
				info.setCount(count);
				
				infos.add(info);
			}
			else{
				result.setData(null);
				result.setCount(0L);
			}
			
			break;
			
		case 4:
			result.setData(null);
			Long rcount = userServer.getCountFromRoleAndRid(4L, descId).getId();
			result.setCount(rcount);
			break;

		default:
			break;
		}
		result.setState(true);
		result.setMessage("查询成功");
		
		return result;
	}
	
	/**
	 * 修改组织名称
	 */
	@RequestMapping("updtetreename.do")
	@ResponseBody
	public Result updateTreeName(Long desc,Long descId,String name){
		Result result = new Result();
		switch (desc.intValue()) {
		case 1:
			result = firmServer.updateFirmName(descId, name);
			break;
		case 2:
			result = companyServer.updateCompanyName(descId, name);
			break;
		case 3:
			result = sectionServer.updateSectionName(descId, name);
			break;
		case 4:
			result = projectServer.updateProjectName(descId, name);
			break;
		default:
			break;
		}
		return result;
	}
	
	/**
	 * 删除treeNode
	 */
	@RequestMapping("deletetreenode.do")
	@ResponseBody
	public Result deleteTreeNode(Long desc,Long descId){
		Result result = new Result();
		switch (desc.intValue()) {
		case 1:
			result = companyServer.getCompanyInfo(descId);
			if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
				result.setState(false);
				result.setMessage("请先删除下级组织");
			}else{
				UserInfo info = new UserInfo();
				info.setRole(String.valueOf(1));
				info.setRid(descId);
				result = userServer.getInfo(info);
				if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
					result.setState(false);
					result.setMessage("请先删除该组织下的人员");
				}else{
					result = firmServer.deleteFirmInfo(descId);
				}
				
			}
			break;
			
		case 2:
			result = sectionServer.getSectionInfo(descId);
			if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
				result.setState(false);
				result.setMessage("请先删除下级组织");
			}else{
				UserInfo info = new UserInfo();
				info.setRole("2");
				info.setRid(descId);
				result = userServer.getInfo(info);
				if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
					result.setState(false);
					result.setMessage("请先删除该组织下的人员");
				}else{
					result = companyServer.deleteCompanyInfo(descId);
					if(result.isState()){
						//删除关联
						//需要回滚
						result = cServer.deleteCorrelationInfo(2L, descId);
					}
				}
			}
			break;
			
		case 3:
			result = projectServer.getProjectInfo(descId);
			if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
				result.setState(false);
				result.setMessage("请先删除下级组织");
			}else{
				UserInfo info = new UserInfo();
				info.setRole("3");
				info.setRid(descId);
				result = userServer.getInfo(info);
				if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
					result.setState(false);
					result.setMessage("请先删除该组织下的人员");
				}else{
					result = sectionServer.deleteSectionInfo(descId);
					if(result.isState()){
						//删除关联
						//需要回滚
						result = cServer.deleteCorrelationInfo(3L, descId);
					}
				}
			}
			break;
			
		case 4:
			UserInfo info = new UserInfo();
			info.setRole("4");
			info.setRid(descId);
			result = userServer.getInfo(info);
			if(result.getData()!=null&&((ArrayList)result.getData()).size()!=0){
				result.setState(false);
				result.setMessage("请先删除该组织下的人员");
			}else{
				result = projectServer.deleteProjectInfo(descId);
				if(result.isState()){
					result = cServer.deleteCorrelationInfo(4L, descId);
				}
			}
			break;

		default:
			break;
		}
		return result;
	}

}
