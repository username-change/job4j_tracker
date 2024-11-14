package ru.job4j.oop;

public class Error {
	private boolean active;
	private int status;
	private String message;

	public Error() {

	}

	public Error(boolean active, int status, String message) {
		this.active = active;
		this.status = status;
		this.message = message;
	}

	public void printInfo() {
		System.out.println("Статус подключения: " + active);
		System.out.println("Качество связи: " + status);
		System.out.println("Действие: " + message);
	}

	public static void main(String[] args) {
		Error error = new Error();
		Error error2 = new Error(true, 3, "отправить сообщение");
		error2.printInfo();
		Error error3 = new Error(true, 5, "отправить файл");
		error3.printInfo();
	}
}
