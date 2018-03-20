package com.welleplus.server;

import com.welleplus.entity.Project;
import com.welleplus.result.Result;

public interface ProjectServer {
	Result addProjectInfo(Project info);
	Result getProjectInfo(Long id);
	Result getProjectInfoForId(Long id);
	Result getProjectInfoAsMap(Long id,Long sid);
	Result updateProjectName(Long id,String name);
	Result deleteProjectInfo(Long id);

}
