app.controller("warninginfoCtrl",function($scope,$rootScope,userServer,$interval){
//	$rootScope.leftheight = "683px";
	$rootScope.leftheight = "630px";
	$rootScope.mainheight = "580px";
	$scope.user = {};
	$scope.user.role = getCookie("welleplusrole"); 
	$scope.user.rid = getCookie("welleplusrid");
	$scope.user.equiptype=4;
	$scope.user.equipstate=3;
	
	$rootScope.map = new AMap.Map('container', {
	    resizeEnable: true,
	    zoom:8,
	    center: [116.397428, 39.90923]        
	});
	
	userServer.getWarningUserinfos($scope.user).then(function(data){
		console.log(data);
		var result = data.data;
		for(var i = 0;i<result.length;i++){
			if(!!result[i].xLoc&&!!result[i].yLoc){
				if(result[i].type==1){
					marker = new AMap.Marker({
						icon: "images/sos.png",
	                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
	                });
				}else if(result[i].type==2){
					marker = new AMap.Marker({
						icon: "images/shuaidao.png",
	                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
	                });
				}else if(result[i].type==10){
					marker = new AMap.Marker({
						icon: "images/bat.png",
	                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
	                });
				}
				marker.setMap($rootScope.map);
				
				var equipnumber = result[i].equipnumber;
				
				content = "姓名: "+result[i].name+"<br/>电话: "+result[i].phonenumber+"<br/>"+"设备编号: "+result[i].equipnumber+"<br/>"
				+"报警类型: <span style='color:red'>"+result[i].typeStr+"</span><br/>时间: "+result[i].warningDate+"<br/>";
				if(result[i].equiptype==0){
					content = content + "心率: "+result[i].heartRate+" 次/分<br/>海拔: "+result[i].altitude+" 米<br/>";
				}
				content = content + "剩余电量: "+result[i].elec + "<br/>地址: "+result[i].address+"</span><br/>"
				;
				marker.content = content;
				marker.on('click', markerClick);
				
			}
		}
		
		$rootScope.map.setFitView();
	});
	
	var timer = $interval(function(){
		if("/warninginfo"==window.location.href.substring(window.location.href.lastIndexOf("/"))){
			userServer.getWarningUserinfos($scope.user).then(function(data){
				$rootScope.map.clearMap();
				var result = data.data;
				for(var i = 0;i<result.length;i++){
					console.log(!!result[i].xLoc&&!!result[i].yLoc);
					if(!!result[i].xLoc&&!!result[i].yLoc){
						if(result[i].type==1){
							marker = new AMap.Marker({
								icon: "images/sos.png",
			                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
			                });
						}else if(result[i].type==2){
							marker = new AMap.Marker({
								icon: "images/shuaidao.png",
			                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
			                });
						}else if(result[i].type==10){
							marker = new AMap.Marker({
								icon: "images/bat.png",
			                    position: new AMap.LngLat(result[i].xLoc, result[i].yLoc)
			                });
						}
						
						marker.setMap($rootScope.map);
						
						var equipnumber = result[i].equipnumber;
						
						content = "姓名: "+result[i].name+"<br/>电话: "+result[i].phonenumber+"<br/>"+"设备编号: "+result[i].equipnumber+"<br/>"
						+"报警类型: <span style='color:red'>"+result[i].typeStr+"</span><br/>时间: "+result[i].warningDate+"<br/>";
						if(result[i].equiptype==0){
							content = content + "心率: "+result[i].heartRate+" 次/分<br/>海拔: "+result[i].altitude+" 米<br/>";
						}
						content = content + "剩余电量: "+result[i].elec + "<br/>地址: "+result[i].address+"</span><br/>"
						;
						marker.content = content;
						marker.on('click', markerClick);
						
					}
				}
				
//				$rootScope.map.setFitView();
			});
		}
		
	},30000);
	
	$scope.$on("destroy",function(){
		$interval.cancel(timer);
	});
	
	var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(5, -30)});
	
	function markerClick(e) {
        infoWindow.setContent(e.target.content);
        infoWindow.open($rootScope.map, e.target.getPosition());
    }
})