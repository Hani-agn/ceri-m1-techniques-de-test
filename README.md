# UCE Génie Logiciel Avancé : Techniques de tests
## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 6 fevrier 2024 id_commit : 9425937
- TP2 : 13 fevrier 2024 id_commit : 35db0bb
- TP3 : 5 mars 2024 id_commit : 4142af7
- TP4 : 8 avril 2024 id_commit : 0268bac
- TP5 : 8 avril 2024 id_commit : 0268bac
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.
## Auteur
- Hani Agguini

## Groupe
- M1-IA-Alternant
## lien Documentation

[Lien github pages](https://hani-agn.github.io/ceri-m1-techniques-de-test/target/docs/apidocs)

## Build & Test Status

[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/XBp1AFwr8eHdArhSEtcyDN/78kMs82YpTqBZWETHzqejS/tree/master.svg?style=svg)](https://app.circleci.com/pipelines/circleci/XBp1AFwr8eHdArhSEtcyDN/78kMs82YpTqBZWETHzqejS?branch=master)
## Code Coverage

[![codecov](https://codecov.io/gh/Hani-agn/ceri-m1-techniques-de-test/graph/badge.svg?token=2AH6NOTZK2)](https://codecov.io/gh/Hani-agn/ceri-m1-techniques-de-test)

## Badge checkstyle
![Checkstyle](target/site/badges/checkstyle-result.svg)

## Rapport pour TP6

Les tests unitaires pour la classe RocketPokemonFactory ont été exécutés avec succès, couvrant les fonctionnalités essentielles de la génération de Pokémon. Voici un résumé des tests et de leurs résultats :

Test de Création de Pokémon avec Index Valide

Objectif : Vérifier que la méthode createPokemon crée correctement un Pokémon lorsque l'index fourni est valide et présent dans la map index2name.

Résultat : Le test a confirmé que le Pokémon créé avec un index valide (Bulbasaur avec l'index 1) avait le bon nom, les CP, HP, la poussière et les bonbons assignés correctement, et un IV de 1,0 comme attendu.

Test de Création de Pokémon avec Index Invalide

Objectif : S'assurer que la méthode createPokemon attribue le nom "MISSINGNO" et un IV de 0 pour un index qui n'est pas présent dans la map index2name.

Résultat : Le test a validé que lorsqu'un index invalide est utilisé, le Pokémon créé est bien "MISSINGNO" et l'IV est de 0, indiquant que les valeurs par défaut sont correctement utilisées.

## Conclusions
Les tests ont été exécutés avec JUnit et ont tous passé sans aucune exception. Ces résultats indiquent que la classe RocketPokemonFactory fonctionne comme prévu pour les cas de test considérés.