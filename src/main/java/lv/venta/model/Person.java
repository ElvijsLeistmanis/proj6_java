package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//If objects are not created out of this class, a DB table or entity annotation is not necessary
@MappedSuperclass

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	@Column(name = "Surname")
	private String surname;
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
}
