import java.util.Scanner;

public class Day_Eleven
{

    public static int getMaxHourGlass(int[][] arr){
        int length = (arr.length - 2) * (arr.length - 2);
        int[] arrOfSums = new int[length];
        int index = 0;

        for (int row = 1; row < arr.length - 1; row++){
            for (int col = 1; col < arr.length - 1; col++){
                arrOfSums[index] = sumOfHourGlass(row, col, arr);
                index++;
            }
        }
        int maxSum = arrOfSums[0];
        for (int i = 0; i < arrOfSums.length; i++){
            if (maxSum < arrOfSums[i]){
                maxSum = arrOfSums[i];
            }
        }
        return maxSum;
    }

    public static int sumOfHourGlass(int r, int c, int[][] arr){
        int sum = arr[r][c] + arr[r - 1][c] + arr[r - 1][c - 1] + arr[r - 1][c + 1] +
                arr[r + 1][c] + arr[r + 1][c - 1] + arr[r + 1][c + 1];
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the desired length of your array: ");
        int length = in.nextInt();
        int arr[][] = new int[length][length];
        for(int i=0; i < length; i++){
            for(int j=0; j < length; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int maxHourGlass = getMaxHourGlass(arr);
        System.out.println(maxHourGlass);
    }
}