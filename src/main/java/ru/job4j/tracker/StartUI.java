package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.tracker.action.CreateAction;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindAllAction;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.action.ReplaceAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

public class StartUI {
	private final Output output;

	public StartUI(Output output) {
		this.output = output;
	}

	public void init(Input input, Tracker tracker, List<UserAction> actions) {
		boolean run = true;
		while (run) {
			this.showMenu(actions);
			int select = input.askInt("Выбрать: ");
			if (select < 0 || select >= actions.size()) {
				output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
				continue;
			}
			UserAction action = actions.get(select);
			run = action.execute(input, tracker);
		}
	}

	private void showMenu(List<UserAction> actions) {
		output.println("Меню:");
		for (int index = 0; index < actions.size(); index++) {
			output.println(index + ". " + actions.get(index).name());
		}
	}

	public static void main(String[] args) {
		Output output = new ConsoleOutput();
		Input input = new ValidateInput(output, new ConsoleInput());
		Tracker tracker = new Tracker();
		List<UserAction> actions = new ArrayList<UserAction>();
		actions.add(new CreateAction(output));
		actions.add(new FindAllAction(output));
		actions.add(new ReplaceAction(output));
		actions.add(new DeleteAction(output));
		actions.add(new FindByIdAction(output));
		actions.add(new FindByNameAction(output));
		actions.add(new ExitAction(output));

		new StartUI(output).init(input, tracker, actions);
	}
}