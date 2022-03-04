import java.util.*;
/*
   This test stub tests Counter.java to make sure the counter class throws the right exceptions when illegal arguments are passed
   This test class is formatted with strings to show exception types, between **NEWTEST** you can comment out code if you want to get rid of tests to clean up your testing space
   This might need to be broken down into methods so main can be read more easily.
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
//NEW TEST*******************************************************************NEW TEST*******************************************************************
      //INCRMENT TEST****************************************************************
      System.out.println("Long Test that tests hours incrementing");
      Counter workingCounter2 = new Counter(0,0,0);
      for (int i = 0; i <24; i++) {
         workingCounter2.increment("hours");
         System.out.println(workingCounter2.toString("standard"));
         System.out.println(workingCounter2.toString("military"));
      }
      System.out.println("\nLong Test that tests minutes incrementing");
      Counter workingCounter3 = new Counter(0,0,0);
      for (int i = 0; i <24; i++) {
         workingCounter3.increment("minutes");
         System.out.println(workingCounter3.toString("standard"));
         System.out.println(workingCounter3.toString("military"));
      }
      System.out.println("\nLong Test that tests minutes incrementing");
      Counter workingCounter4 = new Counter(0,0,0);
      for (int i = 0; i <24; i++) {
         workingCounter4.increment("seconds");
         System.out.println(workingCounter4.toString("standard"));
         System.out.println(workingCounter4.toString("military"));
         }
         //DECREMENT TEST****************************************************************
      System.out.println("\nLong Test that tests hours decrementing");
      Counter workingCounter5 = new Counter(0,0,0);
      for (int i = 0; i <24; i++) {
         workingCounter5.decrement("hours");
         System.out.println(workingCounter5.toString("standard"));
         System.out.println(workingCounter5.toString("military"));
      }
      System.out.println("\nLong Test that tests minutes decrementing");
      Counter workingCounter6 = new Counter(0,0,0);
      for (int i = 0; i <60; i++) {
         workingCounter6.decrement("minutes");
         System.out.println(workingCounter6.toString("standard"));
         System.out.println(workingCounter6.toString("military"));
      }
      System.out.println("\nLong Test that tests seconds decrementing");
      Counter workingCounter7 = new Counter(0,0,0);
      for (int i = 0; i <60; i++) {
         workingCounter7.decrement("seconds");
         System.out.println(workingCounter7.toString("standard"));
         System.out.println(workingCounter7.toString("military"));
      }
//NEW TEST*******************************************************************NEW TEST*******************************************************************    
   }
}
