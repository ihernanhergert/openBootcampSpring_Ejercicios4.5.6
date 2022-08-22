package com.openbootcampspring.tema4.repository;

import com.openbootcampspring.tema4.entities.Book;
import com.openbootcampspring.tema4.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}