# Internet_dos_Brinquedos
Projeto realizado por Adlla Katarine Aragão Cruz Passos e Daniel Alves Costa

Projeto PBL 1 do MI - Concorrência e Conectividade da Universidade Estadual de Feira de Santana.
Consiste em montar um sistema de monitoramento e cadastro de pilotos de uma pista de carros de brinquedos(autorama),
utilizando RFID juntamente de um Raspberry PI para enviar a posição dos carros.

Método de execução 1ª parte:
- Executando o programa a tela inicial é exibida possibilitando o usuário realizar cadastro e login. Se estiver alguma
partida sendo realizada, a classificação é exibida na lista. Como fase de teste foi realizado o cadastro de alguns pilotos previamente(piloto1, piloto2, piloto3, piloto4), juntamente com as configurações que simula o sensor e as definições de 
jogador selecionar carro. 
- Como fase de teste a realização da simulação é realizada através do clique do botão "Testar", fazendo com que os pilotos "andem".
- Botão de cadastro redireciona para a tela de cadastro, possibilitando o usuário de se cadastrar tanto como jogador quanto 
como administrador(selecionando o checkbox).
- Botão login redireciona o usuário para tela de login, direcionando o administrador para a tela de configuração de partida, e o jogador para seleção de carro.

Limitações:
- Como 4 pilotos foram previamentes cadastrados, quando o administrador seleciona um novo corredor nas configurações da partida 
ele informa que a partida estar cheia.
- Métodos para inicio de partida ainda não foram completamente desenvolvidos.
- Método de cadastrar carro implentada, porém ainda não criada interface para configurar isso.
