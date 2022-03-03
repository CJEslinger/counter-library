# counter-library
Allows users to create counter objects that can simulate time clocks when incremented or decremented from.

The counter may be initialized to any time, but once initialized can only be incremented or decremented from. The smallest increment should be a second and the largest increment an hour, but ensure the implementation is easy to expand upon and handles for both positive and negative adjustments. Do not include day as part of the counter, in situations where the provided increment would change the day, simply roll over/under the time (similar to a clock). Display output should be made available for both standard and military time.



The Constructor

When creating a Counter object Counter(int hours, int minutes, int seconds), you must pass real integer numbers that we equate with time. This counter object stores integer data of values between and including 0-23 for hours, and 0-59 for seconds and minutes. If you enter a value out of these bounds you will be thrown an illegal argument exception.



toString(String timeType) method

For this method you must pass "military" or "standard" as an argurment. If you pass "military" as the arguement then this method will return a string output of this counter object for military time. If you pass "standard" as an arguement the method will return a reading of this counter object as a string. If you do not pass either of these as arguments you will be thrown an illegal argument exception.

There are also methods that are private to this class file that properly format the military and standart time string return value. These methods currently have many if else blocks that could be cleaned up. Their function is to format the output properly for those who use the toString method.

increment(String time)

decrement(String time)

The increment both need you to pass an argument of either "seconds", "minutes", or "hours". If you do not pass one of these arguments, you will be thrown an illegal argument exception. When you use the increment() method you will incremnt the argument you passed by +1. If you use the decrement() function, you will decrement the arguemnt you passed by -1.

