
args = commandArgs(T)
if (length(args) < 3) {
	cat("Usage: $ Rscript book.R DATAFILE OUTFILE.png MARKET-ID\n")
	quit(save='no')
}

infile = args[1]
datafile = tempfile()
system(sprintf('grep BOOK %s > %s', infile, datafile))

data = read.table(datafile, comment.char="")
colnames(data) = c('BOOK', 't', 'type', 'market.id', 'price', 'volume')

pngfile = args[2]

market.id = as.integer(args[3])

LIMIT_BUY = 3
LIMIT_SELL = 4
buy = data[(data$type == LIMIT_BUY) & (data$market.id == market.id),]
sel = data[(data$type == LIMIT_SELL) & (data$market.id == market.id),]

ymin = min(data$price)
ymax = max(data$price)

# Discretize
#buy = aggregate(buy$volume, list(t=buy$t, price=round(buy$price, 0)), sum)
#sel = aggregate(sel$volume, list(t=sel$t, price=round(sel$price, 0)), sum)

png(pngfile, width=1200, height=600)
plot(buy$t, buy$price, ylim=c(ymin, ymax), col=rgb(0, 0, 1, 0.2), pch=20, xlab='', ylab='')
points(sel$t, sel$price, ylim=c(ymin, ymax), col=rgb(1, 0, 0, 0.2), pch=20)
title(xlab='Time', ylab='Price')
