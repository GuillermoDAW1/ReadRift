package com.proyecto.ReadRift.repositories;

import com.proyecto.ReadRift.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}