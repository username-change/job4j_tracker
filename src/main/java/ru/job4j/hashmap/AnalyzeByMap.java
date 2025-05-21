package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnalyzeByMap {
	public static double averageScore(List<Pupil> pupils) {
		double score = 0;
		int subjects = 0;

		for (Pupil pupil : pupils) {
			for (Subject subject : pupil.subjects()) {
				score += subject.score();
				subjects++;
			}
		}

		return score / subjects;
	}

	public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
		List<Label> result = new ArrayList<>();

		for (Pupil pupil : pupils) {
			double sum = 0;
			int count = pupil.subjects().size();

			for (Subject subject : pupil.subjects()) {
				sum += subject.score();
			}
			
			double average = sum / count;
			result.add(new Label(pupil.name(), average));
		}

		return result;
	}

	public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
		Map<String, Integer> scores = new LinkedHashMap<>();
		Map<String, Integer> counts = new LinkedHashMap<>();

		for (Pupil pupil : pupils) {
			for (Subject subject : pupil.subjects()) {
				scores.merge(subject.name(), subject.score(), Integer::sum);
				counts.merge(subject.name(), 1, Integer::sum);
			}
		}

		List<Label> result = new ArrayList<>();
		for (String subjectName : scores.keySet()) {
			int total = scores.get(subjectName);
			int count = counts.get(subjectName);
			result.add(new Label(subjectName, (double) total / count));
		}

		return result;
	}

	public static Label bestStudent(List<Pupil> pupils) {
		double maxScore = 0D;
		String best = "";

		for (Pupil pupil : pupils) {
			double sum = 0;

			for (Subject subject : pupil.subjects()) {
				sum += subject.score();
			}
			if (sum > maxScore) {
				maxScore = sum;
				best = pupil.name();
			}
		}

		return new Label(best, maxScore);
	}

	public static Label bestSubject(List<Pupil> pupils) {
		Map<String, Double> subjectScores = new LinkedHashMap<>();

		for (Pupil pupil : pupils) {
			for (Subject subject : pupil.subjects()) {
				subjectScores.merge(subject.name(), (double) subject.score(), Double::sum);

			}
		}

		String bestSubject = "";
		double max = 0;

		for (Entry<String, Double> entry : subjectScores.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				bestSubject = entry.getKey();
			}
		}

		return new Label(bestSubject, max);
	}
}
