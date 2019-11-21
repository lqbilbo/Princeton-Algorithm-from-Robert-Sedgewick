# Solution1 Two Sum

# Solution2 add two numbers

# Solution4 find median sorted arrays

# Solution5 longest palindrme substring

# Binary Tree Zigzag Level Order Traversal

# Solution138 deep copy LinkedList node with random pointer

# Solution200 Number of Islands

# Solution937 Reorder Data in Log Files

# Solution957 prison After N Days

# Solution973 K Closest Points to Origin

# Solution103 zigzagLevelOrder

# Solution127 word ladder I

# Solution240 Search Matrix

# Solution253 Min MeetingRooms 

# Solution238 Product of Array Except Self

# Solution341 Flatten Nested List Iterator    

# Solution692 Top K Frequent Words 

# Solution994 Rotting Oranges
We can use a breadth-first search to model this process. Because we always explore nodes (oranges) with the smallest 
depth first, we're guaranteed that each orange that becomes rotten does so with the lowest possible depth number.
We should also check that at the end, there are no fresh oranges left.
Complexity Analysis
Time Complexity: O(N)O(N), where NN is the number of cells in the grid.
Space Complexity: O(N)O(N).
