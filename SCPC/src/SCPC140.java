import java.io.*;
import java.util.*;

class SCPC140 {
    static String Answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            HashMap<Integer, ArrayList<Integer>> directedMap = new HashMap<>();
            ArrayList<ArrayList<Integer>> undirectedEdges = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                StringTokenizer stk2 = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(stk2.nextToken()) - 1;
                int dst = Integer.parseInt(stk2.nextToken()) - 1;
                ArrayList<Integer> value = directedMap.getOrDefault(src, new ArrayList<>());
                value.add(dst);
                directedMap.put(src, value);
            }

            for (int i = 0; i < k; i++) {
                StringTokenizer stk2 = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(stk2.nextToken()) - 1;
                int dst = Integer.parseInt(stk2.nextToken()) - 1;
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(src);
                pair.add(dst);
                undirectedEdges.add(pair);
            }

            for (int i = 0; i < k; i++) {
                int src = undirectedEdges.get(i).get(0);
                int dst = undirectedEdges.get(i).get(1);
                ArrayList<Integer> value = directedMap.getOrDefault(src, new ArrayList<>());
                value.add(dst);
                directedMap.put(src, value);
                if (isCycle(src, n, directedMap)) {
                    ArrayList<Integer> tempList = directedMap.get(src);
                    tempList.remove(tempList.size() - 1);

                    ArrayList<Integer> updatedValue = directedMap.getOrDefault(dst, new ArrayList<>());
                    updatedValue.add(src);
                    directedMap.put(dst, updatedValue);

                    sb.append("1");
                } else
                    sb.append("0");
            }

            Answer = sb.toString();

            bw.write("Case #" + (test_case + 1) + "\n");
            bw.write(Answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isCycle(int src, int n, HashMap<Integer, ArrayList<Integer>> directedMap) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        stack.add(src);
        while (stack.size() > 0) {
            int node = stack.pop();

            if (visited[node]) {
                if (node == src)
                    return true;
                else
                    continue;
            }

            visited[node] = true;

            if (directedMap.getOrDefault(node, new ArrayList<>()).size() > 0)
                stack.addAll(directedMap.get(node));
        }
        return false;
    }
}
