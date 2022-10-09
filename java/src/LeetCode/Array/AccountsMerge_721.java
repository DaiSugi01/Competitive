package LeetCode.Array;

import java.util.*;

public class AccountsMerge_721 {
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();

    /*
        Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        {
            "johnsmith@mail.com": ["john_newyork@mail.com", "john00@mail.com"]
            "john_newyork@mail.com": ["johnsmith@mail.com"]
            "john00@mail.com" ["johnsmith@mail.com"]
            "mary@mail.com": []
            "johnnybravo@mail.com": []
        }

        ["John",johnsmith@mail.com, john_newyork@mail.com, john00@mail.com]

        visited: {
            johnsmith@mail.com: true,
            john_newyork@mail.com: true,
            john00@mail.com: true
        }
     */
    public static void main(String[] args) {
        AccountsMerge_721 sol = new AccountsMerge_721();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        List<List<String>> res = sol.accountsMerge(accounts);
        for (List<String> r : res) {
            System.out.println(r);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        for (List<String> account : accountList) {
            String firstEmailAddress = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String emailAddress = account.get(i);
                if (!adjacent.containsKey(firstEmailAddress))
                    adjacent.put(firstEmailAddress, new ArrayList<>());
                adjacent.get(firstEmailAddress).add(emailAddress);


                if (!adjacent.containsKey(emailAddress))
                    adjacent.put(emailAddress, new ArrayList<>());
                adjacent.get(emailAddress).add(firstEmailAddress);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accountList) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            if (!visited.contains(firstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(name);
                dfs(firstEmail, mergedAccount);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }

    private void dfs(String email, List<String> mergedAccount) {
        visited.add(email);
        mergedAccount.add(email);

        if (!adjacent.containsKey(email))
            return;

        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor))
                dfs(neighbor, mergedAccount);
        }
    }
}
