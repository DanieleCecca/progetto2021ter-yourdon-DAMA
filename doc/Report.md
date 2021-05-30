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

# Requisiti specifici
Di seguito sono riportati i requisiti funzionali (in ordine cronologico rispetto alla creazione degli issue) seguiti dai requisiti non funzionali.

## Requisiti funzionali

Di seguito sono riportati i requisiti funzionali:
- ### [Help](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/20)

    L'utente può visualizzare l'elenco dei comandi disponibili tramite il comando `help`.
    
    **Criteri di accettazione**

    Eseguendo il comando `help` o invocando l'app con flag `--help` o `-h`
    il risultato è una descrizione concisa, che normalmente appare all'avvio del programma, seguita dalla lista di comandi disponibili, uno per riga, come da esempio successivo:

    - `gioca`
    - `esci`
    - `...`

- ### [Iniziare nuova partita](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/23)

    L'utente può iniziare una partita tramite il comando `gioca`. Subito dopo sarà possibile inserire la prima mossa di gioco (in notazione algebrica) o inserire altri comandi, ad esempio il comando `damiera` (per mostrare la damiera).

    **Criteri di accettazione**

    Al comando `gioca` se nessuna partita è in corso l'app si predispone a ricevere la prima mossa di gioco o altri comandi.


- ### [Abbandonare partita](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/37)

    L'utente può abbandonare la partita tramite il comando `abbandona`.
    
    **Criteri di accettazione:**
    
    Al comando `abbandona` l'app chiede conferma: 
    - se la conferma è positiva, l'app comunica che il Bianco (o Nero) ha vinto per abbandono 
    - se la conferma è negativa, l'app si predispone a ricevere nuovi comandi

- ### [Chiudere il gioco](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/41)

    L'utente può terminare l'applicazione tramite il comando `esci`.

    **Criteri di accettazione:**
    
    Al comando `esci` l'applicazione chiede conferma:
    - se la conferma è positiva, l'app si chiude restituendo un zero exit code
    - se la conferma è negativa, l'app si predispone a ricevere nuovi comandi

- ### [Mostrare damiera con numerazione](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/21)

    L'utente può visualizzare a schermo la damiera con la numerazione in modo da ricordare come sono numerate le caselle della damiera (tramite il comando `numeri`).

    **Criteri di accettazione**

    Al comando `numeri` l'app mostra la damiera con i numeri sulle caselle nere.
    Il formato della damiera è presente in [`Assegnazione progetto.md`](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/blob/master/Assegnazione%20progetto.md)

- ### [Mostrare damiera con i pezzi](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/22)

    L'utente può visualizzare a schermo la damiera con i pezzi in modo da visualizzare lo stato del gioco (tramite il comando `damiera`).

    **Criteri di accettazione**

    Al comando `damiera`
    - se il gioco è iniziato l'app mostra la posizione di tutti pezzi sulla damiera
        - i pezzi sono mostrati [in formato Unicode](https://en.wikipedia.org/wiki/English_draughts#Unicode)
    - se il gioco non è iniziato l'app suggerisce il comando gioca

- ### [Mostrare tempo di gioco](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/42)

    L'utente può visualizzare a schermo il tempo di gioco trascorso tramite il comando `tempo`.

    **Criteri di accettazione**

    Al comando `tempo`
    - se il gioco è in corso 
        - l'app mostra il tempo trascorso per il Bianco dall'inizio del gioco
        - l'app mostra il tempo trascorso per il Nero dall'inizio del gioco
    - se il gioco non è in corso l'app suggerisce il comando `gioca` e si predispone a ricevere nuovi comandi

- ### [Spostare una pedina con spostamento semplice](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/28)

    L'utente può spostare una pedina mediante spostamento semplice inserendo il comando in notazione algebrica.

    **Criteri di accettazione**

    A partita in corso di gioco, l'app deve accettare mosse di spostamento semplice di pedina in notazione algebrica.
    
    Lo spostamento semplice della pedina deve rispettare le [regole del gioco](http://www.fid.it/regolamenti/capo1.htm) della dama italiana, escludendo damature e prese. In particolare (_Art. 4 - Gli spostamenti semplici_).

    La pedina può essere mossa solo in avanti e in diagonale e portata dalla casella di partenza in una casella libera contigua.

    All'immissione di una mossa valida come:
    
        Es. 1-5

    viene aggiornato lo stato della damiera, altrimenti viene visualizzato un messaggio di errore e l'app si predispone a ricevere un nuovo comando.

- ### [Spostare una pedina con presa semplice](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/27)

    L'utente può spostare una pedina mediante presa semplice inserendo il comando in notazione algebrica.

    **Criteri di accettazione**
    
    A partita in corso di gioco, l'app deve accettare mosse di spostamento di pedina con presa semplice in notazione algebrica.

    Lo spostamento della pedina con presa semplice deve rispettare le [regole del gioco](http://www.fid.it/regolamenti/capo1.htm) della dama italiana. In particolare (_Art. 5 e 6_).
    
    All'immissione di una mossa valida come:
    
        Es. 18x11 (se è il bianco a muovere)

    viene aggiornato lo stato della damiera, altrimenti viene visualizzato un messaggio di errore e l'app si predispone a ricevere un nuovo comando.
    
- ### [Spostare una pedina con presa multipla](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/29)

    L'utente può spostare una pedina mediante presa multipla inserendo il comando in notazione algebrica.

    **Criteri di accettazione**

    A partita in corso di gioco, l'app deve accettare mosse di spostamento di pedina con presa multipla in notazione algebrica.

    Lo spostamento della pedina con presa multipla deve rispettare le [regole del gioco](http://www.fid.it/regolamenti/capo1.htm) della dama italiana. In particolare (_Art. 5 e 6_).

    All'immissione di una mossa valida come:
    
        Es. 22x15x6 (se è il bianco a muovere)

    viene aggiornato lo stato della damiera, altrimenti viene visualizzato un messaggio di errore e l'app si predispone a ricevere un nuovo comando.

- ### [Spostare una pedina con damatura](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/30)

    L'utente può spostare una pedina con damatura inserendo il comando in notazione algebrica.

    **Criteri di accettazione**

    A partita in corso di gioco, l'app deve accettare mosse di spostamento semplice di pedina in notazione algebrica che terminano con la damatura.
        
    Lo spostamento con damatura deve rispettare le [regole del gioco](http://www.fid.it/regolamenti/capo1.htm) della dama italiana. 

    All'immissione di una mossa valida come:
    
        Es. 6-3 oppure se c'è una presa 10x3

    viene aggiornato lo stato della damiera, altrimenti viene visualizzato un messaggio di errore e l'app si predispone a ricevere un nuovo comando.

- ### [Mostrare le prese](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/34)

    L'utente può visualizzare le prese effettuate durante la partita tramite il comando `prese`.

    **Criteri di accettazione**
    
    Al comando `prese` l'app mostra le prese del Bianco e del Nero con caratteri Unicode
             
        Es.
            Bianco: ⛂ ⛂
            Nero: ⛀ ⛀ ⛀ ⛀

- ### [Mostrare le mosse giocate](https://github.com/softeng2021-inf-uniba/progetto2021ter-yourdon/issues/36)

    L'utente può visualizzare le mosse giocate (quindi riconosciute ed attuate dal programma), in modo da poter ripercorrere mentalmente la storia della partita giocata, tramite il comando `mosse`.

    **Criteri di accettazione**

    Al comando `mosse` l'app mostra la storia delle mosse con notazione algebrica
    
        Esempio:
            B 21-18
            N 10-14
            B 24-20
            N 14x21
            ...

    [Torna all'indice](##Indice)

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