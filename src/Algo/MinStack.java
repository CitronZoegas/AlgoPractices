package Algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

    private int val;

    private int[] arr = {val+1};
    private Stack<Integer> stack = new Stack<Integer>();

    public MinStack() {

    }

    public void push(int val) {
        this.val = val;
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.stream().min(Integer::compare).get();
    }
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<String>();

        int start = 0;
        int end   = n;

        while(start < end){
            if(n%3 == 0 && n%5 == 0){
                list.add("FizzBuzz");
            }
            else if(n%3 == 0){
                list.add("Fizz");
            }
            else if(n%5 == 0){
                list.add("Buzz");
            }
            else{
                list.add(Integer.toString(start));
            }
            start++;
        }
        return list;
    }
}
