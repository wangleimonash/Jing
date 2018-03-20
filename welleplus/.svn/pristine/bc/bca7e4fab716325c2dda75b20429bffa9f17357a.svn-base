app.service("companyServer",function($http,$q){
	
	this.addCompanyInfo = function(company){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/company/addinfo.do",
			data:company,
			dataType:"json",
//			async:false
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("添加失败");
		});
		
		return deferred.promise;
	}
	
	this.getCompanyInfos = function(){
		var deferred = $q.defer();
		$http.get("/welleplus/company/getinfos.do").success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
});