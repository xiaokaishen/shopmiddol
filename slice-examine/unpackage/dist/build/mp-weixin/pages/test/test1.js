(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/test/test1"],{"1b01":function(t,e,i){"use strict";var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("view",{staticStyle:{width:"100%"}},[i("scroll-view",{staticClass:"bg-white nav",attrs:{"scroll-x":""}},[i("view",{staticClass:"flex text-center"},t._l(t.topList,function(e,a){return i("view",{key:a,staticClass:"cu-item flex-sub",class:a==t.TabCur?"text-green cur":"",attrs:{"data-id":a,eventid:"37b72fa9-0-"+a},on:{tap:t.tabSelect}},[t._v(t._s(e.name)+"("+t._s(0==a?t.checkList.length:1==a?t.readyList.length:2==a?t.badList.length:t.doneList.length)+")")])}))]),i("swiper",{staticStyle:{height:"100vh"},attrs:{current:t.listCur,eventid:"37b72fa9-1"},on:{change:t.changeList}},[i("swiper-item",{attrs:{mpcomid:"37b72fa9-1"}},[i("view",{staticClass:"swiper-item"},[i("question-list",{attrs:{checkList:t.checkList,mpcomid:"37b72fa9-0"}})],1)]),i("swiper-item",{attrs:{mpcomid:"37b72fa9-3"}},[i("view",{staticClass:"swiper-item"},[i("question-list",{attrs:{checkList:t.readyList,mpcomid:"37b72fa9-2"}})],1)]),i("swiper-item",{attrs:{mpcomid:"37b72fa9-5"}},[i("view",{staticClass:"swiper-item"},[i("question-list",{attrs:{checkList:t.badList,mpcomid:"37b72fa9-4"}})],1)]),i("swiper-item",{attrs:{mpcomid:"37b72fa9-7"}},[i("view",{staticClass:"swiper-item"},[i("question-list",{attrs:{checkList:t.doneList,mpcomid:"37b72fa9-6"}})],1)])],1)],1)},n=[];i.d(e,"a",function(){return a}),i.d(e,"b",function(){return n})},"1b0c":function(t,e,i){"use strict";var a=i("2a15"),n=i.n(a);n.a},"1fc6":function(t,e,i){"use strict";i.r(e);var a=i("d398"),n=i.n(a);for(var r in a)"default"!==r&&function(t){i.d(e,t,function(){return a[t]})}(r);e["default"]=n.a},"2a15":function(t,e,i){},"401a":function(t,e,i){"use strict";i("535a");var a=r(i("b0ce")),n=r(i("a1c3"));function r(t){return t&&t.__esModule?t:{default:t}}Page((0,a.default)(n.default))},a1c3:function(t,e,i){"use strict";i.r(e);var a=i("1b01"),n=i("1fc6");for(var r in n)"default"!==r&&function(t){i.d(e,t,function(){return n[t]})}(r);i("1b0c");var s=i("2877"),u=Object(s["a"])(n["default"],a["a"],a["b"],!1,null,null,null);e["default"]=u.exports},d398:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a=r(i("fe5f")),n=r(i("1c1f"));function r(t){return t&&t.__esModule?t:{default:t}}var s={components:{questionList:a.default},computed:{checkList:function(){return n.default.questionData.checkList},readyList:function(){return this.aroundList(1)},badList:function(){return this.aroundList(2)},doneList:function(){return this.aroundList(3)},tabList:function(){return n.default.questionData.tabList},questionList:function(){var t=n.default.questionData.tabList,e=[],i=[],a=0;for(var r in t){var s={name:t[r].name,list:parseInt(r)};if(i.push(s),a++,3==a){a=0;var u={tabList:i};e.push(u),i=[]}}return e},current:function(){return this.changeCurrent}},data:function(){return{listCur:0,changeCurrent:0,topList:[{name:"全部"},{name:"待完成"},{name:"审核失败"},{name:"已完成"}],TabCur:0,scrollLeft:0}},methods:{aroundList:function(t){var e=[],i=n.default.questionData.checkList;return i.forEach(function(i,a){i.progress==t&&e.push(i)}),console.log("v:",e),e},recordCurrent:function(t){this.changeCurrent=t.detail.current},changSwiper:function(t){this.TabCur=t.currentTarget.dataset.current,this.changeCurrent=t.currentTarget.dataset.index},tabSelect:function(t){this.TabCur=t.currentTarget.dataset.id,this.listCur=t.currentTarget.dataset.id,this.scrollLeft=60*(t.currentTarget.dataset.id-1)},changeList:function(t){this.TabCur=t.detail.current,this.scrollLeft=60*(t.detail.current-1)}}};e.default=s}},[["401a","common/runtime","common/vendor"]]]);