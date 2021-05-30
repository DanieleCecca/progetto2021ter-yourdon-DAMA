# **Relazione tecnica finale**
## Indice
#

1. [Introduzione](#Introduzione)
2. [Modello di dominio](#Modello-di-dominio)
3. [Requisiti specifici](#Requisiti-specifici)
    
    3.1[Requisiti funzionali](##Requisiti-funzionali)
    
    3.2[Requisiti non funzionali](##Requisiti-non-funzionali)
    
4. [System Design](#System-Design)
    - [Stile architetturale adottato](##Stile-architetturale-adottato)
    - [Diagramma dei package](##Diagramma-dei-package)
    - [Commenti](##Commenti)
5. OO Design
    - Diagrammi delle classi e diagrammi di sequenza
    - Design pattern utilizzati
    - Commenti
6. Riepilogo dei Test
    - Tabella riassuntiva di Coveralls
7. [Manuale utente](#Manuale-Utente)
8. Processo di sviluppo e organizzazione del lavoro
9. Analisi retrospettiva
    - Soddisfazioni 
    - Insoddisfazioni
    - Cosa ci ha fatto impazzire

# Introduzione
Dama-Yourdon è un'applicazione, con interfaccia a linea di comando, che permette a due giocatori di sfidarsi localmente 
al gioco della dama. L'applicazione è stata realizzata per il corso di Ingegneria del Software dell'A.A 2020/2021 dal gruppo **_Yourdon_** i cui membri sono:

- [Francesco Ferrulli](https://github.com/Ferru2000)
- [Daniele Cecca](https://github.com/DanieleCecca)
- [Marco Angelo Lillo](https://github.com/MarcoLillx)
- [Michele Fraccalvieri](https://github.com/Citrone16)
- [Francesco Digregorio](https://github.com/FDigre)

 L'esecuzione dell'applicazione avviene a linea di comando via **Docker**.

[Torna all'indice](##Indice)
<br><br>

# Modello di dominio
Abbiamo realizzato il seguente modello di dominio per esplicitare i concetti fondamentali della nostra applicazione 
tramite un diagramma delle classi con prospettiva software.

<center><img src = "./drawings/ModelloDiDominio.PNG" alt = "modello di dominio"></center>

[Torna all'indice](##Indice)
 <br><br>


# System Design

## Stile architetturale adottato
Abbiamo deciso di adottare lo stile architetturale **Model-View-Controller**, separando la logica di business (Model) da quella di rappresentazione dei dati (View), attenendoci quindi alla tassonomia **Entity-Control-Boundary**.
- La parte Model viene identificata dalle classi di tipo Entity, che rappresentano il dominio dell'applicazione.
- La parte View viene identificata dalla classe Interfaccia di tipo Boundary, che si occupa delle interazioni con l'attore.
- La parte Controller viene identificata dalla classe Partita di tipo Control, che gestisce la logica di business.

## Diagramma dei package
Abbiamo realizzato il seguente diagramma dei package per esplicitare le dipendenze all'interno della nostra applicazione.

<center><img src = "./drawings/DiagrammaDeiPackage.PNG" alt = "modello di dominio"></center>

[Torna all'indice](##Indice)
 <br><br>

## Commenti
Abbiamo deciso di adottare lo stile architetturale **Model-View-Controller** così da rispettare a pieno la tassonomia **Entity-Control-Boundary**, dove:
- Le classi Entity possono comunicare tra loro e con le classi Control.
- Le classi Boundary possono comunicare con l'attore e con le classi Control.
- Le classi Control possono comunicare con tutte le classi eccetto gli attori.
<br><br>

# Manuale Utente

Per avviare l'applicazione, dopo aver avviato Docker desktop è necessario eseguire i seguenti comandi:
1. `docker pull docker.pkg.github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/dama-yourdon:latest`
2. `docker run --rm -it docker.pkg.github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/dama-yourdon:latest`

Questa applicazione utilizza alcuni simboli in codifica di unicode ed è necessario utilizzare uno dei seguenti terminali che supportano la codifica UTF-8:
- terminale di Linux
- teminale di MacOS
- Windows Terminal
- Git Bash (in questo caso il comando Docker ha come prefisso winpty:
`winpty docker -it ...`)

Avviata l'applicazione si presenterà la seguente schermata:
<center><img src = "../res/img/relazione-tecnica-finale/SchermataIniziale.PNG" alt = "schermata iniziale"></center>
Come si evince dalla schermata sarà possibile eseguire i seguenti comandi:

- `help`: mostra la lista dei comandi accettati

- `gioca`: avvia una nuova partita

- `abbandona`: mostra il seguente messaggio: **"La partita non è ancora iniziata. Inserisci il comando 'gioca' per iniziare una nuova partita."**

- `esci`: chiude l'applicazione. Nel momento in cui questo comando viene invocato richiede una conferma all'utente e in caso affermativo termina l'applicazione

- `numeri`: mostra la damiera numerata, dove i numeri rappresentano le posizioni delle caselle nelle quali sarà possibile muoversi durante la partita

- `damiera`: mostra il seguente messaggio: **"La partita non è ancora iniziata. Inserisci il comando 'gioca' per iniziare una nuova partita."**

- `tempo`: mostra il seguente messaggio: **"La partita non è ancora iniziata. Inserisci il comando 'gioca' per iniziare una nuova partita."**

Una volta iniziata la nuova partita (invocando il comando `gioca`) sarà possibile eseguire i seguenti comandi:

- `help`: mostra la lista dei comandi accettati

- `abbandona`: viene chiesto al giocatore di abbandonare la partita, in caso affermativo viene assegnata la vittoria all'altro giocatore

- `esci`: chiude l'applicazione, nel momento in cui questo comando viene invocato richiede una conferma all'utente e in caso affermativo termina l'applicazione

- `numeri`: mostra la damiera numerata, dove i numeri rappresentano le posizioni delle caselle nelle quali sarà possibile muoversi durante la partita

- `damiera`: mostra la damiera nel suo stato corrente

- `tempo`: mostra il tempo di gioco dei due giocatori

- `prese`: mostra la lista delle prese dei due giocatori   

- `mosse`: mostra la lista delle mosse dei due giocatori

Per poter eseguire una mossa bisogna inserire i comandi in notazione algebrica:

- Spostamento semplice: es. `22-18`

- Presa semplice: es. `19x10`

- Presa multipla: es. `19x10x1`

Nel momento in cui si cerca di eseguire una mossa non valida vengono mostrati dei messaggi di errore con una descrizione diversa a seconda dell'errore commesso.