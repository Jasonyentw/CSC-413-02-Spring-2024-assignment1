package arraylistwithiterator;
import java.util.*;


public class InfixEvalutor 
{
    private static final String INFIX_EXPRESSION = "(a+b)*(c+d)";
    public static double evaluateInfix(String str)
    {
        str = "(" + str + ")";
        char[] tokens = str.toCharArray(); 
        MyLList operatorStack = new MyLList();
        MyLList valueStack = new MyLList();
        
        double Value = 0.0;
        char notation;
        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i] == '(')
            {
                continue;
            }
            else if(Character.isDigit(tokens[i]))
            {
                double digitValue = Character.getNumericValue(tokens[i]);
                valueStack.add(digitValue);
            }
            else if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
            {
                operatorStack.add(tokens[i]);
            }
            else if(tokens[i] == ')')
            {
                if(operatorStack.isEmpty())
                    break;
                notation = (char) operatorStack.remove(operatorStack.getLength());
                double operand2 = (double) valueStack.remove(valueStack.getLength());
                double operand1 = (double) valueStack.remove(valueStack.getLength());
                switch (notation) 
                {
                    case '+':
                        Value = operand1 + operand2;
                        break;
                    case '-':
                        Value = operand1 - operand2;
                        break;
                    case '*':
                        Value = operand1 * operand2;
                        break;
                    case '/':
                        Value = operand1 / operand2;
                        break;
                    default:
                        break;
                }
                valueStack.add(Value);
            }
            
        }

        return (double) valueStack.remove(valueStack.getLength());
    }
    public static void printout()
    {
        System.out.printf(INFIX_EXPRESSION);
    }
}