package opsgenie;

// Java program to implement above approach
public class MatrixTraverse {

    static int n = 3;

    // 2d array to store
    // states of dp
    static int dp[][] = new int[n][n];

    // array to determine whether
    // a state has been solved before
    static int[][] v = new int[n][n];

    // Function to find the minimum number of
    // steps to reach the end of matrix
    static int minSteps(int i, int j, int arr[][])
    {
        // base cases
        if (i == n - 1 && j == n - 1) {
            return 0;
        }

        if (i > n - 1 || j > n - 1) {
            return 9999999;
        }

        // if a state has been solved before
        // it won't be evaluated again.
        if (v[i][j] == 1) {
            return dp[i][j];
        }

        v[i][j] = 1;

        // recurrence relation
        dp[i][j] = 1 + Math.min(minSteps(i + arr[i][j], j, arr), minSteps(i, j + arr[i][j], arr));

        return dp[i][j];
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[][] = { { 2, 1, 2 },
                { 1, 1, 1 },
                { 1, 1, 1 } };

        int ans = minSteps(0, 0, arr);
        if (ans >= 9999999) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
    }
}
