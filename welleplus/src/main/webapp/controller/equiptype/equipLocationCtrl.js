app.controller('equipLocationCtrl', function ($scope, $rootScope, equipTypeListServer, projectService, equipLocationServer, userServer, app_threeSer) {
	$rootScope.leftheight = "735px";
    $scope.tree = {};
    $scope.count = {};
    $scope.user = {};
    $scope.userquery = {};
    $scope.userquery.page = 0;
    
    $rootScope.useruser = {};
    $scope.treeuser = {};
    $scope.treeuser.userName = getCookie("welleplususername");
    $scope.treeuser.role = getCookie("welleplusrole");
    $scope.treeuser.rid = getCookie("welleplusrid");
    $scope.treeuser.id = getCookie("welleplusuid");
    $rootScope.indexPage = 0;
    $scope.treeuser.equiptype = 4;
    $scope.treeuser.worktype = 0;
    $scope.engineer = {};
    //$scope.treeuser.worktype = 0;
    var da;
	var date = new Date();
	var year = 1900 + date.getYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hour = date.getHours();
	var minutes = date.getMinutes();
	var second = date.getSeconds();
	$scope.treeuser.startdate = year+"-"+month+"-"+day+" 00:00:00";
	$scope.treeuser.enddate = year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+second;
	
	$scope.engineer.currentActivity = 4;
	
	//$scope.treeuser.worktype = 0;
	
	Date.prototype.Format = function (fmt) {  
	    var o = {  
	        "M+": this.getMonth() + 1, //月份  
	        "d+": this.getDate(), //日  
	        "h+": this.getHours(), //小时  
	        "m+": this.getMinutes(), //分  
	        "s+": this.getSeconds(), //秒  
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度  
	        "S": this.getMilliseconds() //毫秒  
	    };  
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
	    for (var k in o)  
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
	    return fmt;  
	}

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
    projectService.getTreeInfo($scope.treeuser).then(function (data) {
        $scope.zNodes = data;
        $.fn.zTree.init($("#tree"), setting, $scope.zNodes);
        
        var startdate = new Date();
    	var startdatestr = startdate.Format('yyyy-MM-dd 00:00:00');
    	var enddatestr = startdate.Format('yyyy-MM-dd hh:mm:ss');
        $("#startdate").val(startdatestr);
        $("#enddate").val(enddatestr);
        
        var zTree = $.fn.zTree.getZTreeObj("tree");
		var result = zTree.getNodes();
		
		var treeNode = result[0];
ids = [];
		
		id = [];
		id.push(treeNode.desc);
		id.push(treeNode.descId);
		var name = treeNode.name;
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
    	
    	
    	$scope.userquery.ids = ids;
    	$scope.userquery.page = 0;
    	$scope.userquery.startdate = $("#startdate").val();
    	$scope.userquery.enddate = $("#enddate").val();
    	$scope.equipInfos = {};
    	$rootScope.indexPage = 0;
    	userServer.getUserInfoAndPosition($scope.userquery).then(function(data){
    		console.log(data);
    		if(data.state){
    			$scope.equipInfos = data.data;
    			$scope.count = data.count;
    			
    			var optInit = getOptionsFromForm();
    	        $("#Pagination").pagination(data.count, optInit);
    	        
    			$("#Pagination").click(function(){
    	            var opt = getOptionsFromForm();
    	            $("#Pagination").pagination(data.count, opt);
    	        });
    		}else{
    			$scope.equipInfos = {};
    		}
    	});
		
        
    });

    $scope.treeNode1 = null;
    
    function pageselectCallback(page_index, jq) {
    	$scope.equipInfos = {};
        $scope.userquery.page = page_index;
        $rootScope.indexPage = page_index;
        $scope.userquery.startdate = $("#startdate").val();
    	$scope.userquery.enddate = $("#enddate").val();
    	userServer.getUserInfoAndPosition($scope.userquery).then(function(data){
			$scope.equipInfos = data.data;
			$scope.count = data.count;
        });
    	return false;
    }

    function getOptionsFromForm() {
        var opt = {callback: pageselectCallback};
        opt.prev_text = "<<";
        opt.next_text = ">>";
        opt.items_per_page = 10;
        opt.num_display_entries = 4;
        opt.num_edge_entries = 2;
        return opt;
    }

    function onClick(event, treeId, treeNode, clickFlag) {
        $scope.role = treeNode.desc;
        var zTree = $.fn.zTree.getZTreeObj("tree");
        treeNode1 = treeNode;
        //console.log(treeNode);
        zTree.expandNode(treeNode);
        
//        位置分析统计new
        ids = [];
		
		id = [];
		id.push(treeNode.desc);
		id.push(treeNode.descId);
		var name = treeNode.name;
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
    	
    	
    	$scope.userquery.ids = ids;
    	$scope.userquery.startdate = $("#startdate").val();
    	$scope.userquery.enddate = $("#enddate").val();
    	$scope.equipInfos = {};
    	$rootScope.indexPage = 0;
    	userServer.getUserInfoAndPosition($scope.userquery).then(function(data){
    		console.log(data);
    		if(data.state){
    			$scope.equipInfos = data.data;
    			$scope.count = data.count;
    			
    			var optInit = getOptionsFromForm();
    	        $("#Pagination").pagination(data.count, optInit);
    	        
    			$("#Pagination").click(function(){
    	            var opt = getOptionsFromForm();
    	            $("#Pagination").pagination(data.count, opt);
    	        });
    		}else{
    			$scope.equipInfos = {};
    		}
    	});

        /*
                //var parent = $('#type2').parentNode;
                var parent = document.getElementById("type2").parentNode;
                //var parent = $('#type2').nextSibling;
                //var parents = $('#type2').previousSibling
                parent.removeChild(document.getElementById("type2").previousSibling);
                //parent.removeChild(document.getElementById("type2").nextSibling);
                //parent.removeChild("span");
                if(!document.getElementById("type2").isSameNode(parent.lastChild)){
                    //parent.removeChild(parent.lastChild.previousSibling);
                    parent.removeChild(document.getElementById("type2").nextSibling);
                }
                console.log(parent);
                //console.log(parents);
                */
    	
//    	-------------------------------------------------------------------------------
//        $scope.treeuser.descId = treeNode.descId;
//        $scope.treeuser.desc = treeNode.desc;
//        $scope.treeuser.page = 0;
//        $rootScope.indexPage = 0;
//        equipLocationServer.getliststree($scope.treeuser).then(function (data) {
//            //console.log(data.data);
//            $rootScope.equipInfos = data.data;
//            $scope.count = data.count;
//
//            var optInit = getOptionsFromForm();
//            $("#Pagination").pagination(data.count, optInit);
//
//            $("#setoptions").click(function () {
//                var opt = getOptionsFromForm();
//                $("#Pagination").pagination(data.count, opt);
//            });
//            ------------------------------------------------------------------------------

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

    	
//        });
    }


//    $scope.treeuser.page = 0;
//    equipLocationServer.getlists($scope.treeuser).then(function (data) {
//        //console.log(data);
//    	$scope.equipInfos = {};
//    	$rootScope.indexPage = 0;
//    	userServer.getUserInfoAndPosition($scope.userquery).then(function(data){
//    		console.log(data);
//    		if(data.state){
//    			$scope.equipInfos = data.data;
//    			$scope.count = data.count;
//    			
//    			var optInit = getOptionsFromForm();
//    	        $("#Pagination").pagination(data.count, optInit);
//    	        
//    			$("#Pagination").click(function(){
//    	            var opt = getOptionsFromForm();
//    	            $("#Pagination").pagination(data.count, opt);
//    	        });
//    		}else{
//    			$scope.equipInfos = {};
//    		}
//    	});
//		
//	});
    
    $scope.searchlists = function(){
    	$scope.equipInfos = {};
    	$rootScope.indexPage = 0;
    	$scope.userquery.startdate = $("#startdate").val();
    	$scope.userquery.enddate = $("#enddate").val();
    	if(!$scope.userquery.ids){
    		return;
    	}
    	userServer.getUserInfoAndPosition($scope.userquery).then(function(data){
    		console.log(data);
    		if(data.state){
    			$scope.equipInfos = data.data;
    			$scope.count = data.count;
    			
    			var optInit = getOptionsFromForm();
    	        $("#Pagination").pagination(data.count, optInit);
    	        
    			$("#Pagination").click(function(){
    	            var opt = getOptionsFromForm();
    	            $("#Pagination").pagination(data.count, opt);
    	        });
    		}else{
    			$scope.equipInfos = {};
    		}
    	});
    }
	
	equipTypeListServer.getnpes($scope.treeuser).then(function(data){
//		$rootScope.equipInfos = data.data;		
        //提示
        da = data.data;

        var storageKey = 'TYPEAHEAD_SUGGESTIONS',
            storageData = JSON.parse(localStorage.getItem(storageKey)) || [];

        function clearSuggestions() {
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
            display: ["name", "phonenumber", "equipnumber"],
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

    

    //下拉框
//    $scope.engineer = {
//        name: "t",
//        currentActivity: "工种"
//    };
    $scope.activities = ["工种"];
    app_threeSer.getdownbox($scope.treeuser).then(function (data) {
        //console.log(data);
        $scope.activities = data.data;
    });
    //时间
    laydate.render({

        elem: '#startdate' //指定元素
        // ,value:laydate.now(0, \'YYYY-MM-DD hh:mm:ss\')//默认值
        // , startdate: laydate.now(-1, 'YYYY-MM-DD hh:mm:ss')
        // ,value:'2017-10-01 00:00:00'
        , type: 'datetime'
        , format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
        // ,min: '2000-01-01 00:00:00'
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
    // var start = {
    //     elem: '#startdate',
    //     format: 'yyyy-MM-dd HH:mm:ss',
    //     max: laydate.now(),
    //     istime: false,
    //     istoday: false,
    //     // choose: function (datas) {
    //     //     end.min = datas; //开始日选好后，重置结束日的最小日期
    //     //     end.start = datas //将结束日的初始值设定为开始日
    //     // }
    // };
    // laydate(start);
    // $('#startdate').val(laydate.now(-1, 'YYYY-MM-DD'));

    //点击查询
//    $scope.searchlists = function () {
//        $scope.treeuser.startdate = $('#startdate').val();
//        $scope.treeuser.enddate = $('#enddate').val();
//        $scope.treeuser.type2 = $('#type2').val();
//        $scope.treeuser.worktype = $('#gong').val();
//        //console.log($scope.treeuser);
//        $scope.treeuser.page = 0;
//        if ($scope.treeuser.descId && $scope.treeuser.desc) {
//            equipLocationServer.getliststree($scope.treeuser).then(function (data) {
//                $scope.count = data.count;
//                $rootScope.equipInfos = data.data;
//                $rootScope.indexPage = 0;
//                var optInit = getOptionsFromForm();
//                $("#Pagination").pagination(data.count, optInit);
//
//                $("#setoptions").click(function () {
//                    var opt = getOptionsFromForm();
//                    $("#Pagination").pagination(data.count, opt);
//                });
//            });
//        } else {
//            equipLocationServer.getlists($scope.treeuser).then(function (data) {
//                $scope.count = data.count;
//                $rootScope.equipInfos = data.data;
//                $rootScope.indexPage = 0;
//                var optInit = getOptionsFromForm();
//                $("#Pagination").pagination(data.count, optInit);
//
//                $("#setoptions").click(function () {
//                    var opt = getOptionsFromForm();
//                    $("#Pagination").pagination(data.count, opt);
//                });
//            });
//        }
//    }

});
