package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) throws InterruptedException {
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
        //unsafe threads
        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        Thread[] thread = new Thread[5];
        for (int i = 0; i < thread.length; i++){
            thread[i] = new Thread(unsafeCopier);
            thread[i].start();
        }
        //make sure the background thread is run after the threads do their jobs first
        for (Thread threads : thread){
            threads.join();
        }
        //safe
        SafeCopier safeCopier = new SafeCopier(introduction);
        Thread[] safeThread = new Thread[5];
        for (int i = 0; i < safeThread.length; i++){
            safeThread[i] = new Thread(safeCopier);
            safeThread[i].start();
        }
        for (Thread safetyThreads : safeThread){
            safetyThreads.join();
        }
        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
        // Print out the copied versions here.
        System.out.println("Unsafe Monkeys: " + "\n" + unsafeCopier.copied);
        System.out.println("----------------------------------------------");
        System.out.println("Safe Monkeys: " + "\n" + safeCopier.copied);
    }
}