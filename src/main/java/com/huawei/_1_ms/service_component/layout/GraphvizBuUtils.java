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
		// 根据oGraphvizBuGraphVo，生成GraphvizGraphVo（其中只有子网和节点的从属关系，rule相关信息为空），入库
		GraphvizGraphVo oGraphvizGraphVo = GraphvizGraphVoProvider.genGraphvizGraphVo4Subgraph(oGraphvizBuGraphVo);
		GraphvizGraphVoCache.getInstance().setGraphvizGraphVo(oGraphvizGraphVo);
		return null;
	}

	// #endregion

	// #region save

	public static String save(GraphvizGraphVo oGraphvizGraphVo) {
		// 更新数据库中GraphvizGraphVo的rule相关信息（子网的xOffsetOnGraph、yOffsetOnGraph、heightOnGraph、widthOnGraph和enumLayoutType）
		GraphvizGraphVoCache.getInstance().setGraphvizGraphVo(oGraphvizGraphVo);
		return null;
	}

	// #endregion

	// #region layout

	public static List<GraphvizNodeVo> layout(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		// 1.根据输入的oGraphvizBuGraphVo，更新到缓存中的GraphvizGraphVoCache（只存在节点增减的变化，子网划分不变）
		GraphvizGraphVo oGraphvizGraphVo = GraphvizGraphVoProvider.genGraphvizGraphVo4Node(oGraphvizBuGraphVo);
		// 2.根据数据库中的表，获得GraphvizGraphVo
		GraphvizGraphVoCache.getInstance().setGraphvizGraphVo(oGraphvizGraphVo);

		// 3.设置GraphvizConfigVo，调用GraphvizUtils.layout
		GraphvizConfigVo oGraphvizConfigVo = new GraphvizConfigVo();
		oGraphvizConfigVo.setDirPathRoot("C:\\tmp");
		oGraphvizConfigVo.setGraphvizPath("C:\\tmp\\graphviz.exe");
		return GraphvizUtils.layout(GraphvizGraphVoCache.getInstance().getGraphvizGraphVo(), oGraphvizConfigVo);
	}

	// #endregion
}
