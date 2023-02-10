package org.iesch.ad.demoSeguridad.controler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@Slf4j
public class SaludoControler {

    @GetMapping("mensaje")
    public ResponseEntity<?> saluda(){

        var auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Usuario: {}", auth.getName());
        log.info("Roles: {}", auth.getAuthorities());
        log.info("Esta autenticado: {}", auth.isAuthenticated());
        //Crea un Json que salude
        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("mensaje", "Hola mundo");
        return ResponseEntity.ok(mensaje);
//        return ResponseEntity.ok("Hola mundo");



    }
}
