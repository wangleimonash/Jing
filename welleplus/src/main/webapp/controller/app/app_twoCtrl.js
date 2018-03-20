app.controller('app_twoCtrl', function(equipLocationServer, $scope, $rootScope,
		app_twoSer, projectService) {
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");// 用户名
	$scope.treeuser.role = getCookie("welleplusrole");// 角色01234
	$scope.treeuser.rid = getCookie("welleplusrid");// 角色id
	$scope.treeuser.id = getCookie("welleplusuid");// 用户id
	$scope.treeuser.worktype = 0;
	$scope.treeuser.equiptype = 0;
	// $scope.user = {};
	// $scope.user.page = 0;
	// $rootScope.indexPage = 0;
	
	$scope.isshow = false;
	$scope.whereshow = function(id) {
		console.log(id);
		// $scope.isshow = !$scope.isshow;
		$scope.isshow = true
		$scope.treeuser.phonenumber = id;
		
		app_twoSer.getworkdata($scope.treeuser).then(function(data) {
			console.log(data.data);
			$scope.as = data.data;
			console.log(data.count);

			$scope.oncilkepage = data.count;
			var optInit = getOptionsFromForm1();
			$("#Pagination1").pagination(data.count, optInit);
			$(".pagination a").removeAttr("href");
			// $("#setoptions").click(function () {
			// var opt = getOptionsFromForm1();
			// $("#Pagination1").pagination(data.count, opt);
			// });
		});

	};
	// app_twoSer.gettwolists($scope.treeuser).then(function (data) {
	// $scope.treeuser.page = page_index;
	// $rootScope.oncilkepage = data.count;
	// $rootScope.as = data.data;
	// $rootScope.indexPage = page_index;
	// console.log($rootScope.oncilkepage);
	// });

	// count
	// app_twoSer.getworkdatanumber().then(function(data){
	// $scope.count=data.data;
	// });

	function pageselectCallback1(page_index, jq) {
		// if ($scope.treeuser.descId && $scope.treeuser.desc) {
		// app_twoSer.gettwoliststree($scope.treeuser).then(function (data) {
		// $rootScope.oncilkepage = data.count;
		// $rootScope.as = data.data;
		// $rootScope.indexPage = page_index1;
		// });
		// } else {
		$scope.treeuser.page = page_index;
		console.log(page_index);
		app_twoSer.getworkdata($scope.treeuser).then(function(data) {
			console.log(data.data);
			$scope.as = data.data;
			console.log(data.count);
			$scope.oncilkepage = data.count;

			// var optInit = getOptionsFromForm1();
			// $("#Pagination1").pagination(data.count, optInit);
			$(".pagination a").removeAttr("href");
			// $("#setoptions").click(function () {
			// var opt = getOptionsFromForm1();
			// $("#Pagination1").pagination(data.count, opt);
			// });
		});
		// }
		// return false;
	}
	// 表单一
	function pageselectCallback(page_index, jq) {
		$scope.treeuser.page = page_index;
		console.log(page_index);
		// 选中树型结构的时候
		if ($scope.treeuser.descId && $scope.treeuser.desc) {
			app_twoSer.getliststree($scope.treeuser).then(function(data) {
				$rootScope.count = data.count;
				$rootScope.userinfos = data.data;
				$rootScope.indexPage = 0;
//				var optInit = getOptionsFromForm();
//				$("#Pagination").pagination(data.count, optInit);
//				$("#setoptions").click(function() {
//					var opt = getOptionsFromForm();
//					$("#Pagination").pagination(data.count, opt);
//				});
			});
		} else {
			// 没有选中树型结构的时候
			app_twoSer.getlists($scope.treeuser).then(function(data) {
				$rootScope.count = data.count;
				$rootScope.userinfos = data.data;
				$rootScope.indexPage = 0;
//				var optInit = getOptionsFromForm();
//				$("#Pagination").pagination(data.count, optInit);
//
//				$("#setoptions").click(function() {
//					var opt = getOptionsFromForm();
//					$("#Pagination").pagination(data.count, opt);
//				});

			});
		}
		return false;
	}
	function getOptionsFromForm1() {
		var opt = {
			callback : pageselectCallback1
		};
		opt.prev_text = "<<";
		opt.next_text = ">>";
		opt.items_per_page = 10;
		opt.num_display_entries = 4;
		opt.num_edge_entries = 2;
		return opt;
	}
	function getOptionsFromForm() {
		var opt = {
			callback : pageselectCallback
		};
		opt.prev_text = "<<";
		opt.next_text = ">>";
		opt.items_per_page = 10;
		opt.num_display_entries = 4;
		opt.num_edge_entries = 2;
		return opt;
	}

	var setting = {
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onClick : onClick,
		}
	};
	// 构造树形结构组织
	projectService.getTreeInfo($scope.treeuser).then(function(data) {
		$scope.zNodes = data;
		$.fn.zTree.init($("#tree"), setting, $scope.zNodes);
	});
	//	
	function onClick(event, treeId, treeNode, clickFlag) {
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.expandNode(treeNode);
		// 获取数据
		console.log(treeNode);
		console.log(treeNode.desc);
		// 树的
		$scope.treeuser.desc = treeNode.desc;
		// 树的ID
		$scope.treeuser.descId = treeNode.descId;
		// 角色
		$scope.treeuser.role = $scope.treeuser.role;
		// 角色ID
		$scope.treeuser.rid = $scope.treeuser.rid;
		$scope.treeuser.uid = $scope.treeuser.id;
		// 点击树查询
		app_twoSer.getAttendanceinfo($scope.treeuser).then(function(data) {

			$rootScope.userinfos = data.data;
			$rootScope.count = data.count;
			console.log($rootScope.userinfos);
			console.log($rootScope.count);
			//			
			var optInit = getOptionsFromForm();
			$("#Pagination").pagination(data.count, optInit);
			//	        
			$("#setoptions").click(function() {
				var opt = getOptionsFromForm();
				$("#Pagination").pagination(data.count, opt);
			});
			//			
		});
		// $scope.role = treeNode.desc;
		// var zTree = $.fn.zTree.getZTreeObj("tree");
	}

	// 时间
	laydate.render({
		elem : '#startdate' // 指定元素
		,
		type : 'datetime',
		format : 'yyyy-MM-dd HH:mm:ss' // 可任意组合
		// ,min: '2000-01-01 00:00:00'
		// ,max: 'new Date()'
		,
		theme : '#393D49'
	});
	laydate.render({
		elem : '#enddate' // 指定元素
		,
		type : 'datetime',
		format : 'yyyy-MM-dd HH:mm:ss' // 可任意组合
		// ,min: '2000-01-01 00:00:00'
		// ,max: 'new Date()'
		,
		theme : '#393D49'
	});

	$scope.engineer = {
		name : "t",
		currentActivity : "工种"
	};
	$scope.activities = [ "工种" ];

	// 下拉
	app_twoSer.getdownbox($scope.treeuser).then(function(data) {
		// console.log(data);
		$scope.activities = data.data;
	});

	$scope.treeuser.page = 0;
	// 表单数据
	app_twoSer.gettwohistorydata($scope.treeuser).then(function(data) {
		console.log(data.data);
		var optInit = getOptionsFromForm();
		// $scope.treeuser.page=;
		$rootScope.count = data.count;
		$rootScope.userinfos = data.data;
		console.log(data.name);
		var optInit = getOptionsFromForm();
		$("#Pagination").pagination(data.count, optInit);
		$("#setoptions").click(function() {
			var opt = getOptionsFromForm();
			$("#Pagination").pagination(data.count, opt);
		});
	});
	// 点击查询
	// searchInfo()
	$scope.searchInfo = function() {
		$scope.treeuser.startdate = $('#startdate').val();
		$scope.treeuser.enddate = $('#enddate').val();
		$scope.treeuser.type2 = $('#type2').val();
		$scope.treeuser.worktype = $('#gong').val();
		// console.log($scope.treeuser);
		$scope.treeuser.page = 0;
//		是否点击树查询
		if ($scope.treeuser.descId && $scope.treeuser.desc) {
//			选中树
			app_twoSer.getliststree($scope.treeuser).then(function(data) {
				$rootScope.count = data.count;
				$rootScope.equipInfos = data.data;
				$rootScope.indexPage = 0;
				var optInit = getOptionsFromForm();
				$("#Pagination").pagination(data.count, optInit);
				$("#setoptions").click(function() {
					var opt = getOptionsFromForm();
					$("#Pagination").pagination(data.count, opt);
				});
			});
//			
		} else {
//			没有点中树
			app_twoSer.getlists($scope.treeuser).then(function(data) {
				$rootScope.count = data.count;
				$rootScope.equipInfos = data.data;
				$rootScope.indexPage = 0;
				var optInit = getOptionsFromForm();
				$("#Pagination").pagination(data.count, optInit);

				$("#setoptions").click(function() {
					var opt = getOptionsFromForm();
					$("#Pagination").pagination(data.count, opt);
				});
			});
		}
	}

});