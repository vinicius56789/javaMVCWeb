package com.everis.mvc.bmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.mvc.bmt.dto.CriacaoPedido;
import com.everis.mvc.bmt.model.Pedido;
import com.everis.mvc.bmt.model.User;
import com.everis.mvc.bmt.repository.PedidoRepository;
import com.everis.mvc.bmt.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping("formulario")
	public String formulario(CriacaoPedido criacaoPedido) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid CriacaoPedido criacaoPedido, BindingResult result) {
		if (result.hasErrors()) {
			return "pedido/formulario";
		}
		String username = SecurityContextHolder.getContext().getAuthentication().getName(); // busca nome do usuario
		User user = UserRepository.findByUsername(username); // encontra o user no db pelo nome
		Pedido pedido = criacaoPedido.toPedido();
		pedido.setUser(user); // set do usuario no pedido
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}

}
