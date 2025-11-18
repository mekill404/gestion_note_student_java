package com.mekill.organisation;

import java.time.LocalDate;
import java.util.List;

import com.mekill.user.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
  private List<Groupe> groupe;
  private LocalDate year_of_promotion;
  private Student major_of_promotion;
}
