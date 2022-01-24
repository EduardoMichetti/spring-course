package com.springcourse.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.springcourse.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 75, nullable = false)
	private String name;
	
	@Column(length = 75, nullable = false, unique = true) //unique ele não deixa cadastrar outro igual
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)//colocando string ele vai na ROLE e compara por descrição no contrário ele compara por ID mas a 
	//ID muda caso senha adicionado depois outros campos
	private Role role;
	
	@OneToMany(mappedBy = "user") //aqui é onde faz o mapeamento como se fosse a chave estrangeira que eu fazia no SQL
	private List<Request> requests = new ArrayList<Request>();
	
	@OneToMany(mappedBy = "user") //aqui é onde faz o mapeamento como se fosse a chave estrangeira que eu fazia no SQL
	private List<RequestStage> stages = new ArrayList<RequestStage>();	

}
