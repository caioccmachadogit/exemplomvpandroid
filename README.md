# exemplomvpandroid

Aplicando MVP no Android


MVP (Model View Presenter) considerações:

•	Considerado uma derivação do MVC (Model View Controller) ;
•	Está sendo bastante aplicado em aplicativos Android;
•	Separa a Camada de Apresentação da lógica da mesma;
•	Todo relacionamento funciona através de Interfaces;
•	Camadas independentes, facilita aplicação de testes;
•	Menor acoplamento e Maior Coesão no código;


Implementando MVP

Organização dos Pacotes e Nomenclaturas de 
Classes/interfaces:

 

•	Login: pacote geral da funcionalidade, inclui a Activity;
•	Async: classes de chamadas AsyncTask;
•	Contract: declaração das interfaces: View, Presenter, Interactor;
•	Impl: classes que implementam as interfaces Presenter, Interactor;
•	Services: classes invocadas pelas Async, responsável pela chamada propriamente dita de um serviço; 
Explicando responsabilidades das classes:

LoginActivity: 
•	Activity da funcionalidade, implementa a Interface LoginView;
•	realiza chamadas a Classe LoginPresenteImpl passando dados da view;
•	recebe dados da LoginPresenterImpl através da interface LoginView;
•	exibe informações na view;
•	manipula componentes de layout;
LoginView:
•	Interface responsável por disponibilizar métodos os quais irão devolver dados processados para Activity LoginActivity;
LoginPresenterImpl:
•	Recebe dados da LoginActivity;
•	Trata validações dos dados;
•	Realiza processamento dos dados (regra de negócio) invocando ou não chamadas a Classe LoginInteractorImpl;
•	Retorna dados para LoginActivity através da Interface LoginView;
LoginPresenter:
•	Interface responsável por disponibilizar métodos para Classe LoginPresenterImpl;
OnLoginFinishedListener:
•	Interface responsável por disponibilizar métodos os quais irão devolver dados para Classe LoginPresenterImpl;
LoginInteractorImpl:
•	Recebe dados da Classe LoginPresenterImpl;
•	Realiza chamadas de Serviços e ou banco de dados local;
•	Chamadas a serviços através da Classe AsyncAuth;
•	Recebe dados das chamadas Async e realiza tratamentos;
•	Retorna dados para LoginPresenterImpl através da Interface OnLoginFinishedListener;
LoginInteractor:
•	Interface responsável por disponibilizar métodos para Classe LoginInteractorImpl;
AsyncAuth:
•	Cria o Parse de Request e Response para requisição do serviço;
•	Realiza chamada a Classe RequestAuth;
•	Retorna dados parseados para Classe LoginInteractorImpl;
RequestAuth:
•	Recebe o Parse de Request da AsyncAuth;
•	Realiza a chamada do serviço(back-end);
•	Retorna o response (não parseado) para AsyncAuth;


Código Fonte: https://github.com/caioccmachadogit/exemplomvpandroid.git


