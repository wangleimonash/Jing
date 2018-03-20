package com.welleplus.server;

import com.welleplus.result.Result;

public interface FirmServer {
	Result getFirmInfo(Long id);
	Result getFirmInfos();
	Result updateFirmName(Long id, String name);
	Result deleteFirmInfo(Long id);

}
