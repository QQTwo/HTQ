layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//加载页面数据
	var newsData = '';
	$.ajax({
		url : "/tz/getlist",
		type : "get",
		dataType : "json",
		success:function(data){
			newsData = newsList(data);
			$("#li").append(newsData);
		}
	});
	
	$.ajax({
		url : "/tz/getnamelist",
		type : "get",
		dataType : "json",
		success:function(data){
			var op ;
			for(var i in data){
				op = $("<option val="+data[i].fmname+">"+data[i].fmname+"</option>")
				$("#lo").append(op)
			}
		}
	});


	//批量删除
	$(".links_del").click(function(){
		var $checkbox = $('.news_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.news_list tbody input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//删除数据
	            	for(var j=0;j<$checked.length;j++){
	            		var id=$($checked[j]).attr("id");
	            		$.ajax({
	            			url : "/tz/delete",
	            			type : "get",
	            			dataType : "json",
	            			data:{postid:id},
	            			success:function(data){
	            			}
	            		});
	            	}
	            	$('.news_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("删除成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的文章");
		}
	})

	//搜索
	$(".links_ss").click(function(){
		$("#li").html("");
		var fmname=$("select").val();
		var title=$("#ss").val();
		$.ajax({
			url : "/tz/getlist",
			type : "get",
			data:{fmname:fmname,title,title},
			dataType : "json",
			success:function(data){
				newsData = newsList(data);
				$("#li").append(newsData);
			}
		});
	})
	//全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断文章是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})

	//是否展示
	form.on('switch(isShow)', function(data){
		var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            layer.close(index);
			layer.msg("展示状态修改成功！");
        },2000);
	})
 
	//操作
	$("body").on("click",".news_edit",function(){  //编辑
		
	})

	$("body").on("click",".news_collect",function(){  //收藏.
		if($(this).text().indexOf("已收藏") > 0){
			layer.msg("取消收藏成功！");
			$(this).html("<i class='layui-icon'>&#xe600;</i> 收藏");
		}else{
			layer.msg("收藏成功！");
			$(this).html("<i class='iconfont icon-star'></i> 已收藏");
		}
	})

	$("body").on("click",".news_del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			//_this.parents("tr").remove();
			for(var i=0;i<newsData.length;i++){
				if(newsData[i].newsId == _this.attr("data-id")){
					newsData.splice(i,1);
					newsList(newsData);
				}
			}
			layer.close(index);
		});
	})

	/*//删除
	$("body").on("click",".links_del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			for(var i=0;i<newsData.length;i++){
				if(newsData[i].newsId == _this.attr("data-id")){
					newsData.splice(i,1);
					newsList(newsData);
				}
			}
			layer.close(index);
		});
	})
*/
	
	function newsList(data){
		//渲染数据
		
			var dataHtml = '';
			if(data.length != 0){
				for(var i=0;i<data.list.length;i++){
					dataHtml += '<tr>'
			    	+'<td><input type="checkbox" name="checked"  id="'+data.list[i].postid+'" lay-skin="primary" lay-filter="choose"></td>'
			    	+'<td id="">'+data.list[i].postid+'</td>'
			    	+'<td>'+data.list[i].fmname+'</td>'
			    	+'<td>'+data.list[i].title+'</td>'
			    	+'<td>'+data.list[i].releasetime+'</td>';
			    	if(data.list[i].auditstatus == 1){
			    		dataHtml += '<td>'+"未审核"+'</td>';
			    	}else if(data.list[i].auditstatus == 2){
			    		dataHtml += '<td>'+"已审核"+'</td>';
			    	}else{
			    		dataHtml += '<td style="color:#f00">'+"未通过"+'</td>';	
			    	}
			    	dataHtml += '<td>'
					+  '<a class="layui-btn layui-btn-mini news_edit" href="bkgl_updata.html"><i class="iconfont icon-edit"></i>修 改</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="8">暂无数据</td></tr>';
			}
		    return dataHtml;
		

		
	}
})
