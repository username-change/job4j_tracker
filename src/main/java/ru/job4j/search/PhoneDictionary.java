package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
	private ArrayList<Person> persons = new ArrayList<>();

	public void add(Person person) {
		this.persons.add(person);
	}

	/**
	 * Вернуть список всех пользователей, который содержат key в любых полях.
	 * 
	 * @param key Ключ поиска.
	 * @return Список пользователей, которые прошли проверку.
	 */

	public ArrayList<Person> findBy(Predicate<Person> filter) {
		var result = new ArrayList<Person>();
		for (var person : persons) {
			if (filter.test(person)) {
				result.add(person);
			}
		}
		return result;
	}

	public ArrayList<Person> find(String key) {
		Predicate<Person> nameContains = person -> person.getName().contains(key);
		Predicate<Person> surnameContains = person -> person.getSurname().contains(key);
		Predicate<Person> addressContains = person -> person.getAddress().contains(key);
		Predicate<Person> phoneContains = person -> person.getPhone().contains(key);

		var combine = nameContains
				.or(surnameContains)
				.or(addressContains)
				.or(phoneContains);

		return findBy(combine);
	}
}
