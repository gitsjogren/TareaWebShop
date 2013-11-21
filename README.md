Web applications/DAT076 HT2012 - TareaWebShop project, Group 02
===============================================================

Documentation to be found in doc folder.

Environment
-----------

To be able to review this project the following is needed:

- Java JDK 1.7
- JEE 6 (including NetBeans 7.x, Tomcat 7.x and GlassFish 3.1.2
- Maven3
- The Derby database (JavaDB)
- Web browser (Firefox or Chrome)
- Git version handling

Fetch the repository
--------------------

https://github.com/gitsjogren/TareaWebShop.git

How to import and build the project
-----------------------------------

- First import both projects into NetBeans and perform `Clean and build` on both.
- Second start the GlassFish server by navigate to `Services` tab and right-click on `GlassFish Server 3.x.x` and select start.
- Now you start the `Java DB` server
- Create a databse with information using this configuration:
Database name: shopdb
Username: apa
Password: apa
- Finally `connect` the database just created.
- Now you should be good to go and be able to run TareaWebShop, after some time a webpage will be displayed in your standard web browser. If not, try to clean and build both projects again.