package com.springcourse.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springcourse.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "request_stage")
public class RequestStage implements Serializable{
	/**
	 * ..implements Serializable
	 * Converter um objeto em uma sequencia de bytes
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "text") //igual o campo observação do meu sistema.
	private String description;
	
	@Column(name = "realization_Date", nullable = false) //name é para colocar um nome diferente do que ta na classe no banco de dados
	@Temporal(TemporalType.TIMESTAMP)//timestamp significa que quero armazenar no banco data, hora e minuto 
	private Date realizationDate;
	
	@Column(length = 12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;
	
	@ManyToOne //vários estágios para 1 pedido
	@JoinColumn(name="request_id", nullable = false)
	private Request request;
	
	@ManyToOne //Um usuário pode ter vários estgios de pedido
	@JoinColumn(name="user_id", nullable = false)
	private User user;
}
