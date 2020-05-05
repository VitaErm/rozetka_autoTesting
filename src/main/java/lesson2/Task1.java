package lesson2;

/**
 * Реализовать у класса Task1 переменные age (тип int),  name (тип String), ageGroup(тип String)
 * реализовать методы геттеры и сеттеры для каждой переменной.
 * Должны быть выполненны следующие условия:
 * - не должно быть возможности напрямую устанваливать или читать значение age/name
 * - нельзя установить значение age меньше нуля
 * - максимальныое значение для возраста - 100
 * - значение name не может быть короче чем 3 символа и длиннее чем 50 символов
 * - name не может состоять из одних только пробелов
 * - не зависимо от того ввел пользователь имя с большой или с маленькой буквы,
 * оно должно быть записано в переменную name с большой буквы
 * - ageGroup должен устанавливаться автоматически при установке возраста
 * - child если age до 15 лет
 * - student  - если age от 15 до 25 лет
 * - worker - если age от 26 до 65 лет
 * - pensioner - если age старше 66 лет
 * - ageGroup можно только прочитать с помощью геттера, сеттер должен быть приватным и недоступным для других классов
 */

public class Task1 {
    private String name;
    private int age;
    private String ageGroup;

    public Task1(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (validateName(name)) {
            this.name = correctInitials(name);
        } else {
            System.out.println("You can't set this name");


        }
    }

    private String correctInitials(String name) {
        return this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public int getAge() {
        return this.age;
    }


    public void setAge(int age) {
        if (validateAge(age)) {
            this.age = age;
        } else {
            System.out.println("You can't set this age");
        }
        setAgeGroup(evaluateAgeGroupByAge(age));
    }

    public String getAgeGroup() {
        return this.ageGroup;
    }

    private void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    private String evaluateAgeGroupByAge(int age) {
        String result = null;
        if (age <= 15) result = "child";
        else if (age > 15 && age <= 25) result = "student";
        else if (age > 25 && age <= 65) result = "worker";
        else if (age > 65) result = "pensioner";

        return result;
    }

    private boolean validateAge(int age) {
        boolean validationResult1 = age >= 0 && age < 101;
        return validationResult1;
    }

    private boolean validateName(String name) {
        boolean validationResult2 = name.length() >= 3 && name.length() <= 50 && name.trim().length() > 0;
        return validationResult2;
    }
}