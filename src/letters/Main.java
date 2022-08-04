package letters;

public class Main {


    // https://sdkp.pjwstk.edu.pl/html/staskshtml/S_LETTERS_THREADS/S_LETTERS_THREADS.html
    public static void main(String[] args) throws InterruptedException {
        Letters letters = new Letters("ABCD");
        for (Thread t : letters.getThreads()) {
            System.out.println(t.getName());
            t.start();
        }
        /*<- tu uruchomić
             wszystkie kody w wątkach
         */


        Thread.sleep(5000);
        for (Thread t : letters.getThreads()) {
            t.interrupt();
        }
        /*<- tu trzeba zapisać
           fragment, który kończy działanie kodów, wypisujących litery
        */
        System.out.println("\nProgram skończył działanie");
    }


}
