# jpa-spring-data

### **Jour 1 : Mapping avancé avec `@Embeddable`, `@ElementCollection`, et relations**

### Concepts à apprendre :

1. **Mapping d'objets composites** : Utilisation de `@Embeddable` et `@Embedded`.
2. **Collections d'éléments** : Utilisation de `@ElementCollection` pour mapper des collections simples ou d'objets.
3. **Annotations avancées** : `@JoinColumn`, `@JoinTable`.

### Projet complet :

**Système de gestion des employés avec profils complexes** :

- Créez une application pour gérer les employés avec des informations personnelles complexes.
- Implémentez une entité `Adresse` avec `@Embeddable` et intégrez-la dans l'entité `Employe`.
- Utilisez `@ElementCollection` pour mapper une collection de numéros de téléphone pour chaque employé.
- Configurez une relation `@OneToOne` entre `Employe` et `Contrat` avec `@JoinColumn`.
- Ajoutez une relation `@OneToMany` entre `Departement` et `Employe`.

---

### **Jour 2 : Relations complexes et propagation (`cascade`, `orphanRemoval`)**

### Concepts à apprendre :

1. **Relations bidirectionnelles** : Gestion des relations `@OneToMany`/`@ManyToOne` bidirectionnelles.
2. **Cascade** : Propagation des opérations CRUD avec `cascade`.
3. **Orphan removal** : Suppression automatique des entités orphelines.

### Projet complet :

**Système de gestion des commandes et produits** :

- Créez une application pour gérer les clients, les commandes et les produits.
- Implémentez une relation bidirectionnelle `@OneToMany` entre `Client` et `Commande`.
- Ajoutez une cascade pour propager les suppressions lorsqu'un client est supprimé.
- Utilisez `orphanRemoval` pour supprimer automatiquement les produits orphelins.
- Testez la suppression en cascade et le comportement des relations bidirectionnelles.

---

### **Jour 3 : Transactions distribuées et gestion des exceptions**

### Concepts à apprendre :

1. **Transactions complexes** : Propagation (`REQUIRED`, `REQUIRES_NEW`), isolation (`READ_COMMITTED`, etc.).
2. **Gestion des exceptions** : `OptimisticLockException`, `EntityNotFoundException`.
3. **Deadlocks** : Détection et résolution des deadlocks dans les transactions.

### Projet complet :

**Système de gestion des paiements et remboursements** :

- Créez une application pour gérer les paiements et les remboursements.
- Implémentez des transactions distribuées pour gérer les paiements et les mises à jour des comptes.
- Testez différents niveaux d'isolation pour éviter les deadlocks.
- Ajoutez une gestion robuste des exceptions pour gérer les erreurs transactionnelles.
- Simulez un scénario de deadlock et proposez une solution.

---

### **Jour 4 : Requêtes personnalisées avec `@Query` et pagination**

### Concepts à apprendre :

1. **Requêtes personnalisées** : Utilisation de `@Query` pour définir des requêtes personnalisées.
2. **Pagination et tri** : Utilisation de `Pageable` et `Sort`.

### Projet complet :

**Système de recherche avancée de produits** :

- Créez une application pour rechercher des produits avec des filtres dynamiques.
- Implémentez des requêtes personnalisées pour filtrer les produits par catégorie, prix et disponibilité.
- Ajoutez une fonctionnalité de pagination et de tri pour afficher les résultats.
- Testez les performances des requêtes avec des volumes importants de données.

---

### **Jour 5 : Optimisation des performances (cache, batch fetching, fetch modes)**

### Concepts à apprendre :

1. **Cache de second niveau** : Configuration avec Hibernate et Ehcache.
2. **Batch fetching** : Utilisation de `@BatchSize` pour optimiser les fetchs.
3. **Fetch mode** : Subselect, JOIN FETCH, Batch Fetch.

### Projet complet :

**Système de gestion des stocks et inventaires** :

- Créez une application pour gérer les stocks et les commandes.
- Configurez un cache de second niveau pour optimiser les performances.
- Utilisez `@BatchSize` et `@Fetch(FetchMode.SUBSELECT)` pour optimiser les requêtes.
- Analysez les performances avec Hibernate Statistics.
- Testez les gains de performance avec des volumes importants de données.

---

### **Jour 6 : Auditing et événements (`@CreatedDate`, `@LastModifiedDate`, Hibernate Envers)**

