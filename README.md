# QueueJ2EE
Projet SDIS 2016

1) Reception d'une durée via la page WEB index.html (considéré comme service web)
2.a) Le Work est envoyé au worker via la senderQueue
2.b) Le service web est en attente du callback (callbackTopic)  
3) Le Work est récupéré dans la senderQueue par un EJB Worker (multi-task)
4) La tâche est effectuée
5) Le callback est envoyé dans le Topic 
6) Tous les services WEB en attente reçoivent l'id de la tâche effectuée
7) Les services comparent l'id avec leur tâche courante 
8) si Ok, la page est renvoyé au client; sinon attente
