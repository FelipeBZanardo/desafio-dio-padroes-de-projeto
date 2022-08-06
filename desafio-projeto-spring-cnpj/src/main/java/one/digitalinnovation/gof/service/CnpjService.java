package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Dados;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//https://brasilapi.com.br/api/cnpj/v1/{cnpj}
@FeignClient(name = "publicacnpj", url = "https://brasilapi.com.br/api")
public interface CnpjService {

    @GetMapping("/cnpj/v1/{cnpj}")
    Dados consultarCnpj(@PathVariable("cnpj") String cnpj);

}
