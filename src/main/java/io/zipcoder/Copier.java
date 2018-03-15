package io.zipcoder;

import java.util.Arrays;
import java.util.Iterator;

/**
 * We're using this as an abstract base class since both the safe and unsafe copiers will implement it.
 */
public abstract class Copier implements Runnable {
    // We use an iterator so each monkey / thread can copy an individual word.
    public Iterator<String> stringIterator;
    protected StringBuffer buffer; // You want unsafe? Try using StringBuilder instead.

    public Copier(String toCopy) {
        // Take the input string, split it on spaces, turn that array to an arraylist, and then grab its iterator.
        this.stringIterator = Arrays.asList(toCopy.split(" ")).iterator();
        buffer = new StringBuffer();
    }

    public abstract void run();

    public String getCopy() {
        return buffer.toString();
    }
}
