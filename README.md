## JavaSpringBoot

Spring Boot est un framework qui facilite le développement d'applications fondées sur Spring en offrant des outils permettant d'obtenir une application packagée en JAR, totalement autonome. Ce qui nous intéresse particulièrement, puisque nous essayons de développer des  microservices !

Spring et Spring MVC sont de formidables outils.Néanmoins, un de leurs plus gros problèmes est la configuration (fichiers XML qui indiquent les configurations des servlets, des vues, des contenus statiques, etc.)


❗ Pour simplifier la configuration, Spring Boot propose 2 fonctionnalités principales que nous allons voir dans la suite de ce chapitre :

🍏 L'autoconfiguration.

>Elle permet de configurer automatiquement votre application à partir des JAR trouvés dans votre classpath. En d'autres termes, si vous avez importé des dépendances, Spring Boot ira consulter cette liste, puis produira la configuration nécessaire pour que tout fonctionne correctement.

``` @EnableAutoConfiguration ```

Avec cette annotation, Spring Boot ira scanner la liste de vos dépendances, trouvant par exemple Hibernate. Ayant constaté que vous n'avez défini aucune autre datasource, il créera la configuration nécessaire et l'ajoutera à ApplicationContext.

Vous pouvez très facilement personnaliser ces configurations, en créant vos Beans ou vos propres fichiers de configuration. Spring Boot utilisera alors en priorité vos paramètres.

🍏   Les starters.

- Un starter va apporter à votre projet un ensemble de dépendances, communément utilisées pour un type de projet donné. Ceci va vous permettre de créer un "squelette" prêt à l'emploi très rapidement.

- Gestion des versions. Il vous suffit d'ajouter une simple dépendance au starter de votre choix. Cette dépendance va alors ajouter, à son tour, les éléments dont elle dépend, avec les bonnes versions.


________________________________________________________________________________________________________________________

Maven et Gradle sont deux outils de gestion de projet très populaires dans le monde du développement logiciel, en particulier pour les projets Java. Ils sont utilisés pour automatiser le processus de compilation, de gestion des dépendances, de construction et de déploiement de logiciels. Bien qu'ils aient des objectifs similaires, il y a des différences significatives entre Maven et Gradle en termes de syntaxe, de flexibilité et de fonctionnalités.

Maven :

- Maven est l'un des outils les plus anciens et largement utilisés pour la gestion de projet Java.
- Il utilise des fichiers XML pour décrire la structure du projet, les dépendances et les tâches de construction.
- Les configurations Maven sont généralement plus rigides et suivent une structure pré-définie. Cela peut simplifier la configuration pour les projets standard, mais cela peut devenir contraignant pour les projets plus complexes.
- Maven possède un ensemble de cycles de vie prédéfinis (clean, compile, package, install, etc.) qui dictent l'ordre d'exécution des différentes phases du processus de construction.
- La résolution des dépendances dans Maven est basée sur le concept de "central repository" où les artefacts sont stockés.
- Il peut être moins flexible pour les projets nécessitant des configurations plus avancées ou inhabituelles.

Gradle :

- Gradle est plus récent que Maven et se veut plus flexible et puissant en termes de configuration de projet.
- Il utilise un langage de script Groovy (ou Kotlin) pour décrire la structure du projet et les tâches de construction. Cela permet d'avoir une syntaxe plus expressive et concise par rapport aux fichiers XML de Maven.
- La flexibilité de Gradle permet de personnaliser presque tous les aspects du processus de construction. Cela le rend adapté aux projets complexes et non conventionnels.
- Les "scripts build.gradle" de Gradle décrivent les tâches à exécuter, les dépendances et la façon dont les artefacts sont générés.
- La résolution des dépendances dans Gradle peut être configurée pour utiliser différents référentiels et sources.
- Gradle permet de définir des tâches personnalisées, de gérer des configurations multiples et de réutiliser des blocs de code à travers différents projets.

En résumé, si vous recherchez une solution simple et prédictible pour la gestion de projet Java, Maven pourrait être un bon choix. Si vous avez besoin d'une flexibilité accrue, de meilleures performances et d'une syntaxe plus expressive, Gradle pourrait être plus approprié. Le choix entre les deux dépend des besoins spécifiques de votre projet et de vos préférences en matière de configuration et de syntaxe.

------------------------------------------------------------------------------------------------------------------------

Les formats "jar" et "war" sont deux types d'archives utilisés dans le monde du développement Java pour empaqueter des applications et des composants. Chacun de ces formats est destiné à des types spécifiques de projets et de déploiements.

JAR (Java Archive) :

- Le format JAR est utilisé pour empaqueter des bibliothèques Java, des classes, des ressources et d'autres éléments qui peuvent être réutilisés par d'autres projets Java.
- Les fichiers JAR peuvent contenir du code Java, des fichiers de configuration, des ressources (images, fichiers texte, etc.) et d'autres fichiers nécessaires à l'exécution d'une application.
- Les JAR sont généralement utilisés pour encapsuler des bibliothèques et des modules qui seront partagés entre différentes applications.
- Les JAR peuvent être exécutables en incluant un manifeste qui spécifie la classe contenant la méthode "main" à exécuter.

WAR (Web Archive) :

- Le format WAR est spécialement conçu pour les applications web Java.
- Un fichier WAR est utilisé pour empaqueter une application web complète, y compris les fichiers Java, les fichiers de configuration, les pages JSP, les fichiers HTML, les feuilles de style CSS, les scripts JavaScript et d'autres ressources.
- Les fichiers WAR sont généralement déployés sur des serveurs d'applications Java EE (Enterprise Edition) tels que Apache Tomcat, WildFly, ou IBM WebSphere.
- Un fichier WAR suit une structure spécifique définie par les spécifications Java EE, ce qui permet au serveur d'applications de déployer correctement l'application web.

En résumé, la principale différence réside dans le fait que le format JAR est destiné à l'empaquetage de bibliothèques et de modules Java réutilisables, tandis que le format WAR est spécifiquement conçu pour l'empaquetage d'applications web complètes. Le choix entre les deux dépendra du type de projet que vous développez et du contexte dans lequel vous prévoyez de déployer votre application.

------------------------------------------------------------------------------------------------------------------------
### Swagger

À partir de votre code, Swagger est capable de générer une documentation détaillée au format JSON, répondant aux spécifications OpenAPI. Il vous offre également la possibilité de visualiser cette documentation dans un format HTML élégant.
