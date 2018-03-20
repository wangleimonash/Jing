package com.welleplus.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipType {

	public static List<Map<String, Object>> getList(List<Map<String, Object>> infos){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<infos.size();i++){
        	Map<String, Object> map = new HashMap<String, Object>();
        	if("1".equals(infos.get(i).get("equiptype").toString())){
        		map.put("value", infos.get(i).get("counts"));
        		map.put("name", "gps定位器");
        		list.add(map);
        	}
        	if("2".equals(infos.get(i).get("equiptype").toString())){
        		map.put("value", infos.get(i).get("counts"));
        		map.put("name", "手机app");
        		list.add(map);
        	}
        	if("3".equals(infos.get(i).get("equiptype").toString())){
        		map.put("value", infos.get(i).get("counts"));
        		map.put("name", "电子标签");
        		list.add(map);
        	}
        }
        
        return list;
	}
	public static List<Map<String, Object>> getLists(List<Map<String, Object>> infos){
        for(int i=0;i<infos.size();i++){
//        	Map<String, Object> map = new HashMap<String, Object>();
        	if("1".equals(infos.get(i).get("equiptype").toString())){
//        		infos.get(i).replace("equiptype", "gps定位器");
        		infos.get(i).put("equiptype", "gps定位器");
        	}
        	if("2".equals(infos.get(i).get("equiptype").toString())){
//        		infos.get(i).replace("equiptype", "手机app");
        		infos.get(i).put("equiptype", "手机app");
        	}
        	if("3".equals(infos.get(i).get("equiptype").toString())){
//        		infos.get(i).replace("equiptype", "电子标签");
        		infos.get(i).put("equiptype", "电子标签");
        	}
        }
        
        return infos;
	}
}
