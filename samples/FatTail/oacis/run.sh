#!/bin/bash
die() { echo "$@"; exit 1; }

home=${0%oacis/*.sh}

[ $# -ge 4 ] || die "$0: Need more than 4 arguments but [$@]
Usage: $ bash $0 ./a.out F C N [SEED] >output.dat
  F  FCNAgent fundamentalWeight
  C  FCNAgent chartWeight
  N  FCNAgent noiseWeight"

[ -x "$1" ] || die "$0: $1 is not executable"

F=$2
C=$3
N=$4
SEED=$5    # may be empty
JSON=$(mktemp)
sed "s/%F%/$F/g; s/%C%/$C/g; s/%N%/$N/g" "$home"/oacis/template.json >$JSON

"$1" $JSON $SEED

rm $JSON
