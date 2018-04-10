
args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript plot.R DATAFILES... OUTFILE.png\n");
	quit()
}

datafiles = head(args, -1)
pngfile = tail(args, +1)

cat(pngfile)

data = read.table(datafiles[1])
if (length(datafiles) >= 2) {
	PRICE = 5
	for (i in 2:length(datafiles)) {
		data[,PRICE] = data[,PRICE] + read.table(datafiles[i])[,PRICE]
	}
	data[,PRICE] = data[,PRICE] / length(datafiles)
}
colnames(data) = c('session', 't', 'market.id', 'market.name', 'price', 'fundam')

png(pngfile, width=640, height=480)
plot(0, type='n', xlim=c(1, nrow(data)/2), ylim=c(200, 310), xlab='t', ylab='Price')
lines(data$price[data$market.name == 'Market-1'], col='red')
lines(data$price[data$market.name == 'Market-2'], col='green')
lines(data$fundam[data$market.name == 'Market-1'], col='black')
lines(data$fundam[data$market.name == 'Market-2'], col='black')
