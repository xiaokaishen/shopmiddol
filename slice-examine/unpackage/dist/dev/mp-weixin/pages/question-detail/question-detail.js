(global["webpackJsonp"] = global["webpackJsonp"] || []).push([["pages/question-detail/question-detail"],{

/***/ "./node_modules/babel-loader/lib/index.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader/index.js?!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader/index.js?!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!./node_modules/vue-loader/lib/index.js?!F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=script&lang=js&":
/*!***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/babel-loader/lib!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--12-1!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--18-0!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!./node_modules/vue-loader/lib??vue-loader-options!F:/练习/微信小程序/slice-examine/pages/question-detail/question-detail.vue?vue&type=script&lang=js& ***!
  \***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(uni) {Object.defineProperty(exports, "__esModule", { value: true });exports.default = void 0;
































































































































var _helper = _interopRequireDefault(__webpack_require__(/*! ../../common/helper.js */ "F:\\练习\\微信小程序\\slice-examine\\common\\helper.js"));
var _treeItem = _interopRequireDefault(__webpack_require__(/*! ../../components/uni-tree/tree-item.vue */ "F:\\练习\\微信小程序\\slice-examine\\components\\uni-tree\\tree-item.vue"));
var _diamondTools = _interopRequireDefault(__webpack_require__(/*! ../../components/question-tools/diamond-tools.vue */ "F:\\练习\\微信小程序\\slice-examine\\components\\question-tools\\diamond-tools.vue"));function _interopRequireDefault(obj) {return obj && obj.__esModule ? obj : { default: obj };}var _default =
{
  components: {
    treeItem: _treeItem.default,
    diamondTools: _diamondTools.default },

  data: function data() {
    return {
      topCurrent: 0,
      tabCur: 0,
      list: [],
      verticalNavTop: 0,
      intoView: "tab0",
      questionListTest: [
      {
        tabList: [
        {
          name: '紧急遏制',
          list: 0 },

        {
          name: '分析小组',
          list: 1 },

        {
          name: '问题描述',
          list: 2 }] },



      {
        tabList: [
        {
          name: '临时措施',
          list: 3 },

        {
          name: '根本原因',
          list: 4 },

        {
          name: '永久措施',
          list: 5 }] },



      {
        tabList: [
        {
          name: '紧急遏制',
          list: 0 },

        {
          name: '分析小组',
          list: 1 },

        {
          name: '问题描述',
          list: 2 }] }],




      items: ['5why', '鱼骨图', '七颗钻石'],
      tabIndex: 0, //控制问题工具tab样式
      tabCurrent: 0, //控制问题工具swiper
      chooseIndex: -1,
      checkCurrent: 0,
      changeCurrent: 0, //用于改变当前current
      currentIndex: 0, //控制顶部tab样式
      doneArray: ["是", "否", "不适用"],
      isEsay: true,
      diamondArray: [
      {
        title: '简单问题',
        questionArray: [
        {
          name: "是否遵循正常的工艺",
          buttonOption: [
          { name: "是" },
          { name: "否" },
          { name: "不适用" }],

          inputOption: [{ name: '说明' }] },

        {
          name: "是否使用正确的工具",
          buttonOption: [
          { name: "是" },
          { name: "否" },
          { name: "不适用" }],

          inputOption: [{ name: '说明' }] },

        {
          name: "是否使用正确的零件",
          buttonOption: [
          { name: "是" },
          { name: "否" },
          { name: "不适用" }],

          inputOption: [{ name: '说明' }] },

        {
          name: "是否符合图纸的要求",
          buttonOption: [
          { name: "是" },
          { name: "否" },
          { name: "不适用" }],

          inputOption: [{ name: '说明' }] }] },



      {
        title: '复杂问题',
        questionArray: [
        {
          name: "工艺改变能否解决",
          buttonOption: [
          { name: "是" },
          { name: "否" },
          { name: "不适用" }],

          inputOption: [{ name: '说明' }] },

        {
          name: "是否需要产品更改",
          buttonOption: [
          { name: "是" },
          { name: "否" },
          { name: "不适用" }],

          inputOption: [{ name: '说明' }] },

        {
          name: "长期存在或者非常负责的问题",
          buttonOption: [
          { name: "是" },
          { name: "否" },
          { name: "不适用" }],

          inputOption: [{ name: '说明' }] }] }],




      wayId: 0,
      wayList: [
      {
        id: 1,
        show: true,
        text: '' },

      {
        id: 2,
        show: false,
        text: '' },

      {
        id: 3,
        show: false,
        text: '' },

      {
        id: 4,
        show: false,
        text: '' },

      {
        id: 5,
        show: false,
        text: '' }] };




  },
  computed: {
    tabList: function tabList() {
      return _helper.default.questionData.tabList;
    },
    questionArray: function questionArray() {
      if (this.isEsay) {
        return this.esayQuestion;
      }
      return this.hardQuestion;
    },
    questionList: function questionList() {
      var that = this;
      var tabList = _helper.default.questionData.tabList;
      var tabArray = [];
      var array = [];
      var count = 0;
      for (var i in tabList) {
        var data = {
          name: tabList[i].name,
          list: parseInt(i) };

        array.push(data);
        count++;
        if (count == 3) {
          count = 0;
          var objArray = {
            tabList: array };

          tabArray.push(objArray);
          array = [];
        }
      }
      return tabArray;
    },
    current: function current() {
      return this.changeCurrent;
    },
    hardQuestion: function hardQuestion() {
      return _helper.default.questionData.hardQuestion;
    },
    esayQuestion: function esayQuestion() {
      return _helper.default.questionData.esayQuestion;
    },
    arr: function arr() {
      return _helper.default.questionData.arr;
    },
    windowHeight: function windowHeight() {
      var height = 0;
      uni.getSystemInfo({
        success: function success(res) {
          console.log(res);
          height = res.windowHeight;
        } });

      return height + 'px';
    } },

  onLoad: function onLoad(option) {
    // 			if(option.index){
    // 				let index = parseInt(option.index);
    // 				this.changeCurrent = index;
    // 				this.tabCur = index
    // 			}
    var list = [{}];
    for (var i = 0; i < 26; i++) {
      list[i] = {};
      list[i].name = String.fromCharCode(65 + i);
      list[i].id = i;
      list[i].icon = 'roundcheckfill';
      list[i].type = -1;
    }
    list[0].type = 1;
    list[1].type = 2;
    list[2].type = 3;
    this.list = list;
    this.listCur = list[0];
  },
  methods: {
    TabSelect: function TabSelect(e) {
      console.log("TabSelect:", e);
      if (e.type == 'change') {
        this.tabCur = e.detail.current;
        this.mainCur = e.detail.current;
        this.verticalNavTop = (e.detail.current - 1) * 50;
      } else {
        this.changeCurrent = e.currentTarget.dataset.id;
        this.tabCur = e.currentTarget.dataset.id;
        this.mainCur = e.currentTarget.dataset.id;
        this.verticalNavTop = (e.currentTarget.dataset.id - 1) * 50;
      }
    },
    updateDiamond: function updateDiamond(data) {
      if (data == 1) {
        var esayQuestion = this.esayQuestion;
        var isEsay = false;
        for (var i in esayQuestion) {
          if (esayQuestion[i].optionIndex == 1 || esayQuestion[i].optionIndex == -1) {
            isEsay = true;
          }
        }
        this.isEsay = isEsay;
      }
    },
    changeClick: function changeClick(e) {
      this.isEsay = true;
    },
    changeToolsTab: function changeToolsTab(e) {
      console.log(e.detail.current);
      this.tabIndex = e.detail.current;
    },
    onClickItem: function onClickItem(e) {
      if (e.type == 'change') {
        this.tabIndex = e.detail.current;
      } else {
        this.tabCurrent = e;
      }
    },
    //记录顶部swiper
    recordCurrent: function recordCurrent(e) {
      this.changeCurrent = e.detail.current;
    },
    nextChange: function nextChange(e) {
      this.currentIndex = this.currentIndex + 1;
    },
    changeChoose: function changeChoose(e) {
      this.chooseIndex = e.currentTarget.dataset.index;
    },
    wayInput: function wayInput(e) {
      var _that = this;
      var id = e.currentTarget.dataset.id;
      var text = e.detail.value;
      _that.wayList.forEach(function (v, i) {
        if (id == v.id) {
          v.text = text;
        }
      });
    },
    showNext: function showNext(e) {
      var _that = this;
      var id = e.currentTarget.dataset.id;
      _that.wayList.forEach(function (v, i) {
        if (v.id == id + 1) {
          v.show = !v.show;
        }
        if (v.id > id + 1 && v.show) {
          v.show = false;
        }
      });
    },
    clickChange: function clickChange(e) {
      console.log("e.currentTarget.dataset.type", e.currentTarget.dataset.type);
      var currentIndex = e.currentTarget.dataset.current;
      this.currentIndex = currentIndex;
      this.checkCurrent = e.currentTarget.dataset.index;
      var type = parseInt(e.currentTarget.dataset.type);
      console.log("this.currentIndex:", this.currentIndex);
      var index = type > 0 ? currentIndex : currentIndex + 1;
      console.log("index:", index);
      if (index % 3 == 0) {
        this.checkCurrent = this.checkCurrent + type;
        console.log("this.checkCurrent:", this.checkCurrent);
      }
      this.changeCurrent = this.checkCurrent;
    },
    changSwiper: function changSwiper(e) {
      this.currentIndex = e.currentTarget.dataset.current;
      this.changeCurrent = e.currentTarget.dataset.index;
      console.log("currentIndex:", this.currentIndex);
      console.log("current:", this.changeCurrent);
    } } };exports.default = _default;
/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./node_modules/@dcloudio/uni-mp-weixin/dist/index.js */ "./node_modules/@dcloudio/uni-mp-weixin/dist/index.js")["default"]))

