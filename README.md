# Projet-R304-JDR
Jeu de rôles - Code du projet final de la ressource R3.04 du BUT Informatique deuxième année de l'IUT d'Aix-en-Provence.   

### Description

Bienvenue sur notre jeu de rôle !  

Lorsque vous lancez le jeu, vous choisissez votre classe et entrez votre nom. Vous devez battre des monstres afin de passer de niveau et battre un boss final pour terminer le jeu.  

Lors des rencontres avec les monstres vous pouvez soit vous soignez, soit attaquer. Le round se finit lorsque vous mourrez et vous devez recommencer.  

Tout se fait avec des entrées au clavier.  

### Lancer le jeu

Pour lancer le jeu, vous devez lancer la méthode statique `main(String[])` de la classe `Main` et passer les emplacements vers les trois fichiers CSV : regardez l'aide du programme (accessible en lançant le programme sans argument ou avec les arguments `-h` ou `--help`) pour plus de détails.

Si vous utilisez un IDE comme Intellij IDEA, il vous faudra rajouter les arguments à la configuration de l'exécution de la classe principale pour que vous puissiez jouer.

### Fichiers d'exemples

Vous trouverez des fichiers CSV d'exemples dans les ressources de tests du jeu.

### Fonctionnalités non implémentées

- boss final
- combat de plus de 2 ennemis

### Bugs connus

- les propriétés d'un monstre ne sont pas réinitialisées entre chaque tour
- des problèmes d'affichage sont présents
- les espaces ne sont pas prises en compte pour la gestion des noms
- la validation de certains index n'est pas faite
- certains tests unitaires ne fonctionnent pas, dû à un problème de configuration de l'entrée standard dans les tests

Bon jeu !

Ce projet a été développé par V. Audric, LAURENT Nicolas et YAHIA-AMAR Mathieu.
