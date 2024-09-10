package br.com.alexandre.orcameto.controllers;

import br.com.alexandre.orcameto.model.Cliente;
import br.com.alexandre.orcameto.model.Lancamento;
import br.com.alexandre.orcameto.repositories.LancamentoRepository;
import br.com.alexandre.orcameto.services.ClienteService;
import br.com.alexandre.orcameto.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping()
    public List<Lancamento> listarTodosLancamento(){ return lancamentoRepository.findAll(Sort.by("nome").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long id){
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        return lancamento.isPresent() ? ResponseEntity.ok(lancamento.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Lancamento> inserir(@RequestBody Lancamento lancaento){
        Lancamento lancamentoSalva = lancamentoService.salvar(lancaento);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalva);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) { lancamentoRepository.deleteById(id);}


}
