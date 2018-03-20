app.controller("ztreeCtrl",function($scope){
	var setting = {
			edit: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
//			callback: {
//				beforeDrag: beforeDrag
//			}
		};

		var zNodes =[
			{ id:1, pId:0, name:"父节点 1", open:true},
			{ id:11, pId:1, name:"叶子节点 1-1"},
			{ id:12, pId:1, name:"叶子节点 1-2"},
			{ id:13, pId:1, name:"叶子节点 1-3"},
			{ id:2, pId:0, name:"父节点 2", open:true},
			{ id:21, pId:2, name:"叶子节点 2-1"},
			{ id:22, pId:2, name:"叶子节点 2-2"},
			{ id:23, pId:2, name:"叶子节点 2-3"},
			{ id:3, pId:0, name:"父节点 3", open:true},
			{ id:31, pId:3, name:"叶子节点 3-1"},
			{ id:32, pId:3, name:"叶子节点 3-2"},
			{ id:33, pId:3, name:"叶子节点 3-3"}
		];

//		function beforeDrag(treeId, treeNodes) {
//			return false;
//		}
		
		function setEdit() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
//			remove = $("#remove").attr("checked"),
//			rename = $("#rename").attr("checked"),
//			removeTitle = $.trim($("#removeTitle").get(0).value),
//			renameTitle = $.trim($("#renameTitle").get(0).value);
//			console.log(remove);
			zTree.setting.edit.showRemoveBtn = true;
			zTree.setting.edit.showRenameBtn = true;
			zTree.setting.edit.removeTitle = true;
			zTree.setting.edit.renameTitle = true;
//			showCode(['setting.edit.showRemoveBtn = ' + remove, 'setting.edit.showRenameBtn = ' + rename,
//				'setting.edit.removeTitle = "' + removeTitle +'"', 'setting.edit.renameTitle = "' + renameTitle + '"']);
		}
//		function showCode(str) {
//			var code = $("#code");
//			code.empty();
//			for (var i=0, l=str.length; i<l; i++) {
//				code.append("<li>"+str[i]+"</li>");
//			}
//		}
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setEdit();
//			$("#remove").bind("change", setEdit);
//			$("#rename").bind("change", setEdit);
//			$("#removeTitle").bind("propertychange", setEdit)
//			.bind("input", setEdit);
//			$("#renameTitle").bind("propertychange", setEdit)
//			.bind("input", setEdit);
		});
})