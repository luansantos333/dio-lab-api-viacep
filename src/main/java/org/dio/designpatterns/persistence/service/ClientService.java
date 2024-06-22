package org.dio.designpatterns.persistence.service;

import org.dio.designpatterns.persistence.model.Client;

public interface ClientService {

    Iterable<Client> buscarTodosClientes();

    Client buscarPorId(long id);

    void inserirClient(Client client);

    void atualizarClient(long id, Client client);

    void deletarClient(long id);

}
