package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Departments {
	public static List<String> fillGaps(List<String> departments) {
		Set<String> temp = new LinkedHashSet<>();
		for (String value : departments) {
			String start = "";
			for (String element : value.split("/")) {
				start = start.isEmpty() ? element : start + "/" + element;
				temp.add(start);
			}
		}
		
		return new ArrayList<>(temp);
	}

	public static void sortAsc(List<String> departments) {
		Collections.sort(departments);
	}

	public static void sortDesc(List<String> departments) {
		departments.sort(new DepartmentsDescComparator());
	}
}
