package com.secondaProvaBackEnd.backend.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.secondaProvaBackEnd.backend.dto.TappaDto;

import lombok.Data;

@Entity
@Table(name = "Tappa")
@Data
public class TappaDao {
/*questa classe possiede tutti i dati di una tappa, più tappe formano un viaggio*/
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Luogo")
	private String luogo;
	
	@Column(name = "DataTappa")
	private Date dataTappa;
	
	@Column(name = "IdViaggio")
	private int idViaggio;
	
	@ManyToOne
    @JoinColumn(name="IdViaggio",nullable=false,insertable=false, updatable=false)
	private ViaggioDao viaggioOBJ;

	public TappaDto convertToDto() {
		TappaDto dto = new TappaDto(id,luogo,dataTappa,idViaggio,viaggioOBJ);
		return dto;
	}
	
	
}
