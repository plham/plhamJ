#!/bin/bash
die() { echo "$@"; exit 1; }

home=${0%oacis/plot.sh} #'samples/ShockTransfer'

[ $# -ge 1 ] || die "$0: Need more than 1 arguments but [$@]
Usage: $ bash $home/oacis/plot.sh output.png"

[ -n "$1" ] || die "$0: $1 must be an non-empty string"

Rscript "$home"/plot.R $(find _input -name '_stdout.txt') "$1"
