app.controller('equipTypeCtrl',function($scope,$rootScope,projectService,equipTypeServer,userServer){
	$scope.tree = {};
	$scope.count={};
	$scope.user = {};
	$scope.userquery={};
	$rootScope.useruser = {};
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
	$scope.warningType=0;
	

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
	
	function showIconForTree(treeId, treeNode) {
		return !treeNode.isParent;
	};
	
	$scope.treeNode1 = null;
	function onClick(event, treeId, treeNode, clickFlag) {
		$scope.role = treeNode.desc;
		var zTree = $.fn.zTree.getZTreeObj("tree");
		treeNode1 = treeNode;
		//console.log(treeNode);
		zTree.expandNode(treeNode);
		
		$scope.treeuser.descId = treeNode.descId;
		$scope.treeuser.desc = treeNode.desc;
		$scope.treeuser.type2 = $scope.warningType;
		equipTypeServer.gettypestree($scope.treeuser).then(function(data){
			
			//$scope.count = data.data;
			//console.log(data.data);
			option = {
		    	    // title : {
		    	    //     text: '定位类型',
		    	    //     x:'center'
		    	    // },
		    	    tooltip : {
		    	        trigger: 'item',
		    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    	    },
		    	    legend: {
		    	        // orient: 'vertical',
		    	        left: 'center',
		    	        data: ['手机app','电子标签','gps定位器']
		    	    },
		    	    series : [
		    	        {
		    	            name: '访问来源',
		    	            type: 'pie',
		    	            radius : '55%',
		    	            center: ['50%', '60%'],
		    	            data:data.data,
		    	            itemStyle: {
		    	                emphasis: {
		    	                    shadowBlur: 10,
		    	                    shadowOffsetX: 0,
		    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		    	                }
		    	            }
		    	        }
		    	    ]
		    	};
		    // 使用刚指定的配置项和数据显示图表。
		    myChart.setOption(option);
		});
		    
	}
	
	//$scope.treeuser.type2 = $scope.warningType;
	equipTypeServer.gettypes($scope.treeuser).then(function(data){
		//$scope.count = data.data;
		//console.log(data.data);
		
		 option = {
		    	    // title : {
		    	    //     text: '定位类型',
		    	    //     x:'center'
		    	    // },
		    	    tooltip : {
		    	        trigger: 'item',
		    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    	    },
		    	    legend: {
		    	        // orient: 'vertical',
		    	        left: 'center',
		    	        data: ['手机app','电子标签','gps定位器']
		    	    },
		    	    series : [
		    	        {
		    	            name: '访问来源',
		    	            type: 'pie',
		    	            radius : '55%',
		    	            center: ['50%', '60%'],
		    	            data:data.data,
		    	            itemStyle: {
		    	                emphasis: {
		    	                    shadowBlur: 10,
		    	                    shadowOffsetX: 0,
		    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		    	                }
		    	            }
		    	        }
		    	    ]
		    	};
		    // 使用刚指定的配置项和数据显示图表。
		    myChart.setOption(option);
	});
	
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('equipTypeChart'));
    // 指定图表的配置项和数据
    
    $scope.clickradio = function(){
    	$scope.treeuser.type2 = $scope.warningType;
    	console.log($scope.treeuser.type2);
    	if($scope.treeuser.descId&&$scope.treeuser.desc){
    		equipTypeServer.gettypestree($scope.treeuser).then(function(data){
    			
    			//$scope.count = data.data;
    			//console.log(data.data);
    			option = {
    		    	    // title : {
    		    	    //     text: '定位类型',
    		    	    //     x:'center'
    		    	    // },
    		    	    tooltip : {
    		    	        trigger: 'item',
    		    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    		    	    },
    		    	    legend: {
    		    	        // orient: 'vertical',
    		    	        left: 'center',
    		    	        data: ['手机app','电子标签','gps定位器']
    		    	    },
    		    	    series : [
    		    	        {
    		    	            name: '访问来源',
    		    	            type: 'pie',
    		    	            radius : '55%',
    		    	            center: ['50%', '60%'],
    		    	            data:data.data,
    		    	            itemStyle: {
    		    	                emphasis: {
    		    	                    shadowBlur: 10,
    		    	                    shadowOffsetX: 0,
    		    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    		    	                }
    		    	            }
    		    	        }
    		    	    ]
    		    	};
    		    // 使用刚指定的配置项和数据显示图表。
    		    myChart.setOption(option);
    		});
    		    
    	}else{
    	equipTypeServer.gettypes($scope.treeuser).then(function(data){
    		//$scope.count = data.data;
    		//console.log(data.data);
    		
    		 option = {
    		    	    // title : {
    		    	    //     text: '定位类型',
    		    	    //     x:'center'
    		    	    // },
    		    	    tooltip : {
    		    	        trigger: 'item',
    		    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    		    	    },
    		    	    legend: {
    		    	        // orient: 'vertical',
    		    	        left: 'center',
    		    	        data: ['手机app','电子标签','gps定位器']
    		    	    },
    		    	    series : [
    		    	        {
    		    	            name: '访问来源',
    		    	            type: 'pie',
    		    	            radius : '55%',
    		    	            center: ['50%', '60%'],
    		    	            data:data.data,
    		    	            itemStyle: {
    		    	                emphasis: {
    		    	                    shadowBlur: 10,
    		    	                    shadowOffsetX: 0,
    		    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    		    	                }
    		    	            }
    		    	        }
    		    	    ]
    		    	};
    		    // 使用刚指定的配置项和数据显示图表。
    		    myChart.setOption(option);
    	});
    }
    }
});
