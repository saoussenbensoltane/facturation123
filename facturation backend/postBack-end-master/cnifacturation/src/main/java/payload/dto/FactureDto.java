package payload.dto;

import com.app.models.Convention;
import com.app.models.Facture;
import com.app.models.Structure;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
public class FactureDto {
	
   /* private Long id;
    private String convention;
    private String structure;
    private LocalDate dueDatefct;
    private BigDecimal amount;
    private String period;
    private String status;

    public static List<FactureDto> entityToDto(List<Facture> factures) {
        return factures.stream().map(FactureDto::toDto).collect(Collectors.toList());
    }

    public static FactureDto toDto(Facture facture) {
        if (facture == null) {
            return null;
        }

        FactureDto factureDto = new FactureDto();
        factureDto.setId(facture.getId());
        factureDto.setConvention(Long.toString(facture.getConvention().getId()));
        factureDto.setStructure(facture.getStructure().getCode());
        factureDto.setDueDatefct(facture.getDueDatefct());
        factureDto.setAmount(facture.getAmount());
        factureDto.setPeriod(facture.getPeriod());
        factureDto.setStatus(facture.getStatus());

        return factureDto;
    }

    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConvention() {
		return convention;
	}

	public void setConvention(String convention) {
		this.convention = convention;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public LocalDate getDueDatefct() {
		return dueDatefct;
	}

	public void setDueDatefct(LocalDate dueDatefct) {
		this.dueDatefct = dueDatefct;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Optional: Override toString() for better logging or debugging
	@Override
	public String toString() {
	    return "FactureDto{" +
	            "id=" + id +
	            ", dueDatefct=" + dueDatefct +
	            ", amount=" + amount +
	            ", period='" + period + '\'' +
	            ", status='" + status + '\'' +
	            '}';
	}*/
}