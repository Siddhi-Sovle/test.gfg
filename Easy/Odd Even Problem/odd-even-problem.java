//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        int arr[] = new int[26];
        Arrays.fill(arr,0);
        for(char c:s.toCharArray())
        {
            arr[c-'a']++;
        }
        int sum = 0;
        for(int i = 0;i<26;i++)
        {
            if(arr[i]!=0)
            {
                if(i%2 == 0 && arr[i]%2!=0)
                sum++;
                else if(i%2 != 0 && arr[i]%2==0)
                sum++;
            }
        }
        if(sum%2==0)
        return "EVEN";
        else
        return "ODD";
    }
}