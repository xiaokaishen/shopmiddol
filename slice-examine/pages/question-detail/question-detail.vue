<template>
	<view style="width: 100%;">
		<view class="question-main">
			<scroll-view :scroll-into-view="intoView" class="VerticalNav nav" scroll-y scroll-with-animation :scroll-top="verticalNavTop" style="height:100vh">
				<view class="cu-item" style="padding: 0;" :class="index>tabCur?'':'text-green cur'" v-for="(item,index) in list" :key="index"
				@tap="TabSelect" :id="'tab'+index" :data-id="index">
					<view v-if="index !=0" class="step-up-line"></view>
					<view class="question-step-name">
						<!-- {{item.name}} -->
						问题
					</view>
					<view class="question-step-icon">
						<uni-icon v-if="item.type==1" type="checkbox-filled" size='20' color='green'></uni-icon>
						<uni-icon v-if="item.type==2" type='circle-filled' size='20' color='rgb(251,189,8)'></uni-icon>
						<uni-icon v-if="item.type==3" type='clear' size='20' color='red'></uni-icon>
						<view v-if="item.type ==-1" class="tab-circle"></view>
					</view>
					<view v-if="index !=list.length-1" class="step-bottom-line"></view>
				</view>
			</scroll-view>
			<view class="question-jindu-top">
				<swiper :current="current" @change="TabSelect" vertical :style="{height:windowHeight}">
					<block v-for="(listItem,listIndex) in list" :key="listIndex">
					<swiper-item>
						<view class="swiper-item">
							<view class="cu-bar solid-bottom bg-white">
								<view class="action">
									<text class="icon-title text-green"></text> Tab-{{listItem.name}}</view>
							</view>
							<block v-if="listIndex ==0">
							<view class="question-tools-main" >
								<uni-segmented-control :current="tabIndex" :values="items" @clickItem="onClickItem" style-type="button"
								 active-color="#333333">
								</uni-segmented-control>
							</view>
							<swiper :current="tabCurrent" :style="{height:windowHeight}" @change="onClickItem">
								<swiper-item item-id="0">
									<scroll-view style="background: rgb(255,255,255);" scroll-y="true" :style="{height:windowHeight}">
										<view class="swiper-item">
											<view class="question-why-top">
												<view class="question-why-title">
													<text>为什么会发生？</text>
												</view>
												<view class="question-why-main">
													<block v-for='(way,wayIndex) in wayList' :key='wayIndex'>
														<view v-show="way.show">
															<view>
																{{way.id}}WHY
															</view>
															<view class="question-why-list">
																<textarea maxlength="100" :data-id="way.id" @input="wayInput" class="why-textarea" />
																<view class="textarea-num">
																	<text>{{way.text.length}}/100</text>
																</view>
															</view>
															<navigator v-if="wayIndex != (wayList.length-1)">
																<view @click="showNext" :data-id="way.id" class="question-why-bottom">
																	<!-- <text class="icon-unfold" style="font-size: 40upx;"></text> -->
																	<uni-icon type='arrowdown' size='20'></uni-icon>
																</view>
															</navigator>
														</view>
													</block>
												</view>
											</view>
										</view>
									</scroll-view>
								</swiper-item>
								<swiper-item item-id="1">
									<scroll-view style="background: rgb(255,255,255);" scroll-y="true" :style="{height:windowHeight}">
										<view class="swiper-item">
											<tree-item v-for="(item,index) in arr" :key="index"
												:arrObj="item" :index="index" :length="arr.length"></tree-item>
										</view>
									</scroll-view>
								</swiper-item>
								<swiper-item item-id="2">
									<scroll-view style="background: rgb(255,255,255);" scroll-y="true" :style="{height:windowHeight}">
										<view class="swiper-item">
											<!-- <block v-for="(diamond,diaIndex) in diamondArray" :key="diaIndex"> -->
												<view class="question-why-top" :class="isEsay?'':'check-zhezao'">
													<view class="question-why-title">
														<text>简单问题</text>
													</view>
													<block v-for="(item,index) in esayQuestion" :key="index">
														<diamond-tools :dataName="item.name" :inputOption="item.inputOption"
														 :buttonOption="item.buttonOption" :index="index" 
														 :chooseIndex="item.optionIndex" :type="1" v-on:diamondTochild="updateDiamond" />
													</block>
												</view>
												<view v-show="!isEsay" class="question-why-top">
													<view class="question-why-title">
														<view>
															<text>复杂问题</text>
														</view>
														<view @click="changeClick">
															<uni-icon type="clear" size="20"/>
														</view>
													</view>
													<block v-for="(item,index) in hardQuestion" :key="index">
														<diamond-tools :dataName="item.name" :inputOption="item.inputOption"
														 :buttonOption="item.buttonOption" :index="index" 
														 :chooseIndex="item.optionIndex" :type="2"/>
													</block>
												</view>
											<!-- </block> -->
												<view class="question-diamond-top">
													<view>
														<text>根本原因</text>
													</view>
													<view class="diamond-bottom-textarea">
														<textarea/>
													</view>
												</view>
											</view>
									</scroll-view>
								</swiper-item>
							</swiper>
							</block>
						</view>
					</swiper-item>
					</block>
				</swiper>
			</view>
		</view>
	</view>
