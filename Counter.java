/*
This class acts as a library which allows users to increment and decrement their counter in a time based format.
A user can initialize the counter at any real time
*/
//todo list
//line 56 there is a variable declared that gets called in the toString() method line 28. I think it will blow up due to it being restricted to the overall method and not just the individual object, so it could change for many objects.
//line 84 & 53 Should likely Clean up the formating methods. Maybe add variables for the time values that are exclusive to the formatting methods and that cannot be accessed by other methods.

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
      if (this.hours >= HOURSPERDAY || this.hours < 0) throw new IllegalArgumentException("'hours' argument must be between 0 and 23");
      this.minutes = minutes;
      if (this.minutes >= MINPERHOUR || this.minutes < 0) throw new IllegalArgumentException("'minutes' argument must be between 0 and 60");
      this.seconds = seconds;
      if (this.seconds >= SECPERMIN || this.seconds < 0) throw new IllegalArgumentException("'seconds' argument must be between 0 and 60");
   }    
   
   public String toString(String timeType)
   {
      if (timeType != "military" && timeType != "standard")throw new IllegalArgumentException("You need to enter the string military or standard as an arguement when using this method");
      switch (timeType)
      {
         case "military": 
         return toMilitaryTime();
         case "standard":
         return toStandardTime(); 

      }
      return "";   
   }
   //I think this might blow up for scope problems and who can use this function
   private boolean doMinuteFormatting()
      {
        if (String.valueOf(this.minutes).length() < 2) {return true;}
        else{return false;} 
      }
   private boolean doHourFormatting()
      {
        if (String.valueOf(this.hours).length() < 2) {return true;}
        else{return false;} 
      }

   //NEED TO CLEAN UP
   private String toStandardTime()
   {
      //this will likely blow up
      int standardHours = this.hours;
      if (this.hours >= 12)
      {
         standardHours = this.hours-12;
         if (standardHours == 0)
         {
            if (doMinuteFormatting()){return "Standard Time: 12"+":"+Integer.toString(this.minutes)+":0"+Integer.toString(this.seconds)+ "PM";}
            else {return "Standard Time: 12"+":"+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds)+ "PM";}
         } 
         else
         {
            if (doMinuteFormatting()){return "Standard Time: "+Integer.toString(standardHours)+Integer.toString(this.minutes)+":0"+Integer.toString(this.seconds)+ "PM";}
            else {return "Standard Time: "+Integer.toString(standardHours)+":"+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds)+ "PM";}
         }
      }
      if (standardHours == 0)
         {
            if (doMinuteFormatting()){return "Standard Time: 12"+":0"+Integer.toString(this.minutes)+":0"+Integer.toString(this.seconds)+ "AM";}
            else {return "Standard Time: 12"+":0"+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds)+ "AM";}
         } 
      else
      {
         if (doMinuteFormatting()){return "Standard Time: "+Integer.toString(standardHours)+":0"+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds)+ "AM";}
         return "Standard Time: "+Integer.toString(standardHours)+":"+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds)+ "AM";
      }
   }
 
   //NEED TO CLEAN UP
   private String toMilitaryTime()
   {
      
      if (doHourFormatting() && doMinuteFormatting())
      {
      return "Military Time: 0" + Integer.toString(this.hours)+"0"+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds);
      }
      
      if (doMinuteFormatting())
      {
      return "Military Time: " + Integer.toString(this.hours)+"0"+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds);
      }
      
      if (doHourFormatting())
      {
      return "Military Time: 0" + Integer.toString(this.hours)+""+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds);
      }
      else
      { 
      return "Military Time: " + Integer.toString(this.hours)+""+Integer.toString(this.minutes)+":"+Integer.toString(this.seconds);
      }
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
      if (time != "seconds" && time != "minutes" && time != "hours") throw new IllegalArgumentException("You must pass 'seconds', 'minutes', or 'hours' as and argument.");
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
      if (time != "seconds" && time != "minutes" && time != "hours") throw new IllegalArgumentException("You must pass 'seconds', 'minutes', or 'hours' as and argument.");
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

