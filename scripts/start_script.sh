#!/bin/bash
java -jar -Dspring.profiles.active=prod /home/ec2-user/crm-0.0.1-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &