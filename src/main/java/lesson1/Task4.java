package lesson1;/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом do () while
*/

public class Task4 {

    public static void main(String[] args) {
        String s = "Vita ";
        int n = 0;
        int k = 0;
        do {
            do {
                k++;
                System.out.print(s);
            } while (k < 10);
            n++;
            System.out.println();
            k=0;
        } while (n < 5);
    }
}
