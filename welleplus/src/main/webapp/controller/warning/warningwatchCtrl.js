app.controller("warningwatchCtrl",function($scope,$rootScope,userServer){
	$rootScope.leftheight = "638px";
	$rootScope.mainheight = "588px";
	$scope.user = {};
	$scope.user.role = getCookie("welleplusrole"); 
	$scope.user.rid = getCookie("welleplusrid");
	$scope.user.equiptype=4;
	$scope.user.equipstate=3;
	$scope.user.page = 0;
	$scope.indexPage = 0;
	
	$scope.searchInfo = function(){
		$scope.user.page = 0;
		$scope.indexPage = 0;
		$scope.user.startdate = $("#startdate").val();
		$scope.user.enddate = $("#enddate").val();
		userServer.getwarninglist($scope.user).then(function(data){
			$rootScope.watchwarninginfos = data.data;
			$scope.count = data.count;
			
			
			var optInit = getOptionsFromForm();
	        $("#Pagination").pagination(data.count, optInit);
	        
			$("#setoptions").click(function(){
	            var opt = getOptionsFromForm();
	            $("#Pagination").pagination(data.count, opt);
	        });
		});
	}
	
	$scope.searchInfo();
	
//	userServer.getwarninglist($scope.user).then(function(data){
//		$scope.warninginfos = data.data;
//		$scope.count = data.count;
//		
//		var optInit = getOptionsFromForm();
//        $("#Pagination").pagination(data.count, optInit);
//        
//		$("#setoptions").click(function(){
//            var opt = getOptionsFromForm();
//            $("#Pagination").pagination(data.count, opt);
//        });
//	});
	
	function pageselectCallback(page_index, jq){
		$scope.user.page = page_index;
		userServer.getwarninglist($scope.user).then(function(data){
			$scope.count = data.count;
			$rootScope.watchwarninginfos = data.data;
			$scope.indexPage = page_index;
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
})