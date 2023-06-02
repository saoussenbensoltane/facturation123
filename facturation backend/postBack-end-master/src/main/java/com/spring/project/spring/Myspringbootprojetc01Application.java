package com.spring.project.spring;

import com.spring.project.spring.dto.DirectionAchatDto;
import com.spring.project.spring.dto.RegionDto;
import com.spring.project.spring.dto.TypeAchatDto;
import com.spring.project.spring.entities.Role;
import com.spring.project.spring.entities.TypeAchat;
import com.spring.project.spring.services.OrdonnateurService;
import com.spring.project.spring.services.RegionService;
import com.spring.project.spring.services.TypeAchatService;
import com.spring.project.spring.services.impl.DirectionAchatService;
import com.spring.project.spring.services.impl.NatureProjetService;
import com.spring.project.spring.services.impl.RoleServiceImpl;
import org.modelmapper.ModelMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class Myspringbootprojetc01Application {

	public static void main(String[] args) {
		SpringApplication.run(Myspringbootprojetc01Application.class, args);
	}

	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(NatureProjetService natureProjetService, DirectionAchatService directionAchatService, TypeAchatService typeAchatService, RegionService regionService, RoleServiceImpl roleService, OrdonnateurService ordonnateurService){
		return args -> {

//			typeAchatSee.addNewRole(new Role(null, "Ordonnarvice.addTypeAchat(new TypeAchatDto(null, "informatique"));
////			typeAchatService.addTypeAchat(new TypeAchatDto(null, "divers"));
////			typeAchatService.addTypeAchat(new TypeAchatDto(null, "batiment et travaux"));
////
////			directionAchatService.addDirectionAchat(new DirectionAchatDto(null, "Direction d'achat divers"));
////			directionAchatService.addDirectionAchat(new DirectionAchatDto(null, "direction d'achat informatique"));
////			directionAchatService.addDirectionAchat(new DirectionAchatDto(null, "Direction d'achat de travaux et batiment"));
////			directionAchatService.addDirectionAchat(new DirectionAchatDto(null, "direction de planification et budget"));
////			regionService.addRegion(new RegionDto(null, "Tunis"));
////			regionService.addRegion(new RegionDto(null, "Monastir"));
////
////			typeAchatService.addTypeAchat(new TypeAchatDto(null, "divers"));
////			typeAchatService.addTypeAchat(new TypeAchatDto(null, "batiment et travaux"));
////			typeAchatService.addTypeAchat(new TypeAchatDto(null, "informatique"));
////
////			roleService.addNewRole(new Role(null, "Direction d'achat divers"));
////			roleService.addNewRole(new Role(null, "direction d'achat informatique"));
////			roleService.addNewRole(new Role(null, "Direction d'achat de travaux et batiment"));
////			roleService.addNewRole(new Role(null, "ADMINISTRATEUR"));
////			roleService.addNewRole(new Role(null, "direction de planification et budget"));
////			roleServicteur"));
		};
	}

	@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:4201"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept",
				"Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origine", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
