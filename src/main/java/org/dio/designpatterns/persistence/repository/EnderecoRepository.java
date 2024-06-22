package org.dio.designpatterns.persistence.repository;

import org.dio.designpatterns.persistence.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EnderecoRepository extends CrudRepository <Endereco, String> {


}
