package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class UsageHashSet {
	public static void main(String[] args) {
		Set<String> autos = new HashSet<>();
		autos.add("Lada");
		autos.add("Lada");
		autos.add("BMW");
		autos.add("BMW");
		autos.add("Volvo");
		autos.add("Toyota");

		for (String string : autos) {
			System.out.println(string);
		}

	}
}
