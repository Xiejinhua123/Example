package design_pattern;

public class SingletonClass {

	public static boolean flag = true;

	private SingletonClass() {
//		synchronized (SingletonClass.class) {
//			if (flag == false) {
//				flag = !flag;
//			} else {
//				throw new RuntimeException("单例模式被侵犯！");
//			}
//		}
	}

	private static class SingletonHolder {
		// jvm保证在任何线程访问INSTANCE静态变量之前一定先创建了此实例
	}
	private static final SingletonClass INSTANCE = new SingletonClass();

	public static SingletonClass getInstance() {
		return INSTANCE;
	}

	public void doSomethingElse() {

	}

}
