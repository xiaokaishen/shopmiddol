<template>
	<view class="question-main">
		<swiper :current="current" class="swiper-tab-top" indicator-dots @change="recordCurrent">
			<swiper-item v-for="(question,qIndex) in questionList" :key="qIndex">
				<view class="swiper-item">
					<view class="swiper-tab">
						<view class="swiper-one" v-for="(item,index) in question.tabList" :key="index" @click="changSwiper" :data-current="item.list"
						 :data-index="qIndex">
							<view>
								<text>{{item.name}}</text>
							</view>
							<view class="swiper-tab-line">
								<view class="tab-line" :style="item.list <= currentIndex?{background:'#333333'}:''"></view>
								<view :class="item.list <= currentIndex?'tab-circle-active':'tab-circle'"></view>
							</view>
						</view>
					</view>
				</view>
			</swiper-item>
		</swiper>
		<view class="question-swiper" :style="{height:windowHeight}">
			<view class="swiper-item" v-if="currentIndex==0">
				<view>
					<text>紧急遏制</text>
				</view>
			</view>
			<view class="swiper-item" v-if="currentIndex==1">
				<view>
					<text>分析小组</text>
				</view>
			</view>
			<view class="swiper-item" v-if="currentIndex==2">
				<view class="question-tools-main">
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
			</view>
			<view class="swiper-item" v-if="currentIndex==3">
				<view>
					<text>临时措施</text>
				</view>
			</view>
			<view class="swiper-item" v-if="currentIndex==4">
				<view>
					<text>根本原因</text>
				</view>
			</view>
			<view class="swiper-item" v-if="currentIndex==5">
				<view>
					<text>永久措施</text>
				</view>
			</view>
		</view>
		<view class="question-bottom-main">
			<view class="bottom-main-margin">
				<block v-if="currentIndex !=0">
					<view class="bottom-margin" :data-current="currentIndex-1" :data-index="checkCurrent" data-type="-1" @click="clickChange">
						<text>上一步</text>
					</view>
					<view class="bottom-main-hr"></view>
				</block>
				<block v-if="(currentIndex+1) <tabList.length">
					<view class="bottom-margin" :data-current="currentIndex+1"
					  :data-index="checkCurrent" data-type="1" @click="clickChange">
						<text>下一步</text>
					</view>
				</block>
				<block v-else>
					<view class="bottom-margin">
						<text>提交</text>
					</view>
				</block>
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
			if(option.index){
				let index = parseInt(option.index);
				this.currentIndex = index;
				if(index%3 ==0){
					this.changeCurrent = this.changeCurrent+(index/3);
				}
			}
		},
		methods:{
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
			},
		}
	}
</script>

<style>
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
		position: absolute;
		left: 50%;
		border:2upx solid #CACACA;
		width: 15upx;
		height: 15upx;
		border-radius: 50%;
		top:-5upx;
		background:#ffffff;
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
		padding-top: 148upx;
		padding-bottom:90upx;
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
</style>
