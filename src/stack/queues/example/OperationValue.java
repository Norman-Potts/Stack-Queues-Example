package stack.queues.example;

 
/** Class OperationValue
 *      OperationValue has two private attributes. They are the operation char
 *      -  + / * and the value, a number. Methods get operation returns the 
 *      operation char, and get value returns the value double. The toString 
 *      method is overridden to return the string like "[-,8]" or "[*,3.42]".
 *    
 *   
 * @author Norman
 */
public class OperationValue {
    
    private char operation;
    private double value;
    
    
    /** OperationValue
     *      Sets the operation, and value private variables.
     * @param operation
     * @param value 
     */
    public OperationValue(char operation, double value)
    {
        this.operation = operation;
        this.value = value;
    }
    
    // Returns the operation.
    public char  getOperation() { return operation; }
    
    // Returns the value.
    public double getValue() { return value; }
        
    
    /** Override toString
     *      Displays the string like "[-,8]" or "[*,3.42]".
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        return  "["+operation+", "+value+"]";
    }    
    
}/// End of class OperationValue
