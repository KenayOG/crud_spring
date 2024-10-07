package com.example.demo.controller;


import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	// Endpoint para obtner todos los usuarios
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	// Endpoint para insertar un nuevo usuario
	@PostMapping("/usuarios/insert")
	public String insertarUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
			return "Usuario insertado correctamente";
		} catch(Exception e){
			return "Error al insertar el usuario: " + e.getMessage();
		}
	}
	
	// Endpoint para actualizar un usuario
	@PutMapping("/usuarios/update")
	public String actualizarUsuario(@RequestBody Usuario usuario) {
		try {
			if(usuarioRepository.existsById(usuario.getId())) {
				usuarioRepository.save(usuario);
				return "Usuario actualizado correctamente";
			} else {
				return "Usuario no encontrado";
			}
		} catch(Exception e) {
			return "Error al actualizar el usuario: " + e.getMessage();
		}
	}
	
	// Endpoint para eliminar un usuario
	@DeleteMapping("/usuarios/delete")
	public ResponseEntity<String> eliminarUsuario(@RequestParam("id") Long id) {
		try {
			if(usuarioRepository.existsById(id)){
				usuarioRepository.deleteById(id);
				return ResponseEntity.ok("Usuario eliminado correctamente");
			} else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
			}
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error al eliminar el usuario: " + e.getMessage());
		}
	}
	
	
	
}
