import java.util.*;

public class Sorting {

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Bubble Sort
	private static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i ++) {
			for(int j = 0; j < arr.length - 1; j ++) {
				if(arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	// Selection Sort
	private static void selectionSort(int[] arr) {
		for(int k = 0; k < arr.length - 1; k ++) {
			int minIndex = k;
			for(int i = k + 1; i < arr.length; i ++) {
				if(arr[i] < arr[minIndex]) {
					minIndex = i;
				}
			}
			swap(arr, k, minIndex);
		}
	}

	// Insertion Sort
	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i ++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
		}
	}

	// Merge Sort
	private static void mergeSort(int[] arr, int left, int right) {
		if(left == right) {
			return;
		}

		int mid = (int) Math.floor((left + right) / 2);

		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		
		merge(arr, left, mid, right);
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int n1 = (mid - left) + 1;
		int n2 = right - mid;

		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];

		for(int i = 0; i < n1; i ++) {
			leftArr[i] = arr[left + i]; 
		}

		for(int i = 0; i < n2; i ++) {
			rightArr[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0, k = left;

		while(i < n1 && j < n2) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i ++;
				k ++;
			}
			else if(leftArr[i] > rightArr[j]) {
				arr[k] = rightArr[j];
				j ++;
				k ++;
			}	
		}

		while(i < n1) {
			arr[k] = leftArr[i];
			i ++;
			k ++;
		}

		while(j < n2) {
			arr[k] = rightArr[j];
			j ++;
			k ++;
		}
	}

	// Quick Sort
	private static void quickSort(int[] arr, int left, int right) {
		if(left >= right) {
			return;
		}

		int pivot = partition(arr, left, right);
		
		quickSort(arr, left, pivot - 1);
		quickSort(arr, pivot + 1, right);
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for(int j = left; j < right; j ++) {
			if(arr[j] < pivot) {
				i ++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i + 1, right);
		
		return i + 1;
	}

	// Driver
	public static void main(String[] args) {
		int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		bubbleSort(arr);
		selectionSort(arr);
		insertionSort(arr);
		mergeSort(arr, 0, arr.length - 1);
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));
	}
} 