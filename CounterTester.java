/*
   Tests Counter.java to make sure the counter class throws the right exceptions when illegal arguments are passed
   This also tests the functionality of the counter class making sure you can use this class in various data structures.
   This test class is formated with strings to show exception types, between **NEWTEST** you can comment out code if you want to get rid of tests to clean up your testing space
*/

public class CounterTester {
      public static void main(String[] args) {
      int HOURSTOOHIGH = 25;
      int HOURSTOOLOW = -1;
      int MINSTOOHIGH = 60;
      int MINSTOOLOW = -1;
      int SECSTOOHIGH = 60;
      int SECSTOOLOW = -1;
      
      Counter workingCounter = new Counter(0,0,0);

      System.out.println("ILLEGAL ARGUMENT INITIALIZATION TEST\n");
//NEW TEST*******************************************************************NEW TEST*******************************************************************

      try {
         Counter badClock = new Counter (HOURSTOOHIGH,0,0);
      } catch (IllegalArgumentException e) {
         System.out.println(e); 
         }      
      try {
         Counter badClock = new Counter (0,MINSTOOHIGH,0);
      } catch (IllegalArgumentException e) {
         System.out.println(e); 
         } 
      try {
         Counter badClock = new Counter (0,0,SECSTOOHIGH);
      } catch (IllegalArgumentException e) {
         System.out.println(e); 
         } 
      //testing negative illegal argments
      try {
         Counter badClock = new Counter (HOURSTOOLOW,0,0);
      } catch (IllegalArgumentException e) {
         System.out.println(e); 
         }      
      try {
         Counter badClock = new Counter (0,MINSTOOLOW,0);
      } catch (IllegalArgumentException e) {
         System.out.println(e); 
         } 
      try {
         Counter badClock = new Counter (0,0,SECSTOOLOW);
      } catch (IllegalArgumentException e) {
         System.out.println(e); 
         }
//NEW TEST*******************************************************************NEW TEST*******************************************************************
      System.out.println("\nINCREMENT/DECREMENT ILLEGAL ARGUMENT TEST\n");        
      try {
        workingCounter.increment("");
      } catch (IllegalArgumentException e) {
         System.out.println(e);
      }
      try {
        workingCounter.decrement("");
      } catch (IllegalArgumentException e) {
         System.out.println(e);
      }
//NEW TEST*******************************************************************NEW TEST*******************************************************************
      System.out.println("\n");
      for (int i = 0; i < 10; i++) {
         workingCounter.increment("hours");
         System.out.println(workingCounter.toString("military"));
         System.out.println(workingCounter.toString("standard"));
         System.out.println("\n");
        }             
   }
   
}
