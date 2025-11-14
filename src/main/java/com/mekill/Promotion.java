package com.mekill;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
  private String name;
  private List<String> groupes; 
  private List<Student> students; 
  private List<Notes> allGrades;
  
  public double getCourseGrade(Courses course, Student student, Instant t) 
  {
    List<Notes> relevantNotes = 
    (
      this.allGrades.stream()
      .filter(n -> n.getStudent()
      .equals(student) && n.getExam()
      .getCourse().equals(course))
      .collect(Collectors.toList())
    );
    if (relevantNotes.isEmpty()) 
    {
      return 0.0;
    }
    double numerator = relevantNotes.stream().mapToDouble(note -> 
    {
      double examGrade = note.getExamGrade(t); 
      int coefficient = note.getExam().getCoefficient();
      return examGrade * coefficient;
    }).sum();

    double denominator = relevantNotes.stream()
      .mapToDouble(note -> note.getExam().getCoefficient())
      .sum();
    if (denominator == 0) {
      return 0.0;
    }
    return numerator / denominator;
  }
}