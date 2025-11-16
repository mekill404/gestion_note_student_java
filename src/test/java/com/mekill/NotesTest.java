package com.mekill;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NotesTest {
  private static final List<Teacher> teachers = new ArrayList<>();
  private static final List<Notes> all_grades = new ArrayList<>();
  private static final List<Courses> courses = new ArrayList<>();
  private static final List<Examen> all_exams = new ArrayList<>();
  private static final List<Notes> notes_student1 = new ArrayList<>();
  
  private static Student student1; 
  private static Tutor tutor_1;
  private static Examen exam_1;
  private static Notes note_student1_prog1; 

  private static Instant toInstant(LocalDateTime localDateTime) 
  {
    return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
  }
  
  @BeforeAll
  public static void setup() { 
    
    tutor_1 = new Tutor(1, "RAKOTOSON", "Kevin Alison", LocalDate.of(2000, Month.JANUARY, 31), "020-55-365--90", "rakotosonkevin@Alison.com", "Tonton");
    student1 = new Student(1, "RAZAFIMANANTSOA", "Mahery", LocalDate.of(2005, Month.JANUARY,3), "038-95-653-90", "hei.mahery.55@gmail.com", "K4", tutor_1);

    teachers.add(new Teacher(1, "RAMAROZAKA", "Toky", LocalDate.of(1991, Month.MAY, 3), "033-99-956-33", "Toky.schooll@hei.com", "programmation"));
    teachers.add(new Teacher(2, "RANDRIANARISOA", "Miora", LocalDate.of(1985, Month.JUNE, 5), "030-55-321-54", "miora.randrianarisoa@hei.com", "web devevelopment"));
    teachers.add(new Teacher(3, "RAKOTONDRAMANANA", "Faly", LocalDate.of(1987, Month.JULY, 15), "031-66-987-65", "faly.rakotondramanana@hei.com", "database"));
    teachers.add(new Teacher(4, "RABEMANANJARA", "Sitraka", LocalDate.of(1990, Month.AUGUST, 25), "032-77-123-87", "sitraka.rabemananjara@hei.com", "mathematics"));
    teachers.add(new Teacher(5, "RAZAFINDRAKOTO", "Nirina", LocalDate.of(1988, Month.SEPTEMBER, 30), "033-88-456-78", "nirina.razafindrakoto@hei.com", "Sysème d'exploitation"));

    courses.add(new Courses(1, "PROG1", 5, teachers.get(0)));
    courses.add(new Courses(2, "WEB1", 10, teachers.get(1)));
    courses.add(new Courses(3, "DONNÉE1", 5, teachers.get(2)));
    courses.add(new Courses(4, "Mathématiques", 6, teachers.get(3)));
    courses.add(new Courses(5, "SYS1", 3, teachers.get(4)));

    LocalDateTime exam_prog1_dateTime = LocalDateTime.of(2025, 3, 15, 9, 0);
    LocalDateTime exam_web1_dateTime = LocalDateTime.of(2025, 3, 16, 9, 0);   
    LocalDateTime exam_donnee1_dateTime = LocalDateTime.of(2025, 3, 15, 13, 0); 
    LocalDateTime exam_math_dateTime = LocalDateTime.of(2025, 3, 20, 10, 0);

    exam_1 = new Examen(1, 2, "Examen prog1", courses.get(0), exam_prog1_dateTime);
    all_exams.add(exam_1);
    all_exams.add(new Examen(2, 2, "Examen web1", courses.get(1), exam_web1_dateTime));
    all_exams.add(new Examen(3, 2, "Examen donnée1", courses.get(2), exam_donnee1_dateTime));
    all_exams.add(new Examen(4, 2, "Examen mathématiques", courses.get(3), exam_math_dateTime));
    all_exams.add(new Examen(5, 2, "Examen sys1", courses.get(4), LocalDateTime.of(2025, 3, 22, 15, 30)));

    for (int i = 0; i < all_exams.size(); i++) {
      Notes note = new Notes(all_exams.get(i), student1);
      notes_student1.add(note);
      all_grades.add(note);
    }
    note_student1_prog1 = notes_student1.get(0); 
    Notes note_student1_web1 = notes_student1.get(1);
    Notes note_student1_donnee1 = notes_student1.get(2);
    Notes note_student1_math = notes_student1.get(3);
    note_student1_prog1.addNote(10.0, "Note initiale PROG1", toInstant(LocalDateTime.of(2025, 3, 15, 12, 0)));
    note_student1_prog1.addNote(12.0, "Correction PROG1", toInstant(LocalDateTime.of(2025, 3, 22, 12, 0))); 
    Instant t_web1 = toInstant(exam_web1_dateTime.plusHours(2));
    note_student1_web1.addNote(15.0, "Note initiale WEB1", t_web1); 
    Instant t_donnee1 = toInstant(exam_donnee1_dateTime.plusHours(10));
    note_student1_donnee1.addNote(17.0, "Note initiale DONNÉE1", t_donnee1);
    Instant t_math_initial = toInstant(exam_math_dateTime.plusHours(1));
    note_student1_math.addNote(8.0, "Note initiale Mathematiques", t_math_initial);
    Instant t_math_correction = exam_prog1_dateTime.plusDays(7).atZone(ZoneId.systemDefault()).toInstant();
    note_student1_math.addNote(12.0, "Correction du note Mathématiques", t_math_correction);
    notes_student1.get(4).addNote(16.0, "Note initiale SYS1", toInstant(LocalDateTime.of(2025, 3, 23, 10, 0)));
  }
  
  @Test
  void testAddNoteAndGetHistory() {
    Notes newNote = new Notes(exam_1, student1); 
    assertTrue(newNote.getHistory().isEmpty(), "L'historique doit être vide initialement");
    newNote.addNote(11.0, "Note Initiale", toInstant(LocalDateTime.of(2025, 4, 1, 0, 0))); 
    assertEquals(1, newNote.getHistory().size(), "La taille de l'historique après la première addition doit être 1");
    assertEquals(11.0, newNote.getHistory().get(0).getValue(), 0.001, "La valeur de la première note est incorrecte");
  }

  @Test
  void testGetExam() {
    assertEquals(exam_1, all_grades.get(0).getExam(), "L'objet Examen retourné doit correspondre à exam_1");
  }
  
  @Test
  void testGetStudent() {
    assertEquals(student1, note_student1_prog1.getStudent(), "L'objet Student retourné doit correspondre à student1");
  }
  
  @Test
  void testGetHistory() {
      assertEquals(2, note_student1_prog1.getHistory().size(), "L'historique de PROG1 doit contenir 2 entrées");
      assertEquals(10.0, note_student1_prog1.getHistory().get(0).getValue(), 0.001, "La première entrée doit être 10.0");
      assertEquals(12.0, note_student1_prog1.getHistory().get(1).getValue(), 0.001, "La deuxième entrée doit être 12.0");
  }

  @Test
  void testGetExamGrade_WithHistoryAndInstant() {
    Notes midtermNote = note_student1_prog1; 
    Instant t1 = toInstant(LocalDateTime.of(2025, 3, 16, 10, 0));
    double gradeT1 = midtermNote.getExamGrade(t1);
    assertEquals(10.0, gradeT1, 0.001, "Note à T1 (après 10.0, avant 12.0) doit être 10.0");
    Instant t2 = toInstant(LocalDateTime.of(2025, 3, 23, 10, 0));
    double gradeT2 = midtermNote.getExamGrade(t2);
    assertEquals(12.0, gradeT2, 0.001, "Note à T2 (après correction) doit être 12.0");
    Instant t3 = toInstant(LocalDateTime.of(2025, 1, 1, 0, 0));
    double gradeT3 = midtermNote.getExamGrade(t3);
    assertEquals(0.0, gradeT3, 0.001, "Note à T3 (avant toute note) doit être 0.0");
  }
}