rem #!/bin/sh
rem Ajouter Global/read authorization for anonymous users
java -jar jenkins-cli.jar -s http://localhost:8080/jenkins list-plugins --username admin --password password