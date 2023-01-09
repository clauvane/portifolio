package br.com.clauvane.desafio.portifolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
@EnableAutoConfiguration
public class PortifolioApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PortifolioApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PortifolioApplication.class);
	}

	@GetMapping
	public ModelAndView home() {
		return new ModelAndView("redirect:/home");
	}

	@GetMapping("/")
	public ModelAndView home2() {
		return new ModelAndView("redirect:/home");
	}

}
