package com.huawei._2_sys_layout_designer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;
import com.huawei._1_ms.service_component.layout.vo.GraphvizBuGraphVo;

@RestController
public class LayoutDesignerController {
	// #region Fields

	@Autowired
	private LayoutDesignerService layoutDesignerService;

	// #endregion

	// #region split

	@RequestMapping("/split")
	@ResponseBody
	public String split(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		return this.layoutDesignerService.split(oGraphvizBuGraphVo);
	}

	// #endregion

	// #region save

	@RequestMapping("/save")
	@ResponseBody
	public String save(GraphvizGraphVo oGraphvizGraphVo) {
		return this.layoutDesignerService.save(oGraphvizGraphVo);
	}

	// #endregion

	// #region layout

	@RequestMapping("/layout")
	@ResponseBody
	public List<GraphvizNodeVo> layout(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		return this.layoutDesignerService.layout(oGraphvizBuGraphVo);
	}

	// #endregion

}
