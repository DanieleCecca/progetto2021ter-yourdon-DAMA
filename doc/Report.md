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
7. Manuale utente
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

# Modello di dominio
Abbiamo realizzato il seguente modello di dominio per esplicitare i concetti fondamentali della nostra applicazione 
tramite un diagramma delle classi con prospettiva software.

<center><img src = "./drawings/modello di dominio.png" alt = "modello di dominio"></center>

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

<center><img src = "./drawings/Diagramma dei package.png" alt = "modello di dominio"></center>

[Torna all'indice](##Indice)
 <br><br>

## Commenti
Abbiamo deciso di adottare lo stile architetturale **Model-View-Controller** così da rispettare a pieno la tassonomia **Entity-Control-Boundary**, dove:
- Le classi Entity possono comunicare tra loro e con le classi Control.
- Le classi Boundary possono comunicare con l'attore e con le classi Control.
- Le classi Control possono comunicare con tutte le classi eccetto gli attori. 