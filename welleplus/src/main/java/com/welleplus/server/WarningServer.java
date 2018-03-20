package com.welleplus.server;

import java.util.List;

import com.welleplus.entity.FenceQuery;
import com.welleplus.entity.Warning;
import com.welleplus.result.Result;

public interface WarningServer {
	Result getWarningInfo(Long id);
	Result getCountWarning(Long id);
	Result getWarningInfoAsRole1(Warning info);
	Result getWarningInfoAsRole2(Warning info);
	Result getWarningInfoAsRole3(Warning info);
	Result getWarningInfoAsRole4(Warning info);
	Result getWarningInfos(Warning info);
	Result getWarningInfoFromQuery(FenceQuery info);

}
