package com.isoqualtech.plateformAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;

@SpringBootApplication
public class PlateformApiApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PlateformApiApplication.class, args);
	}
/*	
	@Bean
	public CorsFilter corpsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Acess-Contol-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	*/
	
	@Bean
	public SimpleMailMessage templateSimpleMessage() {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setText(
	      "Secrétariat Commercial\n"
	      + "ISO QUAL TECH sarl \n"
	      + "RESIDENCE ARSSA SALA IMM. 7 APPT. 16 RTE DE KENITRA, 11160, SALE  MAROC\n"
	      + "contact@isoqualtech.com / isoqualtech@gmail.com\n"
	      + "Tél :  +212 668 719 841 \n"
	      + "Fax : +212 537 846 397\n\n"
	      + "\n" );
	    return message;
	}

}
