package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
	private final List<Item> items = new ArrayList<Item>();
	private int ids = 1;

	public Item add(Item item) {
		item.setId(ids);
		items.add(item);
		return item;
	}

	public Item findById(int id) {
		int index = indexOf(id);
		return index != -1 ? items.get(index) : null;
	}

	public List<Item> findByName(String key) {
		List<Item> result = new ArrayList<>();
		for (Item item : items) {
			if (item.getName().equals(key)) {
				result.add(item);
			}
		}
		return result;
	}

	public List<Item> findAll() {
		return new ArrayList<Item>(items);
	}

	private int indexOf(int id) {
		int result = -1;
		for (int index = 0; index < items.size(); index++) {
			if (items.get(index).getId() == id) {
				result = index;
				break;
			}
		}
		return result;
	}

	public boolean replace(int id, Item item) {
		int index = indexOf(id);
		if (index != -1) {
			item.setId(id);
			items.set(index, item);
			return true;
		}
		return false;
	}

	public boolean delete(int id) {
		int index = indexOf(id);
		if (index != -1) {
			items.remove(index);
			return true;
		}
		return false;
	}
}
