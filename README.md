# Crawler para Dados Relacionados ao Padrão TISS (Troca de Informação em Saúde Suplementar)

O Crawler desenvolvido é uma aplicação em Groovy para coletar informações e arquivos relacionados ao Padrão TISS (Troca de Informação em Saúde Suplementar) da Agência Nacional de Saúde Suplementar (ANS). 
O programa é executado no terminal e oferece opções coletarem informações relevantes sobre o Padrão TISS e baixarem os arquivos necessários.

Ferramentas e Tecnologias Utilizadas:

  - Linguagem de Programação Groovy: O Crawler é escrito em Groovy, uma linguagem de programação baseada em Java, que oferece recursos de script e é especialmente adequada para automação de tarefas.
    
   - Jsoup: A biblioteca Jsoup é usada para fazer a análise e extração de dados de páginas da web. É uma ferramenta essencial para a coleta de informações de sites.
     
  - HTTPBuilder: A biblioteca HTTPBuilder é usada para fazer solicitações HTTP e baixar arquivos da web. Ela é usada para interagir com os servidores da ANS e baixar os arquivos necessários.
     
- Apache Commons IO: É utilizado para manipulação de arquivos, permitindo o download e gerenciamento de arquivos localmente.
    
  - Slf4j (Simple Logging Facade for Java): É uma infraestrutura de logging, embora configurado para não operar, pode ser ativado em configurações futuras.

Funcionalidades:

   O programa oferece quatro opções principais para o usuário:
   
  - Baixar Padrão TISS atualizado: Permite ao usuário baixar os arquivos relacionados ao Padrão TISS diretamente do site da ANS.
      
  - Listar Histórico das versões dos Componentes do Padrão TISS a partir de JAN/2016: Coleta informações detalhadas sobre as versões do Padrão TISS e exibe essas informações para o usuário.
      
 -  Baixar Tabela de erros no envio para a ANS: Permite ao usuário baixar a tabela de erros no envio de informações para a ANS.
       
 -  Encerrar a aplicação: Encerra a execução do programa.

  E possui mensagens informativas são adicionadas em cada etapa, informando o usuário sobre o progresso e o resultado das operações.

Esse Crawler é útil para profissionais e organizações na área de saúde suplementar que desejam manter-se atualizados com as informações e arquivos relacionados ao Padrão TISS. 
Ele automatiza a coleta dessas informações, economizando tempo e esforço, e fornece uma maneira conveniente de acessar esses recursos diretamente do site da ANS.
