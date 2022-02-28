/*
This class acts as a library which allows users to increment and decrement their counter in a time based format.
A user can initialize the counter at any real time
*/

public class Counter 
{
//using private data so the counter can only be incremented and decreamented when using the public functions.
   
   private int hours;
   private int minutes;
   private int seconds;
   private int secPerMin = 60;
   private int minPerHour = 60;
   private int hoursPerDay = 24;
   private int standardHours;

   
   
   public Counter(int hours, int minutes, int seconds)
   {
      this.hours = hours;
      this.minutes = minutes;
      this.seconds = seconds;
      formatInitialization();
   }    
   
   //allows user to see their Counter in their consol when they Sys.out.print
   public String toString(String timeType)
   {
      switch (timeType)
      {
         case "military": 
            return "Military Time: "+Integer.toString(this.hours)+":"+Integer.toString(this.minutes)+" Seconds:"+Integer.toString(this.seconds);
            break;
         case "standard":
            return toStandardTime();  
            break; 
      }
   
   //allows user to see standard time
   private String toStandardTime()
   {
      standardHours = this.hours;
      if (this.hours > 12)
      {
         standardHours = this.hours - 12;
        
         return "Standard Time: "+Integer.toString(standardHours)+":"+Integer.toString(this.minutes)+" Seconds:"+Integer.toString(this.seconds);
      }
      else
      {
      return "Standard Time: "+Integer.toString(this.hours)+":"+Integer.toString(this.minutes)+" Seconds:"+Integer.toString(this.seconds);
      }
   }
     
   //this method makes sure the clock works
   private void logicallyIncrementDecrement()
   {
      logicallyIncrement();
      logicallyDecrement();
   }
   
   private void logicallyIncrement()
   {
      if (this.seconds >= secPerMin)
      {
         this.minutes = this.seconds/secPerMin;
         this.seconds = this.seconds%60;
      }
      
      if (this.minutes >= minPerHour)
      {
         this.hours = this.minutes/minPerHour;
         this.minutes = this.minutes%60;
      }
      
      if (this.hours >= 24)
      {
         this.hours = 0;
         this.minutes = 0;
         this.seconds = 0;
      }
   }
   private void logicallyDecrement()
   {
      if (this.seconds < 0)
      {
         this.minutes--;
         this.seconds = secPerMin + this.seconds;
      }
      
      if (minutes < 0)
      {
         this.hours--;
         this.minutes = 59;
      }
      
      if (this.hours < 0)
      {
         this.hours = hoursPerDay + this.hours%hoursPerDay;
      }
   }
   
   private void formatInitialization()
   {
       while (this.seconds >= secPerMin || this.seconds < 0)
       {
         logicallyIncrementDecrement();
       }
       
       while (this.minutes >= minPerHour || this.minutes < 0)
       {
         logicallyIncrementDecrement();
       }
       
       while (this.hours >= hoursPerDay || this.hours < 0)
       {
         logicallyIncrementDecrement();
       }       
   }
   //allows user to increment time by the time they write in the argument
   public void increment(String time)
   {
      switch (time)
      {
         case "seconds":
         this.seconds++;
         break;
         
         case "minutes":
         this.minutes++;
         break;
         
         case "hours":
         this.hours++;
         break;
      }
      logicallyIncrement();  
   }
   //allows user to decrement time
   public void decrement(String time)
   {
      switch (time)
      {
         case "seconds":
         this.seconds--;
         break;
         
         case "minutes":
         this.minutes--;
         break;
         
         case "hours":
         this.hours--;
         break;
      }
      logicallyDecrement();
   }

}

