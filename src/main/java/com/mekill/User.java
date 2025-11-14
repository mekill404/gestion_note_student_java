package com.mekill;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private int id;
  private String name;
  private String first_name;
  private LocalDate birthdate;
  private String phone_number;
  private String email;
}
