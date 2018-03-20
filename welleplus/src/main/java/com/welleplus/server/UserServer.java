package com.welleplus.server;

import com.welleplus.entity.ImageInfo;
import com.welleplus.entity.UserInfo;
import com.welleplus.entity.UserInfoQuery;
import com.welleplus.entity.WatchWarning;
import com.welleplus.result.Result;

import java.util.List;
import java.util.Map;

public interface UserServer {
    Result getInfos();

    Result addUserInfo(UserInfo info) throws Exception;

    Result getInfo(UserInfo info);

    /**
     * 修改用户信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    Result editUser(UserInfo userInfo) throws Exception;

    /**
     * 删除用户信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    Result delUser(Long id) throws Exception;

    
    Result getUserInfoForId(Long id);
    
    Result getCountFromRoleAndRid(Long role,Long rid);
    
    List<UserInfo> getUserInfoForRole(UserInfo info);
    List<UserInfo> getUserInfoFromCorrelation(Long role,Long uid);
    
    List<UserInfo> getUserInfoOfRole2FromRole1(UserInfo info);
    List<UserInfo> getUserInfoOfRole3FromRole1(UserInfo info);
    List<UserInfo> getUserInfoOfRole4FromRole1(UserInfo info);
    List<UserInfo> getUserInfoFromRole0(UserInfo info);
    
    UserInfo getuserinfoforuniq(UserInfo info);
    
    List<Map<String,Object>> getUserInfoCountFromRole2Id(Long fid,Long cid);
    List<Map<String,Object>> getUserInfoCountFromRole1Id(Long fid);
    
    List<Map<String,Object>> getJournalInfoFromRole1Click1(UserInfoQuery info);
    List<Map<String,Object>> getJournalInfoFromRole1Click2(UserInfoQuery info);
    List<Map<String,Object>> getJournalInfoFromRole1Click3(UserInfoQuery info);
    List<Map<String,Object>> getJournalInfoFromRole1Click4(UserInfoQuery info);
    Long getCountJournalInfoFromRole1Click1(UserInfoQuery info);
    Long getCountJournalInfoFromRole1Click2(UserInfoQuery info);
    Long getCountJournalInfoFromRole1Click3(UserInfoQuery info);
    Long getCountJournalInfoFromRole1Click4(UserInfoQuery info);
    
    List<Map<String,Object>> getJournalInfoFromRole2Click2(UserInfoQuery info);
    List<Map<String,Object>> getJournalInfoFromRole2Click3(UserInfoQuery info);
    Long getCountJournalInfoFromRole2Click2(UserInfoQuery info);
    Long getCountJournalInfoFromRole2Click3(UserInfoQuery info);
    
    List<Map<String,Object>> getJournalInfoFromRole3Click3(UserInfoQuery info);
    Long getCountJournalInfoFromRole3Click3(UserInfoQuery info);
    
    List<ImageInfo> getImageInfo(String title);
    
    List<UserInfo> getUserInfoByRoleAndRid(Long role,Long rid);
    List<UserInfo> getUserInfoByRoleAndRidAndInfo(Long role,Long rid,String info);
    
    Map<String,Object> getwatchgpsByImei(String imei);
    Map<String,Object> getwatchheartByImei(String imei);
    Map<String,Object> getwatchdataByImei(String imei);
    Map<String,Object> getappdataByImei(String imei);
    
    Map<String,Object> getwatchwarningByImei(String imei);
    Map<String,Object> getwatchgpsByImeiAndDateTime(String imei,String date,String time);
    
    List<WatchWarning> getwatchwarningByDate(String startdate,String enddate,String imei);
    
    Result login(UserInfo info);
    
    Result updateImgsrc(String path,Long id);
    
    String getImgsrcById(Long id);
    
    List<UserInfo> getUserInfosByIds(int[] ids,int page,String info);
    Long getUserInfosCountByIds(int[] ids,String info);
    
    Long getUserCoutnByNumber(String phoneNumber,String equipNumber);
    
    List<UserInfo> getUserInfoByIds(UserInfoQuery info);
    Long getUserCountByIds(UserInfoQuery info);
    List<UserInfo> getUserInfoByIdsNew(UserInfoQuery info);
    
    Result getUserInfoAndPosition(UserInfoQuery info);
    
//    查询出勤人数
    List<UserInfo> getShouldWorkUser(Map<String,Object> map);
    List<UserInfo> getShouldWorkUserFromCompany(Map<String,Object> map);
    List<UserInfo> getShouldWorkUserFromSection(Map<String,Object> map);
    List<UserInfo> getShouldWorkUserFromProject(Map<String,Object> map);
    
    Long getActWorkCount(Map<String,Object> map);
    Long getlateWorkCount(Map<String,Object> map);
    
    
    Result getUserAndPositionByIds(UserInfoQuery queryInfo);
}