/***/ }),

/***/ "./node_modules/mini-css-extract-plugin/dist/loader.js?!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader/index.js?!./node_modules/css-loader/index.js?!./node_modules/vue-loader/lib/loaders/stylePostLoader.js!./node_modules/postcss-loader/src/index.js?!./node_modules/vue-loader/lib/index.js?!F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=style&index=0&lang=css&":
/*!************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/mini-css-extract-plugin/dist/loader.js??ref--6-oneOf-1-0!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--6-oneOf-1-1!./node_modules/css-loader??ref--6-oneOf-1-2!./node_modules/vue-loader/lib/loaders/stylePostLoader.js!./node_modules/postcss-loader/src??ref--6-oneOf-1-3!./node_modules/vue-loader/lib??vue-loader-options!F:/练习/微信小程序/slice-examine/pages/question-detail/question-detail.vue?vue&type=style&index=0&lang=css& ***!
  \************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// extracted by mini-css-extract-plugin

/***/ }),

/***/ "./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader/index.js?!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!./node_modules/vue-loader/lib/index.js?!F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=template&id=bd98a26e&":
/*!*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--17-0!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!./node_modules/vue-loader/lib??vue-loader-options!F:/练习/微信小程序/slice-examine/pages/question-detail/question-detail.vue?vue&type=template&id=bd98a26e& ***!
  \*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "render", function() { return render; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return staticRenderFns; });
var render = function() {
  var _vm = this
  var _h = _vm.$createElement
  var _c = _vm._self._c || _h
  return _c("view", { staticStyle: { width: "100%" } }, [
    _c(
      "view",
      { staticClass: "question-main" },
      [
        _c(
          "scroll-view",
          {
            staticClass: "VerticalNav nav",
            staticStyle: { height: "100vh" },
            attrs: {
              "scroll-into-view": _vm.intoView,
              "scroll-y": "",
              "scroll-with-animation": "",
              "scroll-top": _vm.verticalNavTop
            }
          },
          _vm._l(_vm.list, function(item, index) {
            return _c(
              "view",
              {
                key: index,
                staticClass: "cu-item",
                class: index > _vm.tabCur ? "" : "text-green cur",
                staticStyle: { padding: "0" },
                attrs: {
                  id: "tab" + index,
                  "data-id": index,
                  eventid: "0c6e87b2-0-" + index
                },
                on: { tap: _vm.TabSelect }
              },
              [
                index != 0
                  ? _c("view", { staticClass: "step-up-line" })
                  : _vm._e(),
                _c("view", { staticClass: "question-step-name" }, [
                  _vm._v("问题")
                ]),
                _c(
                  "view",
                  { staticClass: "question-step-icon" },
                  [
                    item.type == 1
                      ? _c("uni-icon", {
                          attrs: {
                            type: "checkbox-filled",
                            size: "20",
                            color: "green",
                            mpcomid: "0c6e87b2-0-" + index
                          }
                        })
                      : _vm._e(),
                    item.type == 2
                      ? _c("uni-icon", {
                          attrs: {
                            type: "circle-filled",
                            size: "20",
                            color: "rgb(251,189,8)",
                            mpcomid: "0c6e87b2-1-" + index
                          }
                        })
                      : _vm._e(),
                    item.type == 3
                      ? _c("uni-icon", {
                          attrs: {
                            type: "clear",
                            size: "20",
                            color: "red",
                            mpcomid: "0c6e87b2-2-" + index
                          }
                        })
                      : _vm._e(),
                    item.type == -1
                      ? _c("view", { staticClass: "tab-circle" })
                      : _vm._e()
                  ],
                  1
                ),
                index != _vm.list.length - 1
                  ? _c("view", { staticClass: "step-bottom-line" })
                  : _vm._e()
              ]
            )
          })
        ),
        _c(
          "view",
          { staticClass: "question-jindu-top" },
          [
            _c(
              "swiper",
              {
                style: { height: _vm.windowHeight },
                attrs: {
                  current: _vm.current,
                  vertical: "",
                  eventid: "0c6e87b2-7"
                },
                on: { change: _vm.TabSelect }
              },
              _vm._l(_vm.list, function(listItem, listIndex) {
                return _c(
                  "block",
                  { key: listIndex },
                  [
                    _c(
                      "swiper-item",
                      { attrs: { mpcomid: "0c6e87b2-12-" + listIndex } },
                      [
                        _c(
                          "view",
                          { staticClass: "swiper-item" },
                          [
                            _c(
                              "view",
                              { staticClass: "cu-bar solid-bottom bg-white" },
                              [
                                _c("view", { staticClass: "action" }, [
                                  _c("text", {
                                    staticClass: "icon-title text-green"
                                  }),
                                  _vm._v("Tab-" + _vm._s(listItem.name))
                                ])
                              ]
                            ),
                            listIndex == 0
                              ? _c(
                                  "block",
                                  [
                                    _c(
                                      "view",
                                      { staticClass: "question-tools-main" },
                                      [
                                        _c("uni-segmented-control", {
                                          attrs: {
                                            current: _vm.tabIndex,
                                            values: _vm.items,
                                            "style-type": "button",
                                            "active-color": "#333333",
                                            eventid: "0c6e87b2-1-" + listIndex,
                                            mpcomid: "0c6e87b2-3-" + listIndex
                                          },
                                          on: { clickItem: _vm.onClickItem }
                                        })
                                      ],
                                      1
                                    ),
                                    _c(
                                      "swiper",
                                      {
                                        style: { height: _vm.windowHeight },
                                        attrs: {
                                          current: _vm.tabCurrent,
                                          eventid: "0c6e87b2-6-" + listIndex
                                        },
                                        on: { change: _vm.onClickItem }
                                      },
                                      [
                                        _c(
                                          "swiper-item",
                                          {
                                            attrs: {
                                              "item-id": "0",
                                              mpcomid: "0c6e87b2-5-" + listIndex
                                            }
                                          },
                                          [
                                            _c(
                                              "scroll-view",
                                              {
                                                staticStyle: {
                                                  background: "rgb(255,255,255)"
                                                },
                                                style: {
                                                  height: _vm.windowHeight
                                                },
                                                attrs: { "scroll-y": "true" }
                                              },
                                              [
                                                _c(
                                                  "view",
                                                  {
                                                    staticClass: "swiper-item"
                                                  },
                                                  [
                                                    _c(
                                                      "view",
                                                      {
                                                        staticClass:
                                                          "question-why-top"
                                                      },
                                                      [
                                                        _c(
                                                          "view",
                                                          {
                                                            staticClass:
                                                              "question-why-title"
                                                          },
                                                          [
                                                            _c("text", [
                                                              _vm._v(
                                                                "为什么会发生？"
                                                              )
                                                            ])
                                                          ]
                                                        ),
                                                        _c(
                                                          "view",
                                                          {
                                                            staticClass:
                                                              "question-why-main"
                                                          },
                                                          _vm._l(
                                                            _vm.wayList,
                                                            function(
                                                              way,
                                                              wayIndex
                                                            ) {
                                                              return _c(
                                                                "block",
                                                                {
                                                                  key: wayIndex
                                                                },
                                                                [
                                                                  _c(
                                                                    "view",
                                                                    {
                                                                      directives: [
                                                                        {
                                                                          name:
                                                                            "show",
                                                                          rawName:
                                                                            "v-show",
                                                                          value:
                                                                            way.show,
                                                                          expression:
                                                                            "way.show"
                                                                        }
                                                                      ]
                                                                    },
                                                                    [
                                                                      _c(
                                                                        "view",
                                                                        [
                                                                          _vm._v(
                                                                            _vm._s(
                                                                              way.id
                                                                            ) +
                                                                              "WHY"
                                                                          )
                                                                        ]
                                                                      ),
                                                                      _c(
                                                                        "view",
                                                                        {
                                                                          staticClass:
                                                                            "question-why-list"
                                                                        },
                                                                        [
                                                                          _c(
                                                                            "textarea",
                                                                            {
                                                                              staticClass:
                                                                                "why-textarea",
                                                                              attrs: {
                                                                                maxlength:
                                                                                  "100",
                                                                                "data-id":
                                                                                  way.id,
                                                                                eventid:
                                                                                  "0c6e87b2-2-" +
                                                                                  listIndex +
                                                                                  "-" +
                                                                                  wayIndex
                                                                              },
                                                                              on: {
                                                                                input:
                                                                                  _vm.wayInput
                                                                              }
                                                                            }
                                                                          ),
                                                                          _c(
                                                                            "view",
                                                                            {
                                                                              staticClass:
                                                                                "textarea-num"
                                                                            },
                                                                            [
                                                                              _c(
                                                                                "text",
                                                                                [
                                                                                  _vm._v(
                                                                                    _vm._s(
                                                                                      way
                                                                                        .text
                                                                                        .length
                                                                                    ) +
                                                                                      "/100"
                                                                                  )
                                                                                ]
                                                                              )
                                                                            ]
                                                                          )
                                                                        ]
                                                                      ),
                                                                      wayIndex !=
                                                                      _vm
                                                                        .wayList
                                                                        .length -
                                                                        1
                                                                        ? _c(
                                                                            "navigator",
                                                                            [
                                                                              _c(
                                                                                "view",
                                                                                {
                                                                                  staticClass:
                                                                                    "question-why-bottom",
                                                                                  attrs: {
                                                                                    "data-id":
                                                                                      way.id,
                                                                                    eventid:
                                                                                      "0c6e87b2-3-" +
                                                                                      listIndex +
                                                                                      "-" +
                                                                                      wayIndex
                                                                                  },
                                                                                  on: {
                                                                                    click:
                                                                                      _vm.showNext
                                                                                  }
                                                                                },
                                                                                [
                                                                                  _c(
                                                                                    "uni-icon",
                                                                                    {
                                                                                      attrs: {
                                                                                        type:
                                                                                          "arrowdown",
                                                                                        size:
                                                                                          "20",
                                                                                        mpcomid:
                                                                                          "0c6e87b2-4-" +
                                                                                          listIndex +
                                                                                          "-" +
                                                                                          wayIndex
                                                                                      }
                                                                                    }
                                                                                  )
                                                                                ],
                                                                                1
                                                                              )
                                                                            ]
                                                                          )
                                                                        : _vm._e()
                                                                    ],
                                                                    1
                                                                  )
                                                                ]
                                                              )
                                                            }
                                                          )
                                                        )
                                                      ]
                                                    )
                                                  ]
                                                )
                                              ]
                                            )
                                          ],
                                          1
                                        ),
                                        _c(
                                          "swiper-item",
                                          {
                                            attrs: {
                                              "item-id": "1",
                                              mpcomid: "0c6e87b2-7-" + listIndex
                                            }
                                          },
                                          [
                                            _c(
                                              "scroll-view",
                                              {
                                                staticStyle: {
                                                  background: "rgb(255,255,255)"
                                                },
                                                style: {
                                                  height: _vm.windowHeight
                                                },
                                                attrs: { "scroll-y": "true" }
                                              },
                                              [
                                                _c(
                                                  "view",
                                                  {
                                                    staticClass: "swiper-item"
                                                  },
                                                  _vm._l(_vm.arr, function(
                                                    item,
                                                    index
                                                  ) {
                                                    return _c("tree-item", {
                                                      key: index,
                                                      attrs: {
                                                        arrObj: item,
                                                        index: index,
                                                        length: _vm.arr.length,
                                                        mpcomid:
                                                          "0c6e87b2-6-" +
                                                          listIndex +
                                                          "-" +
                                                          index
                                                      }
                                                    })
                                                  })
                                                )
                                              ]
                                            )
                                          ],
                                          1
                                        ),
                                        _c(
                                          "swiper-item",
                                          {
                                            attrs: {
                                              "item-id": "2",
                                              mpcomid:
                                                "0c6e87b2-11-" + listIndex
                                            }
                                          },
                                          [
                                            _c(
                                              "scroll-view",
                                              {
                                                staticStyle: {
                                                  background: "rgb(255,255,255)"
                                                },
                                                style: {
                                                  height: _vm.windowHeight
                                                },
                                                attrs: { "scroll-y": "true" }
                                              },
                                              [
                                                _c(
                                                  "view",
                                                  {
                                                    staticClass: "swiper-item"
                                                  },
                                                  [
                                                    _c(
                                                      "view",
                                                      {
                                                        staticClass:
                                                          "question-why-top",
                                                        class: _vm.isEsay
                                                          ? ""
                                                          : "check-zhezao"
                                                      },
                                                      [
                                                        _c(
                                                          "view",
                                                          {
                                                            staticClass:
                                                              "question-why-title"
                                                          },
                                                          [
                                                            _c("text", [
                                                              _vm._v("简单问题")
                                                            ])
                                                          ]
                                                        ),
                                                        _vm._l(
                                                          _vm.esayQuestion,
                                                          function(
                                                            item,
                                                            index
                                                          ) {
                                                            return _c(
                                                              "block",
                                                              { key: index },
                                                              [
                                                                _c(
                                                                  "diamond-tools",
                                                                  {
                                                                    attrs: {
                                                                      dataName:
                                                                        item.name,
                                                                      inputOption:
                                                                        item.inputOption,
                                                                      buttonOption:
                                                                        item.buttonOption,
                                                                      index: index,
                                                                      chooseIndex:
                                                                        item.optionIndex,
                                                                      type: 1,
                                                                      eventid:
                                                                        "0c6e87b2-4-" +
                                                                        listIndex +
                                                                        "-" +
                                                                        index,
                                                                      mpcomid:
                                                                        "0c6e87b2-8-" +
                                                                        listIndex +
                                                                        "-" +
                                                                        index
                                                                    },
                                                                    on: {
                                                                      diamondTochild:
                                                                        _vm.updateDiamond
                                                                    }
                                                                  }
                                                                )
                                                              ],
                                                              1
                                                            )
                                                          }
                                                        )
                                                      ],
                                                      2
                                                    ),
                                                    _c(
                                                      "view",
                                                      {
                                                        directives: [
                                                          {
                                                            name: "show",
                                                            rawName: "v-show",
                                                            value: !_vm.isEsay,
                                                            expression:
                                                              "!isEsay"
                                                          }
                                                        ],
                                                        staticClass:
                                                          "question-why-top"
                                                      },
                                                      [
                                                        _c(
                                                          "view",
                                                          {
                                                            staticClass:
                                                              "question-why-title"
                                                          },
                                                          [
                                                            _c("view", [
                                                              _c("text", [
                                                                _vm._v(
                                                                  "复杂问题"
                                                                )
                                                              ])
                                                            ]),
                                                            _c(
                                                              "view",
                                                              {
                                                                attrs: {
                                                                  eventid:
                                                                    "0c6e87b2-5-" +
                                                                    listIndex
                                                                },
                                                                on: {
                                                                  click:
                                                                    _vm.changeClick
                                                                }
                                                              },
                                                              [
                                                                _c("uni-icon", {
                                                                  attrs: {
                                                                    type:
                                                                      "clear",
                                                                    size: "20",
                                                                    mpcomid:
                                                                      "0c6e87b2-9-" +
                                                                      listIndex
                                                                  }
                                                                })
                                                              ],
                                                              1
                                                            )
                                                          ]
                                                        ),
                                                        _vm._l(
                                                          _vm.hardQuestion,
                                                          function(
                                                            item,
                                                            index
                                                          ) {
                                                            return _c(
                                                              "block",
                                                              { key: index },
                                                              [
                                                                _c(
                                                                  "diamond-tools",
                                                                  {
                                                                    attrs: {
                                                                      dataName:
                                                                        item.name,
                                                                      inputOption:
                                                                        item.inputOption,
                                                                      buttonOption:
                                                                        item.buttonOption,
                                                                      index: index,
                                                                      chooseIndex:
                                                                        item.optionIndex,
                                                                      type: 2,
                                                                      mpcomid:
                                                                        "0c6e87b2-10-" +
                                                                        listIndex +
                                                                        "-" +
                                                                        index
                                                                    }
                                                                  }
                                                                )
                                                              ],
                                                              1
                                                            )
                                                          }
                                                        )
                                                      ],
                                                      2
                                                    ),
                                                    _c(
                                                      "view",
                                                      {
                                                        staticClass:
                                                          "question-diamond-top"
                                                      },
                                                      [
                                                        _c("view", [
                                                          _c("text", [
                                                            _vm._v("根本原因")
                                                          ])
                                                        ]),
                                                        _c(
                                                          "view",
                                                          {
                                                            staticClass:
                                                              "diamond-bottom-textarea"
                                                          },
                                                          [_c("textarea")]
                                                        )
                                                      ]
                                                    )
                                                  ]
                                                )
                                              ]
                                            )
                                          ],
                                          1
                                        )
                                      ],
                                      1
                                    )
                                  ],
                                  1
                                )
                              : _vm._e()
                          ],
                          1
                        )
                      ]
                    )
                  ],
                  1
                )
              })
            )
          ],
          1
        )
      ],
      1
    )
  ])
}
var staticRenderFns = []
render._withStripped = true



/***/ }),

