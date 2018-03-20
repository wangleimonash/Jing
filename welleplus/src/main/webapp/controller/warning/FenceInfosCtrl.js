app.controller("fenceInfoCtrl",function($scope,$rootScope,fenceServer,waringServer){
	$scope.fence = {};
	$rootScope.leftheight = "723px";
//	$scope.fence.role = 0;
//	$scope.fence.rid = 0;
//	$scope.fence.uid = 0;
//	$scope.fence.desc = 0;
//	$scope.fence.descId = 0;
//	
//	$scope.treeuser.userName = getCookie("welleplususername");
//	$scope.treeuser.role = getCookie("welleplusrole");
//	$scope.treeuser.rid = getCookie("welleplusrid");
//	$scope.treeuser.id = getCookie("welleplusuid");
	
	$scope.fence.role = getCookie("welleplusrole");
	$scope.fence.rid = getCookie("welleplusrid");
	$scope.fence.uid = getCookie("welleplusuid");
	$scope.fence.desc = $scope.fence.role;
	$scope.fence.descId = $scope.fence.rid;
	
	$scope.fence.page = 0;
	$scope.indexPage = 0;
	
	$rootScope.queryFence = {};
	$rootScope.queryFence.warningType = 0;
	
//	格式化时间
	Date.prototype.Format = function (fmt) {  
	    var o = {  
	        "M+": this.getMonth() + 1, //月份  
	        "d+": this.getDate(), //日  
	        "h+": this.getHours(), //小时  
	        "m+": this.getMinutes(), //分  
	        "s+": this.getSeconds(), //秒  
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度  
	        "S": this.getMilliseconds() //毫秒  
	    };  
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
	    for (var k in o)  
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
	    return fmt;  
	}  
	
//	var startdate = new Date();
//	var enddate = new Date(startdate.getTime()-1000*60*60*24*7);
//	var startdatestr = startdate.Format('yyyy-MM-dd hh:mm:ss');
//	var enddatestr = enddate.Format('yyyy-MM-dd hh:mm:ss');
//	console.log(startdatestr);
//	console.log(enddatestr);
//	$("#fenceStartDate").val(startdatestr);
//	$("#fenceEndDate").val(enddatestr);
	
	function pageselectCallback(page_index, jq){
//		$scope.warning.page = page_index;
//		waringServer.getWarningInfoForInfo($scope.warning).then(function(data){
//			$rootScope.count = data.count;
//			$rootScope.warninginfos = data.data;
//			$rootScope.indexPage = page_index;
//		});
		$scope.fence.page = page_index;
		fenceServer.getFenceInfos($scope.fence).then(function(data){
			$scope.fenceinfos = data.data;
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
	
	fenceServer.getFenceInfos($scope.fence).then(function(data){
//		console.log(data);
		if(data.state){
			$scope.fenceinfos = data.data;
			$scope.count = data.count;
			
			var optInit = getOptionsFromForm();
	        $("#Pagination").pagination(data.count, optInit);
	        
			$("#Pagination").click(function(){
	            var opt = getOptionsFromForm();
	            $("#Pagination").pagination(data.count, opt);
	        }); 
			
		}else{
			$scope.fenceinfos = {};
		}
	});
	
	laydate.render({
	    elem: '#fenceStartDate' //指定元素
	    , type: 'datetime'
	    , format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//	    ,min: '2000-01-01 00:00:00'
//	    ,max: 'new Date()'
	    , theme: '#393D49'
	});
	laydate.render({
	    elem: '#fenceEndDate' //指定元素
	    , type: 'datetime'
	    , format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//	    ,min: '2000-01-01 00:00:00'
//	    ,max: 'new Date()'
	    , theme: '#393D49'
	});
	
	function warnPageselectCallback(page_index, jq){
		$rootScope.queryFence.page = page_index;
		waringServer.getwarningbyfenceid($rootScope.queryFence).then(function(data){
			if(data.state){
				$rootScope.fencewarninginfos = data.data;
				$rootScope.warningcount = data.count;
				$rootScope.warnIndexPage = page_index;
			}else{
				$rootScope.fencewarninginfos = {};
				$rootScope.warningcount = 0;
				$rootScope.warnIndexPage = 0;
			}
		});
	    return false;
	}

	function getWarnOptionsFromForm(){
	    var opt = {callback: warnPageselectCallback};
	    opt.prev_text = "<<";
	    opt.next_text = ">>";
	    opt.items_per_page=10;
	    opt.num_display_entries=4;
	    opt.num_edge_entries=2;
	    return opt;
	}
	
	$scope.searchInfo = function(){
		$rootScope.queryFence.startDate = $("#fenceStartDate").val();
		$rootScope.queryFence.endDate = $("#fenceEndDate").val();
		$rootScope.queryFence.page = 0;
		$rootScope.warnIndexPage = 0;
		
		waringServer.getwarningbyfenceid($rootScope.queryFence).then(function(data){
//			console.log(data);
			if(data.state){
				$rootScope.fencewarninginfos = data.data;
				$rootScope.fencewarninginfos.warncount = data.count;
				var optInit = getWarnOptionsFromForm();
		        $("#warnPagination").pagination(data.count, optInit);
		        
				$("#warnPagination").click(function(){
		            var opt = getOptionsFromForm();
		            $("#warnPagination").pagination(data.count, opt);
		        });
			}else{
				$rootScope.fencewarninginfos = {};
			}
			
		});
	}
});



app.directive("fenceop",function($rootScope,$document,userServer,waringServer){
	function getWarnOptionsFromForm(){
	    var opt = {callback: warnPageselectCallback};
	    opt.prev_text = "<<";
	    opt.next_text = ">>";
	    opt.items_per_page=10;
	    opt.num_display_entries=4;
	    opt.num_edge_entries=2;
	    return opt;
	};
	function warnPageselectCallback(page_index, jq){
		$rootScope.queryFence.page = page_index;
		waringServer.getwarningbyfenceid($rootScope.queryFence).then(function(data){
			if(data.state){
				$rootScope.fencewarninginfos = data.data;
				$rootScope.warningcount = data.count;
				$rootScope.warnIndexPage = page_index;
			}else{
				$rootScope.fencewarninginfos = {};
				$rootScope.warningcount = 0;
				$rootScope.warnIndexPage = 0;
			}
		});
		
	    return false;
	};
	return{
		restrict:"E",
		require:"ngModel",
		link:function(scope,element,attrs,ngModel){
			element.bind("click",function(){
//				console.log(ngModel.$modelValue);
				var enddate = new Date();
				var startdate = new Date(enddate.getTime()-1000*60*60*24*7);
				var startdatestr = startdate.Format('yyyy-MM-dd hh:mm:ss');
				var enddatestr = enddate.Format('yyyy-MM-dd hh:mm:ss');
//				console.log(startdatestr);
//				console.log(enddatestr);
				$("#fenceStartDate").val(startdatestr);
				$("#fenceEndDate").val(enddatestr);
				
				var id = ngModel.$modelValue.id;
				$rootScope.queryFence = {};
				$rootScope.queryFence.warningType = 0;
//				$("#fenceStartDate").val("");
//				$("#fenceEndDate").val("");
				$rootScope.queryFence.id = id;
				$rootScope.fencewarninginfo = {};
				$rootScope.fencewarninginfo.name = ngModel.$modelValue.name;
				var fencestate = ngModel.$modelValue.state;
				if(fencestate=="1"){
					$rootScope.fencewarninginfo.state = "开启";
				}else{
					$rootScope.fencewarninginfo.state = "关闭";
				}
				var warningtype = ngModel.$modelValue.warningType;
				if(warningtype=="0"){
					$rootScope.fencewarninginfo.warningtypestr = "无报警";
				}else if(warningtype=="1"){
					$rootScope.fencewarninginfo.warningtypestr = "进围栏报警";
				}else if(warningtype == "2"){
					$rootScope.fencewarninginfo.warningtypestr = "出围栏报警";
				}else if(warningtype == "3"){
					$rootScope.fencewarninginfo.warningtypestr = "进出围栏报警";
				}
				$rootScope.fencewarninginfo.startDate = ngModel.$modelValue.startDate;
				$rootScope.fencewarninginfo.endDate = ngModel.$modelValue.endDate;
				
				$rootScope.fencewarninginfo.discribe = ngModel.$modelValue.discribe;
				
				$rootScope.queryFence.startDate = $("#fenceStartDate").val();
				$rootScope.queryFence.endDate = $("#fenceEndDate").val();
				$rootScope.queryFence.page = 0;
				$rootScope.warnIndexPage = 0;
				scope.$apply(function(){
					$("#fenceinfosbutton").click();
					waringServer.getwarningbyfenceid($rootScope.queryFence).then(function(data){
						console.log(data);
						if(data.state){
							$rootScope.fencewarninginfos = data.data;
							$rootScope.warningcount = data.count;
							var optInit = getWarnOptionsFromForm();
					        $("#warnPagination").pagination(data.count, optInit);
					        
							$("#warnPagination").click(function(){
					            var opt = getOptionsFromForm();
					            $("#warnPagination").pagination(data.count, opt);
					        });
						}else{
							$rootScope.fencewarninginfos = {};
							$rootScope.warningcount = 0;
						}
						
					});
				});
			});
		}
	}
});