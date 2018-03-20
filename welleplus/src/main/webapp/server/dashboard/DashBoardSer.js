app.service("DashBoardSer",function($q,$http){
	this.getuserinfocount = function(fid,role){
		var deferred = $q.defer();
		$http.get("/welleplus/user/getcount.do?fid="+fid+"&role="+role).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		
		return deferred.promise;
	}
	
	this.getlocationofip = function(ip){
		var deferred = $q.defer();
		$http.get("http://restapi.amap.com/v3/ip?key=5c87838663300f4e7430a79582b0dc93&ip="+ip).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getlocationofip = function(){
		var deferred = $q.defer();
		$http.get("http://restapi.amap.com/v3/ip?key=5c87838663300f4e7430a79582b0dc93").success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
});