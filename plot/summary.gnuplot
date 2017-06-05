set terminal pdf enhanced size 7cm,7cm font "Verdana,9"
set output "charts/summary-".ARG1.".pdf"
set boxwidth 0.2 absolute
set title "Validating time for ".ARG1." data"
set ylabel "milliseconds"
set xrange[0:5]
set yrange[0.00003:300]
set logscale y
set grid y
set tics scale 0
set xtics nomirror
set ytics nomirror
set border 2

set style fill solid 0.25 border -1
set style data boxplot

# id 1st min max 3rd
plot "data/summary-".ARG1 using 1:3:2:6:5:(0.6):xticlabels(10) with candlesticks title 'Quartiles' linecolor rgb 'orange' whiskerbars, \
		 ''         using 1:4:4:4:4:(0.6) with candlesticks lt -1 notitle
