package producent.konsument;

import java.util.*;

public class Main {

    private static final Queue<String> queue = new LinkedList<>();
    private static final Random rand = new Random();
    private static int licznik = 0;

    public static void main(String[] args) {

        int productCount = 5;

        Thread producent = new Thread(() -> {
            for (int i = 0; i < productCount; i++) {
                try {
                    Thread.sleep(rand.nextInt(6000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue) {
                    queue.add("Produkt " + i);
                    queue.notify();
                }
            }
        });

        /*
            wait() - dodaje watek do zbioru powiadaminych watkow
            notify() - powiadamia i wybudfza jeden watek
            notifyAll() - powiadamia i wybudza wszystkie watki
         */

        Thread consumer = new Thread(() -> {
            int productLeft = productCount;

            while (productLeft > 0) {
                licznik++;
                String product;

                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    product = queue.poll();
                }
                System.out.println("Consumer got product: " + product);
                System.out.println(licznik);
            }
        });
        producent.start();
        consumer.start();
    }

}
