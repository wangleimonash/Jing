package com.welleplus.result;

public class Result {
    private Long id;
    private String message;
    private boolean state;
    private Object data;
    private Long count;//总数
    private String tempip;//存ip，登录用

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getTempip() {
		return tempip;
	}

	public void setTempip(String tempip) {
		this.tempip = tempip;
	}
	

}
