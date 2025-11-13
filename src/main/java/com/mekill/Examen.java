package com.mekill;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Examen {
  private Integer id_exam, coeficient;
  private String title;
  private Courses course;
  private LocalDateTime date_hour;
}
