#UI_自定义布局#
##设计目标##

	当前布局组件与用户心中的期望效果存在差异，结合graphviz与arbor.js，制作能支持不同应用场景下布局展示的组件
	
##实现原理_自定义布局组件面对的4种场景##
	
	1.后台业务逻辑完成后直接调用布局组件，布局完成后再将数据传递回前台（此时需要性能强大，支持大量数据的快速计算）
	2.前台展示时，用户选择重新布局（此时同1，需支持大量数据的快速计算）
	3.页面上用户选择特定节点进行局部布局（此时需要快速展示，在前台完成布局工作，不需要调用后台布局API）
	4.根据用户需求，支持不同的布局展示效果（此时需要用户提供一定规则，根据需要定制化一些特性的布局方案）

##实现原理_3依赖的arbor.js##
(1)对外接口:start

(2)callback限流

(3)throttle陷阱

(4)对外接口:stop接口

##实现原理_124依赖的graphviz##
(1)graphviz的架构体系_input相关

(2)graphviz的架构体系_graphviz相关

	[graph1.gv]	
	digraph {
		y1->y2
	    y1->y3
	}

	[graph2.gv]
	digraph {
	    x1->x1
	    x1->x2
	    x2->x3
	    x3->x1
	}
	
	[test.bat]
	cd %~dp0
	dot -o graph1dot.gv graph1.gv
	neato -n2 -Tpng -o graph1dot.png graph1dot.gv
	neato -n2 -Tplain-ext -o graph1dot.txt graph1dot.gv
	circo -o graph2circo.gv graph2.gv
	neato -n2 -Tpng -o graph2circo.png graph2circo.gv
	rem random pack subgraph
	rem gvpack -o graph3.gv graph1dot.gv graph2circo.gv
	rem neato -n2 -Tpng -o graph3neato_n2.png graph3.gv
	rem neato -Tpng -o graph3neato.png graph3.gv
	
(3)graphviz的架构体系_output相关

(4)graphvizUtils的设计

##实现原理_业务系统封装##



# reference #
	
	[jquery throttle]
	http://benalman.com/code/projects/jquery-throttle-debounce/docs/files/jquery-ba-throttle-debounce-js.html
	http://www.cnblogs.com/zztt/p/4098657.html
	
	[graphviz]
	http://www.graphviz.org/Documentation.php
	http://stackoverflow.com/questions/8002352/how-to-control-subgraphs-layout-in-dot
	http://www.banghottv.com/merging-multiple-graphviz-dot-files-in-windows-for-gvpack/
	
	
	
