package ru.job4j.search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PhoneDictionaryTest {

	@Test
	void whenFindByName() {
		var phones = new PhoneDictionary();
		phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
		var persons = phones.find("Petr");
		assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
	}

	@Test
	void whenFindByNothing() {
		var phones = new PhoneDictionary();
		phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
		var persons = phones.find("nothing");
		assertThat(persons).isEmpty();
	}
	
	@Test
	void whenFindByAdress() {
		var phones = new PhoneDictionary();
		phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
		var persons = phones.find("Bryansk");
		assertThat(persons.get(0).getAddress()).isEqualTo("Bryansk");
	}
}
