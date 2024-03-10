package BinarySearch;

import java.util.ArrayList;

public class BookAllocation {
	public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
		int start = 0, end = 0, ans = -1;
		
		for(int elem: arr){
			end += elem;    
		}
		
		// start is the minimum possible answer and end is the maximum possible answer
		
		while(start <= end){
			int mid = start + (end - start) / 2;
			
			if(isPossible(arr, n , m, mid)){
				ans = mid; // possible answer
				end = mid - 1;
			} else{
				start = mid + 1;
			}
		}
		
		return ans;
	}
	
	public static boolean isPossible(ArrayList<Integer> arr, int n, int m, int mid){
		int studentsCount = 1; // initially starting from 1
		int pagesCount = 0; // initially a student will start by having no page
		
		for(int elem: arr){
			if(pagesCount + elem <= mid){
				pagesCount += elem;
			} else{
				studentsCount ++;
				
				if(studentsCount > m || elem > mid){
					return false;
				}
				
				pagesCount = elem;
			}
		}
		
		return true;
	}

	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(allocateBooks(list, 5, 3));
	}
}
