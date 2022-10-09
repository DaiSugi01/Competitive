package sample;

import java.util.*;
import java.util.stream.Collectors;

/*
* // Question: In every Amazon warehouse is a conveyor belt with packages.
* // Each package is tagged with an airport code indicating their next destination (e.g. SEA), the sorting facility.
* // Usually, there is a machine that redirects every package on the belt into their respective sorting facility bins, but that machine broke.
* // To mitigate, they are instructing workers to manually pluck the largest section of packages off the belt
* // that fits a certain criteria and place them in a bin for further processing.
*
* // Write a function that would return the largest section of packages on the conveyer belt going to at most N sorting facilities.
* // If there are multiple answers, return the first one on the conveyor belt.
*

 Other comparisons

// Hint: A section is a contiguous group of packages on the belt.

// finding largest section of packages with only 1 sorting facility

<SEA = SEA = YVR = IDA = IDA = IDA = IDA>, 2
<YVR = IDA = IDA = IDA = IDA>

* check if the size of set is less than or equal to #facilities
* Set<String> uniqueAirportCode=[SEA, YVR, IDA]
* String firstAirPort = "SEA"
* Queue<String> currentFacilities = [YVR, IDA]
* List<String> largestFacilities = []
*
* loop through the packages array
*   add airportCode to uniqueAirportCode
*   if (#uniqueAirportCode <= #facilities)
*       add airportCode to queue
*   else
*       if (uniqueAirportCode.size() > largestFacilities.size())
*           largestFacilities = uniqueAirportCode
*       firstAirport = queue.poll()
*       remove firstAirport from queue
*       remove firstAirport from set
*
* update LargestFacilities if #largestFacilities is less than the queue size
* otherwise return LargestFacilities
 */
public class Amazon {
    public static void main(String[] args) {
        Amazon sol = new Amazon();
        System.out.println(sol.test(new ArrayList<>(Arrays.asList("SEA", "SEA", "YVR", "IDA", "IDA", "IDA", "IDA")), 2));
        System.out.println(sol.test(new ArrayList<>(Arrays.asList("SEA", "SEA", "YVR", "IDA", "IDA")), 4));
        System.out.println(sol.test(new ArrayList<>(Arrays.asList("SEA", "SEA", "YVR", "SEA", "IDA")), 1));
    }

    public List<String> test(List<String> packages, int numOfFacilities) {
        List<String> largestFacilities = new ArrayList<>();
        Set<String> uniqueAirport = new HashSet<>();
        Queue<String> currentFacilities = new ArrayDeque<>();

        for (String airport : packages) {
            uniqueAirport.add(airport);
            if (uniqueAirport.size() <= numOfFacilities) {
                currentFacilities.add(airport);
            } else {
                if (currentFacilities.size() > largestFacilities.size())
                    largestFacilities = currentFacilities.stream().map(n1 -> n1).collect(Collectors.toList());

                String firstAirPort = currentFacilities.poll();
                while (currentFacilities.peek() == firstAirPort)
                    currentFacilities.poll();
                uniqueAirport.remove(firstAirPort);
                currentFacilities.add(airport);
            }
        }

        if (currentFacilities.size() > largestFacilities.size())
            return currentFacilities.stream().map(n1 -> n1).collect(Collectors.toList());
        else
            return largestFacilities;
    }
}
