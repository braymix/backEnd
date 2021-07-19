package com.secondaProvaBackEnd.backend.dto;
import java.util.List;

import com.secondaProvaBackEnd.backend.dao.TappaDao;
import com.secondaProvaBackEnd.backend.dao.ViaggioDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespDettaglioDto {
	private TappaDto tappaOBJ;
	private List<PacchettoDto> pacchettoObj;
}
