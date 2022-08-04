package letters;

import java.util.ArrayList;
import java.util.List;

public class Letters {
    private String letters;
    private List<Thread> threads = new ArrayList<>();


    public Letters(String letters) {
        this.letters = letters;

        for (char c : letters.toCharArray()) {
            Runnable r = () -> {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                      break;
                    }
                    System.out.print(c);
                }
            };
            Thread thread = new Thread(r, "Thread " + c);
            threads.add(thread);
        }



        /*
         iterujemy po stringu
         tworzymy watek dla pierwszego znaku
         usypiamy wtek na sekunde
         wyswietlamy znak

         dodajemjy watek na liste watkow
         */
    }

    public List<Thread> getThreads() {
        return threads;
    }

}
