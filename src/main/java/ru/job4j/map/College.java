package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

	private final Map<Student, Set<Subject>> students;

	public College(Map<Student, Set<Subject>> students) {
		this.students = students;
	}

	public Optional<Student> findByAccount(String account) {
		if (account == null) {
			return Optional.empty();
		}
		return students.keySet()
				.stream()
				.filter(student -> student.account().equals(account))
				.findFirst();
	}

	public Optional<Subject> findBySubjectName(String account, String name) {
		Optional<Student> student = findByAccount(account);
		if (student.isPresent()) {
			return students.get(student.get())
					.stream().filter(subject -> subject.name().equals(name))
					.findFirst();
		}
		return Optional.empty();
	}

}
