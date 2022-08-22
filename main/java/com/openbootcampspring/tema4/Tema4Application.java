package com.openbootcampspring.tema4;

import com.openbootcampspring.tema4.entities.Book;
import com.openbootcampspring.tema4.entities.Laptop;
import com.openbootcampspring.tema4.repository.BookRepository;
import com.openbootcampspring.tema4.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Tema4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Tema4Application.class, args);
		BookRepository repository = context.getBean(BookRepository.class);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Book book1 = new Book(null, "libro1","tuma", 500, 29.99, LocalDate.of(2018, 12, 1), true);
		Book book2 = new Book(null, "libro2","tuma2", 600, 29.99, LocalDate.of(2018, 12, 1), true);
		Laptop laptop = new Laptop(null, "laptop1", "16gb RAM");
		repository.save(book1);
		repository.save(book2);
		laptopRepository.save(laptop);
		laptopRepository.save(laptop);

		//System.out.println("num libros en base de datos " + repository.findAll().size());


	}

}
