/*************************************************
File: InfixEvaluator.java
By: Chan-Chun Yen
Date: 21 Feb
Usage: Java
System: Any
Description: Calculate in Infix
*************************************************/
package arraylistwithiterator;

import java.util.Stack;

public class InfixEvaluator 
{
    private static final String INFIX_EXPRESSION = "(a+b)*(c+d)";
    private static double a;
    private static double b;
    private static double c;
    private static double d;

    InfixEvaluator()
    {
        InfixEvaluator.a = 0;
        InfixEvaluator.b = 0;
        InfixEvaluator.c = 0;
        InfixEvaluator.d = 0;
    }

    InfixEvaluator(double a, double b, double c, double d)
    {
        InfixEvaluator.a = a;
        InfixEvaluator.b = b;
        InfixEvaluator.c = c;
        InfixEvaluator.d = d;
    }
    public static double evaluateInfix(String str) 
    {
        str = "(" + str + ")"; // Make sure equation is in the brackets
        char[] tokens = str.toCharArray(); // Turn string to char arry
        Stack<Character> operatorStack = new Stack<>();
        Stack<Double> valueStack = new Stack<>();

        double result = 0.0;
        char notation;

        for (int i = 0; i < tokens.length; i++) 
        {
            if (tokens[i] == '(') 
            {
                continue;
            } 
            else if (Character.isLetter(tokens[i])) // push the identifier to the valuestack
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
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') 
            // push notation to the operatorstack
            {
                operatorStack.push(tokens[i]);
            } 
            else if (tokens[i] == ')') // pop out operands and a operator to calcualte when detecting ) 
            {
                if (operatorStack.isEmpty()) 
                {
                    break;
                }
                notation = operatorStack.pop();
                double operand2 = valueStack.pop();
                double operand1 = valueStack.pop();
                switch (notation) 
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
                valueStack.push(result); // push result to the stack
            }
        }

        return valueStack.pop(); 
    }

    public static void printout() 
    {
        System.out.printf(INFIX_EXPRESSION);
    }
}
