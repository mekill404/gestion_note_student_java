package com.mekill;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Student extends User {
  private String groupe;
  private Tutor tutor;

  public Student(int id, String name, String first_name, LocalDate birthdate, String phone_number, String email,
      String groupe, Tutor tutor) {
    super(id, name, first_name, birthdate, phone_number, email);
    this.groupe = groupe;
    this.tutor = tutor;
  }

  public void setGroupe(String groupe) {
    this.groupe = groupe;
  }

  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
  }
}
