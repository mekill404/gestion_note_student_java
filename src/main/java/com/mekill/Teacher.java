package com.mekill;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher 
{
  private int id_teacher;
  private LocalDate birthdday;
  private String name, firstname, email, tel_number, speciality;
}
