package main.java.lesson2;

public class Runner {
    public static void main(String[] args) {
        Task1 f = new Task1("test", 25);
        System.out.println(f.getAge() +
                f.getAgeGroup() +
                f.getName());
    }
}
