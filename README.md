# alexss-desafio-bb-cotacao-api

Épico: Cotação de Moeda Estrangeira Dollar.

 1 - User Story - Consumir as informaçãoes de moeda estrangeira dollar do Banco Central. 

Descrição: Como operador de cambio, 
	   Eu quero estar apto a consultar a cotação oficial do dollar do dia no Banco Central  
	   De modo que eu possa registrar em uma base de consulta os respectivos preços de compra, venda e data e hora da cotação.
	   
	   Obs: Ator: Operador de Cambio.
		Ação: Consultar a cotação de moeda estrangeira dollar no Banco Central por uma respectiva data.
		Objetivo: Montar uma base de informaçãoes sobre preco de compra, preçco de venda, data e hora da cotação.
		
Critérios de aceitação

	   Eu quero ter a opção de entrar com a data do dia no formato "MM-dd-yyyy" (Mês Dia Ano).
	   Eu quero vizualizar as seguintes informações de forma estruturada JSON: informações: data e hora da requisição, data da cotação, o valor da cotação para compra, o valor da cotação para venda e data e hora da cotação; de 	  forma estruturada JSON.
	   As informações visuzalidas devem ser salvas em uma base de consulta para futuras analises.

Cenário de teste.

	1. O Usuário deve utilizar qualquer browser para consultar o servico de cotação de moeda estrangeira, dollar; provido pela aplicação.
	2. O Usuário deverá selecionar o serviço de cotação de moeda estrangeira dollar e preencher com a data de pesquisa no formato (MM-dd-aaaa) mes dia e ano com quatro digitos.
	3. O Usuário deverá clicar no botão executar consultar pra iniciar o processamento.
	4. A Aplicação retornará as informações da cotação do dia da moeda estrangeira dollar e apresetará ao usuário através da interface UI swagger no formato JSON.
	5. O Usuário poderá executar outras pesquisas após limpar o retorno da pequisa executação e preenchendo com uma nova data a ser pesquisada.	   	   	     