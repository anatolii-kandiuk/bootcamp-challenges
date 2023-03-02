package org.bootcamp.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunConcurrency {
    private static final String SALES = "src/main/java/org/bootcamp/concurrency/data/sales.csv";
    private static double furniture = 0;
    private static double technology = 0;
    private static double supplies = 0;
    private static double average = 0;

    public static void run() {
        try {
            Path path = Paths.get(SALES);

            int nThreads = Runtime.getRuntime().availableProcessors();

            ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

            Future<Double> future1 = executorService.submit(() -> average(path, "Furniture"));
            Future<Double> future2 = executorService.submit(() -> average(path, "Technology"));
            Future<Double> future3 = executorService.submit(() -> average(path, "Office Supplies"));
            Future<Double> future4 = executorService.submit(() -> totalAverage(path));

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore dataset: ");

            String name = scan.nextLine();

            furniture = future1.get();
            technology = future2.get();
            supplies = future3.get();
            average = future4.get();

            executorService.shutdownNow();

            System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
            System.out.println("Average Furniture Sales: " + furniture);
            System.out.println("Average Technology Sales: " + technology);
            System.out.println("Average Office Supplies Sales: " + supplies);
            System.out.println("Total Average: " + average);

            scan.close();

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
