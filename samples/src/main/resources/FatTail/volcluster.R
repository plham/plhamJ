
args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript volcluster.R DATAFILE OUTFILE.png\n");
	quit()
}

datafile = args[1]
pngfile = args[2]

data = read.table(datafile)
colnames(data) = c('session', 't', 'market.id', 'market.name', 'price', 'fundam')

data = data[data$session == 1,]

p = data$price
p = tail(p, -10000)  # Remove initial
p = rle(p)$values    # Remove unchanged
r = diff(log(p), lag=1)

png(pngfile, width=640, height=480)
acf(abs(r)) # With plot