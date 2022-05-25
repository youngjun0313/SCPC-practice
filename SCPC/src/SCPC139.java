import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class SCPC139 {
    static String Answer;

    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());
            int[] bits = new int[n];
            int[] tempAns = new int[n];
            String num = br.readLine();
            for (int i = 0; i < n; i++) {
                bits[i] = Integer.parseInt(String.valueOf(num.toCharArray()[i]));
            }

            boolean[] must_zero = new boolean[n];

            for (int i = 0; i < n; i++) {
                if(i-t>=0 && bits[i-t]==0)
                    must_zero[i] = true;
                if(i+t<n && bits[i+t]==0)
                    must_zero[i] = true;
            }

            for (int i = 0; i < n; i++) {
                if(bits[i]==0) {
                    if(i+t<n)
                        tempAns[i+t]=0;
                    if(i-t>=0)
                        tempAns[i-t]=0;
                } else {
                    if(i-t>=0 && tempAns[i-t]==1)
                        continue;
                    else if(i+t<n && !must_zero[i+t])
                        tempAns[i+t]=1;
                    else
                        tempAns[i-t]=1;
                }
            }

            Answer="";
            for (int i = 0; i < n; i++) {
                Answer += tempAns[i];
            }

            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}