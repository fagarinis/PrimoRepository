package it.prova.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSet {

	public static void main(String[] args) {
//		Set e' un interfaccia implementata da HashSet e TreeSet, i set:
//			1. sono collezioni non ordinate
//			2. non possono contenere duplicati
//			3. ha varie implementazioni tra cui HashSet, TreeHashSet e TreeSet (ordinato)
//		l'ordine di iterazione su un HashSet e' non deterministico e le operazioni normali hanno costo costante
		
		//vari modi di inizializzazione:
		Set<Integer> setDiInteri = new HashSet<>();
		Set<Character>	setDiChar = new HashSet<>(Arrays.asList(new Character[]{'c','b','a','d','d'}));
		Set<String> setDiStringhe = Stream.of("prova", "stream", "per", "creare", "set").collect(Collectors.toCollection(HashSet::new));
		
		//aggiunte
		setDiInteri.add(7); //aggiunta di un elemento
		setDiInteri.addAll(Arrays.asList(23,23,25,6,26, 2, -4,-6, 18, 19, 21));
		setDiInteri.add(-9);
		setDiChar.add('e');
		
		//rimozioni
		setDiInteri.remove(7);
		setDiInteri.removeIf(n -> n % 2 == 0); //rimuovi tutti i pari
		
		//select
		System.out.println("***prova se contiene 23 e 25");
		System.out.println(setDiInteri.containsAll(Arrays.asList(23,25)));;
		
		
		//cicli
		System.out.println("****************ciclo sugli HashSet*************");
		System.out.print("set di interi: ");
		for (Integer integer : setDiInteri) 
			System.out.print(integer+", ");
		
		System.out.println();
		System.out.print("set di char: ");
		for (Character c : setDiChar) 
			System.out.print(c +", ");
		
		System.out.println();
		System.out.print("set di stringhe: ");
		for (String str : setDiStringhe) 
			System.out.print(str+", ");
		System.out.println("\n");
		
		//il TreeSet ha i suoi elementi ordinati ad heap in ordine crescente (o attraverso un comparatore)
		TreeSet<Integer> treeSetDiInteri = new TreeSet<>();
		
		treeSetDiInteri.add(100);
		treeSetDiInteri.add(10009);
		treeSetDiInteri.add(-5);
		treeSetDiInteri.addAll(setDiInteri);
		
		//l'ordine di iterazione su un TreeSet e' crescente e le operazioni normali hanno costo log(n)
		System.out.println("**************ciclo sul TreeSet*************");
		for (Integer integer : treeSetDiInteri) {
			System.out.print(integer+", ");
		}
		
	}

}
