package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiejinhua.example.entity.LotteryData;
import com.xiejinhua.example.util.HttpClientUtil;

public class Main {
	private static List<JSONObject> jsons = new ArrayList<>();

	private static native void registerNatives();

	public static void main(String[] args) throws Exception {
		

		File file = new File("D:\\a.txt");
		// String str = JSON.toJSONString(map);

		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fileWriter);
for (int i = 445; i < 50000; i++) {
	String str = HttpClientUtil.httpGet("http://10.0.56.207:" + i);
	if (str != null)
		bw.write(i + "----" + str);
		}
		bw.close();
		fileWriter.close();
	
		
		System.out.println(  );
		
//		testHttpDingDing();
//		ClassLoader
	}
	
	public static void test2() throws IOException, InterruptedException {
		File file = new File("D:\\a.txt");
		String line = null;
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			String res = HttpClientUtil.httpGet("http://127.0.0.1:8080/inventory/retry?id=" + line);
			System.out.println(res + "----------- " + line);
		}
		fileReader.close();
		br.close();
	}
	
	public static void test3() throws IOException, InterruptedException {
		File file = new File("D:\\b.txt");
		String line = null;
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			String res = HttpClientUtil.httpGet("http://127.0.0.1:8080/inventory/retry?id=" + line);
			System.out.println(res + "----------- " + line);
		}
		fileReader.close();
		br.close();
	}
	
	public static void test4() throws IOException, InterruptedException {
		File file = new File("D:\\c.txt");
		String line = null;
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			String res = HttpClientUtil.httpGet("http://127.0.0.1:8080/inventory/retry?id=" + line);
			System.out.println(res + "----------- " + line);
		}
		fileReader.close();
		br.close();
	}

	public static void test1() throws IOException {
		File file = new File("D:\\a.html");
		StringBuilder sb = FileUtil.readFile(file);
		String str = sb.toString();
		String[] strs = str.split("<tr");

		List<LotteryData> jsons = new LinkedList<>();
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			if (s == null || s.length() <= 0)
				continue;
			String[] ss = s.split("<td");
			LotteryData data = new LotteryData();
			for (int j = 2; j < 10; j++) {
				String sj = ss[j].replaceFirst("</td", "").replaceAll("class=\"t_cfont2\">", "")
						.replaceAll("class=\"t_cfont4\">", "").replaceAll(" ", "");
				String[] sjs = sj.split(">");
				for (int k = 1; k < sjs.length; k++) {
					data.setId(sjs[k]);
					System.out.println(k + " k " + sjs[k]);
				}
				System.out.println(j + "  " + ss[j]);
				Integer tmp = null;
				try {
					tmp = Integer.valueOf(sjs[0]);
				} catch (Exception e) {
					continue;
				}
				if (tmp != null)
					switch (j) {
					case 3:
						data.setB1(tmp);
						break;
					case 4:
						data.setB2(tmp);
						break;
					case 5:
						data.setB3(tmp);
						break;
					case 6:
						data.setB4(tmp);
						break;
					case 7:
						data.setB5(tmp);
						break;
					case 8:
						data.setB6(tmp);
						break;
					case 9:
						data.setR1(tmp);
						break;
					}
			}
			System.out.println(JSON.toJSONString(data));
		}
	}

	public static void testHttpDingDing() {
		// 文档地址 https://open-doc.dingtalk.com/microapp/serverapi2/qf2nxq
		String url = "https://oapi.dingtalk.com/robot/send?access_token=48d56384fe3578aece678a54180fb5a05197fefa61534ece4f154da120bc94e3";
		String res = HttpClientUtil.httpJSONPost(url, "{\"msgtype\":\"text\", \"text\":{\"content\":\"测试消息\n测试数据\"}}");
		System.out.println(res);
	}

	// public static void testDingDing() throws ApiException {
	// // DingTalkClient client = new DefaultDingTalkClient(
	// //
	// "https://oapi.dingtalk.com/robot/send?access_token=48d56384fe3578aece678a54180fb5a05197fefa61534ece4f154da120bc94e3");
	// // OapiRobotSendRequest request = new OapiRobotSendRequest();
	//// request.setMsgtype("text");
	//// OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
	//// text.setContent("测试文本消息");
	//// request.setText(text);
	//// OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
	//// at.setAtMobiles(Arrays.asList("13261303345"));
	//// request.setAt(at);
	//
	// request.setMsgtype("link");
	// OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
	// link.setMessageUrl("https://www.baidu.com/");
	// link.setPicUrl("");
	// link.setTitle("时代的火车向前开");
	// link.setText("这个即将发布的新版本，创始人陈航（花名“无招”）称它为“红树林”。\n" +
	// "而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是“红树林");
	// request.setLink(link);
	// OapiRobotSendResponse response = client.execute(request);
	//
	//// request.setMsgtype("markdown");
	//// OapiRobotSendRequest.Markdown markdown = new
	// OapiRobotSendRequest.Markdown();
	//// markdown.setTitle("杭州天气");
	//// markdown.setText("#### 杭州天气 @156xxxx8827\n" + ">
	// 9度，西北风1级，空气良89，相对温度73%\n\n"
	//// + ">
	// ![screenshot](https://gw.alipayobjects.com/zos/skylark-tools/public/files/84111bbeba74743d2771ed4f062d1f25.png)\n"
	//// + "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
	//// request.setMarkdown(markdown);
	//// OapiRobotSendResponse response = client.execute(request);
	// }

	public static void testMsg() throws IOException {
		// map.put("a", 2);
		// map.put("b", 2);
		// System.out.println(JSON.toJSONString(map));

		String filepath = "D:\\json";
		readFile(filepath);
		JSONArray array = new JSONArray();
		for (JSONObject json : jsons) {
			array.addAll(json.getJSONArray("sheet"));
		}
		StringBuilder sb = new StringBuilder();
		for (Object object : array) {
			JSONObject json = JSONObject.parseObject(object.toString());
			// String key = json.getString("companyCode") + " - " +
			// json.getString("subjectCode");
			// if ( map.containsKey(key) ) {
			// map.put(key, map.get(key)+1);
			// }else {
			// map.put(key, 1);
			// }
			sb.append("SELECT t.company_code, t.subject_code FROM fam_corporate_accounting t WHERE t.company_code = '"
					+ json.getString("companyCode") + "' AND t.subject_code = '" + json.getString("subjectCode")
					+ "' union all \n");
		}
		writeFile(sb.toString());
	}

	public static void writeFile(String str) throws IOException {
		File file = new File("D:\\a.txt");
		// String str = JSON.toJSONString(map);

		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fileWriter);

		bw.write(str);
		bw.close();
		fileWriter.close();
	}

	public static boolean readFile(String filepath) throws FileNotFoundException, IOException {
		File file = new File(filepath);
		if (file.isDirectory()) {
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				File readfile = new File(filepath + "\\" + filelist[i]);
				if (!readfile.isDirectory()) {
					StringBuilder sb = readFile(readfile);
					JSONObject json = JSONObject.parseObject(sb.toString());
					jsons.add(json);
				} else if (readfile.isDirectory()) {
					readFile(filepath + "\\" + filelist[i]);
				}
			}
		}
		return true;
	}

	public static StringBuilder readFile(File file) throws IOException {
		String line = null;
		StringBuilder sb = new StringBuilder();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		fileReader.close();
		br.close();
		return sb;
	}
}