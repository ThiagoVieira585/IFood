package br.com.ifce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ifce.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query(value="select CASE WHEN count(1)> 0 THEN 'true' Else 'false' END from cliente where id = :id", nativeQuery=true )
	public boolean exist(int id);
	
	@Query(value="select * from cliente where email = :email and senha= :senha", nativeQuery=true )
	public Cliente Login(String email, String senha);
	
}