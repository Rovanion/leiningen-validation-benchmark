all: all-keywords summary one-keyword


all-keywords:
	gnuplot -c all-keywords.gnuplot Spec
	gnuplot -c all-keywords.gnuplot Schema
	gnuplot -c all-keywords.gnuplot Truss
	gnuplot -c all-keywords.gnuplot Plain

summary:
	gnuplot -c summary.gnuplot all
	gnuplot -c summary.gnuplot passing
	gnuplot -c summary.gnuplot failing

one-keyword:
	for key in $(subst data/one-keyword-,,$(wildcard data/one-keyword-*)); do \
		gnuplot -c one-keyword.gnuplot $$key; \
	done

clean:
	-rm data/*
	-rm charts/*
