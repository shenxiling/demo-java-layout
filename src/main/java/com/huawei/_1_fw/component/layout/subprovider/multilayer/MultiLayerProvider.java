package com.huawei._1_fw.component.layout.subprovider.multilayer;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;
import com.huawei._1_fw.component.layout.vo.multilayergraph.MultiLayerGraphVo;

public class MultiLayerProvider {
	//#region layoutFirstLine
	
	public static MultiLayerGraphVo layoutFirstLine(MultiLayerGraphVo oMultiLayerGraphVo) {
		// TODO 
		//1.根据ip层设置的第一排节点，和oMultiLayerGraphVo.lstEdge计算光层的第一排节点
		
		//2.计算两层的第一排节点如何排放交叉最少
		
		//3.更新坐标到oMultiLayerGraphVo.lstGraph4MultiLayer
		return null;
	}
	
	//#endregion
	
	//#region coordinateTransByYAngle
	
	public static List<GraphvizNodeVo> coordinateTransByYAngle(int iYAngle,List<GraphvizNodeVo> lstOriginNode)
	{
		//TODO
		return null;
	}
	
	//#endregion
	
	//#region CoordinateTransByYZplane
	
	public static List<GraphvizNodeVo> coordinateTransByZPlane(int iZPlaneAngle,List<GraphvizNodeVo> lstOriginNode)
	{
		//TODO
		return null;
	}
	
	//#endregion
	
	//#region layoutOtherNode

	public static List<GraphvizNodeVo> layoutOtherNode(MultiLayerGraphVo oMultiLayerGraphVo,List<GraphvizNodeVo> lstRes) {
		// TODO 
		//1.根据oMultiLayerGraphVo.lstEdge，确定存在上下层对应关系的Node的坐标
		//1.1.一对一，则下层节点放在上层节点的正下方，根据layerDistance
		
		//1.2.一对多，如果一个下层节点对应多个上层节点，则放在这多个上层节点中心的正下方，layerDistance
		
		//1.3.多对一，如果剩下的节点中，多个下层节点对应一个上层节点
		//1.3.1.竖直排放，后面y轴进行偏转时，可以排开，与水平连线存在一定交叉
		//1.3.2.进行分类,具体分类算法待确定
		//(思路1：graphviz是否支持限定某些点在一定范围内的布局？似乎不能直接支持
		//思路2：根据连线情况分成两边？如何根据连线划分，而且整体设计复杂
		//思路3：先竖直排放，通过布局配置界面进行移动调整，再重新布局)
		
		//2.将已确定部分Node坐标的lstGraph4MultiLayer中oGraphvizGraphVo的使用layoutInner进行布局（布局这一层）
		
		return null;
	}
	
	//#endreigon
}
