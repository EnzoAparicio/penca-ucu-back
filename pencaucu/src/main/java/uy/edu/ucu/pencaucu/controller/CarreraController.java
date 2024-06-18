package uy.edu.ucu.pencaucu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ucu.pencaucu.dto.CarreraDTO;
import uy.edu.ucu.pencaucu.service.ICarreraService;
import uy.edu.ucu.pencaucu.util.ResponseUtil;

@RestController
public class CarreraController {

	@Autowired
	ICarreraService iCarreraService;
	
	@GetMapping("/carrera/getAll")
	public ResponseEntity<List<CarreraDTO>> getAllCarrera(){
		try {
			List<CarreraDTO> carreraDTOList = iCarreraService.getAllCarrera();
			if (!carreraDTOList.isEmpty()) {
				return ResponseUtil.okResponse(carreraDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
}
