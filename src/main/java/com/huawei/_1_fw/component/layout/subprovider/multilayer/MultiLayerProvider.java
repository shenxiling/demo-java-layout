package com.huawei._1_fw.component.layout.subprovider.multilayer;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;
import com.huawei._1_fw.component.layout.vo.multilayergraph.MultiLayerGraphVo;

public class MultiLayerProvider {
	//#region layoutFirstLine
	
	public static MultiLayerGraphVo layoutFirstLine(MultiLayerGraphVo oMultiLayerGraphVo) {
		// TODO 
		//1.����ip�����õĵ�һ�Žڵ㣬��oMultiLayerGraphVo.lstEdge������ĵ�һ�Žڵ�
		
		//2.��������ĵ�һ�Žڵ�����ŷŽ�������
		
		//3.�������굽oMultiLayerGraphVo.lstGraph4MultiLayer
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
		//1.����oMultiLayerGraphVo.lstEdge��ȷ���������²��Ӧ��ϵ��Node������
		//1.1.һ��һ�����²�ڵ�����ϲ�ڵ�����·�������layerDistance
		
		//1.2.һ�Զ࣬���һ���²�ڵ��Ӧ����ϲ�ڵ㣬����������ϲ�ڵ����ĵ����·���layerDistance
		
		//1.3.���һ�����ʣ�µĽڵ��У�����²�ڵ��Ӧһ���ϲ�ڵ�
		//1.3.1.��ֱ�ŷţ�����y�����ƫתʱ�������ſ�����ˮƽ���ߴ���һ������
		//1.3.2.���з���,��������㷨��ȷ��
		//(˼·1��graphviz�Ƿ�֧���޶�ĳЩ����һ����Χ�ڵĲ��֣��ƺ�����ֱ��֧��
		//˼·2��������������ֳ����ߣ���θ������߻��֣�����������Ƹ���
		//˼·3������ֱ�ŷţ�ͨ���������ý�������ƶ������������²���)
		
		//2.����ȷ������Node�����lstGraph4MultiLayer��oGraphvizGraphVo��ʹ��layoutInner���в��֣�������һ�㣩
		
		return null;
	}
	
	//#endreigon
}
