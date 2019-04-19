
args = commandArgs(T)
if (length(args) < 1) {
	cat("Usage: Rscript statistics.R DATAFILE\n");
	quit()
}

library(e1071)

datafile = args[1]

data = read.table(datafile)
colnames(data) = c('session', 't', 'market.id', 'market.name', 'price', 'fundam')

data = data[data$session == 1,]

p = data$price
p = tail(p, -10000)  # Remove initial
p = rle(p)$values    # Remove unchanged
r = diff(log(p), lag=1)

cat('{', '"mean":', mean(r),
	',', '"var":', var(r),
	',', '"sd":', sd(r),
	',', '"skew":', skewness(r),
	',', '"kurt":', kurtosis(r),
	'}')
