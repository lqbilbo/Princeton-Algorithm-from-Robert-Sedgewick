package leetcode;

import java.util.*;

public class Solution582 {

    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        findChild(pid, ppid, kill);
        return new ArrayList<>(new HashSet<>(ans));
    }

    public static void findChild(List<Integer> pid, List<Integer> ppid, int kill) {
        // 1. find in parent
        int child = 0;
        for (int i=0; i<ppid.size(); i++) {
            if (ppid.get(i) == kill) {
                child = pid.get(i);
                ans.add(kill);
                findChild(pid, ppid, child);
            }
        }
        // 2. find in child
        if (child == 0) {
            for (int i=0; i<pid.size(); i++) {
                if (pid.get(i) == kill) {
                    ans.add(kill);
                    return;
                }
            }
        }
    }

    /**
     * HashMap + Breadth First Search
     * Time complexity : O(n). We need to traverse over the ppid array of size nn once. Also, at most n
     * additions/removals are done from the queue.
     *
     * Space complexity : O(n). map of size n is used.
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public static List<Integer> killProcessWithBFS(List <Integer> pid, List <Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List < Integer > l = map.getOrDefault(ppid.get(i), new ArrayList<>());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int r = queue.remove();
            l.add(r);
            if (map.containsKey(r))
                for (int id: map.get(r))
                    queue.add(id);
        }
        return l;
    }

    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1,2,3,4,5);
        List<Integer> ppid = Arrays.asList(0,1,1,1,1);
        int kill = 1;
        System.out.println(killProcessWithBFS(pid, ppid, kill));
    }
}
