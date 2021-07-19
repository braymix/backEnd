package com.secondaProvaBackEnd.backend.dto;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.secondaProvaBackEnd.backend.dao.ViaggioDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TappaDto {
	private int id;
	private String luogo;
	private Date dataTappa;
	private int idViaggio;
	private ViaggioDao viaggioOBJ;
}
