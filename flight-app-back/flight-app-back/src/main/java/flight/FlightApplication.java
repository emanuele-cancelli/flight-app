package flight;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightApplication {
	
	// used in FlightController class
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
    public static void main(String[] args) {
    	SpringApplication.run(FlightApplication.class, args);   
    }
}