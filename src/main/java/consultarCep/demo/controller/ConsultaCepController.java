package consultarCep.demo.controller;


import org.springframework.ui.Model; // importação para utilizar o model ( transforma dados com json em algo utilizavel no html

import consultarCep.demo.DTO.CepConsultaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller // utilizado para lidar com paginas estáticas ( @restcontroller para dados )
@RequestMapping("/") // rota inicial para nao ficar colocando "/" depois nos gets
public class ConsultaCepController {

    @GetMapping("cep") // rota criada
    public String page() { // declara para puxar o html
        return "cep";
    }

    @PostMapping("cep") // declara um post que vai requistar os parametros do html com @RequestParam
    public String consulta(@RequestParam String numero, Model model) {
        if (numero == null || numero.isEmpty()) { // caso o numero do cep for nulo e não existir volta novamente
            return "cep";

        } else { // caso de certo ele realiza a
            // conexao com o viacep, pegando o formato e incluindo no parametro, pois la será inserido e comparado

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CepConsultaDTO> resp =
                    restTemplate.getForEntity(
                            String.format("https://viacep.com.br/ws/%s/json", numero),
                            CepConsultaDTO.class
                    );

            CepConsultaDTO dados = resp.getBody();  // pega o requestbody que não volta como html e sim no json ou outros
            model.addAttribute  ("dados", dados); // coloca no model add atributte, utilizada diretamente para
            // manipular no html, passando dados pra dados


            return "cep"; // retorna o html de fato
        }
    }
    }
