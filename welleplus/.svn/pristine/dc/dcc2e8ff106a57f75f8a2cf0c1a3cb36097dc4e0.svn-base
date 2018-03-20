app.service("sectionServer",function($http,$q){
	this.addSectionInfo = function(section){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/welleplus/section/addinfo.do",
			data:section,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject();
		});
		
		return deferred.promise;
	}
});