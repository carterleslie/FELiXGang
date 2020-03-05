# FELiXGang
 Happy Teams Project for Carter Leslie, Wade Linder, and Felix Mbikogbia for Dr. Reeves' SE20 CS374.01 class at Abilene Christian University

Pitch
---------
For teachers who need to organize students into teams, the FELiXGang sorting system is a sorting program that sorts students based on their preferences, both positive and negative unlike Canvas' random team creation program.

Our Solution
---------
What makes the FELiXGang sorting system different is that students will be able to list their preferences for other students in a descending list, with the most preferred at the top and scaling down. Along with this, they can also choose a select list of students they'd prefer to not work with by adding a minus sign ```-``` before the student's ID number. Afterwards, the students are sorted into a matrix where they are swapped with other students until an optimal happiness is created using the list of all students available.

#Glossary
==========

General terms
-------------
**Person:** A person is any name inputted in the file that is tied to their preferences. <br />
**Team:** A team consists of at least two people and at max half the class size. <br />
**Happy Team(s):** Teams in which the majority of members are happy to be a part of. <br />
**Happiness:** Happiness is how satisfied or dissatisfied a person is with all of their team members. May be positive or negative depending on if the person wants or does not want to be on a team with their teammate. It is specified in the file if the person wants or does not want to be on a team with other people. <br />
**Individual Happiness:** The happiness rate of each individual in a team. <br />
**Team Happiness:** The overall score of the total happiness of a team. <br />
**Class size:** Class size refers to the number of students per class, before students are divided into groups. </br>

Important Functions
----------
```fillTeams()``` The this functions takes a document (string), containing the names of everyone. The function then divides the individuals into teams, the ```teamsMatrix``` array, and puts all their preferences into the ```prefsMatrix``` array. If there are few people, the function will fill the end columns in the matrix with "null" to represent a fake, placeholder person. </br >
```calcIndividualHappiness()``` Calculates the happiness for each person, and stores it in the individual happiness array. Can be positive or negative. This is because an individuals happiness can go up or down depending on if they wanted to be on a team with someone. This is shown by putting a positive id in the preferences, meaning they want to be on a team with them, or by putting a negative of the person they don't like's id, showing that they don't want to be on a team with them. </br >
```calcTeamHappiness()``` This calculates the total happiness of each team. </br >
```calcTotalHappiness()``` Calculates the total happiness of everyone in a class. </br >
```calcAllHappiness()``` Calls all happiness functions so that they can all be called simultaneously rather than having to all be called implicitly. </br >
```swapPeople()``` Swaps two people so that they both end up in the position of the other after the swap. </br >
```makeBestTeams()``` Makes the best teams, up to the number the user specified, and returns all of the best teams. </br >
```printTeams() ``` Prints the names of everyone in each team, their team number, and their team happiness. </br >

Test Functions
---------
```testInizializer()``` This function tests to make sure that the FELiXGang class is initialized correctly depending on the class size with a constant number of teams and team size. </b >
```testFillMatrix()```  This function checks to make sure that each person is in a team matrix is at the index they are supposed to be when initially filled. </br >
```testHappiness()``` This function tests the happiness of both an individual and a team, and makes sure the value is what it is supposed to be. </br >
```testSwap()```  After team members are swapped, this test checks to see if the members swapped are at the correct index. </br >
```testSwapHappiness()``` This checks the happiness of each member swapped to make sure that their happiness changed. </br >
```testNegativeHappy()```Checks to see if a persons or team's happiness is negative.  </br >
```testTotalHappiness()``` This tests the total happiness of the class. </br >
```testTotalHappinessSwap()``` Checks the total happines of the class after some team members have been swapped. </br >
```testBest()``` Checks to see if all of the sets our program created are better than 0. </br >
```testWrongSwap()``` Tests to see if our code breaks when you try to swap someone outside of the array. </br >
```testBothWrongSwap()``` Tests to see if swapping two people outside the array will cause an error. </br >
```testHappyWrong()``` Tests to see if trying to access a happiness outside of the class size causes an error. </br >
```testFillMatrixWrong()``` Tests to see if trying to return a person from outside the matrix breaks the program. </br >
```testPrefsMatrixIndex``` Tests to see if the preferences are in the right place. </br >
```testGetIDMatrixIndex``` Tests to make sure the ID's in the ID matrix are correct. </br >
```testGetIDMatrixIndexWrong()``` Tests to see if calling an ID outside the ID matrix causes an error. </br >

#Timeline
==========

Week 1
----------
* Basic framework
* Parallel matrices for people and IDs created
* Linked ID matrices to preference arrays

Week 2
----------
* Sort function created
* Accepts input files
* Swap function created
* Fixes

Week 3
----------
* Created a best teams function that swaps people until a truly optimal solution is made
* Allows user-inputted files
* Allows user-inputted command line arguements
* Wrote twice as many more test cases
* Bugfixing

#Master Story
==============

* Brainstorm on project structure and what it will take.
* Write the initializers
* Write a function that feeds data from file into the program (reading student names and preferences into the code)
* Add matrices that store student names and preferences separately.
* Split students into teams
* Write a basic happiness function
* Add more to happiness function, including the calculations of happiness, both individual and group.
* Add swap functions
* Write test functions
* Debug and add more test functions
* Finishing touches (anything that might come up during the project)
* Write the README.md file

#Inception Deck
================

Why are we here? 
------------
The purpose of the project is the design a system that can randomly assign people to teams based on their selected preferences. Our customers could include high school teachers, professors, or any other person that might want to find an easier way of assigning people to teams.

Pitch
---------
For teachers who need to organize students into teams, the FELiXGang sorting system is a sorting program that sorts students based on their preferences, both positive and negative unlike Canvas' random team creation program.

Product Box
-------
If you are a teacher, a professor, or someone that works with teams often, you know team selection can be a hard task. That is why FELiXGang was made to solve the problem. The FELiXGang program uses sophisticated algorithms that easily assigns people in to teams, and even calculates individual and group happiness in the team. If no one is happy with the team, FELiXGang also has a swap algorithm that keeps swapping people in different teams until everyone is happy with their team. Creating teams has never been easier. Get FELiXGang team maker today!

The Not List
------
For this program, there isn’t going to be any user interface. It is a program to run from the terminal only. Also, this program won’t need internet connection to run, so there is no need to worry about that.

Meet Your Neigbors
---
This project only had three people working on it. There wasn’t any third party or anyone else less directly involved with the project that we could meet with.

Our Solution
---------
What makes the FELiXGang sorting system different is that students will be able to list their preferences for other students in a descending list, with the most preferred at the top and scaling down. Along with this, they can also choose a select list of students they'd prefer to not work with by adding a minus sign ```-``` before the student's ID number. Afterwards, the students are sorted into a matrix where they are swapped with other students until an optimal happiness is created using the list of all students available.

What keeps us up at night:
----
This project didn’t have many risks. The major problem was the time for all team members to meet, but though this was the case, team members still managed to meet at least once/twice a week to work on the project.

Size it up: 
---
The project is expected to be for three weeks. The first week will consist of brainstorming and building the project’s basic framework. The second week will consist of add more functionalities, scaling the project, and adding test cases. The third week will consist of creating more functions for swapping team members, adding more test cases, and finishing the debug process.

Be clear on what is going to give
---
For this project, time is the most important thing, followed by quality, then scope. There is not budget needed for the project. The goal is to spend at least 3 hours a week working on the project, and to deliver working software by the end of three weeks.

What is it going to take:
---
It is going to take team collaboration and dedication to finish the project, as well as good team communication.