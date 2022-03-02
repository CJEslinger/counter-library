public class CounterTester
{
   public static void main(String[] args)
   {
      Counter[] testCounters;
      Counter clock = new Counter(23,0,0);
      
      System.out.println("NEW TEST\n\n\n");
      System.out.println(clock.toString("military"));
      for (int i =0; i<3600; i++)
      {
         clock.decrement("seconds");
         clock.increment("minutes");
         System.out.println(clock.toString("standard"));
      }      
   }
}
