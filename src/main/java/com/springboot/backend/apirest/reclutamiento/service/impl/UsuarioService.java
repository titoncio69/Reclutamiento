package com.springboot.backend.apirest.reclutamiento.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.reclutamiento.exception.ModeloNotFoundException;
import com.springboot.backend.apirest.reclutamiento.model.Usuario;
import com.springboot.backend.apirest.reclutamiento.repository.IUsuarioRepository;
import com.springboot.backend.apirest.reclutamiento.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	@Autowired
	private IUsuarioRepository repo;

	@Override
	public Usuario findById(Integer id) throws Exception {
		Optional<Usuario> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Usuario no encontrado " + id);
		}
		return op.get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return repo.findAll();
	}

	@Override
	public Usuario save(Usuario e) {
		return repo.save(e);
	}

	@Override
	public Usuario update(Usuario e) {
		return repo.save(e);
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Usuario> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Usuario no encontrado " + id);
		}
		repo.deleteById(id);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = repo.findByUsername(username);
		if(u == null) {
			throw new UsernameNotFoundException("Usuario no existe : " + username);
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		u.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails userDetail = new User(u.getUsername(), u.getPassword(), roles);
		return userDetail;
	}

}