/***/ "F:\\练习\\微信小程序\\slice-examine\\main.js?{\"page\":\"pages%2Fquestion-detail%2Fquestion-detail\"}":
/*!**********************************************************************************************!*\
  !*** F:/练习/微信小程序/slice-examine/main.js?{"page":"pages%2Fquestion-detail%2Fquestion-detail"} ***!
  \**********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
__webpack_require__(/*! uni-pages */ "F:\\练习\\微信小程序\\slice-examine\\pages.json");
var _mpvuePageFactory = _interopRequireDefault(__webpack_require__(/*! mpvue-page-factory */ "./node_modules/@dcloudio/vue-cli-plugin-uni/packages/mpvue-page-factory/index.js"));
var _questionDetail = _interopRequireDefault(__webpack_require__(/*! ./pages/question-detail/question-detail.vue */ "F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue"));function _interopRequireDefault(obj) {return obj && obj.__esModule ? obj : { default: obj };}
Page((0, _mpvuePageFactory.default)(_questionDetail.default));

/***/ }),

/***/ "F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue":
/*!***************************************************************************!*\
  !*** F:/练习/微信小程序/slice-examine/pages/question-detail/question-detail.vue ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _question_detail_vue_vue_type_template_id_bd98a26e___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./question-detail.vue?vue&type=template&id=bd98a26e& */ "F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=template&id=bd98a26e&");
