package io.zipcoder;

import java.util.Iterator;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {
    // We use an iterator so each monkey / thread can copy an individual word.
//    public Iterator<String> stringIterator;
//    public String copied;
    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (stringIterator.hasNext()) {
            StringBuilder sb = new StringBuilder();
            String s = stringIterator.next();
            sb.append(s);

            copied = copied + sb.toString() + " " + Thread.currentThread().getName();
        }
    }
}

