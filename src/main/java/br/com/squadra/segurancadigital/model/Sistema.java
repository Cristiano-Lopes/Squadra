package br.com.squadra.segurancadigital.model;

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

@Entity
public class Sistema implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String sigla;
	private String emailAtendimentoSistema;
	private String url;
	private Date ultimaAlteracao;
	private String justificativaUltimaAlteracao;
	private String novaJustificativa;
	private Status statusSistema;
	private Usuario usuario;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(nullable = false, length = 10)
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Column(name = "email_de_atendimento_do_sistema", length = 100)
	public String getEmailAtendimentoSistema() {
		return emailAtendimentoSistema;
	}

	public void setEmailAtendimentoSistema(String emailAtendimentoSistema) {
		this.emailAtendimentoSistema = emailAtendimentoSistema;
	}

	@Column(length = 50)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_da_ultima_alteracao", nullable = false)
	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	@Column(name = "justificativa_da_ultima_alteracao", length = 500)
	public String getJustificativaUltimaAlteracao() {
		return justificativaUltimaAlteracao;
	}

	public void setJustificativaUltimaAlteracao(String justificativaUltimaAlteracao) {
		this.justificativaUltimaAlteracao = justificativaUltimaAlteracao;
	}

	@Column(name = "nova_justificativa_de_alteracao", length = 500, nullable = false)
	public String getNovaJustificativa() {
		return novaJustificativa;
	}

	public void setNovaJustificativa(String novaJustificativa) {
		this.novaJustificativa = novaJustificativa;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "status_do_sistema", nullable = false, length = 11)
	public Status getStatusSistema() {
		return statusSistema;
	}

	public void setStatusSistema(Status statusSistema) {
		this.statusSistema = statusSistema;
	}

	@ManyToOne
	@JoinColumn(nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
