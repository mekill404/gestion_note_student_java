package com.mekill.utils;

import java.util.List;
import com.mekill.user.Student;

import lombok.Data;

@Data
public class Bulletin {
  private int id_bulletin;
  private Student proprietaire_bulletin;
  private List<Courses> courses_list;
  private List<Notes> notes_list;
  private String remarque_du_prof;
  private double moyenne;
  private int rang;
}