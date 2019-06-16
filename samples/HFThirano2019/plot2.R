args = commandArgs(T)
if (length(args) < 2) {
	cat("Usage: Rscript plot.R DATAFILE OUTFILE.png\n");
	quit()
}

datafile = args[1]
pngfile = args[2]

data = read.table(datafile)
colnames(data) = c('logtype','place', 'freq', 'contract', 'ratio')

data$delta = data$freq - data$contract

png(pngfile, width=640, height=480)

barplot(t(data[,c("contract", "delta")]), names.arg=data$place, axis.lty=1, las=1, cex.names=0.7, beside=F)