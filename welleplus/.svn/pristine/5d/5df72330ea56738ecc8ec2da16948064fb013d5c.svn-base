package com.welleplus.server;

import com.welleplus.entity.Equipment;
import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;

import java.util.List;
import java.util.Map;


/**
 * 作者:王卫
 * 创建时间:2017-09-11
 * 描述:设备接口服务
 */
public interface EquipmentService {
    /**
     * 增加定位设备信息
     */
    int addEquipment(Equipment equipment) throws Exception;

    /**
     * 查看定位设备信息
     */
    Equipment getEquipment(Equipment equipment) throws Exception;

    /**
     * 查询全部定位设备信息
     */
    List<Equipment> getAllPmequipment(UserInfo user) throws Exception;

    /**
     * 通过uid修改定位设备所属围栏信息
     */
    int editEquipmentByUid(Map<String, Object> map) throws Exception;

    /**
     * 删除定位设备信息
     */

    int delEquipment(Equipment equipmentt) throws Exception;

    /**
     * 获取轨迹信息
     *
     * @param equipment
     * @return
     * @throws Exception
     */
    Result getHistory(Equipment equipment) throws Exception;

    /**
     * 通过条件查询位置信息
     *
     * @param equipment
     * @return
     * @throws Exception
     */
    Result getLocation(Equipment equipment) throws Exception;

    /**
     * 通过condition传回来的参数获取设备信息
     *
     * @param condition
     * @return
     * @throws Exception
     */
    Equipment getEquipmentByCondition(String condition) throws Exception;
}
