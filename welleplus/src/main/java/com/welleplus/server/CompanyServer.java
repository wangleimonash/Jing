package com.welleplus.server;

import com.welleplus.entity.Company;
import com.welleplus.result.Result;

public interface CompanyServer {
	Result addCompanyInfo(Company info);
	Result getCompanyInfo(Long id);
	Result getCompanyInfoForId(Long id);
	Result updateCompanyName(Long id,String name);
	Result deleteCompanyInfo(Long id);

}
