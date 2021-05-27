#Stack Queues Example


This program allows the user to build a mathematical operation by accepting the operations as input. 
The program will calculates the current value based on the operation given.
For example the program starts at 0.00, when the user enters +32, the current value becomes 32.00.
If the user then were to type -2, the current value becomes 30.00. 
If the user then were to type /3,  the current value becomes 10.00. 
 
The program can accept five different commands. They are X, C, D, U, R.  

X - Exit ends the program.

C - Clear clears the operation.

D - Display prints out the operation deque.

U - Undo removes the last item in operation.

R - Redo redoes the last item undone.   
   
 
 
 
 
 
 The operations are stored in a deque. The undo command removes the last operation from the deque and
 places it on top of the undo stack. The redo command takes the command at the top of the undo stack and 
 places it back into the deque.
 
