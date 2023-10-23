package one.digitalinnovation.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import one.digitalinnovation.gof.model.UnidadeFerativativa;


@FeignClient(name = "UF", url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados")
public interface ConsultarUF {

	@GetMapping("/{id}")
	public UnidadeFerativativa consultarUF(@PathVariable("id") Integer id);
}
