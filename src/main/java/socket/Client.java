package socket;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Client {
	private JFrame frame;
	private JTextArea textArea;//展示消息
	private JTextField txt_host;//服务器ip
	private JTextField txt_port;//端口
	private JTextField txt_name;//昵称
	
	private JPanel northPanel;//北部的面板
	private JButton btn_start;//连接服务器按钮
	private JButton btn_stop;//断开按钮
	
	private JSplitPane centerSplit;//中间区域
	private JScrollPane rightScroll;//用户列表
	private DefaultListModel listModel;//用户列表组件
	private JList userList;//用户的实际列表数据对象
	
	//左侧的消息区域列表
	private JScrollPane leftScroll;
	//南部
	private JPanel southPanel;
	private JTextField txt_msg;
	private JButton btn_send;
	
	private Socket socket;
	
	private BufferedReader reader;
	private PrintWriter writer;
	
	public static void main(String [] args){
		new Client();
	}
	public Client(){
		frame = new JFrame("客户端");
		textArea = new JTextArea();
		textArea.setEditable(false);
		txt_port = new JTextField("8989");
		txt_host = new JTextField("127.0.0.1");
		txt_name = new JTextField("Jame");
		btn_start = new JButton("连接");
		btn_stop = new JButton("断开");
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 7));
		northPanel.add(new JLabel("服务器："));
		northPanel.add(txt_host);
		northPanel.add(new JLabel("端口："));
		northPanel.add(txt_port);
		northPanel.add(new JLabel("昵称："));
		northPanel.add(txt_name);
		northPanel.add(btn_start);
		northPanel.add(btn_stop);
		northPanel.setBorder(new TitledBorder("基本信息"));
		leftScroll = new JScrollPane(textArea);
		leftScroll.setBorder(new TitledBorder("消息区域"));
		rightScroll = new JScrollPane();
		rightScroll.setBorder(new TitledBorder("用户列表"));
		centerSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftScroll,rightScroll);
		centerSplit.setDividerLocation(400);
		txt_msg =new JTextField();
		btn_send = new JButton("发送消息");
		southPanel = new JPanel(new BorderLayout());
		southPanel.add(txt_msg,"Center");
		southPanel.add(btn_send,"East");
		southPanel.setBorder(new TitledBorder("发送区域"));
		frame.setLayout(new BorderLayout());
		frame.add(northPanel,"North");
		frame.add(centerSplit,"Center");
		frame.add(southPanel,"South");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
		btn_start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String host = txt_host.getText().trim();
				int port = Integer.valueOf(txt_port.getText().trim());
				String name = txt_name.getText().trim();
				frame.setTitle("聊天室");
				if(connectServer(host,port,name)){
					btn_start.setEnabled(false);
				}
				
			}
		});
		btn_send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				writer.println("ALL#【"+txt_name.getText()+"】："+txt_msg.getText().trim());
				writer.flush();
			}
		});
	}
	public boolean connectServer(String host,int port,String name){
		try{
			socket = new Socket(host,port);
			writer = new PrintWriter(socket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer.println(name);
			writer.flush();
			MessageThread ms = new MessageThread(reader, textArea);
			ms.start();
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
}
class MessageThread extends Thread{
	private BufferedReader reader;
	private JTextArea textArea;
	public MessageThread(BufferedReader reader,JTextArea textArea){
		this.reader = reader;
		this.textArea = textArea;
	}
	
	public void run(){
		try {
			while(true){
				
					String message = reader.readLine();
						textArea.append(message+"\r\n");
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
