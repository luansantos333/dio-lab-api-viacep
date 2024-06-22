package org.dio.designpatterns.persistence.service;

import org.dio.designpatterns.persistence.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "viacep.com.br/ws")

public interface ViaCepService {

    @GetMapping("/{cep}/json")
    public Endereco consultar(@PathVariable("cep") String cep);
}
