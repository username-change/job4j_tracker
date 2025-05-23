package ru.job4j.search;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {

	@Test
	public void whenHigherPrioritySecond() {
		var queue = new PriorityQueue();
		queue.put(new Task("low", 5));
		queue.put(new Task("urgent", 1));
		queue.put(new Task("middle", 3));
		var result = queue.take();
		assertThat(result.getDescription()).isEqualTo("urgent");
	}

	@Test
	public void whenHigherPriorityEquals() {
		var queue = new PriorityQueue();
		queue.put(new Task("low", 5));
		queue.put(new Task("urgent", 5));
		queue.put(new Task("middle", 5));
		var result = queue.take();
		assertThat(result.getDescription()).isEqualTo("low");
	}

}
