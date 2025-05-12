package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
	private final Deque<Character> descendingElements;
	private final Deque<Character> evenElements;

	public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
		this.descendingElements = descendingElements;
		this.evenElements = evenElements;
	}

	private String getEvenElements() {
		StringBuilder sb = new StringBuilder();
		int initialSize = evenElements.size();
		for (int i = 0; i < initialSize; i++) {
			if (i % 2 == 0) {
				sb.append(evenElements.pollFirst());
			} else {
				evenElements.pollFirst();
			}

		}
		return sb.toString();
	}

	private String getDescendingElements() {
		StringBuilder sb = new StringBuilder();
		int size = descendingElements.size();
		for (int i = 0; i < size; i++) {
			sb.append(descendingElements.pollLast());
		}
		return sb.toString();
	}

	public String getReconstructPhrase() {
		return getEvenElements() + getDescendingElements();
	}
}