//$("#showbutton").click(function(){
//	$("#myfile").click();
//});

function clickfile(){
	$("#myfile").click();
}

function uploadfile(docObj){
	var name=docObj.value;  
    var type=name.split(".");  
    type=type[type.length-1];  
    if("jpg"!=type &&"png"!=type &&"jpeg"!=type&&"gif"!=type){  
        alert("错误的类型，请选择图片");  
        document.getElementById("myfile").value=null;//防止将非图片类型上传  
        return ;  
    }
    
    var id = $("#userid").val();
    if(id){
    	var formData = new FormData();
        formData.append("myfile", document.getElementById("myfile").files[0]);
//        formData.append("id",id);
        $("#myimg").attr("src","images/loading.gif");
        $.ajax({
            url: "/welleplus/file/uploadfile.do?id="+id,
            type: "POST",
            data: formData,
            /**
            *必须false才会自动加上正确的Content-Type
            */
            contentType: false,
            /**
            * 必须false才会避开jQuery对 formdata 的默认处理
            * XMLHttpRequest会对 formdata 进行正确的处理
            */
            processData: false,
            success: function (data) {
                if (data.state) {
                	$("#myimg").attr("src","/welleplus/file/viewimg.do?rand="+Math.random()+"&id="+id);
//                    alert("上传成功！");
                    $("#myfile").val("");
                }else{
                	alert(data.message);
                	$("#myimg").attr("src","/welleplus/file/viewimg.do?rand="+Math.random()+"&id="+id);
                }
//                 $("#imgWait").hide();
            },
            error: function () {
                alert("图片过大，最多支持5M");
//                 $("#imgWait").hide();
                $("#myimg").attr("src","/welleplus/file/viewimg.do?rand="+Math.random()+"&id="+id);
            }
        });
    }else{
    	
    }
    
    
}


