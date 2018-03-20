app.service("equipLocationServer",function($q,$http){
	this.getlists = function(user){
		//console.log("getMaxInfos");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/equiplocation/getlists.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		
		return deferred.promise;
	}
	
	this.getliststree = function(user){
		//console.log("getMaxInfos");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/equiplocation/getliststree.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		
		return deferred.promise;
	}
	
	this.getWorkPosition = function(imei,startDate,endDate){
		var deferred = $q.defer();
		$http.get("/welleplus/equiplocation/getworkposition.do?imei="+imei+"&startDate="+startDate+"&endDate="+endDate).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
});