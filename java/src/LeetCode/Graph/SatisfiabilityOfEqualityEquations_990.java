package LeetCode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SatisfiabilityOfEqualityEquations_990 {
    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations_990 sol = new SatisfiabilityOfEqualityEquations_990();
        System.out.println(sol.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
    }

    /*
        create map from "==" equations
        {
            a: [b],
            b: [c],
            e: [f]
        }

        for (int i...26) (a to z)
            int[] 26 represents relation between chars
            [0,0,0,3,4,4,5,6,..25]

        check "!=" operation
        loop through given equations array
            if "!="
                if  0 == 0  --> a and b are equal.

     */
    public boolean equationsPossible(String[] equations) {
        List<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            graph[i] = new ArrayList<>();

        for (String e : equations) {
            if (e.charAt(1) == '=') {
                int u = e.charAt(0) - 'a';
                int v = e.charAt(3) - 'a';
                graph[u].add(v);
                graph[v].add(u);
            }
        }

        int[] colors = new int[26];
        Arrays.fill(colors, -1);
        for (int i = 0; i < 26; i++) {
            if (colors[i] == -1)
                dfs(i, i, colors, graph);
        }


        for (String e : equations) {
            if (e.charAt(1) == '!') {
                int u = e.charAt(0) - 'a';
                int v = e.charAt(3) - 'a';
                if (colors[u] == colors[v]) return false;
            }
        }
        return true;
    }

    private void dfs(int u, int c, int[] colors, List<Integer>[] graph) {
        if (colors[u] == -1) {

            colors[u] = c;
            for (int v : graph[u])
                dfs(v, c, colors, graph);
        }
    }
}
