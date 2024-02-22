/*************************************************
File: PostfixEvaluator.java
By: Chan-Chun Yen
Date: 21 Feb
Usage: Java
System: Any
Description: Calculate in Postfix
*************************************************/
package arraylistwithiterator;

import java.util.Stack;

public class PostfixEvaluator 
{
    private static final String POSTFIX_EXPRESSION = "ac-b^d+";
    private static double a;
    private static double b;
    private static double c;
    private static double d;

    PostfixEvaluator()
    {
        PostfixEvaluator.a = 0;
        PostfixEvaluator.b = 0;
        PostfixEvaluator.c = 0;
        PostfixEvaluator.d = 0;
    }

    PostfixEvaluator(double a, double b, double c, double d)
    {
        PostfixEvaluator.a = a;
        PostfixEvaluator.b = b;
        PostfixEvaluator.c = c;
        PostfixEvaluator.d = d;
    }

    public static double evaluatePostfix(String str)
    {
        char[] tokens = str.toCharArray(); // Turn string to char arry
        Stack<Double> valueStack = new Stack<>();

        for (int i = 0; i < tokens.length; i++)
        {
            if(Character.isLetter(tokens[i])) // push the identifier to the valuestack
            {
                switch (tokens[i]) 
                {
                    case 'a':
                        valueStack.add(a);
                        break;
                    case 'b':
                        valueStack.add(b);
                        break;
                    case 'c':
                        valueStack.add(c);
                        break;
                    case 'd':
                        valueStack.add(d);
                        break;
                    default:
                        break;
                }
            }
            else if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^') 
            // calculate when happen to the notation
            {
                double result = 0.0;
                double operand2 = valueStack.pop();
                double operand1 = valueStack.pop();
                switch (tokens[i]) 
                {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    case '^':
                        result = Math.pow(operand1, operand2);
                    default:
                        break;
                }
                valueStack.add(result); // push result to the stack
            }
        }

        return valueStack.pop();
    }

    public static void printout() 
    {
        System.out.printf(POSTFIX_EXPRESSION);
    }
}
