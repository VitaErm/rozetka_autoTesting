/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом while
*/

public class Task3 {

    public static void main(String[] args) {
        String s = "Vita ";
        int n = 5;
        int j = 10;
        while (n > 0) {
            n--;
            j = 10;
            while (j > 0) {
                j--;
                System.out.print(s);
            }
            System.out.println();
        }


    }
}