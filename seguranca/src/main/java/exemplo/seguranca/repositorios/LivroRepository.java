package exemplo.seguranca.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exemplo.seguranca.entidades.Livro;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	public List<Livro> findAllByTitulo(String titulo);
	public Optional<Livro> findById(Long id);

}
