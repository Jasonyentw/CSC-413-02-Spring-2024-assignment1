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
        String notation;
        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i] == '(')
            {
                continue;
            }
            else if(Character.isDigit(tokens[i]))
            {
                char[] charArray = { tokens[i] };
                valueStack.add(charArray);
            }
            else if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
            {
                char[] charArray = { tokens[i] };
                valueStack.add(charArray);
            }
            else if(tokens[i] == ')')
            {
                notation = operatorStack.remove();
            }
            
        }

        return 0.0;
    }
    public static void printout()
    {
        System.out.println(INFIX_EXPRESSION);
    }
}