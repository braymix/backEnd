package com.secondaProvaBackEnd.backend.services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondaProvaBackEnd.backend.dao.ViaggioDao;
import com.secondaProvaBackEnd.backend.dto.ViaggioDto;
import com.secondaProvaBackEnd.backend.repository.ViaggioRepository;
import com.secondaProvaBackEnd.backend.services.interfaces.ViaggioI;


@Service
@Transactional
public class ViaggioServicesImpl implements ViaggioI {

	@Autowired
	private ViaggioRepository viaggioRepository;
	/*questa funzione ritorna semplicemente tutti i viaggi in ordine sempre crescente*/
	@Override
	public List<ViaggioDto> findAll() {
		List<ViaggioDto> list = new ArrayList<>();
		try {
			for (ViaggioDao viaggi : viaggioRepository.fatchAllOrderByDataPartenza()) {
				list.add(viaggi.convertToDto());
			}
		} catch (Exception e) {
			return null;
		}
		return list;
	}

}
