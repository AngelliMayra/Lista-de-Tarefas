package br.com.todo.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.todo.dao.TarefaDAO;
import br.com.todo.model.Tarefa;

@Controller
public class TarefaController {
	
	@Autowired
	private TarefaDAO dao;
	
	@PostMapping(value = "/cadastro")
	public ModelAndView cadastraTarefa(@ModelAttribute Tarefa tarefa) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		ModelAndView view = new ModelAndView("CriarTarefa");
		view.addObject("dateFormat", dateFormat);
	    dao.salvar(tarefa);	    
	    view.addObject("mensagem", "Tarefa cadastrada com sucesso");
	    view.addObject("tarefas", dao.getAll());
	    return view;
	}

	@GetMapping(value = "/cadastro")
	public ModelAndView retornoAposExcluir(@ModelAttribute Tarefa tarefa) {
	    ModelAndView view = new ModelAndView("CriarTarefa");
	    view.addObject("mensagem", "Tarefa cadastrada com sucesso");
	    view.addObject("tarefas", dao.getAll());
	    return view;
	}

	@GetMapping(value = "/excluir/{id}")
	public String excluirTarefa(@PathVariable("id") int id) {
	    dao.excluir(id);
	    return "redirect:/cadastro";
	}

	@GetMapping(value = "/editar/{id}")
	public ModelAndView editarTarefa(@PathVariable("id") int id, Model model) {
	    ModelAndView view = new ModelAndView("EditarTarefas");
	    model.addAttribute("tarefa", dao.getId(id));
	    return view;
	}

	@PostMapping(value="/atualizar/{id}")
	public String updateTarefa(@PathVariable("id") int id, @ModelAttribute Tarefa tarefa) {
	    dao.editar(id, tarefa);
	    return "redirect:/cadastro";
	}

}
