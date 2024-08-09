Trabalho concluido durante o curso de Desenvolvimento de Sistemas do Senai Cimatec, feito por Jader Trindade.

# Introdução

O projeto **E-Shop** é um aplicativo móvel desenvolvido para plataforma Android utilizando Java e XML no Android Studio. Ele oferece uma plataforma de comércio eletrônico onde os usuários podem visualizar e comprar produtos e serviços. O aplicativo inclui funcionalidades de login seguro, cadastro de usuários, exibição de catálogo de produtos e serviços com filtros de pesquisa, adição de itens ao carrinho de compras e visualização de detalhes dos produtos. O design é moderno, com uma paleta de cores predominantemente roxa sobre um fundo preto, proporcionando uma experiência visual agradável e intuitiva para os usuários.

## Funcionalidades

- **Carrinho de compras:** Através do E-Shop você consegue colocar seu produto desejado em um carrinho, e após se decidir se quer comprar algo mais, finalizar sua compra.
- **Login Seguro:** Como dito anteriormente, o aplicativo E-Shop conta com um sistema de autenticação Firebase criado pelo Google! Isso significa que seus dados estarão mais guardados do que nunca.
- **Design Inteligente e Acessibilidade:** O design do E-Shop foi estudado milimetricamente para proporcionar ao usuário uma experiência fluida e de fácil entendimento, sendo acessível a todos.
- **Log Out:** Com o E-Shop você pode deslogar de sua conta com apenas um toque! Além disso, pode checar seu perfil e nome, caso queira confirmá-los.

## Sobre o código:

Falando sobre o código do E-Shop, ao desenvolvê-lo eu priorizei a sua simplicidade e robustez, para isso eu implementei as seguintes funcionalidades:

- **Arquitetura MVC (Model-View-Controller):** O projeto segue o padrão de arquitetura MVC para separar as responsabilidades de apresentação, lógica de negócio e gerenciamento de dados.
- **Componentes de Interface de Usuário:** Utilização extensiva de layouts XML para definir a interface do usuário, como ConstraintLayout e LinearLayout.
- **Estilos e temas:** Definidos no arquivo styles.xml para garantir consistência visual em todo o aplicativo.
- **Firebase Authentication e Firebase Database:** Autenticação de usuários usando o Firebase Authentication. Integração com o Firebase Database para armazenar e recuperar dados dos produtos, usuários e carrinho de compras.
- **RecyclerView e Adapter Personalizado:** Utilização do RecyclerView juntamente com um Adapter personalizado (ProdutoServicoAdapter) para exibir a lista de produtos e serviços. Implementação de filtros e pesquisa na lista de produtos usando Filter do RecyclerView.
- **Funcionalidades de Login e Cadastro:** Tela de login (TelaLogin) com validação de autenticação usando Firebase. Tela de cadastro (TelaCadastro) para novos usuários se registrarem no aplicativo.
- **Carrinho de Compras:** Implementação de um carrinho de compras onde os usuários podem adicionar produtos, visualizar o total da compra e finalizar a compra (simulado).
- **Tratamento de Exceções e Mensagens Toast:** Tratamento de exceções específicas do Firebase Authentication para informar ao usuário sobre erros de login, senha incorreta, usuário não cadastrado, etc. Exibição de mensagens informativas usando Toast para interações do usuário, como envio de email de redefinição de senha.
- **Estilização e Tema:** Personalização da interface do usuário com uma paleta de cores roxo, branco e preto, definida em arquivos XML (colors.xml). Estilização de botões, textos e campos de entrada usando estilos (styles.xml) para manter a consistência visual.
- **Integração com Barra de Status:** Definição da cor da barra de status para roxo sem usar um estilo, apenas referenciando @color.
- **Configuração do Manifesto:** Permissões necessárias configuradas, como INTERNET. Declaração de atividades e definição de atividade inicial (TelaLogin).

## Pontos a melhorar:

O E-Shop é apenas um protótipo, e tem diversos pontos a melhorar, como:

- **Integração com Banco de Dados:** Implementar uma integração com um banco de dados (por exemplo, Firebase Realtime Database ou Firestore) para armazenar informações de produtos, usuários e carrinho de compras. Isso permitirá persistência de dados e sincronização em tempo real.
- **Autenticação Avançada:** Refinar a autenticação com Firebase Authentication para incluir recuperação de senha, login social (como Google, Facebook) e verificação de e-mail.
- **Pagamentos Online:** Integrar um serviço de pagamento online (como PayPal, Stripe) para permitir que os usuários finalizem compras diretamente pelo aplicativo.
- **Notificações Push:** Implementar notificações push utilizando Firebase Cloud Messaging para informar os usuários sobre promoções, status de pedidos, etc.
- **Aprimoramento da Interface do Usuário:** Realizar uma revisão completa do design da interface do usuário para garantir uma experiência intuitiva e moderna. Incluir animações e transições suaves para melhorar a interatividade.
- **Busca Avançada e Filtros:** Aprimorar a funcionalidade de busca com sugestões automáticas, pesquisa por categoria e filtros avançados.
- **Histórico de Compras e Recomendações:** Implementar um histórico de compras para os usuários e recomendações personalizadas com base no histórico de compras.
- **Gestão de Estoque e Administração:** Desenvolver uma interface de administração web para gerenciar produtos, pedidos, usuários e monitorar o estoque.
- **Avaliações e Comentários:** Permitir que os usuários avaliem e comentem sobre produtos comprados, incentivando feedback e interação na comunidade.
- **Localização e Multi-idiomas:** Adicionar suporte a múltiplos idiomas e personalização de moedas com base na localização do usuário.
- **Segurança e Performance:** Realizar auditorias regulares de segurança para proteger os dados do usuário e otimizar o desempenho do aplicativo.
- **Análise de Dados:** Implementar ferramentas de análise para entender o comportamento do usuário, melhorar a conversão de vendas e ajustar estratégias de marketing.

## GitHub

Você pode encontrar o código-fonte do projeto no GitHub: [E-Shop Repository](https://github.com/trindadej44/MyApplication#js-repo-pjax-container)
