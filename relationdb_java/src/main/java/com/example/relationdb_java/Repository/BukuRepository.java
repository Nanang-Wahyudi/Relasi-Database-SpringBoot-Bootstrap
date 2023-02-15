package com.example.relationdb_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.relationdb_java.Entity.Buku;

public interface BukuRepository extends JpaRepository<Buku, Integer> {

}
