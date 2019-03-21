function weiduInfo(){
	var xtxxNum=0;
	var znxNum=0;
	$.getJSON("/c/gsq/user/queryAllNews",function(data){
		$.each(data,function(i,obj){			
			if(obj.newstype==1 && obj.readstate==0){
				xtxxNum=xtxxNum+1;
			}else if(obj.newstype==2 && obj.readstate==0){
				znxNum=znxNum+1;
			}
		})
		$("[name=xtxx]").html(xtxxNum);
		$("[name=znx]").html(znxNum);
	})
}