package io.zipcoder;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    private Lock lock;

    public SafeCopier(String toCopy) {
        super(toCopy);
        lock = new ReentrantLock();
    }

    public void run() {
        try{
            lock.lock();
            copied += stringIterator.next() + " " + Thread.currentThread().getName()+ " ";
        } catch (NoSuchElementException e){

        } finally {
            lock.unlock();
        }
    }
}

//Explanation/PseudoCode
//created a private lock field with type lock
//inorder to fully extend Copier had to override Copier constructor and methods
//instantiated the lock (looked at the lecture for the "new ReentrantLock()"
//try and catch for exception handling
//NoSuchElementException  =  indicates that there are no more elements in the enumeration.
//finally - The finally block always executes when the try block exits.
//then I unlocked the lock