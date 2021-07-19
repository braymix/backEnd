package com.secondaProvaBackEnd.backend.services.interfaces;

import java.util.List;

import com.secondaProvaBackEnd.backend.dto.ViaggioDto;

public interface ViaggioI {

	List<ViaggioDto> findAll();
	
}
