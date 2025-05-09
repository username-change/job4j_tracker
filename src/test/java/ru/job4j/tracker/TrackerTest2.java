package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TrackerTest2 {
	@Test
	public void whenReplaceItemIsSuccessful() {
	    Tracker tracker = new Tracker();
	    Item item = new Item("Bug");
	    tracker.add(item);
	    int id = item.getId();
	    Item updateItem = new Item("Bug with description");
	    tracker.replace(id, updateItem);
	    assertThat(tracker.findById(1).getName()).isEqualTo("Bug with description");
	}

	@Test 
	public void whenReplaceItemIsNotSuccessful() {
	    Tracker tracker = new Tracker();
	    Item item = new Item("Bug");
	    tracker.add(item);
	    Item updateItem = new Item("Bug with description");
	    boolean result = tracker.replace(1000, updateItem);
	    assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
	    assertThat(result).isFalse();
	}

}
