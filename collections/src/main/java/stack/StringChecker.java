package stack;

import java.util.*;

public class StringChecker<T> {


    private static final Map<Character, Character> BRACE_MAP;


    static {
        BRACE_MAP = new HashMap<>();
        BRACE_MAP.put('{','}');
        BRACE_MAP.put('[',']');
        BRACE_MAP.put('(',')');
    }

    Deque<T> stack;

    public StringChecker() {
        stack = new ArrayDeque<>();
    }

    @Override
    public String toString() {
        return "StringChecker{" +
                "stack=" + stack +
                '}';
    }

    public void push(T t) {
        stack.push(t);
    }

    public T poll() {
        return stack.poll();
    }

    public T peek() {
        return stack.peek();
    }

    public int count() {
        return stack.size();
    }

    public static void main(String[] args) {
        if(args.length < 1 || args.length > 1)
            System.out.println("Invalid input. Provide a string to check");

        String input = args[0];
        StringChecker<Character> stringChecker = new StringChecker<>();
        Set<Character> keys = BRACE_MAP.keySet();

        for(Character ch: input.toCharArray()) {
            if(keys.contains(ch))
                stringChecker.push(ch);
            else if (BRACE_MAP.values().contains(ch)) {
                Character lastChar = stringChecker.peek();
                Character matching = BRACE_MAP.get(lastChar);
                if(matching!=null && matching==lastChar) {
                    stringChecker.poll();
                }
            }
        }

        if(stringChecker.count()>0) {
            System.out.println("Unbalanced String : " + stringChecker);
        }
    }
}


