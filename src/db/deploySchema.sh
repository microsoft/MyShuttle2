#!/bin/bash
echo "Starting schema deployment"

MYSQL=`which mysql`
EXPECTED_ARGS=4

if [ $# -ne $EXPECTED_ARGS ]
then
  echo "Usage: $0 mysqlServerName user password schemaFile"
  exit $E_BADARGS
fi

echo "Creating schema"
$MYSQL -h "$1.mysql.database.azure.com" -u "$2@$1" -p$3 MyShuttleDb < $4

echo "Done!"
