$(function(){
	$("<audio id='chatAudio'><source src='/Public/muisc/muisc.mp3' type='audio/mpeg' ></audio>").appendTo('body');
	
})	
var msgtype = 0;

		//初始化ws
		function initWebSocket(newstype,userid) {
			
			
				//var userid=[[${USER.userid}]];
				
			//1.创建引擎 (必须是ws协议)
			if(window.WebSocket) {
				ws = new WebSocket("ws://127.0.0.1:7777/ws/sys/"+newstype+"/"+userid);
				//2.绑定事件
				ws.onopen = function() {
					console.info("长连接建立成功,可以通讯");					
				}
				ws.onclose = function() {
					
				}
				ws.onerror = function() {
					
				}
				ws.onmessage = function(e) {
					var msg = e.data; //服务器文本消息	
					
					
					if(newstype==-1){
					$(".msg_num").html(msg);
					
					if(msg>0){
						if(msgtype == 0){
							bf();
							msgtype = 1;
							layer.open({
								title:"系统提示",
								content:'韩汀中你有一条新消息,请注意查收',
								offset:'rb',
								icon:6,
								anim: 2,
								shade:0,
								btnAlign:'r',
								fixed:false,
								move:false
							});
						}
							
						
					}
					}
					if(newstype==1){
						$("[name=xtxx]").html(msg);
						
					}
					if(newstype==2){
						$("[name==znx]").html(msg);
					}
					if(msg==0){
						$(".msg_num").remove();
					}
					
					
					
				}
			} else {
				alert("不支持WebSocket技术");
			}
		}

function bf(){
	var id=$("#chatAudio")[0];
	if(id.paused){
		id.play();	
		setTimeout(function(){id.pause()},2500)
	}
	else {
		id.pause();
	}
}