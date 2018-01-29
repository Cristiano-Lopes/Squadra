package br.com.squadra.segurancadigital.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "sistema")
public class Sistema {

	private Long id;
	private String descricao;
	private String sigla;
	private String email;
	private String url;
	private Status status;
	private LocalDate dataAlteracao;
	private String justificativaAlteracao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL) // So vai ser retornado para o JSON se for diferente de null
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	@NotEmpty(message = "Dados obrigatórios não informados.")
	@JsonInclude(Include.NON_NULL) // So vai ser retornado para o JSON se for diferente null
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(nullable = false, length = 10)
	@NotEmpty(message = "Dados obrigatórios não informados.")
	@JsonInclude(Include.NON_NULL) // So vai ser retornado para o JSON se for diferente de null
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Email
	@JsonInclude(Include.NON_NULL) // So vai ser retornado para o JSON se for diferente de null
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 50)
	@JsonInclude(Include.NON_NULL) // So vai ser retornado para o JSON se for diferente de null
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@JsonInclude(Include.NON_NULL) // So vai ser retornado para o JSON se for diferente de null
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "data_alteracao")
	@JsonInclude(Include.NON_NULL) // So vai ser retornado para o JSON se for diferente de null
	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Column(name = "justificativa_alteracao", columnDefinition = "text")
	@JsonInclude(Include.NON_NULL) // So vai ser retornado para o JSON se for diferente de null
	public String getJustificativaAlteracao() {
		return justificativaAlteracao;
	}

	public void setJustificativaAlteracao(String justificativaAlteracao) {
		this.justificativaAlteracao = justificativaAlteracao;
	}
}