/* harmony import */ var _question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./question-detail.vue?vue&type=script&lang=js& */ "F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=script&lang=js&");
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__[key]; }) }(__WEBPACK_IMPORT_KEY__));
/* harmony import */ var _question_detail_vue_vue_type_style_index_0_lang_css___WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./question-detail.vue?vue&type=style&index=0&lang=css& */ "F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=style&index=0&lang=css&");
/* harmony import */ var _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/vue-loader/lib/runtime/componentNormalizer.js */ "./node_modules/vue-loader/lib/runtime/componentNormalizer.js");






/* normalize component */

var component = Object(_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_3__["default"])(
  _question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__["default"],
  _question_detail_vue_vue_type_template_id_bd98a26e___WEBPACK_IMPORTED_MODULE_0__["render"],
  _question_detail_vue_vue_type_template_id_bd98a26e___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"],
  false,
  null,
  null,
  null
  
)

/* hot reload */
if (false) { var api; }
component.options.__file = "F:/练习/微信小程序/slice-examine/pages/question-detail/question-detail.vue"
/* harmony default export */ __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ "F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=script&lang=js&":
/*!****************************************************************************************************!*\
  !*** F:/练习/微信小程序/slice-examine/pages/question-detail/question-detail.vue?vue&type=script&lang=js& ***!
  \****************************************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_18_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!./node_modules/babel-loader/lib!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--12-1!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--18-0!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!./node_modules/vue-loader/lib??vue-loader-options!./question-detail.vue?vue&type=script&lang=js& */ "./node_modules/babel-loader/lib/index.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader/index.js?!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader/index.js?!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!./node_modules/vue-loader/lib/index.js?!F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=script&lang=js&");
