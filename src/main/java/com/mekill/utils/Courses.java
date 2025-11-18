// Dans Courses.java
package com.mekill.utils;

import lombok.Data;

import com.mekill.user.Teacher;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
  private int id_courses;
  private String label;
  private int credit;
  private Teacher teacher;
  private Examen evaluation_cour;
  private Notes note_evaluation;
}
