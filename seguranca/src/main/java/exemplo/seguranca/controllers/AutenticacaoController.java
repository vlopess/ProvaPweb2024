package exemplo.seguranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exemplo.seguranca.dtos.DadosAutenticacao;
import exemplo.seguranca.dtos.DadosTokenJWT;
import exemplo.seguranca.entidades.Usuario;
import exemplo.seguranca.servicos.JWTokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JWTokenService tokenService;
	
	
	
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody DadosAutenticacao dados) {
		System.out.println(dados);
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        System.out.println(authentication);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
		System.out.println(tokenJWT);

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
