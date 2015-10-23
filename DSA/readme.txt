Module         		: Advance-Data Structures
Assignment for Session	: DSA-Session1
Author			: Rohit

----------------------------------------------------------------
1. Implement generalized list collection in Java. An element of a generalized list can itself be a 
   generalized list. Here is an example of a generalized list­ 
 
   (5, (8, 3), (6, (10, 12), 4), 7) 
 
   The above list consists of four elements, the first and last elements are numbers, whereas 
   second and third elements are themselves lists.  
 
   You can assume that the atomic elements of the list are integers. 
 
   Implement the following methods for this collection: 
 
   a) Constructor to create an empty list. 
   b) Constructor that will take a string representing a generalized list; and will create the list 
      accordingly. For example we can provide “(5, (8, 3), (6, (10, 12), 4), 7)” as an argument to the 
      constructor. 
   c) Method toString() that will return a string representing the generalized list. 
   d) Method sum() that will return the sum of all the elements in the list 
   e) Method max() that will return the largest value in the list 
   f) Method find(x) that will search for x in the list; and return true if x is present in the list and false 
      otherwise. 

2. Write a Java program that will take a boolean expression in infix form as an input, and will 
   display the truth table for that boolean expression. For parsing you can assume that­  
 
   a) variables in boolean expression are single character long    
   b) there are no white spaces in the expression 
   c) expression is made of only three types of operators and(&), or (|) and not (~)    
   d) precedence of operators is as follows­ not (~) > and (&) > or (|) 
   e)  and (&) associates from left to right, or (|) associates from left to right, not (~) associates 
      from right to left 
   f) expression may have parentheses  

3. NxN sliding puzzle has N?^2 ?­ 1 blocks with numbers from 1 to N?^2 ?­ 1 on them. One of the slots in 
   the NxN puzzle is empty. The blocks adjacent to the empty slot can be swapped with the empty 
   slot, by moving a block horizontally or vertically. 



