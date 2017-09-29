#!/bin/bash
echo "Starting schema deployment"

MYSQL=`which mysql`
EXPECTED_ARGS=6

if [ $# -ne $EXPECTED_ARGS ]
then
  echo "Usage: $0 mysqlserver adminuser adminpassword username password schemafile"
  exit $E_BADARGS
fi

echo "Creating MyShuttleDb and user/password"
q1="CREATE DATABASE MyShuttleDb;"
q2="GRANT ALL ON MyShuttleDb.* TO '$4'@'*' IDENTIFIED BY '$5';"
q3="FLUSH PRIVILEGES;"
script="${q1}${q2}${q3}"
$MYSQL -h $1 -u$1 -p$2 -e "$script"

echo "Creating schema"
$MYSQL -h $1 -u$4 -p$5 MyShuttleDb < $6

echo "Done!"
