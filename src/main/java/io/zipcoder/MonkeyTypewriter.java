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
        UnsafeCopier unsafeCopy = new UnsafeCopier(introduction);

        Thread monkeySteve = new Thread(unsafeCopy, "[1]");
        Thread monkeyGuido = new Thread(unsafeCopy, "[2]");
        Thread monkeyJon = new Thread(unsafeCopy, "[3]");
        Thread monkeyMichelle = new Thread(unsafeCopy, "[4]");
        Thread monkeyHeather = new Thread(unsafeCopy, "[5]");

        Thread[] unsafeThreads = {monkeySteve,monkeyGuido,monkeyJon,monkeyMichelle,monkeyHeather};

        for(Thread t : unsafeThreads){
            t.start();
        }



        SafeCopier safeCopy = new SafeCopier(introduction);

        Thread monkeyJoe = new Thread(safeCopy, "[6]");
        Thread monkeyVince = new Thread(safeCopy, "[7]");
        Thread monkeyKibret = new Thread(safeCopy,"[8]");
        Thread monkeyAmy = new Thread(safeCopy,"[9]");
        Thread monkeyDan = new Thread(safeCopy,"[10]");

        Thread[] safeThreads = {monkeyJoe,monkeyVince,monkeyKibret,monkeyAmy,monkeyDan};
        long startTime = System.currentTimeMillis();
        for(Thread t : safeThreads){
            t.start();
        }

        for(Thread t : safeThreads){
            try {
                t.join();
            }
            catch(InterruptedException e){
                System.out.println("MONKEY INTERRUPTED");
            }
        }

        long duration = System.currentTimeMillis()-startTime;





        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println("Unsafe Copy: \n" + unsafeCopy.copied);
        System.out.println();




        System.out.println("Multi-threaded process computed in " + duration + "ms");
        System.out.println("Safe Copy: \n" + safeCopy.copied);
    }
}