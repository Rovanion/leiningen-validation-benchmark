set terminal pdf enhanced size 30cm,21cm font "Verdana,10"
set output "charts/all-keywords-and-systems.pdf"
set boxwidth 0.2 absolute
set title "Validation time per keyword of all systems side by side."
set ylabel "milliseconds"
set xrange[0:18]
set yrange[0.00003:300]
set logscale y
set grid y

set tics scale 0
set xtics rotate by -45
set xtics nomirror
set ytics nomirror
set border 2

set style fill solid 0.25 border -1
set style data boxplot

set key right top

width = 0.1
space = 0.03
start = 0
end   = 16
step  = 17
# Data columns: id count min 1st-quart median 3rd-quart max sum std-dev name
# id
do for [i=0:3] {
	plot "data/all-keywords-Spec" every ::start+step*i::end+step*i using ($1-step*i-width*2-space*2):4:3:7:6:(width):(real('0x'.strcol(10))) \
		with candlesticks linecolor rgb variable title "Spec" whiskerbars, \
		''         every ::start+step*i::end+step*i using ($1-step*i-width*2-space*2):5:5:5:5:(width) with candlesticks lt -1 notitle, \
		"data/all-keywords-Schema" every ::start+step*i::end+step*i using ($1-step*i-width-space):4:3:7:6:(width):(real('0x'.strcol(10))):xticlabels(11) \
		with candlesticks linecolor rgb variable title "Schema" whiskerbars, \
		''         every ::start+step*i::end+step*i using ($1-step*i-width-space):5:5:5:5:(width) with candlesticks lt -1 notitle, \
		"data/all-keywords-Truss" every ::start+step*i::end+step*i using ($1-step*i-0.0):4:3:7:6:(width):(real('0x'.strcol(10))) \
		with candlesticks linecolor rgb variable title "Truss" whiskerbars, \
		''         every ::start+step*i::end+step*i using 1:5:5:5:5:(width) with candlesticks lt -1 notitle, \
		"data/all-keywords-Plain" every ::start+step*i::end+step*i using ($1-step*i+width+space):4:3:7:6:(width):(real('0x'.strcol(10))) \
		with candlesticks linecolor rgb variable title "Plain Clojure" whiskerbars, \
		''         every ::start+step*i::end+step*i using ($1-step*i+width+space):5:5:5:5:(width) with candlesticks lt -1 notitle
}