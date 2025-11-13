package com.mekill;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Student 
{
  private int id_student;
  private String name, first_name, date_naissance, email, groupe;
  private Tutor tutor;
}
