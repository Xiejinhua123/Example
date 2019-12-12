package arithmetic.sort;

public class Common {
	
	public static int[] before = {500,966,125,147,159632,44,1,55,8,2,36,98,10,2,56,3,5,9,1,3,89,2,0};
	
	public static String toString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
