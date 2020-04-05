API POKEMON TYPE
=================

Cette API permet de requêter les pokemons.
Ici les (vrais) pokémons sont présents (soit les 151 premiers pokémons).

2 routes sont possibles :

/pokemon-types
----------

Qui représente l'ensemble des pokémons au format JSON

/pokemon-types/id
----------------------

Qui représente seulement un pokémon au format JSON.
On peut donc tester en remplaçant id par un nombre entre 1 et 151.
Son id correspond à sa place dans le pokedex

Les informations du pokemon sont :
- Son nom
- Sa place dans le pokedex (id)
- Ses stats
- Sa liste de types
- Son poids
- Sa taille

Cette API a été développé en local car le réseau de développement était trop filtré et ne permettait pas un bon usage de l'API.
Elle a été déployé sur Heroku à l'adresse suivante : https://pokemon-type-api-tvanmacke.herokuapp.com/
