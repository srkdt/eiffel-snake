# SNAKEIFFEL

Coding II & Software Engineering - Project

Members: Enzo Job, Michiel Kindt, Théo Rey

## Table of contents
1. [Prelude](#prelude)
    + [Goal](#goal)
    + [Conditions](#conditions)
1. [Build instructions](#build-instructions)
1. [Operating manual](#operating-manual)
1. [Userstories](#userstories)
1. [Releaseplan](#releaseplan)
1. [Documentation - Sprint 1](#documentation-sprint-1)
    + [Tasklist - Sprint 1](#tasklist)
    + [Important code snippets - Sprint 1](#important-code-snippets)
1. [Documentation - Sprint 2](#dokumentation-sprint-2)
    + [Tasklist - Sprint 2](#tasklist)
    + [Important code snippets - Sprint 2](#important-code-snippets)
1. [Test cases](#test-cases)

## Prelude
Welcome to our project "SNAKEIFFEL" ! The project consists of our own interpretation of the well known and often copied game "SNAKE".
The player controls the snake on by changing directions on the playfield.
The goal of the game lies in collecting points by eating Apples, without letting the snake eat his own Tail.
The game doesn't need an internet connection and can be played alone.
It is a great idea to spend some fun time and to sharpen your reflexes.

### Goal
The aim is to combine the skills and competencies learned in programming and software engineering within a single project.
For development we're using the SCRUM framework.
We are planning on two sprints for this project.

### Conditions
* The game should be programmed with JAVA
* The project should be published on GitHub.
* The build automation should be done with MAVEN.
* This program should be playable on MAC, Windows and Linux Computers.
* The classes of the program should have the appropriate Unit-Tests.
* The program should be able to be executed using a specially created JAR file and the command java-jar xxxxx.jar.

## Build instructions
* Laden Sie die Datei .jar auf ihren Computer runter.
* Vergewissern Sie sich, dass Sie eine Java Runtime Environment auf Ihrem Computer installiert haben.
* Klicken Sie (Doppelklick) auf ebenjene, um die Datei auszuführen.

## Operating manual
Here is a short introduction to our game: 
* After starting the game, a start interface will appear with different buttons: START, EXIT....
* The goal is to eat as many apples as possible to make the snake grow  
* Each apple eaten gives 20 points 
* When you bump into yourself you will die 
* You can return to the menu or exit the game at any time 

## Userstories
| **Userstory Nr.** |   **Userstories**  | **Storypoints**  |  **Priority**  |  **Acceptance criteria** |
|:-:|-----|:-:|:-:|-----|
| 1 | As a player I want to eat apples to win points and grow | 3 | 1 | Points are added when the snake eats an Apple, the snake growswith each apple |
| 2 | As a user I would like to be able to enter difficulty parameters | 2 | 3 | The player can choose between several levels of difficulty |
| 3 | As a user I would like to be able to start over or leave at the end of the game | 3 | 2 | A menu asks the player after the end of a game if he wants to restart or to quit the game |
| 4 | As a user I want to see an animation and my final score at the end of the game | 3 | 3 | The end score is displayed at the end of a game with a small animation |
| 5 | As a user I want to have a good looking interface | 3 | 3 | The interface should look good |
| 6 | As user I would like to see my current score | 2 | 1 | The current score is displayed and updated in real time during the game |
| 7 | As a programmer I want to be able to reproduce the program easily in order to rebuild it, maintain it and add new features. | 2 | 2 |  Comments in the code. Logical structure (classes, methods, variables) |
| 8 | As a user I would like to be able to move with the arrow keys | 5 | 1 | The player uses the arrow keys to change the directions of the snake |
| 9 | As a user I would like to have game options | 2 | 3 | Game options are implemented to let the player choose between different grafical sprites |

## Releaseplan
|  **Sprint 1** | **Sprint 2**  |
|-----|-----|
|  **Userstory 1:**  Eat apples | **Userstory 2:**  Difficulty parameters  |
|  **Userstory 3:**  Start over | **Userstory 4:**  Final score  |
|  **Userstory 6:**  Current score | **Userstory 5:**  Good looking interface  |
|  **Userstory 7:**  Logical structure | **Userstory 9:**  Game options  |
|  **Userstory 8:**  Arrow keys |   |
	
## Documentation - Sprint 1
### Tasklist
| Tasknumber | Tasks | Userstory | Estimated effort |
|:-:|-----|:-:|:-:|
| 1 | Create and display apples randomly | 1 | 2 Stunden |
| 2 | Increment the score with each apple eaten | 1 | 1 Stunde |
| 3 | Extend the snake with every apple | 1 | 2 Stunden |
| 4 | Implement options for start/end | 3 | 30 min |
| 5 | Implement menu  | 3 | 30 min |
| 6 | Display score somewhere| 6 | 20 min |
| 7 | Reset score at death | 6 | 1 Stunde |
| 8 | Classes should be well divided | 7 | 30 min |
| 9 | Add a comment | 7 | 20 min    |
| 10 | Respect conventions | 7 | 20 min |
| 11 | Create interface | 8 | 1 Stunde |
| 12 | Implementing movements | 8 | 4 Stunden |
| 13 | Prevent forbidden movements | 8 | 2 Stunden |

### Important code snippets

## Documentation - Sprint 2
### Tasklist
| Tasknumber | Tasks | Userstory | Estimated effort |
|:-:|-----|:-:|:-:|
| 1 | Adjust speed of the snake| 2 | 1 Stunden |
| 2 | Show Endscore | 4 | 1 Stunden |
| 3 | Create animation(s) | 4 | 10 min |
| 4 | Implement animation | 4 | 10 min |
| 5 | Menu presentation | 5 | 2 Stunden |

### Important code snippets


## Test cases
| Test Case # | Description | Test Data | Expected Result | Actual Result | Pass/Fail |
|:-:|-----|:-:|:-:|:-:|:-:|
| 1 |  |
