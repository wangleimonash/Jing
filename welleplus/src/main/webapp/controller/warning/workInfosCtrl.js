app.controller("workInfoCtrl",function($scope,$rootScope,projectService,fenceServer){
	$rootScope.leftheight = "630px";
	$rootScope.mainheight = "546px";
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
	
	$scope.userinfos = {};
	
	$scope.fence = {};
//	$scope.fence.role = $scope.treeuser.role;
//	$scope.fence.rid = $scope.treeuser.rid;
//	$scope.fence.uid = $scope.treeuser.id;
	$scope.indexPage = 0;
	
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
    
    projectService.getTreeInfo($scope.treeuser).then(function(data){
    	var startdate = new Date();
    	var enddate = new Date(startdate.getTime()-1000*60*60*24*7);
    	var startdatestr = startdate.Format('yyyy-MM-dd');
    	var enddatestr = enddate.Format('yyyy-MM-dd');
    	$("#fenceStartDate").val(enddatestr);
    	$("#fenceEndDate").val(startdatestr);
    	
		$scope.zNodes = data;
		$.fn.zTree.init($("#tree"), setting, $scope.zNodes);
		
//		$scope.fence.desc = $scope.zNodes[0].desc;
//		$scope.fence.descId = $scope.zNodes[0].descId;
//		fenceServer.getWorkInfos($scope.fence).then(function(data){
//    		if(data.state){
//    			$scope.userinfos = data.data;
//    		}else{
//    			$scope.userinfos = {};
//    		}
//    	})
		
		var zTree = $.fn.zTree.getZTreeObj("tree");
		var result = zTree.getNodes();
		
		var treeNode = result[0];
		
		ids = [];
		
		if(treeNode.desc!=4){
    		if(treeNode.children){
    			var result = treeNode.children;
    			for(var i=0;i<result.length;i++){
    				if(result[i].desc!=4){
    					if(result[i].children){
    						var result1 = result[i].children;
    						for(var j=0;j<result1.length;j++){
    							if(result1[j].desc!=4){
    								if(result1[j].children){
    									var result2 = result1[j].children;
    									for(var k=0;k<result2.length;k++){
    										ids.push(result2[k].descId);
    									}
    								}
    							}else{
    								ids.push(result1[j].descId);
    							}
    						}
    					}
    				}else{
    					ids.push(result[i].descId);
    				}
    			}
    		}
    	}else{
    		ids.push(treeNode.descId);
    	}
		
		$scope.fence.ids = ids;
    	$scope.fence.page = 0;
    	$scope.indexPage = 0;
    	$scope.fence.startDate = $("#fenceStartDate").val();
    	$scope.fence.endDate = $("#fenceEndDate").val();
		
    	fenceServer.getNewWorkInfos($scope.fence).then(function(data){
//    		console.log(data);
    		if(data.state){
    			$scope.userinfos = data.data;
    			$scope.count = data.count;
    			var optInit = getOptionsFromForm();
    	        $("#Pagination").pagination(data.count, optInit);
    	        
    			$("#Pagination").click(function(){
    	            var opt = getOptionsFromForm();
    	            $("#Pagination").pagination(data.count, opt);
    	        });
    		}else{
    			$scope.userinfos = {};
    		}
    	});
		
	});
    
    $scope.searchInfo = function(){
    	$scope.fence.page = 0;
    	$scope.indexPage = 0;
    	$scope.fence.startDate = $("#fenceStartDate").val();
    	$scope.fence.endDate = $("#fenceEndDate").val();
    	fenceServer.getNewWorkInfos($scope.fence).then(function(data){
    		if(data.state){
    			$scope.userinfos = data.data;
    			$scope.count = data.count;
    			var optInit = getOptionsFromForm();
    	        $("#Pagination").pagination(data.count, optInit);
    	        
    			$("#Pagination").click(function(){
    	            var opt = getOptionsFromForm();
    	            $("#Pagination").pagination(data.count, opt);
    	        });
    		}else{
    			$scope.userinfos = {};
    		}
    	});
    }
    
    function pageselectCallback(page_index, jq){
    	$scope.userinfos = {};
		$scope.fence.page = page_index;
		fenceServer.getNewWorkInfos($scope.fence).then(function(data){
			$scope.userinfos = data.data;
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
    
    
    
    function onClick(event, treeId, treeNode, clickFlag) {
    	var zTree = $.fn.zTree.getZTreeObj("tree");
    	zTree.expandNode(treeNode);
    	console.log(treeNode);
    	$scope.indexPage = 0;
    	
//    	$scope.fence.desc = treeNode.desc;
//    	$scope.fence.descId = treeNode.descId;
    	$scope.userinfos = {};
    	
    	ids = [];
    	if(treeNode.desc!=4){
    		if(treeNode.children){
    			var result = treeNode.children;
    			for(var i=0;i<result.length;i++){
    				if(result[i].desc!=4){
    					if(result[i].children){
    						var result1 = result[i].children;
    						for(var j=0;j<result1.length;j++){
    							if(result1[j].desc!=4){
    								if(result1[j].children){
    									var result2 = result1[j].children;
    									for(var k=0;k<result2.length;k++){
    										ids.push(result2[k].descId);
    									}
    								}
    							}else{
    								ids.push(result1[j].descId);
    							}
    						}
    					}
    				}else{
    					ids.push(result[i].descId);
    				}
    			}
    		}
    	}else{
    		ids.push(treeNode.descId);
    	}
    	
    	console.log(ids);
    	$scope.fence.ids = ids;
    	$scope.fence.page = 0;
    	$scope.indexPage = 0;
    	$scope.fence.startDate = $("#fenceStartDate").val();
    	$scope.fence.endDate = $("#fenceEndDate").val();
    	fenceServer.getNewWorkInfos($scope.fence).then(function(data){
//    		console.log(data);
    		if(data.state){
    			$scope.userinfos = data.data;
    			$scope.count = data.count;
    			var optInit = getOptionsFromForm();
    	        $("#Pagination").pagination(data.count, optInit);
    	        
    			$("#Pagination").click(function(){
    	            var opt = getOptionsFromForm();
    	            $("#Pagination").pagination(data.count, opt);
    	        });
    		}else{
    			$scope.userinfos = {};
    		}
    	});
    	
//    	fenceServer.getWorkInfos($scope.fence).then(function(data){
//    		console.log(data);
//    		if(data.state){
//    			$scope.userinfos = data.data;
//    		}else{
//    			$scope.userinfos = {};
//    		}
//    	})
    	
    }
    
    laydate.render({
	    elem: '#fenceStartDate' //指定元素
	    , type: 'date'
	    , format: 'yyyy-MM-dd' //可任意组合
//	    ,min: '2000-01-01 00:00:00'
//	    ,max: 'new Date()'
	    , theme: '#393D49'
	});
	laydate.render({
	    elem: '#fenceEndDate' //指定元素
	    , type: 'date'
	    , format: 'yyyy-MM-dd' //可任意组合
//	    ,min: '2000-01-01 00:00:00'
//	    ,max: 'new Date()'
	    , theme: '#393D49'
	});
});

app.directive("userworkop",function($rootScope,$document,userServer,waringServer,equipLocationServer){
	return{
		restrict:"E",
		require:"ngModel",
		link:function(scope,element,attrs,ngModel){
			element.bind("click",function(){
				console.log(ngModel.$modelValue);
				var equipnumber = ngModel.$modelValue.equipnumber;
				$rootScope.equipTypeStr = ngModel.$modelValue.equipTypeStr;
				$rootScope.equipNumber = ngModel.$modelValue.equipnumber;
				var startDate = $("#fenceStartDate").val();
				var endDate = $("#fenceEndDate").val();
				scope.$apply(function(){
					$("#workdaysinfosbutton").click();
					$rootScope.workpositions = {};
					equipLocationServer.getWorkPosition(equipnumber,startDate,endDate).then(function(data){
						console.log(data);
						if(data.state){
							$rootScope.workpositions = data.data;
						}else{
							$rootScope.workpositions = {};
						}
					});
				});
			});
		}
	}
});