package com.welleplus.serverImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.welleplus.dao.UserDao;
import com.welleplus.entity.ImageInfo;
import com.welleplus.entity.UserInfo;
import com.welleplus.entity.UserInfoQuery;
import com.welleplus.entity.WatchWarning;
import com.welleplus.result.Result;
import com.welleplus.server.UserServer;

@Service
public class UserServerImpl implements UserServer {
    @Resource
    private UserDao userDao;

    public Result getInfos() {
        // TODO Auto-generated method stub
        Result result = new Result();
        List<UserInfo> infos = userDao.getUserInfos();
        result.setData(infos);
        result.setMessage("查询成功");
        result.setState(true);
        return result;
    }

    public Result addUserInfo(UserInfo info) throws Exception {
        // TODO Auto-generated method stub
        Result result = new Result();
        int id = userDao.addUserInfo(info);
        result.setId(info.getId());
        result.setData(info);
        result.setState(true);
        result.setMessage("添加成功");
        return result;
    }

    public Result getInfo(UserInfo info) {
        // TODO Auto-generated method stub
        Result result = new Result();
        try {
            List<UserInfo> infos = userDao.getUserInfo(info);
            result.setData(infos);
            result.setState(true);
            result.setMessage("查询成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result.setState(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改用户信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public Result editUser(UserInfo userInfo) throws Exception{
        Result result = new Result();
        userDao.editUser(userInfo);
        result.setState(true);
        result.setMessage("更新成功");
        return result;
    }

    /**
     * 删除用户信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public Result delUser(Long id) throws Exception{
        Result result = new Result();
        userDao.delUser(id);
        result.setState(true);
        result.setMessage("删除成功");
        return result;
    }

	@Override
	public Result getUserInfoForId(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			UserInfo info = userDao.getUserInfoForId(id);
			result.setData(info);
			result.setState(true);
			result.setMessage("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("查询失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result getCountFromRoleAndRid(Long role, Long rid) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("role", role);
		map.put("rid", rid);
		try {
			Long count = userDao.getCountFromRoleAndRid(map);
			result.setId(count);
			result.setState(true);
			result.setMessage("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setId(0L);
			result.setState(false);
			result.setMessage("查询失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<UserInfo> getUserInfoForRole(UserInfo info) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getUserInfoForRole(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public List<UserInfo> getUserInfoFromCorrelation(Long role, Long uid) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("role", role);
		map.put("uid", uid);
		try {
			infos = userDao.getUserInfoFromCorrelation(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public List<UserInfo> getUserInfoOfRole2FromRole1(UserInfo info) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = userDao.getUserInfoOfRole2FromRole1(info);
		return infos;
	}

	@Override
	public List<UserInfo> getUserInfoOfRole3FromRole1(UserInfo info) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = userDao.getUserInfoOfRole3FromRole1(info);
		return infos;
	}

	@Override
	public List<UserInfo> getUserInfoOfRole4FromRole1(UserInfo info) {
		// TODO Auto-generated method stub
		Map<String,Long> map = new HashMap<String,Long>();
		List<UserInfo> infos = userDao.getUserInfoOfRole4FromRole1(info);
		return infos;
	}

	@Override
	public UserInfo getuserinfoforuniq(UserInfo info) {
		// TODO Auto-generated method stub
		UserInfo userInfo = userDao.getuserinfoforuniq(info);
		return userInfo;
	}

	@Override
	public List<UserInfo> getUserInfoFromRole0(UserInfo info) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = userDao.getUserInfoFromRole0(info);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getUserInfoCountFromRole2Id(Long fid,
			Long cid) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fid", fid);
		map.put("cid", cid);
		List<Map<String, Object>> infos = userDao.getUserInfoCountFromRole2Id(map);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getUserInfoCountFromRole1Id(Long fid) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fid", fid);
		List<Map<String,Object>> infos = userDao.getUserInfoCountFromRole1Id(map);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getJournalInfoFromRole1Click1(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
//		map.put("page", page);
		List<Map<String,Object>> infos = userDao.getJournalInfoFromRole1Click1(info);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getJournalInfoFromRole1Click2(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
//		map.put("page", page);
		List<Map<String,Object>> infos = userDao.getJournalInfoFromRole1Click2(info);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getJournalInfoFromRole1Click3(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
//		map.put("page", page);
		List<Map<String,Object>> infos = userDao.getJournalInfoFromRole1Click3(info);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getJournalInfoFromRole1Click4(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
//		map.put("page", page);
		List<Map<String,Object>> infos = userDao.getJournalInfoFromRole1Click4(info);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getJournalInfoFromRole2Click2(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("rid", rid);
//		map.put("uid", uid);
		List<Map<String,Object>> infos = userDao.getJournalInfoFromRole2Click2(info);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getJournalInfoFromRole2Click3(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
		List<Map<String,Object>> infos = userDao.getJournalInfoFromRole2Click3(info);
		return infos;
	}

	@Override
	public List<Map<String, Object>> getJournalInfoFromRole3Click3(UserInfoQuery info) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("rid", rid);
//		map.put("uid", uid);
		List<Map<String,Object>> infos = userDao.getJournalInfoFromRole3Click3(info);
		return infos;
	}

	@Override
	public List<ImageInfo> getImageInfo(String title) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("title", title);
		List<ImageInfo> infos = userDao.getImageInfo(map);
		return infos;
	}

	@Override
	public Long getCountJournalInfoFromRole1Click1(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
//		map.put("page", page);
		Long count = userDao.getCountJournalInfoFromRole1Click1(info);
		return count;
	}

	@Override
	public Long getCountJournalInfoFromRole1Click2(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
//		map.put("page", page);
		Long count = userDao.getCountJournalInfoFromRole1Click2(info);
		return count;
	}

	@Override
	public Long getCountJournalInfoFromRole1Click3(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
//		map.put("page", page);
		Long count = userDao.getCountJournalInfoFromRole1Click3(info);
		return count;
	}

	@Override
	public Long getCountJournalInfoFromRole1Click4(UserInfoQuery info) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("descId", descId);
//		map.put("page", page);
		Long count = userDao.getCountJournalInfoFromRole1Click4(info);
		return count;
	}

	@Override
	public Long getCountJournalInfoFromRole2Click2(UserInfoQuery info) {
		// TODO Auto-generated method stub
		Long count = userDao.getCountJournalInfoFromRole2Click2(info);
		return count;
	}

	@Override
	public Long getCountJournalInfoFromRole2Click3(UserInfoQuery info) {
		// TODO Auto-generated method stub
		Long count = userDao.getCountJournalInfoFromRole2Click3(info);
		return count;
	}

	@Override
	public Long getCountJournalInfoFromRole3Click3(UserInfoQuery info) {
		// TODO Auto-generated method stub
		Long count = userDao.getCountJournalInfoFromRole3Click3(info);
		return count;
	}

	@Override
	public List<UserInfo> getUserInfoByRoleAndRid(Long role, Long rid) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("role", role);
		map.put("rid", rid);
		try {
			infos = userDao.getUserInfoByRoleAndRid(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public Map<String, Object> getwatchgpsByImei(String imei) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map = userDao.getwatchgpsByImei(imei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map = null;
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getwatchheartByImei(String imei) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map = userDao.getwatchheartByImei(imei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map = null;
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getwatchdataByImei(String imei) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map = userDao.getwatchdataByImei(imei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map = null;
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getappdataByImei(String imei) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map = userDao.getappdataByImei(imei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map = null;
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getwatchwarningByImei(String imei) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map = userDao.getwatchwarningByImei(imei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map = null;
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getwatchgpsByImeiAndDateTime(
			String imei,String date,String time) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> rmap = new HashMap<String,Object>();
		map.put("imei", imei);
		map.put("date", date);
		map.put("time", time);
		try {
			rmap = userDao.getwatchgpsByImeiAndDateTime(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rmap = null;
			e.printStackTrace();
		}
		return rmap;
	}

	@Override
	public List<WatchWarning> getwatchwarningByDate(String startdate,
			String enddate,String imei) {
		// TODO Auto-generated method stub
		List<WatchWarning> infos = new ArrayList<WatchWarning>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startdate", startdate);
		map.put("enddate", enddate);
		map.put("imei", imei);
		try {
			infos = userDao.getwatchwarningByDate(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public Result login(UserInfo info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			List<UserInfo> infos = userDao.login(info);
			result.setData(infos);
			result.setState(true);
			result.setMessage("登录成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setData(null);
			result.setMessage("登录失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result updateImgsrc(String path, Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("imgsrc", path);
		map.put("id", id);
		try {
			userDao.updateImgsrc(map);
			result.setState(true);
			result.setMessage("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("保存失败");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getImgsrcById(Long id) {
		// TODO Auto-generated method stub
		String path = null;
		try {
			path = userDao.getImgsrcById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

	@Override
	public List<UserInfo> getUserInfoByRoleAndRidAndInfo(Long role, Long rid,
			String info) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("role", role);
		map.put("rid", rid);
		map.put("info", info);
		try {
			infos = userDao.getUserInfoByRoleAndRidAndInfo(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public List<UserInfo> getUserInfosByIds(int[] ids,int page,String info) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ids", ids);
		map.put("page", page);
		map.put("info", info);
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getUserInfosByIds(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public Long getUserInfosCountByIds(int[] ids,String info) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ids", ids);
		map.put("info", info);
		Long count = 0L;
		try {
			count = userDao.getUserInfosCountByIds(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Long getUserCoutnByNumber(String phoneNumber, String equipNumber){
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		map.put("phonenumber", phoneNumber);
		map.put("equipnumber", equipNumber);
		Long count = 0L;
		try {
			count = userDao.getUserCoutnByNumber(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<UserInfo> getUserInfoByIds(UserInfoQuery info) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getUserInfoByIds(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public Long getUserCountByIds(UserInfoQuery info) {
		// TODO Auto-generated method stub
		Long count = 0L;
		try {
			count = userDao.getUserCountByIds(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<UserInfo> getUserInfoByIdsNew(UserInfoQuery info) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getUserInfoByIdsNew(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public Result getUserInfoAndPosition(UserInfoQuery info) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			result.setCount(userDao.getCountUserInfoAndPosition(info));
			List<Map<String,Object>> infos = userDao.getUserInfoAndPosition(info);
			result.setData(infos);
			result.setState(true);
			result.setMessage("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("查询失败");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询出勤人员信息
	 */
	public List<UserInfo> getShouldWorkUser(Map<String,Object> map){
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getShouldWorkUser(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public List<UserInfo> getShouldWorkUserFromCompany(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getShouldWorkUserFromCompany(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public List<UserInfo> getShouldWorkUserFromSection(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getShouldWorkUserFromSection(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public List<UserInfo> getShouldWorkUserFromProject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getShouldWorkUserFromProject(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public Long getActWorkCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Long count = 0L;
		try {
			count = userDao.getActWorkCount(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Long getlateWorkCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Long count = 0L;
		try {
			count = userDao.getlateWorkCount(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Result getUserAndPositionByIds(UserInfoQuery queryInfo) {
		// TODO Auto-generated method stub
		Result result = new Result();
		List<UserInfo> infos = new ArrayList<UserInfo>();
		try {
			infos = userDao.getUserAndPositionByIds(queryInfo);
			result.setState(true);
			result.setMessage("查询成功");
			result.setData(infos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("查询失败");
			e.printStackTrace();
		}
		return result;
	}
}