### Concepts à apprendre :

1. **Auditing** : Utilisation de `@CreatedDate`, `@LastModifiedDate`.
2. **Événements JPA** : `@PrePersist`, `@PostPersist`, `@PreUpdate`.
3. **Audit avec Envers** : Introduction à Hibernate Envers pour l'audit historique.

### Projet complet :

**Système de suivi des modifications des documents** :

- Créez une application pour suivre les modifications apportées aux documents.
- Ajoutez des champs d'auditing (`createdAt`, `updatedAt`) à une entité `Document`.
- Implémentez des événements JPA pour loguer les actions effectuées sur les documents.
- Configurez Hibernate Envers pour suivre l'historique des modifications.
- Testez la traçabilité des données avec des scénarios réels.

---

### **Jour 7 : Requêtes complexes avec QueryDSL et jointures**

### Concepts à apprendre :

1. **Requêtes natives complexes** : Utilisation de `@Query` avec SQL natif.
2. **QueryDSL** : Introduction à QueryDSL pour des requêtes typesafe.
3. **Jointures complexes** : Utilisation de `JOIN FETCH` pour optimiser les requêtes.

### Projet complet :

**API REST pour la gestion des clients et commandes** :

- Créez une API REST pour gérer les clients et leurs commandes.
- Implémentez des requêtes natives pour récupérer des données agrégées (par exemple, le total des commandes par client).
- Utilisez QueryDSL pour créer des requêtes typesafe.
- Ajoutez des jointures complexes pour optimiser les requêtes.
- Testez les performances des requêtes complexes.

---

### **Jour 8 : Projections et DTOs avec MapStruct**

### Concepts à apprendre :

1. **Projections** : Utilisation de projections pour récupérer des données partielles.
2. **DTOs (Data Transfer Objects)** : Mapping d'entités vers des DTOs avec MapStruct.

### Projet complet :

**Application sécurisée pour la gestion des utilisateurs et rôles** :

- Créez une application sécurisée pour gérer les utilisateurs et leurs rôles.
- Implémentez des projections pour récupérer uniquement les champs nécessaires.
- Utilisez MapStruct pour mapper les entités vers des DTOs.
- Transformez des données imbriquées en DTOs.
- Testez la sécurité et la validation des données.

---

### **Jour 9 : Tests et intégration avec Testcontainers**

### Concepts à apprendre :

1. **Tests unitaires** : Tests de repositories avec `@DataJpaTest`.
2. **Tests d'intégration** : Tests complets avec `@SpringBootTest`.
3. **Mocking** : Mock de dépendances avec Mockito.
4. **Testcontainers** : Utilisation de Testcontainers pour tester des bases de données réelles.

### Projet complet :

**Tests pour une application de gestion des commandes** :

- Créez des tests unitaires pour un repository de commandes.
- Implémentez des tests d'intégration pour valider l'ensemble de l'application.
- Utilisez Mockito pour simuler des dépendances externes.
- Intégrez **Testcontainers** pour tester les interactions avec une base de données PostgreSQL.
- Testez les performances et la fiabilité des transactions.

---

### **Jour 10 : Sécurité et validation avec Spring Security**

### Concepts à apprendre :

1. **Sécurité** : Intégration de Spring Security avec Spring Data.
2. **Validation** : Validation des données avec Bean Validation (`@Valid`).

### Projet complet :

**Application sécurisée pour la gestion des utilisateurs et rôles** :

- Créez une application sécurisée pour gérer les utilisateurs et leurs rôles.
- Implémentez des validations pour les champs des formulaires.
- Intégrez Spring Security pour protéger les endpoints.
- Testez la sécurité avec **Testcontainers** pour valider les mécanismes d'authentification et d'autorisation.

---

### **Jour 11-14 : Projet final intégré**

### Projet final :

**Système de gestion complète d'une bibliothèque** :

- Créez une application pour gérer les livres, les membres et les emprunts.
- Implémentez toutes les fonctionnalités vues précédemment : `@Embeddable`, `@ElementCollection`, `@JoinColumn`, relations complexes, transactions, requêtes personnalisées, auditing, optimisations, spécifications, DTOs, tests, sécurité.
- Utilisez **Testcontainers** pour tester l'intégralité de l'application dans un environnement proche de la production.
