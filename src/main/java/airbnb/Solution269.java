package airbnb;

import java.util.*;

public class Solution269 {

    /**
     * 直觉和算法
     *
     * 首先，为单词中出现过的每个字母建立一个标识等级的map。
     *
     * 然后，通过比较相邻的单词，建立一个key为字母，value为比key小的字母组成的set列表组成的hashmap。
     *
     * 最终的标识等级的hashMap表示有多少字母位于key前面。
     *
     * 最后使用Kahn's algorithm做一下拓扑排序。
     *
     * 时间复杂度：O(W * N)
     * 空间复杂度：O(W+ N)
     *
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }

    public static void main(String[] args) {
        Solution269 solution269 = new Solution269();
        String[] words1 = {
            "wrt",
            "wrf",
            "er",
            "ett",
            "rftt"
        };
        System.out.println(solution269.alienOrder(words1));
        String[] words2 = {
            "z",
            "x"
        };
        System.out.println(solution269.alienOrder(words2));
        String[] words3 = {
            "z",
            "x",
            "z"
        };
        System.out.println(solution269.alienOrder(words3));
    }
}
