# demo1
Repositorio de practica Spring framework. Desarrollo de una API basica que pretende disponer al cliente informacion relacionadas a usuarios (nombre, correo, prioridad).

## Herramientas de desarrollo version 1
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
    <li>Instalar: OpenJDK8 (JDK con el que fue testeado) - MySQL - Postman(opcional)</li>
    <li>Clonar repositorio</li>
    <li>Crear una base de datos en MySQL</li>
    <li>Modificar el archivo <code>application.properties</code> con los datos de la base de datos creada</li>
    <li>Ejecutar el proyecto:</li>
    <ul>
        <li>mvnw.cmd spring-boot:run</li>
        <li>./mvnw.cmd spring-boot:run</li>
    </ul>
    <li>Fork repositorio postman para pruebas(opcional)</li>
</ul>

## Flujo de informacion
<img src="assets/Flujo de informacion Spring.png" align="center" style="width: 100%">

## Herramientas de desarrollo version 2
<ul>
    <li>Kibana</li>
    <li>Elasticsearch</li>
    <li>logstash</li>
    <li>filebeat</li>
</ul>

## Ejecutar demo version 2
Integracion de Elastic Stack para la obtencion de datos del sistema y su visualizacion a traves de Kibana. Esto simula un software de monitoreo de informacion el cual nos permitira en un ambiente de produccion conocer el estado de nuestros servicios asi como tambien si estos dan el ancho tanto para la carga de trabajo actual como futura.

<ul>
    <li>Descargar Elastic Stack v8.5.0: <a href="https://www.elastic.co/es/downloads/past-releases">enlace</a></li>
    <li>Descomprimir en directorio 'ELK'</li>
    <li>Reemplazar y modificar archivos de configuracion de la carpeta 'config'</li>
    <li>Inicializar en orden</li>
    <ul>
        <li>Elasticsearch <code>'.\ELK\elasticsearch\bin\elasticsearch.bat'</code></li>
        <li>Kibana <code>'.\ELK\kibana\bin\kibana.bat'</code></li>
        <li>Logstash <code>'.\ELK\logstash\bin\logstash -f logstash.conf'</code></li>
        <li>Filebeat <code>'.\ELK\filebeat\filebeat.exe -c .\ELK\filebeat\filebeat.yml'</code></li>
        <li>Heartbeat <code>'.\ELK\heartbeat\heartbeat.exe -c .\ELK\heartbeat\heartbeat.yml'</code></li>
        <li>Metricbeat <code>'.\ELK\metricbeat\metricbeat.exe -c .\ELK\metricbeat\metricbeat.yml'</code></li>
        <li>Packetbeat <code>'.\ELK\packetbeat\packetbeat.exe -c .\ELK\packetbeat\packetbeat.yml'</code></li>
        <li>API: <code>'.\mvnw spring-boot:run'</code></li>            
    </ul>
</ul>

## Flujo de informacion
