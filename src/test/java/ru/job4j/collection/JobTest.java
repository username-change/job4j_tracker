package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameDescAndPriorityAsc() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameDescAndPriorityDesc() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}