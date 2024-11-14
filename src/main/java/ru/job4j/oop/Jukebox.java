package ru.job4j.oop;

public class Jukebox {
	public void music(int position) {
		String message = switch (position) {
		case 1 -> "Пусть бегут неуклюже";
		case 2 -> "Спокойной ночи";
		default -> "Песня не найдена";
		};
		
		System.out.println(message);
	}

	public static void main(String[] args) {
		Jukebox musicJukebox = new Jukebox();
		musicJukebox.music(1);
	}
}