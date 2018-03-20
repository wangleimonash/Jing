package com.welleplus.dao;

import java.util.List;
import java.util.Map;

import com.welleplus.entity.Section;

public interface SectionDao {
	int addSectionInfo(Section info) throws Exception;
	List<Section> getSectionInfo(Long id) throws Exception;
	Section getSectionInfoForId(Long id);
	Section getSectionAsMap(Map<String, Object> map);
	int updateSectionName(Section info) throws Exception;
	int deleteSectionInfo(Long id) throws Exception;

}
