package com.mekill;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses 
{
  private int id_courses;
  private String label;
  private double credit;
  private Teacher teacher;
}
