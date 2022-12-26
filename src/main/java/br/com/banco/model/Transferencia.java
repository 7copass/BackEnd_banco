package br.com.banco.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.banco.enums.Tipo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "transferencia")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private LocalDate dataTransferencia; 

	private Double valor;

	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(name = "nome_operador_transacao")
	private String nomeOperadorTransacao;

	
	@ManyToOne
	@JoinColumn(name = "CONTA_ID", nullable = false, referencedColumnName = "ID_CONTA",
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_CONTA"))
	private Conta conta_id;

}
