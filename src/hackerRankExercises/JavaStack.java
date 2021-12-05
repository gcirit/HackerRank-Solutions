package hackerRankExercises;

import java.util.*;
import java.io.*;
import java.util.*;

public class JavaStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String input = sc.next();
            System.out.println(balanced(input));
        }
    }

    public static boolean balanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c =='[' || c == '(' || c == '{') {
                stack.push(c);
            }else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}