app.controller('elepenCtrl',function($scope,$rootScope,fenceServer,projectService,$timeout){
	$rootScope.leftheight = "670px";
	$rootScope.mainheight = "580px";
	$scope.isShow = false;
	$scope.showEdit = false;
	$scope.showtree = true;
	$scope.ztreeshow = true;
	$scope.fence = {};
	$scope.editfence = {};
	$scope.fence.warningType = 0;
	$scope.selectnumber = 0;
	$scope.radionumber = 1;
	$scope.radioeditnumber = 1;
	$scope.fence.state = 1;
	$rootScope.lnglated = new Array();
	
	//绘制的围栏数量
	$scope.fencecount = 0;
	
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
	
	///////////////////////////////////树状图
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
		$scope.zNodes = data;
		$.fn.zTree.init($("#tree"), setting, $scope.zNodes);
	});
	
	$rootScope.gaodemap = new AMap.Map("container", {
        resizeEnable: true
    });	
	
	$rootScope.gaodemap.plugin(["AMap.ToolBar"], function() {
	});
	
	$scope.showandhidetree = function(){
    	$scope.showtree = !$scope.showtree;
    	if($scope.showtree){
    		$("#mymain").removeClass("col-xs-12");
    		$("#mymain").addClass("col-xs-10");
    		$scope.ztreeshow =true;
    	}else{
    		$("#mymain").removeClass("col-xs-10");
    		$("#mymain").addClass("col-xs-12");
    		$scope.ztreeshow =false;
    	}
    }
	
	$scope.searchPlace = function(){
    	AMap.service(["AMap.PlaceSearch"], function() {
            var placeSearch = new AMap.PlaceSearch({ //构造地点查询类
                pageSize: 5,
                pageIndex: 1,
                city: "上海", //城市
                map: $rootScope.gaodemap//,
                //panel: "panel"
            });
            placeSearch.search($scope.placeinfo, function(status, result) {
            });
            
        });
    }
	
    
    
    
    
    $scope.deletePen = function(){
    	if(!$rootScope.desc){
    		alert("请选择组织");
    		return;
    	}
    	if($rootScope.desc != 4){
    		alert("该组织无需编辑电子围栏");
    		return;
    	}
    	fenceServer.getFenceInfoFromPid($rootScope.descId).then(function(data){
    		if(data.state){
    			if(data.data!=null){
//    				if(confirm("您确定要删除"+$rootScope.thisname+"下的"+$scope.fenceName+"电子围栏吗?")){
    				if(confirm("您确定要删除电子围栏吗?")){
    		    		fenceServer.deleteInfo($rootScope.descId).then(function(data){
    		    			alert(data.message);
    		    			if(data.state){
    		    				$rootScope.gaodemap.clearMap();
    		    			}
    		    			
    		    		});
    		    	}
    			}else{
    				alert("该组织没有电子围栏");
    			}
    		}else{
    			alert("系统繁忙，请稍后再试");
    		}
    	});
    	
    }
    
    $scope.editPen = function(){
    	if(!$rootScope.desc){
    		alert("请选择组织");
    		return;
    	}
    	if($rootScope.desc != 4){
    		alert("该组织无需编辑电子围栏");
    		return;
    	}
//    	$rootScope.gaodemap.clearMap();
    	
    	fenceServer.getFenceInfoFromPid($rootScope.descId).then(function(data){
    		console.log(data);
    		if(data.state){
    			if(data.data!=null){
//    				$rootScope.gaodemap.clearMap();
    				$("#mymap").removeClass("col-xs-12");
    		    	$("#mymap").addClass("col-xs-7");
    		    	$scope.isShow = false;
    		    	$scope.showEdit = true;
    		    	$rootScope.lnglat = new Array();
    		    	
//    		    	$scope.editfence = data.data;
    		    	$scope.selecteditnumber = data.data.warningType;
    		    	$scope.editfence.name = data.data.name;
    		    	$("#editstartdate").val(data.data.startDate);
    		    	$("#editenddate").val(data.data.endDate);
    		    	$("#editworkstartdate").val(data.data.workstartdate);
    		    	$("#editworkenddate").val(data.data.workenddate);
    		    	$scope.radioeditnumber = data.data.state;
    		    	$scope.editfence.state = data.data.state;
    		    	$scope.editfence.warningType = data.data.warningType;
    		    	
    		    	console.log($scope.radioeditnumber);
    			}else{
    				alert("该组织没有电子围栏");
    			}
    		}else{
    			alert("操作失败");
    		}
    	});
    	
    }
    
    $scope.addPen = function(){
    	if(!$rootScope.desc){
    		alert("请选择组织");
    		return;
    	}
    	if($rootScope.desc != 4){
    		alert("该组织无法添加电子围栏");
    		return;
    	}
    	
    	$("#mymap").removeClass("col-xs-12");
    	$("#mymap").addClass("col-xs-7");
    	$scope.isShow = true;
    	$rootScope.lnglat = [];
    }
    
    $scope.closeAddPen = function(){
    	$("#mymap").removeClass("col-xs-7");
    	$("#mymap").addClass("col-xs-12");
    	$scope.isShow = false;
    	$scope.showEdit = false;
    	$rootScope.mouseTool.close(true);
//    	$rootScope.gaodemap.off('click',callbackfn);
    	$rootScope.gaodemap.clearMap();
    	
    	fenceServer.getFenceInfoFromPid($rootScope.descId).then(function(data){
    		if(data.state){
//    			$scope.fenceName = data.data.name;
    			var result = data.data;
    			console.log(result);
    			var polygonArr = [];
    			polygonArr.push([result.xloc,result.yloc]);
    			polygonArr.push([result.xloc1,result.yloc1]);
    			polygonArr.push([result.xloc2,result.yloc2]);
    			if(result.xloc3 && result.yloc3){
    				polygonArr.push([result.xloc3,result.yloc3]);
    			}
    			if(result.xloc4 && result.yloc4){
    				polygonArr.push([result.xloc4,result.yloc4]);
    			}
    			if(result.xloc5 && result.yloc5){
    				polygonArr.push([result.xloc5,result.yloc5]);
    			}
    			if(result.xloc6 && result.yloc6){
    				polygonArr.push([result.xloc6,result.yloc6]);
    			}
    			var  polygon = new AMap.Polygon({
    		        path: polygonArr,//设置多边形边界路径
    		        strokeColor: "#10171f", //线颜色
    		        strokeOpacity: 0.1, //线透明度
    		        strokeWeight: 5,    //线宽
    		        fillColor: "#f39c12", //填充色
    		        fillOpacity: 0.35,//填充透明度
    		        extData:result[0]
    		    });
    			
    		    polygon.setMap($rootScope.gaodemap);
    		    $rootScope.gaodemap.setZoom(16);
    		    $rootScope.gaodemap.setCenter([result.xloc3,result.yloc3]);
    		}
    	});
    }
    
    
    $scope.editFence = function(){
		console.log($rootScope.lnglat);
		if($rootScope.lnglat.length==0){
    		$rootScope.lnglat = $rootScope.lnglated;
    	}
		if(!$scope.editfence.name){
    		alert("请输入围栏名称");
    		return;
    	}
		if($scope.fencecount > 1){
			alert("只允许绘制一个电子围栏");
			$scope.fencecount = 0;
			$rootScope.gaodemap.clearMap();
			
			fenceServer.getFenceInfoFromPid($rootScope.descId).then(function(data){
        		if(data.state){
//        			$scope.fenceName = data.data.name;
        			var result = data.data;
        			console.log(result);
        			var polygonArr = [];
        			polygonArr.push([result.xloc,result.yloc]);
        			polygonArr.push([result.xloc1,result.yloc1]);
        			polygonArr.push([result.xloc2,result.yloc2]);
        			if(result.xloc3 && result.yloc3){
        				polygonArr.push([result.xloc3,result.yloc3]);
        			}
        			if(result.xloc4 && result.yloc4){
        				polygonArr.push([result.xloc4,result.yloc4]);
        			}
        			if(result.xloc5 && result.yloc5){
        				polygonArr.push([result.xloc5,result.yloc5]);
        			}
        			if(result.xloc6 && result.yloc6){
        				polygonArr.push([result.xloc6,result.yloc6]);
        			}
        			var  polygon = new AMap.Polygon({
        		        path: polygonArr,//设置多边形边界路径
        		        strokeColor: "#10171f", //线颜色
        		        strokeOpacity: 0.1, //线透明度
        		        strokeWeight: 5,    //线宽
        		        fillColor: "#f39c12", //填充色
        		        fillOpacity: 0.35,//填充透明度
        		        extData:result[0]
        		    });
        			
        		    polygon.setMap($rootScope.gaodemap);
        		    $rootScope.gaodemap.setZoom(16);
        		    $rootScope.gaodemap.setCenter([result.xloc2,result.yloc2]);
        		    
        		    $rootScope.lnglated = new Array();
        		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
//        		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
        		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
//        		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
        		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
//        		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
        		    if(result.xloc3 && result.yloc3){
        		    	$rootScope.lnglated.push(result.xloc3 + "," + result.yloc3);
        		    }
        		    if(result.xloc4 && result.yloc4){
        		    	$rootScope.lnglated.push(result.xloc4 + "," + result.yloc4);
        		    }
        		    if(result.xloc5 && result.yloc5){
        		    	$rootScope.lnglated.push(result.xloc5 + "," + result.yloc5);
        		    }
        		    if(result.xloc6 && result.yloc6){
        		    	$rootScope.lnglated.push(result.xloc6 + "," + result.yloc6);
        		    }
        		    
        		    
        		    console.log($rootScope.lnglated);
        			
        		}else{
        			$rootScope.lnglated = new Array();
        		}
        	});
			
			return;
		}
		
//    	if($rootScope.lnglat.length==0){
//    		alert("请在地图上绘制围栏");
//    		return;
//    	}
//    	if($rootScope.lnglat.length!=8){
//    		alert("只能选择4个点");
//    		return;
//    	}
    	
    	$scope.editfence.startDate = $("#editstartdate").val();
    	$scope.editfence.endDate = $("#editenddate").val();
    	$scope.editfence.workstartdate = $("#editworkstartdate").val();
    	$scope.editfence.workenddate = $("#editworkenddate").val();
    	$scope.editfence.pid = $rootScope.descId;
    	$scope.editfence.lnglat = $rootScope.lnglat;
    	console.log($scope.editfence);
    	fenceServer.updateInfo($scope.editfence).then(function(data){
    		console.log(data);
    		$scope.fencecount = 0;
    		if(data.state){
    			$rootScope.gaodemap.clearMap();
    			alert(data.message);
    			$("#mymap").removeClass("col-xs-7");
    	    	$("#mymap").addClass("col-xs-12");
    	    	$scope.isShow = false;
    	    	$scope.showEdit = false;
    	    	$rootScope.mouseTool.close(true);
//    	    	$rootScope.gaodemap.off('click',callbackfn);
    	    	
    	    	fenceServer.getFenceInfoFromPid($rootScope.descId).then(function(data){
	        		if(data.state){
//	        			$scope.fenceName = data.data.name;
	        			var result = data.data;
	        			console.log(result);
	        			var polygonArr = [];
	        			polygonArr.push([result.xloc,result.yloc]);
	        			polygonArr.push([result.xloc1,result.yloc1]);
	        			polygonArr.push([result.xloc2,result.yloc2]);
	        			if(result.xloc3 && result.yloc3){
	        				polygonArr.push([result.xloc3,result.yloc3]);
	        			}
	        			if(result.xloc4 && result.yloc4){
	        				polygonArr.push([result.xloc4,result.yloc4]);
	        			}
	        			if(result.xloc5 && result.yloc5){
	        				polygonArr.push([result.xloc5,result.yloc5]);
	        			}
	        			if(result.xloc6 && result.yloc6){
	        				polygonArr.push([result.xloc6,result.yloc6]);
	        			}
	        			var  polygon = new AMap.Polygon({
	        		        path: polygonArr,//设置多边形边界路径
	        		        strokeColor: "#10171f", //线颜色
	        		        strokeOpacity: 0.1, //线透明度
	        		        strokeWeight: 5,    //线宽
	        		        fillColor: "#f39c12", //填充色
	        		        fillOpacity: 0.35,//填充透明度
	        		        extData:result[0]
	        		    });
	        			
	        		    polygon.setMap($rootScope.gaodemap);
	        		    $rootScope.gaodemap.setZoom(16);
	        		    $rootScope.gaodemap.setCenter([result.xloc2,result.yloc2]);
	        		    
	        		    $rootScope.lnglated = new Array();
	        		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
//	        		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
	        		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
//	        		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
	        		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
//	        		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
	        		    if(result.xloc3 && result.yloc3){
	        		    	$rootScope.lnglated.push(result.xloc3 + "," + result.yloc3);
	        		    }
	        		    if(result.xloc4 && result.yloc4){
	        		    	$rootScope.lnglated.push(result.xloc4 + "," + result.yloc4);
	        		    }
	        		    if(result.xloc5 && result.yloc5){
	        		    	$rootScope.lnglated.push(result.xloc5 + "," + result.yloc5);
	        		    }
	        		    if(result.xloc6 && result.yloc6){
	        		    	$rootScope.lnglated.push(result.xloc6 + "," + result.yloc6);
	        		    }
	        		    
	        		    
	        		    console.log($rootScope.lnglated);
	        			
	        		}else{
	        			$rootScope.lnglated = new Array();
	        		}
	        	});
    		}else{
    			alert(data.message);
    		}
    	});
    }
    
    
    $scope.addFence = function(){
    	console.log($rootScope.lnglat);
    	if(!$scope.fence.name){
    		alert("请输入围栏名称");
    		return;
    	}
    	if($scope.fencecount == 0){
    		alert("请在地图商绘制围栏");
    		return;
    	}
    	if($scope.fencecount != 1){
    		alert("只允许绘制一个围栏");
    		$rootScope.gaodemap.clearMap();
    		$scope.fencecount = 0;
    		return;
    	}
//    	if($rootScope.lnglat.length==0){
//    		alert("请在地图上绘制围栏");
//    		return;
//    	}
//    	if($rootScope.lnglat.length!=8){
//    		alert("只能选择4个点");
//    		return;
//    	}
    	$scope.fence.lnglat = $rootScope.lnglat;
    	$scope.fence.startDate = $("#startdate").val();
    	$scope.fence.endDate = $("#enddate").val();
    	$scope.fence.workstartdate = $("#workstartdate").val();
    	$scope.fence.workenddate = $("#workenddate").val();
    	$scope.fence.pid = $rootScope.descId;
    	console.log($scope.fence);
    	$rootScope.gaodemap.clearMap();
    	fenceServer.addFenceInfo($scope.fence).then(function(data){
    		$scope.fencecount = 0;
    		if(data.state){
    			alert(data.message);
    			$scope.fence.name = "";
    			$scope.fence.startdate = "";
    			$scope.fence.enddate = "";
    			$scope.fence.warningType = 0;
    			$scope.fence.state = 1;
    			
    			$scope.number = 0;
    			$scope.radionumber = 1;
    			$("#startdate").val("");
    			$("#enddate").val("");
    			$("#workstartdate").val("");
    			$("#workenddate").val("");
    			
    			$("#mymap").removeClass("col-xs-7");
    	    	$("#mymap").addClass("col-xs-12");
    	    	$scope.isShow = false;
    			$rootScope.mouseTool.close(true);
//    			$rootScope.gaodemap.off('click',callbackfn);
    	    	
//    	    		$.ajax({
//    	    			url:"/welleplus/fence/getinfofrompid.do?pid="+$rootScope.descId,
//    	    			success:function(data){
//    	    				var result = data.data;
//    	        			console.log(result);
//    	        			var polygonArr = [];
//    	        			polygonArr.push([result.xloc,result.yloc]);
//    	        			polygonArr.push([result.xloc1,result.yloc1]);
//    	        			polygonArr.push([result.xloc2,result.yloc2]);
//    	        			polygonArr.push([result.xloc3,result.yloc3]);
//    	        			var  polygon = new AMap.Polygon({
//    	        		        path: polygonArr,//设置多边形边界路径
//    	        		        strokeColor: "#FF33FF", //线颜色
//    	        		        strokeOpacity: 0.2, //线透明度
//    	        		        strokeWeight: 10,    //线宽
//    	        		        fillColor: "#1791fc", //填充色
//    	        		        fillOpacity: 0.35,//填充透明度
//    	        		        extData:result[0]
//    	        		    });
//    	        			
//    	        		    polygon.setMap($rootScope.gaodemap);
//    	        		    $rootScope.gaodemap.setZoom(10);
//    	        		    $rootScope.gaodemap.setCenter([result.xloc3,result.yloc3]);
//    	    				console.log(3333);
//    	    			},
//    	    			error:function(){
//    	    				
//    	    			}
//    	    		});
    	    		
    	    		
    	    	}else{
    	    		alert(data.message);
    	    	}
	    		fenceServer.getFenceInfoFromPid($rootScope.descId).then(function(data){
	        		if(data.state){
	//        			$scope.fenceName = data.data.name;
	        			var result = data.data;
	        			console.log(result);
	        			var polygonArr = [];
	        			polygonArr.push([result.xloc,result.yloc]);
	        			polygonArr.push([result.xloc1,result.yloc1]);
	        			polygonArr.push([result.xloc2,result.yloc2]);
	        			if(result.xloc3 && result.yloc3){
	        				polygonArr.push([result.xloc3,result.yloc3]);
	        			}
	        			if(result.xloc4 && result.yloc4){
	        				polygonArr.push([result.xloc4,result.yloc4]);
	        			}
	        			if(result.xloc5 && result.yloc5){
	        				polygonArr.push([result.xloc5,result.yloc5]);
	        			}
	        			if(result.xloc6 && result.yloc6){
	        				polygonArr.push([result.xloc6,result.yloc6]);
	        			}
	        			var  polygon = new AMap.Polygon({
	        		        path: polygonArr,//设置多边形边界路径
	        		        strokeColor: "#10171f", //线颜色
	        		        strokeOpacity: 0.1, //线透明度
	        		        strokeWeight: 5,    //线宽
	        		        fillColor: "#f39c12", //填充色
	        		        fillOpacity: 0.35,//填充透明度
	        		        extData:result[0]
	        		    });
	        			
	        		    polygon.setMap($rootScope.gaodemap);
	        		    $rootScope.gaodemap.setZoom(16);
	        		    $rootScope.gaodemap.setCenter([result.xloc2,result.yloc2]);
	        		    
	        		    $rootScope.lnglated = new Array();
	        		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
//	        		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
	        		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
//	        		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
	        		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
//	        		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
	        		    if(result.xloc3 && result.yloc3){
	        		    	$rootScope.lnglated.push(result.xloc3 + "," + result.yloc3);
	        		    }
	        		    
//	        		    $rootScope.lnglated.push(result.xloc3 + "," + result.yloc3);
	        		    if(result.xloc4 && result.yloc4){
	        		    	$rootScope.lnglated.push(result.xloc4 + "," + result.yloc4);
	        		    }
	        		    if(result.xloc5 && result.yloc5){
	        		    	$rootScope.lnglated.push(result.xloc5 + "," + result.yloc5);
	        		    }
	        		    if(result.xloc6 && result.yloc6){
	        		    	$rootScope.lnglated.push(result.xloc6 + "," + result.yloc6);
	        		    }
	        			
	        		}
	        	});
    			
    	});
    }
    
    $scope.showandhidetree = function(){
    	$scope.showtree = !$scope.showtree;
    	if($scope.showtree){
    		$("#mymain").removeClass("col-xs-12");
    		$("#mymain").addClass("col-xs-10");
    		$scope.ztreeshow =true;
    	}else{
    		$("#mymain").removeClass("col-xs-10");
    		$("#mymain").addClass("col-xs-12");
    		$scope.ztreeshow =false;
    	}
    }
    
  //执行一个laydate实例
    laydate.render({
        elem: '#startdate' //指定元素
        , type: 'time'
        , format: 'HH:mm:ss' //可任意组合
//        ,min: '2000-01-01 00:00:00'
//        ,max: 'new Date()'
        , theme: '#393D49'
    });
    laydate.render({
        elem: '#enddate' //指定元素
        , type: 'time'
        , format: 'HH:mm:ss' //可任意组合
//        ,min: '2000-01-01 00:00:00'
//        ,max: 'new Date()'
        , theme: '#393D49'
    });
    
    laydate.render({
        elem: '#editstartdate' //指定元素
        , type: 'time'
        , format: 'HH:mm:ss' //可任意组合
//        ,min: '2000-01-01 00:00:00'
//        ,max: 'new Date()'
        , theme: '#393D49'
    });
    laydate.render({
        elem: '#editenddate' //指定元素
        , type: 'time'
        , format: 'HH:mm:ss' //可任意组合
//        ,min: '2000-01-01 00:00:00'
//        ,max: 'new Date()'
        , theme: '#393D49'
    });
    
    laydate.render({
    	elem: '#workstartdate',
    	type: 'time',
    	format: 'HH:mm:ss',
    	theme: '#393D49'
    });
    laydate.render({
    	elem: '#workenddate',
    	type: 'time',
    	format: 'HH:mm:ss',
    	theme: '#393D49'
    });
    laydate.render({
    	elem: '#editworkstartdate',
    	type: 'time',
    	format: 'HH:mm:ss',
    	theme: '#393D49'
    });
    laydate.render({
    	elem: '#editworkenddate',
    	type: 'time',
    	format: 'HH:mm:ss',
    	theme: '#393D49'
    });
    
    
    
    ///////////////////////////////////树状图
