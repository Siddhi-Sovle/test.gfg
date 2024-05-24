//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution{
    public static int[][] dp;
    public static int mod;
    public static int dfs(int index, int sum, int[] arr){
        if(index>=arr.length){
            return sum==0?1:0;
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum];
        }
        int ways = dfs(index+1,sum,arr);
        if(sum-arr[index]>=0){
            ways = (ways%mod+dfs(index+1, sum-arr[index],arr)%mod)%mod;
        }
        return dp[index][sum] = ways%mod;
    }
    
    public static int countPartitions(int n, int d, int[] arr){
        int sum=0;
        mod = (int)(1e9 + 7);
        for(int num:arr){
            sum+=num;
        }
        int maxi = d+sum;
        if(maxi%2!=0){
            return 0;
        }
        dp = new int[n][(maxi/2)+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, (maxi/2),arr);
    }
}