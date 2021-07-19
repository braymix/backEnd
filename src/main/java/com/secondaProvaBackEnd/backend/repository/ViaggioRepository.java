package com.secondaProvaBackEnd.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.secondaProvaBackEnd.backend.dao.ViaggioDao;

public interface ViaggioRepository extends JpaRepository<ViaggioDao, Integer> {

	@Query(value="SELECT * FROM Viaggio \r\n" + 
			"ORDER BY DataPartenza", nativeQuery=true)
	List<ViaggioDao> fatchAllOrderByDataPartenza();
}
