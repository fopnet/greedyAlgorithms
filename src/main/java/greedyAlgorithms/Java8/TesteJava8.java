package greedyAlgorithms.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



class TesteJava8 {
    static List<String> places = new ArrayList<>();

	// preparing our data
	public static List<String> getPlaces(){

		places.add("Portugal, Lisboa");
		places.add("Portugal, Porto");
		places.add("India, Delhi");
		places.add("USA, New York");
		places.add("Africa, Nigeria");

		return places;
	}

	public static void main( String[] args ) {

		List<String> myPlaces = getPlaces();
		System.out.println("Places from Portugal:");

        // ADD YOUR CODE HERE
        System.out.println(myPlaces.stream().filter(s -> s.toLowerCase().indexOf("portugal") >=0).collect(Collectors.toList()));

        myPlaces.stream().filter(s -> s.toUpperCase().contains("PORTUGAL")).map(String::toUpperCase).forEach(System.out::println);
        
       
	}
}