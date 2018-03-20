package com.welleplus.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welleplus.entity.UserInfo;
import com.welleplus.entity.UserInfoQuery;
import com.welleplus.result.Result;
import com.welleplus.server.UserServer;

@Controller
@RequestMapping("file")
public class UploadController {
	private static String uploadPath = null;// 上传文件的目录  
    private static String tempPath = null; // 临时文件目录  
    private static File uploadFile = null;  
    private static File tempPathFile = null;  
    private static int sizeThreshold = 1024*2000;  
    private static int sizeMax = 5*1024*1024;  
    
    private static int excelSizeThreshold = 1024*1024;
    private static int excelSizeMax = 50*1024*1024;
    
    
  //初始化  
    static{  
          tempPath = "C:/upload/tmp";  
          tempPathFile = new File(tempPath);  
          if (!tempPathFile.exists()) {  
              tempPathFile.mkdirs();  
          }  
    }  
    
    @Resource
    public UserServer userServer;
	
    /**
     * 上传图片
     * @param request
     * @return
     */
    @RequestMapping("uploadfile.do")
    @ResponseBody
	public Result upload(HttpServletRequest request,Long id){
    	Result result = new Result();
    	
    	if(id==null){
    		result.setState(false);
    		result.setMessage("id为空");
    		return result;
    	}
    	
		boolean isMultpart = ServletFileUpload.isMultipartContent(request);
		if(isMultpart){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(sizeThreshold); // 设置缓冲区大小，这里是4kb  
			factory.setRepository(tempPathFile);// 设置缓冲区目录  
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			upload.setSizeMax(sizeMax);
			
			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> itr = items.iterator();
				while(itr.hasNext()){
					FileItem item = (FileItem)itr.next();
					if(!item.isFormField()){
//						long size = item.getSize();
//						System.out.println(size);
						String name = item.getName();
						if(name!=null){
							File fullFile = new File(name);
//							String nameA = item.getFieldName();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date date = new Date();
							String nameA = sdf.format(date);
							String fullFileName = date.getTime()+fullFile.getName();
							
							uploadPath = "C:/upload/file/"+nameA;  
			                  uploadFile = new File(uploadPath);  
			                  if (!uploadFile.exists()) {  
			                      uploadFile.mkdirs();  
			                  }  
			                  if(!fullFile.getName().equals("")){  
			                      File savedFile=new File(uploadPath,fullFileName);  
			                      item.write(savedFile); 
			                      //将文件路径保存到数据库
			                      
			                      result = userServer.updateImgsrc(uploadPath+"/"+fullFileName, id);
			                      
//			                      result.setState(true);
//			                      result.setMessage("保存成功");
			                  }else{  
			                	  
			                  }  
						}
					}
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
    
    /**
     * 显示头像
     * @param response
     */
    @RequestMapping("viewimg")
    @ResponseBody
    public void getImg(HttpServletResponse response,Long id){
//    	String path = "D:/upload/file/imgA/test.png";
    	
    	if(id==null){
    		return;
    	}
    	String path = userServer.getImgsrcById(id);
    	if(path==null||path.isEmpty()){
    		return;
    	}
    	
//    	System.out.println(path);
    	
    	ServletOutputStream sos = null;
    	FileInputStream fis = null;
    	
    	try {
			fis = new FileInputStream(path);
			int i = fis.available();
			byte[] data = new byte[i];
			fis.read(data);
			fis.close();
			
			sos = response.getOutputStream();
			sos.write(data);
			sos.flush();
			sos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    /**
     * excel上传
     */
    @RequestMapping("uploadexcel.do")
    @ResponseBody
    @Transactional(value="transactionManager",rollbackFor=java.lang.Exception.class)
    public Result uploadExcel(HttpServletRequest request,Long desc,Long descId) throws Exception{
    	Result result = new Result();
    	
    	if(desc==null || descId==null){
    		result.setState(false);
    		result.setMessage("请选择所属组织");
    		return result;
    	}
    	
		boolean isMultpart = ServletFileUpload.isMultipartContent(request);
		if(isMultpart){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(excelSizeThreshold); // 设置缓冲区大小，这里是4kb  
			factory.setRepository(tempPathFile);// 设置缓冲区目录  
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			upload.setSizeMax(excelSizeMax);
			
//			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> itr = items.iterator();
				while(itr.hasNext()){
					FileItem item = (FileItem)itr.next();
					if(!item.isFormField()){
						//存储excel解析后的结果
						List<List<String>> infos = new ArrayList<List<String>>();
						
						InputStream is = item.getInputStream();
//						Workbook workbook = new XSSFWorkbook(is);
						Workbook workbook = WorkbookFactory.create(is);
						Sheet sheet = workbook.getSheetAt(0);
						for(int i=1;i<=sheet.getLastRowNum();i++){
							Row row = sheet.getRow(i);
							
//							int minCell = row.getFirstCellNum();
//							int maxCell = row.getLastCellNum();
							
							int minCell = sheet.getRow(0).getFirstCellNum();
							int maxCell = sheet.getRow(0).getLastCellNum();
							List<String> rowList = new ArrayList<String>();
							for(int j=minCell;j<maxCell;j++){
								Cell cell = row.getCell(j);
								if(cell==null){
									rowList.add(null);
								}else{
									rowList.add(cell.toString());
								}
								
							}
							infos.add(rowList);
						}
						
//						List<UserInfo> userInfos = new ArrayList<UserInfo>();
						
						if(infos.size()>0){
							for(List<String> lists:infos){
//								UserInfo userInfo = new UserInfo(lists.get(0),lists.get(1),lists.get(2));
								UserInfo userInfo = new UserInfo();
								String name = lists.get(0);
								if(name==null||name.isEmpty()){
									result.setState(false);
									result.setMessage("姓名不能为空");
									throw new Exception("nameempty");
								}
								userInfo.setName(name);
								
								String phonenumber = lists.get(1);
//								if(phonenumber==null||phonenumber.isEmpty()){
//									throw new Exception();
//								}
								userInfo.setPhonenumber(phonenumber);
								
								String worktype = lists.get(2);
								if(worktype==null||worktype.isEmpty()){
									userInfo.setWorktype(0);
								}else{
									if("农民工".equals(worktype)){
										userInfo.setWorktype(1);
									}else if("安全人员".equals(worktype)){
										userInfo.setWorktype(2);
									}else if("管理人员".equals(worktype)){
										userInfo.setWorktype(3);
									}else{
										userInfo.setWorktype(0);
									}
								}
								
								String equipnumber = lists.get(3);
								if(phonenumber==null||phonenumber.isEmpty()){
									userInfo.setEquipnumber(null);
								}else{
									userInfo.setEquipnumber(equipnumber);
								}
								
								String sex = lists.get(4);
//								if(sex==null||sex.isEmpty()){
//									throw new Exception();
//								}
								
								if(sex!=null&&!sex.isEmpty()){
									if("男".equals(sex.trim())){
										userInfo.setSex("1");
									}else if("女".equals(sex.trim())){
										userInfo.setSex("0");
									}
								}
								
								userInfo.setEquiptype(1);
								userInfo.setRole(String.valueOf(desc));
								userInfo.setRid(descId);
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								userInfo.setCreatdate(sdf.format(new Date()));
								userInfo.setEquipstate(1);
//								userInfo.setWorktype(1);
								userInfo.setGetdate(sdf.format(new Date()));
								
								result = addUser(userInfo);
//								if(!result.isState()){
//									throw new Exception();
//								}
								
//								userInfos.add(userInfo);
								
							}
						}
					}
				}
//			}catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}
		return result;
	}
    
    private Result addUser(UserInfo info) throws Exception{
    	Result result = new Result();
    	if(info.getPhonenumber()!=null&&!info.getPhonenumber().isEmpty()){
    		UserInfo queryInfo = new UserInfo();
    		queryInfo.setPhonenumber(info.getPhonenumber());
    		UserInfo resultInfo = userServer.getuserinfoforuniq(queryInfo);
    		if(resultInfo!=null){
    			result.setState(false);
    			result.setMessage("电话号码已存在");
    			throw new Exception("phonehaved");
//    			return result;
    		}
    	}
    	if(info.getEquipnumber()!=null&&!info.getEquipnumber().isEmpty()){
    		UserInfo queryInfo = new UserInfo();
    		queryInfo.setEquipnumber(info.getEquipnumber());
    		UserInfo resultInfo = userServer.getuserinfoforuniq(queryInfo);
    		if(resultInfo!=null){
    			result.setState(false);
    			result.setMessage("设备编号已存在");
    			throw new Exception("equiphaved");
//    			return result;
    		}
    	}
    	
		
    	result = userServer.addUserInfo(info);
    	
    	return result;
    }

}
