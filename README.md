# counter-library
Allows users to create counter objects that can simulate time clocks when incremented or decremented from.

The counter may be initialized to any time, but once initialized can only be incremented or decremented from. The smallest increment should be a second and the largest increment an hour, but ensure the implementation is easy to expand upon and handles for both positive and negative adjustments. Do not include day as part of the counter, in situations where the provided increment would change the day, simply roll over/under the time (similar to a clock). Display output should be made available for both standard and military time.

Note that this project is NOT a clock, increments are not made “per second” and there should be no integration with any pre-existing system-time libraries. Increments can be made at any interval and to any logical boundary (hour, minute, or second), but MUST be limited to increments of one (i.e. in order to add two hours to the counter, hour must be incremented twice, or minute 120 times, or second 7200 times). 

Make sure to protect the code as best as possible to prevent circumvention of the intended functionality.
Write a separate, automated, unit test stub, to completely validate the entire library’s functionality.
