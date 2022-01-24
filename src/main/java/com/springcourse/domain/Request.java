package com.springcourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

@Entity(name = "request")
public class Request implements Serializable{
	
	/**
	 * ..implements Serializable
	 * Converter um objeto em uma sequencia de bytes
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 75, nullable = false)
	private String subject;
	
	@Column(columnDefinition = "text") //igual o campo observação do meu sistema.
	private String description;
	
	@Column(name = "creation_date", nullable = false) //name é para colocar um nome diferente do que ta na classe no banco de dados
	@Temporal(TemporalType.TIMESTAMP)//timestamp significa que quero armazenar no banco data, hora e minuto 
	private Date creationDate;
	
	@Column(length = 12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;
	
	@ManyToOne //vários pedidos para 1 usuário
	@JoinColumn(name = "owner_id", nullable = false)//chave estrangeira do usuário.
	private User owner;
	
	@OneToMany(mappedBy = "request") //um pedido pode ter vários estágios.MAPPEDBY é para pegar como foi declarado na classe REQUESTSTAGE
	private List<RequestStage> stages = new ArrayList<RequestStage>();
}
