package com.xiejinhua.example.main;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import com.xiejinhua.example.entity.MyHashMap;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.xiejinhua.example.test.Test;
import com.xiejinhua.example.util.HttpClientUtil;
import com.xiejinhua.example.util.Util;

/**
 * 
 * @author Administrator
 *
 */
public class Main {

	static ExecutorService pool = Executors.newFixedThreadPool(1000);
	@SuppressWarnings("rawtypes")
	static List<Future> futures = new LinkedList<Future>();

	public static void main(String[] args) {
		portTest();
	}

	static void testBc() {
		int blue = 33;
		int red = 16;
		Set<LinkedList<Integer>> results = new  HashSet<LinkedList<Integer>>(); 
		for ( int b1 = 1; b1 <= blue; b1++ )
			for ( int b2 = 1; b2 <= blue; b2++ )
				for ( int b3 = 1; b3 <= blue; b3++ )
					for ( int b4 = 1; b4 <= blue; b4++ )
						for ( int b5 = 1; b5 <= blue; b5++ )
							for ( int b6 = 1; b6 <= blue; b6++ ) {
								Set<Integer> result = new  HashSet<Integer>();
								result.add(b1);
								result.add(b2);
								result.add(b3);
								result.add(b4);
								result.add(b5);
								result.add(b6);
								if (result.size() != 6)
									continue;
								for (int r = 1; r <= red; r++) {
									LinkedList<Integer> result1 = new LinkedList<>(result);
									result1.add(r);
//									System.out.println(result1.toString());
									results.add(result1);
								}
							}
		System.out.println(results.size());
		
	}
	
