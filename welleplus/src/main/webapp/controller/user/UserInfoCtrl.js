app.controller("userInfoCtrl",function($scope,$rootScope,userServer){
	$rootScope.leftheight = "698px";
//	userServer.getUserInfos().then(function(data){
//		$scope.userinfos = data.data;
//	});
	$scope.user = {};
//	$scope.user.id = getCookie("welleplusuid");
	$scope.user.role = getCookie("welleplusrole"); 
	$scope.user.rid = getCookie("welleplusrid");
//	$scope.user.userName = getCookie("welleplususername");
	$rootScope.indexPage = 0;
	$scope.user.equiptype=4;
	$scope.user.equipstate=3;
	
	
	
	function pageselectCallback(page_index, jq){
		$scope.user.page = page_index;
		userServer.getuserinfos($scope.user).then(function(data){
			$rootScope.count = data.count;
			$rootScope.userinfos = data.data;
			$rootScope.indexPage = page_index;
		});
        return false;
    }
    
    function getOptionsFromForm(){
        var opt = {callback: pageselectCallback};
        opt.prev_text = "<<";
        opt.next_text = ">>";
        opt.items_per_page=10;
        opt.num_display_entries=4;
        opt.num_edge_entries=2;
        return opt;
    }
	
	userServer.getuserinfos($scope.user).then(function(data){
		$rootScope.userinfos = data.data;
		$rootScope.count = data.count;
		var optInit = getOptionsFromForm();
        $("#Pagination").pagination(data.count, optInit);
        
		$("#setoptions").click(function(){
            var opt = getOptionsFromForm();
            $("#Pagination").pagination(data.count, opt);
        });
	});
	
	$scope.searchuUserInfo = function(){
		userServer.getuserinfos($scope.user).then(function(data){
			$rootScope.userinfos = data.data;
			$rootScope.count = data.count;
			var optInit = getOptionsFromForm();
	        $("#Pagination").pagination(data.count, optInit);
	        
			$("#setoptions").click(function(){
	            var opt = getOptionsFromForm();
	            $("#Pagination").pagination(data.count, opt);
	        });
		});
	}
	
	
});