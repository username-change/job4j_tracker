package ru.job4j.tracker;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class ItemTest {
	@Test
	void testSortItemsByNameAsc() {
		List<Item> items = Arrays.asList(
				new Item("Phone"),
                new Item("Computer"),
                new Item("Tablet")
        );
		
		List<Item> expected = Arrays.asList(
				new Item("Computer"),
				new Item("Phone"),
                new Item("Tablet")
        );
		
		Collections.sort(items, new ItemAscByName());
		assertThat(items).isEqualTo(expected);
	}
	
	@Test
	void testSortItemsByNameDesc() {
		List<Item> items = Arrays.asList(
				new Item("Phone"),
                new Item("Computer"),
                new Item("Tablet")
        );
		
		List<Item> expected = Arrays.asList(
				new Item("Tablet"),
				new Item("Phone"),
				new Item("Computer")
        );
		
		Collections.sort(items, new ItemDescByName());
		assertThat(items).isEqualTo(expected);
	}

}
