package consultarCep.demo.DTO;

public record  CepConsultaDTO( //  record utilizado para deixar imutavel e os dados não mudarem
          // configuração de todos os parametros que vão ser passados com valor
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String ibge,
        String gia,
        String ddd,
        String siafi

){}

