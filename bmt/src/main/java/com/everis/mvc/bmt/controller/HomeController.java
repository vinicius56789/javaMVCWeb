package com.everis.mvc.bmt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.everis.mvc.bmt.model.Pedido;
import com.everis.mvc.bmt.model.StatusPedido;
import com.everis.mvc.bmt.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model) {
		Sort sort = Sort.by("DataEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort); // trás os 10 primeiros itens
		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO, paginacao);
		model.addAttribute("pedidos" , pedidos);
		return "home";
	}
}
