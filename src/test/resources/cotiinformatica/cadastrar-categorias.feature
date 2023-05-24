#language: pt

Funcionalidade: Cadastrar Categorias
	como um usuário autenticado no sistema
	eu quero cadastrar categorias
	para que eu possa incluir contas nestas categorias
	
Contexto:
	Dado O usuário está autenticado no sistema
	
Cenário: Cadastro de categoria com sucesso
	Dado Acessar a página de cadastro de categoria
	E Informar o nome da categoria
	Quando Solicitar a realização do cadastro da categoria
	Então Sistema informa que a categoria foi cadastrada com sucesso
