
package stack.queues.example;
/**
 *  StackQueuesExample
 *  
 *  This program allows the user to build a mathematical operation by accepting the operations as input. 
 *  The program will calculates the current value based on the operation given.
 *  For example the program starts at 0.00, when the user enters +32, the current value becomes 32.00.
 *  If the user then were to type -2, the current value becomes 30.00. 
 *  If the user then were to type /3,  the current value becomes 10.00. 
 * 
 * The program can accept five different commands. They are X, C, D, U, R.  
 * X - Exit ends the program.
 * C - Clear clears the operation.
 * D - Display prints out the operation deque.
 * U - Undo removes the last item in operation.  removes the last item in operation. deque and places it in the undo stack.
 * R - Redo redoes the last item undone.  at the top of the undo stack and places it in operation deque.
 *   
 * 
 * 
 * The operations are stored in a deque. The undo command removes the last operation from the deque and
 * places it on top of the undo stack. The redo command takes the command at the top of the undo stack and 
 * places it back into the deque.
 * 
 * 
 * 
 */


import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Norman
 */
public class StackQueuesExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        char inputchar; 
        double inputDouble;
        
        double total = 0;              
        Stack<OperationValue> undo = new Stack<OperationValue>();
        ArrayDeque<OperationValue> operationList = new ArrayDeque<OperationValue>();        
        Scanner input = new Scanner( System.in);                       
        char End = 'a';
        while(End != 'x' )
        {
            try
            {                          
                System.out.printf("The Current Value is %.2f \n", total); 
                System.out.printf("Enter Operation and value (i.e. \"+ 4.2\" ) \n (E[X]it, [C]lear, [D]isplay [U]ndo, [R]edo ):");            
                input.reset();                              
                String line = input.nextLine();                               
                line = line.replaceAll(" ", "");
                char[] arrChar = line.toCharArray();
                inputchar = arrChar[0];
                        
                boolean orderflag = false;
                if( inputchar == 'x' || inputchar == 'X')
                {   // End the program.
                    End = 'x';
                    orderflag = true;
                }
                if (inputchar == 'c' || inputchar == 'C')
                {   // Clear the operationList. 
                    operationList.clear();         
                    undo.clear();
                    orderflag = true;
                }                               
                if (inputchar == 'd' || inputchar == 'D')
                {
                    System.out.println("ArrayDeque operationList");                     
                    for(int i = 0; i < operationList.size(); i++)
                    {   //Display  the stack.
                        OperationValue item = operationList.pop();
                        System.out.printf(" "+ item.toString() +" \n" );                       
                        operationList.addLast(item);
                        
                    }                                                                                                                   
                    orderflag = true;
                    System.out.println("");                        
                }               
                if (inputchar == 'u' || inputchar == 'U')
                {   // Clear the operationList.                     
                    if(!operationList.isEmpty()){
                        OperationValue popped =  operationList.removeLast();
                        System.out.println(" UNDO: "+ popped);
                        undo.add(popped);
                        orderflag = true;
                    }
                }               
                if (inputchar == 'r' || inputchar == 'R')
                {   // Clear the operationList.                     
                    if(!undo.empty()){
                        OperationValue popped =  undo.pop();
                        operationList.add(popped);
                        System.out.println(" Redo: "+ popped);
                        orderflag = false;
                    }
                }               
                
                if (orderflag == false)
                {
                    if(inputchar == '+' || inputchar == '-' || inputchar == '*' || inputchar == '/')
                    {
                        String pat = "[0-9\\.]+";
                        Pattern pattern = Pattern.compile(pat);                        
                        String number = "";
                        for(int c = 1; c < arrChar.length; c++)
                        {   
                            String item = ""+arrChar[c]+"";
                            Matcher matcher = pattern.matcher(item);                            
                            
                            if ( matcher.matches())
                            {
                                number += item;
                            }                                                        
                        }
                        System.out.println(" number: "+number);                        
                        inputDouble = Double.parseDouble(number);                        
                        OperationValue OpInput = new OperationValue(inputchar, inputDouble);
                        operationList.add(OpInput);                                   
                    }
                    else 
                    {
                        System.err.println("Error: Input is inncorrect.");
                    }
                }                                
                total = calculator(operationList);               
                
            }
            catch (Exception e )
            {
                System.err.println("ERROR.");                        
            }                                  
        }                  
    }/// End of method main
    
    
    
    
    /** Method calculator
     *  Uses the ArrayDeque to calculate a value. The ArrayDeque operationList
     *  contains values and mathematical operations. For each item in the Deque
     *  Execute it's operation and it's value with the CalvulatorValue.
     * 
     * @param operationList
     * @return 
     */
    public static double calculator(ArrayDeque<OperationValue> operationList){                                       
        double CalculatorValue = 0.00;        
        for(OperationValue item : operationList)
        {   
            if(item.getOperation() == '+')
            {
                CalculatorValue= CalculatorValue + item.getValue();                
            }
            else if( item.getOperation() == '-')
            {
                 CalculatorValue= CalculatorValue - item.getValue();
            }
            else if (item.getOperation() == '*')
            {
                CalculatorValue = CalculatorValue * item.getValue();                
            }    
            else if (item.getOperation() == '/')
            {
                CalculatorValue= CalculatorValue / item.getValue();
            }                 
        }                                
        return CalculatorValue;        
    }/// End of method calculator
    
    
}/// End of class Main


