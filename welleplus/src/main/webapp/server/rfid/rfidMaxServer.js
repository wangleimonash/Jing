app.service("rfidMaxServer",function($q,$http){
	this.getMaxInfos = function(user){
		//console.log("getMaxInfos");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/rfid/getmaxrfid.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		
		return deferred.promise;
	}
	this.getCount = function(user){
		//console.log("getCount");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/rfid/getCount.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		
		return deferred.promise;
	}
});