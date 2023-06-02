package payload.request;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicatonUpdateRequest {
	@NotBlank
	@Size(max = 20)
	@Column(name = "code")
    @JsonProperty("code")
	private String code;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "libelle")
    @JsonProperty("libelle")
	private String libelle;
	

	
	
	@Column(name = "prix")
    @JsonProperty("prix")
	private BigDecimal prix;


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getPrix() {
		return prix;
	}


	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	
}
