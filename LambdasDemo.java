
/**
 * LambdasDemo
 * 
 * This class will demonstrate the use of 3 Lambda expressions and 1 Lambda block.
 * The use of the Collections utility is used to determine the min, max, avg values
 * for each Lambda expression. The median can calculated for any size list given and
 * is done so from within the block. All the results are printed out for the user's
 * convenience.
 * 
 * @author SDantzler
 * */
import java.util.*;

public class LambdasDemo {

   public static void main(String[] args) {

      // Create a Generic list of doubles
      List<Double> numbers = Arrays.asList(17.64, 55.56, 36.93, 55.96, 20.23,
            41.74, 1.8, 95.97, 81.89, 36.16, 34.41, 87.9, 13.74, 11.15);

      // instance variables
      NumberFunctions min, max, avg, median;

      // Demo Lambda expressions to find min, max, and mean values using the
      // Collections utility class
      min = () -> Collections.min(numbers);
      System.out.println("The minimum value is " + min.getValue());

      max = () -> Collections.max(numbers);
      System.out.println("The maximum value is " + max.getValue());

      avg = () -> (numbers.stream().mapToDouble(e -> e).average()
            .getAsDouble());
      System.out.printf("The average is %5.2f", avg.getValue());
      System.out.println();

      // Sort the list
      Collections.sort(numbers);

      // Demo a Lambda block to find the median value in the list
      median = () -> {
         double result;

         if (numbers.size() % 2 != 0) { // calculates median for odd list
            result = numbers.get((numbers.size() / 2));
         } else { // calculates median for even list (avg of 2 middle values)
            result = (numbers.get(((numbers.size() / 2) - 1))
                  + numbers.get(numbers.size() / 2)) / 2;
         }
         return result;
      }; // end Lambda block

      System.out.printf("The median value is %5.2f", median.getValue());
   }// end main method

}// end class LambdasDemo
