package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

//    StringBuilder myUnsafeBuilder = new StringBuilder();

    public UnsafeCopier(String toCopy) {

        super(toCopy);
    }

//    public void run() {
//
//        while(stringIterator.hasNext()){
//            copied = stringIterator.next() + " ";
//            myUnsafeBuilder.append(copied);
//        }
//
//        copied = myUnsafeBuilder.toString();
//
//        System.out.println(copied);
//
//    }

//    public StringBuilder getMyUnsafeBuilder() {
//
//        copied = myUnsafeBuilder.toString();
//
//        return myUnsafeBuilder;
//    }

    public void run(){
        while (stringIterator.hasNext()) {
            copied += stringIterator.next() + " ";
        }
    }
}
