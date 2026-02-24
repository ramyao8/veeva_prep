#!/bin/bash
echo "Enter the message to log:"
read message

echo "$(date '+%Y-%m-%d %H:%M:%S') : $message" >>demo.log

echo "Message logged to log.txt"
