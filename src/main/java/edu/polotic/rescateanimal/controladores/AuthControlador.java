package edu.polotic.rescateanimal.controladores;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.polotic.rescateanimal.dto.RegistroDto;
import edu.polotic.rescateanimal.entidades.Usuario;
import edu.polotic.rescateanimal.repositorios.RolRepositorio;
import edu.polotic.rescateanimal.repositorios.UsuarioRepositorio;


@Controller
public class AuthControlador {
    
    @Autowired
    private BCryptPasswordEncoder codificador;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
 

    @GetMapping("/login")
    public ModelAndView showLoginForm(Model model, 
        @RequestParam(name = "error", required = false) String error,
        @RequestParam(name="logout", required = false) String logout) {
            
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Iniciar sesión");
        maw.addObject("vista", "auth/login");
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        return maw;
    }

    @GetMapping({"/loginSuccess"})
    public RedirectView loginCheck(){
        return new RedirectView("/");
    }
    
    @GetMapping("/registro")
	public ModelAndView registro(RegistroDto registroDto)
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Registrarse");
        maw.addObject("vista", "auth/registro");
        maw.addObject("registroDto", registroDto);
        return maw;
	}

	@PostMapping("/registro")
	public ModelAndView registrar(@RequestParam @Valid RegistroDto registroDto, BindingResult br, RedirectAttributes ra, HttpServletRequest request)
    {
    
          if ( br.hasErrors() ) {
			return this.registro(registroDto);
		}

        Usuario u = new Usuario();
        u.setEmail(registroDto.getEmail());
        u.setPassword(codificador.encode(registroDto.getPassword()));
        u.setRol(rolRepositorio.findByNombre("Usuario").orElseThrow(() -> new IllegalArgumentException("Error al crear usuario")));

		usuarioRepositorio.save(u);

        try {
            request.login(registroDto.getEmail(), registroDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }

        HomeControlador hc = new HomeControlador();
        return hc.home();
	}

}