# FELiXGang
 Happy Teams Project for Carter Leslie, Wade Linder, and Felix Mbikogbia for Dr. Reeves' SE20 CS374.01 class at Abilene Christian University

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
```testWrongSwap()``` Tests to see if our code breaks when you try to swap someone outside of the array. </br >
```testBothWrongSwap()``` Tests to see if swapping two people outside the array will cause an error. </br >
```testHappyWrong()``` Tests to see if trying to access a happiness outside of the class size causes an error. </br >
```testFillMatrixWrong()``` Tests to see if trying to return a person from outside the matrix breaks the program. </br >
```testPrefsMatrixIndex``` Tests to see if the preferences are in the right place. </br >
```testGetIDMatrixIndex``` Tests to make sure the ID's in the ID matrix are correct. </br >
```testGetIDMatrixIndexWrong()``` Tests to see if calling an ID outside the ID matrix causes an error. </br >