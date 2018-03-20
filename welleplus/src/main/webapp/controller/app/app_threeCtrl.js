app.controller('app_threeCtrl', function($rootScope,$scope,app_threeSer,projectService,userServer) {
    $scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");//用户名
	$scope.treeuser.role = getCookie("welleplusrole");//角色01234
	$scope.treeuser.rid = getCookie("welleplusrid");//角色id
	$scope.treeuser.id = getCookie("welleplusuid");//用户id
	
	$scope.user = {};
	$scope.user.role = $scope.treeuser.role;
	$scope.user.rid = $scope.treeuser.rid;
	$scope.user.uid = $scope.treeuser.id;
	$scope.user.page = 0;
	$rootScope.indexPage = 0;
	var date = new Date();
    var year = 1900 + date.getYear();
    var month = date.getMonth()+1;
    var day = date.getDate();
    var hour = date.getHours();
    var minutes = date.getMinutes();
    var second = date.getSeconds();
    $scope.user.startdate = year+"-"+month+"-"+day+" 00:00:00";
    $scope.user.enddate = year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+second;
	
	var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick,
			}
		};
	//构造树形结构组织
	projectService.getTreeInfo($scope.treeuser).then(function(data){
		$scope.zNodes = data;
		$.fn.zTree.init($("#tree"), setting, $scope.zNodes);
	});
	
	
	function pageselectCallback(page_index, jq){
		$scope.user.page = page_index;
		userServer.getjourinfo($scope.user).then(function(data){
			$rootScope.journalinfos = data.data;
			$rootScope.infocount = data.count;
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
//	
	function onClick(event, treeId, treeNode, clickFlag) {
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.expandNode(treeNode);
		console.log("event:"+event,"treeId:"+treeId,"treeNode:"+treeNode,"clickFlag:"+clickFlag);
		console.log(treeNode);
		
		$scope.user.desc = treeNode.desc;
		$scope.user.descId = treeNode.descId;
		$rootScope.desc = $scope.user.desc;
		$rootScope.descId = $scope.user.descId;
		$scope.user.startdate = $("#startdate").val();
	    $scope.user.enddate = $("#enddate").val();
		
		userServer.getjourinfo($scope.user).then(function(data){
			console.log(data);
			$rootScope.journalinfos = data.data;
			$rootScope.infocount = data.count;
			
			var optInit = getOptionsFromForm();
			$("#Pagination").pagination(data.count, optInit);
	        
			$("#setoptions").click(function(){
	            var opt = getOptionsFromForm();
	            $("#Pagination").pagination(data.count, opt);
	        });
		});
		
		$scope.role = treeNode.desc;
		var zTree = $.fn.zTree.getZTreeObj("tree");
	}
	
	$scope.searchJournalInfo = function(){
		$scope.user.desc = $rootScope.desc;
		$scope.user.descId = $rootScope.descId;
		$scope.user.startdate = $("#startdate").val();
	    $scope.user.enddate = $("#enddate").val();
		userServer.getjourinfo($scope.user).then(function(data){
			console.log(data);
			$rootScope.journalinfos = data.data;
			$rootScope.infocount = data.count;
			
			var optInit = getOptionsFromForm();
			$("#Pagination").pagination(data.count, optInit);
	        
			$("#setoptions").click(function(){
	            var opt = getOptionsFromForm();
	            $("#Pagination").pagination(data.count, opt);
	        });
		});
	}
	
	
	
	//时间
	laydate.render({
		elem: '#startdate' //指定元素
			, type: 'datetime'
				, format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//					,min: '2000-01-01 00:00:00'
//					,max: 'new Date()'
					, theme: '#393D49'
	});
	laydate.render({
		elem: '#enddate' //指定元素
			, type: 'datetime'
				, format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//					,min: '2000-01-01 00:00:00'
//					,max: 'new Date()'
					, theme: '#393D49'
	});
	
	
	$scope.engineer = {
		name : "t",
		currentActivity : "工种"
	};
	$scope.activities = [ "工种" ];
	

//	下拉
	app_threeSer.getdownbox($scope.treeuser).then(function(data){
		//console.log(data);
		$scope.activities = data.data;
	});	
	
		
		
//		页面加载加载所有表单数据
		app_threeSer.getsurfacedata($scope.treeuser).then(function(data){
			console.log(data.data);
			$scope.userinfos = data.data;
			console.log(data.name);
		
		});
		
		
		
		
		
});

app.directive("appinfo",function($rootScope,$document){
	return{
		restrict:"E",
		require:"ngModel",
		link:function(scope,element,attrs,ngModel){
			element.bind("click",function(){
					var id = ngModel.$modelValue.id;
					scope.$apply(function(){
						for(var i=0;i<scope.journalinfos.length;i++){
							if(scope.journalinfos[i].id == id){
								$("#myappbutton").click();
								console.log(ngModel.$modelValue);
								var result = ngModel.$modelValue;
								$rootScope.journalInfos = result;
								
							}
						}
					});
			});
		}
	}
});