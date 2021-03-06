/*
Вася и Петя учатся в школе в одном классе. Недавно Петя поведал Васе о хитром способе
возведения в квадрат натуральных чисел, оканчивающихся на цифру 5. Теперь Вася может
с легкостью возводить в квадрат двузначные (и даже некоторые трехзначные) числа,
оканчивающиеся на 5. Способ заключается в следующем: для возведения в квадрат числа,
оканчивающегося на 5 достаточно умножить число, полученное из исходного вычеркиванием
последней пятерки на следующее по порядку число, затем остается лишь приписать «25» к
получившемуся результату справа. Например, для того, чтобы возвести число 125 в квадрат
достаточно 12 умножить на 13 и приписать 25, т.е. приписывая к числу 12*13=156 число 25,
получаем результат 15625, т.е. 1252=15625. Напишите программу, возводящую число,
оканчивающееся на 5, в квадрат для того, чтобы Вася смог проверить свои навыки.
*/

import java.util.Random;
import java.util.Scanner;

public class Task_1 {

    public static void task_1() {
        System.out.println("Рассчитать квадрат числа по схеме Васи и проверить правильность этого метода.");
        int num = square();
        System.out.println("Число: " + num);
        int numVasya = calculate(num);
        System.out.println("Квадрат числа по Васиной схеме: " + numVasya);
        System.out.println("Квадрат числа по всеобщим законам: " + num * num);
    }

    public static int square() {
        Random random = new Random();
        int num = random.nextInt(1000);
        while(true) {
            if (num % 5 == 0 && num % 10 != 0) {
                return num;
            }
            num = random.nextInt(1000);
        }
    }

    public static int calculate(int num) {
        String strVasya = num / 10 * (num / 10 + 1) + "25";
        int num1 = 0;
        try (Scanner scan = new Scanner(strVasya)) {
            while (scan.hasNextInt()) {
                num1 = scan.nextInt();
            }
        }
        return num1;
    }
}
