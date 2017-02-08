package com.huawei._2_sys_layout_designer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;
import com.huawei._1_ms.service_component.layout.vo.GraphvizBuGraphVo;
import com.huawei._2_sys_layout_designer.provider.MainProvider;

@Service
public class LayoutDesignerService {
	// #region split

	public String split(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		return MainProvider.split(oGraphvizBuGraphVo);
	}

	// #endregion

	// #region save

	public String save(GraphvizGraphVo oGraphvizGraphVo) {
		return MainProvider.save(oGraphvizGraphVo);
	}

	// #endregion

	// #region layout

	public List<GraphvizNodeVo> layout(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		return MainProvider.layout(oGraphvizBuGraphVo);
	}

	// #endregion
}
