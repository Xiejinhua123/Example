package arithmetic.sort;

/**
 * 插入排序 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
 *
 * 唯一的好处可能就是不占用额外的内存空间了吧。
 *
 * 理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
 *
 * @author Administrator
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		System.out.println(Common.toString(Common.before));
		int[] after = InsertionSort.insertionSort(Common.before);
		System.out.println(Common.toString(after));
	}

	/**
	 * 从第一个元素开始，该元素可以认为已经被排序；
	 * 
	 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
	 * 
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
	 * 
	 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
	 * 
	 * 将新元素插入到该位置后；
	 * 
	 * 重复步骤2~5
	 * @param arr
	 * @return
	 */
	public static int[] insertionSort(int[] arr) {
		int len = arr.length;
		int preIndex, current;
		for (int i = 1; i < len; i++) {
			preIndex = i - 1;
			current = arr[i];
			while (preIndex >= 0 && arr[preIndex] > current) {
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex + 1] = current;
		}
		return arr;
	}

}
