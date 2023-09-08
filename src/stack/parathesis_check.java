package stack;

import java.util.Scanner;

public class parathesis_check {

    static public class stack{
        int top;
        char arr[] = new char[100];
        stack(){
            top = -1;
        }
        void push(char ch){
            arr[++top] = ch;
        }
        boolean isEmpty(){
            return top == -1;
        }
        char pop(){
            return arr[top--];
        }
    }

    static boolean isBracketsBalanced(String expr){

        stack stack = new stack();

        for (int i = 0; i < expr.length(); i++){
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String arge[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a string : ");
        String s = sc.nextLine();
        System.out.println(isBracketsBalanced(s));
    }
}

