
args = commandArgs(T)
if (length(args) < 1) {
	cat("Usage: Rscript statistics.R DATAFILE\n");
	quit()
}

library(e1071)

datafile = args[1]

data = read.table(datafile)
colnames(data) = c('logtype','session', 't', 'market.id', 'market.name', 'price.fundam', 'price.last','price.bestbuy', 'price.bestsell', 'volume')

data = data[data$session == 2,]

p = data$price.last
p = rle(p)$values    # Remove unchanged
r = diff(log(p), lag=1)

cat('{', '"mean":', mean(r),
	',', '"var":', var(r),
	',', '"sd":', sd(r),
	',', '"skew":', skewness(r),
	',', '"kurt":', kurtosis(r),
	'}')
