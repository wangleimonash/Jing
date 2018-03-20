app.controller("warningCtrl",function($scope,$rootScope,waringServer){
//	$rootScope.leftheight = "683px";
	$rootScope.leftheight = "630px";
	$rootScope.mainheight = "580px";
	$scope.warning = {};
	$scope.warning.user = {};
	$scope.warning.fence = {};
	$scope.warning.fence.warningType = 0;
	
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
	
	$scope.warning.user.id = $scope.treeuser.id;
	$scope.warning.user.rid = $scope.treeuser.rid;
	$scope.warning.user.role = $scope.treeuser.role;
	$scope.warning.page = 0;
	$rootScope.indexPage = 0;
	waringServer.getWarningInfoForInfo($scope.warning).then(function(data){
		$rootScope.warninginfos = data.data;
		$rootScope.count = data.count;
		
		var optInit = getOptionsFromForm();
        $("#Pagination").pagination(data.count, optInit);
        
		$("#setoptions").click(function(){
            var opt = getOptionsFromForm();
            $("#Pagination").pagination(data.count, opt);
        }); 
	});
	
	function pageselectCallback(page_index, jq){
		$scope.warning.page = page_index;
		waringServer.getWarningInfoForInfo($scope.warning).then(function(data){
			$rootScope.count = data.count;
			$rootScope.warninginfos = data.data;
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
	
	$scope.searchInfo = function(){
		$scope.warning.startDate = $("#startdate").val();
		$scope.warning.endDate = $("#enddate").val();
		console.log($scope.warning);
		waringServer.getWarningInfoForInfo($scope.warning).then(function(data){
			$scope.warninginfos = data.data;
			
			$rootScope.count = data.count;
			
			var optInit = getOptionsFromForm();
	        $("#Pagination").pagination(data.count, optInit);
	        
			$("#setoptions").click(function(){
	            var opt = getOptionsFromForm();
	            $("#Pagination").pagination(data.count, opt);
	        }); 
		});
	}
	
	
	//执行一个laydate实例
    laydate.render({
        elem: '#startdate' //指定元素
        , type: 'datetime'
        , format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//        ,min: '2000-01-01 00:00:00'
//        ,max: 'new Date()'
        , theme: '#393D49'
    });
    laydate.render({
        elem: '#enddate' //指定元素
        , type: 'datetime'
        , format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//        ,min: '2000-01-01 00:00:00'
//        ,max: 'new Date()'
        , theme: '#393D49'
    });
});