package com.mulheres.mulheres_do_brasil.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mulheres.mulheres_do_brasil.entities.Institution;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer>{

}
