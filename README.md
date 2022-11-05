# demo1
Repositorio de practica Spring framework. Desarrollo de una API basica que pretende disponer al cliente informacion relacionadas a usuarios (nombre, correo, prioridad).

## Herramientas de desarrollo
<ul>
    <li>Video de referencia: <a href="https://www.youtube.com/watch?v=vTu2HQrXtyw&t=15s">enlace</a></li>
    <li>Microsoft Visual Studio Code</li>
    <ul>
        <li>VSCode Extension Spring Boot Extension Pack</li>
    </ul>
    <li>Open JDK 8</li>
    <li>Postman</li>
    <ul>
        <li>Postman Workspace: <a href="https://www.postman.com/aerospace-cosmonaut-18829270/workspace/spring-framework">enlace</a></li>
    </ul>
    <li>Spring framework v2.7.5</li>
    <li>Maven Project</li>
    <li>Maven dependency</li>
    <ul>
        <li>mysql-connector-java: Dependencia de Spring para la conexion a base de datos MySQL</li>
        <li>spring-boot-starter-data-jpa: Dependencia de Spring para mapear datos</li>
        <li>spring-boot-starter-test</li>
        <li>spring-boot-starter-web</li>
        <li>spring-boot-starter-tomcat</li>
    </ul>
</ul>

## Ejecutar demo1
<ul>
    <li>Instalar: OpenJDK8 (JDK con el que fue testeado) - MySQL - Postman(si prefiere)</li>
    <li>Clonar repositorio</li>
    <li>Crear una base de datos en MySQL</li>
    <li>Modificar el archivo <code>application.properties</code> con los datos de la base de datos creada</li>
    <li>Ejecutar el proyecto:</li>
    <ul>
        <li>mvnw.cmd spring-boot:run</li>
        <li>./mvnw.cmd spring-boot:run</li>
    </ul>
    <li>Fork repositorio postman para pruebas</li>
</ul>

## Imagenes
<h3>Flujo de informacion</h3>
<img src="assets/Flujo de informacion Spring.png" align="center" style="width: 100%">
