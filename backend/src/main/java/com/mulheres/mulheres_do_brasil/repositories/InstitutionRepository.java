package com.mulheres.mulheres_do_brasil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mulheres.mulheres_do_brasil.entities.Institution;

@Service
public interface InstitutionRepository extends JpaRepository<Institution, Integer>{

}
