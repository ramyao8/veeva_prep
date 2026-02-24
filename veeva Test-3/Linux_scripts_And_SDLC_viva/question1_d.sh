#!/bin/bash

echo "Enter the file extension to search (e.g., txt, java, sh):"
read extension

echo "Files with extension .$extension in current directory ($PWD):"
find . -type f -name "*.$extension"
