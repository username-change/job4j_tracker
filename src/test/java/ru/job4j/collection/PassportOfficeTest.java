package ru.job4j.collection;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PassportOfficeTest {
	@Test
	public void whenTestAddMethod() {
		Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
		PassportOffice office = new PassportOffice();
		office.add(citizen);
		assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
	}

	@Test
	public void whenTestAddMethodFalse() {
		Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
		Citizen citizen2 = new Citizen("2f44a", "Petr Arsentev");
		PassportOffice office = new PassportOffice();
		office.add(citizen);
		assertThat(office.add(citizen2)).isFalse();
	}

}
