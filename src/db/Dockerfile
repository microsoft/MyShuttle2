FROM mysql

ENV MYSQL_RANDOM_ROOT_PASSWORD="yes"
# this is meant for debugging only - DO NOT use in production!
#ENV MYSQL_ROOT_PASSWORD="P@ssw0rd"

ADD schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306