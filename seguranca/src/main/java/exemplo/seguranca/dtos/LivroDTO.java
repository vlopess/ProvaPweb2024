package exemplo.seguranca.dtos;

import exemplo.seguranca.entidades.Livro;
import jakarta.validation.constraints.NotNull;

public record LivroDTO(Long id, 
		@NotNull String titulo, 
		@NotNull String autor) {
	
	public LivroDTO(Livro livro) {
		this(livro.getId(), livro.getTitulo(), livro.getAutor());
	}

}
