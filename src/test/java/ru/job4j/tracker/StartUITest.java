package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import ru.job4j.tracker.action.CreateAction;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindAllAction;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.action.ReplaceAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
    	Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }
    
    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item")); 
        String replacedName = "New item name";
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
	
	@Test
	void whenExit() {
		Output output = new StubOutput();
	    Input input = new MockInput(
	            new String[] {"0"}
	    );
	    Tracker tracker = new Tracker();
	    UserAction[] actions = {
	            new ExitAction(output)
	    };
	    new StartUI(output).init(input, tracker, actions);
	    assertThat(output.toString()).isEqualTo(
	            "Меню:" + System.lineSeparator()
	                    + "0. Завершить программу" + System.lineSeparator()
	                    + "=== Завершение программы ===" + System.lineSeparator()
	    );
	}
	
	@Test
	void whenReplaceItemTestOutputIsSuccessfully() {
	    Output output = new StubOutput();
	    Tracker tracker = new Tracker();
	    Item one = tracker.add(new Item("test1"));
	    String replaceName = "New Test Name";
	    Input input = new MockInput(
	            new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
	    );
	    UserAction[] actions = new UserAction[]{
	            new ReplaceAction(output),
	            new ExitAction(output)
	    };
	    new StartUI(output).init(input, tracker, actions);
	    String ln = System.lineSeparator();
	    assertThat(output.toString()).isEqualTo(
	            "Меню:" + ln
	                    + "0. Изменить заявку" + ln
	                    + "1. Завершить программу" + ln
	                    + "=== Редактирование заявки ===" + ln
	                    + "Заявка изменена успешно." + ln
	                    + "Меню:" + ln
	                    + "0. Изменить заявку" + ln
	                    + "1. Завершить программу" + ln
	                    + "=== Завершение программы ===" + ln
	    );
	}
	
	@Test
	void whenFindAllItemTestOutputIsSuccessfully() {
	    Output output = new StubOutput();
	    Tracker tracker = new Tracker();
	    Item one = tracker.add(new Item("test1"));
	    Input input = new MockInput(
	            new String[] {"0", "1"}
	    );
	    UserAction[] actions = new UserAction[]{
	            new FindAllAction(output),
	            new ExitAction(output)
	    };
	    new StartUI(output).init(input, tracker, actions);
	    String ln = System.lineSeparator();
	    assertThat(output.toString()).isEqualTo(
	            "Меню:" + ln
	                    + "0. Показать все заявки" + ln
	                    + "1. Завершить программу" + ln
	                    + "=== Вывод всех заявок ===" + ln
                        + one + ln
	                    + "Меню:" + ln
	                    + "0. Показать все заявки" + ln
	                    + "1. Завершить программу" + ln
	                    + "=== Завершение программы ===" + ln
	    );	
	}
	
	@Test
	void whenFindByNameItemTestOutputIsSuccessfully() {
	    Output output = new StubOutput();
	    Tracker tracker = new Tracker();
	    Item one = tracker.add(new Item("test1"));
	    Input input = new MockInput(
	            new String[] {"0", one.getName(), "1"}
	    );
	    UserAction[] actions = new UserAction[]{
	            new FindByNameAction(output),
	            new ExitAction(output)
	    };
	    new StartUI(output).init(input, tracker, actions);
	    String ln = System.lineSeparator();
	    assertThat(output.toString()).isEqualTo(
	            "Меню:" + ln
	                    + "0. Показать заявки по имени" + ln
	                    + "1. Завершить программу" + ln
	                    + "=== Вывод заявок по имени ===" + ln
	                    + one + ln
	                    + "Меню:" + ln
	                    + "0. Показать заявки по имени" + ln
	                    + "1. Завершить программу" + ln
	                    + "=== Завершение программы ===" + ln
	    );	
	}
	
	@Test
	void whenFindByIdItemTestOutputIsSuccessfully() {
	    Output output = new StubOutput();
	    Tracker tracker = new Tracker();
	    Item one = tracker.add(new Item("test1"));
	    Input input = new MockInput(
	            new String[] {"0", String.valueOf(one.getId()), "1"}
	    );
	    UserAction[] actions = new UserAction[]{
	            new FindByIdAction(output),
	            new ExitAction(output)
	    };
	    new StartUI(output).init(input, tracker, actions);
	    String ln = System.lineSeparator();
	    assertThat(output.toString()).isEqualTo(
	            "Меню:" + ln
	                    + "0. Показать заявку по id" + ln
	                    + "1. Завершить программу" + ln
	                    + "=== Вывод заявки по id ===" + ln
	                    + one + ln
	                    + "Меню:" + ln
	                    + "0. Показать заявку по id" + ln
	                    + "1. Завершить программу" + ln
	                    + "=== Завершение программы ===" + ln
	    );	
	}
	
	@Test 
	void whenInvalidExit() {
	    Output output = new StubOutput();
	    Input input = new MockInput(
	            new String[] {"-1", "0"}
	    );
	    Tracker tracker = new Tracker();
	    UserAction[] actions = new UserAction[]{
	            new ExitAction(output)
	    };
	    new StartUI(output).init(input, tracker, actions);
	    String ln = System.lineSeparator();
	    assertThat(output.toString()).isEqualTo(
	            "Меню:" + ln
	                    + "0. Завершить программу" + ln
	                    + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
	                    + "Меню:" + ln
	                    + "0. Завершить программу" + ln
	                    + "=== Завершение программы ===" + ln
	    );
	}
}