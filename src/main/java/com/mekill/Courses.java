package com.mekill;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Courses 
{
  private int id_courses;
  private String label;
  private double credit;
  private Teacher teacher;
}
