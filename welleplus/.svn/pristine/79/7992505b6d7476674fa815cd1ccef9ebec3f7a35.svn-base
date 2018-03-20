app.service("waringServer",function($http,$q){
	this.getWarningInfo = function(fence){
		var deferred = $q.defer();
//		$http.get("/welleplus/warning/getinfo.do?ids="+ids).success(function(data){
//			deferred.resolve(data);
//		}).error(function(){
//			deferred.reject("查询失败");
//		});
		$http({
			method:"post",
			url:"/welleplus/warning/getinfo.do",
			data:fence
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getWarningInfoForInfo = function(warning){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/warning/getinfoforinfo.do",
			data:warning,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getwarningbyfenceid = function(queryFence){
//		var deferred = $q.defer();
//		$http.get("/welleplus/warning/getwarningbyfenceid.do?id="+id).success(function(data){
//			deferred.resolve(data);
//		}).error(function(){
//			deferred.reject("查询失败");
//		});
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/warning/getwarningbyfenceid.do",
			data:queryFence,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
});