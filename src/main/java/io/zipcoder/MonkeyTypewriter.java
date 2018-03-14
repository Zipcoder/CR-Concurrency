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


        UnsafeCopier uc = new UnsafeCopier(introduction);
        Thread davy = new Thread(uc);
        Thread peter = new Thread(uc);
        Thread micky = new Thread(uc);
        Thread michael = new Thread(uc);
        Thread david = new Thread(uc);

        david.start();
        davy.start();
        peter.start();
        micky.start();
        michael.start();

        SafeCopier sc = new SafeCopier(introduction);
        Thread joe = new Thread(sc);
        Thread corrine = new Thread(sc);
        Thread garret = new Thread(sc);
        Thread kibret = new Thread(sc);
        Thread pete = new Thread(sc);

        joe.start();
        corrine.start();
        garret.start();
        kibret.start();
        pete.start();


        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }


        System.out.println(uc.copied);
        System.out.println("         ---------------------          ");
        System.out.println("             Safe Copier                ");
        System.out.println(sc.copied);
        // Print out the copied versions here.
    }
}