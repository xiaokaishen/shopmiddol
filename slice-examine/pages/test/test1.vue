<template>
	<view style="width:100%;">
		<scroll-view scroll-x class="bg-white nav">
			<view class="flex text-center">
				<view class="cu-item flex-sub" :class="index==TabCur?'text-green cur':''" v-for="(item,index) in topList" :key="index" @tap="tabSelect" :data-id="index">
					{{item.name}}({{index==0?checkList.length:index==1
					?readyList.length:index==2?badList.length:doneList.length}})
				</view>
			</view>
		</scroll-view>
		<swiper :current="listCur" @change="changeList" style="height: 100vh;">
			<swiper-item>
				<view class="swiper-item">
					<question-list :checkList="checkList"></question-list>
				</view>
			</swiper-item>
			<swiper-item>
				<view class="swiper-item">
					<question-list :checkList="readyList"></question-list>
				</view>
			</swiper-item>
			<swiper-item>
				<view class="swiper-item">
					<question-list :checkList="badList"></question-list>
				</view>
			</swiper-item>
			<swiper-item>
				<view class="swiper-item">
					<question-list :checkList="doneList"></question-list>
				</view>
			</swiper-item>
		</swiper>
	</view>
</template>

<script>
	import questionList from '../../components/list-template/question-list.vue'
	import helper from '../../common/helper.js'
	export default {
		components:{
			questionList
		},
		computed:{
			checkList(){
				return helper.questionData.checkList;
			},
			readyList(){
				return this.aroundList(1);
			},
			badList(){
				return this.aroundList(2);
			},
			doneList(){
				return this.aroundList(3);
			},
			tabList(){
				return helper.questionData.tabList;
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
			}
		},
		data(){
			return {
				listCur:0,
				changeCurrent:0,
				topList: [
					{
					name:'全部'
					},
					{
					name:'待完成'
					},
					{
					name:'审核失败'
					},
					{
					name:'已完成'
					},
				],
				TabCur: 0,
				scrollLeft: 0
			}
		},
		methods:{
			aroundList(type){
				var list = [];
				let checkList = helper.questionData.checkList;
				checkList.forEach(function(v,i){
					if(v.progress ==type){
						list.push(v)
					}
				})
				console.log("v:",list);
				return list;
			},
			//记录顶部swiper
			recordCurrent(e){
				this.changeCurrent = e.detail.current;
			},
			changSwiper:function(e){
				this.TabCur = e.currentTarget.dataset.current;
				this.changeCurrent = e.currentTarget.dataset.index;
			},
			tabSelect(e) {
				this.TabCur = e.currentTarget.dataset.id;
				this.listCur = e.currentTarget.dataset.id;
				this.scrollLeft = (e.currentTarget.dataset.id - 1) * 60
			},
			changeList(e){
				this.TabCur = e.detail.current;
				this.scrollLeft = (e.detail.current - 1) * 60
			}
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
		padding-top: 30upx;
	}
	.question-list-code{
		display: flex;
		justify-content: flex-end;
	}
	.question-list-bottom{
		
	}
	.message-right-text{
		font-size: 55upx;
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
		padding-bottom:30upx;
		background: #FFFFFF;
		flex-grow: 1;
	}
	.swiper-one-name{
		height: 35upx;
	}
	.swiper-tab{
		display: flex;
		justify-content: space-around;
		font-size: 30upx;
		height:68upx;
		background:#ffffff;
		/* border-bottom: 2upx solid #CACACA; */
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
