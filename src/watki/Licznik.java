package watki;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Licznik {
    private AtomicInteger licznik = new AtomicInteger(0);

    public void zwiekszLicznik() {
        licznik.addAndGet(1);
    }

    public AtomicInteger getLicznik() {
        return licznik;
    }
    //    private int licznik = 0;
//
//    private Lock lock = new ReentrantLock();

//    public void zwiekszLicznik() {
//        try {
//            lock.lock();
//            licznik++;
//        } finally {
//            lock.unlock();
//        }
//    }
//    public void zwiekszLicznik() {
//        synchronized (this) {
//            licznik++;
//        }
//    }

//    public int getLicznik() {
//        return licznik;
//    }
}
