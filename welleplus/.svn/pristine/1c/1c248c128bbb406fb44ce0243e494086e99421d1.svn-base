package com.welleplus.serverImpl;

import com.welleplus.dao.CorrelationDao;
import com.welleplus.dao.FirmDao;
import com.welleplus.dao.UserDao;
import com.welleplus.entity.Correlation;
import com.welleplus.entity.Firm;
import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.MapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: David
 * @Description:
 * @Date: Created in 2017/9/22 10:10
 */
@Service
public class MapServiceImpl implements MapService {
    @Resource
    private CorrelationDao correlationDao;
    @Resource
    private UserDao userDao;
    @Resource
    private FirmDao firmDao;

    /**
     * 获取用户位置信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public Result getLocation(UserInfo userInfo) throws Exception {
        // TODO Auto-generated method stub
        Result result = new Result();
        UserInfo u = new UserInfo();
        Firm firm = new Firm();
//        获取所要查询的用户信息的条数
        int i=userDao.getUserInfoCountByParam(userInfo);
        if (i!=1){
            if(i>=2){
                result.setState(false);
                result.setMessage("该员工姓名出现同名，请使用其他条件查询！！！");
                return result;
            }
            if(i<=0){
                result.setState(false);
                result.setMessage("未获取到员工信息，请使用其他条件查询！！！");
                return result;
            }
        }

//        获取所要查询的用户信息
        u = userDao.getUserInfoByParam(userInfo);
//        u.setStartdate(userInfo.getStartdate());
//        u.setEnddate(userInfo.getEnddate());
//        获取所要查询的用户的组织信息
        Map<String, Object> map = firmDao.getOrg(u);
        Map<String,Object> Map = new HashMap<String,Object>();
        if(userInfo.getRole().equals("0")){
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
//                result.setData(locationmap);
//                result.setData(map);
//                result.setData(u);
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }
        }
        if (map.get("grade1").equals(userInfo.getRole())  & map.get("id1").equals(userInfo.getRid())) {
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }

        }
        if (map.get("grade2").equals(userInfo.getRole())  & map.get("id2").equals(userInfo.getRid())) {
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }

        }
        if (map.get("grade3").equals(userInfo.getRole())  & map.get("id3").equals(userInfo.getRid())) {
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }

        }
        if (map.get("grade4").equals(userInfo.getRole())  & map.get("id4").equals(userInfo.getRid())) {
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置信息
                List<UserInfo> locationmap = userDao.getLocationByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的位置信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }
        }
        result.setState(false);
        result.setMessage("查询失败！！");
        return result;
    }

    /**
     * 获取用户轨迹信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public Result getHistory(UserInfo userInfo) throws Exception {
        // TODO Auto-generated method stub
        Result result = new Result();
        UserInfo u = new UserInfo();
        Firm firm = new Firm();
        //        获取所要查询的用户信息的条数
        int i=userDao.getUserInfoCountByParam(userInfo);
        if (i!=1){
            if(i>=2){
                result.setState(false);
                result.setMessage("该员工姓名出现同名，请使用其他条件查询！！！");
                return result;
            }
            if(i<=0){
                result.setState(false);
                result.setMessage("未获取到该员工信息，请使用其他条件查询！！！");
                return result;
            }
        }

//        获取所要查询的用户信息
        u = userDao.getUserInfoByParam(userInfo);
        u.setStartdate(userInfo.getStartdate());
        u.setEnddate(userInfo.getEnddate());
//        获取所要查询的用户的组织信息
        Map<String,Object> Map = new HashMap<String,Object>();
        Map<String, Object> map = firmDao.getOrg(u);
        if (userInfo.getRole().equals("0")){
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;

            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置轨迹信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(true);
                result.setMessage("查询成功");
                return result;            }
        }
        if (map.get("grade1").equals(userInfo.getRole())  & map.get("id1").equals(userInfo.getRid())) {
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;

            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置轨迹信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }

        }
        if (map.get("grade2").equals(userInfo.getRole())  & map.get("id2").equals(userInfo.getRid())) {
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置信息
                List<UserInfo> locationmap = userDao.getHistoryByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置轨迹信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }

        }
        if (map.get("grade3").equals(userInfo.getRole())  & map.get("id3").equals(userInfo.getRid())) {
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置轨迹信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }
            result.setState(true);
            result.setMessage("查询成功");
            return result;

        }
        if (map.get("grade4").equals(userInfo.getRole())  & map.get("id4").equals(userInfo.getRid())) {
            if (u.getEquiptype() == 0) {
                // 如果用户使用设备类型是0，即为手表类型
                // 通过设备编号查找手表类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByWatch(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 1) {
                // 如果用户使用设备类型是1，即为安全帽类型
                // 通过设备编号查找安全帽类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByEquipment(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 2) {
                // 如果用户使用设备类型是2，即为app类型
                // 通过设备编号查找app类型位置轨迹信息
                List<UserInfo> locationmap = userDao.getHistoryByPhone(u);
                if (locationmap.size()==0){
//                    Correlation crr=correlationDao.getCorrelationByUid(u);
                    List<UserInfo> usermap=userDao.getUserInfoMapByParam(u);
                    result.setData(usermap);
                    result.setState(false);
                    result.setMessage("没有查到符合条件的轨迹信息！！");
                    return result;
                }
                Map.put("u",u);
                Map.put("map",map);
                Map.put("locationmap",locationmap);
                result.setData(Map);
                result.setState(true);
                result.setMessage("查询成功");
                return result;
            }
            if (u.getEquiptype() == 3) {
                // 如果用户使用设备类型是3，即为RFID类型
                // 通过设备编号查找RFID类型位置轨迹信息
//            List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//            result.setData(equipmentmap);
                result.setState(false);
                result.setMessage("暂无法查询Rfid信息");
                return result;
            }
            result.setState(true);
            result.setMessage("查询成功");
            return result;
        }

//        List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
//        result.setData(equipmentmap);
        result.setState(true);
        result.setMessage("查询成功");
        return result;
    }
}
