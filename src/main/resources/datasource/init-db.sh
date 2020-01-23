#!/bin/bash

DATABASE_NAME="data-source"

echo  -e "--------------------->  Initializing mysql:$DATABASE_NAME database\n\n"

docker build -t $DATABASE_NAME .

echo  -e "\n\n--------------------->  Database $DATABASE_NAME initialized"