</template>

<script>
	import helper from '../../common/helper.js'
	import treeItem from '../../components/uni-tree/tree-item.vue'
	import diamondTools from '../../components/question-tools/diamond-tools.vue'
	export default {
		components:{
			treeItem,
			diamondTools
		},
		data() {
			return {
				topCurrent:0,
				tabCur: 0,
				list:[],
				verticalNavTop: 0,
				intoView:"tab0",
				questionListTest:[
					{
						tabList:[
							{
								name:'紧急遏制',
								list:0
							},
							{
								name:'分析小组',
								list:1
							},
							{
								name:'问题描述',
								list:2
							}
						],
					},
					{
						tabList:[
					{
						name:'临时措施',
						list:3
					},
					{
						name:'根本原因',
						list:4
					},
					{
						name:'永久措施',
						list:5
					}
					],
					},
					{
						tabList:[
							{
								name:'紧急遏制',
								list:0
							},
							{
								name:'分析小组',
								list:1
							},
							{
								name:'问题描述',
								list:2
							}
						],
					},
				],
				items: ['5why','鱼骨图','七颗钻石'],
				tabIndex:0,//控制问题工具tab样式
				tabCurrent:0,//控制问题工具swiper
				chooseIndex: -1,
				checkCurrent:0,
				changeCurrent:0,//用于改变当前current
				currentIndex:0,//控制顶部tab样式
				doneArray:["是","否","不适用"],
				isEsay:true,
				diamondArray:[
					{
						title:'简单问题',
						questionArray:[
							{
								name: "是否遵循正常的工艺",
								buttonOption:[
									{name:"是"}, 
									{name:"否"},
									{name:"不适用"},
									],
								inputOption:[{name:'说明'}]
							},
							{
								name: "是否使用正确的工具",
								buttonOption:[
									{name:"是"}, 
									{name:"否"},
									{name:"不适用"},
									],
								inputOption:[{name:'说明'}]
							},
							{
								name: "是否使用正确的零件",
								buttonOption:[
									{name:"是"}, 
									{name:"否"},
									{name:"不适用"},
									],
								inputOption:[{name:'说明'}]
							},
							{
								name: "是否符合图纸的要求",
								buttonOption:[
									{name:"是"}, 
									{name:"否"},
									{name:"不适用"},
									],
								inputOption:[{name:'说明'}]
							}
						]
					},
					{
						title:'复杂问题',
						questionArray:[
							{
								name: "工艺改变能否解决",
								buttonOption:[
									{name:"是"}, 
									{name:"否"},
									{name:"不适用"},
									],
								inputOption:[{name:'说明'}]
							},
							{
								name: "是否需要产品更改",
								buttonOption:[
									{name:"是"}, 
									{name:"否"},
									{name:"不适用"},
									],
								inputOption:[{name:'说明'}]
							},
							{
								name: "长期存在或者非常负责的问题",
								buttonOption:[
									{name:"是"}, 
									{name:"否"},
									{name:"不适用"},
									],
								inputOption:[{name:'说明'}]
							},
						]
					},
				],
				wayId: 0,
				wayList:[
						{
							id:1,
							show:true,
							text: '' 
						},
						{
							id:2,
							show:false,
							text: '' 
						},
						{
							id:3,
							show:false,
							text: '' 
						},
						{
							id:4,
							show:false,
							text: '' 
						},
						{
							id:5,
							show:false,
							text: '' 
						}
					],
				
			}
		},
		computed:{
			tabList(){
				return helper.questionData.tabList;
			},
			questionArray(){
				if(this.isEsay){
					return this.esayQuestion
				}
				return this.hardQuestion
			},
			questionList(){
				var that =this;
				var tabList = helper.questionData.tabList;
				var tabArray = [];
				var array = [];
				let count = 0;
				for(let i in tabList){
					let data = {
						name: tabList[i].name,
						list: parseInt(i)
					}
					array.push(data);
					count++;
					if(count ==3){
						count =0;
						let objArray ={
							tabList:array
						}
						tabArray.push(objArray);
						array =[];
					} 
				}
				return tabArray;
			},
			current(){
				return this.changeCurrent
			},
			hardQuestion(){
				return helper.questionData.hardQuestion;
			},
			esayQuestion(){
				return helper.questionData.esayQuestion;
			},
			arr(){
				return helper.questionData.arr;
			},
			windowHeight(){
				var height = 0;
				uni.getSystemInfo({
					success:function (res) {
						console.log(res)
						height = res.windowHeight;
					}
				})
				return height+'px';
			}	
		},
		onLoad(option) {
// 			if(option.index){
// 				let index = parseInt(option.index);
// 				this.changeCurrent = index;
// 				this.tabCur = index
// 			}
				let list = [{}];
				for (let i = 0; i < 26; i++) {
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
		methods:{
			TabSelect(e) {
				console.log("TabSelect:",e)
				if(e.type == 'change'){
					this.tabCur = e.detail.current;
					this.mainCur = e.detail.current;
					this.verticalNavTop = (e.detail.current - 1) * 50;
				}else{
					this.changeCurrent = e.currentTarget.dataset.id;
					this.tabCur = e.currentTarget.dataset.id;
					this.mainCur = e.currentTarget.dataset.id;
					this.verticalNavTop = (e.currentTarget.dataset.id - 1) * 50
				}
			},
			updateDiamond(data){
				if(data ==1){
					let esayQuestion = this.esayQuestion;
					let isEsay = false;
					for(let i in esayQuestion){
						if(esayQuestion[i].optionIndex ==1||esayQuestion[i].optionIndex == -1){
							isEsay = true;
						}
					}
					this.isEsay = isEsay;
				}
			},
			changeClick(e){
				this.isEsay = true;
			},
			changeToolsTab(e){
				console.log(e.detail.current)
				this.tabIndex = e.detail.current
			},
			onClickItem(e){
				if(e.type == 'change'){
					this.tabIndex = e.detail.current;
				}else{
					this.tabCurrent = e
				}
			},
			//记录顶部swiper
			recordCurrent(e){
				this.changeCurrent = e.detail.current;
			},
			nextChange(e){
				this.currentIndex = this.currentIndex+1;
			},
			changeChoose(e){
				this.chooseIndex = e.currentTarget.dataset.index;
			},
			wayInput(e){
				var _that = this;
				let id = e.currentTarget.dataset.id;
				let text = e.detail.value;
				_that.wayList.forEach(function(v,i){
					if(id == v.id){
						v.text = text;
					}
				})
			},
			showNext(e){
				var _that = this;
				let id = e.currentTarget.dataset.id;
				_that.wayList.forEach(function(v,i){
					if(v.id == (id +1)){
						v.show = !v.show
					}
					if(v.id > (id +1) &&v.show){
						v.show = false;
					}
				})
			},
			clickChange:function(e){
				console.log("e.currentTarget.dataset.type",e.currentTarget.dataset.type)
				let currentIndex = e.currentTarget.dataset.current;
				this.currentIndex = currentIndex;
				this.checkCurrent = e.currentTarget.dataset.index;
				let type = parseInt(e.currentTarget.dataset.type);
				console.log("this.currentIndex:",this.currentIndex);
				let index = type >0?currentIndex:currentIndex+1;
				console.log("index:",index)
				if(index %3 ==0){
					this.checkCurrent = this.checkCurrent+type;
					console.log("this.checkCurrent:",this.checkCurrent)
				}
				this.changeCurrent = this.checkCurrent
			},
			changSwiper:function(e){
				this.currentIndex = e.currentTarget.dataset.current;
				this.changeCurrent = e.currentTarget.dataset.index;
				console.log("currentIndex:",this.currentIndex);
				console.log("current:",this.changeCurrent)
			},
		}
	}
</script>

<style>
	@import "../../colorui/main.css";
	/* @import "../../colorui/icon.css"; */
	.question-step-name{
		font-size: 24upx;
		color:#CACACA;
		width: 80upx;
	}
	.question-step-icon{
		position: absolute;
		top: 0upx;
	}
	.step-up-line{
		width:4upx;
		height:50upx;
		background:#CACACA;
		position:absolute;
		top:0upx;
	}
	.step-bottom-line{
		width:4upx;
		height:50upx;
		background:#CACACA;
		position:absolute;
		bottom:0upx;
	}
	.question-jindu-top{
		flex-grow: 1;
		padding: 30upx;
	}
	.check-zhezao{
		pointer-events:none;
		color:#cacaca;
	}
	.question-tools-option{
		padding: 20upx 30upx;
		border:2upx solid #007AFF;
	}
	.question-tools-main{
		padding: 30upx 0upx;
	}
	.bottom-main-hr{
		background: #CACACA;
		width: 4upx;
		height: 100%;
	}
	.bottom-margin{
		display: flex;
		align-items: center;
		justify-content: center;
		flex-grow: 1;
		height: 100%;
		background: #333333;
		color: #FFFFFF;
	}
	.bottom-main-back{
	}
	.bottom-margin-confirm{
		
	}
	.bottom-main-margin{
		display: flex;
		justify-content: space-around;
		align-items: center;
		height: 100%;
	}
	.question-bottom-main{
		position: fixed;
		bottom: 0;
		height: 90upx;
		width: 100%;
		font-size: 30upx;
		background: #FFFFFF;
		z-index: 100;
	}
	.swiper-tab-top{
		height: 148upx;
		position:fixed;
		width:100%;
		background:#ffffff;
		z-index:100;
	}
	.tab-circle-active{
		position: absolute;
		left: 50%;
		border:2upx solid #333333;
		width: 15upx;
		height: 15upx;
		border-radius: 50%;
		top:-5upx;
		background:#ffffff;
	}
	.tab-circle{
		border:2upx solid #CACACA;
		width: 15upx;
		height: 15upx;
		border-radius: 50%;
		background:#CACACA;
		left: -7upx;
	}
	.tab-line{
		height: 4upx;
		width: 100%;
		background: #CACACA;
	}
	.swiper-tab-line{
		position: relative;
		margin-top:30upx;
	}
	.swiper-one{
		flex-grow: 1;
		text-align: center;
	}
	.swiper-tab{
		display: flex;
		justify-content: space-around;
		font-size: 30upx;
		height:98upx;
		background:#ffffff;
	}
	.diamond-bottom-textarea{
		border: 2upx solid #CACACA;
		width: 500rpx;
		height: 400rpx;
	}
	.diamond-bottom-textarea >textarea{
		width: 100%;
		height: 100%;
	}
	.question-diamond-bottom>textarea{
		width: 100%;
	}
	.question-diamond-bottom{
		margin-top: 30upx;
	}
	.detail-input{
		border:2upx solid #cacaca;
		text-align: right;
	}
	.record-detail-input{
		display: flex;
		justify-content: space-between;
		margin-top: 20upx;
	}
	.tab-color-0{
		background: #65d89b;
		color: rgb(255,255,255);
	}
	.tab-color-1{
		background: #ed0000;
		color: rgb(255,255,255);
	}
	.tab-color-2{
		background: #dedede;
		color: rgb(255,255,255);
	}
	.choose-item-word{
		color: #dedede;
	}
	.question-diamond-top{
		font-size: 30upx;
		padding:20upx 30upx;
		width:100%;
	}
	.choose-item-hr{
		height: auto;
		width: 2upx;
		background: #f2f2f2;
	}
	.mission-choose-item{
		padding:15upx 40upx;
		border-radius:35upx;
		font-size:30upx;
		font-weight: bold;
	}
	.detail-choose-item{
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.record-detail-choose{
		display: flex;
		justify-content: space-around;
		padding-top: 20upx;
	}
	.question-why-bottom{
		display: flex;
		justify-content: center;
		padding: 20upx 30upx 0upx 30upx;
	}
	.question-why-main{
		margin-top: 30upx;
	}
	.textarea-num{
		font-size: 26upx;
		display: flex;
		justify-content: flex-end;
	}
	.question-why-list{
		font-size: 30upx;
		border: 2upx solid #CACACA;
	}
	.why-textarea{
		width: 100%;
		height: 60upx;
	}
	.question-why-top{
		position: relative;
		padding: 20upx 30upx;
		border-bottom:30upx solid #f7f7f7;
	}
	.question-why-title{
		display: flex;
		justify-content: space-between;
		align-items: center;
		font-size: 32upx;
		font-weight: bold;
	}
	.question-swiper{
	}
	.answer-list-title{
		display: flex;
		justify-content: space-around;
		background:rgb(255,255,255);
		font-size:30upx;
		height:100upx;
		align-items:center;
		font-weight: 500;
	}
	.question-main{
		width: 100%;
		display: flex;
	}
	.item-active{
		color:#1592d9;
		border-bottom:2upx solid;
	}
	.answer-list-item{
		display: flex;
		justify-content: center;
		align-items: center;
		height:100%;
	}
	
	.fixed {
		position: fixed;
		z-index: 99;
	}
	
	.VerticalNav.nav {
		width: 80upx;
		white-space: initial;
	}
	.detail-tab-line{
		background: #CACACA;
		height: 100%;
	}
	.cu-item .detail-tab-text{
		flex-grow: 1;
		text-align: center;
	}
	.VerticalNav.nav .cu-item {
		display: flex;
		align-items: center;
		justify-content: center;
		width: 100%;
		background-color: #fff;
		margin: 0;
		border: none;
		height: 150upx;
		position: relative;
	}
	
	.VerticalNav.nav .cu-item.cur {
		background-color: #f1f1f1;
	}
	
	.VerticalNav.nav .cu-item.cur::after {
		content: "";
		width: 8upx;
		height: 30upx;
		border-radius: 10upx 0 0 10upx;
		position: absolute;
		background-color: currentColor;
		top: 0;
		right: 0upx;
		bottom: 0;
		margin: auto;
	}
	
	.VerticalBox {
		display: flex;
	}
	
	.VerticalMain {
		width: 100%;
		background-color: #f1f1f1;
	}
</style>