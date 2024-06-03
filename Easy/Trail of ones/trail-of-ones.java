//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int MOD = 1000000007;

    static int numberOfConsecutiveOnes(int n) {
        if (n == 2) {
            return 1; // Special case for n = 2
        }

        long[] dp = new long[n + 1];
        dp[1] = 2; // "0" and "1"
        dp[2] = 3; // "00", "01", and "10"

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        long total = modExp(2, n, MOD);

        long result = (total - dp[n] + MOD) % MOD;
        return (int) result;
    }

    static long modExp(long base, int exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

}


