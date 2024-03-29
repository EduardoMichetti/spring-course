package com.springcourse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	//extends JpaRepository recebe como parametro o nome da classe e o tipo da chave primária desta classe.
	// fornece vários métodos como por exemplo, pesquisar um registro, retornar todos registros, salvar, update... de forma simples.

	/*
	 * //EXEMPLOS public User findByName(String name); //método para achar um
	 * usuário
	 * 
	 * public User findByEmailAndPassword(String email, String password);//retorna
	 * usuário e email //ou fazer desta forma para ficar mais legível quando tiver
	 * mais parametros. //?1 significa os parametros que vão ser informados.
	 * 
	 * @Query("SELECT FROM User WHERE email = ?1 AND password = ?2") public User
	 * login(String email, String password);
	 */
	@Query("SELECT FROM User WHERE email = ?1 AND password = ?2") 
	public Optional<User> login(String email, String password); //Optional<User> do Java Util para tratar valores nulos, quando não encontrar no nosso caso
	
	
}
