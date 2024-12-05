package ru.job4j.tracker.input;

import ru.job4j.tracker.output.StubOutput;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
	@Test
	void whenInvalidInput() {
		StubOutput output = new StubOutput();
		Input in = new MockInput(new String[] {"one", "1"});
		ValidateInput input = new ValidateInput(output, in);
		int selected = input.askInt("Enter menu:");
		assertThat(selected).isEqualTo(1);
	}

	@Test
	void whenMultipleInput() {
		StubOutput output = new StubOutput();
		Input in = new MockInput(new String[] {"1", "2", "3"});
		ValidateInput input = new ValidateInput(output, in);
		int fistSelected = input.askInt("Enter menu:");
		assertThat(fistSelected).isEqualTo(1);
		int secondSelected = input.askInt("Enter menu:");
		assertThat(secondSelected).isEqualTo(2);
		int thirdSelected = input.askInt("Enter menu:");
		assertThat(thirdSelected).isEqualTo(3);
	}

	@Test
	void whenNegativeInput() {
		StubOutput output = new StubOutput();
		Input in = new MockInput(new String[] {"-1"});
		ValidateInput input = new ValidateInput(output, in);
		int selected = input.askInt("Enter menu:");
		assertThat(selected).isEqualTo(-1);
	}

}
