public class CounterTester
{
   public static void main(String[] args)
   {
      Counter clock = new Counter(0,0,-65);
      
      System.out.println("NEW TEST\n\n\n");
      System.out.println(clock.toString("military"));
      for (int i =0; i<100; i++)
      {
         clock.decrement("seconds");
         System.out.println(clock.toString());
      }      
   }
}