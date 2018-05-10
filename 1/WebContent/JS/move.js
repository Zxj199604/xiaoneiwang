window.onload = function(){
  var oTop = document.getElementById("to_top");
  document.onmousemove = function(evt){
    var oEvent = evt || window.event;
    var scrollleft = document.documentElement.scrollLeft || document.body.scrollLeft;
    var scrolltop = document.documentElement.scrollTop || document.body.scrollTop;
    oTop.style.left = oEvent.clientX + scrollleft +10 +"px";
    oTop.style.top = oEvent.clientY + scrolltop + 10 + "px";
  }
}