package com.secondaProvaBackEnd.backend.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.secondaProvaBackEnd.backend.dto.ViaggioDto;

import lombok.Data;

@Entity
@Table(name = "Viaggio")
@Data
public class ViaggioDao {
	@Id
	@Column(name = "Id")
	private int id;

	@Column(name = "Titolo")
	private String titolo;
	
	@Column(name = "DataPartenza")
	private Date dataPartenza;
	
	@Column(name = "DataArrivo")
	private Date dataArrivo;
	
	@Column(name = "Luogo")
	private String luogo;

	public ViaggioDto convertToDto() {
		ViaggioDto dto = new ViaggioDto(id,titolo,dataPartenza,dataArrivo,luogo);
		return dto;
	}
}
