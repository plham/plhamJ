#!/bin/bash
die() { echo "$@"; exit 1; }

home=${0%oacis/run.sh} #'samples/ShockTransfer'

[ $# -ge 3 ] || die "$0: Need more than 3 arguments but [$@]
Usage: $ bash $home/oacis/run.sh ./a.out F1 FI [SEED] >output.dat
  F1  FCNAgent fundamentalWeight trading Market 1
  FI  FCNAgent fundamentalWeight trading IndexMarket I"

[ -x "$1" ] || die "$0: $1 is not executable"

F1=$2
FI=$3
SEED=$4    # may be empty
JSON=$(mktemp)
sed "s/%F1%/$F1/g; s/%FI%/$FI/g" "$home"/oacis/template.json >$JSON

"$1" $JSON $SEED

rm $JSON
