package com.app.security.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.models.Convention;
import com.app.models.Facture;
import com.app.repository.FactureRepository;

@Service
public class FactureService {
	
	 @Autowired
	    private FactureRepository factureRepository;
	 
	 public List<Facture> createFacturesForConvention(Convention convention) {
		    List<Facture> factures = new ArrayList<>();
		    LocalDate startDate = convention.getDateSignature();
		    LocalDate endDate = convention.getDueDate();
		    BigDecimal totalAmount = convention.getTotalAmount();
		    int periodMonths = 6;
		    int numberOfPeriods = (int) ChronoUnit.MONTHS.between(startDate, endDate) / periodMonths;
		    BigDecimal amountPerPeriod = totalAmount.divide(BigDecimal.valueOf(numberOfPeriods), 2, RoundingMode.HALF_UP);

		    for (int i = 0; i < numberOfPeriods; i++) {
		        LocalDate dueDate = startDate.plusMonths(periodMonths);
		        if (dueDate.isAfter(endDate)) {
		            dueDate = endDate;
		        }
		        Facture facture = new Facture();
		        facture.setConvention(convention);
		        facture.setStructure(convention.getStructure());
		        facture.setDueDatefct(dueDate);
		        facture.setAmount(amountPerPeriod);
		        facture.setPeriod(startDate + " - " + dueDate); 
		        facture.setStatus("PENDING");
		        factures.add(facture);
		        startDate = startDate.plusMonths(periodMonths);
		    }

		    factureRepository.saveAll(factures);
		    return factures;
		}
	 public void markFactureAsPaid(Long factureId) {
		    Facture facture = factureRepository.findById(factureId)
		    		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "facture not found"));

		    facture.setStatus("PAID");
		    factureRepository.save(facture);
		}
}
