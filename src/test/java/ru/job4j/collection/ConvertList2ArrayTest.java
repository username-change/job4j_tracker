package ru.job4j.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ConvertList2ArrayTest {

	@Test
    public void when7ElementsThen9() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    public void when5ElementsThen6() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                2
        );
        int[][] expected = {
                {1, 2},
                {3, 4},
                {5, 0}
        };
        assertThat(result).isDeepEqualTo(expected);
    }

}
