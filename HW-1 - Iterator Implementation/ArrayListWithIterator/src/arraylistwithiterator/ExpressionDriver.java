package arraylistwithiterator;

import java.util.Scanner;
import java.util.*;
/** 
   A driver that demonstrates the revised class ArrayListWithIterator.
 */
public class ExpressionDriver  
{
    public static void main (String args[]) 
    {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a list: ");

        ListWithIteratorInterface<String> myList = new MyLList<>();
        
        System.out.println("Testing add to end: Add A, B, C, D");
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");

        System.out.println("\nUsing ADT list operations hasNext and next:");

        displayList(myList);


        Iterator it = myList.getIterator();

        System.out.println("Execute the iterator's next() again:");
        try 
        {
            it.next();		   // Should throw an error
            System.out.println("Oops... No exception");
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("NoSuchElementException was thrown as expected!");
        } // end catch

        System.out.println("\nBegin iteration again:");
        it = myList.getIterator();
        System.out.println("next() returns " + it.next() + " (should be A)");

        System.out.println("remove() should remove A");
        it.remove();

        System.out.println("next() returns " + it.next() + " (should be B)");
        System.out.println("next() returns " + it.next() + " (should be C)");

        System.out.println("remove() should remove C");
        it.remove();
        System.out.println();

        System.out.println("List state after all adds and removes");
        displayList(myList);

        System.out.println("\nExecute the iterator's remove() again:");
        try 
        {
            it.remove();		   // Should throw an error
            System.out.println("Oops... No exception");
        } 
        catch (IllegalStateException e) 
        {
            System.out.println("IllegalStateException was thrown as expected!");
        } // end catch

        while (true) 
        {
            System.out.println("Enter values for identifiers (a, b, c, d): ");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            double d = scanner.nextDouble();

            InfixEvaluator infix = new InfixEvaluator(a, b, c, d);
            PostfixEvaluator postfix = new PostfixEvaluator(a, b, c, d);

            System.out.printf("Value of infix string (a+b)*(c+d) with a=%.2f, b=%.2f, c=%.2f, d=%.2f is %.2f%n",
            a, b, c, d, infix.evaluateInfix("(a+b)*(c+d)"));

            System.out.printf("Value of postfix string ac-b^d+ with a=%.2f, b=%.2f, c=%.2f, d=%.2f is %.2f%n",
            a, b, c, d, postfix.evaluatePostfix("ac-b^d+"));

            System.out.print("Do you want to continue? (yes/no): ");
            String userResponse = scanner.next().toLowerCase();

            if (userResponse.equals("no")) 
            {
                System.out.println("Program ended.");
                break;
            } 
            else if (!userResponse.equals("yes")) 
            {
                System.out.println("Invalid input. Program will continue.");
            }
        }

        scanner.close();
        
    } // end main

    public static void displayList(ListWithIteratorInterface<String> aList) 
    {

        System.out.println("The list contains " + aList.getLength() +
                            " string(s) running through iterator, as follows:");		

        Iterator it = aList.getIterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }  // end displayList

}  // end Driver