On souhaite gérer les notes au sein d’un établissement scolaire. Pour cela, il est important de pouvoir rattacher une note à un étudiant, pour un examen, sur un cours enseigné par un enseignant. 
Pour cela, vous devez créer des classes Java pour modéliser : 
Les étudiants qui sont caractérisés par un id (entier), un nom, un prénom, une date de naissance, un email, un numéro de téléphone, un groupe (sous la forme d’une chaîne de caractères), et un tuteur;
Les enseignants qui sont caractérisés par un id (entier), un nom, un prénom, une date de naissance, un email, un numéro de téléphone, et une spécialité (par exemple: front-end, back-end…)
Les tuteurs qui sont caractérisés par un id (entier), un nom, un prénom, une date de naissance, un email, un numéro de téléphone, et une description du lien avec l’étudiant (sous la forme d’une chaîne de caractères). 
Les notes pour un étudiant à un examen donné, avec une valeur initiale, et un historique des changements de la valeur, datée à l'heure près. On veut à chaque changement donner le motif avec une petite phrase ; 
Les cours (ou matières) avec leur id, leur label (PROG1, PROG2, …), leurs crédits, et l’enseignant (un seul) qui enseigne le cours.

Les examens avec leur id, leur titre, le cours rattaché, la date & heure de l’examen, et le coefficient de l’examen (par  exemple, si un examen de PROG2 a un coefficient 2 résulte sur un 10/20, et un autre examen de PROG2 a un coefficient 3 résulte sur un 15/20 , le calcul de la note finale du cours est : (10*2 + 15*3) / 5 = 13/20.
La promotion qui contient un ensemble de groupes 
Pour cet examen, on souhaite : 
double getExamGrade(Exam exam, Student student, Instant t) : permettre de calculer la note actuelle d’un étudiant à un examen, à un instant précis.
double getCourseGrade(Course course, Student student, Instant t) : calcule la note finale d’un étudiant donné pour une matière donnée à un moment donné.
Appuyez ces deux méthodes par des tests unitaires. 
