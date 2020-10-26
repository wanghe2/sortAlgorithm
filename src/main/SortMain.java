package main;
/**
 * 记录几种排序方式
 * @author wanghe
 *
 */
public class SortMain {

	private int[] datas= {1,4,2,12,9,10,4,64,23,43,21,5,21,73};
	
	public static void main(String[] args) {
		SortMain sortMain=new SortMain();
		sortMain.fun3();
		for(int i=0;i<sortMain.datas.length;i++) {
			System.err.println(sortMain.datas[i]);
		}
	}
	
	/**
	 * 直接排序 将未排序的数据插入至已排好序序列的合适位置  (平均复杂度为O(n²))
	 */
	public void fun1() {
		int temp;
		for (int i = 1; i < datas.length; i++) {
			temp = datas[i];//待插入数据
			int j;
			for(j = i - 1; j >= 0; j--) {
				//判断是否大于temp，大于则后移一位
				if(datas[j] > temp) {
					datas[j+1] = datas[j];
				}else{
					break;
				}
			}
			datas[j + 1] = temp;
		}
	}
	
	/**
	 * 希尔排序
	 */
	public void fun2() {
		int j = 0;
		int temp = 0;
		for (int increment = datas.length / 2; increment > 0; increment /= 2){
			for (int i = increment; i < datas.length; i++) {
				temp = datas[i];
				for (j = i - increment; j >= 0; j -= increment) {
					if (temp < datas[j]) {
						datas[j + increment] =datas[j];
					} else {
						break;
					}
	
				}
				datas[j + increment] = temp;
			}
		}
	}
	
	
	/**
	 * 
	 * 选择排序是一种简单直观的排序算法，
	 * 其基本原理如下：对于给定的一组记录，经过第一轮比较后得到最小的记录，
	 * 然后将该记录的位置与第一个记录的位置交换；接着对不包括第一个记录以外的其他记录进行第二次比较，
	 * 得到最小记录并与第二个位置记录交换；重复该过程，知道进行比较的记录只剩下一个为止。
	 * 
	 */
	
	
	
	/**
	 * 冒泡排序     总的平均时间复杂度为：O(n2) 
	 * 设排序表长为n，从后向前或者从前向后两两比较相邻元素的值，如果两者的相对次序不对(A[i-1]> A[i])，
	 * 则交换它们，其结果是将最小的元素交换到待排序序列的第一个位置，我们称它为一趟冒泡。
	 * 下一趟冒泡时，前一趟确定的最小元素不再参与比较，待排序序列减少一个元素，
	 * 每趟冒泡的结果把序列中最小的元素放到了序列的”最前面”。
	 */
	public void fun3() {
		for(int i=0;i<datas.length-1;i++) {
			for(int j=0;j<datas.length-i-1;j++) {
				if(datas[j]>datas[j+1]) {
					int temp=0;
					temp=datas[j+1];
					datas[j+1]=datas[j];
					datas[j]=temp;
				}
			}
		}
	}
	
	/**
	 * 快速排序是对冒泡排序的一种改进。
	 * 首先在数组中选择一个基准点，然后分别从数组的两端扫描数组，
	 * 设两个指示标志（lo指向起始位置，hi指向末尾)，首先从后半部分开始，
	 * 如果发现有元素比该基准点的值小，就交换lo和hi位置的值，然后从前半部分开始扫秒，
	 * 发现有元素大于基准点的值，就交换lo和hi位置的值，如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。
	 * 一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了
	 */
	/**

	 * 将数组的某一段元素进行划分，小的在左边，大的在右边

	 * @param data

	 * @param start

	 * @param end

	 * @return

	 
	 * @return */

	public static int divide(int[]data,int start,int end){

		//每次都以最右边的元素作为基准值

		int base = data[end];
		//start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。
		while(start < end){
			while(start < end &&data[start] <= base) {
				//从左边开始遍历，如果比基准值小，就继续向右走
				start++;
			}
			//上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
			if(start < end){
				//交换
				int temp = data[start];

				data[start] = data[end];

				data[end] = temp;

				//交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
				end--;
			}

			while(start < end &&data[end] >= base) {

				//从右边开始遍历，如果比基准值大，就继续向左走

				end--;

			}

			//上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换

			if(start < end){
				//交换

				int temp = data[start];

				data[start] = data[end];

				data[end] = temp;
				//交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
				start++;
			}
		}
		//这里返回start或者end皆可，此时的start和end都为基准值所在的位置
		return end;
	}

	/**

	 * 快速排序

	 * 时间复杂度：O（n^2）

	 * @param data

	 * @param start

	 * @param end

	 */

	public static void quickSort(int[] data, int start, int end){

		if(start > end){
			//如果只有一个元素，就不用再排下去了
			return;
		}else{
			//如果不止一个元素，继续划分两边递归排序下去
			int partition = divide(data, start,end);
			quickSort(data, start, partition-1);
			quickSort(data, partition+1,end);
		}
	}
}
