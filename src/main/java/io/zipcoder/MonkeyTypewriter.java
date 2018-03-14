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
        Copier r = new UnsafeCopier(introduction);
        Copier s = new SafeCopier(introduction);
        while(r.stringIterator.hasNext() || s.stringIterator.hasNext()) {
            Thread monkey1 = new Thread(r);
            Thread monkey2 = new Thread(r);
            Thread monkey3 = new Thread(r);
            Thread monkey4 = new Thread(r);
            Thread monkey5 = new Thread(r);
            Thread monkey6 = new Thread(s);
            Thread monkey7 = new Thread(s);
            Thread monkey8 = new Thread(s);
            Thread monkey9 = new Thread(s);
            Thread monkey10 = new Thread(s);

            monkey1.start();
            monkey2.start();
            monkey3.start();
            monkey4.start();
            monkey5.start();
            monkey6.start();
            monkey7.start();
            monkey8.start();
            monkey9.start();
            monkey10.start();

//            monkey1.interrupt();
//            monkey2.interrupt();
//            monkey3.interrupt();
//            monkey4.interrupt();
//            monkey5.interrupt();
//            monkey6.interrupt();
//            monkey7.interrupt();
//            monkey8.interrupt();
//            monkey9.interrupt();
//            monkey10.interrupt();
        }
            // This wait is here because main is still a thread and we want the main method to print the finished copies
            // after enough time has passed.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("MAIN INTERRUPTED");
            }

        // Print out the copied versions here.
        System.out.println("Unsafe Copier: " + r.copied);
        System.out.println();
        System.out.println("Safe Copier: " + s.copied);
    }
}