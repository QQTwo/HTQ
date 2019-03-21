package com.accp.ws;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.accp.biz.gsq.UserBiz;
import com.accp.ws.cfg.HttpSessionConfigurator;

@ServerEndpoint(value = "/ws/sys/{newstype}/{userid}", configurator = HttpSessionConfigurator.class)
@Component
public class SysMessageSocketHanlder {

	private final static Map<String, Session> usersMap = new ConcurrentHashMap<String, Session>();

	public static ApplicationContext ac;// 非常重要

	private String userName;

	@OnOpen
	public void onopen(Session session,@PathParam("newstype")Integer newstype,@PathParam("userid")Integer userid) {
		System.out.println("newstype"+newstype);
		//EmailBiz emailbiz=(EmailBiz)ac.getBean("EmailBiz");		
		UserBiz userBiz=(UserBiz) ac.getBean("UserBiz");
		// 最新消息推送功能
		new Thread() {
			public void run() {				
				while (true) {
					try {
						int countInit=userBiz.selectNoReader(newstype,userid);
						
						session.getBasicRemote().sendText(String.valueOf(countInit));	
					
						Thread.sleep(3000);
						int count = userBiz.selectNoReader(newstype,userid);	
						
						if (count > countInit) {							
							session.getBasicRemote().sendText(String.valueOf(count));
							countInit = count;
						}
					} catch (Exception e) {
							e.printStackTrace();
						break;
					}
				}
			}
		}.start();
	}

	

	@OnClose
	public void onclose(Session session) {
		
	}

	@OnError
	public void onerror(Session session, Throwable ex) {
		
	}

	@OnMessage
	public void onmessage(String msg, Session session) {
		
	}
}
