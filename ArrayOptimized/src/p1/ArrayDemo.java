package p1;

import java.util.*;

public class ArrayDemo {

	static int count = 0;
    public static int fourPointerSearch(int[] arr, int target) {
    	
    	
    	
        int start = 0;
        int end = arr.length - 1;
        int mid = arr.length / 2;
        int midLeft = mid - 1;
        int midRight = mid;

       
        while (start <= end && midLeft >= 0 && midRight < arr.length) {

        	count++;
        	
            // Check from start
            if (arr[start] == target) {
                return start;
            }

            // Check from end
            if (arr[end] == target) {
                return end;
            }

            // Check from mid going left
            if (arr[midLeft] == target) {
                return midLeft;
            }

            // Check from mid going right
            if (arr[midRight] == target) {
                return midRight;
            }

            // Move start to mid
            start++;
            // Move end to mid
            end--;
            // Move midLeft to midLeft - 1
            midLeft--;
            // Move midRight to midRight + 1
            midRight++;
        }

        return -1; // not found
    }

    public static void main(String[] args) {
       
    	 int size = 1000000;
         Integer[] tempArr = new Integer[size];

         // Fill with 1 to 1,000,000
         for (int i = 0; i < size; i++) {
             tempArr[i] = i + 1;
         }

         // Shuffle the array
         List<Integer> list = Arrays.asList(tempArr);
         Collections.shuffle(list);

         // Convert back to int[]
         int[] arr = new int[size];
         for (int i = 0; i < size; i++) {
             arr[i] = list.get(i);
         }
       System.out.println("Enter the Search Value : - ");
        int target = new Scanner(System.in).nextInt();
        
        long startTime = System.currentTimeMillis();
        int index = fourPointerSearch(arr, target);
        long endTime = System.currentTimeMillis();
        System.out.println("Operation Finish in : "+(endTime-startTime)+" millSec");
       
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
        
        System.out.println("And Total Iteration count Is :- "+count);
    }
}