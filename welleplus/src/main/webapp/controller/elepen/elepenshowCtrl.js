app.controller("elepenshowCtrl",function($scope,$rootScope,projectService,fenceServer,waringServer){
	$rootScope.leftheight = "671px";
	$rootScope.mainheight = "580px";
	$scope.showtree = true;
	$scope.ztreeshow =true;
	$scope.fence = {};
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
	$scope.fence.role = $scope.treeuser.role;
	$scope.fence.rid = $scope.treeuser.rid;
	$scope.fence.uid = $scope.treeuser.id;
	$rootScope.showmap = new AMap.Map("container", {
        resizeEnable: true
    });	
	$rootScope.showmap.plugin(["AMap.ToolBar"], function() {
	});
	
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
    
    function onClick(event, treeId, treeNode, clickFlag) {
    	var zTree = $.fn.zTree.getZTreeObj("tree");
    	zTree.expandNode(treeNode);
//    	$scope.desc = treeNode.desc;
//    	$scope.descId = treeNode.descId;
//    	$scope.fence.desc = $scope.desc;
//    	$scope.fence.descId = $scope.descId;
    	$scope.fence.desc = treeNode.desc;
    	$scope.fence.descId = treeNode.descId;
//    	console.log(treeNode);
//    	console.log($scope.fence);
    	$rootScope.showmap.clearMap();
    	fenceServer.getInfoFromId($scope.fence).then(function(data){
//    		$rootScope.showmap.clearMap();
    		if(data.data&&data.data.length!=0){
    			var result = data.data;
        		console.log(result);
        		var polygons = [];
        		var ids = [];
        		
        		for(var i=0;i<result.length;i++){
        			var polygonArr = [];
        			polygonArr.push([result[i].xloc,result[i].yloc]);
        			polygonArr.push([result[i].xloc1,result[i].yloc1]);
        			polygonArr.push([result[i].xloc2,result[i].yloc2]);
        			if(result[i].xloc3 && result[i].yloc3){
        				polygonArr.push([result[i].xloc3,result[i].yloc3]);
        			}
        			if(result[i].xloc4 && result[i].yloc4){
        				polygonArr.push([result[i].xloc4,result[i].yloc4]);
        			}
        			if(result[i].xloc5 && result[i].yloc5){
        				polygonArr.push([result[i].xloc5,result[i].yloc5]);
        			}
        			if(result[i].xloc6 && result[i].yloc6){
        				polygonArr.push([result[i].xloc6,result[i].yloc6]);
        			}
        			
        			ids.push(result[i].id);
        			
        			var  polygon = new AMap.Polygon({
        		        path: polygonArr,//设置多边形边界路径
        		        strokeColor: "#10171f", //线颜色
        		        strokeOpacity: 0.1, //线透明度
        		        strokeWeight: 5,    //线宽
        		        fillColor: "#f39c12", //填充色
        		        fillOpacity: 0.35,//填充透明度
        		        extData:result[i]
        		    });
        			
        		    polygon.setMap($rootScope.showmap);
        		    polygons.push(polygon);
        		}
        		
        		while(polygons.length!=0){
        			polygons.pop().on("click",function(){
        				var fenceInfo = this.getExtData();
        				console.log(this.getExtData());
        				
        				//根据点击的围栏加载统计信息
        				fenceServer.getCount(fenceInfo.id).then(function(data){
        					console.log(data);
        					var info = [];
//            		        info.push("<div><div><img style=\"float:left;\" /></div> ");
//            		        info.push("<div style=\"padding:0px 0px 0px 4px;\"><b>高德软件</b>");
            				info.push("<div style=\"padding:0px 0px 0px 4px;\">");
            		        info.push("围栏名称:"+fenceInfo.name);
            		        info.push("当前围栏人数:"+data.data.userCount);
            		        info.push("报警次数:"+data.data.warningCount);
            		        info.push("最后一次统计时间:"+data.message);
            		        infoWindow = new AMap.InfoWindow({
            		            content: info.join("<br/>")  //使用默认信息窗体框样式，显示信息内容
            		        });
            		        var x = Number(fenceInfo.xloc)+Number(fenceInfo.xloc2);
                		    var y = Number(fenceInfo.yloc)+Number(fenceInfo.yloc2);
            		        infoWindow.open($rootScope.showmap, [x/2,y/2]);
        				});
        				
        				
        				
        			});
        		}
        		
        		$scope.fence.ids = ids;
        		console.log($scope.fence);
        		waringServer.getWarningInfo($scope.fence).then(function(data){
        			$rootScope.alldatas = data.data;
        			console.log($rootScope.alldatas);
        		});
        		
        		
//        		console.log(ids);
        		
    		    $rootScope.showmap.setZoom(16);
    		    var x = Number(result[0].xloc)+Number(result[0].xloc2);
    		    var y = Number(result[0].yloc)+Number(result[0].yloc2);
    			$rootScope.showmap.setCenter([x/2,y/2]);
    		}
    		
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
	
});