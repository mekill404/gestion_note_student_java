package com.mekill;

import lombok.Data;

@Data
public class Courses 
{
  private int id_courses;
  private String label;
  private double credit;
  private Teacher teacher;
}
