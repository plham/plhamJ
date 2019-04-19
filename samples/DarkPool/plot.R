library(zoo)

args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript plot.R DATAFILE OUTFILE.png\n");
	quit()
}

datafile = args[1]
pngfile = args[2]

data = read.table(datafile)
colnames(data) = c('session', 't', 'market.id', 'market.name', 'price', 'fundam', 'trade.price', 'trade.volume')

trade.price = na.locf(data$trade.price[data$market.name == 'DarkPoolMarket'], na.rm=FALSE)
trade.price[is.na(trade.price)] = 300

png(pngfile, width=640, height=480)
plot(0, type='n', xlim=c(1, nrow(data)/2), ylim=c(280, 320), xlab='t', ylab='Price')
lines(data$price[data$market.name == 'LitMarket'], col='gold')
lines(data$price[data$market.name == 'DarkPoolMarket'], col='blue')
lines(data$fundam[data$market.name == 'LitMarket'], col='black')
lines(trade.price, col='red')

