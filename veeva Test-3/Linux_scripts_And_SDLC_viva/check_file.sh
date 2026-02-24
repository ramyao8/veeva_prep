#!/bin/bash

echo "Enter the file name to check in current directory:"
read filename

if [ -e "$filename" ]; then
    echo "File '$filename' exists in the current directory."
else
    echo "File '$filename' does NOT exist in the current directory."
fi
