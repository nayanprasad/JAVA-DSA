package stack;
import java.util.*;


class stack{
    int top;
    int arr[] =  new int[100];
    stack(){
        top = -1;
    }

    void push(int d){
        arr[++top] = d;
    }

    int pop(){
        return arr[top--];
    }
    int peek(){
        return arr[top];
    }
}
public class postfix_evaluation{

    public int postfixANS(String s){

        stack st = new stack();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int a = Character.getNumericValue(ch);
                st.push(ch - '0');
            }
            else{
                int val1 = st.pop();
                int val2 = st.pop();
                switch(ch)
                {
                    case '+':
                        st.push(val2+val1);
                        break;

                    case '-':
                        st.push(val2- val1);
                        break;

                    case '/':
                        st.push(val2/val1);
                        break;

                    case '*':
                        st.push(val2*val1);
                        break;
                }
            }
        }
        return st.pop();
    }

    public static void main(String[] args){
        String s = "231*+9-";
        postfix_evaluation a = new postfix_evaluation();
        System.out.println(a.postfixANS(s));
    }
}
