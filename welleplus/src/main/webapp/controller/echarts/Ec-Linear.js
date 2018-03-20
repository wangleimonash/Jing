



//echarts基本参数  
    app.factory('$echartsConfig1', function () {  
        return {  
  
//        	 title: {
//        	        text: '堆叠区域图'
//        	    },
        	    tooltip : {
        	        trigger: 'axis',
        	        axisPointer: {
        	            type: 'cross',
        	            label: {
        	                backgroundColor: '#6a7985'
        	            }
        	        }
        	    },
        	    legend: {
        	        data:['日出勤','周出勤','月出勤','年出勤','总出勤']
        	    },
//        	    toolbox: {
//        	        feature: {
//        	            saveAsImage: {}
//        	        }
//        	    },
        	    grid: {
        	        left: '3%',
        	        right: '4%',
        	        bottom: '3%',
        	        containLabel: true
        	    },
        	    xAxis : [
        	        {
        	            type : 'category',
        	            boundaryGap : false,
        	            data : []
        	        }
        	    ],
        	    yAxis : [
        	        {
        	            type : 'value'
        	        }
        	    ],
        	    series : [
        	        {
        	            name:'日出勤',
        	            type:'line',
        	            stack: '总量',
        	            data:[120, 132, 101, 134, 90, 230, 210]
        	        },
        	        {
        	            name:'周出勤',
        	            type:'line',
        	            stack: '总量',
        	            data:[220, 182, 191, 234, 290, 330, 310]
        	        },
        	        {
        	            name:'月出勤',
        	            type:'line',
        	            stack: '总量',
        	            data:[150, 232, 201, 154, 190, 330, 410]
        	        },
        	        {
        	            name:'年出勤',
        	            type:'line',
        	            stack: '总量',
        	            data:[320, 332, 301, 334, 390, 330, 320]
        	        },
        	        {
        	            name:'总出勤',
        	            type:'line',
        	            stack: '总量',
        	            label: {
        	                normal: {
        	                    show: true,
        	                    position: 'top'
        	                }
        	            },
        	            data:[820, 932, 901, 934, 1290, 1330, 1320]
        	        }
        	        
        	        
        	        
        	           
        	        
        	        
        	    ]
        };  
    })  
    //echarts directive  
    .directive('echarts1', ['$echartsConfig1','$window', function ($echartsConfig1,$window) {  
        return {  
            restrict: 'A',  
            link: function (scope, element, attrs) {  
                if (!scope.$echartsInstance)  
                    scope.$echartsInstance = {};  
                scope.$watch(attrs.echarts, function () {  
                    var option=angular.extend({},$echartsConfig1,scope.$eval(attrs.echarts1));  
                    if (option.id) {  
                        scope.$echartsInstance[option.id] = echarts.init(element[0]);  
                        scope.$echartsInstance[option.id].setOption(option);  
                    } else {  
                        scope.$echartsInstance = echarts.init(element[0]);  
                        scope.$echartsInstance.setOption(option);  
                    }  
                });  
                $window.onresize = function() {  
                    if(scope.$echartsInstance.searchTimeOption)  
                        scope.$echartsInstance.searchTimeOption.resize();  
                    if(scope.$echartsInstance.searchCostOption1)  
                        scope.$echartsInstance.searchCostOption1.resize();  
                    if(scope.$echartsInstance.searchNumOption)  
                        scope.$echartsInstance.searchNumOption.resize();  
                     
                };  
            }  
        };  
    }]) 
    
    
    