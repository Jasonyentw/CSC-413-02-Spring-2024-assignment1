package arraylistwithiterator;
import java.util.*;

import javax.xml.validation.Validator;

public class InfixEvalutor 
{
    private static final String INFIX_EXPRESSION = "(a+b)*(c+d)";
    public static double evaluateInfix(String str)
    {
        char[] tokens = str.toCharArray(); 
        MyLList operatorStack = new MyLList();
        MyLList valueStack = new MyLList();
        
        double Answer = 0.0;
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
                notation = (char) operatorStack.remove(operatorStack.getLength());
                switch (notation) 
                {
                    case '+':
                        Answer += (double)valueStack.remove(valueStack.getLength()) + (double)valueStack.remove(valueStack.getLength());
                        break;
                    case '-':
                        
                        break;
                    case '*':
                        
                        break;
                    case '/':
                        
                        break;
                    default:
                        break;
                }
            }
            
        }

        return Answer;
    }
    public static void printout()
    {
        System.out.println(INFIX_EXPRESSION);
    }
}