package com.everis.mvc.bmt.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.everis.mvc.bmt.model.Pedido;
import com.everis.mvc.bmt.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatusPedido(StatusPedido status);

	@Query("SELECT p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);

	@Query("SELECT p from Pedido p join p.user u where u.username = :username and p.statusPedido = :status")
	List<Pedido> findByStatusPedidoEUsuario(@Param("status") StatusPedido status, @Param("username") String username);

	@Cacheable("pedido") // salva última chamada no db precisa ativar no run application
	List<Pedido> findByStatusPedido(StatusPedido status, Pageable paginacao);

}
