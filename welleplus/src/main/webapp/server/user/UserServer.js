app.service('userServer',function($http,$q){
	this.getUserInfos = function(){
		var deferred = $q.defer();
		$http.get("/welleplus/user/getinfos.do").success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getRoles = function(){
		var deferred = $q.defer();
		$http.get("/welleplus/data/role.json").success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.addUserInfo = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/addinfo.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("添加失败");
		});
		
		return deferred.promise;
	}
	
	this.getUserInfo = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getinfo.do",
			data:user,
//			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.deleteUserInfo = function(id){
		var deferred = $q.defer();
		$http.get("/welleplus/user/delUser.do?id="+id).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("删除失败");
		});
		
		return deferred.promise;
	}
	
	this.editUserInfo = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/editUser.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("编辑失败");
		});
		
		return deferred.promise;
	}
	
	this.getuserinfos = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getuserinfos.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
//	this.getjourinfo = function(user){
//		var deferred = $q.defer();
//		$http.get("/welleplus/user/getjourinfo.do?desc="+user.desc+"&descId="+user.descId+"&role="+user.role+"&rid="+user.rid+"&uid="+user.uid+"&page="+user.page+"&worktype="+user.worktype+"&name="+user.name+"&startdate="+user.startdate+"&enddate="+user.enddate).success(function(data){
//			deferred.resolve(data);
//		}).error(function(){
//			deferred.reject("查询失败");
//		});
//		
//		return deferred.promise;
//	}
	
	this.getjourinfo = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getjourinfo.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getUserInfoByRoleAndRid = function(ids){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getinfobyroleid.do",
			data:ids,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getUserInfoByIdsNew = function(ids){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getinfobyidsnew.do",
			data:ids,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getUserAndPositionByIds = function(ids){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getuserandpositionbyids.do",
			data:ids,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getUserInfoByRoleAndRidNew = function(ids){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getinfobyroleandridnew.do",
			data:ids,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject();
		});
		
		return deferred.promise;
	}
	
	this.getUserInfoDescByRoleAndRid = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getdescbyroleid.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getUserInfoDescByIds = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getdescbyids.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getWarningUserinfos = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getwarninguserinfos.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getwarninglist = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:'/welleplus/user/getwarninglist.do',
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.getUserInfoAndPosition = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/user/getuserinfoandposition.do",
			data:user,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject();
		});
		
		return deferred.promise;
	}
	
	this.getShouldWorkUser = function(id,role){
		var deferred = $q.defer();
		$http.get("/welleplus/user/getshouldworkuser.do?id="+id+"&role="+role).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject();
		});
		
		return deferred.promise;
	}
	
});