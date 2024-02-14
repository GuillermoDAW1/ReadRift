package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Review;
import com.proyecto.ReadRift.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Puedes agregar más métodos de servicio según sea necesario
}