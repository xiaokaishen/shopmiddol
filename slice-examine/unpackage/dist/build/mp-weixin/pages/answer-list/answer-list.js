(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/answer-list/answer-list"],{2742:function(t,e,a){},3189:function(t,e,a){"use strict";a.r(e);var i=a("3db5"),n=a("60e2");for(var s in n)"default"!==s&&function(t){a.d(e,t,function(){return n[t]})}(s);a("324b");var r=a("2877"),l=Object(r["a"])(n["default"],i["a"],i["b"],!1,null,null,null);e["default"]=l.exports},"324b":function(t,e,a){"use strict";var i=a("2742"),n=a.n(i);n.a},"3db5":function(t,e,a){"use strict";var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("view",{staticClass:"record-detail-main"},[a("view",{attrs:{id:"answer-list-top"}},[a("view",{staticClass:"answer-list-title"},t._l(t.tabList,function(e,i){return a("block",{key:i},[a("view",{staticClass:"answer-list-item",class:i==t.current?"item-active":""},[a("text",[t._v(t._s(e))])])])})),a("view",{staticClass:"check-div"})]),a("swiper",{style:{height:t.windowHeight},attrs:{current:t.current,eventid:"47dead38-1"},on:{change:t.changSwiper}},t._l(t.tabList,function(e,i){return a("block",{key:i},[a("swiper-item",{attrs:{mpcomid:"47dead38-0-"+i}},[a("scroll-view",{style:{height:t.windowHeight},attrs:{"scroll-y":"true"}},t._l(t.list,function(e,n){return a("block",{key:n},[a("view",[a("view",{staticClass:"record-detail-list"},[a("view",{staticClass:"detail-list-left"},[a("view",{staticClass:"list-left-one"},[a("view",{staticClass:"record-detail-heard"},[a("image",{attrs:{src:"../../static/img/heard-img.jpg"}})]),a("view",{staticClass:"detail-heard-font"},[a("text",[t._v("测试1")])])]),a("view",{staticClass:"list-left-two"},[a("view",{staticClass:"detail-list-manager"},[a("text",[t._v("管理员")])]),a("view",{staticClass:"detail-list-date"},[a("text",[t._v("三周前")])])])]),a("view",{staticClass:"detail-list-left"},[a("view",[a("text",{staticClass:"list-left-tap"},[t._v("open")])])])]),a("view",{staticClass:"record-detail-personal",attrs:{eventid:"47dead38-0-"+i+"-"+n},on:{click:t.closeModal}},[a("image",{attrs:{src:"../../static/img/user.png"}}),a("text",[t._v("责任人")])])]),a("view",{staticClass:"check-div"})])}))],1)],1)})),a("neil-modal",{attrs:{show:t.show,title:"指定责任人","show-cancel":!1,"confirm-color":"rgb(255,255,255)","confirm-text":"rgb(255,255,255)",eventid:"47dead38-5",mpcomid:"47dead38-1"},on:{close:t.closeModal}},[a("view",{staticClass:"record-modal-list"},[a("view",[a("text",[t._v("问题点")])]),a("view",[a("text",[t._v("测试1")])])]),a("view",{staticClass:"record-modal-list"},[a("view",[a("text",[t._v("紧急程度")])]),a("view",[a("picker",{attrs:{mode:"selector",range:t.dangerArray,eventid:"47dead38-2"},on:{change:t.dangerChange}},[a("view",[t._v(t._s(t.dangerArray[t.dangerIndex]))])])],1)]),a("view",{staticClass:"record-modal-list"},[a("view",[a("text",[t._v("责任人")])]),a("view",[a("picker",{attrs:{mode:"selector",range:t.managerArray,eventid:"47dead38-3"},on:{change:t.mangerChange}},[a("view",[t._v(t._s(t.managerArray[t.managerIndex]))])])],1)]),a("view",{staticClass:"record-modal-list"},[a("view",[a("text",[t._v("截至日期")])]),a("view",[a("picker",{attrs:{mode:"date",value:t.date,start:t.startDate,end:t.endDate,eventid:"47dead38-4"},on:{change:t.bindDateChange}},[a("view",{staticClass:"uni-input"},[t._v(t._s(t.date))])])],1)]),a("view",{staticClass:"detail-modal-submit"},[t._v("确定")])])],1)},n=[];a.d(e,"a",function(){return i}),a.d(e,"b",function(){return n})},"60e2":function(t,e,a){"use strict";a.r(e);var i=a("b869"),n=a.n(i);for(var s in i)"default"!==s&&function(t){a.d(e,t,function(){return i[t]})}(s);e["default"]=n.a},b550:function(t,e,a){"use strict";a("535a");var i=s(a("b0ce")),n=s(a("3189"));function s(t){return t&&t.__esModule?t:{default:t}}Page((0,i.default)(n.default))},b869:function(t,e,a){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var i=n(a("f211"));function n(t){return t&&t.__esModule?t:{default:t}}var s={components:{neilModal:i.default},data:function(){var t=this.getDate({format:!0});return{current:0,tabList:["我发现的","我负责的"],show:!1,list:[1,2,3,4,5],dangerArray:["一级","二级","三级"],dangerIndex:0,managerArray:["责任人1","责任人2","责任人3"],managerIndex:0,date:t}},computed:{windowHeight:function(){var e=0;return t.getSystemInfo({success:function(t){e=t.windowHeight}}),e-75+"px"}},methods:{changSwiper:function(t){this.current=t.detail.current},closeModal:function(t){this.show=!this.show},dangerChange:function(t){this.dangerIndex=t.target.value},mangerChange:function(t){this.managerIndex=t.target.value},getDate:function(t){var e=new Date,a=e.getFullYear(),i=e.getMonth()+1,n=e.getDate();return"start"===t?a-=60:"end"===t&&(a+=2),i=i>9?i:"0"+i,n=n>9?n:"0"+n,"".concat(a,"-").concat(i,"-").concat(n)},bindDateChange:function(t){this.date=t.target.value}}};e.default=s}).call(this,a("543d")["default"])}},[["b550","common/runtime","common/vendor"]]]);