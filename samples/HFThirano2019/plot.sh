#! /bin/bash
cat output.dat | grep "MarketPrice" > output-marketprice.dat
Rscript plot.R output-marketprice.dat output.png