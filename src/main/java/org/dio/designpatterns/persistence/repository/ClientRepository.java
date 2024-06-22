package org.dio.designpatterns.persistence.repository;

import jakarta.websocket.server.PathParam;
import org.dio.designpatterns.persistence.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository

public interface ClientRepository extends CrudRepository <Client, Long> {



}
