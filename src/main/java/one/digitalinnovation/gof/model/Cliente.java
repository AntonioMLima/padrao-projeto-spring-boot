package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne
	private UnidadeFerativativa unidadeFerativativa;

	public void setUnidadeFerativativa(UnidadeFerativativa unidadeFerativativa) {
        this.unidadeFerativativa = unidadeFerativativa;
    }

    public UnidadeFerativativa getUnidadeFerativativa() {
        return unidadeFerativativa;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
