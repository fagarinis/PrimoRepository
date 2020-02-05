package it.prova.map;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {

		// map e' un interfaccia che viene implementata da HashMap
		// la map contiene valori basandosi su chiavi uniche
		// i valori non sono ordinati
		// i valori possono essere duplicati

		// HashMap: non mantiene l'ordine
		// LinkedHashMap: mantiere l'ordine di inserimento
		// TreeMap: mantiene un ordine crescente delle chiavi

		Map<String, Integer> frutti = new HashMap<>();
		frutti.put("ananas", 3);
		frutti.put("mela", 3);
		frutti.put("pera", 7);
		frutti.put("mango", 5);
		frutti.put("pesca", 1);

		// per ottenere il valore associato a una chiave
		System.out.println("**test get mele*");
		Integer numeroMele = frutti.get("mela");
		System.out.println(numeroMele);

		// modifica un valore
		frutti.put("mela", numeroMele + 1);
		frutti.merge("mela", 1, Integer::sum);

		// rimuovi una entry
		System.out.println("test remove mango");
		System.out.println(frutti.remove("mango"));

		
		//check di una entry
		System.out.println("contiene l'ananas? "+ frutti.containsKey("ananas") );
		
		System.out.println("***test ciclare su una map***");
		// per ciclare su una map e' fondamentale il metodo .entrySet che contiene
		// le coppie chiave valore (oggetti Map.Entry)
		// Map.Entry e' una sottointerfaccia di Map
		for (Map.Entry kv : frutti.entrySet())
			System.out.print(kv.getKey() + ": " + kv.getValue()+", ");
		System.out.println();
		
		//applico un operazione su tutti i valori
		System.out.println("*******applico un operazione su tutti i valori*****");
		for (Map.Entry kv : frutti.entrySet()) {
			frutti.compute((String) kv.getKey(), (key,value)-> Math.abs(value*2 + key.hashCode()/100000));
		}
		
		
		
		System.out.println(frutti);
		

	}

}
