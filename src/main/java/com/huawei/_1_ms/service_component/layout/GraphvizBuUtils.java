package com.huawei._1_ms.service_component.layout;

import java.util.List;

import com.huawei._1_fw.component.layout.GraphvizUtils;
import com.huawei._1_fw.component.layout.vo.config.GraphvizConfigVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;
import com.huawei._1_ms.service_component.layout.subprovider.cache.GraphvizGraphVoCache;
import com.huawei._1_ms.service_component.layout.subprovider.datatrans.GraphvizGraphVoProvider;
import com.huawei._1_ms.service_component.layout.vo.GraphvizBuGraphVo;

public class GraphvizBuUtils {
	// #region split

	public static String split(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		// ����oGraphvizBuGraphVo������GraphvizGraphVo������ֻ�������ͽڵ�Ĵ�����ϵ��rule�����ϢΪ�գ������
		GraphvizGraphVo oGraphvizGraphVo = GraphvizGraphVoProvider.genGraphvizGraphVo4Subgraph(oGraphvizBuGraphVo);
		GraphvizGraphVoCache.getInstance().setGraphvizGraphVo(oGraphvizGraphVo);
		return null;
	}

	// #endregion

	// #region save
	
	//TODO:���أ������topo��չʾ�����Ϣ��⣬
	public static String save(GraphvizGraphVo oGraphvizGraphVo) {
		// �������ݿ���GraphvizGraphVo��rule�����Ϣ��������xOffsetOnGraph��yOffsetOnGraph��heightOnGraph��widthOnGraph��enumLayoutType��
		GraphvizGraphVoCache.getInstance().setGraphvizGraphVo(oGraphvizGraphVo);
		return null;
	}

	// #endregion

	// #region layout

	//TODO:����or���ⴴ�������Ľӿ�
	public static List<GraphvizNodeVo> layout(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		// 1.���������oGraphvizBuGraphVo�����µ������е�GraphvizGraphVoCache��ֻ���ڽڵ������ı仯���������ֲ��䣩
		GraphvizGraphVo oGraphvizGraphVo = GraphvizGraphVoProvider.genGraphvizGraphVo4Node(oGraphvizBuGraphVo);
		// 2.�������ݿ��еı����GraphvizGraphVo
		GraphvizGraphVoCache.getInstance().setGraphvizGraphVo(oGraphvizGraphVo);

		// 3.����GraphvizConfigVo������GraphvizUtils.layout
		GraphvizConfigVo oGraphvizConfigVo = new GraphvizConfigVo();
		oGraphvizConfigVo.setDirPathRoot("C:\\tmp");
		oGraphvizConfigVo.setGraphvizPath("C:\\tmp\\graphviz.exe");
		return GraphvizUtils.layoutOneLayer(GraphvizGraphVoCache.getInstance().getGraphvizGraphVo(), oGraphvizConfigVo);
	}

	// #endregion
}
