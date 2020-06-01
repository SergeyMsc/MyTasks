// Задачка на проверку високосности года

public class Task_3 {
    static void task_3() {
        int year = 2020;
        System.out.println(year + " год:");
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Год является високосным.");
        } else {
            System.out.println("Год не является високосным.");
        }
    }
}