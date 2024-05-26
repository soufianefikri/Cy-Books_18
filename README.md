CY-Book


CY-Book est une application graphique en Java conçue pour aider les bibliothécaires à gérer efficacement une bibliothèque de livres. L'application permet l'inscription des usagers, la gestion des emprunts. Elle est conçue pour être utilisée avec une souris et un clavier.

    Fonctionnalités
          •	Inscription des usagers : Permet l'ajout de nouveaux utilisateurs dans la base de données.
          •	Gestion des emprunts : Suivi des emprunts et des retours de livres.


    Architecture
        CY-Book est composé de deux principaux aspects :
            1.	Connexion à une base de données locale : Cette base de données stocke les informations des usagers ainsi que les détails de chaque emprunt de livre.
            2.	Intégration de l'API de la Bibliothèque Nationale de France (BNF) : Permet de récupérer et d'intégrer les informations sur chaque livre édité et publié en France.


    Outils Utilisés
            •	Java : Langage de programmation principal pour l'application.
            •	MySQL : Utilisé pour la base de données locale.
            •	Jira : Utilisé pour suivre l'avancement du projet et gérer les tâches.
            •	GitHub : Utilisé pour partager le code et collaborer entre les membres de l'équipe.
            •	SceneBuilder : Utilisé pour créer l'interface utilisateur graphique via un système de Drag and Drop.


    Installation
            1.	Cloner le dépôt GitHub :
                git clone https://github.com/soufianefikri/Cy-Books_18/tree/main/src
                
                cd cy-book
            2.	Configurer la base de données MySQL :
                1.	Créer une Scheme local nommé cy_books.
                2.	Copier-coller le contenu de script.sql dans un dossier Query sur MySQL.
                3.	Modifier les paramètres de connexion à la base de données dans le fichier connexion.java dans le dossier view. Remplacer les variables USER et PASS pour le nom du propriétaire sur serveur MySQL et son mot de passe.



            3.	Lancer l'application :
                1.	Importer le projet dans votre IDE Java préféré (par exemple, Eclipse).
                2.	Exécuter la classe App.java .


Utilisation
            
            •	Inscription des usagers : Accéder au module d'inscription des usagers et ajouter de nouveaux utilisateurs.
            
            •	Gestion des emprunts : Suivre les emprunts et les retours de livres via le module de gestion des emprunts.


Développement
    
    Méthodologie
          Notre projet a été développé en suivant la méthode SCRUM, ce qui a permis une gestion agile et collaborative du projet. Les réunions quotidiennes et hebdomadaires ont assuré une bonne communication et une bonne répartition des tâches au sein de l'équipe.

