#!/bin/bash

echo "Enter a command to execute:"
read user_command

$($user_command 2>>error.log)
echo "If there were any errors, they have been logged to error.log"
