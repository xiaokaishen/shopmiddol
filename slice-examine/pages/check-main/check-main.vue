<template>
	<view style="width: 100%;">
		<view id="the-id">
			<view class="container">
				<view class="canvasView">
					<view class="title">
						<view class="check-title-user">
							<view class="check-title-header">
								
							</view>
							<view class="check-title-name">
								<view class="title-user-name">
									<text>用户名</text>
								</view>
								<view class="title-class-name">
									<text>所在部门名</text>
								</view>
							</view>
						</view>
						<view class="check-title-calendar" @click="gotoCalendar()">
							<image src="../../static/img/calendar.png"></image>
						</view>
						<!-- <text class="title-calendar" @click="gotoCalendar()">
							日历	
						</text> -->
					</view>
					<view style="height: 360upx;">
						<!-- <mpvue-echarts :echarts="echarts" :onInit="lineInit" canvasId="line" ref="lineChart" /> -->
					</view>
				</view>
			</view>
			<view class="check-div">
				
			</view>
		</view>
		<scroll-view scroll-y="true" @scrolltolower='onLowerRush()' :style="{height:windowHeight}">
			<block v-for="(item,index) in checkList" :key="index">
				<view class="main-list-top" @click="gotoDetail" :data-index="index" :data-id='item.id'>
					<view class="main-list">
						<view class="out-main">
							<view class="out-top">{{item.day}}</view>
							<view class="out-bottom">{{item.week}}</view>
						</view>
						<view class="check-list-tittle">
							<view>
								<view class="list-font-one">
									{{item.name}}
								</view>
								<view class="font-three-top">
									<view class="list-font-three" :data-index="index" @click.stop="onpenModal">
										<view v-if="item.chooseOne[item.oneIndex]" class="list-type-four">
											<text>{{item.chooseOne[item.oneIndex]}}</text>
										</view>
										<view v-if="item.chooseTwo[item.twoIndex]" class="list-type-four">
											<text>{{item.chooseTwo[item.twoIndex]}}</text>
										</view>
										<view v-if="item.chooseThree[item.threeIndex]" class="list-type-four">
											<text>{{item.chooseThree[item.threeIndex]}}</text>
										</view>
										<view v-if="item.chooseFour[item.fourIndex]" class="list-type-four">
											<text>{{item.chooseFour[item.fourIndex]}}</text>
										</view>
									</view>
									<!-- <view class="list-font-three" :data-index="index" @click.stop="onpenModal">
										<block v-for="(choose,chooseIndex) in item.chooseArray" :key='chooseIndex'>
											<view v-if="choose.checked" class="list-type-four">
												<text>{{choose.name}}</text>
											</view>
										</block>
									</view> -->
									<view class="main-list-right">
										25/30
										<view class="list-right-hr">
											<view class="list-right-background" style="width: 50%"></view>
										</view>
									</view>
								</view>
							</view>
						</view>
					</view>
				</view>
			</block>
			<!-- <view v-show="showRush"> -->
				<uni-load-more :status="loadType" :contentText="contentText"></uni-load-more>
			<!-- </view> -->
		</scroll-view>
		<!-- <neil-modal :show="show" 
		    @close="closeModal()" 
		    title="表头清单" 
			:show-cancel="false"
			confirm-color="rgb(255,255,255)"
			confirm-text="rgb(255,255,255)">
			<view class="main-modal-top">
				<block v-if="checkList[chooseIndex]">
					<block v-for="(choose,index) in chooseObj.chooseArray" :key="index">
						<view @click="chooseChecked" :data-index="index" class="check-main-modal" 
						:style="choose.checked?'background:#8F8F94;color:rgb(255,255,255)':''">
							{{choose.name}}
						</view>
					</block>
				</block>
			</view>
			<view class="detail-modal-submit" @click="chooseSubmit">
				确定
			</view>
		</neil-modal> -->
		<neil-modal 
		    :show="show" 
		    @close="closeModal" 
		    title="选择表头" 
			:show-cancel="false"
		    confirm-color="rgb(255,255,255)"
			confirm-text="rgb(255,255,255)"
			>
			<view v-if="chooseObj.chooseOne" class="record-modal-list">
				<view>
					<text>车间</text>
				</view>
				<view>
					<picker mode="selector" :range="chooseObj.chooseOne" @change="chooseOneChange">
						<view>{{chooseObj.chooseOne[chooseObj.oneIndex]}}</view>
					</picker>
				</view>
			</view>
			<view v-if="chooseObj.chooseTwo" class="record-modal-list">
				<view>
					<text>区域</text>
				</view>
				<view>
					<picker mode="selector" :range="chooseObj.chooseTwo" @change="chooseTwoChange">
						<view>{{chooseObj.chooseTwo[chooseObj.twoIndex]}}</view>
					</picker>
				</view>
			</view>
			<view v-if="chooseObj.chooseThree" class="record-modal-list">
				<view>
					<text>产线</text>
				</view>
				<view>
					<picker mode="selector" :range="chooseObj.chooseThree" @change="chooseThreeChange">
						<view>{{chooseObj.chooseThree[chooseObj.threeIndex]}}</view>
					</picker>
				</view>
			</view>
			<view v-if="chooseObj.chooseFour" class="record-modal-list">
				<view>
					<text>工位</text>
				</view>
				<view>
					<picker mode="selector" :range="chooseObj.chooseFour" @change="chooseFourChange">
						<view>{{chooseObj.chooseFour[chooseObj.fourIndex]}}</view>
					</picker>
				</view>
			</view>
			<view class="detail-modal-submit" @click="chooseSubmit">
				确定
			</view>
		</neil-modal>
	</view>
