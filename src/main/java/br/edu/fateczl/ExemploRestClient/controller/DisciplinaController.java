package br.edu.fateczl.ExemploRestClient.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fateczl.ExemploRestClient.consumer.DisciplinaConsumer;
import br.edu.fateczl.ExemploRestClient.model.Disciplina;

@Controller
public class DisciplinaController {

	@Autowired
	DisciplinaConsumer dCons;

	// POST
	@RequestMapping(name = "disciplina", value = "/disciplina", method = RequestMethod.POST)
	public ModelAndView op(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String codigo = allRequestParam.get("codigo");
		String nome = allRequestParam.get("nome");
		String button = allRequestParam.get("button");

		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		Disciplina d = new Disciplina();
		String erro = "";
		String saida = "";

		try {
			if (button.equals("Listar")) {
				disciplinas = dCons.findAll();
			} else {
				d.setCodigo(Integer.parseInt(codigo));
				d.setNome(nome);

				if (button.equals("Buscar")) {
					d = dCons.findOne(d);
				}
				if (button.equals("Cadastrar")) {
					saida = dCons.save(d);
				}
				if (button.equals("Atualizar")) {
					saida = dCons.modify(d);
				}
				if (button.equals("Excluir")) {
					saida = dCons.delete(d);
				}

			}
			if (button.equals("Listar")) {
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			model.addAttribute("disciplinas", disciplinas);
			model.addAttribute("disciplina", d);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		return new ModelAndView("index");
	}

}
