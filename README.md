# Aplicação Spring Security JWT

Este repositório contém uma aplicação de exemplo que ilustra o uso de JWT (JSON Web Token) em conjunto com o Spring Security. O objetivo é fornecer uma implementação básica de autenticação e autorização usando essas tecnologias populares.

## Descrição

A aplicação foi desenvolvida utilizando o framework Spring Boot, que facilita a criação de aplicativos Java baseados em Spring. O Spring Security é uma estrutura de segurança amplamente adotada que fornece recursos de autenticação e autorização para aplicativos.

O JWT é um padrão aberto (RFC 7519) que define uma maneira compacta e segura de transmitir informações entre partes como um objeto JSON. É amplamente usado para autenticação stateless em aplicativos web e APIs RESTful. Nesta aplicação, o JWT é utilizado para autenticar os usuários e fornecer tokens de acesso seguros.

## Funcionalidades

- Registro de usuários: permite que novos usuários se cadastrem na aplicação fornecendo um nome de usuário e senha.
- Autenticação: permite que os usuários façam login usando suas credenciais registradas.
- Autorização: protege recursos específicos da aplicação, permitindo apenas que usuários autenticados acessem esses recursos.
- Geração de token JWT: ao fazer login com sucesso, um token JWT é gerado e fornecido ao usuário.
- Verificação de token JWT: os endpoints protegidos exigem que os usuários enviem o token JWT válido para acessá-los. O token é verificado para garantir sua autenticidade e integridade antes de permitir o acesso.

## Configuração e Execução

Siga as etapas abaixo para configurar e executar a aplicação:

1. Clone este repositório em sua máquina local:

   ```
   git clone https://github.com/yuri-italo/dio-spring-security-jwt.git
   ```

2. Navegue até o diretório do projeto:

   ```
   cd dio-spring-security-jwt
   ```

3. O projeto utiliza o Maven como gerenciador de dependências. Para construir a aplicação, execute o seguinte comando:

   ```
   mvn clean install
   ```

4. Após a conclusão da construção, execute o seguinte comando para iniciar a aplicação:

   ```
   mvn spring-boot:run
   ```

   Isso iniciará o aplicativo Spring Boot e a aplicação estará disponível em `http://localhost:8080`.

5. Você pode usar uma ferramenta como o Postman ou o cURL para interagir com os endpoints disponíveis na aplicação.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias, correções de bugs ou novos recursos.

