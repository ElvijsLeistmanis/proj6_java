package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "ProfessorTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor extends Person{
	
	//ID is inherited from Person class
	
	@Column(name = "Degree")
	@Enumerated(EnumType.STRING)
	@NotNull
	private Degree degree;
	
	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	private Course course;
	
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setDegree(degree);
	}
}
