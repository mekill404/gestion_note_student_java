package com.mekill;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User
{
  private String groupe;
  private Tutor tutor;
}
