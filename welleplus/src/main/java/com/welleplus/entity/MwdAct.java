package com.welleplus.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author: David
 * @Description:设备上传位置信息
 * @Date: Created in 2017/8/23 09:24
 */
public class MwdAct {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 设备串列号
	 */
	private String IEMI;
	/**
	 * 经度x
	 */
	private String Xloc;
	/**
	 * 纬度y
	 */
	private String Yloc;
	/**
	 * 当前电量
	 */
	private int Bat;
	/**
	 * 接收的信号强度
	 */
	private int RSSI;
	/**
	 * sos求救信号状态
	 */
	private String sos;
	/**
	 * 手表当前时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date watch_date;
	/**
	 * 接受信息时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_date;
	/**
	 * 定位的类型v是lbs，a是gps
	 */
	private String is_position;
	/**
	 * 当前位置
	 */
	private String address;
	public String getIEMI() {
		return IEMI;
	}
	public void setIEMI(String iEMI) {
		IEMI = iEMI;
	}
	public int getRSSI() {
		return RSSI;
	}
	public void setRSSI(int rSSI) {
		RSSI = rSSI;
	}
	public String getIs_position() {
		return is_position;
	}
	public void setIs_position(String is_position) {
		this.is_position = is_position;
	}
	/**
	 * 备用
	 */
	private String type;
	/**
	 * 原始数据
	 */
	private String gps_info;
	/**
	 * 原始数据
	 */
	private String bts_info;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIemi() {
		return IEMI;
	}
	public void setIemi(String iemi) {
		this.IEMI = iemi;
	}
	public String getXloc() {
		return Xloc;
	}
	public void setXloc(String xloc) {
		this.Xloc = xloc;
	}
	public String getYloc() {
		return Yloc;
	}
	public void setYloc(String yloc) {
		this.Yloc = yloc;
	}
	public int getBat() {
		return Bat;
	}
	public void setBat(int bat) {
		this.Bat = bat;
	}
	public int getRssi() {
		return RSSI;
	}
	public void setRssi(int rssi) {
		this.RSSI = rssi;
	}
	public String getSos() {
		return sos;
	}
	public void setSos(String sos) {
		this.sos = sos;
	}
	public Date getWatch_date() {
		return watch_date;
	}
	public void setWatch_date(Date watch_date) {
		this.watch_date = watch_date;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGps_info() {
		return gps_info;
	}
	public void setGps_info(String gps_info) {
		this.gps_info = gps_info;
	}
	public String getBts_info() {
		return bts_info;
	}
	public void setBts_info(String bts_info) {
		this.bts_info = bts_info;
	}
	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"IEMI\":\"" + IEMI + "\", \"Xloc\":\"" + Xloc + "\", \"Yloc\":\"" + Yloc + "\", \"Bat\":" + Bat + ", \"RSSI\":"
				+ RSSI + ", \"sos\":\"" + sos + "\", \"watch_date\":" + watch_date + ", \"create_date\":" + create_date
				+ ", \"is_position\":\"" + is_position + "\", \"address\":\"" + address + "\", \"type\":\"" + type + "\", \"gps_info\":\"" + gps_info
				+ "\", \"bts_info\":\"" + bts_info + "\"}";
	}

}
