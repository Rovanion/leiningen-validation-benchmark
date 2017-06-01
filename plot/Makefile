all: all-keywords summary one-keyword


all-keywords:
	gnuplot -c all-keywords.gnuplot spec
	gnuplot -c all-keywords.gnuplot schema
	gnuplot -c all-keywords.gnuplot truss

summary:
	gnuplot -c summary.gnuplot

one-keyword:
	for key in $(subst data/one-keyword-,,$(wildcard data/one-keyword-*)); do \
		gnuplot -c one-keyword.gnuplot $$key; \
	done
