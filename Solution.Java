import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
        private final static int wall = -1;

    public static int solution(int start, int length) {
        //Your code goes here.
        return getCheckSum(start,length);
        // return 14 ;
    }
        private static int getCheckSum(int start, int length) {
        int[][] matrix = populateMatrix(start, length);
        int[] list = getChecksumNumber(matrix,length);
        return getXOR(list);
    }
    
        private static int getXOR(int[] list) {
        int xor = 0;
        for (int l : list) {
            xor = xor ^ l;
        }
        return xor;
    }
    
    private static int[] getChecksumNumber(int[][] matrix, int length) {
        int[] list = new int[getFactorial(length)];
        // List<Integer> list = new ArrayList<>();
        int position =0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length + 1; j++) {
                if(matrix[i][j]==wall)
                    break;
                // list.add(matrix[i][j]);
                list[position++] = matrix[i][j];
            }

        }
        //   return toArray(list);
           return list;
    }

    private static int[] toArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        int p = 0;
        for (int v :
                list) {
            arr[p++] = v;
        }
        return arr;
    }
    
        private static int[][] populateMatrix(int start, int length) {
        int wallPosition = length ;
        int values = start;
        int[][] matrix = new int[length][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length + 1; j++) {
                if (j == wallPosition) {
                    matrix[i][j] = wall;
                    wallPosition--;
                }
                else
                    matrix[i][j] = values++;
            }
        }
        return matrix;
    }
    
    
       private static int getFactorial(int length) {
        if(length == 0)
            return 0;
        return  length + getFactorial(length-1);
    }
}
