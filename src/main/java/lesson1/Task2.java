package main.java.lesson1;/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом for
*/

public class Task2 {

    public String nameMultiplier5by10(String name) {
        return nameMultiplier(name, 5, 10);
    }

    public String nameMultiplier(String name, int rows, int columns) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultBuilder.append(name).append(" ");
            }
            resultBuilder.append("\r\n");
        }
        return resultBuilder.toString();
    }
}