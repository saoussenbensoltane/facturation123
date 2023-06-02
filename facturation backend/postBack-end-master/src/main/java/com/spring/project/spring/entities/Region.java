package com.spring.project.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nomRegion;

	@OneToMany(mappedBy = "reg", cascade = CascadeType.ALL)
	private List<Calendrier>calendriers;

}
