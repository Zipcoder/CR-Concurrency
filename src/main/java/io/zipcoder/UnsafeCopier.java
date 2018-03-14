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
        try{
            Thread.sleep(50);
        }
        catch(InterruptedException e){
            System.out.println("SLEEP INTERRUPTED");
        }

        while(stringIterator.hasNext()){
            StringBuilder builder = new StringBuilder();
            try {
                this.copied += builder.append(stringIterator.next() + " " + Thread.currentThread().getName()).toString();
            }
            catch(NoSuchElementException e){

            }
        }

    }
}
