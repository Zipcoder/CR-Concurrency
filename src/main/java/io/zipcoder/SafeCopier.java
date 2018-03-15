package io.zipcoder;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    Lock lock1 = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (stringIterator.hasNext()) {
            lock1.lock();
            try {
                copied += stringIterator.next() + " " + Thread.currentThread().getName();
            } catch (NoSuchElementException NSEE) {
            } finally {
                lock1.unlock();
            }
        }
    }
}