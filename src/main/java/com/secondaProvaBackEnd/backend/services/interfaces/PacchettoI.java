package com.secondaProvaBackEnd.backend.services.interfaces;

import java.util.List;

import com.secondaProvaBackEnd.backend.dto.PacchettoDto;
import com.secondaProvaBackEnd.backend.dto.TappaDto;

public interface PacchettoI {
	List<PacchettoDto> getTappaByIdTappa(int idTappa);
}
