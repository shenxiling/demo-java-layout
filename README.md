# 目的#

	当前布局组件与用户心中的期望效果存在差异，结合graphviz与arbor.js，制作能支持不同应用场景下布局展示的组件
	
#应用场景#
	
	1.后台业务逻辑完成后直接调用布局组件，布局完成后再将数据传递回前台（此时需要性能强大，支持大量数据的快速计算）
	2.前台展示时，用户选择重新布局（此时同1，需支持大量数据的快速计算）
	3.页面上用户选择特定节点进行局部布局（此时需要快速展示，在前台完成布局工作，不需要调用后台布局API）
	4.根据用户需求，支持不同的布局展示效果（此时需要用户提供一定规则，根据需要定制化一些特性的布局方案）

# 步骤 #

**STEP1.Gradle中引用依赖的jar**
	
	伪工作流，未引入新的jar

**STEP2.编写resources/processes/xxx.bpmn20.xml，这里只是展示工作流的具体流程，程序运行中并未起到配置作用**

工作流wf1	
	
	<?xml version="1.0" encoding="UTF-8"?>
	<definitions
	        xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL"
	        xmlns:activiti="http://activiti.org/bpmn"
	        targetNamespace="Examples">

    	<process id="WF1" name="WF1">
	        <startEvent id="start" />
	        <sequenceFlow id="flow1" sourceRef="start" targetRef="commonStep1" />
	        <serviceTask id="commonStep1" activiti:expression="#{commonStep1.run()}" />
	        <sequenceFlow id="flow2" sourceRef="commonStep1" targetRef="step1" />
	        <serviceTask id="step1" activiti:expression="#{step1.run()}" />
	        <sequenceFlow id="flow3" sourceRef="step1" targetRef="end" />
	        <endEvent id="end" />
    	</process>
	/definitions>
	
工作流wf2

	<?xml version="1.0" encoding="UTF-8"?>
	<definitions
	        xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL"
	        xmlns:activiti="http://activiti.org/bpmn"
	        targetNamespace="Examples">

    	<process id="WF2" name="WF2">
	        <startEvent id="start" />
	        <sequenceFlow id="flow1" sourceRef="start" targetRef="step2" />
	        <serviceTask id="step2" activiti:expression="#{step2.run()}" />
	        <sequenceFlow id="flow2" sourceRef="step2" targetRef="end" />
        	<endEvent id="end" />
    	</process>
	</definitions>
	
**STEP3.编写subprovider/Subprovider4xxx.java，并在subprovider/step中添加这个工作流中特定的STEP，这里以工作流wf1示例**

#####Subprovider4Wf1.java######
这里使用了MsWFProvider这个工具类来调用一个step，具体流程为先根据canRun()这个方法的结果来决定是否执行run()
	
	package com.huawei.client.provider.subprovider;

	import com.huawei._1_fw.component.wf.MsWFProvider;
	import com.huawei.client.provider.subprovider.steps.common.CommonStep1;
	import com.huawei.client.provider.subprovider.steps.wf1.Step1;

	public class Subprovider4Wf1 {
		// #region wf1
	
		public static String wf1() {
			MsWFProvider.fireStep(CommonStep1.class, "StartContext");
			MsWFProvider.fireStep(Step1.class, "CommonStep1Context");
			return "ok";
		}

		// #endregion
	}

#####CommonStep1.java#####
这是一个公共的Step，可以供其它工作流复用，放在step.common这个package下。它同样继承IMsWFStep这个接口，需要实现canRun()和run()这两个方法。

	package com.huawei.client.provider.subprovider.steps.common;

	import org.springframework.stereotype.Component;
	import com.huawei._1_fw.component.wf.IMsWFStep;
	
	@Component
	public class CommonStep1 implements IMsWFStep {
		// #region canRun
	
		@Override
		public boolean canRun(Object oLastStepContext) {
			// 根据业务逻辑实现
			return true;
		}
	
		// #endregion
	
		// #region run
	
		@Override
		public void run(Object oLastStepContext) {
			// 根据上下文执行相应业务逻辑
			if (null != oLastStepContext) {
				System.out.println("CommonStep1_case1...");
			} else {
				System.out.println("CommonStep1_case2...");
			}
		}
	
		// #endregion
	}


#####Step1.java#####
这是此工作流中的特有step，放在step.wf1这个package下，同样继承IMsWFStep这个接口，需要实现canRun()和run()这两个方法。

	package com.huawei.client.provider.subprovider.steps.wf1;

	import org.springframework.stereotype.Component;
	import com.huawei._1_fw.component.wf.IMsWFStep;

	@Component
	public class Step1 implements IMsWFStep {
		// #region canRun
	
		@Override
		public boolean canRun(Object oLastStepContext) {
			// 根据业务逻辑实现
			return true;
		}
	
		// #endregion
	
		// #region run
	
		@Override
		public void run(Object oLastStepContext) {
			// 根据上下文执行相应业务逻辑
			if (null != oLastStepContext) {
				System.out.println("step1_case1...");
			} else {
				System.out.println("step1_case2...");
			}
		}
	
		// #endregion
	}

# reference #
	
	http://benalman.com/code/projects/jquery-throttle-debounce/docs/files/jquery-ba-throttle-debounce-js.html
	http://www.cnblogs.com/zztt/p/4098657.html
	
	
