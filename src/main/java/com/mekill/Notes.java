package com.mekill;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Notes {
  private final Examen exam;
  private final Student student;
  private final List<ChangeEntry> history = new ArrayList<>();

  @Getter
  public static class ChangeEntry {
    private final double value;
    private final Instant instant;
    private final String motif;

    public ChangeEntry(double value, Instant instant, String motif) {
      this.value = value;
      this.instant = instant;
      this.motif = motif;
    }

    public double getValue() {
      return value;
    }

    public Instant getInstant() {
      return instant;
    }

    public String getMotif() {
      return motif;
    }

    @Override
    public String toString() {
      return "ChangeEntry(value=" + value + ", instant=" + instant + ", motif=" + motif + ")";
    }
  }

  public Notes(Examen exam, Student student) {
    this.exam = exam;
    this.student = student;
  }

  public Examen getExam() {
    return exam;
  }

  public Student getStudent() {
    return student;
  }

  public List<ChangeEntry> getHistory() {
    return Collections.unmodifiableList(history);
  }

  public void addNote(double newValue, String motif, Instant instant) {
    Instant time = (instant != null) ? instant : Instant.now();
    history.add(new ChangeEntry(newValue, time, motif));
  }

  public double getExamGrade(Instant t) {
    return history.stream()
        .filter(entry -> !entry.getInstant().isAfter(t))
        .max(Comparator.comparing(ChangeEntry::getInstant))
        .map(ChangeEntry::getValue)
        .orElse(0.0);
  }
}