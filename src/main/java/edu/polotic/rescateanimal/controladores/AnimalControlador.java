package edu.polotic.rescateanimal.controladores;

import edu.polotic.rescateanimal.entidades.*;
import edu.polotic.rescateanimal.servicios.*;
import java.io.*;
import java.nio.file.Paths;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("animales")
public class AnimalControlador implements WebMvcConfigurer{
    
    @Autowired
    AnimalServicio animalServicio;

    @PostMapping("/crear")
	public ModelAndView guardar( @Valid  Animal animal, BindingResult br, RedirectAttributes ra)
    {
        animalServicio.save(animal); 
        HomeControlador hc = new HomeControlador();
        ModelAndView maw = hc.home();

        maw.addObject("exito", "Denuncia realizada exitosamente");
		return maw;
	}
}