	static void testIP() {
		try {
			 System.out.println( InetAddress.getLocalHost() );
			boolean status = InetAddress.getByName("192.168.52.118").isReachable(800);
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testHashMap() {
		
		MyHashMap<String, String> map = new MyHashMap<String , String>();
		map.put("1", "a");
		map.put("2", "a");
		map.put("3", "a");
		map.put("4", "a");
		map.put("5", "a");
		map.put("6", "a");
		map.put("7", "a");
		map.put("8", "a");
		map.put("9", "a");
		map.put("10", "a");
		map.put("11", "a");
		map.put("12", "a");
		map.put("13", "a");
		
	}
	
	static void testThreadPool() {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
		pool.submit(()->{
			
		});
	}
	
	static void testProxy() {
		int size = 5000;
		for (int i = 0; i < size; i++) {
			pool.submit(() -> {
				HttpClientUtil.httpGet("http://127.0.0.1:8080/v1/testProxy?queryCode=20000016&queryMerchants=1&shopId=1&serialid=10");
			});
		}
	}
	
	static void testThread() {

		int a = 0;
		int size = 50;
		for (int i = 0; i < size; i++) {
			futures.add(pool.submit(() -> {
				// HttpClientUtil.httpGet("http://127.0.0.1:8188/example/test/testThread");
				System.out.println("shutcown前当前线程：" + Thread.currentThread().getName());
				return "a" + a;
			}));
		}
		// pool.shutdown();
		long time = System.currentTimeMillis();
		futures.forEach(f -> {
			while (!f.isDone()) {
			}
			try {
				System.out.println(f.get().toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < size; i++) {
			pool.submit(new Runnable() {
				@Override
				public void run() {
					// HttpClientUtil.httpGet("http://127.0.0.1:8188/example/test/testThread");
					System.out.println("shutcown后当前线程：" + Thread.currentThread().getName());
				}
			});
		}
		long time1 = System.currentTimeMillis();
		System.out.println("最终耗时：" + (time1 - time));

	}

	static void portTest() {
		try {
			int size = 99999;
			for (int i = 0; i < size; i++) {
				final Integer ii = i;
				pool.submit(new Runnable() {
					@Override
					public void run() {
						String str = HttpClientUtil.httpGet("http://192.168.1.3:" + ii, 300);
						if (str != null) {
							Util.write(ii + " \t " + str);
						}
					}
				});
			}
		} catch (Exception e) {
		}
		pool.shutdown();
	}

	static void testZookeeper() {
		Long start = System.currentTimeMillis();
		int size = 50;
		for (int i = 0; i < size; i++) {
			String str = HttpClientUtil.httpGet("http://127.0.0.1:8001/test");
			System.out.println(str);
		}
		System.out.println("最终执行耗时：" + (System.currentTimeMillis() - start));
	}

	static void testClassLoad() {
		Test test = new Test();
		test.print();
		Test test1 = new Test();
		test1.print();
	}

	static void u8Rdrecord08Save(WebService1Soap wss) {
		// 118302
		String jSon = "{\"CVOUCHCODE\": \"INV_IN-181101-1139\", \"DDATE\": \"2018-11-01\",\"CSTORENAME\": \"999\",\"CMAKER\": \"管理员\",\"ITAXRATE\": \"16\",\"CWHCODE\": \"02\",\"CMEMO\": \"\",\"DETAILList\": [{\"CINVCODE\": \"118103\",\"CBATCH\": \"\",\"ITAXRATE\": 16,\"DMADEDATE\": \"2018-11-01\",\"IAMOUNT\": \"0\",\"IQUANTITY\": 4}]}";
		System.out.println(jSon);
		System.out.println(wss.u8Rdrecord08Save(jSon));
	}

	static void u8Rdrecord09Save(WebService1Soap wss) {
		String jSon = "{\"CVOUCHCODE\": \"INV_OUT-181101-2556\",\"DDATE\": \"2018-11-01\",\"CSTORENAME\": \"999\",\"ITAXRATE\": \"16\",\"CWHCODE\": \"02\",\"CMAKER\": \"管理员\",\"CMEMO\": \"\",\"DETAILList\": [{\"CINVCODE\": \"117101\",\"IQUANTITY\": 1,\"CBATCH\": \"\",\"DMADEDATE\": \"2016-11-05\",\"ITAXRATE\": \"16\",\"IAMOUNT\": 0}]}";
		System.out.println(jSon);
		System.out.println(wss.u8Rdrecord09Save(jSon));
	}

	static void u8TransVouchSave(WebService1Soap wss) {
		String jSon = "{\"CVOUCHCODE\":\"DBO-181105-0460\",\"DDATE\":\"2018-11-05\",\"CSTORENAME\":\"999\",\"COWHCODE\":\"02\",\"CIWHCODE\":\"03\",\"CMAKER\":\"管理员\",\"CMEMO\":\"\",\"DETAILList\":[{\"CINVCODE\":\"118211\",\"IQUANTITY\":1,\"CBATCH\":\"20181105\",\"CMADEDATE\":\"2018-11-05\"}]}";
		System.out.println(jSon);
		System.out.println(wss.u8TransVouchSave(jSon));
	}

	static void u8GatheringSave(WebService1Soap wss) {
		// {"CVOUCHCODE":"180427-16289","CSTORENAME":"999","DDATE":"2018-04-27","CSSCODE":"04","CDEPCODE":"7242","CCODE":"100204","CEXCH_NAME":"人民币","IEXCHRATE":"1","IAMOUNT_F":48720,"IAMOUNT":48720,"CMAKER":"程西平","CMEMO":"收4.27汇款48720元","DETAILList":[{"CDEPCODE":"7242","CCODE":"11220101","IAMOUNT_F":48720,"IAMOUNT":48720}]}
		String jSon = "{\"CVOUCHCODE\":\"181105-16345\",\"CSTORENAME\":\"999\",\"DDATE\":\"2018-11-05\",\"CSSCODE\":\"05\",\"CCUSCODE\":\"41010021\",\"CDEPCODE\":\"2211\",\"CCODE\":\"1001\",\"CEXCH_NAME\":\"人民币\",\"IEXCHRATE\":\"1\",\"IAMOUNT_F\":563.23,\"IAMOUNT\":563.23,\"CMAKER\":\"管理员\",\"CMEMO\":\"暂无描述\",\"DETAILList\":[{\"CCUSCODE\":\"41010021\",\"CDEPCODE\":\"2211\",\"CCODE\":\"117104\",\"IAMOUNT_F\":563.23,\"IAMOUNT\":563.23}]}";
		System.out.println(jSon);
		System.out.println(wss.u8GatheringSave(jSon));
	}
}
