package com.mekill;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Teacher 
{
  private int id_teacher;
  private String name, firstname, date_naissance, email, tel_number, speciality;
}
