#!/bin/bash

echo "Enter HTML file name:"
read filename

echo "Enter tag name:"
read tag

if [ -f "$filename" ]; then
    echo "Content inside <$tag> tag:"
    grep -oP "(?<=<$tag>).*?(?=</$tag>)" "$filename"
else
    echo "File does not exist."
fi
