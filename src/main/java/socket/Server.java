package socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.*;
import java.util.HashMap;

public class Server {

	/**
	 * 所有客户端的线程费服务类
	 */
	public static HashMap<String,ClientThread> clients = new HashMap<String,ClientThread>();
	public static void main(String [] args) throws IOException{
		//1.建立服务端的端口监听 再8989端口监听
		ServerSocket server = new ServerSocket(8989);
		System.out.println("服务端开放8989端口等待连接…………");
		while(true){//死循环
			//2.等待连接
			Socket socket = server.accept();//接收，阻塞方法
			System.out.println("客户端连接成功……………………");
			ClientThread clientNew = new ClientThread(socket);
			clientNew.start();
		}
	}
}

class ClientThread extends Thread{
	//当前客户端的对应的socket对象
	private Socket socket;
	//读取客户端发送的内容
	private BufferedReader reader;
	//服务端发送客户端消息的writer
	private PrintWriter writer;
	//客户端的用户名
	private String name;
	//客户端的IP地址
	private String ip;
	public ClientThread(Socket socket){
		this.socket = socket;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			writer = new PrintWriter(socket.getOutputStream());
			//第一个消息是客户端发送到用户名
			//1.
			this.name = reader.readLine();
			this.ip = socket.getInetAddress().getHostAddress();
			//发送消息通知所有人新用户连接
			sendMessage("ADD#"+this.name+this.ip);
			Server.clients.put(name+ip, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		try {
			while(true){
				
					String message = reader.readLine();
					String[] msgs = message.split("#");
					if(msgs[0].equals("DEL")){
						Server.clients.remove(name+ip);
						sendMessage(message);
					}else if(msgs[0].equals("PRI")){
						ClientThread target = Server.clients.get(msgs[1]);
						target.getWriter().println("["+name+ip+"]对你说:"+msgs[2]);
						target.getWriter().flush();
					}else if(msgs[0].equals("ALL")){
						sendMessage(msgs[1]);
					}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	* @Title: sendMessage 
	* @Description: 发送消息的处理方法
	* @param message    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void sendMessage(String message){
		ClientThread clientThread ;
		for(String key : Server.clients.keySet()){
			try{
				clientThread = Server.clients.get(key);
				clientThread.getWriter().println(message);
				clientThread.getWriter().flush();
			}catch(Exception ex){
				Server.clients.remove(key);
			}
		}
	}
	public BufferedReader getReader() {
		return reader;
	}
	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}
	public PrintWriter getWriter() {
		return writer;
	}
	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}
	
}
