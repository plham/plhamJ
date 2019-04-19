
args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript plot.R DATAFILE OUTFILE.png\n");
	quit()
}

datafile = args[1]
pngfile = args[2]

data = read.table(datafile)
colnames(data) = c('session', 't', 'market.id', 'market.name', 'price', 'fundam', 'trade.price', 'trade.volume')

size = 100
lit.vol = filter(data$trade.volume[data$market.name == 'LitMarket'], rep(1, size))
dark.vol = filter(data$trade.volume[data$market.name == 'DarkPoolMarket'], rep(1, size))

png(pngfile, width=640, height=480)
plot(0, type='n', xlim=c(1, nrow(data)/2), ylim=c(0, 100), xlab='t', ylab='Volume')
lines(lit.vol, col='gold')
lines(dark.vol, col='blue')

