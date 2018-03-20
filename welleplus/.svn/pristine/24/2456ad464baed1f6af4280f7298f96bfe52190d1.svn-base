app.controller("dashboardCtrl",function($rootScope,$scope,$interval,DashBoardSer,equipTypeServer,fenceServer,userServer){
	$rootScope.leftheight = "502px";
	$rootScope.mainheight = "546px";
	$scope.id = getCookie("welleplusuid");
	$scope.role = getCookie("welleplusrole"); 
	$scope.rid = getCookie("welleplusrid");
//	$scope.ip = getCookie("welleplusip");
	
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = $scope.role;
	$scope.treeuser.rid = $scope.rid;
	$scope.treeuser.id = $scope.id;
	$scope.warningType=0;
	
	var localdate = new Date();
	var year = 1900 + localdate.getYear();
	var month = 1 + localdate.getMonth();
	var date = localdate.getDate();
	var day = localdate.getDay();
	if(day==0){
		$scope.dayofweeks = ["日","一","二","三","四","五","六"];
	}else if(day==1){
		$scope.dayofweeks = ["一","二","三","四","五","六","日"];
	}else if(day==2){
		$scope.dayofweeks = ["二","三","四","五","六","日","一"];
	}else if(day==3){
		$scope.dayofweeks = ["三","四","五","六","日","一","二"];
	}else if(day==4){
		$scope.dayofweeks = ["四","五","六","日","一","二","三"];
	}else if(day==5){
		$scope.dayofweeks = ["五","六","日","一","二","三","四"];
	}else{
		$scope.dayofweeks = ["六","日","一","二","三","四","五",];
	}
	$scope.localtime = year+"-"+month+"-"+date;
//	console.log("--------------"+$scope.ip);
//	if($scope.ip=="本地"){
//		$scope.address = "上海市";
//	}else if(!$scope.ip){
		DashBoardSer.getlocationofip().then(function(data){
			console.log(2222222);
			console.log(data);
			$scope.address = data.city;
		});
//	}else{
//		DashBoardSer.getlocationofip($scope.ip).then(function(data){
//			console.log(33333);
//			console.log(data);
//			$scope.address = data.city;
//		});
//	}
		
	userServer.getShouldWorkUser($scope.rid,$scope.role).then(function(data){
//			console.log(222);
//			console.log(data);
		$scope.shouldcount = data.data.shouldcount;
		$scope.workcount = data.data.workcount;
	});
	$interval(function(){
		userServer.getShouldWorkUser($scope.rid,$scope.role).then(function(data){
//			console.log(222);
//			console.log(data);
			$scope.shouldcount = data.data.shouldcount;
			$scope.workcount = data.data.workcount;
		});
	},1000*30);
	
	
	
	$rootScope.myChart = echarts.init(document.getElementById('mybarChart'));
	if($scope.role==1||$scope.role==0){
		DashBoardSer.getuserinfocount($scope.rid,$scope.role).then(function(data){
			console.log(data);
			$scope.seriesarr = [];
			var xAxisData = [];
			var seriesData0 = [];
			var seriesData1 = [];
			var seriesData2 = [];
			var seriesData3 = [];
			var result = data.data;
			for(var i=0;i<result.length;i++){
				var a = result[i];
				xAxisData.push(a.name);
				if(!a.data.其他){
					seriesData0.push(0);
				}else{
					seriesData0.push(a.data.其他);
				}
				if(!a.data.农民工){
					seriesData1.push(0);
				}else{
					seriesData1.push(a.data.农民工);
				}
				if(!a.data.安全人员){
					seriesData2.push(0);
				}else{
					seriesData2.push(a.data.安全人员);
				}
				if(!a.data.管理人员){
					seriesData3.push(0);
				}else{
					seriesData3.push(a.data.管理人员);
				}
				
			}
			
			for(var i=0;i<4;i++){
				$scope.series = {};
				$scope.series.type = 'bar';
				if(i==0){
					$scope.series.name = "其他";
					$scope.series.data = seriesData0;
				}else if(i==1){
					$scope.series.name = "农民工";
					$scope.series.data = seriesData1;
				}else if(i==2){
					$scope.series.name = "安全人员";
					$scope.series.data = seriesData2;
				}else if(i==3){
					$scope.series.name = "管理人员";
					$scope.series.data = seriesData3;
				}
				
				$scope.seriesarr.push($scope.series);
			}
			
			console.log($scope.seriesarr);
			
			
			
			$rootScope.option = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend: {
//				    	orient: 'vertical',
//				    	left:'left',
				        data:['其他','农民工','安全人员','管理人员'],
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis : [
				        {
				            type : 'category',
				            data : xAxisData
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : $scope.seriesarr
				};
			
			$rootScope.myChart.setOption($scope.option);
			
		});
	}
	
	
//	$scope.equipChart = echarts.init(document.getElementById('equipTypeChart'));
////	if($scope.role==1){
//	
//	fenceServer.getWorkPie().then(function(data){
//		if(data.state){
//			var result = data.data;
//			console.log(111);
//			console.log(result);
//			var names = [];
//			var datas = [];
//			for(var i in result){
//				names.push(i);
//				var map = {};
//				map.name = i;
//				if(result.i){
//					map.value = result.i;
//				}else{
//					map.value = 0;
//				}
//				
//				datas.push(map);
//			}
//			console.log(datas);
////			console.log($scope.names);
////			console.log($scope.datas);
//			
//			$scope.equipoption = {
//		    	    // title : {
//		    	    //     text: '定位类型',
//		    	    //     x:'center'
//		    	    // },
//		    	    tooltip : {
//		    	        trigger: 'item',
////		    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
//		    	    },
//		    	    legend: {
////		    	        orient: 'vertical',
//		    	        left: 'center',
//		    	        data: names
//		    	    },
//		    	    series : [
//		    	        {
//		    	            name: '数量',
//		    	            type: 'pie',
//		    	            radius : '55%',
//		    	            center: ['50%', '60%'],
//		    	            data:datas,
//		    	            itemStyle: {
//		    	                emphasis: {
//		    	                    shadowBlur: 10,
//		    	                    shadowOffsetX: 0,
//		    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
//		    	                }
//		    	            }
//		    	        }
//		    	    ]
//		    	};
//		    // 使用刚指定的配置项和数据显示图表。
//			$scope.equipChart.setOption($scope.equipoption);
//			
//		}
//	});
//		equipTypeServer.gettypes($scope.treeuser).then(function(data){
//			//$scope.count = data.data;
//			//console.log(data.data);
//			
//			 $scope.equipoption = {
//			    	    // title : {
//			    	    //     text: '定位类型',
//			    	    //     x:'center'
//			    	    // },
//			    	    tooltip : {
//			    	        trigger: 'item',
//			    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
//			    	    },
//			    	    legend: {
//			    	        // orient: 'vertical',
//			    	        left: 'center',
//			    	        data: ['手机app','电子标签','gps定位器']
//			    	    },
//			    	    series : [
//			    	        {
//			    	            name: '访问来源',
//			    	            type: 'pie',
//			    	            radius : '55%',
//			    	            center: ['50%', '60%'],
//			    	            data:data.data,
//			    	            itemStyle: {
//			    	                emphasis: {
//			    	                    shadowBlur: 10,
//			    	                    shadowOffsetX: 0,
//			    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
//			    	                }
//			    	            }
//			    	        }
//			    	    ]
//			    	};
//			    // 使用刚指定的配置项和数据显示图表。
//			 $scope.equipChart.setOption($scope.equipoption);
//		});
//	}
	
	$scope.indexmap = new AMap.Map("container", {
        resizeEnable: true
    });
	$scope.indexmap.plugin(["AMap.ToolBar"], function() {
	});
	
	$scope.fence = {}
	$scope.fence.desc = $scope.role;
	$scope.fence.descId = $scope.rid;
	$scope.fence.role = $scope.role;
	$scope.fence.rid = $scope.rid;
	$scope.fence.uid = $scope.id;
	fenceServer.getInfoFromId($scope.fence).then(function(data){
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
    			polygonArr.push([result[i].xloc3,result[i].yloc3]);
    			
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
    			
    		    polygon.setMap($scope.indexmap);
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
//        		        info.push("<div><div><img style=\"float:left;\" /></div> ");
//        		        info.push("<div style=\"padding:0px 0px 0px 4px;\"><b>高德软件</b>");
        				info.push("<div>");
        		        info.push("围栏名称:"+fenceInfo.name);
        		        info.push("当前围栏人数:"+data.data.userCount);
        		        info.push("报警次数:"+data.data.warningCount);
        		        info.push("最后一次统计时间:"+data.message);
        		        infoWindow = new AMap.InfoWindow({
        		            content: info.join("<br/>")  //使用默认信息窗体框样式，显示信息内容
        		        });
        		        var x = Number(fenceInfo.xloc)+Number(fenceInfo.xloc2);
            		    var y = Number(fenceInfo.yloc)+Number(fenceInfo.yloc2);
        		        infoWindow.open($scope.indexmap, [x/2,y/2]);
    				});
    				
    				
    				
    			});
    		}
    		
    		$scope.indexmap.setZoom(16);
		    var x = Number(result[0].xloc)+Number(result[0].xloc3);
		    var y = Number(result[0].yloc)+Number(result[0].yloc3);
		    $scope.indexmap.setCenter([x/2,y/2]);
		}
		
	});
	
	$interval(function(){
		fenceServer.getInfoFromId($scope.fence).then(function(data){
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
	    			polygonArr.push([result[i].xloc3,result[i].yloc3]);
	    			
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
	    			
	    		    polygon.setMap($scope.indexmap);
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
//	        		        info.push("<div><div><img style=\"float:left;\" /></div> ");
//	        		        info.push("<div style=\"padding:0px 0px 0px 4px;\"><b>高德软件</b>");
	        				info.push("<div>");
	        		        info.push("围栏名称:"+fenceInfo.name);
	        		        info.push("当前围栏人数:"+data.data.userCount);
	        		        info.push("报警次数:"+data.data.warningCount);
	        		        info.push("最后一次统计时间:"+data.message);
	        		        infoWindow = new AMap.InfoWindow({
	        		            content: info.join("<br/>")  //使用默认信息窗体框样式，显示信息内容
	        		        });
	        		        var x = Number(fenceInfo.xloc)+Number(fenceInfo.xloc2);
	            		    var y = Number(fenceInfo.yloc)+Number(fenceInfo.yloc2);
	        		        infoWindow.open($scope.indexmap, [x/2,y/2]);
	    				});
	    				
	    				
	    				
	    			});
	    		}
	    		
	    		$scope.indexmap.setZoom(16);
			    var x = Number(result[0].xloc)+Number(result[0].xloc3);
			    var y = Number(result[0].yloc)+Number(result[0].yloc3);
			    $scope.indexmap.setCenter([x/2,y/2]);
			}
			
		});
	},1000*60);
	
	var skycons = new Skycons({"color": "#73879c"});
	skycons.add("partly-cloudy-day", Skycons.PARTLY_CLOUDY_DAY);
	skycons.add("clear-day",Skycons.CLEAR_DAY);
	skycons.add("rain",Skycons.RAIN);
	skycons.add("snow",Skycons.SNOW);
	skycons.add("sleet",Skycons.SLEET);
	skycons.add("wind",Skycons.WIND);
	skycons.add("cloudy",Skycons.CLOUDY);
	skycons.play();

});