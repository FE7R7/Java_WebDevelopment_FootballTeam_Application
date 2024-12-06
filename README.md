User / Football Team Application

For this project, I implemented an application that manages registered Users who, once logged in, access information about Football Teams.

I tried to make the application intuitive, providing information for each action available on each page. There are also buttons that, depending on the actions available on each page, allow the user to navigate between pages.

The file that needs be run to start the application is indexLogin.jsp. From this page, you can choose to go to the registration page where, in addition to creating an user register, you can also Read a record, Update or Delete a user account, so basically all the CRUD actions.
After registering as an user, you can choose to return to the login page, where once logged in, you will be directed to the welcome page that will allow the user to perform CRUD actions for Football Teams. There is also an extra action that can be chosen, which is to display a list of all registered teams.

From the Team actions page, you can also choose to go to the User actions page, such as logging out, where you will return to the login page.

You will only be possible to access the Teams page if you have user credentials and are logged in.
I also implemented a feature that makes the system more secure from the user's point of view. I added another attribute to the TEAMFOOTBALL table called user_id that creates a link (using foreign key) with the USERFOOTBALL table. I also adjusted the DAO java file, the Servlet java files such as JSP files. This new feature guarantees that the logged-in user will have CRUD access only to the football teams that he or she created, thus ensuring data privacy.

I divided the Java files (Object class, DAO class and all Servlet Controller classes) for User and Football Teams Objects into two packages with their names to identify them.

There are two tables to be created in the Database, one for User with the attributes related to it that are (name, email, password) and a table for Football Teams also with attributes such as (team name, nationality, stadium).
I made the SQL statement available, so that the tables can be created. The sql files are inside the webapp folder inside the project along with the jsp files.

User / Football Team Application

For this project, I implemented an application that manages registered Users who, once logged in, access information about Football Teams.

From the login page user can choose to go to the registration page where, in addition to creating an user register, you can also Read a record, Update or Delete a user account, so basically all the CRUD actions. 
After registering as an user, you can choose to return to the login page, where once logged in, you will be directed to the welcome page that will allow the user to perform CRUD actions for Football Teams. There is also an extra action that can be chosen, which is to display a list of all registered teams.

From the Team actions page, you can also choose to go to the User actions page, such as logging out, where you will return to the login page.

You will only be possible to access the Teams page if you have user credentials and are logged in. I also implemented a feature that makes the system more secure from the user's point of view. I added another attribute to the TEAMFOOTBALL table called user_id that creates a link (using foreign key) with the USERFOOTBALL table. I also adjusted the DAO java file, the Servlet java files such as JSP files. This new feature guarantees that the logged-in user will have CRUD access only to the football teams that he or she created, thus ensuring data privacy.

It was very interesting to see the interaction between the Browser, each Java file with its specific role, and the Database. The pages access being controlled by  credentials authentication was also really cool.
Even though it is a very simple system, it gave me an idea of ​​how many processes that we experience in real life works, such as when we access a website and after logging in, we search for the information we want. 
After all, the basis of the operation and the principles behind it, I believe, are the same as those of a real system.
