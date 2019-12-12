package arithmetic.sort;

import java.util.ArrayList;

/**
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 
 * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 
 * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排
 * 
 * @author Administrator
 *
 */
public class BucketSort {
	public static void main(String[] args) {
		System.out.println(Common.toString(Common.before));
		int[] after = BucketSort.bucketSort(Common.before, Common.before.length);
		System.out.println(Common.toString(after));
	}

	/**
	 * 人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
	 * 
	 * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
	 * 
	 * 对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
	 * 
	 * 从不是空的桶里把排好序的数据拼接起来。
	 * 
	 * @param array
	 * @param bucketSize
	 * @return
	 */
	/**
	 * 桶排序
	 * 
	 * @param array
	 * @param bucketSize
	 * @return
	 */
	public static int[] bucketSort(int[] arrays, int bucketSize) {
		if (arrays == null || arrays.length < 2)
			return arrays;
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int a : arrays)
			array.add(a);

		int max = array.get(0), min = array.get(0);
		// 找到最大值最小值
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) > max)
				max = array.get(i);
			if (array.get(i) < min)
				min = array.get(i);
		}
		int bucketCount = (max - min) / bucketSize + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
		ArrayList<Integer> resultArr = new ArrayList<>();
		for (int i = 0; i < bucketCount; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < array.size(); i++) {
			bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
		}
		for (int i = 0; i < bucketCount; i++) {
			if (bucketSize == 1) { // 如果带排序数组中有重复数字时 感谢 @见风任然是风 朋友指出错误
				for (int j = 0; j < bucketArr.get(i).size(); j++)
					resultArr.add(bucketArr.get(i).get(j));
			} else {
				if (bucketCount == 1)
					bucketSize--;
				int[] result = new int[bucketArr.get(i).size()];
				for (int j = 0; j < bucketArr.get(i).size(); j++)
					result[j] = bucketArr.get(i).get(j);
				int[] temp = bucketSort(result, bucketSize);
				for (int j = 0; j < temp.length; j++)
					resultArr.add(temp[j]);
			}
		}
		int[] result = new int[resultArr.size()];
		for (int i = 0; i < resultArr.size(); i++)
			result[i] = resultArr.get(i);
		return result;
	}
}
