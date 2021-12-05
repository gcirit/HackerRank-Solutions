package opsgenie;

import java.util.Scanner;
public class ReachTheEndInTimeRecursive {
    static int minTime;
    public static String reach(String arr[], int maxTime) {

        int n = arr.length;

        char a[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            a[i] = arr[i].toCharArray();
        }

        minTime = Integer.MAX_VALUE;

        reach(a, maxTime, 0, 0, new boolean[n][n], 0);

        if (minTime <= maxTime) {
            return "YES";
        } else {
            return "NO";
        }

    }

    public static void reach(char arr[][], int maxTime, int i, int j, boolean visited[][], int time) {

        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == '#' || visited[i][j] == true) {
            return;
        }

        if (i == arr.length - 1 && j == arr[0].length - 1) {
            minTime = Math.min(minTime, time);
            return;
        }

        visited[i][j] = true;

        reach(arr, maxTime, i - 1, j, visited, time + 1);
        reach(arr, maxTime, i, j - 1, visited, time + 1);
        reach(arr, maxTime, i + 1, j, visited, time + 1);
        reach(arr, maxTime, i, j + 1, visited, time + 1);

        visited[i][j] = false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        int time = sc.nextInt();

        System.out.println(reach(arr, time));
    }
}
