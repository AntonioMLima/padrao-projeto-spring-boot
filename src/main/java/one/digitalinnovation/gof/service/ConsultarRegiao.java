package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Regiao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "reg", url = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes")
public interface ConsultarRegiao {

    @GetMapping("/{id}")
    public Regiao consultarRegiao(@PathVariable("id") Integer id);
}