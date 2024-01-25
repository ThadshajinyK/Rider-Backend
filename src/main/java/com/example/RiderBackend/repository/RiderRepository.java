package com.example.RiderBackend.repository;

import com.example.RiderBackend.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {

}
