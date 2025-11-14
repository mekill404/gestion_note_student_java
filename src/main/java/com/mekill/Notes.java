package com.mekill;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Notes {
    @Getter
    @AllArgsConstructor
    public static class ChangeEntry{
        private double value;
        private Instant instant;
        private String motif;
    }

    private final Examen exam;
    private final Student student;
        private final List<ChangeEntry> history = new ArrayList<>();

    public Notes(Examen exam, Student student, double initialValue, String initialMotif) {
        this.exam = exam;
        this.student = student;
        this.add_note(initialValue, initialMotif);
    }

    public void add_note(double new_value, String motif)
    {
        history.add(new ChangeEntry(new_value, Instant.now(), motif));
    }

    public double getExamGrade(Instant t)
    {
        return history.stream()
            .filter(entry -> !entry.getInstant().isAfter(t))
            .max(Comparator.comparing(ChangeEntry::getInstant))
            .map(ChangeEntry::getValue)
            .orElse(0.0);
    }
}
