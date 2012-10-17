<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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

        
    </body>
</html>
