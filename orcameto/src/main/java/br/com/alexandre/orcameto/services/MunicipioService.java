package br.com.alexandre.orcameto.services;

import br.com.alexandre.orcameto.model.Lancamento;
import br.com.alexandre.orcameto.model.Municipio;
import br.com.alexandre.orcameto.repositories.LancamentoRepository;
import br.com.alexandre.orcameto.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;
    public Municipio salvar (Municipio municipio) {return municipioRepository.save(municipio);}
}
