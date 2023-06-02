package payload.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ConventionResponse {
    private String application;
    private String structure;
    private BigDecimal price;
    private String email;
    private BigDecimal nbr_reel;
    private BigDecimal nbr_Min;
    private BigDecimal nbr_Max;
    private BigDecimal totalAmount;
    private LocalDate dateSignature;
    private LocalDate dueDate;
    
    public ConventionResponse(String application, String structure, BigDecimal price,String email, BigDecimal nbr_reel, BigDecimal nbr_Min, BigDecimal nbr_Max, BigDecimal totalAmount,LocalDate dateSignature,LocalDate dueDate) {
        this.application = application;
        this.structure = structure;
        this.price = price;
		this.email=email;
        this.nbr_reel = nbr_reel;
        this.nbr_Min = nbr_Min;
        this.nbr_Max = nbr_Max;
        this.totalAmount = totalAmount;
        this.dateSignature = dateSignature;
        this.dueDate=dueDate;
    }
	
		public String getApplication() {
	        return application;
	    }

	    public void setApplication(String application) {
	        this.application = application;
	    }

	    public String getStructure() {
	        return structure;
	    }

	    public void setStructure(String structure) {
	        this.structure = structure;
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }

	    public void setPrice(BigDecimal price) {
	        this.price = price;
	    }
	    
	    public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public BigDecimal getNbr_reel() {
			return nbr_reel;
		}

		public void setNbr_reel(BigDecimal nbr_reel) {
			this.nbr_reel = nbr_reel;
		}


		public BigDecimal getTotalAmount() {
			return totalAmount;
		}


		public void setTotalAmount(BigDecimal totalAmount) {
			this.totalAmount = totalAmount;
		}


		public BigDecimal getNbr_Min() {
			return nbr_Min;
		}


		public void setNbr_Min(BigDecimal nbr_Min) {
			this.nbr_Min = nbr_Min;
		}


		public BigDecimal getNbr_Max() {
			return nbr_Max;
		}


		public void setNbr_Max(BigDecimal nbr_Max) {
			this.nbr_Max = nbr_Max;
		}

		public LocalDate getDateSignature() {
			return dateSignature;
		}

		public void setDateSignature(LocalDate dateSignature) {
			this.dateSignature = dateSignature;
		}

		public LocalDate getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}


		
		
	
    
    
}
