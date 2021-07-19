package com.secondaProvaBackEnd.backend.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.secondaProvaBackEnd.backend.dto.PacchettoDto;

import lombok.Data;

@Entity
@Table(name = "Pacchetto")
@Data
public class PacchettoDao {

	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Titolo")
	private String titolo;
	
	@Column(name = "idTappa")
	private int tappa;

	@ManyToOne
    @JoinColumn(name="idTappa",nullable=false,insertable=false, updatable=false)
	private TappaDao tappaOBJ;

	public PacchettoDto convertToDto() {
		PacchettoDto dto = new PacchettoDto(id,titolo,tappa,tappaOBJ);
		return dto;
	}
}
