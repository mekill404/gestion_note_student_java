package com.mekill.user;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Teacher extends User
{
  private String speciality;

  public Teacher(int id, String name, String first_name, LocalDate birthdate, String phone_number, String email, String speciality) {
    super(id, name, first_name, birthdate, phone_number, email);
    this.speciality = speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

}