//    var setting = {
//			data: {
//				simpleData: {
//					enable: true
//				}
//			},
//			callback: {
//				onClick: onClick,
//			}
//		};
//    
//    projectService.getTreeInfo($scope.treeuser).then(function(data){
//		$scope.zNodes = data;
//		$.fn.zTree.init($("#tree"), setting, $scope.zNodes);
//	});
    
    function onClick(event, treeId, treeNode, clickFlag) {
    	var zTree = $.fn.zTree.getZTreeObj("tree");
    	zTree.expandNode(treeNode);
    	console.log(treeNode);
    	$rootScope.desc = treeNode.desc;
    	$rootScope.descId = treeNode.descId;
    	$rootScope.thisname = treeNode.name;
    	$rootScope.gaodemap.clearMap();
    	$("#mymap").removeClass("col-xs-7");
    	$("#mymap").addClass("col-xs-12");
    	$scope.isShow = false;
    	$scope.showEdit = false;
    	//获取电子围栏
    	if($rootScope.desc==4){
    		fenceServer.getFenceInfoFromPid($rootScope.descId).then(function(data){
        		if(data.state){
//        			$scope.fenceName = data.data.name;
        			var result = data.data;
        			console.log(result);
        			var polygonArr = [];
        			polygonArr.push([result.xloc,result.yloc]);
        			polygonArr.push([result.xloc1,result.yloc1]);
        			polygonArr.push([result.xloc2,result.yloc2]);
        			if(result.xloc3 && result.yloc3){
        				polygonArr.push([result.xloc3,result.yloc3]);
        			}
        			if(result.xloc4 && result.yloc4){
        				polygonArr.push([result.xloc4,result.yloc4]);
        			}
        			if(result.xloc5 && result.yloc5){
        				polygonArr.push([result.xloc5,result.yloc5]);
        			}
        			if(result.xloc6 && result.yloc6){
        				polygonArr.push([result.xloc6,result.yloc6]);
        			}
        			
        			var  polygon = new AMap.Polygon({
        		        path: polygonArr,//设置多边形边界路径
        		        strokeColor: "#10171f", //线颜色
        		        strokeOpacity: 0.1, //线透明度
        		        strokeWeight: 5,    //线宽
        		        fillColor: "#f39c12", //填充色
        		        fillOpacity: 0.35,//填充透明度
        		        extData:result[0]
        		    });
        			
        		    polygon.setMap($rootScope.gaodemap);
        		    $rootScope.gaodemap.setZoom(16);
        		    $rootScope.gaodemap.setCenter([result.xloc2,result.yloc2]);
        		    
        		    $rootScope.lnglated = new Array();
        		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
//        		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
        		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
//        		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
        		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
//        		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
        		    if(result.xloc3 && result.yloc3){
        		    	$rootScope.lnglated.push(result.xloc3 + "," + result.yloc3);
        		    }
        		    
//        		    $rootScope.lnglated.push(result.xloc3 + "," + result.yloc3);
        		    if(result.xloc4 && result.yloc4){
        		    	$rootScope.lnglated.push(result.xloc4 + "," + result.yloc4);
        		    }
        		    if(result.xloc5 && result.yloc5){
        		    	$rootScope.lnglated.push(result.xloc5 + "," + result.yloc5);
        		    }
        		    if(result.xloc6 && result.yloc6){
        		    	$rootScope.lnglated.push(result.xloc6 + "," + result.yloc6);
        		    }
        		    
        		    
        			
        		}else{
        			$rootScope.lnglated = new Array();
        		}
        	});
    	}
    	
    }
    
    $rootScope.gaodemap.plugin(["AMap.MouseTool"], function() {
	});
  
