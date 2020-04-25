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
		
		// Piloto mesmoPiloto = this.pilotos.stream().filter(p -> p.equals(v.getPiloto())).findFirst().get();

		// this.voltas.stream().max(Comparator.comparing(Volta::getHora)).get();
		/**
		 * IntStream.range(0, pilotoList.size()).mapToObj(idx -> {

			Piloto p = pilotoList.get(idx);

			p.setPosicaoChegada(idx + 1);

			p.calcularTempoDecorridoDoVencedor(vencedor);

			return p;

		}).collect(Collectors.toList());
		 */

		 /**
			static public Function<String, Volta> fromString = (line) -> {
				String[] data = line.split("(\\s{2,})");// a CSV has comma separated lines
				Volta v = new Volta();

				v.setHora(LocalTime.parse(data[0]));
				v.setPiloto(new Piloto(data[1]));
				v.setId(Integer.parseInt(data[2]));
				v.setTempo(LocalTime.parse("0:".concat(data[3]), DateTimeFormatter.ofPattern("H[H]:m:ss.SSS")));
				v.setVelocidadeMedia(Double.parseDouble(data[4].replace(",", ".")));
				
				return v;
			};

			private static List<Volta> streamToList(Stream<String> stream) {
				return stream.skip(1).map(Volta.fromString).collect(Collectors.toList());
			}

		  */

		  /**
		    /**
				 * Retorna o piloto vencedor da corrida que completou 4 voltas
				public Piloto getVencedor() {
					return this.voltas.stream()
							.filter(v -> v.getPiloto().getNumeroVoltasCompletas() == this.numeroVoltasCorrida)
							.min(Comparator.comparing(Volta::getHora))
							.get()
							.getPiloto();
				}
		   */
       
	}
}