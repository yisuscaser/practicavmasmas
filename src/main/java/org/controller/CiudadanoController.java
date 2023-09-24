package org.controller;

import java.util.Map;

import org.modelo.Ciudadano;
import org.modelo.Domicilio;
import org.service.CiudadanoService;
import org.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CiudadanoController {
	
	@Autowired
	private CiudadanoService service;
	@Autowired
	private DomicilioService serviceDom;

	@RequestMapping(value = "/index")
	public String listCiudadano(Map<String, Object> map) {
		map.put("ciudadano", new Ciudadano());
		map.put("ciudadanoList", service.listCiudadanos());
		return "ciudadanoForm";
	}

	@RequestMapping(value = "/ciudadano/add", method = RequestMethod.POST)
	public String addCiudadano(@ModelAttribute Ciudadano ciudadano, BindingResult result) {
		service.addCiudadano(ciudadano);
		return "redirect:/index";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteCiudadano(@PathVariable("id") int id) {
		service.deleteCiudadano(id);
		return "redirect:/index";
	}

	@RequestMapping(value = "/edit/{id}")
	public String updateCiudadano(@PathVariable("id") int id, Model model) {
		model.addAttribute("ciudadano", service.getCiudadanoById(id));
		model.addAttribute("ciudadanoList", service.listCiudadanos());
		return "ciudadanoForm";
	}
	
	@RequestMapping(value = "/ciudadano/{id}/domicilio")
	public String listDomicilio(@PathVariable("id") int id, Model model, Map<String, Object> map) {
		model.addAttribute("ciudadano", service.getCiudadanoById(id));
		model.addAttribute("domicilio", new Domicilio());
		
		map.put("domicilio", new Domicilio());
		map.put("domicilioList", serviceDom.listDomicilios(service.getCiudadanoById(id)));
		return "domicilioForm";
	}
	
	@RequestMapping(value = "/ciudadano/{id}/domicilio/add", method = RequestMethod.POST)
	public String addDomicilio(@PathVariable("id") int id, @ModelAttribute Domicilio domicilio,  BindingResult result) {
		domicilio.setIDCIUDADANO(id);
		serviceDom.addDomicilio(domicilio);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/domicilio/delete/{id}")
	public String deleteDomicilio(@PathVariable("id") int id) {
		serviceDom.deleteDomicilio(id);
		return "redirect:/index";
	}
}
