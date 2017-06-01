all: per-key summary


per-key:
	gnuplot -c per-key.gnuplot spec
	gnuplot -c per-key.gnuplot schema
	gnuplot -c per-key.gnuplot truss

summary:
	gnuplot -c summary.gnuplot
