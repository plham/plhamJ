#!/bin/bash

# 1: input log file
# 2: destination CSV file

java -cp target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
     plham.core.main.log.Analyzer -fe -t $2 $1