</template>

<script>
	import helper from '../../common/helper.js';
	import uniLoadMore from "@/components/uni-load-more/uni-load-more.vue";
	
	export default {
		computed:{
			checkList(){
				return helper.mission.checkList;
			},
			windowHeight(){
				var height = 0;
				uni.getSystemInfo({
					success:function (res) {
						height = res.windowHeight;
					}
				})
				return (height-uni.upx2px(450+30))+'px';
			}
		},
		data() {
			return {
				loadType: "more",
				chooseObj:{},
				chooseIndex:-1,
				show:false,
				showRush:false,
				domHeight:450,
				contentText: {
					contentdown: "全部显示",
					contentrefresh: "正在加载...",
					contentnomore: "没有更多数据了",
				},
				// checkList:[1,2,3,4],
				selected: [
                {
                    date: '2018-12-26'
                },
                {
                    date: '2018-12-27'
                },
                {
                    date: '2018-12-28'
                },
                {
                    date: '2019-1-29'
                }
            ],
				updateStatus: false
			}
		},
		onLoad() {
		},
		onShareAppMessage(res) {
			
		},
		methods: {
			chooseOneChange:function(e){
				console.log("chooseOneChange:",e)
				this.chooseObj.oneIndex = e.detail.value;
			},
			chooseTwoChange:function(e){
				this.chooseObj.twoIndex = e.detail.value;
			},
			chooseThreeChange:function(e){
				this.chooseObj.threeIndex = e.detail.value;
			},
			chooseFourChange:function(e){
				this.chooseObj.fourIndex = e.detail.value;
			},
			chooseSubmit:function(e){
				let id = this.chooseObj.id;
// 				if(!this.isChecked(this.chooseObj)){
// 					this.show = true;
// 					uni.showToast({
// 						title:"至少选择一个表头",
// 						icon:'none'
// 					})
// 					return false;
// 				}
				this.show = false;
				uni.navigateTo({
					url: '../mission-list/mission-list?id='+id
				})
			},
			chooseChecked:function(e){
				let index = e.currentTarget.dataset.index;
				let chooseArray = this.chooseObj.chooseArray;
				for(let i in chooseArray){
					chooseArray[i].checked = false;
				}
				this.chooseObj.chooseArray[index].checked = !chooseArray[index].checked;
			},
			onpenModal:function(e){
				console.log("e:",e)
				this.chooseIndex = e.currentTarget.dataset.index;
				this.chooseObj = helper.mission.checkList[this.chooseIndex];
				console.log("this.chooseObj:",this.chooseObj)
				this.show = true;
			},
			closeModal:function (e) {
				console.log("closeModal")
				this.show = !this.show;
			},
			gotoDetail:function(e){
				let id = e.currentTarget.dataset.id;
				let index = e.currentTarget.dataset.index;
// 				if(!this.isChecked(helper.mission.checkList[index])){
// 					console.log("helper.mission.checkList[index]:",helper.mission.checkList[index])
// 					this.chooseIndex = index;
// 					this.chooseObj = helper.mission.checkList[index];
// 					this.show = true;
// 					uni.showToast({
// 						title:"至少选择一个表头",
// 						icon:'none'
// 					})
// 					return false;
// 				}
				uni.navigateTo({
					// url: '../check-detail/check-detail'
					url: '../mission-list/mission-list?id='+id
				})
			},
			isChecked:function(chooseObj){
				let chooseArray = chooseObj.chooseArray;
				let count = 0;
				for(let i in chooseArray){
					if(chooseArray[i].checked){
						count++
					}
				}
				if(count == 0){
					return false;
				}
				return true;
			},
			onLowerRush(){
				var _that = this;
				_that.loadType = "loading";
				setTimeout(function(){
					_that.loadType = "more";
				},3000)
			},
			gotoCalendar(){
				uni.navigateTo({
					url:'../check-calendar/check-calendar'
				})
			},
		},
		components: {
			uniLoadMore
		}
	}
</script>

