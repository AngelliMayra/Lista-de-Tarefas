package br.com.todo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tarefas")
public class Tarefa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String tituloTarefa;

	@Column(nullable = false, length = 100)
	private String descricaoTarefa;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false, length = 100)
	private Date dataConclusaoTarefa;

	public Tarefa() {
	}

	public Tarefa(Long id, String tituloTarefa, String descricaoTarefa, Date dataConclusaoTarefa) {
		super();
		this.id = id;
		this.tituloTarefa = tituloTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataConclusaoTarefa = dataConclusaoTarefa;
	}

	public String getTituloTarefa() {
		return tituloTarefa;
	}

	public void setTituloTarefa(String tituloTarefa) {
		this.tituloTarefa = tituloTarefa;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public Date getDataConclusaoTarefa() {
		return dataConclusaoTarefa;
	}

	public void setDataConclusaoTarefa(Date dataConclusaoTarefa) {
		this.dataConclusaoTarefa = dataConclusaoTarefa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}

}
