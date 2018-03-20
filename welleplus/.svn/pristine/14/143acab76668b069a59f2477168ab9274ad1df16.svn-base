package com.welleplus.serverImpl;

import com.welleplus.dao.EquipmentDao;
import com.welleplus.entity.Company;
import com.welleplus.entity.Equipment;
import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.EquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: David
 * @Description:
 * @Date: Created in 2017/9/11 10:04
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Resource
    private EquipmentDao equipmentDao;

    @Override
    public int addEquipment(Equipment equipment) throws Exception {
        return 0;
    }

    @Override
    public Equipment getEquipment(Equipment equipment) throws Exception {
        return null;
    }

    @Override
    public List<Equipment> getAllPmequipment(UserInfo user) throws Exception {
        return null;
    }

    @Override
    public int editEquipmentByUid(Map<String, Object> map) throws Exception {
        return 0;
    }

    @Override
    public int delEquipment(Equipment equipmentt) throws Exception {
        return 0;
    }

    /**
     * 获取历史轨迹
     *
     * @param equipment
     * @return
     * @throws Exception
     */
    @Override
    public Result getHistory(Equipment equipment) throws Exception {
        // TODO Auto-generated method stub
        Result result = new Result();
        List<Equipment> equipmentList = equipmentDao.getHistory(equipment);
        result.setData(equipmentList);
        result.setState(true);
        result.setMessage("查询成功");
        return result;
    }

    /**
     * 获取位置信息
     *
     * @param equipment
     * @return
     * @throws Exception
     */
    @Override
    public Result getLocation(Equipment equipment) throws Exception {
        // TODO Auto-generated method stub
        Result result = new Result();
        List<Equipment> equipmentmap= equipmentDao.getLocation(equipment);
        result.setData(equipmentmap);
        result.setState(true);
        result.setMessage("查询成功");
        return result;
    }

    @Override
    public Equipment getEquipmentByCondition(String condition) throws Exception {
        return null;
    }
}
