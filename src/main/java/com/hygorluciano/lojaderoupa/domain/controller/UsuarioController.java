package com.hygorluciano.lojaderoupa.domain.controller;

import com.hygorluciano.lojaderoupa.domain.dto.usuario.AtualizadoUsuarioDto;
import com.hygorluciano.lojaderoupa.domain.dto.usuario.CadastraUsuarioDto;
import com.hygorluciano.lojaderoupa.domain.dto.usuario.VizualizarUsuarioComListPedidoDto;
import com.hygorluciano.lojaderoupa.domain.dto.usuario.VizualizarUsuarioDto;
import com.hygorluciano.lojaderoupa.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<HttpStatus> cadastraUsuario(@RequestBody @Valid CadastraUsuarioDto dados){
        return usuarioService.criandoUsuario(dados);
    }
    @GetMapping
    public ResponseEntity<List<VizualizarUsuarioDto>> verUsuario(){
        return usuarioService.verUsuario();
    };

    @GetMapping("/{id}")
    public ResponseEntity<List<VizualizarUsuarioComListPedidoDto>> verUsuarioComListaPedido(@PathVariable String id){
        return usuarioService.verUsuarioComListaPedidos(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> atualizarUsuario(@PathVariable String id, @RequestBody @Valid AtualizadoUsuarioDto dados){
        return usuarioService.atulizarUsuario(id,dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletaUsuario(@PathVariable String id){
        return usuarioService.deletaUsuario(id);
    }
}
