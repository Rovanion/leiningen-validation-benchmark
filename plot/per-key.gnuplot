set terminal pdf enhanced size 30cm,21cm font "Verdana 10"
set output "charts/per-keyword-".ARG1.".pdf"
set boxwidth 0.2 absolute
set title "Validation time per keyword for ".ARG1
set ylabel "milliseconds"
set xrange[0:65]
set yrange[0.00005:50]
set logscale y
set grid y

set tics scale 0
set xtics rotate by -45
set xtics nomirror
set ytics nomirror
set border 2



# Data columns: X Min 1stQuartile Median 3rdQuartile Max BoxWidth Titles

# set bars 4.0
set style fill solid 0.25 border -1
set style data boxplot


plot "data/per-keyword-".ARG1 using 1:3:2:6:5:(0.6):xticlabels(9) with candlesticks linecolor rgb 'orange' title 'Quartiles' whiskerbars, \
		 ''         using 1:4:4:4:4:(0.6) with candlesticks lt -1 notitle
