| # | Title | Solution | Approach |
|---| ----- | -------- | -------- |
| 1 | Two Sum | [Java](./src/main/java/leetcode/Solution1.java)
| 2 | add two numbers | [Java](./src/main/java/leetcode/Solution2.java)
| 4 | find median sorted arrays | [Java](./src/main/java/leetcode/Solution4.java)
| 5 | longest palindrme substring | [Java](./src/main/java/leetcode/Solution5.java)
| 53 | Maximum Subarray | [Java](./src/main/java/leetcode/Solution53.java) | The algorithm is general and straightforward: iterate over the array and update at each step the standard set for such problems:current element.current local maximum sum (at this given point).global maximum sum seen so far.
| 103 | Tree Zigzag Level Order Traversal | [Java](./src/main/java/leetcode/Solution103.java)
| 121 | Best Time to Buy and Sell Stock  | [Java](./src/main/java/leetcode/Solution121.java) | The points of interest are the peaks and valleys in the given graph. We need to find the largest peak following the smallest valley. We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
| 127 | word ladder I | [Java](./src/main/java/leetcode/Solution127.java)
| 138 | deep copy LinkedList node with random pointer | [Java](./src/main/java/leetcode/Solution138.java)
| 152 | Maximum Product Subarray | [Java](./src/main/java/leetcode/Solution152.java)
| 200 | Number of Islands | [Java](./src/main/java/leetcode/Solution200.java)
| 238 | Product of Array Except Self | [Java](./src/main/java/leetcode/Solution238.java)
| 240 | Search Matrix | [Java](./src/main/java/leetcode/Solution240.java)
| 253 | Min MeetingRooms | [Java](./src/main/java/leetcode/Solution253.java)
| 341 | Flatten Nested List Iterator | [Java](./src/main/java/leetcode/Solution341.java)
| 692 | Top K Frequent Words | [Java](./src/main/java/leetcode/Solution692.java)
| 713 | Subarray Product Less Than K | [Java](./src/main/java/leetcode/Solution713.java) | For each right, call opt(right) the smallest left so that the product of the subarray nums[left] * nums[left + 1] * ... * nums[right] is less than k. opt is a monotone increasing function, so we can use a sliding window.
| 937 | Reorder Data in Log Files | [Java](./src/main/java/leetcode/Solution937.java)
| 957 | prison After N Days | [Java](./src/main/java/leetcode/Solution957.java)
| 973 | K Closest Points to Origin | [Java](./src/main/java/leetcode/Solution973.java)
| 994 | Rotting Oranges | [Java](./src/main/java/leetcode/Solution994.java) | We can use a breadth-first search to model this process. Because we always explore nodes (oranges) with the smallest depth first, we're guaranteed that each orange that becomes rotten does so with the lowest possible depth number. We should also check that at the end, there are no fresh oranges left.Complexity Analysis. Time Complexity: O(N)O(N), where NN is the number of cells in the grid. Space Complexity: O(N)O(N).