set terminal pdf enhanced size 30cm,21cm font "Verdana 10"
set output "charts/all-keywords-".ARG1.".pdf"
set boxwidth 0.2 absolute
set title "Validation time per keyword for ".ARG1
set ylabel "milliseconds"
set xrange[0:67]
set yrange[0.00003:50]
set logscale y
set grid y

set tics scale 0
set xtics rotate by -45
set xtics nomirror
set ytics nomirror
set border 2

set style fill solid 0.25 border -1
set style data boxplot

# Data columns: id count min 1st-quart median 3rd-quart max sum std-dev name
# id
plot "data/all-keywords-".ARG1 using 1:4:3:7:6:(0.6):xticlabels(10) with candlesticks linecolor rgb 'orange' title 'Quartiles' whiskerbars, \
		 ''         using 1:5:5:5:5:(0.6) with candlesticks lt -1 notitle
