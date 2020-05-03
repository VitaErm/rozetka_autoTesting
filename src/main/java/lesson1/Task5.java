/**
 * Реализовать функцию, которая принимает строку и возвращает ее же в обратном виде
 * например "Hello world!!!" -> "!!!dlrow olleH"
 */
public class Task5 {
    public static void main(String[] args) {

        String s = "Oooops";
        System.out.println(reverse(s));

    }

    public static String reverse(String s) {
        String str = new StringBuffer(s).reverse().toString();

        return str;


    }
}
