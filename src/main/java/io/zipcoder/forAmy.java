package io.zipcoder;

public class forAmy {
}

/*

package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        UnsafeCopier myUnsafeCopier = new UnsafeCopier(introduction);
        Copier mySafeCopier = new SafeCopier(introduction);
        Thread[] mySafeThreads = new Thread[5];
        Thread[] myUnsafeThreads = new Thread[5];

        for (int i =0; i <mySafeThreads.length; i++){
            mySafeThreads[i] = new Thread(myUnsafeCopier);
        }

        for (Thread element: mySafeThreads){
            element.start();
        }

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
//        System.out.println(t.getMyUnsafeBuilder());
        System.out.println(mySafeCopier.copied);
    }
}



















        /*
        UnsafeCopier testCopier = new UnsafeCopier(introduction);

        Thread monkey1 = new Thread(testCopier);
        Thread monkey2 = new Thread(testCopier);
        Thread monkey3 = new Thread(testCopier);
        Thread monkey4 = new Thread(testCopier);
        Thread monkey5 = new Thread(testCopier);
        Thread monkey6 = new Thread(testCopier);

        monkey1.start();
        monkey2.start();
        monkey3.start();
        monkey4.start();
        monkey5.start();
        monkey6.start();

        */

//   Thread frederick = new Thread(mySafeCopier);
//        Thread allessandra = new Thread(mySafeCopier);
//        Thread allison = new Thread(mySafeCopier);
//        Thread addison = new Thread(mySafeCopier);
//        Thread ricardo = new Thread(mySafeCopier);
//        Thread fernando = new Thread(mySafeCopier);






//
//        while(mySafeCopier.stringIterator.hasNext()) {
//            //start here
//            frederick.start();
//            allessandra.start();
//            allessandra.start();
//            allison.start();
//            addison.start();
//            ricardo.start();
//            fernando.start();
//
//
//        }
//




