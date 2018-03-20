package com.welleplus.entity;

import java.io.Serializable;

/**
 * @author: David
 * @Description:
 * @Date: Created in 2017/8/23 10:41
 */
public class Correlation implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7123657757804056490L;
	private Long id;
    private Long uid;
    private Long pmid;
    private Long grade;
    private Long gradeid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getPmid() {
		return pmid;
	}
	public void setPmid(Long pmid) {
		this.pmid = pmid;
	}
	public Long getGrade() {
		return grade;
	}
	public void setGrade(Long grade) {
		this.grade = grade;
	}
	public Long getGradeid() {
		return gradeid;
	}
	public void setGradeid(Long gradeid) {
		this.gradeid = gradeid;
	}

}
