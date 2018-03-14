package io.zipcoder;

import java.util.NoSuchElementException;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier{

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while(stringIterator.hasNext()){
            try {
                this.copied = this.copied + stringIterator.next() + " " + Thread.currentThread().getName();
            }
            catch(NoSuchElementException e){

            }
        }

    }
}
