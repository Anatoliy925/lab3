package lab3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Resources{
    public int num1;
    public int num2;

    public Resources(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}

public class Main {
    public static void main(String[] args) {

        Resources numbers1 = new Resources(15,5);
        Resources numbers2 = new Resources(14,2);
        Resources numbers3 = new Resources(17,17);
        Resources numbers4 = new Resources(21,7);

        Thread thread1 = new Thread(new CalculationsRunnable(numbers1));
        CalculationsThread thread2 = new CalculationsThread(numbers2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new CalculationsRunnable(numbers3));
        executorService.execute(new CalculationsThread(numbers4));

        executorService.shutdown();
    }
}

class CalculationsThread extends Thread{

    Resources numbers;

    public CalculationsThread(Resources numbers) {
        this.numbers = numbers;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(numbers.num1 + " + " + numbers.num2 +" = " + (numbers.num1 + numbers.num2));
        System.out.println(numbers.num1 + " - " + numbers.num2 +" = " + (numbers.num1 - numbers.num2)+ "\n");

    }
}

class CalculationsRunnable implements Runnable{

    Resources numbers;

    public CalculationsRunnable(Resources numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {

        System.out.println(numbers.num1 + " * " + numbers.num2 +" = " + (numbers.num1 * numbers.num2));
        System.out.println(numbers.num1 + " / " + numbers.num2 +" = " + (numbers.num1 / numbers.num2)+ "\n");
    }
}