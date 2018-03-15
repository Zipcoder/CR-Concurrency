package io.zipcoder;

import java.util.Iterator;
//import java.util.NoSuchElementException;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    private Lock sharedLock = new ReentrantLock();

    public SafeCopier(String toCopy) {

        super(toCopy);
    }

    public void run() {


        while (stringIterator.hasNext()) {
            sharedLock.lock();
            try {
                copied += (stringIterator.next()) + " " ;
            } catch (NoSuchElementException e) {

            } finally {
                sharedLock.unlock();
            }
        }

    }


//    public void run() {
//        addToCopy(stringIterator);
//    }
//    synchronized void addToCopy(Iterator<String> is) {
//        while (is.hasNext()) {
//            try {
//                String str = is.next();
//                copied += str + " " + Thread.currentThread().getName() + " ";
//            } catch (NoSuchElementException e) {
//
//            }
//        }
//    }
}
