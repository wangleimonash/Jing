app.controller("userlocationCtrl",function($scope,$rootScope,projectService,userServer){
	$rootScope.leftheight = "632px";
	$rootScope.mainheight = "546px";
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
	
	var count = 0;
	
	$rootScope.userlocationmap = new AMap.Map('container', {
	    resizeEnable: true,
	    zoom:8,
	    center: [116.397428, 39.90923]        
	});
	
	
//	AMap.plugin('AMap.ToolBar', function () {
//        var toolbar = new AMap.ToolBar();
//        map.addControl(toolbar)
//    });
	
//	marker = new AMap.Marker({
//		icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
//        position: new AMap.LngLat(121.9355, 31)
//    });
	
//	 marker.setMap(map);
	
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
	
//	$rootScope.markers = [];
	$rootScope.cluster = null;
	
	projectService.getTreeInfo($scope.treeuser).then(function(data){
		$scope.zNodes = data;
		$.fn.zTree.init($("#tree"), setting, $scope.zNodes);
		
		//***************************开始默认加载数据************************************
		var zTree = $.fn.zTree.getZTreeObj("tree");
		var treeNode = zTree.getNodes();
		
		var data = treeNode[0];
		var ids = [];
//    	1
    	id = [];
    	id.push(data.desc);
    	id.push(data.descId);
    	ids.push(id);
    	
    	console.log(data);
    	
    	if(data.children){
    		var data1 = data.children;
    		for(var i=0;i<data1.length;i++){
//    			2
    			id1 = [];
    			id1.push(data1[i].desc);
    			id1.push(data1[i].descId);
    			ids.push(id1);
    			var data2 = data1[i].children;
    			if(data2){
    				for(var j=0;j<data2.length;j++){
//    					3
    					id2 = [];
    					id2.push(data2[j].desc);
    					id2.push(data2[j].descId);
    					ids.push(id2);
    					
    					var data3 = data2[j].children;
    					if(data3){
    						for(var k=0;k<data3.length;k++){
//    							4
    							id3 = [];
    							id3.push(data3[k].desc);
    							id3.push(data3[k].descId);
    							ids.push(id3);
    						}
    					}
    				}
    			}
    		}
    	}
		userServer.getUserAndPositionByIds(ids).then(function(data){
			console.log(data);
			var result = data.data;
			
			$rootScope.markers = [];
			count = 0;
			
			for(var i = 0;i<result.length;i++){
				if(!!result[i].xLoc&&!!result[i].yLoc){
					if(result[i].equiptype==0){
//						手表
						$scope.marker = new AMap.Marker({
							icon: "images/watch.png",
		                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc),
//		                    content: '<div style="background-color: hsla(180, 100%, 50%, 0.7); height: 24px; width: 24px; border: 1px solid hsl(180, 100%, 40%); border-radius: 12px; box-shadow: hsl(180, 100%, 50%) 0px 0px 1px;"></div>'
		                });
					}else if(result[i].equiptype==1){
//						安全帽
						$scope.marker = new AMap.Marker({
							icon: "images/hat.png",
		                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc),
//		                    content: '<div style="background-color: hsla(180, 100%, 50%, 0.7); height: 24px; width: 24px; border: 1px solid hsl(180, 100%, 40%); border-radius: 12px; box-shadow: hsl(180, 100%, 50%) 0px 0px 1px;"></div>'
		                });
					}else if(result[i].equiptype==2){
//						app
						$scope.marker = new AMap.Marker({
							icon: "images/app.png",
		                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc),
//		                    content: '<div style="background-color: hsla(180, 100%, 50%, 0.7); height: 24px; width: 24px; border: 1px solid hsl(180, 100%, 40%); border-radius: 12px; box-shadow: hsl(180, 100%, 50%) 0px 0px 1px;"></div>'
		                });
					}else{
						
					}
					
					$scope.marker.setMap($rootScope.userlocationmap);
					var equipnumber = result[i].equipnumber;
					var address = result[i].address;
					if(!address){
						address = "";
					}
					
					content = "姓名: "+result[i].name+"<br/>电话: "+result[i].phonenumber+"<br/>"
					+"时间: "+result[i].positiontime+"<br/>";
					if(result[i].equiptype==0){
						content = content + "心率: "+result[i].heartRate+" 次/分<br/>海拔: "+result[i].altitude+" 米<br/>";
					}
					if(result[i].equiptype==2){
						equipnumber = result[i].phonenumber;
					}
					if(result[i].equiptype==0||result[i].equiptype==1){
						content = content + "剩余电量: "+result[i].elec+"<br/>";
					}
					content = content + "地址: "+address+"<br/>设备类型: "+result[i].equipTypeStr+"<br/>"
					+"设备编号: "+equipnumber+"<br/>";
//					content.push("<a onclick='clicka()' style='color:rgba(13,11,106,0.87);text-decoration:underline;'>历史轨迹</a>");
//					content = content + "<a onclick='clicka()' style='color:rgba(13,11,106,0.87);text-decoration:underline;'>历史轨迹</a>";
					$scope.marker.content = content;
					$scope.marker.on('click', markerClick);
					
					$rootScope.markers.push($scope.marker);
					 
					
					 
				}
				
				
			}
			
			$rootScope.userlocationmap.setFitView();
			
//			addCluster();
			
			
		});
	});
	
	
	
	
	
	function onClick(event, treeId, treeNode, clickFlag) {
		$rootScope.markers = [];
		
		var zTree = $.fn.zTree.getZTreeObj("tree");
    	zTree.expandNode(treeNode);
    	
    	$rootScope.userlocationmap.clearMap();
//    	$rootScope.cluster.clearMarkers();
//    	$rootScope.cluster.setMap(null);
    	var data = treeNode;
    	var ids = [];
//    	1
    	id = [];
    	id.push(data.desc);
    	id.push(data.descId);
    	ids.push(id);
    	
    	
    	if(data.children){
    		var data1 = data.children;
    		for(var i=0;i<data1.length;i++){
//    			2
    			id1 = [];
    			id1.push(data1[i].desc);
    			id1.push(data1[i].descId);
    			ids.push(id1);
    			var data2 = data1[i].children;
    			if(data2){
    				for(var j=0;j<data2.length;j++){
//    					3
    					id2 = [];
    					id2.push(data2[j].desc);
    					id2.push(data2[j].descId);
    					ids.push(id2);
    					
    					var data3 = data2[j].children;
    					if(data3){
    						for(var k=0;k<data3.length;k++){
//    							4
    							id3 = [];
    							id3.push(data3[k].desc);
    							id3.push(data3[k].descId);
    							ids.push(id3);
    						}
    					}
    				}
    			}
    		}
    	}
		userServer.getUserAndPositionByIds(ids).then(function(data){
			console.log(data);
			var result = data.data;
			$rootScope.userlocationmap.clearMap();
			for(var i = 0;i<result.length;i++){
				if(!!result[i].xLoc&&!!result[i].yLoc){
					if(result[i].equiptype==0){
//						手表
						$scope.marker = new AMap.Marker({
							icon: "images/watch.png",
		                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
		                });
					}else if(result[i].equiptype==1){
//						安全帽
						$scope.marker = new AMap.Marker({
							icon: "images/hat.png",
		                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
		                });
					}else if(result[i].equiptype==2){
//						app
						$scope.marker = new AMap.Marker({
							icon: "images/app.png",
		                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
		                });
					}else{
						
					}
					
					$scope.marker.setMap($rootScope.userlocationmap);
					
					var equipnumber = result[i].equipnumber;
					var address = result[i].address;
					if(!address){
						address = "";
					}
					
					content = "姓名: "+result[i].name+"<br/>电话: "+result[i].phonenumber+"<br/>"
					+"时间: "+result[i].positiontime+"<br/>";
					if(result[i].equiptype==0){
						content = content + "心率: "+result[i].heartRate+" 次/分<br/>海拔: "+result[i].altitude+" 米<br/>";
					}
					if(result[i].equiptype==2){
						equipnumber = result[i].phonenumber;
					}
					if(result[i].equiptype==0||result[i].equiptype==1){
						content = content + "剩余电量: "+result[i].elec+"<br/>";
					}
					content = content + "地址: "+address+"<br/>设备类型: "+result[i].equipTypeStr+"<br/>"
					+"设备编号: "+equipnumber+"<br/>";
					$scope.marker.content = content;
					$scope.marker.on('click', markerClick);
					
					$rootScope.markers.push($scope.marker);
					
					 
				}
				
			}
			
			
			$rootScope.userlocationmap.setFitView();
			
//			$rootScope.userlocationmap.clearMap();
//			addCluster();
			
			
		});
    	
	}
	

	var _renderCluserMarker = function (context) {
		count = $rootScope.markers.length;
		
        var factor = Math.pow(context.count/count,1/18)
        var div = document.createElement('div');
        var Hue = 180 - factor* 180;
        var bgColor = 'hsla('+Hue+',100%,50%,0.7)';
        var fontColor = 'hsla('+Hue+',100%,20%,1)';
        var borderColor = 'hsla('+Hue+',100%,40%,1)';
        var shadowColor = 'hsla('+Hue+',100%,50%,1)';
        div.style.backgroundColor = bgColor
        var size = Math.round(30 + Math.pow(context.count/count,1/5) * 20);
        div.style.width = div.style.height = size+'px';
        div.style.border = 'solid 1px '+ borderColor;
        div.style.borderRadius = size/2 + 'px';
        div.style.boxShadow = '0 0 1px '+ shadowColor;
        div.innerHTML = context.count;
        div.style.lineHeight = size+'px';
        div.style.color = fontColor;
        div.style.fontSize = '14px';
        div.style.textAlign = 'center';
        context.marker.setOffset(new AMap.Pixel(-size/2,-size/2));
        context.marker.setContent(div)
     }
	
	 function addCluster(tag) {
	        if ($rootScope.cluster) {
	            $rootScope.cluster.setMap(null);
	        }
	        if (tag == 2) {//完全自定义
	            $rootScope.cluster = new AMap.MarkerClusterer($rootScope.userlocationmap,$rootScope.markers,{
	                gridSize:10,
	                renderCluserMarker:_renderCluserMarker
	            });
	        } else if (tag == 1) {//自定义图标
	            var sts = [{
	                url: "http://a.amap.com/jsapi_demos/static/images/blue.png",
	                size: new AMap.Size(32, 32),
	                offset: new AMap.Pixel(-16, -16)
	            }, {
	                url: "http://a.amap.com/jsapi_demos/static/images/green.png",
	                size: new AMap.Size(32, 32),
	                offset: new AMap.Pixel(-16, -16)
	            }, {
	                url: "http://a.amap.com/jsapi_demos/static/images/orange.png",
	                size: new AMap.Size(36, 36),
	                offset: new AMap.Pixel(-18, -18)
	            },{
	                url: "http://a.amap.com/jsapi_demos/static/images/red.png",
	                size: new AMap.Size(48, 48),
	                offset: new AMap.Pixel(-24, -24)
	            },{
	                url: "http://a.amap.com/jsapi_demos/static/images/darkRed.png",
	                size: new AMap.Size(48, 48),
	                offset: new AMap.Pixel(-24, -24)
	            },{
	                url: "http://a.amap.com/jsapi_demos/static/images/darkRed.png",
	                size: new AMap.Size(60, 60),
	                offset: new AMap.Pixel(-24, -24)
	            }];
	            $rootScope.cluster = new AMap.MarkerClusterer($rootScope.userlocationmap, $rootScope.markers, {
	                styles: sts,
	                gridSize:80
	            });
	        } else {//默认样式
	            $rootScope.cluster = new AMap.MarkerClusterer($rootScope.userlocationmap, $rootScope.markers,{gridSize:10});
	        }
	        
	        $rootScope.markers = [];
	        
	    }
	
	var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(5, -30)});
	
	function markerClick(e) {
        infoWindow.setContent(e.target.content);
        infoWindow.open($rootScope.userlocationmap, e.target.getPosition());
    }
	
	
})