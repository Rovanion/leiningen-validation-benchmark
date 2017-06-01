set terminal pdf enhanced size 10cm,10cm font "Verdana 10"
set output "charts/one-keyword-".ARG1.".pdf"
set boxwidth 0.2 absolute
set title "Validation comparison for key :".ARG1
set ylabel "milliseconds"
set xrange[0:4]
set yrange[0.00005:300]
set logscale y
set grid y

set tics scale 0
set xtics nomirror
set ytics nomirror
set border 2

set style fill solid 0.25 border -1
set style data boxplot

# Data columns: id count min 1st-quart median 3rd-quart max sum std-dev name

plot "data/one-keyword-".ARG1 using 1:4:3:7:6:(0.6):xticlabels(10) with candlesticks linecolor rgb 'orange' title 'Quartiles' whiskerbars, \
		 ''         using 1:5:5:5:5:(0.6) with candlesticks lt -1 notitle
