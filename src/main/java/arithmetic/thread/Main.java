package arithmetic.thread;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		TestLock test = new TestLock();
		new Thread(()-> {
			while(true)
				test.a();
		}).start();
		
		new Thread(()-> {
			while(true)
				test.b();
		}).start();
	}
}

class TestLock {

	public void a() {
		synchronized (this) {
			System.out.println("a");
			try {
				Thread.sleep(1000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void b() {
		System.out.println("b");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

enum Singleton {
	RED;

	private String a;

	public List<String> getString() {
		return new ArrayList<String>();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
}