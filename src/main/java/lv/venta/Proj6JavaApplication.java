package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;

import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class Proj6JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj6JavaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner testRepo(IStudentRepo studentRepo, IProfessorRepo professorRepo,
			IGradeRepo gradeRepo, ICourseRepo courseRepo) {
				return new CommandLineRunner() {
					
					@Override
					public void run(String... args) throws Exception {
						Student student1 = new Student("Rendijs", "Serna");
						Student student2 = new Student("Elvijs", "Leistmanis");
						studentRepo.saveAll(Arrays.asList(student1, student2));
						
						Professor professor1 = new Professor("Vairis", "Caune", Degree.phd);
						Professor professor2 = new Professor("Galina", "Hilkevica", Degree.phd);
						professorRepo.saveAll(Arrays.asList(professor1, professor2));
						
						Course course1 = new Course("Algoritmu teorija", 3, professor1);
						Course course2 = new Course("Matematiska analize", 6, professor2);
						courseRepo.saveAll(Arrays.asList(course1, course2));
						
						Grade grade1 = new Grade(6, student1, course1);
						Grade grade2 = new Grade(2, student1, course2);
						Grade grade3 = new Grade(7, student2, course1);
						Grade grade4 = new Grade(8, student2, course2);
						gradeRepo.saveAll(Arrays.asList(grade1, grade2, grade3, grade4));
					}
				};
				
	}
}
 