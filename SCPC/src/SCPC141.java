import java.io.*;
import java.util.*;

class SCPC141 {
    static int Answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            ArrayList<Integer> minMax = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer stk2 = new StringTokenizer(br.readLine());
                int size = Integer.parseInt(stk2.nextToken());
                ArrayList<Integer> stressList = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    stressList.add(Integer.parseInt(stk2.nextToken()));
                }
                Collections.sort(stressList);
                if (size % 2 == 1)
                    Answer += stressList.get(0) * 2 + stressList.get(1);
                else
                    Answer += stressList.get(0) + stressList.get(1);

                minMax.add(stressList.get(2) + stressList.get(3));
            }

            for (int i = 0; i < n - 2; i++) {
                Answer += minMax.get(i);
            }

            System.out.println(minMax);

            bw.write("Case #" + (test_case + 1) + "\n");
            bw.write(Answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
