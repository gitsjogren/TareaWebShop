<%-- 
    Document   : index.jsp
    Created on : 2012-okt-21, 14:38:06
    Author     : Alexander
--%>

<<<<<<< HEAD
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Tarea's Web Shop!</title>
    </head>
    <body>


        <h1>Welcome to Tarea's Web Shop! </h1>
        
        Don't stand and linger, come and see what's inside our shop!
        <p>Administrators login <a href="./faces/adminPages/home.xhtml">here!</a></p>
           
            <p>Customers can access our store through <a href="./faces/userPages/home.xhtml" >here!</a></p>


=======
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets">
  
        <ui:composition template="./template.xhtml">

            <ui:define name="top">
                Home Page
            </ui:define>

            <ui:define name="left">
                Home Page
            </ui:define>

            <ui:define name="content">
                <p>Request a secure Admin page <a href="secureAdmin/home.xhtml">here!</a></p>
                <p>Request a secure User page <a href="secureUser/home.xhtml" >here!</a></p>
            </ui:define>

        </ui:composition>

</html>

        
>>>>>>> bfd2debddfd07905a9040c1879e855982333be2d
    </body>
</html>
