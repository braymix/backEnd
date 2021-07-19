package com.secondaProvaBackEnd.backend.services.interfaces;

import java.util.List;

import com.secondaProvaBackEnd.backend.dto.TappaDto;

public interface TappaI {

	List<TappaDto> getTappaByIdViaggio(int idViaggio);
}
