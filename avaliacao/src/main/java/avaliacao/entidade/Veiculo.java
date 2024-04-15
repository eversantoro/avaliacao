package avaliacao.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Ever Santoro
 * Classe responsavel pelo mapeamento objeto relacional do Veiculo
 */
@Entity
@Table(name="veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 3631328751651244663L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id")
	private Long id;
	
	@Column(name="modelo")
	@NotNull
	@Size(min=1, max=100)
	private String modelo;	
	
	@Column(name="marca")
	@Size(min=1, max=100)
	private String marca;	

	@Column(name="placa")
	@NotNull
	@Size(min=1, max=12)
	private String placa;	
		
	@Column(name="fabricacao")
	@Temporal(TemporalType.DATE)
	private Date fabricacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", placa=" + placa + ", fabricacao="
				+ fabricacao + "]";
	}	
	
	
	
	
}
