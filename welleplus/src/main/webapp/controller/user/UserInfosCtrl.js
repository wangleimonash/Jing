app.controller('userInfosCtrl',function($scope,$rootScope,projectService,userServer){
	$rootScope.leftheight = "670px";
	$rootScope.mainheight = "580px";
	$scope.userinfos = {};
	$scope.userinfoquery = {};
	
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
	
	$rootScope.detailedinfos = {};
	$rootScope.detailedinfos.loginname = $scope.treeuser.userName;
	
	$scope.indexPage = 0;
	
	var setting = {}
	setting = {
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
		var zTree = $.fn.zTree.getZTreeObj("tree");
		var result = zTree.getNodes();
		
		var treeNode = result[0];
		
		ids = [];
		
		id = [];
		id.push(treeNode.desc);
		id.push(treeNode.descId);
		var name = treeNode.name;
		if(treeNode.pId){
			var nodedata1 = getNameById(treeNode.pId);
			name = nodedata1.name + " > " + name;
			if(nodedata1.pId){
				var nodedata2 = getNameById(nodedata1.pId);
				name = nodedata2.name + " > " + name;
				if(nodedata2.pId){
					var nodedata3 = getNameById(nodedata2.pId);
					name = nodedata3.name + " > " + name;
				}
			}
		}
		id.push(name);
		ids.push(id);
		if(treeNode.children){
			var data1 = treeNode.children;
			for(var i=0;i<data1.length;i++){
				id1 = [];
				id1.push(data1[i].desc);
				id1.push(data1[i].descId);
				var name1 = name + " > " + data1[i].name; 
				id1.push(name1);
				ids.push(id1);
				
				if(data1[i].children){
					var data2 = data1[i].children;
					for(var j=0;j<data2.length;j++){
						id2 = [];
						id2.push(data2[j].desc);
						id2.push(data2[j].descId);
						var name2 = name1 + " > " + data2[j].name;
						id2.push(name2);
						ids.push(id2);
						
						if(data2[j].children){
							var data3 = data2[j].children;
							for(var k=0;k<data3.length;k++){
								id3 = [];
								id3.push(data3[k].desc);
								id3.push(data3[k].descId);
								var name3 = name2 + " > " +data3[k].name;
								id3.push(name3);
								ids.push(id3);
							}
						}
					}
				}
				
			}
		}
		$scope.userinfoquery.ids = ids;
		$scope.userinfoquery.page = 0;
		
		userServer.getUserInfoDescByIds($scope.userinfoquery).then(function(data){
			console.log(data);
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
				$scope.userinfos = [];
				$scope.count = 0;
			}
			
		});
	});
	
	
	function pageselectCallback(page_index, jq){
		$scope.userinfoquery.page = page_index;
		$scope.userinfos = {};
		userServer.getUserInfoDescByIds($scope.userinfoquery).then(function(data){
//			$scope.fenceinfos = data.data;
			$scope.indexPage = page_index;
			$scope.userinfos = data.data;
			$scope.count = data.count;
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
	
	$scope.searchInfo = function(){
		if(!$scope.userinfoquery.ids){
			return;
		}
		$scope.userinfoquery.page = 0;
		$scope.indexPage = 0;
		$scope.userinfos = {};
//		$scope.count = 0;
		userServer.getUserInfoDescByIds($scope.userinfoquery).then(function(data){
			console.log(data);
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
				$scope.userinfos = [];
				$scope.count = 0;
			}
			
		});
	}
	
	function onClick(event, treeId, treeNode, clickFlag) {
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.expandNode(treeNode);
		
		$scope.userinfoquery.page = 0;
		$scope.count = 0;
		$scope.indexPage = 0;
		$scope.userinfos = {};
		
		
		ids = [];
		
		id = [];
		id.push(treeNode.desc);
		id.push(treeNode.descId);
		var name = treeNode.name;
		if(treeNode.pId){
			var nodedata1 = getNameById(treeNode.pId);
			name = nodedata1.name + " > " + name;
			if(nodedata1.pId){
				var nodedata2 = getNameById(nodedata1.pId);
				name = nodedata2.name + " > " + name;
				if(nodedata2.pId){
					var nodedata3 = getNameById(nodedata2.pId);
					name = nodedata3.name + " > " + name;
				}
			}
		}
		id.push(name);
		ids.push(id);
		if(treeNode.children){
			var data1 = treeNode.children;
			for(var i=0;i<data1.length;i++){
				id1 = [];
				id1.push(data1[i].desc);
				id1.push(data1[i].descId);
				var name1 = name + " > " + data1[i].name; 
				id1.push(name1);
				ids.push(id1);
				
				if(data1[i].children){
					var data2 = data1[i].children;
					for(var j=0;j<data2.length;j++){
						id2 = [];
						id2.push(data2[j].desc);
						id2.push(data2[j].descId);
						var name2 = name1 + " > " + data2[j].name;
						id2.push(name2);
						ids.push(id2);
						
						if(data2[j].children){
							var data3 = data2[j].children;
							for(var k=0;k<data3.length;k++){
								id3 = [];
								id3.push(data3[k].desc);
								id3.push(data3[k].descId);
								var name3 = name2 + " > " +data3[k].name;
								id3.push(name3);
								ids.push(id3);
							}
						}
					}
				}
				
			}
		}
		
//		console.log(ids);
		
		$scope.userinfos = {};
		
		
		$scope.userinfoquery.ids = ids;
		
//		userServer.getUserInfoDescByRoleAndRid($scope.userinfoquery).then(function(data){
//			console.log(data);
//			if(data.state){
//				$scope.userinfos = data.data;
//				$scope.count = data.count;
//				
//				var optInit = getOptionsFromForm();
//		        $("#Pagination").pagination(data.count, optInit);
//		        
//				$("#Pagination").click(function(){
//		            var opt = getOptionsFromForm();
//		            $("#Pagination").pagination(data.count, opt);
//		        }); 
//			}else{
//				$scope.userinfos = [];
//				$scope.count = 0;
//			}
//			
//		});
		userServer.getUserInfoDescByIds($scope.userinfoquery).then(function(data){
			console.log(data);
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
				$scope.userinfos = [];
				$scope.count = 0;
			}
			
		});
		
		    
	}
	
	function getNameById(id){
		if($scope.zNodes){
			nodedata = $scope.zNodes;
			for(var i=0;i<nodedata.length;i++){
				if(nodedata[i].id==id){
					return nodedata[i];
				}
			}
		}
	}
	
	
});

