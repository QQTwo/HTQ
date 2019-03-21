layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//加载页面数据
	var linksData = '';
	loadInfo(0);
//	$.ajax({
//		url : "/wdg/advs/0/1/30",
//		type : "get",
//		dataType : "json",
//		success : function(data){
//			linksData = data.list;
//			if(window.sessionStorage.getItem("addLinks")){
//				var addLinks = window.sessionStorage.getItem("addLinks");
//				linksData = JSON.parse(addLinks).concat(linksData);
//			}
//			//执行加载数据的方法
//			linksList();
//		}
//	})
	//加载广告分类
	$.ajax({
		url : "/wdg/adv/types",
		type : "get",
		dataType : "json",
		success:function(data){
			$("#types_select").html("");
			$("#types_select").append("<option value='0'>请选择</option>");
			$.each(data,function(i,e){
				$("#types_select").append("<option value="+e.atid+">"+e.atname+"</option>");
			});
		}
	});
	//查询
	$(".search_btn").click(function(){
			 var index =  layer.msg('查询中，请稍候',{icon: 16,time:800,shade:0.8});
			 setTimeout(function(){
				 loadInfo($("#types_select").val());
			 },800);
	})

	//添加友情链接
	$(".linksAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "添加友情链接",
			type : 2,
			content : "linksAdd.html",
			success : function(layero, index){
				setTimeout(function(){
					layui.layer.tips('点击此处返回友链列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				},500)
			}
		})
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})

	//批量删除
	$(".batchDel").click(function(){
		var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//删除数据
	            	for(var j=0;j<$checked.length;j++){
	            		for(var i=0;i<linksData.length;i++){
							if(linksData[i].aid == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
								deleteAdv(linksData[i].aid);
								linksData.splice(i,1);
								linksList(linksData);
							}
						}
	            	}
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("删除成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的文章");
		}
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
		data.elem.checked;
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})
 
	//操作
	$("body").on("click",".links_edit",function(){  //编辑
		var aid = $(this).attr("data-id");
		cookie.set("advid",aid,3000);
		cookie.set("type",2,3000);
//		window.sessionStorage.setItem("advid",aid);
//		window.sessionStorage.setItem("type",2);//标记为续费
		window.parent.addTab($('<a href="javascript:;" data-url="page/advertisement/insertAd.html"><i class="layui-icon" data-icon=""></i><cite>续费</cite></a>'));
		//window.location.href="insertAd.html";
	})

	$("body").on("click",".links_del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			//_this.parents("tr").remove();
			for(var i=0;i<linksData.length;i++){
				if(linksData[i].aid == _this.attr("data-id")){
					deleteAdv(linksData[i].aid);
					linksData.splice(i,1);
					linksList(linksData);
				}
			}
			layer.close(index);
		});
	})
	//删除广告
	function deleteAdv(aid){
		$.ajax({
			type:"DELETE",
			url:"http://127.0.0.1:7777/wdg/adv/"+aid,
			success:function(flag){
				if (flag==false) {
					layer.msg("服务器正忙(-500)");
				}else{
					layer.msg("删除成功");
				}
			}
		});
	}
	
	
	function loadInfo(atid){
		$.ajax({
			url : "/wdg/advs/"+atid,
			type : "get",
			dataType : "json",
			success : function(data){
				linksData = data;
				if(window.sessionStorage.getItem("addLinks")){
					var addLinks = window.sessionStorage.getItem("addLinks");
					linksData = JSON.parse(addLinks).concat(linksData);
				}
				//执行加载数据的方法
				linksList();
			}
		})
	}
	
	function dateFtt(fmt,date){ //author: meizz   
	  var o = {   
	    "M+" : date.getMonth()+1,                 //月份   
	    "d+" : date.getDate(),                    //日   
	    "h+" : date.getHours(),                   //小时   
	    "m+" : date.getMinutes(),                 //分   
	    "s+" : date.getSeconds(),                 //秒   
	    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
	    "S"  : date.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	    if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;   
	} 
	
	
	function linksList(that){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = linksData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
			if(currData.length != 0){
				
				for(var i=0;i<currData.length;i++){
						var endTime = "<td>---</td>";
						var btn = '<a class="layui-btn layui-btn-mini "><i class="iconfont icon-edit"></i> 编辑</a>';
						if(currData[i].startTime!= "" && currData[i].startTime !=null &&currData[i].rentamonth!=""){
							var d = new Date(currData[i].startTime);
							d.setMonth(d.getMonth()+currData[i].rentamonth);
							endTime = "<td>"+dateFtt("yyyy-MM-dd hh:mm:ss",d)+"</td>";
							btn +=  '<a class="layui-btn layui-btn-warm layui-btn-mini links_edit" data-id="'+currData[i].aid+'"><i class="layui-icon">&#xe61f;</i> 续费</a>';
						}
						dataHtml += '<tr>'
					    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
					    	+'<td align="left">'+currData[i].atitle+'</td>'
					    	+'<td>'+currData[i].aorder+'</td>'
					    	+'<td><img src="'+currData[i].aimgPath+'" width="200px"/></td>'
					    	+endTime
					    	+'<td>'+currData[i].atname+'</td>'
					    	+'<td>'
					    	+btn
							+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="'+data[i].aid+'"><i class="layui-icon">&#xe640;</i> 删除</a>'
					        +'</td>'
					    	+'</tr>';
					
				}
			}else{
				dataHtml = '<tr><td colspan="7">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 6; //每页出现的数据量
		if(that){
			linksData = that;
		}
		laypage({
			cont : "page",
			pages : Math.ceil(linksData.length/nums),
			jump : function(obj){
				$(".links_content").html(renderDate(linksData,obj.curr));
				$('.links_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
})


