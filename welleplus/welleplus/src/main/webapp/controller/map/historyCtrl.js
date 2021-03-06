app.controller('historyCtrl', function ($scope, historyServer, equipTypeListServer) {
    $scope.map = {};
    $scope.map.role = getCookie("welleplusrole");
    $scope.map.rid = getCookie("welleplusrid");
    $scope.map.sysUserid = getCookie("welleplusuid");
    $scope.treeuser = {};
    $scope.treeuser.userName = getCookie("welleplususername");
    $scope.treeuser.role = getCookie("welleplusrole");
    $scope.treeuser.rid = getCookie("welleplusrid");
    $scope.treeuser.id = getCookie("welleplusuid");
    //地图显示
    var map = new AMap.Map("container", {
        resizeEnable: true,
        zoom: 10
    });
    AMap.plugin('AMap.ToolBar', function () {
        var toolbar = new AMap.ToolBar();
        map.addControl(toolbar)
    })
    //工具条
    AMap.plugin(['AMap.ToolBar', 'AMap.Scale', 'AMap.OverView'],
        function () {
            map.addControl(new AMap.ToolBar());

            map.addControl(new AMap.Scale());

            map.addControl(new AMap.OverView({isOpen: true}));
        });
    var date = new Date();
    var year = 1900 + date.getYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    var minutes = date.getMinutes();
    var second = date.getSeconds();
    $scope.map.startdate = year + "-" + month + "-" + day + " 00:00:00";
    $scope.map.enddate = year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + second;

    //执行一个laydate实例
    laydate.render({
        elem: '#startdate' //指定元素
        , type: 'datetime'
        , format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//        ,min: '2000-01-01 00:00:00'
//        ,max: 'new Date()'
        , theme: '#393D49'
    });
    laydate.render({
        elem: '#enddate' //指定元素
        , type: 'datetime'
        , format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
//        ,min: '2000-01-01 00:00:00'
//        ,max: 'new Date()'
        , theme: '#393D49'
    });
    equipTypeListServer.getnpes($scope.treeuser).then(function (data) {
        // $rootScope.equipInfos = data.data;
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

    $scope.searchhistory = function () {
        $scope.map.param = $('#param2').val();

        $scope.map.startdate = $('#startdate').val();
        $scope.map.enddate = $('#enddate').val();

        console.log($scope.map);
        historyServer.getHistory($scope.map).then(function (data) {
            console.log(data);
            if (data.state) {
                // alert(data.message);
                // flag = true;
            } else {
                alert(data.message);
                // flag = false;
            }
            $scope.historys = data.data;
            var lineArr = [];
            map = new AMap.Map('container', {
                resizeEnable: true,
                // center: [data.data[0].xloc, data.data[0].yloc],
                // center: [(Number(data.data[0].Xloc)+Number(data.data[data.data.length-1].Xloc))/2, (Number(data.data[0].Yloc)+Number(data.data[data.data.length-1].Yloc))/2],
                zoom: 10
            });
            if ($scope.map.param == null||$scope.map.param=='') {
                marker.setMap(null);
                lineArr.setMap(null);
                return;
            }
            if (data.data != null&data.state) {

                if(data.data[0].Xloc==''|data.data[0].Xloc==null){
                    map = new AMap.Map('container', {
                        resizeEnable: true,
                        // center: [data.data[0].xloc, data.data[0].yloc],
                        // center: [(Number(data.data[0].Xloc)+Number(data.data[data.data.length-1].Xloc))/2, (Number(data.data[0].Yloc)+Number(data.data[data.data.length-1].Yloc))/2],
                        zoom: 10
                    });
                    alert("没有查到符合条件的位置信息！！")
                }else {
                    map = new AMap.Map('container', {
                        resizeEnable: true,
                        // center: [data.data[0].xloc, data.data[0].yloc],
                        center: [(Number(data.data[0].Xloc)+Number(data.data[data.data.length-1].Xloc))/2, (Number(data.data[0].Yloc)+Number(data.data[data.data.length-1].Yloc))/2],
                        zoom: 10
                    });
                }
                for (var i = 0; i < data.data.length; i++) {
                    var result = data.data[i];
                    lineArr.push([result.Xloc, result.Yloc]);
                }
                ;

                var marker = new AMap.Marker({ //添加自定义点标记
                    map: map,
                    position: [data.data[0].Xloc, data.data[0].Yloc], //基点位置
                    offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
                    draggable: false,  //是否可拖动
                    content: '<div class="marker-route marker-marker-bus-end"></div>',  //自定义点标记覆盖物内容
                });
                marker.setTitle('定位方式:' + data.data[data.data.length - 1].position + '\n位置:' + data.data[0].address + '\n时间:' + data.data[0].datetime);

                var marker = new AMap.Marker({ //添加自定义点标记
                    map: map,
                    position: [data.data[data.data.length - 1].Xloc, data.data[data.data.length - 1].Yloc], //基点位置
                    // offset: new AMap.Pixel(-7, -30), //相对于基点的偏移位置
                    offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
                    draggable: false,  //是否可拖动
                    content: '<div class="marker-route marker-marker-bus-from"></div>',  //自定义点标记覆盖物内容

                });
                marker.setTitle('定位方式:' + data.data[data.data.length - 1].position + '\n位置:' + data.data[data.data.length - 1].address + '\n时间:' + data.data[data.data.length - 1].datetime);

                // 设置鼠标划过点标记显示的文字提示

                // 设置label标签
                // marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
                //     offset: new AMap.Pixel(20, 20),//修改label相对于maker的位置
                //     content: "我是marker的label标签"
                // });
                //折线样式
                var polyline = new AMap.Polyline({
                    path: lineArr,          //设置线覆盖物路径
                    strokeColor: "#3366FF", //线颜色
                    strokeOpacity: 1,       //线透明度
                    strokeWeight: 5,        //线宽
                    strokeStyle: "solid",   //线样式
                    strokeDasharray: [10, 5] //补充线样式
                });
                polyline.setMap(map);
            } else {
                polyline.setMap(null);
                map = new AMap.Map('container', {
                    resizeEnable: true,
                    // center: [data.data[0].xloc, data.data[0].yloc],
                    // center: [(data.data[0].xloc+data.data[data.data.length-1].xloc)/2, (data.data[0].yloc+data.data[data.data.length-1].yloc)/2],
                    zoom: 10
                });
                alert("新地图");

            }
        });
    }
});