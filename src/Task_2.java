/*
Суть в том, чтобы создать большой массив и провести операцию с каждым его элементом.
Во втором методе такой же массив разделить на 2 массива и провести те же операции с
каждым из них и затем вновь объединить в один массив.
Для каждого метода засекается время работы. Выяснилось, что второй метод медленнее.
 */

public class Task_2 {
    public static void task_2() {
        System.out.println("Сравнение работы двух методов с большим массивом:");
        method1();
        method2();
    }

    static final int size = 10000000;
    static final int half = size/2;
    static float[] arr = new float[size];

    public static void method1() {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f +
                    i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы первого метода: " +
                (System.currentTimeMillis() - timeStart));
    }

    public static void method2(){
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long timeStart = System.currentTimeMillis();
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f +
                    i / 5) * Math.cos(0.4f + i / 2));
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f +
                    i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        System.out.println("Время работы второго метода: " +
                (System.currentTimeMillis() - timeStart));
    }
}