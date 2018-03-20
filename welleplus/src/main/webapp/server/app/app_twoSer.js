app.service("app_twoSer",function($http,$q){
//	gettwolists表单二未点击树分页

	this.gettwolists = function(section){
		//console.log("getMaxInfos");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/once/gettwolists.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		return deferred.promise;
	}
	
	
	this.getdownbox = function(section){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/drop/getboxone.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	


	this.getsurfacedata = function(section){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/drop/getsurfacedata.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	
	this.getSectiondata= function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/drop/getsectiondata.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		
		return Section.promise;
	}
	
	this.getEngineering = function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/drop/getengineering.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		
		return Section.promise;
	}
	this.getConstruction = function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/drop/getconstruction.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		
		return Section.promise;
	}
	this.getTeam = function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/drop/getteam.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		
		return Section.promise;
	}
	
	
	this.getLocation = function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/once/getlocation.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		
		return Section.promise;
	}
	
	
	
	
	
	this.gettwohistorydata = function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/once/gettwohistorydata.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		
		return Section.promise;
	}
//	getworkdata

	this.getworkdata = function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/once/getworkdata.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		
		return Section.promise;
	}
//	点击树加载数据
//	getAttendanceinfo
	this.getAttendanceinfo = function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/once/getAttendanceinfo.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		return Section.promise;
};
//查询
//getliststree
this.getliststree = function(user){
	//console.log("getMaxInfos");
	var deferred = $q.defer();
	$http({
		method:"post",
		url:"/welleplus/once/getliststree.do",
		data:user,
		dataType:"json"
	}).success(function(data){
		deferred.resolve(data);
	}).error(function(){
		deferred.reject("查询失败")
	});
//	getlists
	return deferred.promise;
}

//else查询
//getlists
this.getlists = function(user){
	//console.log("getMaxInfos");
	var deferred = $q.defer();
	$http({
		method:"post",
		url:"/welleplus/once/getlists.do",
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