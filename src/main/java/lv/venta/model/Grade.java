package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "GradeTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {
	
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Gid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gid;
	
	@Column(name = "GradeValue")
	@Min(0)
	@Max(10)
	private int gradeValue;
	
	@ManyToOne
	@JoinColumn(name = "Sid")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "Cid")
	private Course course;
	
	private Grade(int gradeValue, Student student, Course course) {
		setGradeValue(gradeValue);
		setStudent(student);
		setCourse(course);
	}
}