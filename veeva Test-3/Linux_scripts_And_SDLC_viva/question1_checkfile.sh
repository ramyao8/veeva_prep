#!/bin/bash
echo "Enter the file name to search in the entire system:"
read filename

result=$(find / -iname "*$filename*" 2>/dev/null)

if [ -n "$result" ]; then
    echo "File(s) '$filename' found at:"
    echo "$result"
else
    echo "File '$filename' does NOT exist in the system."
fi
