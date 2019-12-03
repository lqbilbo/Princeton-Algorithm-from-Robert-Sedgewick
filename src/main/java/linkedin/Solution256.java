package linkedin;

import java.util.ArrayList;
import java.util.List;

public class Solution256 {
    public int minCost(int[][] costs) {
        List<Integer> ansArr = new ArrayList<>();
        int adjacentIndex = -1;
        for (int i=0; i<costs.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j=0; j<3; j++) {
                if (costs[i][j] < min && j != adjacentIndex) {
                    min = costs[i][j];
                    adjacentIndex = j;
                }
            }
            ansArr.add(min);
        }
        int ans = 0;
        for (int min : ansArr) {
            ans += min;
        }
        return ans;
    }

    /**
     * Compare the minimum values of the adjacent bits in all the upper rows of each row
     */
    class Solution {
        public int minCost(int[][] costs) {
            if(costs==null||costs.length==0){
                return 0;
            }
            for(int i=1; i<costs.length; i++){
                costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
                costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
                costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
            }
            int n = costs.length-1;
            return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
        }
    }
}
