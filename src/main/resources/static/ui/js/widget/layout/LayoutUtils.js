/**
 * Created by JHercules on 2017/1/20.
 */
(function($){
    $.LayoutUtils=function(){
        var self=this;
        this.name="LayoutUtils";

        //region Fields

        //options
        this.m_oOptions={
            whOption:undefined,
            dataOption:undefined,
            callbackOption:undefined
        };
        //arbor的ParticleSystem
        var oParticleSystem = arbor.ParticleSystem();
        //stop flag
        var bIsStop = false;

        //endregion

        //region layout

        /**
         * 潜规则：数据结构如下
        var oWhOption={
            width:800,
            height:600
        };
        var oDataOption={
            arborNodes:[{name:"node1", data:{prop1:1,prop2:2}}],
            arborLinks:[{srcNodename:"node1", dstNodeName:"node2", data:{prop1:1, prop2:2}}]
        };
        var oCallbackOption={
            delayMs:5000,
            oRedrawCallback:function(mapNodes){

            }
        };
         * @param oWhOption
         * @param oDataOption
         * @param oCallbackOption
         */
        this.layout = function(oWhOption, oDataOption, oCallbackOption){
            //1.初始化options
            self.m_oOptions = {
                whOption: oWhOption,
                dataOption: oDataOption,
                callbackOption: oCallbackOption
            };

            //2.初始化arbor的粒子系统
            _initParticleSystem(undefined, self.m_oOptions.whOption);

            //3.告知arbor待布局的topo数据信息(添加node/edge)
            for(var i = 0;i < self.m_oOptions.dataOption.arborNodes.length; i++)
            {
                _addArborNode(self.m_oOptions.dataOption.arborNodes[i]);
            }
            for(var j=0;j<self.m_oOptions.dataOption.arborLinks.length;j++)
            {
                _addArborLink(self.m_oOptions.dataOption.arborLinks[j]);
            }

            //4.设定arbor重绘函数的执行方法
            bIsStop = false;
            oParticleSystem.renderer={
                init: function(){

                },
                redraw: throttleUtils.wrapper(self.m_oOptions.callbackOption.delayMs, _redrawCallback)
            };
        };

        var _initParticleSystem = function(oOptions4ParticleSystem, oWhOption){
            //region arbor的粒子系统默认值
//oOptions4ParticleSystem={
//                    repulsion:1000,//排斥力，值越大，目标节点相离越远
//                    stiffness:600,//聚拢度，值越大，目标节点靠得越近
//                    friction:0.5,  //系统的阻尼系数，值为0~1，为1时不能移动
//                    gravity:false,   //引力，是否强制向中间聚拢
//                    fps:55, //每秒多少帧
//                    dt:0.02, //仿真计算时的单位时间长度。。。。？？不确定
//                    precision:0.6  //计算中准确度与速度的均衡，值为0~1,0时速度很快,1时变化很平滑但是需要大量计算
//                };
            //endregion

            //特应性参数设置
            if(oOptions4ParticleSystem){
                oParticleSystem.parameters(oOptions4ParticleSystem);
            }
            oParticleSystem.screenSize(oWhOption.width,oWhOption.height);
        };

        var _addArborNode = function(oArborNode){
            oParticleSystem.addNode(oArborNode.name, oArborNode.data);
        };

        var _addArborLink = function(oArborLink){
            oParticleSystem.addEdge(oArborLink.srcNodeName, oArborLink.dstNodeName, oArborLink.data);
        };

        var _redrawCallback = function(){
            if(!bIsStop){
                var mapNodes={};
                oParticleSystem.eachNode(function(oNode, oPoint){
                    mapNodes[oNode.name]={
                        x:oPoint.x,
                        y:oPoint.y
                    };
                });
                //供用户回调，传递一个全局节点信息的map，key为name，value是x、y坐标
                if(!collectionUtils.isEmpty4Map(mapNodes)) {
                    self.m_oOptions.callbackOption.oRedrawCallback(mapNodes);
                }
            }
        };

        //endregion

        //region stop

        this.stop = function(){
            oParticleSystem.stop();
            bIsStop = true;
        };

        //endregion
    }
})(jQuery);
