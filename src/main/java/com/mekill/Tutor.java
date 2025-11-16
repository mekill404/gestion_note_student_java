package com.mekill;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Tutor extends User {
  private String description_link;

  public Tutor(int id, String name, String first_name, LocalDate birthdate, String phone_number, String email,
      String description_link) {
    super(id, name, first_name, birthdate, phone_number, email);
    this.description_link = description_link;
  }

  public void setDescription_link(String description_link) {
    this.description_link = description_link;
  }
  
}
