package com.s2p.practice.leetcode.problems._00700_00800.accountsMerge;

import java.util.*;

/**
 * https://leetcode.com/problems/accounts-merge/
 * 721. Accounts Merge
 * Note : leetcode Solution
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /*
         [["","",""],["John","",""],["Mary",""],["John","johnnybravo@mail.com"]]
         */
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        input.add(Arrays.asList("John", "john00@mail.com"));
        input.add(Arrays.asList("Mary", "mary@mail.com"));
        input.add(Arrays.asList("John", "johnnybravo@mail.com"));
        input.add(Arrays.asList("John", "john00@mail.com", "johnsmith@mail.com"));

        List<List<String>> result = new Solution().accountsMerge(input);
        System.out.println(result);
    }
}
