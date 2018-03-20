app.controller('rfidMaxCtrl', function ($scope,$rootScope, rfidMaxServer,$interval) {
    $scope.map = {};
    $scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
    //地图显示
    var map = new AMap.Map('container', {
		resizeEnable : true,
		center : [ 121.5491187572, 31.1465517886 ],
		zoom : 18
	});
    var circle = new AMap.Circle({
		center : new AMap.LngLat("121.5491187572", "31.1465517886"),// 圆心位置
		radius : 10, //半径
		strokeColor : "#F33", //线颜色
		strokeOpacity : 1, //线透明度
		strokeWeight : 3, //线粗细度
		fillColor : "#ee2200", //填充颜色
		fillOpacity : 0.35
	//填充透明度,
	});
	var i = 0;
	rfidMaxServer.getCount($scope.treeuser).then(function(data){
		//console.log(data);
		i=data.data;
	});
	$interval(function() {

		rfidMaxServer.getCount($scope.treeuser).then(function(data){
			//console.log(data);
			i=data.data;
		});
		
		AMapUI.loadUI([ 'overlay/SimpleMarker' ], function(SimpleMarker) {
			var infoWindow = new SimpleMarker({
				//设置节点属性
				iconLabel : {
					//普通文本
					innerHTML : i,
					//设置样式
					style : {
						color : '#fff',
						fontSize : '120%',
						marginTop : '2px'
					}
				},
				iconStyle : 'red',
				map : map,
				position : [ 121.5491187572, 31.1465517886 ],
				zIndex : 200
			});
			infoWindow.on("click", function() {
				//checkEPC();
				rfidMaxServer.getMaxInfos($scope.treeuser).then(function(data){
					$rootScope.maxrfidInfos = data.data;
					//console.log($rootScope.maxrfidInfos);
				});
				$("#mybutton").click();
			});
			rfidMaxServer.getMaxInfos($scope.treeuser).then(function(data){
				$rootScope.maxrfidInfos = data.data;
				//console.log($rootScope.maxrfidInfos);
			});
		});
	}, 3000);

	AMapUI.loadUI([ 'overlay/SimpleMarker' ], function(SimpleMarker) {
		var infoWindow = new SimpleMarker({
			//设置节点属性
			iconLabel : {
				//普通文本
				innerHTML : '...',
				//设置样式
				style : {
					color : '#fff',
					fontSize : '120%',

					marginTop : '2px'
				}
			},
			iconStyle : 'red',
			map : map,
			position : [ 121.5491187572, 31.1465517886 ],
			zIndex : 200
		});
		infoWindow.on("click", function() {
			//checkEPC();
			$("#mybutton").click();
			$scope.$apply(function(){
				rfidMaxServer.getMaxInfos($scope.treeuser).then(function(data){
					//console.log(data);
					$rootScope.maxrfidInfos = data.data;
				});
			});
			
			
		});
	});
	
	circle.setMap(map);
	circle.on("click", function() {
		//checkEPC();
		$("#mybutton").click();
		rfidMaxServer.getMaxInfos($scope.treeuser).then(function(data){
			//console.log(data);
			$rootScope.maxrfidInfos = data.data;
		});
		
	});
	
});