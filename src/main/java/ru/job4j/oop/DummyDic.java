package ru.job4j.oop;

public class DummyDic {
	public String engToRus(String eng) {
		String word = "Неизвестное слово. " + eng;
		return word;
	}

	public static void main(String[] args) {
		DummyDic dic = new DummyDic();
		String voice = dic.engToRus("hello");
		System.out.println(voice);
	}
}
