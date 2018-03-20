app.service("app_threeSer",function($http,$q){
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
	
	
	this.getliststree = function(section){
		var Section = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/drop/getliststree.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			Section.resolve(data);
		}).error(function(){
			Section.reject("查询失败");
		});
		
		return Section.promise;
	}
//	getliststree
	this.getliststree = function(user){
		//console.log("getMaxInfos");
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/drop/getliststree.do",
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