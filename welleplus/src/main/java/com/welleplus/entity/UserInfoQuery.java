package com.welleplus.entity;


public class UserInfoQuery {
	private Long desc;
	private Long descId;
	private Long role;
	private Long rid;
	private Long uid;
	private Long page;
	private Integer worktype;
	private String name;
	private String startdate;
	private String enddate;
	private String equiptype;
	
	private Object[][] ids;
	private String info;
	
	public Long getDesc() {
		return desc;
	}
	public void setDesc(Long desc) {
		this.desc = desc;
	}
	public Long getDescId() {
		return descId;
	}
	public void setDescId(Long descId) {
		this.descId = descId;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Integer getWorktype() {
		return worktype;
	}
	public void setWorktype(Integer worktype) {
		this.worktype = worktype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Object[][] getIds() {
		return ids;
	}
	public void setIds(Object[][] ids) {
		this.ids = ids;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getEquiptype() {
		return equiptype;
	}
	public void setEquiptype(String equiptype) {
		this.equiptype = equiptype;
	}
	

}
