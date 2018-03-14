package io.zipcoder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends  Copier{

    Lock mySharedLock = new ReentrantLock();

    public SafeCopier(String toCopy) {

        super(toCopy);
    }

    public void run() {
        mySharedLock.lock();
        while (stringIterator.hasNext()) {
            mySharedLock.lock();
            copied += stringIterator.next() + " ";
            mySharedLock.unlock();

        }

    }
}
