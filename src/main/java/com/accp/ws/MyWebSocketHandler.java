package com.accp.ws;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

//1.配置站点
@ServerEndpoint("/ws/test/{newstype}")
@Component
public class MyWebSocketHandler {

	private final static Set<Session> usersSet = new CopyOnWriteArraySet<Session>();// 线程安全

	private final static Map<String, Session> usersMap = new ConcurrentHashMap<String, Session>();// 线程安全

	private String userName;

	@OnOpen
	public void onopen(Session session, @PathParam("name") String name) {
		System.out.println("接收客户端【" + session.getId() + "】连接");
		usersSet.add(session);// 保存
		usersMap.put(name, session);
		this.userName = name;
		// 启用心跳程序
		new Thread() {
			public void run() {
				while (true) {
					try {
						System.out.println("服务器心跳程序启动");
						session.getBasicRemote().sendText("pong");
						Thread.sleep(15000);
					} catch (Exception e) {
						usersSet.remove(session);
						break;
					}
				}
			}
		}.start();

	}

	@OnClose
	public void onclose(Session session) {
		System.out.println("客户端【" + session.getId() + "】连接关闭");
		usersSet.remove(session);
		usersMap.remove(userName);
	}

	@OnError
	public void onerror(Session session, Throwable e) {
		System.out.println("客户端【" + session.getId() + "】通讯异常");
		usersSet.remove(session);
		usersMap.remove(userName);

	}

	private void sendAllUsers(String msg) {
		for (Session session : usersSet) {
			try {
				session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				continue;
			}
		}
	}
	
	private void sendUsers(String name,String msg) {
		try {
			usersMap.get(name).getBasicRemote().sendText(msg);
		} catch (IOException e) {
			return;
		}
	}

	// 这个方法的参数位置不能更改
	@OnMessage
	public void onmessage(String msg, Session session) {
		// 发消息
		try {
			if (!"ping".equals(msg)) {
				if ("小成".equals(msg)) {
					session.getBasicRemote().sendText("小成需要凤姐");
				} else if ("小林".equals(msg)) {
					session.getBasicRemote().sendText("小林需要春哥");
				} else if ("all".equals(msg)) {// 群发
					this.sendAllUsers("群发一条消息");
				}else if(msg.contains("@")) {
					String[] temp=msg.split("@");
					this.sendUsers(temp[1],this.userName+"说:"+temp[0]);//单发
				}
			}
		} catch (IOException e) {
			System.out.println("发送异常");
		}
	}

}
