package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
	@Override
	public int compare(String left, String right) {
		String[] leftParts = left.split("/");
		String[] rightParts = right.split("/");
		int rst = rightParts[0].compareTo(leftParts[0]);

		return rst != 0 ? rst : left.compareTo(right);
	}
}
