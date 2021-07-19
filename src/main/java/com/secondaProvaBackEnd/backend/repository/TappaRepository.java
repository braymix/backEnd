package com.secondaProvaBackEnd.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondaProvaBackEnd.backend.dao.TappaDao;

public interface TappaRepository extends JpaRepository<TappaDao, Integer> {
	
	List<TappaDao> findAllByIdViaggioOrderByDataTappa(int idViaggio);

}