//    var callbackfn = function(e){
//        $rootScope.lnglat.push(e.lnglat.getLng() + ',' + e.lnglat.getLat());
//        console.log(e.lnglat.getLng() + ',' + e.lnglat.getLat());
//    }
    
    //在地图中添加MouseTool插件
    $timeout(function(){
    	$rootScope.mouseTool = new AMap.MouseTool($rootScope.gaodemap);
    	
    	AMap.event.addDomListener(document.getElementById('addPen'), 'click', function() {
        	if(!$scope.desc||$scope.desc!=4){
        		return;
        	}
        	$rootScope.lnglat = new Array();
//        	$rootScope.gaodemap.on('click', callbackfn);
            $rootScope.mouseTool.polygon();
            
        }, false);
        
        AMap.event.addDomListener(document.getElementById('editPen'), 'click', function() {
        	if(!$scope.desc||$scope.desc!=4){
        		return;
        	}
        	$rootScope.lnglat = new Array();
//        	$rootScope.gaodemap.on('click', callbackfn);
            $rootScope.mouseTool.polygon();
            
        }, false);
        
        $scope.remove = function(){
        	$rootScope.mouseTool.close(true);
        	console.log($rootScope.lnglat);
//        	$rootScope.gaodemap.off('click',callbackfn);
        }
        
        ///////////////////////////////////////////////////////////////////////////////////
//        围栏绘制完成后调用该方法
        AMap.event.addListener($rootScope.mouseTool, 'draw', function(type,obj) {
        	$rootScope.lnglat = [];
//        	console.log(2222333);
//        	$rootScope.mouseTool.close(true);
    		var polygonItem = type.obj;
    		var path = polygonItem.getPath();//取得绘制的多边形的每一个点坐标
    		if(path.length>7){
    			alert("最多只支持七个点");
    			$rootScope.gaodemap.clearMap();
    			
    			fenceServer.getFenceInfoFromPid($rootScope.descId).then(function(data){
            		if(data.state){
//            			$scope.fenceName = data.data.name;
            			var result = data.data;
            			console.log(result);
            			var polygonArr = [];
            			polygonArr.push([result.xloc,result.yloc]);
            			polygonArr.push([result.xloc1,result.yloc1]);
            			polygonArr.push([result.xloc2,result.yloc2]);
            			if(result.xloc3 && result.yloc3){
            				polygonArr.push([result.xloc3,result.yloc3]);
            			}
            			if(result.xloc4 && result.yloc4){
            				polygonArr.push([result.xloc4,result.yloc4]);
            			}
            			if(result.xloc5 && result.yloc5){
            				polygonArr.push([result.xloc5,result.yloc5]);
            			}
            			if(result.xloc6 && result.yloc6){
            				polygonArr.push([result.xloc6,result.yloc6]);
            			}
            			var  polygon = new AMap.Polygon({
            		        path: polygonArr,//设置多边形边界路径
            		        strokeColor: "#10171f", //线颜色
            		        strokeOpacity: 0.1, //线透明度
            		        strokeWeight: 5,    //线宽
            		        fillColor: "#f39c12", //填充色
            		        fillOpacity: 0.35,//填充透明度
            		        extData:result[0]
            		    });
            			
            		    polygon.setMap($rootScope.gaodemap);
            		    $rootScope.gaodemap.setZoom(16);
            		    $rootScope.gaodemap.setCenter([result.xloc2,result.yloc2]);
            		    
            		    $rootScope.lnglated = new Array();
            		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
//            		    $rootScope.lnglated.push(result.xloc + "," + result.yloc);
            		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
//            		    $rootScope.lnglated.push(result.xloc1 + "," + result.yloc1);
            		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
//            		    $rootScope.lnglated.push(result.xloc2 + "," + result.yloc2);
            		    if(result.xloc3 && result.yloc3){
            		    	$rootScope.lnglated.push(result.xloc3 + "," + result.yloc3);
            		    }
            		    if(result.xloc4 && result.yloc4){
            		    	$rootScope.lnglated.push(result.xloc4 + "," + result.yloc4);
            		    }
            		    if(result.xloc5 && result.yloc5){
            		    	$rootScope.lnglated.push(result.xloc5 + "," + result.yloc5);
            		    }
            		    if(result.xloc6 && result.yloc6){
            		    	$rootScope.lnglated.push(result.xloc6 + "," + result.yloc6);
            		    }
            		    
            		    
            		    console.log($rootScope.lnglated);
            			
            		}else{
            			$rootScope.lnglated = new Array();
            		}
            	});
    			
    			return;
    		}
    		for(var i=0;i<path.length;i++){
    			$rootScope.lnglat.push(path[i].lng + ',' + path[i].lat);
    		}
    		console.log(path);
    		console.log($rootScope.lnglat);
    		$scope.fencecount += 1;
    	});
    	
    },1000);
    
    
    
});