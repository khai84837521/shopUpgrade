if(!window.console)window.console={};if(!window.console.log)window.console.log=function(){};if(!window.console.warn)window.console.log=function(){};if(!window.console.error)window.console.log=function(){};if(!window.console.time)window.console.log=function(){};if(!window.console.timeEnd)window.console.log=function(){};if(!Array.prototype.indexOf){Array.prototype.indexOf=function(obj,start){for(var i=start||0;i<this.length;i++){if(this[i]==obj){return i}}}}(function($,global,GsBase){"use strict";var userAgent=global.navigator.userAgent;var flatForm=global.navigator.platform.toLowerCase();var root=global.document.documentElement;var osFilter="win16|win32|win64|mac";if(!$.browser){$.browser={};$.browser.msie=false;$.browser.version=0;if(navigator.userAgent.match(/MSIE ([0-9]+)\./)){$.browser.msie=true;$.browser.version=RegExp.$1}}switch(true){case/Android/.test(userAgent):GsBase.os="android";break;case/iPhone|iPad|iPod/i.test(userAgent):GsBase.os="ios";break;case/MacOSX/.test(userAgent):GsBase.os="mac";break;case/X11/.test(userAgent):GsBase.os="unix";break;case/Linux/.test(userAgent):GsBase.os="linux";break;case/Windows NT 6.4|Windows NT 10.0/i.test(userAgent):GsBase.os="win10";break;case/Windows NT 6.3|Windows NT 6.2/i.test(userAgent):GsBase.os="win8";break;case/Windows NT 6.1/.test(userAgent):GsBase.os="win";break;default:GsBase.os=/win/.test(flatForm)?"win":flatForm}switch(true){case/iPhone|iPad|iPod/i.test(userAgent):GsBase.device=GsBase.device=="mobile"&&/iPad/i.test(userAgent)?"tablet":GsBase.device;break;case/Android/.test(userAgent):GsBase.device=GsBase.device=="mobile"&&!/Mobile/i.test(userAgent)?"tablet":GsBase.device;break;default:GsBase.device="pc"}if(GsBase.device!="pc"&&osFilter.indexOf(flatForm)>0){GsBase.device="pc-"+GsBase.device}switch(true){case/MSIE/.test(userAgent):GsBase.browserName=/Touch/.test(userAgent)?"ie-touch":"ie";GsBase.browserVersion=userAgent.match(/MSIE ([\d]+)/)[1];global.bVer=GsBase.browserVersion;break;case/Trident/.test(userAgent):GsBase.browserName=/Touch/.test(userAgent)?"ie-touch":"ie";GsBase.browserVersion=4+parseInt(userAgent.match(/Trident\/([\d]+)/)[1]);global.bVer=GsBase.browserVersion;break;case/Edge/.test(userAgent):GsBase.browserName="edge";GsBase.browserVersion=userAgent.match(/Edge\/([\d\.]+)/)[1];global.bVer=0;break;case/Chrome/.test(userAgent):GsBase.browserName="chrome";GsBase.browserVersion=userAgent.match(/Chrome\/([\d\.]+)/)[1];global.bVer=0;break;case/Safari/.test(userAgent):GsBase.browserName="safari";GsBase.browserVersion=userAgent.match(/Safari\/([\d\.]+)/)[1];global.bVer=0;break;case/Firefox/.test(userAgent):GsBase.browserName="firefox";GsBase.browserVersion=userAgent.match(/Firefox\/([\d\.]+)/)[1];global.bVer=0;break;case/Opera/.test(userAgent):GsBase.browserName="opera";GsBase.browserVersion=userAgent.match(/Opera\/([\d\.]+)/)[1];global.bVer=0;break;default:GsBase.browserName="unknown";GsBase.browserVersion="unknown";global.bVer=0}GsBase.mobileBrowser=$.browser.device=/android|webos|iphone|ipad|ipod|blackberry|iemobile|opera mini/i.test(userAgent.toLowerCase());global.isXp=userAgent.indexOf("Windows NT 5.1")>0;root.className=GsBase.os+" "+GsBase.device+" "+GsBase.browserName+" v"+GsBase.browserVersion;if(!document.getElementById("gs-icon-font")){var gsIcons=document.createElement("link");gsIcons.id="gs-icon-font";gsIcons.rel="stylesheet";gsIcons.href="//image.gsshop.com/ui/stage/gsshop/fonts/style.css";document.head.insertBefore(gsIcons,document.head.firstChild)}})(jQuery,window,window.GsBase=window.GsBase||{});
//# sourceMappingURL=browser.js.map