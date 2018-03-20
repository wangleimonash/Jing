package com.welleplus.entity;

/**
 * @author: David
 * @Description:用户权限设置信息
 * @Date: Created in 2017/8/22 11:25
 */
public class Permission {
    /**
     * 管理员对应部门权限设置信息id
     */
    private int id;
    /**
     * 管理员是否拥有添加权限
     */
    private int add;
    /**
     * 管理员是否拥有删除权限
     */
    private int delect;
    /**
     * 管理员是否拥有修改权限
     */
    private int edit;
    /**
     * 管理员是否拥有查看权限
     */
    private int check;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdd() {
        return add;
    }

    public void setAdd(int add) {
        this.add = add;
    }

    public int getDelect() {
        return delect;
    }

    public void setDelect(int delect) {
        this.delect = delect;
    }

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Permission{" +
                "id=" + id +
                ", add=" + add +
                ", delect=" + delect +
                ", edit=" + edit +
                ", check=" + check +
                '}';
    }
}
