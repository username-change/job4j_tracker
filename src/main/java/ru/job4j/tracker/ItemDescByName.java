package ru.job4j.tracker;

import java.util.Collections;
import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
	@Override
	public int compare(Item first, Item second) {
		return Collections.reverseOrder().compare(first.getName(), second.getName());
	}

}
