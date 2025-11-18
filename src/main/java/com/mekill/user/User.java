package com.mekill.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class User {
  private int id;
  private String name;
  private String first_name;
  private LocalDate birthdate;
  private String phone_number;
  private String email;
}
