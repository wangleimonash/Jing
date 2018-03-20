package com.welleplus.controller;

import com.welleplus.entity.UserInfo;
import com.welleplus.result.Result;
import com.welleplus.server.MapService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("map")
public class MapController {

    @Resource
    private MapService mapService;

    /**
     * 获取历史轨迹信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("getHistory.do")
    @ResponseBody
    public Result getHistory(@RequestBody UserInfo userInfo) throws Exception {
        Result result = new Result();
        if(userInfo.getParam()==null||userInfo.getParam()==""){
            result.setState(false);
            result.setMessage("查询条件不能为空!");
            return result;
        }
        result = mapService.getHistory(userInfo);
        return result;
    }

    /**
     * 获取位置信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("getLocation.do")
    @ResponseBody
    public Result getLocation(@RequestBody UserInfo userInfo) throws Exception {
        Result result = new Result();
        if(userInfo.getParam()==null||userInfo.getParam()==""){
            result.setState(false);
            result.setMessage("查询条件不能为空!");
            return result;
        }
        result = mapService.getLocation(userInfo);
        return result;
    }
}
