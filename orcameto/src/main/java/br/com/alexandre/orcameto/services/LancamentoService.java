package br.com.alexandre.orcameto.services;


import br.com.alexandre.orcameto.model.Cliente;
import br.com.alexandre.orcameto.model.Lancamento;
import br.com.alexandre.orcameto.repositories.ClienteRepository;
import br.com.alexandre.orcameto.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;
    public Lancamento salvar (Lancamento lancamento) {return lancamentoRepository.save(lancamento);}
}

