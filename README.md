# Princeton-Algorithm-from-Robert-Sedgewick
learning algorithm from Robert Sedgewick

# Lesson 1st Union-Find

1. dynamic connectivity
2. quick find
3. quick union
4. improvements
5. applications

-- Subtext of the lecture --
- Steps to developing a usable algorithm.
  - Model the problem.
  - Find an algorithm to solve it.
  - Fast enough? Fits in memory?
  - If not, figure out why.
  - Find a way to address the problem.
  - Iterate until satisfied.
  
- The scientific method.

- Mathematical analysis.

# Lesson 2nd Bags, Queues, and Stacks

1. stacks
2. resizing arrays
3. queues
4. generics
5. iterators
6. applications

- stack
  - void push(String item)
  - String pop()
  - boolean isEmpty()
  
##  stack implementations: resizing array vs. linked list

- Tradeoffs. Can implement a stack with either resizing array or linked list;
client can use interchangeably. Which one is better?

Linked-list implementation.
  - Every operation takes constant time in the worst case.
  - Uses extra time and space to deal with the links.
  
Resizing-array implementation.
  - Every operation takes constant amortized time.
  - Less wasted space.
  
- queue
  - void enqueue(String item)
  - String dequeue()
  - boolean isEmpty()
  
- bag
  - void add(Item x)
  - int size()
  - Iterable<Item> iterator()
  
# Lesson 3rd Algorithm Analysis

1. mathematical models
2. order-of-growth classifications
3. theory of algorithms
4. memory

the mostly common running time:
1, log N, N, NlogN, N^2, N^3, and 2^N

binary Search implement in Java - Arrays.binarySearch

## Theory of algorithms

1. Goals.
- Establish "difficulty" of a problem.
- Develop "optimal" algorithms

2. Approach.
- Suppress details in analysis: analyze "to within a constant factor".
- Eliminate variability in input model by focusing on the worst case.

3. Optimal algorithm.
- Performance guarantee (to within a constant factor) for any input.
- No algorithm can provide a better performance guarantee.

example: Three-sum problem

## Algorithm design approach

Start.
- Develop an algorithm
- Prove a lower bound.

Gap?
- Lower the upper bound (discover a new algorithm).
- Raise the lower bound (more difficult).

Golden Age of Algorithm Design.
- 1970s-.
- Steadily decreasing upper bounds for many important problems.
- Many known optimal algorithms.

Caveats.
- Overly pessimistic to focus on worst case?
- Need better than "to within a constant factor" to predict performance.

## Memory

typical memory usage for objects in Java

1. Object overhead: 16bytes
2. Reference: 8bytes
3. Padding: Each object uses a multiple of 8 bytes.

- Primitive type: 4 bytes for int, 8 bytes for double, ...
- Object reference: 8 bytes.
- Array: 24 bytes + memory for each array entry.
- Object: 16 bytes + memory for each instance variable + 8 if
- inner class (for pointer to enclosing class).
- Padding: round up to multiple of 8 bytes.

Shallow memory usage: Don't count referenced objects.

Deep memory usage: If array entry or instance variable is a reference,
add memory (recursively) for referenced object.

Turning the crank: summary
________________________________

1.Empirical analysis.
2.Mathematical analysis.
3.Scientific method.