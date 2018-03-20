app.controller('rfidHistoryCtrl', function ($scope, rfidHistoryServer) {
	$scope.treeuser = {};
	$scope.treeuser.userName = getCookie("welleplususername");
	$scope.treeuser.role = getCookie("welleplusrole");
	$scope.treeuser.rid = getCookie("welleplusrid");
	$scope.treeuser.id = getCookie("welleplusuid");
	rfidHistoryServer.getRfidInfo($scope.treeuser).then(function(data){
		//console.log(data);
		$scope.rfidInfos = data.data;
	});

	$scope.findhistory = function () {
		$scope.treeuser.startdate = $('#startdate').val();
		$scope.treeuser.enddate = $('#enddate').val();
		$scope.treeuser.type2 = $('#type2').val();
		rfidHistoryServer.getRfidInfo($scope.treeuser).then(function(data){
			console.log(data);
			$scope.rfidInfos = data.data;
		});
	}

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
	
	rfidHistoryServer.getUserRfidInfo($scope.treeuser).then(function(data){
		//console.log(data);

	
	var data = data.data;

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
                data: data,
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
});