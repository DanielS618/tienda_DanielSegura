

package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }
@RequestMapping("/informacion") //este es el URL para llamar a la pagina y en el return la pagina que va a mostrar
    public String contacto(Model model) {
        model.addAttribute("attribute", "value");
        return "contacto";
    }
    
}
