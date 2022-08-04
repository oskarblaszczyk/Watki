package watki;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // A - 1h, B - 1h, C - 30 sek

        Thread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Runnable r = () -> {
            System.out.println("jestem w lambda runnablu");
        };

        Thread t3 = new Thread(r);
        t3.start();

        Thread t4 = new Thread(() -> {
            System.out.println("jestem w lambda run");
        });
        t4.start();

        // https://matluniewski.smallhost.pl/1.svg

        Thread t5 = new Thread(() -> {
            System.out.println("Thread start");
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + i);
            }
            System.out.println("Thread stop");
        });
       // t5.start();

        System.out.println("Main start");
        for (int i = 0; i < 5; i++) {
            System.out.println("Main " + i);
        }
        System.out.println("Main stop");

        // Stwórz klase Licznik ktora ma pole typu int o wartosci 0, getter oraz metode
        // zwiekszajaca pole o 1
        Licznik licznik = new Licznik();
        Runnable licznikR = () -> {
            for (int i = 0; i < 100000; i++) {
                licznik.zwiekszLicznik();
            }
        };

        Thread licznik1 = new Thread(licznikR);
        Thread licznik2 = new Thread(licznikR);
        Thread licznik3 = new Thread(licznikR);

        licznik1.start();
        licznik2.start();
        licznik3.start();

        licznik1.join();
        licznik2.join();
        licznik3.join();

        System.out.println(licznik.getLicznik());

        // InterruptedException synalizuje sytuacje w ktorej watek został przerwany
        // interrupt() przerywa watek
        // interrupted() sprawdza czy watek jest przerwany
        // isInterrupted() sprawdza czy watek byl kiedykolwiek przerwany

    }
}
