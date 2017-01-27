/**
 * Created by JHercules on 2017/1/20.
 */
(function($){
    $.CanvasUtils=function(){
        var self=this;
        this.name="CanvasUtils";

        //region Field

        var oCanvas= $("#myCanvas");
        var oCanvasText = oCanvas[0].getContext("2d");

        //endregion

        //region drawNode

        this.drawDot=function(strColor,iX,iY,iR){
            oCanvasText.fillStyle=strColor;
            oCanvasText.beginPath();
            oCanvasText.arc(iX,iY,iR,0,Math.PI*2,true);
            oCanvasText.closePath();
            oCanvasText.fill();
        };

        //endregion

        //region drawLine

        this.drawLine=function(strColor,iSrcX,iSrcY,iDstX,iDstY){
            oCanvasText.fillStyle=strColor;
            oCanvasText.moveTo(iSrcX,iSrcY);
            oCanvasText.lineTo(iDstX,iDstY);
            oCanvasText.stroke();
        };

        //endregion

        //region clear

        this.clear= function () {
            oCanvasText.clearRect(0,0,oCanvas[0].width,oCanvas[0].height);
        };

        //endregion
    }
})(jQuery);