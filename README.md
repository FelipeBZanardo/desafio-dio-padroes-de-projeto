# desafio-dio-padroes-de-projeto
Desafio Bootcamp Santander - Dio - Padrões de Projeto

Inspirado nas aulas "Explorando Padrões de Projeto na Prática com Java" onde o professor ensina a cadastrar clientes através de uma api externa "viacep", o presente projeto trata-se de cadastro de empresas.

## O cadastro de empresas necessita de: 
- Um ID (gerado automaticamente);
- Nome de identificação;
- CNPJ (Cadastro Nacional da Pessoa Jurídica).

## Através de uma api externa de consulta de CNPJ, dados extras foram obtidos para o cadastro da empresa:
(url da api: <https://brasilapi.com.br/api/cnpj/v1/{cnpj}>)
- Razão social;
- Nome Fantasia;
- Logradouro;
- Município.

Testes foram feitos através do endereço <http://127.0.0.1:8080/swagger-ui.html> e todos obtiveram sucesso.

## Principais dificuldades para realização do projeto:
- Encontrar uma api externa pronta para consulta de CNPJ;
- Dificuldade em obter dados da api externa. 
Caso os atributos da API venham com nomes diferentes dos quais quero utilizar na minha interface, não sei como fazer para mofificá-los e tratá-los;
