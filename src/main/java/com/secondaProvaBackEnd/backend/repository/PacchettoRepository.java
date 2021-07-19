package com.secondaProvaBackEnd.backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.secondaProvaBackEnd.backend.dao.PacchettoDao;
import com.secondaProvaBackEnd.backend.dao.TappaDao;

public interface PacchettoRepository extends JpaRepository<PacchettoDao, Integer> {

	@Query(value="Select * from Pacchetto where IdTappa = ?1",nativeQuery=true)
	List<PacchettoDao> findByIdTappa(int idTappa);
}
