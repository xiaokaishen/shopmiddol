<template>
	<view style="width: 100%;">
	<scroll-view scroll-y style="height: 100vh;">
		<view class="question-list-top" :data-id='item.list' @click="gotoDetail"
		v-for="(item,index) in checkList" :key="index">
			<view class="question-list-detail">
				<view class="question-list-type" 
				:class="item.progress ==1?'bg-yellow':item.progress ==2?'bg-red':item.progress ==3?'bg-green':''">
				</view>
				<view class="list-detail-message">
					<view class="detail-message-left">
						<view class="bg-cyan detail-message-top">
							<view class="detail-message-text">
								{{item.come}}
							</view>
						</view>
						<view class="detail-message-name">
							<view class="">
								<text>{{item.code}}</text>
							</view>
							<view>
								{{item.name}}
							</view>
							<view>
								{{item.user}}
							</view>
						</view>
					</view>
					<view class="detail-message-right">
						<text class="message-right-text"
						:class="item.progress ==1?'text-yellow':item.progress ==2?'text-red':item.progress ==3?'text-green':''">{{item.count}}</text><text>{{item.unit}}</text>
					</view>
				</view>
			</view>
			<view class="question-list-main">
				<view class="swiper-tab">
					<view class="swiper-one" v-for="(arrItem,aIndex) in item.tabList" :key="aIndex">
						<view class="swiper-one-name"
						:class="item.progress ==1?'text-yellow':item.progress ==2?'text-red':item.progress ==3?'text-green':''">
							<text>{{aIndex == item.list?arrItem.name:''}}</text>
						</view>
						<view class="question-tab-line">
							<view class="tab-line" :style="aIndex <= item.list?{background:'#333333'}:''"></view>
							<view v-if="arrItem.isDone ==1" class="tab-circle-icon">
								<uni-icon type='checkbox-filled' size='20' color='rgb(57,181,74)'></uni-icon>
							</view>
							<view v-if="arrItem.isDone ==2" class="tab-circle-icon">
								<uni-icon type='circle-filled' size='20' color='rgb(251,189,8)'></uni-icon>
							</view>
							<view v-if="arrItem.isDone ==-1" class="tab-circle-icon">
								<uni-icon type='clear' size='20' color='rgb(229,77,66)'></uni-icon>
							</view>
							<view v-else-if="arrItem.isDone ==3" class="tab-circle"></view>
							<!-- <view :class="aIndex <= item.list?'tab-circle-active':'tab-circle'"></view> -->
						</view>
					</view>
				</view>
				<view class="question-list-bottom">
					<view>
						<text>开始时间： {{item.startDate}}</text>
					</view>
					<view>
						<text>预计关闭日期： {{item.endDate}}</text>
					</view>
				</view>
			</view>
		</view>
	</scroll-view>	
	</view>
</template>

<script>
	export default {
		props:{
			checkList:{
				type:Array,
				default:() => []
			},
		},
		methods:{
			gotoDetail:function(e){
				let index = e.currentTarget.dataset.id;
				uni.navigateTo({
					// url: '../check-question/check-question?index='+index
					url: '../question-detail/question-detail?index='+index
				})
			},
		}
	}
</script>

<style>
	@import "../../colorui/main.css";
	/* @import "../../colorui/icon.css"; */
	.question-list-bottom{
		display: flex;
		justify-content: space-between;
		font-size: 24upx;
		color: #46595F;
		margin-top: 20upx;
	}
	.question-list-main{
		padding-top: 25upx;
	}
	.question-list-code{
		display: flex;
		justify-content: flex-end;
	}
	.question-list-bottom{
		
	}
	.message-right-text{
		font-size: 80upx;
	}
	.detail-message-name{
		margin-left: 20upx;
	}
	.list-detail-message{
		display: flex;
		justify-content: space-between;
		align-items: center;
		width: 100%;
	}
	.detail-message-left{
		display: flex;
	}
	.detail-message-right{
		font-size: 24upx;
	}
	.detail-message-top{
		display: flex;
	}
	.detail-message-top{
		width:100upx;
		height:100upx;
		font-size:24upx;
		display:flex;
		justify-content:center;
		align-items:center;
		margin-left: 20upx;
		border-radius: 35upx;
	}
	.detail-message-text{
		padding: 10upx;
	}
	.detail-message-come{
		
	}
	.question-list-detail{
		display: flex;
	}
	.question-list-type{
		width:20upx;
		height:100upx;
		border-radius:50upx;
	}
	.question-tab-line{
		position: relative;
		background: #FFFFFF;
		flex-grow: 1;
	}
	.swiper-one-name{
		height: 24upx;
		font-size: 24upx;
		position: relative;
		bottom: 25upx;
		left: 20upx;
		font-weight: 600;
	}
	.swiper-tab{
		display: flex;
		justify-content: space-around;
		font-size: 30upx;
		height:40upx;
		background:#ffffff;
	}
	.tab-circle-icon{
		position: absolute;
		left: 50%;
		top:-17upx;
		background: #FFFFFF;
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
	tab-circle-active{
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
		background:#CACACA;
	}
	.tab-line{
		height: 4upx;
		width: 100%;
		background: #CACACA;
	}
	.swiper-tab-line{
		position: relative;
		margin-top:10upx;
	}
	.swiper-one{
		flex-grow: 1;
		text-align: center;
	}
	.swiper-tab-top{
		height: 100upx;
		position:fixed;
		width:100%;
		background:#ffffff;
		z-index:100;
	}
	.question-list-top{
		/* display: flex; */
		padding: 30upx 20upx 10upx 20upx;
		background: #FFFFFF;
		border-top: 2upx solid #DEDEDE;
		border-bottom: 30upx solid #DEDEDE;
		font-size: 24upx;
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
</style>
