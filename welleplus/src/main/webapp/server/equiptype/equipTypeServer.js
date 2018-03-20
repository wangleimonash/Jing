app.service("equipTypeServer",function($q,$http){
	this.gettypes = function(user){
		//console.log("getMaxInfos");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/equiptype/gettypes.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		
		return deferred.promise;
	}
	
	this.gettypestree = function(user){
		//console.log("getMaxInfos");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/equiptype/gettypestree.do",
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