package dataclass;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long now = new Date().getTime();

        Thread.sleep(10000);

        long then = new Date().getTime();

        System.out.println("Difference = " + (then-now));

    }
}
