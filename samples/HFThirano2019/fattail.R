
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
p = rle(p)$values    # Remove unchanged
r = diff(log(p), lag=1)
r = r / sd(r)    # Normalized (sd(r) == 1)

rmax = max(abs(range(r)))
x = c(seq(-rmax, rmax, by=1/2), rmax)
h = hist(r, breaks=x, plot=F)

png(pngfile, width=640, height=480)
plot(h$mids, log(h$density), xlim=c(-10, 10), col='red', xlab='Return / sd(Return)', ylab='log(Density)')
lines(x, log(dnorm(x, 0, 1)))

png(gsub('.png', '-cdf.png', pngfile), width=640, height=480) 
cdf = cumsum(h$density / sum(h$density))
plot(h$mids, log(1 - cdf), xlim=c(-5, 10), col='red', xlab='Return / sd(Return)', ylab='log(1 - CumDensity)')
lines(x, log(1 - pnorm(x, 0, 1)))
