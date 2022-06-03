import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class RadixSort2 {
	public static void radixSortAscending(int[] values) {
		int radix = 10;
		Deque<Integer>[] bucket = new ArrayDeque[radix];
		
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayDeque<Integer>();
		}
		
		boolean maxLength = false;
		int aux = -1;
		int digitPlacement = 1;
		while(!maxLength) {
			maxLength = true;
			// split per bucket
			for(Integer i : values) {
				aux = i / digitPlacement;
				bucket[aux % radix].add(i);
				if (maxLength == true && aux > 0) {
					maxLength = false;
				}
			}		
			// empty the buckets into the input array
			int contor = 0;
			for (int bucketNo = 0; bucketNo < radix; bucketNo++) {
				for (Integer item : bucket[bucketNo]) {
					values[contor++] = item;
				}
				bucket[bucketNo].clear();
			}			
			digitPlacement *= radix;
		}		
	}
	
	public static void radixSortDescending(int[] values) {
		int radix = 10;
		Deque<Integer>[] bucket = new ArrayDeque[radix];
		
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayDeque<Integer>();
		}
		
		boolean maxLength = false;
		int aux = -1;
		int digitPlacement = 1;
		while(!maxLength) {
			maxLength = true;
			
			for(Integer i : values) {
				aux = i / digitPlacement;
				bucket[aux % radix].add(i);
				if (maxLength == true && aux > 0) {
					maxLength = false;
				}
			}
			
			int contor = 0;
			for (int bucketNo = 9; bucketNo >= 0; bucketNo--) {
				for (Integer item : bucket[bucketNo]) {
					values[contor++] = item;
				}
				bucket[bucketNo].clear();
			}			
			digitPlacement *= radix;
		}		
	}
	
	public static void main(String[] args) {
		int[] values = {1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713};
		radixSortAscending(values);
		System.out.println(Arrays.toString(values));	
		radixSortDescending(values);
		System.out.println(Arrays.toString(values));
		
	}
}
