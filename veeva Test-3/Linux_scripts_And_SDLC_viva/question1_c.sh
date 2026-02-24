#!/bin/bash

echo "Files larger than 1 KB in current directory ($PWD):"
find . -type f -size +1k
