
# Desafio de padrões de projeto

Neste desáfio eu explorei alguns Design Patterns como Singleton, Strategy e Facade.

Esse projeto é uma API REST que recupera alguns dados da Unidade Ferederativa do cliente com base no código da mesma.

É possivel visualizar os códigos correspondentes das UFs [aqui](https://www.ibge.gov.br/explica/codigos-dos-municipios.php).

A documentação das APIs externas usadas encontra-se [aqui](https://servicodados.ibge.gov.br/api/docs/localidades#api-_).

Exemplo de entrada usando método POST:
```json
{
  "nome": "Antonio",
  "unidadeFerativativa": {
    "id": 53
  }
}
```
Saída:

```json
{
  "id": 1,
  "nome": "Antonio",
  "unidadeFerativativa": {
    "id": 53,
    "sigla": "DF",
    "nome": "Distrito Federal",
    "regiao": {
      "id": 5,
      "sigla": "CO",
      "nome": "Centro-Oeste"
    }
  }
}
```






