# Sobre o projeto

## Essa api foi desenvolvida utilizando a linguagem de programação Java, na versão 21, empregando o spring boot como framework na versão 3.1.4. Além disso, foi utilizada uma imagem do docker do MySQL como banco para desenvolvimento local e o Postman para realizar os testes dos endpoints. Também utilizei JWT para autenticação, JPA para persistencia de dados, Junit e mockito para testes unitários.

Inicialmente o administrador terá que registrar o usuário no endpoint /auth/register, informando o tipo de permissão que o usuário terá: "ADMIN" ou "USER". 

Permissão do tipo ADMIN: poderá registrar, ver, deletar e atualizar os instrumentos musicais da loja. 

Permissão do tipo USER: somente poderá ver os instrumentos musicais da loja.  


Em seguida, o usuário terá que informar o login e senha no endpoint /auth/login, que retornará um Bearer Token que será utilizado para garantir a confidencialidade do projeto. 

![Foto1](https://github.com/Marcaly/projeto-loja-de-musica/blob/main/fotosProjeto/Captura%20de%20tela%202023-11-11%20170510.png)


Se o usuário com a permissão "USER" tentar fazer alguma requisição que não esteja no escopo de suas permissões, retornará um 403 forbidden, o que significa que o mesmo não tem as devidas permissões. 

![Foto2](https://github.com/Marcaly/projeto-loja-de-musica/blob/main/fotosProjeto/Captura%20de%20tela%202023-11-11%20170753.png)

Somente o usuário com a permissão "ADMIN" poderá fazer as requisições PUT, POST e DELETE com sucesso, no caso da foto foi feito um POST com o Token do admin, o que resultou em um 201 Created. 

![Foto3](https://github.com/Marcaly/projeto-loja-de-musica/blob/main/fotosProjeto/Captura%20de%20tela%202023-11-11%20171101.png)

