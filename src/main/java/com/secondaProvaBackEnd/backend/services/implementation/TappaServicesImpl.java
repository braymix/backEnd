package com.secondaProvaBackEnd.backend.services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondaProvaBackEnd.backend.dao.TappaDao;
import com.secondaProvaBackEnd.backend.dto.TappaDto;
import com.secondaProvaBackEnd.backend.repository.TappaRepository;
import com.secondaProvaBackEnd.backend.services.interfaces.TappaI;
@Service
@Transactional
public class TappaServicesImpl implements TappaI {

	@Autowired
	public TappaRepository tappaRepository;
	/*questa funzione fa in modo che dato un id di un determinato viaggio mi ritorni tutte le tappe di quel viaggio 
	 * in ordine sempre crescente per data della tappa*/
	@Override
	public List<TappaDto> getTappaByIdViaggio(int idViaggio) {
		List<TappaDto> list = new ArrayList<>();
		try {
			for (TappaDao prodotti : tappaRepository.findAllByIdViaggioOrderByDataTappa(idViaggio)) {
				list.add(prodotti.convertToDto());
			}
		} catch (Exception e) {
			return null;
		}
		return list;
	}

}
