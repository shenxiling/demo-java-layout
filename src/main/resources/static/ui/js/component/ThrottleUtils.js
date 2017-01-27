/**
 * Created by JHercules on 2017/1/26.
 */
function ThrottleUtils(){
    //#region wrapper

    this.wrapper = function(iDelayMs, oCallback){
        var oCallbackWrapper = $.throttle(iDelayMs, false, oCallback);
        return oCallbackWrapper;
    };

    //#endrgion
};
var throttleUtils = new ThrottleUtils();