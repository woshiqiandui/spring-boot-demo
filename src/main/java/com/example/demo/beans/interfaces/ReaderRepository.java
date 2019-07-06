package com.example.demo.beans.interfaces;

import com.example.demo.beans.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,String> {
}
