package io.zipcoder;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {


    private Lock copyLock = new ReentrantLock();


    public SafeCopier(String toCopy) {
        super(toCopy);
    }


//    public synchronized void run() {
//        while(stringIterator.hasNext()){
//            this.copied = this.copied + stringIterator.next() + " " + Thread.currentThread().getName();
//        }
//
//    }

    public void run() {

        while (stringIterator.hasNext()) {
            copyLock.lock();
            try {
                this.copied += stringIterator.next() + " " + Thread.currentThread().getName();
            } catch (NoSuchElementException e) {

            } finally {
                copyLock.unlock();

            }
        }


    }
}
