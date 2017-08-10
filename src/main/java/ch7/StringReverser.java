package ch7;

/**
 * Created by Alex on 10/08/2017.
 */
public class StringReverser {

    public static String reverse(String input){
        StringBuilder reversedBuilder = new StringBuilder(input);
        for(int i=0; i<reversedBuilder.length() / 2; i++){
            char temp = reversedBuilder.charAt(i);
            int newPos = reversedBuilder.length() -i -1;
            reversedBuilder.setCharAt(i, reversedBuilder.charAt(newPos));
            reversedBuilder.setCharAt(newPos, temp);
        }
        return reversedBuilder.toString();
    }
}
