#!/bin/bash

if [ "$#" -ne 1 ];
    then printf "Usage: $0 <dev/prod>\n"
    exit 85
fi

printf "[down.sh] Tearing down old artifacts\n"
sudo bash down.sh

if [ "$1" == "dev" ];
  then printf "\n[up.sh] Development mode. It won't tear up java microservices\n"
  printf "\n[up.sh] Tearing up database containers\n"
  sudo docker-compose up --build zookeeper kafka schema-registry kowl enviador-prendas enviador-promociones \
  aplicador-promociones-db aplicador-promociones consultador-prendas-db consultador-prendas
  exit 0
fi

if [ "$1" == "prod" ];
  then printf "\n[up.sh] Production mode. It will tear up ALL containers\n"
    sudo mvn clean
    sudo mvn install -Dmaven.test.skip
    sudo docker-compose up --build
fi
