set terminal pdf enhanced size 10cm,10cm font "Verdana 10"
set output "charts/summary.pdf"
set boxwidth 0.2 absolute
set title "Validating all data"
set ylabel "milliseconds"
set xrange[0:4]
set yrange[0.0001:300]
set logscale y
set grid y

set tics scale 0
set xtics rotate by -45
set xtics nomirror
set ytics nomirror
set border 2

set style fill solid 0.25 border -1
set style data boxplot


plot "data/summary" using 1:3:2:6:5:(0.6):xticlabels(9) with candlesticks title 'Quartiles' linecolor rgb "orange" whiskerbars, \
		 ''         using 1:4:4:4:4:(0.6) with candlesticks lt -1 notitle
