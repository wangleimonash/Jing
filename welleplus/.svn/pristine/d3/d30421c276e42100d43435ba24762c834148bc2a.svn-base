app.controller('app_oneCtrl', function($scope,projectService) {
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
//	$scope.fence.role = $scope.treeuser.role;
//	$scope.fence.rid = $scope.treeuser.rid;
//	$scope.fence.uid = $scope.treeuser.id;
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
	console.log(1);
	 projectService.getTreeInfo($scope.treeuser).then(function(data){
			$scope.zNodes = data;
			$.fn.zTree.init($("#tree"), setting, $scope.zNodes);
		});
	 function onClick(event, treeId, treeNode, clickFlag) {
		
	    }
///***
// * 图表
// * **/
//	 projectService.getInfoForPie().then(function(result){
//			$scope.datas = result.data;
//			$scope.data = new Array();
//			$scope.legdata = new Array();
//			for(var i=0;i<$scope.datas.length;i++){
//				$scope.data[i] = {"value":$scope.datas[i].value,"name":$scope.datas[i].name};
//				$scope.legdata[i] = $scope.datas[i].name;
//			}
//			console.log("data");
//			console.log($scope.data);
//			console.log($scope.legdata);
//			
//			function initpiechart(){
//				var peiChart = echarts.init(document.getElementById("barchart"));
//				var peiOption = {
////					    title : {
////					        text: '定位类型',
////					        subtext: '各类型占比',
////					        x:'center'
////					    },
//					    tooltip : {
//					        trigger: 'item',
//					        formatter: "{a} <br/>{b} : {c} ({d}%)"
//					    },
//					    legend: {
//					        orient: 'vertical',
//					        left: 'left',
////					        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
//					        data: $scope.legdata
//					    },
//					    series : [
//					        {
//					            name: '定位类型',
//					            type: 'pie',
//					            radius : '55%',
//					            center: ['50%', '60%'],
////					            data:[
////					                {value:335, name:'直接访问'},
////					                {value:310, name:'邮件营销'},
////					                {value:234, name:'联盟广告'},
////					                {value:135, name:'视频广告'},
////					                {value:1548, name:'搜索引擎'}
////					            ],
//					            data:$scope.data,
//					            itemStyle: {
//					                emphasis: {
//					                    shadowBlur: 10,
//					                    shadowOffsetX: 0,
//					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
//					                }
//					            }
//					        }
//					    ]
//					};
//				
//				peiChart.setOption(peiOption);
//			}
//			initpiechart();
//			
//		});
 });