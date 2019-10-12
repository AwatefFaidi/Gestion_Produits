# Gestion_Produits


Cette application permet de gérer des produits (Chercher, saisir, ajouter, éditer, mettre à jour et supprimer des produits).

 Créer une simple base de données MySQL

 Créer la couche DAO pour faire le mapping Objet relationnel avec JDBC. Cette couche DAO se compose de :
o Une entité Produit sur forme d’un simple java Bean
o Une interface IPrdouitDao et une classe PrdouitDaoImpl (implementation) qui déclarer les méthodes permettant de gérer les produits
o Une classe  SingeltonConnexion qui implémente le pattern Singleton de créer de connexion JDBC.
o Une classe TestDAO  pour tester la couche DAO.
 La couche Web :
o Créer un modèle; classe ProduitModel 
o Créer un contrôleur ControleurServlet en utilisant le composant Web Servlet
o Créer des vues JSP basée sur JSTL en utilisant BootStrap.


