package com.welleplus.enums;

public enum WarningType {
	NOWARNING("无报警",0),INWARNING("进围栏报警",1),OUTWARNING("出围栏报警",2),INANDOUTWARNING("进出围栏报警",3);
	private WarningType(String name,int value){
		this.name = name;
		this.value = value;
	}
	private String name;
	private int value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
