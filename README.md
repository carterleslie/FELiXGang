# FELiXGang
 Happy Teams Project for Carter Leslie, Wade Linder, and Felix Mbikogbia for Dr. Reeves' SE20 CS374.01 class at Abilene Christian University

#Glossary
==========

General terms
-------------
**Team** <br /> A team consists of at least two people or more <br />
**Happy Team(s)** <br /> Teams in which the majority of members are happy to be a part. <br />
**Team Happiness** <br /> The overall score of the total happiness of a team. <br />
**Individual Happiness** <br /> The happiness rate of each individual in a team. <br />
**Class size** </br > Class size refers to the number of students per class, before students are divided into groups. </br>

Important Functions
----------
```calcTeamHappiness()``` This calculates the total happiness of each team. </br >
```swapPeople()``` Swaps teams members from one team to another(e.g takes someone from team A to team B, and vice versa . This is meant to increase general team happiness. </br >
```printTeams() ``` Prints the names of everyone in each team. </br >
```calcIndividualHappiness()``` Calculates the happiness for each person, and stores it in the happiness array. </br >
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


  