/* harmony import */ var _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_18_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_18_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_18_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_18_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__[key]; }) }(__WEBPACK_IMPORT_KEY__));
 /* harmony default export */ __webpack_exports__["default"] = (_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_18_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0___default.a); 

/***/ }),

/***/ "F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=style&index=0&lang=css&":
/*!************************************************************************************************************!*\
  !*** F:/练习/微信小程序/slice-examine/pages/question-detail/question-detail.vue?vue&type=style&index=0&lang=css& ***!
  \************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_6_oneOf_1_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_6_oneOf_1_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_index_js_ref_6_oneOf_1_2_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_stylePostLoader_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_6_oneOf_1_3_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_style_index_0_lang_css___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!./node_modules/mini-css-extract-plugin/dist/loader.js??ref--6-oneOf-1-0!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--6-oneOf-1-1!./node_modules/css-loader??ref--6-oneOf-1-2!./node_modules/vue-loader/lib/loaders/stylePostLoader.js!./node_modules/postcss-loader/src??ref--6-oneOf-1-3!./node_modules/vue-loader/lib??vue-loader-options!./question-detail.vue?vue&type=style&index=0&lang=css& */ "./node_modules/mini-css-extract-plugin/dist/loader.js?!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader/index.js?!./node_modules/css-loader/index.js?!./node_modules/vue-loader/lib/loaders/stylePostLoader.js!./node_modules/postcss-loader/src/index.js?!./node_modules/vue-loader/lib/index.js?!F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=style&index=0&lang=css&");
