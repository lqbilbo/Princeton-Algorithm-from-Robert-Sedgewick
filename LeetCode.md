| # | Title | Solution | Approach |
|---| ----- | -------- | -------- |
| 1 | Two Sum | [Java](./src/main/java/leetcode/Solution1.java)
| 2 | add two numbers | [Java](./src/main/java/leetcode/Solution2.java)
| 4 | find median sorted arrays | [Java](./src/main/java/leetcode/Solution4.java)
| 5 | longest palindrme substring | [Java](./src/main/java/leetcode/Solution5.java)
| 103 | Tree Zigzag Level Order Traversal | [Java](./src/main/java/leetcode/Solution103.java)
| 127 | word ladder I | [Java](./src/main/java/leetcode/Solution127.java)
| 138 | deep copy LinkedList node with random pointer | [Java](./src/main/java/leetcode/Solution138.java)
| 200 | Number of Islands | [Java](./src/main/java/leetcode/Solution200.java)
| 238 | Product of Array Except Self | [Java](./src/main/java/leetcode/Solution238.java)
| 240 | Search Matrix | [Java](./src/main/java/leetcode/Solution240.java)
| 253 | Min MeetingRooms | [Java](./src/main/java/leetcode/Solution253.java)
| 341 | Flatten Nested List Iterator | [Java](./src/main/java/leetcode/Solution341.java)
| 692 | Top K Frequent Words | [Java](./src/main/java/leetcode/Solution692.java)
| 937 | Reorder Data in Log Files | [Java](./src/main/java/leetcode/Solution937.java)
| 957 | prison After N Days | [Java](./src/main/java/leetcode/Solution957.java)
| 973 | K Closest Points to Origin | [Java](./src/main/java/leetcode/Solution973.java)
| 994 | Rotting Oranges | [Java](./src/main/java/leetcode/Solution994.java) | We can use a breadth-first search to model this process. Because we always explore nodes (oranges) with the smallest depth first, we're guaranteed that each orange that becomes rotten does so with the lowest possible depth number. We should also check that at the end, there are no fresh oranges left.Complexity Analysis. Time Complexity: O(N)O(N), where NN is the number of cells in the grid. Space Complexity: O(N)O(N).