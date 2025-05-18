package ru.job4j.search;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PhoneDictionaryTest {

	@Test
	void whenFindByName() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
		ArrayList<Person> persons = phones.find("Petr");
		assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
	}

	@Test
	void whenFindByNothing() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
		ArrayList<Person> persons = phones.find("nothing");
		assertThat(persons).isEmpty();
	}
	
	@Test
	void whenFindByAdress() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
		ArrayList<Person> persons = phones.find("Bryansk");
		assertThat(persons.get(0).getAddress()).isEqualTo("Bryansk");
	}
}
