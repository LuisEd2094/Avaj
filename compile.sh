#!/bin/bash

if [ "$1" = "del" ]; then
    find . -name "*.class" -type f -exec rm -f {} +
else
    find * -name "*.java" > sources.txt
    javac @sources.txt
    java simulator.Main scenario.txt
fi
