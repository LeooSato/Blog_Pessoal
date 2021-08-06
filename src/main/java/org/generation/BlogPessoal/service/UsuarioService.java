package org.generation.BlogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.BlogPessoal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.generation.BlogPessoal.model.UsuarioLogin;
import org.generation.BlogPessoal.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario cadastrarUsuario( Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEnconder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEnconder);
		
		return repository.save(usuario);
		
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> usuarioLogin){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(usuarioLogin.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = usuarioLogin.get().getUsuario() + ":" + usuarioLogin.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " +  new String(encodedAuth);
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setToken(authHeader);
				
				
				return  usuarioLogin;
			}
						
		}
		
		return null;
	}
}

