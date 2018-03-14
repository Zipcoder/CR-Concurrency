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


    public void run() {
        try{
            Thread.sleep(50);
        }
        catch(InterruptedException e){
            System.out.println("SLEEP INTERRUPTED");
        }

        while (stringIterator.hasNext()) {
            copyLock.lock();
            StringBuilder builder = new StringBuilder();
            try {
                this.copied += builder.append(stringIterator.next() + " " + Thread.currentThread().getName()).toString();
            } catch (NoSuchElementException e) {

            } finally {
                copyLock.unlock();

            }
        }


    }
}
