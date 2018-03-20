package com.welleplus.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6175233045321713805L;
	private Long id;
	private String userName;
	private String password;
	private String sex;
	private String role;
	private String phonenumber;
	private String email;
	private String name;
	private String creatdate;
	private Long rid;
	private String equipnumber;
	private int equipstate;
	private Integer equiptype;
	private Integer worktype;
	private String type2;
	private Integer isin;
	private String getdate;
	private int promise;
	private int oncilkepage;
	
	
	private String promiseStr;
	private String worktypeStr;
	
	private String describe;//描述
	
	private List<Correlation> correlations;
	
	public int getOncilkepage() {
		return oncilkepage;
	}
	public void setOncilkepage(int oncilkepage) {
		this.oncilkepage = oncilkepage;
	}
	/**
	 * 用传用户信息
	 */
	private String param;
	
	/**
     * 开始时间
     */
    private String startdate;
    /**
     * 结束时间
     */
    private String enddate;
    /**
	 * tree
	 */
    private long descId;
    /**
	 * tree
	 */
    private int desc;
    /**
	 * 分页
	 */
    private int page;
	
	private List<Long> ids;//当前用户管理的下级组织id
	private Long grade;
	private String equipTypeStr;
	private String equipStateStr;
	
	private String edituserName;
	private String editphonenumber;
	private String editequipnumber;
	
	
	//地图商展示用字段
	private String positiontime;//定位时间
	private Integer heartRate;//心率
	private String altitude;//海拔
	private String xLoc;
	private String yLoc;
	private String address;//地址
	private String elec;//电量
	
	//手表报警展示用
	private int type;//报警类型1：sos，2：摔倒，10：低电量
	private String typeStr;//报警类型
	private String warningDate;//报警时间
	
	
	private Integer workdays;//出勤天数
	private Integer laterdays;//迟到天数
	private Integer befordays;//早退天数
	
	private String imgsrc; // 头像地址
	
	public UserInfo(){
		
	}
	
	public UserInfo(String name,String phoneNumber,String equipnumber){
		this.name = name;
		this.phonenumber = phoneNumber;
		this.equipnumber = equipnumber;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatdate() {
		return creatdate;
	}
	public void setCreatdate(String creatdate) {
		this.creatdate = creatdate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	public Long getGrade() {
		return grade;
	}
	public void setGrade(Long grade) {
		this.grade = grade;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getEquipnumber() {
		return equipnumber;
	}
	public void setEquipnumber(String equipnumber) {
		this.equipnumber = equipnumber;
	}
	public int getEquipstate() {
		return equipstate;
	}
	public void setEquipstate(int equipstate) {
		this.equipstate = equipstate;
	}
	public Integer getEquiptype() {
		return equiptype;
	}
	public void setEquiptype(Integer equiptype) {
		this.equiptype = equiptype;
	}
	public Integer getWorktype() {
		return worktype;
	}
	public void setWorktype(Integer worktype) {
		this.worktype = worktype;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public Integer getIsin() {
		return isin;
	}
	public void setIsin(Integer isin) {
		this.isin = isin;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getGetdate() {
		return getdate;
	}
	public void setGetdate(String getdate) {
		this.getdate = getdate;
	}
	public List<Correlation> getCorrelations() {
		return correlations;
	}
	public void setCorrelations(List<Correlation> correlations) {
		this.correlations = correlations;
	}
	public String getEquipTypeStr() {
		return equipTypeStr;
	}
	public void setEquipTypeStr(String equipTypeStr) {
		this.equipTypeStr = equipTypeStr;
	}
	public String getEquipStateStr() {
		return equipStateStr;
	}
	public void setEquipStateStr(String equipStateStr) {
		this.equipStateStr = equipStateStr;
	}
	public long getDescId() {
		return descId;
	}
	public void setDescId(long descId) {
		this.descId = descId;
	}
	public int getDesc() {
		return desc;
	}
	public void setDesc(int desc) {
		this.desc = desc;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPromise() {
		return promise;
	}
	public void setPromise(int promise) {
		this.promise = promise;
	}
	public String getPromiseStr() {
		return promiseStr;
	}
	public void setPromiseStr(String promiseStr) {
		this.promiseStr = promiseStr;
	}
	public String getWorktypeStr() {
		return worktypeStr;
	}
	public void setWorktypeStr(String worktypeStr) {
		this.worktypeStr = worktypeStr;
	}
	public String getEdituserName() {
		return edituserName;
	}
	public void setEdituserName(String edituserName) {
		this.edituserName = edituserName;
	}
	public String getEditphonenumber() {
		return editphonenumber;
	}
	public void setEditphonenumber(String editphonenumber) {
		this.editphonenumber = editphonenumber;
	}
	public String getEditequipnumber() {
		return editequipnumber;
	}
	public void setEditequipnumber(String editequipnumber) {
		this.editequipnumber = editequipnumber;
	}
	public String getPositiontime() {
		return positiontime;
	}
	public void setPositiontime(String positiontime) {
		this.positiontime = positiontime;
	}
	public Integer getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getxLoc() {
		return xLoc;
	}
	public void setxLoc(String xLoc) {
		this.xLoc = xLoc;
	}
	public String getyLoc() {
		return yLoc;
	}
	public void setyLoc(String yLoc) {
		this.yLoc = yLoc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTypeStr() {
		return typeStr;
	}
	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}
	public String getWarningDate() {
		return warningDate;
	}
	public void setWarningDate(String warningDate) {
		this.warningDate = warningDate;
	}
	public String getElec() {
		return elec;
	}
	public void setElec(String elec) {
		this.elec = elec;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getWorkdays() {
		return workdays;
	}
	public void setWorkdays(Integer workdays) {
		this.workdays = workdays;
	}
	public Integer getLaterdays() {
		return laterdays;
	}
	public void setLaterdays(Integer laterdays) {
		this.laterdays = laterdays;
	}
	public Integer getBefordays() {
		return befordays;
	}
	public void setBefordays(Integer befordays) {
		this.befordays = befordays;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	

}
