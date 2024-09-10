package br.com.alexandre.orcameto.controllers;

import br.com.alexandre.orcameto.model.Cliente;
import br.com.alexandre.orcameto.model.Lancamento;
import br.com.alexandre.orcameto.model.Municipio;
import br.com.alexandre.orcameto.repositories.LancamentoRepository;
import br.com.alexandre.orcameto.repositories.MunicipioRepository;
import br.com.alexandre.orcameto.services.ClienteService;
import br.com.alexandre.orcameto.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private MunicipioRepository municipioRepository;

    @GetMapping()
    public List<Municipio> listarTodosMunicipio(){ return municipioRepository.findAll(Sort.by("nome").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Municipio> buscarPeloCodigo(@PathVariable int id){
        Optional<Municipio> municipio = municipioRepository.findById(id);
        return municipio.isPresent() ? ResponseEntity.ok(municipio.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Municipio> inserir (@RequestBody Municipio municipio){
        Municipio municipioSalva = municipioService.salvar(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(municipioSalva);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable int id) { municipioRepository.deleteById(id);}


}
