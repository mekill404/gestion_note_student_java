package com.mekill.utils;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examen {
  private int id_exam;
  private int coefficient;
  private String title;
  private Courses course;
  private LocalDateTime date_hour;
  private Bulletin bulletin_exam;
}
