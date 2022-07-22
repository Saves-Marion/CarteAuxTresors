# Carte aux trésors - Marion SAVES

## Problem statement

The objective of this exercise is to retrieve the output configuration of a treasure map after having the adventurers perform their mouvement.

In order to do it, an entry map is given providing :
* The dimension of the map `C - horizontalSize - verticalSize`
* The position of each mountain `M - horizontal - vertical`
* The position of each treasure and the quantity of treasure in each chest `T - horizontal - vertical - quantity of treasure` 
* The informations relative to each adventurers `A - name - horizontal - vertical - orientation - sequence of mouvement`.

Their are some rules : 
* An adventurer cannot go through a mountain 
* An adventurer cannot be in the same position as another adventurer. 
* Moreover, in order to retrieve a treasure the adventurer has to make a mouvement (one cannot be on the same position as a treasure, be frozen by a mountain and retrieve each round a treasure)

## The project
### The architecture
 ```bash
     └───src
        ├───main
        │   ├───java
        │   │   ├───configuration
        │   │   ├───enums
        │   │   ├───exceptions
        │   │   ├───implementation
        │   │   │   ├───file
        │   │   │   └───mouvement
        │   │   └───models
        │   └───ressources
        └───test
            ├───java
            └───ressources
 ```

**main** → The implementation section, where is the code.

**configuration** → Where the path of the inputFile and the outputFile are.

**enums** → Enumerations of the elementType (can be C, M, T or A), the mouvement (A, G, D) and the orientation (N, O, S, E).

**exceptions** → The output messages when an exception is thrown

**implementation** → The code itself, the file part to open, close, read or write and the mouvement part in order to move an adventurer, retrieve a treasure, change the orientation ...

**models** → The description of each entity : Map, Adventurer, Treasure, Mountain

**ressources** → Where some input and output file are. Where one can put their own inputFile.

**test** → The test section, where the TU are.

### The technologies

Java : 1.8.0_162

JUnit : 5.8.1

IDE : Intellij

### Exemple

Input exemple

| First  | Second  | Third | Forth | Fifth | Sixth     |
|--------|---------|-------|-------|-------|-----------|
| C      | 3       | 4     |
| M      | 1       | 0     |
| T      | 0       | 3     | 2     |
 | T      | 1       | 3     | 3     |   
| A      | Lara    | 1     | 1     | S     | AADADAGGA |

Output exemple

| First  | Second  | Third | Forth | Fifth | Sixth |
|--------|---------|-------|-------|-------|-------|
| C      | 3       | 4     |
| M      | 1       | 0     |
| T      | 1       | 3     | 2     |
| A      | Lara    | 0     | 3     | S     | 3     |

## How to start the application

In order to start the application with your own map,
you have to change the path of the input and of the output file here :
``src/main/java/configuration/FileNameConfiguration``

*TIPS: If you want to write the name of your input file you can do it by uncomment the line 25 to 31 in the TreasureMap.runTreasureMap() function. You will have to uncomment the FileNamConfiguration and comment the former ones (in order to remove the 'final' word).*

Then one can open their favorite IDE and execute the Main class.

The solution will appear in the outputFile. One can also see in its console a step by step.
