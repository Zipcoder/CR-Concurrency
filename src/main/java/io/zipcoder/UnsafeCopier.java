package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {

        super(toCopy);
    }

    public void run() {
        while(stringIterator.hasNext()){
            copied += stringIterator.next()+" ";
        }
    }
}

//PseudoCode
//loop through the array in copier.java
// monkey needs to grab the next word
//append it to the copy
//monkeytypewriter will create 5 monkey(threads) and use this class to start them

//Ex of run method
//tried a for loop initially and couldn't figure out what should be in the comparable part
//so while stringIterator(which was turned into an arraylist in copier.java) knows our iteration
//has more elements, then add the stringIterators next value to copied plus the space.


