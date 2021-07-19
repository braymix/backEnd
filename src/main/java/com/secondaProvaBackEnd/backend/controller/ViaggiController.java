package com.secondaProvaBackEnd.backend.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secondaProvaBackEnd.backend.dto.BaseResponseDto;
import com.secondaProvaBackEnd.backend.dto.PacchettoDto;
import com.secondaProvaBackEnd.backend.dto.RespDettaglioDto;
import com.secondaProvaBackEnd.backend.dto.TappaDto;
import com.secondaProvaBackEnd.backend.dto.ViaggioDto;
import com.secondaProvaBackEnd.backend.services.implementation.PacchettoServicesImpl;
import com.secondaProvaBackEnd.backend.services.implementation.TappaServicesImpl;
import com.secondaProvaBackEnd.backend.services.implementation.ViaggioServicesImpl;

@RestController
@RequestMapping(value = "api/viaggi")
public class ViaggiController {
	/*questo controller mi serve per poter eseguire le chiamate rest*/

	/*qui richiamo i vari services implementation dove ho fatto i metodi di cui ho bisogno*/
	@Autowired
	private ViaggioServicesImpl viaggioServicesImpl;
	
	@Autowired
	private TappaServicesImpl tappaServicesImpl;
	
	@Autowired
	private PacchettoServicesImpl pacchettoServicesImpl;

	/*questo servizio ritorna tutti i viaggi ordinati per ordine di partenza*/
	@GetMapping(path = "getAllViaggi")
	public BaseResponseDto<List<ViaggioDto>> gettAllViaggi() {

		BaseResponseDto<List<ViaggioDto>> response = new BaseResponseDto<List<ViaggioDto>>();
		response.setTimestamp(new Date());

		try {
			response.setResponse(viaggioServicesImpl.findAll());
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("lista di viaggi caricata correttamente");
		} catch (Exception e) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage(""+e);
		}

		return response;
	}
	/*questo servizio mi ritorna tutte le tappe ed i relativi pacchetti di un determinato viaggio*/
	@GetMapping(path = "detDettaglio/{idViaggio}")
	public BaseResponseDto<List<RespDettaglioDto>> getDescrizione(@PathVariable int idViaggio) {

		BaseResponseDto<List<RespDettaglioDto>> response = new BaseResponseDto<List<RespDettaglioDto>>();
		response.setTimestamp(new Date());
		List<RespDettaglioDto> list = new ArrayList<RespDettaglioDto>();
		try {
			
			 List<TappaDto> listTappe = tappaServicesImpl.getTappaByIdViaggio(idViaggio);
			 
			 for(int i = 0 ; i<= listTappe.size()-1;i++ ) {
				 List<PacchettoDto> temp = pacchettoServicesImpl.getTappaByIdTappa(listTappe.get(i).getId());
				 RespDettaglioDto respT = new RespDettaglioDto();
				 respT.setTappaOBJ(listTappe.get(i));
				 respT.setPacchettoObj(temp);
				 list.add(respT);
			 }
					
			response.setResponse(list);
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("lista dettaglio caricata correttamente");
		} catch (Exception e) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage(""+e);
		}

		return response;
	}
}
