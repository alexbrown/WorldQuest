#!/usr/bin/env bash

username="Student"
password="zip code"
mysqlIp=$(boot2docker ip)

mysql --user="$username" --password="$password" -h$mysqlIp < database_init.sql
mysql --user="$username" --password="$password" -h$mysqlIp worldquest < database_fixture.sql