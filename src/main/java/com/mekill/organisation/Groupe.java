package com.mekill.organisation;

import java.util.List;

import com.mekill.enumeration.Groupe_promotion;
import com.mekill.user.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groupe {
  private int groupe_id;
  private Groupe_promotion groupe_name;
  private List<Student> groupe_member;
  private Student groupe_chef;
}