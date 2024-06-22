package org.dio.designpatterns.persistence.service.imp;

import org.dio.designpatterns.persistence.model.Client;
import org.dio.designpatterns.persistence.model.Endereco;
import org.dio.designpatterns.persistence.repository.ClientRepository;
import org.dio.designpatterns.persistence.repository.EnderecoRepository;
import org.dio.designpatterns.persistence.service.ClientService;
import org.dio.designpatterns.persistence.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service

public class ClientServiceImp implements ClientService {
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ViaCepService cepService;
    
    @Override
    public Iterable<Client> buscarTodosClientes() {

        return clientRepository.findAll();

    }

    @Override
    public Client buscarPorId(long id) {
        return clientRepository.findById(id).orElseThrow(() -> new NoSuchElementException());


    }

    @Override
    public void inserirClient(Client client) {

        String cep = client.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {

            return cepService.consultar(cep);
        });

        enderecoRepository.save(endereco);

        client.setEndereco(endereco);

        clientRepository.save(client);


    }

    @Override
    public void atualizarClient(long id, Client client) {

        if (clientRepository.existsById(id)) {

            String cep = client.getEndereco().getCep();

            if (enderecoRepository.existsById(cep)) {

                clientRepository.save(client);

            } else {

                Endereco enderecoNovo = cepService.consultar(cep);
                client.setEndereco(enderecoNovo);
                enderecoRepository.save(enderecoNovo);
                clientRepository.save(client);


            }


        }
    }

    @Override
    public void deletarClient(long id) {

        clientRepository.deleteById(id);

    }
}
