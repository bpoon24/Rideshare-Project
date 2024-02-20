I. DESCRIPTION
This program simulates cars moving passengers between stations along a road.  
In essence, I simulate "movement" by transferring values between various ArrayLists.
The road class is hierarchically the highest, since it coordinates the stations.
However, the station class does the heavy-lifting, orchestrating the picking-up and dropping-off.
The car and passenger classes perform useful supporting functions but don't "see" the program at a high-level.

II. SIMULATION RESULTS
Scenario 1: 20 cars and 50 passengers
Values of average revenue: 1.541, 1.691, 1.669, 1.789, 1.857
Mean: 1.709

Scenario 2: 10 cars and 40 passengers
Values of average revenue: 1.514, 1.274, 2.521, 1.589, 1.724
Mean: 1.724

Scenario 2 generally has a higher average revenue because 1.724 > 1.709.


III. REFLECTION
I'm most proud of the components I created that overcame the challenges I faced.  

For example, one difficulty I had was handling situations where multiple cars could pick up a single passenger.
I addressed it by creating a list of passengers at each station and then removing passengers from the list as they were loaded into cars.

A more conceptual challenge I encountered was deciding what information each class should have access to.
I initially attempted to set up my program such that only the road class contained lists of stations, cars, and passengers.
But I soon realized that this prevented the "lower" classes from performing their necessary functions.
So I settled on a waterfall-style set-up where each class had lists of the classes beneath it.
Since I randomly generated the elements of each class at the level of the road, I created methods to effectively transfer the information to the lower classes.


