all: per-key summary comparison-key


per-key:
	gnuplot -c per-key.gnuplot spec
	gnuplot -c per-key.gnuplot schema
	gnuplot -c per-key.gnuplot truss

summary:
	gnuplot -c summary.gnuplot

comparison-key:
	for key in $(subst data/comparison-keyword-,,$(wildcard data/comparison-keyword-*)); do \
		gnuplot -c comparison-key.gnuplot $$key; \
	done
