package com.everis.mvc.bmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.mvc.bmt.dto.CriacaoPedido;
import com.everis.mvc.bmt.model.Pedido;
import com.everis.mvc.bmt.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(CriacaoPedido criacaoPedido) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid CriacaoPedido criacaoPedido, BindingResult result) {
		if (result.hasErrors()) {
			return "pedido/formulario";
		}
		Pedido pedido = criacaoPedido.toPedido();
		pedidoRepository.save(pedido);
		return "pedido/formulario";
	}

}
