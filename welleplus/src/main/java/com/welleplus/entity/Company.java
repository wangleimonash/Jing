package com.welleplus.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: David
 * @Description:二级机构信息 公司信息
 * @Date: Created in 2017/8/22 10:04
 */
public class Company implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -262249609515039776L;
	/**
     * 二级机构信息id
     */
    private Long id;
    /**
     * 二级机构名称
     */
    private String name;
    /**
     * 二级机构联系电话
     */
    private String phonenumber;
    /**
     * 二级机构邮箱
     */
    private String email;
    /**
     * 二级机构地址
     */
    private String address;
    /**
     * 二级机构信息添加时间
     */
    private Timestamp creatdate;
    /**
     * 二级机构级别字段
     */
    private String grade;
    /*
     *二级机构信息预留字段1
     */
    private String type1;
    /**
     * 二级机构信息预留字段2
     */
    private String type2;
    /**
     * 二级机构上级部门信息id
     */
    private Long fid;
    
    private Map<String,Long> data;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreatdate() {
        return creatdate;
    }

    public void setCreatDate(Timestamp creatdate) {
        this.creatdate = creatdate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Map<String, Long> getData() {
		return data;
	}

	public void setData(Map<String, Long> data) {
		this.data = data;
	}

	public void setCreatdate(Timestamp creatdate) {
		this.creatdate = creatdate;
	}
    

}
