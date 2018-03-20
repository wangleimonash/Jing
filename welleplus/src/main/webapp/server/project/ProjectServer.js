app.service("projectService",function($http,$q){
	this.getTreeInfo = function(user){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/project/gettree.do",
			data:user,
			dataType:"json",
			cache: true
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});
		
		return deferred.promise;
		
//		$http.get("/welleplus/project/gettree.do").success(function(data){
//			deferred.resolve(data);
//		}).error(function(){
//			deferred.reject("查询失败");
//		});
//		
//		return deferred.promise;
	}
	
	this.addProjectInfo = function(project){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/project/addinfo.do",
			data:project,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("添加失败");
		});
		
		return deferred.promise;
	}
	
	this.getDownMenu = function(desc,descId,role,id,rid){
		var deferred = $q.defer();
		$http.get("/welleplus/project/getdownmenu.do?desc="+desc+"&descId="+descId+"&role="+role+"&id="+id+"&rid="+rid).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		});
		
		return deferred.promise;
	}
	
	this.updteTreeName = function(desc,descId,name){
		var deferred = $q.defer();
		$http.get("/welleplus/project/updtetreename.do?desc="+desc+"&descId="+descId+"&name="+name).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("更新失败");
		});
		
		return deferred.promise;
	}
	
	this.deleteTreeNode = function(desc,descId){
		var deferred = $q.defer();
		$http.get("/welleplus/project/deletetreenode.do?desc="+desc+"&descId="+descId).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("删除失败");
		});
		
		return deferred.promise;
	}
});