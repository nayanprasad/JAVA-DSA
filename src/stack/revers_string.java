package stack;

import java.util.Scanner;
import java.util.*;

public class revers_string {

    public class stack{
        int top;
        char arr[]=new char[100];

        stack(){
            top = -1;
        }

        public void push(char c){
            arr[++top] = c;
        }

        public boolean isEmpty(){
            return  top == -1;
        }
        public char pop(){
            return arr[top--];
        }
    }

    String revers(String s){
        stack st = new stack();
        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
        }
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            char ch = st.pop();
            ans += ch;
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a string : ");
        String s = sc.nextLine();
        revers_string obj = new revers_string();
        System.out.println("revers : " + obj.revers(s));
    }
}
