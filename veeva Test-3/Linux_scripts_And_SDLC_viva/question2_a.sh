#!/bin/bash
echo "Enter the file name to search in:"
read filename

echo "Enter the string to search for:"
read searchString


echo "Searching for '$searchString' in '$filename'..."
grep -n "$searchString" "$filename"

if [ $? -ne 0 ]; then
    echo "String '$searchString' not found in '$filename'."
fi
