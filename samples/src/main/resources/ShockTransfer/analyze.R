
args = commandArgs(T)
if (length(args) < 1) {
	cat("Usage: Rscript analyze.R DATAFILE\n");
	quit()
}

datafile = args[1]

data = read.table(datafile)
colnames(data) = c('session', 't', 'market.id', 'market.name', 'price', 'fundam', 'index')

cat('{', '"divergence":', sum((data$price - data$fundam)[data$market.name == 'SpotMarket-2']), '}')
