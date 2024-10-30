DUE Tuesday 29th,

This java program focuses on implementing a single linked list.   

Use three classes: 
- listNode 
- phonebookManager
- TestClass (aka main method) - this should be small, maybe a switch case menu?

The phone book node should contain at least name, address, city, and phone number fields in the phonebook node. 

The phonebook manager will allow you to either add an entry (name, address, city, phone #) to the end and then sort it, or alphabetically by last name.  

BONUS: You can also modify the entry, delete entries, or move them from the Bellingham to the Seattle phone book (optional).  
		- packages?

Finally, you should be able to print out your list in a nice format. 

Feel free to run any extra credit ideas by me that you may have.  I love giving out extra credit.

* https://chatgpt.com/share/67198006-a840-8001-845f-dbffa47c9b57
* https://www.geeksforgeeks.org/how-to-sort-a-linkedlist-in-java/ 
* https://www.youtube.com/watch?v=N6dOwBde7-M
* Modify: 
	* https://www.geeksforgeeks.org/modify-contents-linked-list/#
	* https://www.prepbytes.com/blog/linked-list/modify-contents-of-linked-list/#tabs_desc_4643_3
	* **Winner** https://www.geeksforgeeks.org/linkedlist-set-method-in-java/
* Video
	* object to linked list https://www.youtube.com/watch?v=1Jz89NiXr1I
	* https://www.youtube.com/watch?v=POh2z5TWDmk


Darrell - 

 I left name a string to account for non-western naming cultures. This will account for people with mulitple last names or who reverse the usual first name first paradigm.  It does make it harder to sort. 

 I don't have ENUMS because name, addy, city and phNum are open-ended data that users can fill with any value.  ENUMS work best with things like days of the week or months of the year where the values are known and limited.