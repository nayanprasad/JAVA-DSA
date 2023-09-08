package stack;
import  java.util.*;

public class infixTOpostfix {


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
        public char peek(){
            return arr[top];
        }
        public void display(){
            for(int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

   public String iTOp(String s){

        String ans = "";
        stack st = new stack();

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                ans += ch;
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while (!st.isEmpty() && st.peek() != '('){
                    ans += st.pop();

                }
                st.pop();  // remove (
            }
            else {
                while(!st.isEmpty() && Prec(ch) <= Prec(st.peek())){
                    ans += st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                return "Invalid Expression";
            } else {
                ans += st.pop();
            }

        }
        return ans;
    }

    public static void main(String[] args){
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        infixTOpostfix a = new infixTOpostfix();
        System.out.println(a.iTOp(exp));
    }
}
