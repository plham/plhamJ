library(zoo)

args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript volcluster.R DATAFILE OUTFILE.png\n");
	quit()
}

datafile = args[1]
pngfile = args[2]

data = read.table(datafile)
colnames(data) = c('logtype','session', 't', 'market.id', 'market.name', 'price.fundam', 'price.last','price.bestbuy', 'price.bestsell', 'volume')

data = data[data$session == 2,]

p = data$price.last
msd = rollapply(p, width = 100, FUN = sd)

png(pngfile, width=640, height=480)
acf(abs(msd),1000) # With plot