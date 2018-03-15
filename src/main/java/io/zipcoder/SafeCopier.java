package io.zipcoder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{ //this will inherit the behavior of the abstract copier class

    private Lock lock = new ReentrantLock();

    public SafeCopier(String strCopy){
        super(strCopy); //calling the constructor of the copier class
    }

    public void run(){
        while (this.stringIterator.hasNext()){ //while the iterator/monkey/thread has the next string , try locking it
            lock.tryLock(); //this makes the thread safe by trying to lock it
            this.copied += this.stringIterator.next() + " ";
            lock.unlock();
        }
    }
}