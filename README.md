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
**Team:** A team consists of at least two people and at max half the class size <br />
**Happy Team(s):** Teams in which the majority of members are happy to be a part of. <br />
**Team Happiness:** The overall score of the total happiness of a team. <br />
**Individual Happiness:** The happiness rate of each individual in a team. <br />
**Class size:** Class size refers to the number of students per class, before students are divided into groups. </br>

Important Functions
----------
```calcTeamHappiness()``` This calculates the total happiness of each team. </br >
```swapPeople()``` Swaps teams members from one team to another(e.g takes someone from team A to team B, and vice versa . This is meant to increase general team happiness. </br >
```printTeams() ``` Prints the names of everyone in each team. </br >
```calcIndividualHappiness()``` Calculates the happiness for each person, and stores it in the individual happiness array. Can be positive or negative. This is because an individuals happiness can go up or down depending on if they wanted to be on a team with someone. This is shown by putting a positive id in the preferences, meaning they want to be on a team with them, or by putting a negative of the person they don't like's id, showing that they don't want to be on a team with them. </br >
```calcTotalHappiness()``` Calculates the total happiness of everyone in a class. </br >
```fillTeams()``` The this functions takes a document (string), containing the names of everyone. The function then divides the individuals into teams, the ```teamsMatrix``` array, and puts all their preferences into the ```prefsMatrix``` array. If there are few people, the function will fill the end columns in the matrix with null.</br >

Test Functions
---------
```testInizializer()``` This function tests to make sure that the FELiXGang class is initialized correctly. </b >
```testFillMatrix()```  This function checks to make sure that each person is in a team matrix is at the index they are supposed to be </br >
```testHappiness()``` This function tests the happiness of both an individual and that whole team, and makes sure the value is what it is supposed to be. </br >
```testSwap()```  After team members are swapped, this test makes checks to see if swap was done correctly, and the members swapped are at the correct index. </br >
```testSwapHappiness()``` This checks the happiness of each member swapped to make sure that their happiness changed. </br >
```testNegativeHappy()```Checks to see if a persons happiness, or team's negative. The person's happines is negative when one of their preferences is negative. </br >
```testTotalHappiness()``` This tests the total happiness of the class. </br >
```testTotalHappinessSwap()``` Checks the total happines of the class after some team members have been swapped. </br >

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
* Bugfixing
