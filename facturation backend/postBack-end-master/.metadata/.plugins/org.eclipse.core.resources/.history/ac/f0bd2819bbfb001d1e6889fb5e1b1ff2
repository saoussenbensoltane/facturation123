package com.app.security.services;

import java.math.BigDecimal;


import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.models.Convention;
import com.app.models.Facture;
import com.app.models.User;
import com.app.repository.ConventionRepository;
import com.app.repository.FactureRepository;
import com.app.repository.UserRepository;

import payload.dto.FactureDto;

@Service
public class FactureService {
	@Autowired
	private final FactureRepository factureRepository;
	@Autowired
    private final UserService userService;
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final ConventionRepository conventionRepository;
	
	@Autowired
	public FactureService(FactureRepository factureRepository, UserService userService, UserRepository userRepository, ConventionRepository conventionRepository) {
	    this.factureRepository = factureRepository;
	    this.userService = userService;
	    this.userRepository = userRepository;
	    this.conventionRepository = conventionRepository;
	}
	 
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
		        sendFactureDueDateEmail(facture);
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
	 
	 public void sendFactureDueDateEmail(Facture facture) {
		    final String fromEmail = "asma1bargaoui@gmail.com";
		    final String password = "vahorraxvibbpedx";
		    
		    String to = facture.getConvention().getUser().getEmail();
		    String subject = "Facture Due Date Reminder";
		    String text = "Dear " + facture.getConvention().getUser().getUsername() + ",\n\n"
		            + "This is a reminder that your facture for convention " + facture.getConvention().getId()
		            + " is due on " + facture.getDueDatefct() + ". Please make sure to submit your payment before the due date.\n\n"
		            + "Best regards,\n CompanyName";

		    Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");
		    
		    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(fromEmail, password);
		        }
		    });

		    try {
		        MimeMessage message = new MimeMessage(session);
		        message.setFrom(new InternetAddress(fromEmail));
		        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		        message.setSubject(subject);
		        message.setText(text);
		        
		        Transport.send(message);
		        System.out.println("Email sent successfully to " + to);
		    } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    } } 
		    @Scheduled(cron = "0 15 16 * * *")
			 public void sendFactureDueDateEmails() {
			     LocalDate today = LocalDate.now();
			     List<Facture> factures = factureRepository.findByDueDatefct(today);

			     for (Facture facture : factures) {
			         sendFactureDueDateEmail(facture); 
			     }
	 }
		    
		    public List<Facture> getFacturesByUserConvention(UserDetails userDetails) {
		        String username = userDetails.getUsername();

		        User user = userRepository.findByUsername(username)
		                .orElseThrow();

		        List<Convention> conventions = conventionRepository.findByUserId(user.getId());
		        if (conventions.isEmpty()) {
		            throw new RuntimeException("Conventions not found for the user");
		        }
		        
		        List<Facture> factures = new ArrayList<>();
		        for (Convention convention : conventions) {
		            List<Facture> conventionFactures = factureRepository.findByConvention(convention);
		            factures.addAll(conventionFactures);
		        }
		        
		        return factures;
		    }
		    
		    
		
	 }
