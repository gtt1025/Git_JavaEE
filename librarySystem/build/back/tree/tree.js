
var openedpicimage="tree/openedpic.gif";
var closedpicimage="tree/closedpic.gif";
var filepicimage="tree/filepic.gif";

var treetext=new Array();
var treelink=new Array();
var treelinktarget=new Array();

var faisunMenu_treeNum=0;

document.write("<style type='text/css'>.blockhide{display:none;} .blockmove{overflow: hidden;height:1px;display:block;} .blockshow{overflow: visible;height:1px;display:block;} .hideme{overflow: visible;display:none;} .showme{overflow: visible;display:block;} .faisunMenu td{font-size:12px;} </style>");

function outinit(itemNo,dir,blockheight){ 
  var subfiles=document.all["item"+itemNo];
  if(blockheight==0){
	subfiles.className="blockshow";
    blockheight=parseInt(subfiles.offsetHeight);
	if(dir>0)subfiles.className="blockmove";
  }
  var outinspeed=blockheight/5;
  var nowheight=parseInt(subfiles.offsetHeight)+outinspeed*dir;
  if(nowheight<=0){
    subfiles.className="blockhide";
	return;
  }else{
    subfiles.className="blockmove";
  }
  if(nowheight>=blockheight && dir>0){
    subfiles.className="blockshow";	
	return;
  }
  subfiles.style.height=nowheight;
  subfiles.scrollTop=blockheight;
  parentsresize(subfiles);
  setTimeout("outinit("+itemNo+","+dir+","+blockheight+")",10);
}

function parentsresize(obj){ 
	do{
		if(obj.className=="faisunMenu"){
			break;
		}
		if(obj.className=="blockshow"){
			obj.style.height="1px";
		}
	}while(obj=obj.parentElement);
}

function showhideit(itemNo){
  var showfolder=document.images["openedpicimage"+itemNo];
  var hidefolder=document.images["closedpicimage"+itemNo];
  var subfiles=document.all["item"+itemNo];
  if(subfiles.className=="blockmove") return;

  if(showfolder.className=="hideme") {
	hidefolder.className="hideme";
    showfolder.className="showme";
	outinit(itemNo,1,0);
  }
  else {
	showfolder.className="hideme";
    hidefolder.className="showme";
	outinit(itemNo,-1,0);
  }
}

function addnode(text,url,target){
  treetext.push(text);
  treelink.push(url?url:"");
  treelinktarget.push(target?target:"main");
}

function getsubnum(text){ 
  var newtext=text.replace(/^-*/,"");
  return text.length-newtext.length;
}


function createtree(){

  faisunMenu_treeNum++;
  var treestatus=new Array();
  var treeendlayer=new Array();
  var openedlayer=new Array();

  var next_subnum=0;
  for(i=treetext.length-1;i>=0;i--){ 
    var subnum=getsubnum(treetext[i]);
	treestatus[i]=0;
	if(subnum<next_subnum){ 
	   treeendlayer[next_subnum]=0;
	   treestatus[i]+=1;
	}
	if(!treeendlayer[subnum]){ 
	   treeendlayer[subnum]=1;
	   treestatus[i]+=2;
	}	
	next_subnum=subnum;
  }
  
  var echo="<div class='faisunMenu'>";
  for(i=0;i<treetext.length;i++){
     if(!treetext[i]) continue;
	 var subnum=getsubnum(treetext[i]);
	 var newtext=treetext[i].replace(/^-*\*?/,"");
	 
	 if(treestatus[i]==1||treestatus[i]==3){
	   var havechild=1;
	 }else{
	   var havechild=0;
	 }

	 if(treestatus[i]==2||treestatus[i]==3){
	   openedlayer[subnum]=0;
	   var barstatus=2;
	 }else{
	   openedlayer[subnum]=1;
	   var barstatus=1;		 
	 }

	 var showme=treetext[i].match(/^-*\*/);
	 var openfold=(i==treetext.length-1?0:treetext[i+1].match(/^-*\*/));
	 var li=i-1;
     if(i>0&&(treestatus[li]==1||treestatus[li]==3)){
	   echo += "<div id='item"+faisunMenu_treeNum+li+"' class='"+(showme?"blockshow":"blockhide")+"'>";
	 }
	 echo += "<table border='0' cellspacing='0' cellpadding='0' "+(subnum==0?"height=30":"")+"><tr>\n";
	for(j=1;j<subnum;j++){
	  echo += "<td width='20' valign=bottom><img src='tree/"+(openedlayer[j]?"bar3.gif":"spacer.gif")+"' width='20' height='20'></td>\n";
	}
	if(subnum>0){
	  echo += "<td width='20' valign=bottom><img src='tree/bar"+barstatus+".gif' width='20' height='20'></td>";
	}
	var clicktoshowhide=(havechild?"onclick='showhideit("+faisunMenu_treeNum+""+i+")' style='cursor:hand' ":"");
    echo += "<td width='22' valign=bottom "+clicktoshowhide+"><img name='openedpicimage"+faisunMenu_treeNum+""+i+"' src='"+(havechild?openedpicimage:filepicimage)+"' class='"+(openfold?"showme":"hideme")+"' width='20' height='20'><img name='closedpicimage"+faisunMenu_treeNum+""+i+"' src='"+(havechild?closedpicimage:filepicimage)+"' class='"+(openfold?"hideme":"showme")+"' width='20' height='20'></td>";
	echo += "<td nowrap valign=bottom><a "+clicktoshowhide+" "+(treelink[i]?"href='"+treelink[i]+"'":"name='#'")+" target='"+treelinktarget[i]+"'>"+newtext+"</a></td></tr></table>\n\n";	

     if(barstatus==2&&!havechild){
	   for(j=subnum;j>=0;j--){
	     if(!openedlayer[j]) echo += "</div>";else break;
	   }
	 }
  }
  echo += "</div>";
  document.write(echo);
  treetext=new Array();
  treelink=new Array();
  treelinktarget=new Array();

}
