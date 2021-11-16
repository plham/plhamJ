
ARGS="plham.samples.CI2002.NewCI2002Main samples/src/main/resources/CI2002/config.json 100"
LIFELINE="plham.core.main.glb.PlhamLifeline"
GRAIN=50

#export MPJ_HOME=/work/gp43/share/mpj-v0_44
#export I_MPI_PIN=0

#PLHAMJ_DIR="/work/gp43/share/PlhamJ"
#PROC=${PJM_MPI_PROC}

################################################################################
# ARGUMENTS
################################################################################
# Settings for Simulations
#-------------------------------------------------------------------------------
# 1: Runner used to run the simulation (dist / glb)
# 2: Name of the problem
#        (expecting config.json in /work/gp43/share/PlhamJ/Configs/<var>/)
# 3: Output class
# 4: Integer indicating if warmup is needed
#-------------------------------------------------------------------------------
# Settings for GLB (only concerns "glb" runner)
#-------------------------------------------------------------------------------
# 5: Lifeline strategy used
# 6: Granularity
#-------------------------------------------------------------------------------
# Other settings
#-------------------------------------------------------------------------------
# 7: Jar containing all dependencies
# 8: Core Mapping restriction for taskset command
# 9: Seed
################################################################################


# Depending on $1, determine the main class
if [ $1 == "dist" ]
then
    echo "Dist Runner"
    MAIN=plham.core.main.ParallelRunnerDist
    LOGFILE=dist.log
    CSVFILE=dist_time.csv
else
    echo "GLB Runner"
    MAIN=plham.core.main.glb.GlbRunner
    LOGFILE=glb.log
    CSVFILE=glb_time.csv
fi

#if [ $4 == "0" ]
#then
#    echo "No Warmup"
#    ARGS="$3 ${PLHAMJ_DIR}/Configs/$2/config.json $9"
#else
#    echo "With Warmup"
#    ARGS="$3 ${PLHAMJ_DIR}/Configs/$2/config.json $9 ${PLHAMJ_DIR}/Configs/$2/warmup.json"
#fi


mpirun -n 4 \
       java \
       -cp target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
       -Djava.library.path=$MPJ_HOME/lib \
       -Dplhamj.lifeline=$LIFELINE \
       -Dglb.grain=$GRAIN \
       -Dplhamj.logfile=$LOGFILE \
       handist.collections.launcher.Launcher 0 0 native \
       ${MAIN} ${ARGS}

java -cp target/plhamj-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
       plham.core.main.log.Analyzer -f -t $CSVFILE $LOGFILE
