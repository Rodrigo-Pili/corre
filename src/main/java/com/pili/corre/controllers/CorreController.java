package com.pili.corre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pili.corre.model.Corre;
import com.pili.corre.repository.Corres;

@Controller
public class CorreController {
	
	@Autowired
	private Corres corres;

	@GetMapping("/lista")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("index");

		modelAndView.addObject("corres", corres.findAll());
		modelAndView.addObject(new Corre());

		return modelAndView;
	}
	
	@PostMapping("/corres")
	public String salvar(Corre corre) {
		corre.setTotal(corre.calculaTotal(corre.getGramas(), corre.getPreco()));
		
		this.corres.save(corre);
		
		return "redirect:/lista";
	}

}
