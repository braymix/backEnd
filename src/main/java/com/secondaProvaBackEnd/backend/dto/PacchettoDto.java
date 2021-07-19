package com.secondaProvaBackEnd.backend.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.secondaProvaBackEnd.backend.dao.TappaDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacchettoDto {

	private int id;
	private String titolo;
	private int tappa;
}
