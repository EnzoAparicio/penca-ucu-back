package uy.edu.ucu.pencaucu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ucu.pencaucu.dto.EstadioDTO;
import uy.edu.ucu.pencaucu.service.IEstadioService;
import uy.edu.ucu.pencaucu.util.ResponseUtil;

@RestController
public class EstadioController {

	@Autowired
	IEstadioService iEstadioService;

	@GetMapping("/estadio/getAll")
	public ResponseEntity<List<EstadioDTO>> getAllEstadio() {
		try {
			List<EstadioDTO> estadioDTOList = iEstadioService.getAllEstadio();
			if (!estadioDTOList.isEmpty()) {
				return ResponseUtil.okResponse(estadioDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
}
