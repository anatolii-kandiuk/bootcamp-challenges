package org.bootcamp.concurrency;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.FutureTask;

public class RunConcurrency {
// bootcamp-challenges
    private static final String SALES = "/home/anatolii/Education/Udemy/Java/JavaCore/Bootcamp/bootcamp-challenges/src/main/java/org/bootcamp/concurrency/data/sales.csv";
    private static double furniture = 0;
    private static double technology = 0;
    private static double supplies = 0;
    private static double average = 0;

    public static void run() {
        try {
            Path path = Paths.get(SALES);

            FutureTask<Double> futureTask2 = new FutureTask<>(() -> average(path, "Furniture"));
            Thread thread2 = new Thread(futureTask2);

            FutureTask<Double> futureTask3 = new FutureTask<>(() -> average(path, "Technology"));
            Thread thread3 = new Thread(futureTask3);

            FutureTask<Double> futureTask4 = new FutureTask<>(() -> average(path, "Office Supplies"));
            Thread thread4 = new Thread(futureTask4);

            FutureTask<Double> futureTask5 = new FutureTask<>(() -> totalAverage(path));
            Thread thread5 = new Thread(futureTask5);

            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore dataset: ");

            String name = scan.nextLine();

            furniture = futureTask2.get();
            technology = futureTask3.get();
            supplies = futureTask4.get();
            average = futureTask5.get();

            System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
            System.out.println("Average Furniture Sales: " + furniture);
            System.out.println("Average Technology Sales: " + technology);
            System.out.println("Average Office Supplies Sales: " + supplies);
            System.out.println("Total Average: " + average);

            scan.close();

/*

            Thread thread12 = new Thread(() -> System.out.println("thread 12"));
            Thread thread13 = new Thread(() -> System.out.println("thread 13"));
            Thread thread14 = new Thread(() -> System.out.println("thread 14"));
            Thread thread15 = new Thread(() -> System.out.println("thread 15"));

            thread15.start();
            thread14.start();
            //thread14.sleep(2000);
            thread13.start();
            thread12.start();

*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    /**
     * Function name: average
     * @param path (Path)
     * @param category (String)
     * @return Double
     *
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three values.
     *   3. Filters every value by the @param category
     *   4. Maps every element in the stream to a double (price * quantity).
     *   5. Applies the terminal operation average.
     *   6. Returns the average as double.
     *
     */
    public static Double average(Path path, String category) {
//        if(Thread.currentThread().isInterrupted()) {
//            return 0.;
//        }
        try {
            return Files.lines(path)
                    .skip(1)
                    .map((line) -> line.split(","))
                    .filter((values) -> values[0].equals(category))
                    .mapToDouble((values) -> Double.valueOf(values[1]) * Double.valueOf(values[2]))
                    .average()
                    .getAsDouble();

        } catch (IOException ioException) {
            System.out.println(ioException);

            return 0.0;
        }
    }


    /**
     * Function name: totalAverage
     * @param path
     * @return Double
     *
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three values.
     *   3. Maps every element in the stream to a double (price * quantity)
     *   4. Applies the terminal operation average
     *   5. Returns the average as double.
     *
     */
    public static Double totalAverage(Path path) {
        try {
            return Files.lines(path)
                    .skip(1)
                    .map((line) -> line.split(","))
                    .mapToDouble((values) -> Double.valueOf(values[1]) * Double.valueOf(values[2]))
                    .average()
                    .getAsDouble();
        } catch (IOException ioException) {
            System.out.println(ioException);

            return 0.0;
        }
    }

}
