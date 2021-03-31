#!/bin/sh
java -jar jenkins-cli.jar -s http://$1/ install-plugin parameterized-trigger <Plugin_1 URL> <Plugin_2 URL> --username $2 --password $3 –restart