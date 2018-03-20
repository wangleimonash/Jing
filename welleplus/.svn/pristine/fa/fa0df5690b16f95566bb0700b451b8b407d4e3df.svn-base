app.service("rfidHistoryServer",function($q,$http){
	this.getRfidInfo = function(user){
		//console.log("getCount");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/rfid/getrfids.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		
		return deferred.promise;
	}
	
	this.getUserRfidInfo = function(user){
		//console.log("getCount");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/rfid/getUserRfidInfo.do",
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