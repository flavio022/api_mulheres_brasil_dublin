package com.mulheres.mulheres_do_brasil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mulheres.mulheres_do_brasil.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
	
}
