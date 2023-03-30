# DominionQuest

DominionQuest is a digital implementation of the board game [Dominion](http://wiki.dominionstrategy.com/index.php/Gameplay).

The current version implements the [First Game](http://wiki.dominionstrategy.com/index.php/First_Game) Kingdom and can be played over the command line interface.

See Releases.  

## Deploy

### As JAR

```
$: ./gradle build jar
```

You'll find the JAR under `build\libs`. Run it with `java -jar <JAR Name>`.  

## (Self) Critique

### Paradigm

Procedural paradigm suits the project better. This type of boardgame has a small number of data structures, but has lots of functions that mutate them.

Data structures rarely change, but functions, in form of new cards, need to be added all the time.

Code is difficult to follow, because every class is connected to every other class.

However, tracking the location of cards is made easy using object-oriented paradigm.

### Testing 

It is difficult to test functions. That is because classes are highly interconnected, without a hierarchy. To test any function a lot of objects needs to be created and populated with default values.

### Card Implementation

They look like functions because each needs to be passed a reference to a player that owns it and the game state that it needs to mutate.
They could have been implemented as procedural functions.
