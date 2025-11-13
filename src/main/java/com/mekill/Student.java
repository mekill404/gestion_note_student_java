package com.mekill;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student 
{
  private Integer id_student;
  private LocalDate birthday;
  private String name, first_name, email, groupe;
  private Tutor tutor;
}