/* harmony import */ var _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_6_oneOf_1_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_6_oneOf_1_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_index_js_ref_6_oneOf_1_2_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_stylePostLoader_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_6_oneOf_1_3_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_style_index_0_lang_css___WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_6_oneOf_1_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_6_oneOf_1_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_index_js_ref_6_oneOf_1_2_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_stylePostLoader_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_6_oneOf_1_3_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_style_index_0_lang_css___WEBPACK_IMPORTED_MODULE_0__);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_6_oneOf_1_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_6_oneOf_1_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_index_js_ref_6_oneOf_1_2_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_stylePostLoader_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_6_oneOf_1_3_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_style_index_0_lang_css___WEBPACK_IMPORTED_MODULE_0__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_6_oneOf_1_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_6_oneOf_1_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_index_js_ref_6_oneOf_1_2_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_stylePostLoader_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_6_oneOf_1_3_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_style_index_0_lang_css___WEBPACK_IMPORTED_MODULE_0__[key]; }) }(__WEBPACK_IMPORT_KEY__));
 /* harmony default export */ __webpack_exports__["default"] = (_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_6_oneOf_1_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_6_oneOf_1_1_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_index_js_ref_6_oneOf_1_2_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_stylePostLoader_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_6_oneOf_1_3_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_style_index_0_lang_css___WEBPACK_IMPORTED_MODULE_0___default.a); 

/***/ }),

/***/ "F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=template&id=bd98a26e&":
/*!**********************************************************************************************************!*\
  !*** F:/练习/微信小程序/slice-examine/pages/question-detail/question-detail.vue?vue&type=template&id=bd98a26e& ***!
  \**********************************************************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_17_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_template_id_bd98a26e___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!./node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--17-0!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!./node_modules/vue-loader/lib??vue-loader-options!./question-detail.vue?vue&type=template&id=bd98a26e& */ "./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader/index.js?!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!./node_modules/vue-loader/lib/index.js?!F:\\练习\\微信小程序\\slice-examine\\pages\\question-detail\\question-detail.vue?vue&type=template&id=bd98a26e&");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "render", function() { return _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_17_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_template_id_bd98a26e___WEBPACK_IMPORTED_MODULE_0__["render"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return _E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_17_0_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_E_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_question_detail_vue_vue_type_template_id_bd98a26e___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]; });



/***/ })

},[["F:\\练习\\微信小程序\\slice-examine\\main.js?{\"page\":\"pages%2Fquestion-detail%2Fquestion-detail\"}","common/runtime","common/vendor"]]]);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/question-detail/question-detail.js.map