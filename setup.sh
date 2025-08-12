#! /bin/bash

set -e

echo "Gerando chaves..."
source ./gen-keys.sh

echo "Subindo containers..."
docker compose down
docker compose up -d --remove-orphans

echo "Configurando envs..."
cp ./src/main/resources/.env-example.properties ./src/main/resources/.env-dev.properties
cp ./src/main/resources/.env-example.properties ./src/main/resources/.env-test.properties

echo "Setup concluído!"
