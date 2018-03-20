app.controller('equipTypeListCtrl',function($scope,$rootScope,projectService,equipTypeListServer,userServer,app_threeSer){
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
	$rootScope.indexPage = 0;
	$scope.treeuser.equiptype = 0;
	$scope.treeuser.worktype = 0;
	$scope.engineer = {};
	//$scope.treeuser.worktype = 0;
    var date = new Date();
    var year = 1900 + date.getYear();
    var month = date.getMonth()+1;
    var day = date.getDate();
    var hour = date.getHours();
    var minutes = date.getMinutes();
    var second = date.getSeconds();
    $scope.treeuser.startdate = year+"-"+month+"-"+day+" 00:00:00";
    $scope.treeuser.enddate = year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+second;
	var da;

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
	
	$scope.treeNode1 = null;
	function onClick(event, treeId, treeNode, clickFlag) {
		$scope.role = treeNode.desc;
		var zTree = $.fn.zTree.getZTreeObj("tree");
		treeNode1 = treeNode;
		//console.log(treeNode);
		zTree.expandNode(treeNode);
		
		
		//var parent = $('#type2').parentNode;
		// var parent = document.getElementById("type2").parentNode;
		//var parent = $('#type2').nextSibling;
		//var parents = $('#type2').previousSibling
        // parent.removeChild(document.getElementById("type2").previousSibling);
	    //parent.removeChild(document.getElementById("type2").nextSibling);
		//parent.removeChild("span");
        // if(!document.getElementById("type2").isSameNode(parent.lastChild)){
	    	// //parent.removeChild(parent.lastChild.previousSibling);
	    	// parent.removeChild(document.getElementById("type2").nextSibling);
        // }
        // console.log(parent);
		//console.log(parents);
		
		$scope.treeuser.descId = treeNode.descId;
		$scope.treeuser.desc = treeNode.desc;
		$scope.treeuser.page = 0;
		$rootScope.indexPage = 0;
		equipTypeListServer.getliststree($scope.treeuser).then(function(data){
			//console.log(data.data);
			$rootScope.equipInfos = data.data;
			$scope.count = data.count;

			var optInit = getOptionsFromForm();
	        $("#Pagination").pagination(data.count, optInit);
	        
			$("#setoptions").click(function(){
	            var opt = getOptionsFromForm();
	            $("#Pagination").pagination(data.count, opt);
	        }); 
		    
			/*//提示
			da = data.data;

		    var storageKey = 'TYPEAHEAD_SUGGESTIONS',
		        storageData = JSON.parse(localStorage.getItem(storageKey)) || [];

		    function clearSuggestions () {
		        localStorage.removeItem(storageKey);
		        storageData = [];
		    }
		    typeof $.typeahead === 'function' && $.typeahead({
		        input: ".js-typeahead",
		        minLength: 1,
		        maxItem: 8,
		        maxItemPerGroup: 6,
		        order: "asc",
		        hint: true,
		        searchOnFocus: true,
		        display: ["name","phonenumber", "equipnumber"],
		        emptyTemplate: '',
		        source: {
		            suggestion: {
		                template: "{{name}} {{phonenumber}} {{equipnumber}} <small class='typeahead__suggestion-label'>Suggestion</small>",
		                minLength: 0,
		                maxLength: 0,
		                dynamic: true,
		                filter: false,
		                data: function () {
		                    var deferred = $.Deferred();
		                    setTimeout(function () {
		                    	clearSuggestions();
		                        deferred.resolve(storageData);
		                    }, 250);

		                    return deferred;
		                }
		            },
		            teams: {
		                data: da,
		                matcher: function (item, displayKey) {
		                    var isSuggestion;
		                    for (var i = 0, ii = storageData.length; i < ii; ++i) {
		                        if (storageData[i].name === item.name) {
		                            isSuggestion = true;
		                            break;
		                        }
		                    }
		                    return isSuggestion ? undefined : true;
		                }
		            }
		        },
		        callback: {
		            onClick: function (node, a, item, event) {
		                var maxSuggestions = 3;

		                if (storageData.length >= maxSuggestions) {
		                    storageData.pop();
		                }
		                storageData.unshift(item);

		                localStorage.setItem(storageKey, JSON.stringify(storageData));
		            }
		        },
		        debug: true
		    });*/

		});
	}
	
	
	$scope.treeuser.page = 0;
	equipTypeListServer.getlists($scope.treeuser).then(function(data){
		//console.log(data);
		$rootScope.equipInfos = data.data;
		$scope.count = data.count;

		var optInit = getOptionsFromForm();
        $("#Pagination").pagination(data.count, optInit);
        
		$("#setoptions").click(function(){
            var opt = getOptionsFromForm();
            $("#Pagination").pagination(data.count, opt);
        }); 
		
		
	});
	
	equipTypeListServer.getnpes($scope.treeuser).then(function(data){
		//$rootScope.equipInfos = data.data;		
		//提示
		// da = data.data;

	    var storageKey = 'TYPEAHEAD_SUGGESTIONS',
	        storageData = JSON.parse(localStorage.getItem(storageKey)) || [];

	    function clearSuggestions () {
	        localStorage.removeItem(storageKey);
	        storageData = [];
	    }
	    typeof $.typeahead === 'function' && $.typeahead({
	        input: ".js-typeahead",
	        minLength: 1,
	        maxItem: 8,
	        maxItemPerGroup: 6,
	        order: "asc",
	        hint: true,
	        searchOnFocus: true,
	        display: ["name","phonenumber", "equipnumber"],
	        emptyTemplate: '',
	        source: {
	            suggestion: {
	                template: "{{name}} {{phonenumber}} {{equipnumber}} <small class='typeahead__suggestion-label'>Suggestion</small>",
	                minLength: 0,
	                maxLength: 0,
	                dynamic: true,
	                filter: false,
	                data: function () {
	                    var deferred = $.Deferred();
	                    setTimeout(function () {
	                    	clearSuggestions();
	                        deferred.resolve(storageData);
	                    }, 250);

	                    return deferred;
	                }
	            },
	            teams: {
	                data: da,
	                matcher: function (item, displayKey) {
	                    var isSuggestion;
	                    for (var i = 0, ii = storageData.length; i < ii; ++i) {
	                        if (storageData[i].name === item.name) {
	                            isSuggestion = true;
	                            break;
	                        }
	                    }
	                    return isSuggestion ? undefined : true;
	                }
	            }
	        },
	        callback: {
	            onClick: function (node, a, item, event) {
	                var maxSuggestions = 3;

	                if (storageData.length >= maxSuggestions) {
	                    storageData.pop();
	                }
	                storageData.unshift(item);

	                localStorage.setItem(storageKey, JSON.stringify(storageData));
	            }
	        },
	        debug: true
	    });
	});

	function pageselectCallback(page_index, jq){
		$scope.treeuser.page = page_index;
		if($scope.treeuser.descId&&$scope.treeuser.desc){
			equipTypeListServer.getliststree($scope.treeuser).then(function(data){
				$scope.count = data.count;
				$rootScope.equipInfos = data.data;
				$rootScope.indexPage = page_index;
			});
		}else{
			equipTypeListServer.getlists($scope.treeuser).then(function(data){
				$scope.count = data.count;
				$rootScope.equipInfos = data.data;
				$rootScope.indexPage = page_index;
			});
		}
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
	//下拉框
    $scope.engineer = {
    		name : "t",
    		currentActivity : "工种"
    	};
    $scope.activities = [ "工种" ];
    app_threeSer.getdownbox($scope.treeuser).then(function(data){
		//console.log(data);
		$scope.activities = data.data;
	});	
    
  //时间
	laydate.render({
		elem: '#startdate' //指定元素
			, type: 'datetime'
				, format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//					,min: '2000-01-01 00:00:00'
//					,max: 'new Date()'
					, theme: '#393D49'
	});
	laydate.render({
		elem: '#enddate' //指定元素
			, type: 'datetime'
				, format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//					,min: '2000-01-01 00:00:00'
//					,max: 'new Date()'
					, theme: '#393D49'
	});
	
	//点击查询
	$scope.searchlists = function () {
		$scope.treeuser.startdate = $('#startdate').val();
		$scope.treeuser.enddate = $('#enddate').val();
		$scope.treeuser.type2 = $('#type2').val();
		$scope.treeuser.worktype = $('#gong').val();
		//console.log($scope.treeuser);
		$scope.treeuser.page = 0;
		if($scope.treeuser.descId&&$scope.treeuser.desc){
			equipTypeListServer.getliststree($scope.treeuser).then(function(data){
				$scope.count = data.count;
				$rootScope.equipInfos = data.data;
				$rootScope.indexPage = 0;
				var optInit = getOptionsFromForm();
		        $("#Pagination").pagination(data.count, optInit);
		        
				$("#setoptions").click(function(){
		            var opt = getOptionsFromForm();
		            $("#Pagination").pagination(data.count, opt);
		        }); 
			});
		}else{
			equipTypeListServer.getlists($scope.treeuser).then(function(data){
				$scope.count = data.count;
				$rootScope.equipInfos = data.data;
				$rootScope.indexPage = 0;
				var optInit = getOptionsFromForm();
		        $("#Pagination").pagination(data.count, optInit);
		        
				$("#setoptions").click(function(){
		            var opt = getOptionsFromForm();
		            $("#Pagination").pagination(data.count, opt);
		        }); 
			});
		}
	}
	
});
