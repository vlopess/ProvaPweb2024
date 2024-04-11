package exemplo.seguranca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exemplo.seguranca.dtos.CheckInDTO;
import exemplo.seguranca.dtos.LivroDTO;
import exemplo.seguranca.servicos.LivroService;

@RestController
public class LivroController {
	final private LivroService livroService;
	
	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}
	
	@PostMapping("/cadastrar")	
	public ResponseEntity<LivroDTO> cadastrar(@RequestBody LivroDTO livroDTO){
		return livroService.cadastrar(livroDTO);
	}
	
	
	
	@GetMapping("/livros")
	public ResponseEntity<List<LivroDTO>> getAllLivros(){
		return livroService.getAllLivros();
	}
	
	@GetMapping("/livros/{titulo}")
	public ResponseEntity<List<LivroDTO>> detalharLivro(@PathVariable String titulo){
		System.out.println(titulo);
		return livroService.detalharLivro(titulo);
	}

}
