package arrays;

public class String1 {

    public static void main(String[] args){
        String s = "Hello World";
        int counter = 0;
        for(int i=0; i<s.length(); i++ ) {
            char c = s.charAt(i);
            Character ch = new Character('C');

            if(c>='A' && c<='Z' && ((counter%2)==1)) {
                System.out.println("yes: " + c);
                counter++;
            }
        }


    }
}
