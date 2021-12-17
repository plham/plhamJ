echo "Dist Runner with LB"

ARGS="plham.samples.CI2002.NewCI2002Main samples/src/main/resources/CI2002/config.json 100"
MAIN=plham.core.main.ParallelRunnerDistManualLB
LOGFILE=dist.log
CSVFILE=dist_time.csv

mpirun -n 4 \
       java \
       -cp target/plhamj-v1.0.0-jar-with-dependencies.jar \
       -Djava.library.path=$MPJ_HOME/lib \
       -Dplhamj.lifeline=$LIFELINE \
       -Dglb.grain=$GRAIN \
       -Dplhamj.logfile=$LOGFILE \
       -Dplham_runner_dist.lbdump=distrib.csv \
       -Dplham_runner_dist.lbstrategy=levelextremes \
       -Dplham_runner_dist.lbperiod=10 \
       handist.collections.launcher.Launcher 0 0 native \
       ${MAIN} ${ARGS}

#java -cp target/plhamj-v1.0.0-jar-with-dependencies.jar \
#       plham.core.main.log.Analyzer -f -t $CSVFILE $LOGFILE

echo "Distribution evolution over the course of the program will now be printed"
cat distrib.csv
