package com.mekill;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Examen {
  private int id_exam, coefficient;
  private String title;
  private Courses course;
  private LocalDateTime date_hour;
}