app.directive("userop",function($rootScope,$document,userServer){
	return{
		restrict:"E",
		require:"ngModel",
		link:function(scope,element,attrs,ngModel){
			element.bind("click",function(){
				console.log(ngModel.$modelValue);
				if(ngModel.$modelValue.imgsrc){
					$("#userinfosimg").attr("src",$rootScope.imgpath+ngModel.$modelValue.id);
				}else{
					$("#userinfosimg").attr("src","images/adduser.jpg");
				}
				$rootScope.detailedinfos.describe = ngModel.$modelValue.describe;
				$rootScope.detailedinfos.equipTypeStr = ngModel.$modelValue.equipTypeStr;
				$rootScope.detailedinfos.equipnumber = ngModel.$modelValue.equipnumber;
				$rootScope.detailedinfos.getdate = ngModel.$modelValue.getdate;
				$rootScope.detailedinfos.name = ngModel.$modelValue.name;
				$rootScope.detailedinfos.sex = ngModel.$modelValue.sex;
				$rootScope.detailedinfos.phonenumber = ngModel.$modelValue.phonenumber;
				$rootScope.detailedinfos.worktypeStr = ngModel.$modelValue.worktypeStr;
				var role = ngModel.$modelValue.role;
				if(role=="0"){
					$rootScope.detailedinfos.roleStr = "系统管理员";
				}else if(role=="1"){
					$rootScope.detailedinfos.roleStr = "公司管理员";
				}else if(role=="2"){
					$rootScope.detailedinfos.roleStr = "分公司管理员";
				}else if(role=="3"){
					$rootScope.detailedinfos.roleStr = "部门管理员";
				}else if(role=="4"){
					$rootScope.detailedinfos.roleStr = "分组管理员";
				}else{
					$rootScope.detailedinfos.roleStr = "其他";
				}
				scope.$apply(function(){
					$("#userinfosbutton").click();
				});
			});
		}
	}
});