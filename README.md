# Library-Simulator
Requirements:
1. Ability to add new library users. There are two types of users:
• Student - can borrow up to 4 books or magazines at one time
• Lecture - can borrow up to 10 books or magazines at a time
Each user must have a name and card number in the library. There may be two
users with the same first and last name but the card number in the library must be unique.
The card number is generated automatically when a user is added to the library- its format doesn't matter.
2. Ability to list all library users. Each row is for a different user
and contains, in the following order: first name, last name, library card number, and type (separated by semicolons).
The type can be S if the user is a student or L if the user is lecturer e.g.:
Piotr;Kowalczyk;13;S
Maria;Nowak;11;S
3. Possibility to add two types of elements to the collection in the library:
• Book - each must have a title and author
• Magazine – each must have a magazine title and number
If an existing book/magazine is added, the number of all available ones should increase copies of this book/magazine. 
The method of adding books and magazines should be able to
adding one or more types of elements, regardless of the type (book, magazine).
4. Possibility to borrow books and magazines, if there are enough copies in the library and the user has the option to borrow another copy.
5. Possibility to list all magazines from the library. 
Each row is for one number and contains, 
in the following order: the title, number, total number of copies, and quantity of available copies (separated by semicolons) e.g.:
Traveler;03/2017;30;17
National Geographic;01/2016;15;13
6. Possibility to list all books from the library.
Each line is for one title and contains, 
in the following order: the title, author, total number of copies, and the number of available copies (separated by semicolons)e.g.:
With Fire and Sword; H. Sienkiewicz;20;7
The Bourne Identity;R. Ludlum;40;33
7. Ability to add a list of books/magazines from a text file. Each row in the file
should include title, author/number, number of copies to be added and type (B – book, M – magazine) separated by a semicolon. 
If there are already some books from the text file in the library, then we increase it
number of copies for these items. Below is an example of the contents of the book file:
With Fire and Sword; H. Sienkiewicz;20;B
The Bourne Identity;R. Ludlum;10;B
Game of Thrones;George R.R. Martin;15;B
National Geographic;01/2016;15;M
8. Ability to save to a new file the card numbers of those library users who have
borrowed copies and for each user listed titles and authors of books or titles and
magazines numbers that they have.  
If someone has several copies of the same book or magazine, it should be displayed several times e.g.:
ID5[With Fire and Sword-H. Sienkiewicz; With Fire and Sword-H.
Sienkiewicz; Traveler-03/2017; National Geographic-01/2016]
ID24[Traveler-03/2017; National Geographic-01/2016]
