package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HolaMundoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoApplication.class, args);
	}
	
	@RestController
	class HolaMundoController{
		@GetMapping("/hola")
		public String holaMundo() {
			
			return "Hola Mundo con spring!";
		}
	}
	
	@RestController
    @CrossOrigin(origins = "http://localhost:5173")
    class CalculadoraController {

        @GetMapping("/calculadora/sumar")
        public int sumar(@RequestParam("a") int a, @RequestParam("b") int b) {
            return a + b;
        }

        @GetMapping("/calculadora/restar")
        public int restar(@RequestParam("a") int a, @RequestParam("b") int b) {
            return a - b;
        }

        @GetMapping("/calculadora/multiplicar")
        public int multiplicar(@RequestParam("a") int a, @RequestParam("b") int b) {
            return a * b;
        }

        @GetMapping("/calculadora/dividir")
        public int dividir(@RequestParam("a") int a, @RequestParam("b") int b) {
            if (b == 0) {
                throw new ArithmeticException("No se puede dividir por cero");
            }
            return a / b;
        }
    }

}
