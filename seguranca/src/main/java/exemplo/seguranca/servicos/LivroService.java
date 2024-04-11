package exemplo.seguranca.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exemplo.seguranca.dtos.CheckInDTO;
import exemplo.seguranca.dtos.LivroDTO;
import exemplo.seguranca.entidades.Livro;
import exemplo.seguranca.repositorios.LivroRepository;

@Service
public class LivroService {
	final private LivroRepository livroRepository;
	
	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public ResponseEntity<LivroDTO> cadastrar(LivroDTO livroDTO){
		var newLivro = new Livro(livroDTO);
		livroRepository.save(newLivro);
		return ResponseEntity.ok(livroDTO);
	}
	
	public ResponseEntity<List<LivroDTO>> getAllLivros(){
		return ResponseEntity.ok(livroRepository.findAll().stream().map(LivroDTO::new).toList());
	}
	
	public ResponseEntity<List<LivroDTO>> detalharLivro(String titulo){
		var livro = livroRepository.findAllByTitulo(titulo).stream().map(LivroDTO::new).toList();		
		return ResponseEntity.ok(livro);
	}
	
	public ResponseEntity<CheckInDTO> fazercheckin(Long id){
		//var livro = livroRepository.findByID(id);		
		return ResponseEntity.ok(new CheckInDTO("devolvido"));
	}
	
	public ResponseEntity<CheckInDTO> fazercheckout(CheckInDTO checkInDTO){
		//var livro = livroRepository.save(checkInDTO);		
		return ResponseEntity.ok(new CheckInDTO("devolvido"));
	}
}
