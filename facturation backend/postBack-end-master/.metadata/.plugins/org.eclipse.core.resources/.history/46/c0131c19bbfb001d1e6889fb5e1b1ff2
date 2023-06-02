package payload.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ConventionRequest { 
		 
		 @NotBlank(message = "Application code is required")
		 private String application;
		 
		 @NotBlank(message = "Structure code is required")
		 private String structure;
		 
		 @NotNull
		 private BigDecimal nbr_reel;
		 
		 @NotNull
		 private BigDecimal nbr_Min;
		 
		 @NotNull
		 private BigDecimal nbr_Max;
		 
		 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
		 private LocalDate dateSignature;
		 
		 private int conventionDuration;
		 

		public String getStructure() {
			return structure;
		}

		public void setStructure(String structure) {
			this.structure = structure;
		}

		public String getApplication() {
			return application;
		}

		public void setApplication(String application) {
			this.application = application;
		}

		public BigDecimal getNbr_reel() {
			return nbr_reel;
		}

		public void setNbr_reel(BigDecimal nbr_reel) {
			this.nbr_reel = nbr_reel;
		}
		
		

		public LocalDate getDateSignature() {
			return dateSignature;
		}

		public void setDateSignature(LocalDate dateSignature) {
			this.dateSignature = dateSignature;
		}

		
		public int getConventionDuration() {
			return conventionDuration;
		}

		public void setConventionDuration(int conventionDuration) {
			this.conventionDuration = conventionDuration;
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

		public BigDecimal getPrice() {
			// TODO Auto-generated method stub
			return null;
		}


		

		


	    }
  /*  @NotBlank
    private String application;

    @NotBlank
    private String structure;

    @Null
    private BigDecimal nbr_reel;

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

    public BigDecimal getNbr_reel() {
        return nbr_reel;
    }

    public void setNbr_reel(BigDecimal nbr_reel) {
        this.nbr_reel = nbr_reel;
    }

    // Constructor
    public conventionRequest() {
    }

    public conventionRequest(String application, String structure, BigDecimal nbr_reel) {
        this.application = application;
        this.structure = structure;
        this.nbr_reel = nbr_reel;
    }
}*/