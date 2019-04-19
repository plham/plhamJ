
args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript plot.R DATAFILE OUTFILE.png\n");
	quit()
}

datafile = args[1]
pngfile = args[2]

data = read.table(datafile)
colnames(data) = c('session', 't', 'market.id', 'market.name', 'price', 'fundam')

shock.at = 100
data$running[1:shock.at] = 'true'    # For visualization

png(pngfile, width=640, height=480)
plot(0, type='n', xlim=c(1, nrow(data)), ylim=c(270, 330), xlab='t', ylab='Price')
lines(data$price, col='red')
lines(data$fundam, col='black')
points(data$price * (data$running == 'false'), pch=20, cex=3, col=rgb(0, 0, 1, 0.05))

