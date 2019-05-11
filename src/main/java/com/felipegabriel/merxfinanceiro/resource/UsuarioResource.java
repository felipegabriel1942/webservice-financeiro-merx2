package com.felipegabriel.merxfinanceiro.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipegabriel.merxfinanceiro.model.Usuario;
import com.felipegabriel.merxfinanceiro.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario){
		try {
			Usuario obj = usuarioService.salvarUsuario(usuario);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuario){
		try {
			Usuario obj = usuarioService.salvarUsuario(usuario);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value = "/{pkUsuario}")
	public ResponseEntity<Void> deletar(@Valid @PathVariable Integer pkUsuario){
		try {
			usuarioService.deletarUsuario(pkUsuario);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "/{pkUsuario}")
	public ResponseEntity<Usuario> buscar(@Valid @PathVariable Integer pkUsuario){
		try {
			Usuario obj = usuarioService.buscarUsuario(pkUsuario);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "/listar/")
	public ResponseEntity<List<Usuario>> listar(){
		try {
			List<Usuario> listObj = usuarioService.listarUsuarios();
			return ResponseEntity.ok(listObj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
