package stack;

import java.util.Scanner;
import java.util.*;

public class palindrom_check {

    static public class stack{
        int top;
        char arr[] = new char[100];
        stack(){
            top = -1;
        }
        void push(char ch){
            arr[++top] = ch;
        }
        char pop(){
            return arr[top--];
        }
    }

    static boolean isPalindrome(String s){
        stack st = new stack();
        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
        }
        for(int i = 0; i < s.length(); i++){
            char ch = st.pop();
            if(ch != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a string : ");
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
    }
}
