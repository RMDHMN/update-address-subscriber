#!/bin/bash

PORT=3308
MY_SQL_ROOT_PASSWORD=root
MY_SQL_DATABASE=data-source

echo  -e "--------------------->  deploying $MY_SQL_DATABASE:$PORT/$MY_SQL_DATABASE mysql database\n\n"

 docker run -d -p 127.0.0.1:$PORT:3306 --name=$MY_SQL_DATABASE -e MYSQL_ROOT_PASSWORD=$MY_SQL_ROOT_PASSWORD $MY_SQL_DATABASE

echo  -e "\n\n--------------------->  database $MY_SQL_DATABASE:$PORT/$MY_SQL_DATABASE deployed"