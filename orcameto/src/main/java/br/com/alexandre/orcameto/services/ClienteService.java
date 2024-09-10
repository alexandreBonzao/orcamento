package br.com.alexandre.orcameto.services;

import br.com.alexandre.orcameto.model.Cliente;
import br.com.alexandre.orcameto.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente salvar (Cliente cliente) {return clienteRepository.save(cliente);}
}
