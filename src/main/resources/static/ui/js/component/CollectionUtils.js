function CollectionUtils(){
	//#region isEmpty
	
	this.isEmpty4Map = function(mapData){
        for(var strKey in mapData){
            return false;
        }
        return true;
	};
	
	//#endrgion
};
var collectionUtils = new CollectionUtils();