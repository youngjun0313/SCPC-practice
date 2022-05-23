import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Scanner;

public class SCPC138 {
    static int Answer;
    public static void main(String[] args) throws Exception	{
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            Answer=0;
            int n = sc.nextInt();
            int[] nums = new int[n];
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                nums[i]=sc.nextInt();
            }

            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    int pivot = i;
                    boolean check=true;
                    visited[i]=true;
                    while(pivot<n) {
                        if(pivot+nums[pivot] >= n)
                            break;
                        if(visited[pivot+nums[pivot]])
                            check = false;
                        visited[pivot+nums[pivot]] = true;
                        pivot+=nums[pivot];
                    }
                    if(check)
                        Answer++;
                }
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
