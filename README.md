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
