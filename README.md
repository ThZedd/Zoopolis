![image](https://github.com/user-attachments/assets/0a0584f1-045d-4eb2-9670-13dc1ff7ae00)

**Curso:** **Engenharia Informática** 

**Elementos do Grupo 03:**
- **Bernardo Carvalho - 20231441**
- **Thiago Moreirão - 20221437**
- **David Bação - 20230331** 

**Repositório no GitHub:** https://github.com/ThZedd/Zoopolis

---
### **Professores**

**Programação Mobile** 
<br>Nathan Campos 

**Projeto Desenvolvimento Móvel** 
<br>Pedro Rosa

**Programação Orientada por Objetos** 
<br>Fabio Guilherme 

**Bases de Dados** 
<br>Miguel Boavida

**Competências Comunicacionais** 
<br>Luiza Bianquini Campos

**Matemática Discreta** 
<br>Paulo Velho


---
# Relatório - Projeto Mobile - Zoopolis


- **Zoopolis** é uma aplicação móvel concebida com o intuito de melhorar a experiência dos visitantes ao zoológico, através do fornecimento de um meio interativo e educativo para explorar as instalações. O seu objetivo é resolver a **falta de informações acessíveis** (por exemplo: a localização dos caixotes do lixo) durante a visita, oferecendo um guia digital, localização em tempo real, exibição de preços, recursos educativos e a **possibilidade de acumular pontos**, de modo a maximizar o aproveitamento da visita. 

---
# Palavras-Chave


- Aplicação Móvel, zoológico, interação, educação, turismo, colheita de pontos, guia digital, localização em tempo real.

---
# Objetivos e Motivação

### Motivação:

- Com a crescente digitalização dos espaços culturais e educativos, os zoológicos têm a oportunidade de melhorar a experiência dos seus visitantes. A nossa aplicação **Zoopolis** pretende tornar essas visitas mais cativantes e informativas, principalmente para o público jovem, através da combinação de entretenimento e educação.

### Objetivos:

 - Oferecer uma experiência cativante e interativa, com a colheita de pontos, um guia digital e localização em tempo real.
 - Incentivar as visitas recorrentes ao zoológico e o aprendizado sobre as espécies através de um guia digital.
 - Facilitar a visita ao zoo com uma interface intuitiva e de facil acesso.

---
# Público-Alvo

- **Estudantes** interessados na vida animal;
- **Turistas** que visitam o zoológico pela primeira vez;
- **Famílias** com crianças em idade escolar;
- **Amantes de animais** que desejam de aprender mais acerca de animais.

---
# Aplicações semelhantes

Após uma pesquisa acerca de aplicações disponíveis no mercado, deparamo-nos com várias apps para zoológicos, tais como:

1. **ZSL London Zoo App:** Aplicação de guia e mapa interativo com informações sobre os animais e as atrações do zoológico de Londres.
2. **San Diego Zoo:** Oferece informações detalhadas sobre os animais e eventos, além de notificações em tempo real.
3. **Bronx Zoo App:** Além de funcionar como guia interativo, proporciona uma experiência de navegação com mapas detalhados, informações sobre os animais e suporte para planejar visitas, incluindo horários de alimentação e eventos especiais.

Estas aplicações oferecem várias funções básicas, tais como, mapas e guias, mas a Zoopolis pretende diferenciar-se com a colheita de pontos.

---
# Guiões de Teste

### Caso de Utilização Principal: Visita Guiada (Core)

1.  O utilizador faz login ou cria uma conta;
2.  **Introduz o código**, que estará disponibilizado no bilhete, e inicia a sua visita ao zoo;
3. Acede ao menu dos animais e **seleciona o animal** que deseja visitar;
4. Recebe informações detalhadas e curiosidades acerca do animal, e o **trajeto necessário** a efetuar até chegar a esse animal;
5. Após chegar ao recinto desse animal irá se deparar com uma placa com uma foto do animal, algumas informações sobre o mesmo e um **QR Code**, que poderá scannear;
6. Ao scannear esse **QR Code** esse animal aparece durante aquela visita como **"Visitado"** e o utilizador **ganha 1 ponto**;
7. Esses pontos podem ser acumulados, e ao fim de juntar um determinado número de pontos poderá levantar num dos kiosks um brinde.

### Casos de Utilização Secundários:

#### - Compra de Bilhetes:

1.  O utilizador faz login ou cria uma conta;
2. Acede ao menu dos preços e **seleciona a opção** de "Buy Tickets";
3. Seleciona o tipo de bilhete e o número de entradas;
4. Conclui a compra através de um **pagamento seguro**.

#### - Pesquisa Informativa:
1. O utilizador pode selecionar a opção de **entrar como convidado**;
2. Seleciona o **menu dos animais**;
3. Pesquisa sobre o **animal que deseja**;
4. Seleciona (caso este exista no zoológico) e obterá informações sobre o mesmo.

---
# Descrição da solução

#### 1. Descrição Genérica:

- A solução será criar uma **aplicação móvel** que oferece uma **experiência interativa, educativa e divertida** para os visitantes do zoológico. Inclui funcionalidades como **mapa interativo**, **colheita de pontos**, **compra de bilhetes**, **informação e curiosidades** acerca dos animais do zoológico e **localização em tempo real**.

#### 2. Enquadramento nas Unidades Curriculares:

- **Programação Mobile:** Desenvolvimento da aplicação móvel através da utilização da aplicação **Android Studio**.
- **Programação Orientada por Objetos:** Interligação da **base de dados** com a app através da utilização do **Spring Boot**.
- **Base de dados:** Armazenamento das **informações dos animais, utilizadores e dos pontos coletados**.
- **Competências Comunicacionais:** Comunicação eficaz na **propaganda e divulgação** do produto em desenvolvimento.
- **Matemática Discreta:** Análise e tratamento dos dados da aplicação.

#### 3. Requisitos Técnicos:

- **Linguagens de Programação**: **Kotlin**, **Java**, **MySQL**.
- **Plataforma de Desenvolvimento**: Android Studio
- **Base de Dados:** MySQL Workbench.
- **API:** Spring Boot. 

#### 4. Arquitetura da Solução:

- **Frontend:** Desenvolvimento da aplicação com Android Studio.
- **Backend:** Utilização de Spring Boot para lidar com as interações entre a base de dados e a aplicação.
- **Base de dados:** Utilização de MySQL Workbench para criar a DB.

#### 5. Tecnologias a utilizar:

- **Frontend:** Kotlin.
- **Backend:** Java.
- **Base de dados:** MySQL.

---

# MockUps:



---
# Planeamento (Gráfico de Gantt):






---
# Conclusão:

- O nosso projeto **Zoopolis** tem como objetivo revolucionar as visitas ao zoológico e a forma como as pessoas interagem com o zoo, utilizando tecnologias modernas como **a localização em tempo real**. Queremos criar uma **experiência educativa e cativante**, contribuindo para a preservação da vida selvagem, sensibilizando os visitantes. Ao longo do desenvolvimento da aplicação, **estaremos abertos a críticas construtivas**, de forma a atender às necessidades dos nossos utilizadores, garantindo assim que a nossa aplicação seja **intuitiva, funcional e prática**.


---
# Bibliografia:

- [ZSL London Zoo](https://www.zsl.org/) 
- [Bronx Zoo](https://map.bronxzoo.com/home) 
- [San Diego Zoo App](https://play.google.com/store/apps/details?id=com.seamgen.sandiegozoo.zoo&hl=en&pli=1) 
- [Figma](https://www.figma.com/)