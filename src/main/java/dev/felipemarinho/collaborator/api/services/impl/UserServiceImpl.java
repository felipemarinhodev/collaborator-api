package dev.felipemarinho.collaborator.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.felipemarinho.collaborator.api.entities.User;
import dev.felipemarinho.collaborator.api.repositories.UserRepository;
import dev.felipemarinho.collaborator.api.services.UserService;
import dev.felipemarinho.collaborator.api.utils.PasswordUtils;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRespository;
	
	@Override
	public Optional<User> buscarPorEmail(String email) {
		log.info("Buscando usuário por E-mail {}", email);
		return Optional.ofNullable(this.userRespository.findByEmail(email));
	}

	@Override
	public Optional<User> buscarPorId(Long id) {
		log.info("Buscando usuário por id {}", id);
		return this.userRespository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRespository.findAll();
	}

	@Override
	public User save(User user) {
		String bCryptPassword = PasswordUtils.buildBcrypt(user.getPassword());
		user.setPassword(bCryptPassword);
		return this.userRespository.save(user);
	}

	
	
}
