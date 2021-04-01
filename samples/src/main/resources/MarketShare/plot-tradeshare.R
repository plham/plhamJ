
args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript plot.R DATAFILE OUTFILE.png\n");
	quit()
}

datafile = args[1]
pngfile = args[2]

data = read.table(datafile)
colnames(data) = c('session', 't', 'market.id', 'market.name', 'price', 'fundam', 'trade.volume')

png(pngfile, width=640, height=480)
volumeA = filter(data$trade.volume[data$market.name == 'Market-A'], rep(1, 100))
volumeB = filter(data$trade.volume[data$market.name == 'Market-B'], rep(1, 100))
shareB = volumeB / (volumeA + volumeB)
plot(shareB, ylim=c(0, 1), xlab='t', ylab='Share (Market B)', col='red')

