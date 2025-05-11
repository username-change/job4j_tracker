package ru.job4j.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

class OrderConvertTest {
	@Test
	public void whenSingleOrder() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("3sfe", "Dress"));
		HashMap<String, Order> map = OrderConvert.process(orders);
		Order expected = new Order("3sfe", "Dress");
		assertThat(map.get("3sfe")).isEqualTo(expected);
	}

	@Test
	public void whenDuplicateOrders() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("3sfe", "Dress"));
		orders.add(new Order("3sfe", "Shoes"));
		orders.add(new Order("3sfe", "Phone"));
		HashMap<String, Order> map = OrderConvert.process(orders);
		assertThat(map.size()).isEqualTo(1);
	}

}
