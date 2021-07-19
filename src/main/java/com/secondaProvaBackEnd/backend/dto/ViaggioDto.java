package com.secondaProvaBackEnd.backend.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViaggioDto {
	private int id;
	private String titolo;
	private Date dataPartenza;
	private Date dataArrivo;
	private String luogo;
}
