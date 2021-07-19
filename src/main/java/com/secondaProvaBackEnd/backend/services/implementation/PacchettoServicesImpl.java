package com.secondaProvaBackEnd.backend.services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondaProvaBackEnd.backend.dao.PacchettoDao;
import com.secondaProvaBackEnd.backend.dao.TappaDao;
import com.secondaProvaBackEnd.backend.dto.PacchettoDto;
import com.secondaProvaBackEnd.backend.dto.TappaDto;
import com.secondaProvaBackEnd.backend.repository.PacchettoRepository;
import com.secondaProvaBackEnd.backend.repository.TappaRepository;
import com.secondaProvaBackEnd.backend.services.interfaces.PacchettoI;
@Service
@Transactional
public class PacchettoServicesImpl implements PacchettoI {

	@Autowired
	PacchettoRepository pacchettoRepository;
	
	@Override
	public List<PacchettoDto> getTappaByIdTappa(int idTappa) {
		List<PacchettoDto> list = new ArrayList<>();
		try {
			for (PacchettoDao prodotti : pacchettoRepository.findByIdTappa(idTappa)) {
				list.add(prodotti.convertToDto());
			}
		} catch (Exception e) {
			return null;
		}
		return list;
	}

}
