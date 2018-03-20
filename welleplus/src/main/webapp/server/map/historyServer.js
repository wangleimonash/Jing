app.service("historyServer",function($q,$http){
	this.getHistory = function(map){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/map/getHistory.do",
			// data:$.param({"name":map.name}),
			data:map,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("  ");
		});
		
		return deferred.promise;
	}
});