<style>
	.record-modal-list{
		display: flex;
		justify-content: space-between;
		padding:20upx 30upx;
	}
	.title-user-name{
		font-size: 24upx;
		color: #ffffff;
	}
	.title-class-name{
		font-size: 30upx;
		color: #ffffff;
	}
	.check-title-name{
		margin-left: 40upx;
	}
	.check-title-user{
		display: flex;
		align-items: center;
	}
	.check-title-calendar >image{
		width: 45upx;
		height: 39upx;
	}
	.check-title-header{
		width: 70upx;
		height: 70upx;
		border-radius: 50%;
		background: #efefef;
		border:4upx solid #ffffff;
	}
	.list-right-background{
		height: 10upx;
		background: #75b7e5;
		border-radius:25upx;
	}
	.list-right-hr{
		width:150upx;
		height:10upx;
		background:#f3f3f3;
		border-radius:25upx;
	}
	.font-three-top{
		display: flex;
		justify-content: space-between;
		align-items: center;
		width: 560upx;
	}
	.out-bottom{
		border-bottom-left-radius: 25upx;
		border-bottom-right-radius: 25upx;
		background: #2079ab;
		height: 48upx;
		font-size: 24upx;
		color: #f5f5f5;
	}
	.out-top{
		border-top-left-radius: 25upx;
		border-top-right-radius: 25upx;
		background: #f9f9f9;
		height: 61upx;
		font-size: 48upx;
		color: #4f95d5;
		font-weight: bold;
	}
	.out-main >view{
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.out-main{
		width: 104upx;
		height: 104upx;
		background: #f0ffff;
		border-radius:25upx;
		box-shadow:0upx 3upx 5upx #888888;
		padding: 10upx;
	}
	.detail-modal-submit{
		background:rgb(73,90,128);
		display:flex;
		justify-content:center;
		align-items:center;
		padding:20upx 0upx;
		margin:30upx 30upx 0upx;
		border-radius:15upx;
		color:rgb(255,255,255);
		font-size:32upx;
	}
	.check-main-modal{
		width: 45%;
		text-align: center;
		padding: 20upx 0;
		margin: 20upx 0;
		border:1upx solid #BDBABD
	}
	.main-modal-top{
		display: flex;
		justify-content: space-around;
		align-items: center;
		flex-wrap: wrap;
	}
	.main-list-right{
		display: flex;
		flex-direction: column;
		align-items: center;
		font-size: 18upx;
		color: #b6b6b6;
	}
	.main-list-top{
		font-size: 26upx;
		display: flex;
		justify-content: space-between;
		padding:30upx;
		background: rgb(255,255,255);
		margin-bottom: 2upx;
	}
	.check-list-tittle{
		display: flex;
		align-items: center;
		width:560upx;
		word-break:break-all;
		margin-left:14upx;
	}
	.main-list{
		display: flex;
	}
	.list-font-one{
		font-size: 24upx;
		color: #878787;
	}
	.list-font-two{
		font-size: 26upx;
		color: rgb(155,155,155);
	}
	.list-font-three{
		display: flex;
		flex-wrap: wrap;
		font-size: 26upx;
		margin-top: 20upx;
	}
	.list-type-one{
		background:rgb(201,201,201);
		color:rgb(255,255,255);
		padding:3upx 8upx;
		margin-right: 20upx;
	}
	.list-type-two{
		background:rgb(242,69,28);
		color:rgb(255,255,255);
		padding:3upx 8upx;
		border: 1upx solid rgb(242,69,28);
	}
	.list-type-three{
		background:rgb(255,255,255);
		color:rgb(242,69,28);
		padding:3upx 8upx;
		border: 1upx solid rgb(242,69,28);
	}
	.check-main-list{
		display: flex;
	}
	.out{
		border-bottom:120upx #D6D3D6 solid;
		width:0upx;
		height:6upx;
		border-right:120upx #BDBABD solid;
		position:relative;
		margin-right: 30upx;
	}
	.b{
		font-style:normal;
		display:block;
		position:absolute;
		top:69upx;
		left:6upx;
		width:60upx;
	} 
	.em{
		font-style:normal;
		display:block;
		position:absolute;
		top:22upx;
		left:51upx;
		width:60upx;
	} 
	.title-calendar{
		background:rgb(9,160,247);
		color:rgb(255,255,255);
		padding:0 20upx;
		margin:20upx 20upx 0upx 0upx;
		border-radius:35upx;
	}
	page,
	view {
        font-size: 26upx;
	}

	page {
		min-height: 100%;
	}

	.page-section-title {
		padding: 0 30upx;
	}

	.title {
		display: flex;
		justify-content: space-between;
		align-items: center;
		background: #1398dc;
		padding: 10upx 20upx;
	}

	.container {
		display: flex;
		padding-bottom: 30upx;
		box-sizing: border-box;
		background: rgb(255,255,255);
		height: 450upx;
	}

	.container,
	.canvasView {
		display: flex;
		flex: 1;
		flex-direction: column;
	}

	.navigate {
		color: #007AFF;
	}

	.canvas-bar {
		display: flex;
		flex-direction: row;
		justify-content: space-between;
	}

	.update-btn {
		margin-right: 30upx;
	}
</style>
