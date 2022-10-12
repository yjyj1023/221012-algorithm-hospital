import java.util.Scanner;

public class codeup4596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //113,23,85,34,17,74,25,52,65
        //10,7,39,42,88,52,14,72,63
        //87,42,18,78,53,45,18,84,53
        //34,28,64,85,12,16,75,36,55
        //21,77,45,35,28,75,90,76,1
        //25,87,65,15,28,11,37,28,74
        //65,27,75,41,7,89,78,64,39
        //47,47,70,45,23,65,3,41,44
        //87,13,82,38,31,12,29,29,80

        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = arr[0][0];
        int index_row = 1;
        int index_col = 1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    index_row = i + 1;
                    index_col = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.printf("%d %d", index_row, index_col);
    }
}
