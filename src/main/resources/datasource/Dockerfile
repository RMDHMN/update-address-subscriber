FROM mysql

ENV MY_SQL_ROOT_PASSWORD=root
ENV MY_SQL_DATABASE=data-source

COPY ./datasource.sql /docker-entrypoint-initdb.d/

EXPOSE 3306
