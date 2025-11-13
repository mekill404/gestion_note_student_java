package com.mekill;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
  private Integer id_tutor;
  private LocalDate birthday;
  private String name, firstname, email, tel_number, description_link;
}
