package stack;

import java.util.Stack;

public class StringChecker2 {

    private static final String NO = "NO";
    private static final String YES = "YES";
    public static void main(String[] args) {
        String s = " (:()";

        Stack stack = new Stack();
        String result = NO;


        if (null == s || s.trim().length() == 0) {
            System.out.println(result);
        }

        String input = s;
        Character prevChar = null;
        Character recentBrace;
        int counter=0;
        //s.replace(":)", "");

        for(Character ch: input.toCharArray()) {
            char currentChar = ch.charValue();
counter++;
            if((prevChar!=null && prevChar.charValue() ==':') && (currentChar==')' || currentChar=='(') && counter!=input.length()) {
                continue;
            }

            if(currentChar =='(' && (prevChar==null || (prevChar!=null && prevChar.charValue() !=':'))) {

                stack.push(ch);

            } else if(currentChar ==')' && (prevChar==null || counter==input.length() || (prevChar!=null && prevChar.charValue() !=':'))) {

                if(stack.size()>0)
                    recentBrace = (Character) stack.peek();
                else
                    recentBrace = null;

                if(recentBrace==null || recentBrace.charValue() !='(') {
                    result = NO;
                    break;
                } else {
                    stack.pop();
                }

            }

            prevChar = ch;
        }

        if(stack.size()==0)
            result = YES;

System.out.println(result);
    }
}

