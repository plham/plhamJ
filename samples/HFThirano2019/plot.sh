#! /bin/bash
cat output.dat | grep "MarketPrice" > output-marketprice.dat
cat output.dat | grep "HFTOrderPlace" > output-orderplace.dat
Rscript plot.R output-marketprice.dat output.png
Rscript plot2.R output-orderplace.dat output2.png
Rscript volcluster.R output-marketprice.dat volcluster.png
Rscript fattail.R output-marketprice.dat fattail.png
Rscript statistics.R output-marketprice.dat