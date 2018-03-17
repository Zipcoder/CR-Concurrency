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

        // made a UnsafeCopier called unsafeCopier with the introduction variable in it.
        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        // Setting the Thread array of monkeys equal to 5
        Thread[] unsafeThreadMonkeys = new Thread[5];
        //everytime the value of i goes through the loop and i is less than the my unsafeThreadMonkey thread then add it
        for (int i =0; i < unsafeThreadMonkeys.length;i++){
            unsafeThreadMonkeys[i] = new Thread(unsafeCopier);
            // now if the value of i is less than my array length then start threading.
        } for (int i =0; i < unsafeThreadMonkeys.length;i++){
            unsafeThreadMonkeys[i].start();
        }

        SafeCopier safeCopier = new SafeCopier(introduction);

        Thread[] safeThreadMonkeys = new Thread[5];
        for (int i = 0; i < safeThreadMonkeys.length;i++){
            safeThreadMonkeys[i] = new Thread(safeCopier);
        }
        for (int i = 0; i <safeThreadMonkeys.length;i++){
            safeThreadMonkeys[i].start();
        }



        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(unsafeCopier.copied);
        System.out.println("==============");
        System.out.println(safeCopier.copied);
    }



}