package exemplo.seguranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import exemplo.seguranca.dtos.CheckInDTO;
import exemplo.seguranca.repositorios.LivroRepository;
import exemplo.seguranca.servicos.LivroService;

@RestController
public class EmprestimoController {
	
	
	@Autowired
	private LivroService livroService; 
	
	@PostMapping("emprestimos")
	public ResponseEntity<CheckInDTO> fazercheckout(@PathVariable CheckInDTO checkInDTO){
		return livroService.fazercheckout(checkInDTO);
	}
	
	@PutMapping("/emprestimos/{id}")
	public ResponseEntity<CheckInDTO> fazercheckin(@PathVariable Long id){
		return livroService.fazercheckin(id);
	}

}
