args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript plot.R DATAFILE OUTFILE.png\n");
	quit()
}

datafile = args[1]
pngfile = args[2]

data = read.table(datafile)
colnames(data) = c('logtype','session', 't', 'market.id', 'market.name', 'price.fundam', 'price.last','price.bestbuy', 'price.bestsell', 'volume')

marketData = data[data$logtype == "MarketPrice",]

png(pngfile, width=640, height=480)

par(oma = c(0, 0, 0, 2))

plot(0, type='n', xlim=c(1, nrow(marketData)), ylim=c(395, 405), xlab='t', ylab='price')
lines(marketData$price.last, col='green')
lines(marketData$price.fundam, col='black')
lines(marketData$price.bestbuy, col='red')
lines(marketData$price.bestsell, col='blue')

par(new = T)
barplot(data$volume, axes = FALSE, ylab = "", ylim=c(0, 100), col="blue")
axis(4)

mtext("volume", side = 4, line = 2)