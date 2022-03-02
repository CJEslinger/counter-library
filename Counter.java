/*
This class acts as a library which allows users to increment and decrement their counter in a time based format.
A user can initialize the counter at any real time
*/
//todo list
// line 32 modify formatting for military time. It might need a method similar to toStandardTime() Method
//line 47 there is a variable declared that gets called in the toString() method line 28. I think it will blow up due to it being restricted to the overall method and not just the individual object, so it could change for many objects.
//line 94&113 add exceptions for if argument is not what intended
public class Counter 
{   
   private int hours;
   private int minutes;
   private int seconds;
   private int SECPERMIN = 60;
   private int MINPERHOUR = 60;
   private int HOURSPERDAY = 24;

   public Counter(int hours, int minutes, int seconds)
   {
      this.hours = hours;
      if (this.hours >= HOURSPERDAY || this.hours < 0) throw new IllegalArgumentException("hours must be between 0 and 23");
      this.minutes = minutes;
      if (this.minutes >= MINPERHOUR || this.seconds < 0) throw new IllegalArgumentException("minutes must be between 0 and 60");
      this.seconds = seconds;
      if (this.seconds >= SECPERMIN || this.seconds < 0) throw new IllegalArgumentException("seconds must be between 0 and 60");
   }    
   
   public String toString(String timeType)
   {
      if (timeType != "military" && timeType != "standard")throw new IllegalArgumentException("You need to enter the string military or standard as an arguement when using this method");
      switch (timeType)
      {
         case "military": 
         //need to modify formating for military time
         return "Military Time: "+Integer.toString(this.hours)+":"+Integer.toString(this.minutes)+" Seconds:"+Integer.toString(this.seconds);
         
         case "standard":
         return toStandardTime(); 

      }
      return "";   
   }
   
   private String toStandardTime()
   {
      //this will likely blow up
      int standardHours = this.hours;
      if (this.hours > 12)
      {
         standardHours = 0;
      }
      return "Standard Time: "+Integer.toString(standardHours)+":"+Integer.toString(this.minutes)+" Seconds:"+Integer.toString(this.seconds);
   }
   
   private void logicallyIncrement()
   {
      if (this.seconds >= SECPERMIN)
      {
         this.minutes++;
         this.seconds = 0;
      }
      
      if (this.minutes >= MINPERHOUR)
      {
         this.hours++;
         this.minutes = 0;
      }
      
      if (this.hours >= HOURSPERDAY)
      {
         this.hours = 0;
      }
   }
   private void logicallyDecrement()
   {
      if (this.seconds < 0)
      {
         this.minutes--;
         this.seconds = 59;
      }
      
      if (minutes < 0)
      {
         this.hours--;
         this.minutes = 59;
      }
      
      if (this.hours < 0)
      {
         this.hours = 23;
      }
   }
   
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

