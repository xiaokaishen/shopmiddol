(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/test/phone-search"],{1504:function(t,e,n){"use strict";n.r(e);var a=n("f84e"),r=n("4422");for(var i in r)"default"!==i&&function(t){n.d(e,t,function(){return r[t]})}(i);var u=n("2877"),o=Object(u["a"])(r["default"],a["a"],a["b"],!1,null,null,null);e["default"]=o.exports},"3fba":function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a=r(n("5240"));function r(t){return t&&t.__esModule?t:{default:t}}var i={name:"phone-search",components:{phoneSearchList:a.default},data:function(){return{phones:null}},onLoad:function(t){this.phones=JSON.parse(unescape(t.phones))},methods:{paramClick:function(t){console.log(t)}}};e.default=i},4422:function(t,e,n){"use strict";n.r(e);var a=n("3fba"),r=n.n(a);for(var i in a)"default"!==i&&function(t){n.d(e,t,function(){return a[t]})}(i);e["default"]=r.a},5240:function(t,e,n){"use strict";n.r(e);var a=n("d15d"),r=n("d7c1");for(var i in r)"default"!==i&&function(t){n.d(e,t,function(){return r[t]})}(i);n("72ac");var u=n("2877"),o=Object(u["a"])(r["default"],a["a"],a["b"],!1,null,null,null);e["default"]=o.exports},"5d8f":function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a={name:"phone-search-list",props:{phones:Object},data:function(){return{keyword:"",list:[],timer:null}},computed:{hasNoData:function(){return!this.list.length}},watch:{keyword:function(){var t=this;this.timer&&clearTimeout(this.timer),this.keyword?this.timer=setTimeout(function(){var e=[];for(var n in t.phones)t.phones[n].forEach(function(n){(n.spell.indexOf(t.keyword)>-1||n.name.indexOf(t.keyword)>-1)&&e.push(n)});t.list=e},100):this.list=[]}},methods:{handleInput:function(t){this.keyword=t.detail.value},handleClick:function(t){this.$emit("paramClick",t.target.dataset)}}};e.default=a},"72ac":function(t,e,n){"use strict";var a=n("b9ef"),r=n.n(a);r.a},"7bfe":function(t,e,n){"use strict";n("535a");var a=i(n("b0ce")),r=i(n("1504"));function i(t){return t&&t.__esModule?t:{default:t}}Page((0,a.default)(r.default))},b9ef:function(t,e,n){},d15d:function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("view",[n("view",{staticClass:"search"},[n("input",{staticClass:"search-input",attrs:{type:"text",focus:"",placeholder:"请输入要搜索的联系人",eventid:"42e19466-0"},on:{input:t.handleInput}})]),t.keyword?n("view",{staticClass:"search-main"},[t.hasNoData?n("view",{staticClass:"search-main-errtitle"},[t._v("无搜索结果")]):t._e(),t._l(t.list,function(e,a){return n("view",{key:e.id,staticClass:"search-main-title",attrs:{"hover-class":"hover","hover-start-time":20,"hover-stay-time":70,"data-name":e.name,"data-id":e.id,"data-phoneNumber":e.phoneNumber,eventid:"42e19466-1-"+a},on:{click:t.handleClick}},[t._v(t._s(e.name))])})],2):t._e()])},r=[];n.d(e,"a",function(){return a}),n.d(e,"b",function(){return r})},d7c1:function(t,e,n){"use strict";n.r(e);var a=n("5d8f"),r=n.n(a);for(var i in a)"default"!==i&&function(t){n.d(e,t,function(){return a[t]})}(i);e["default"]=r.a},f84e:function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("view",{staticStyle:{width:"100%"}},[n("phone-search-list",{attrs:{phones:t.phones,eventid:"6ca3a1dd-0",mpcomid:"6ca3a1dd-0"},on:{paramClick:t.paramClick}})],1)},r=[];n.d(e,"a",function(){return a}),n.d(e,"b",function(){return r})}},[["7bfe","common/runtime","common/vendor"]]]);