package hackerrank.graph;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class EvenTree {
    // https://www.hackerrank.com/challenges/even-tree/problem

    public static void main(String[] args) {
        String data = "10 9\n" +
                      "2 1\n" +
                      "3 1\n" +
                      "4 3\n" +
                      "5 2\n" +
                      "6 1\n" +
                      "7 2\n" +
                      "8 6\n" +
                      "9 8\n" +
                      "10 8";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Scanner sc = new Scanner(System.in);
        System.setIn(stdin);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n + 1][n + 1];
        boolean visited[][] = new boolean[n + 1][n + 1];
        boolean test[] = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int count;
        HashMap hm[] = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) hm[i] = new HashMap();

        //FOR LOOP 1: For Storing value of each dfs in hashmap and if odd nodes edge is only 1 cases true
        for (int i = 1; i <= n; i++) {
            dfs(i, n, arr, hm[i], visited[i]);
            count = 0;

            for (int j = 1; j <= n; j++)
                if (arr[i][j] == 1 && (int) (hm[i].get(j)) % 2 == 1)
                    count++;
            if (count == 1)
                test[i] = true;
        }

        //FOR LOOP 2: for each passing test convert the even node edge as -1
        for (int i = 1; i <= n; i++) {
            if (test[i]) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] == 1 && (int) (hm[i].get(j)) % 2 == 0) {
                        arr[i][j] = -1;
                        arr[j][i] = -1;
                    }
                }

            }
        }

        // Count all -1 and divide by 2
        int countt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                if (arr[i][j] == -1)
                    countt++;
        }

        System.out.println(countt / 2);
        sc.close();
    }


    public static int dfs(int node, int n, int g[][], HashMap hm, boolean visited[]) {
        int c = 1;
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && g[node][i] == 1)
                c += dfs(i, n, g, hm, visited);
        }
        hm.put(node, c);
        return c;
    }

}
