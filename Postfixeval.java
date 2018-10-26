/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixeval;

import java.util.Stack;
import java.util.Scanner;
public class Postfixeval {

    public static double eval(String s){
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                char num = s.charAt(i);
                stack.push((double)num-48);
            }else{
                if(s.charAt(i)=='*'){
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    double toStack = num1 * num2;
                    stack.push(toStack);
                }
                if(s.charAt(i)=='/'){
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    double toStack = num2 / num1;
                    stack.push(toStack);
                }
                if(s.charAt(i)=='+'){
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    double toStack = num1 + num2;
                    stack.push(toStack);
                }
                if(s.charAt(i)=='-'){
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    double toStack = num2 - num1;
                    stack.push(toStack);
                }
            }    
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter a postfix expression as a string with no spaces");
        String exp = in.next();
        System.out.println(eval(exp));
    }
    
}
