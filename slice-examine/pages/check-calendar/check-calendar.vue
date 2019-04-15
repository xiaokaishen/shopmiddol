<template>
	<view>
		<view class="content">
			<calendar 
			:selected="selected" 
			:lunar="false" 
			:disable-before="true" 
			:start-date="'2019-01-01'"
			:end-date="'2019-12-31'"
			@getdate="getdate" />
		</view>
			<view class="calendar-color-beizhu">
				<view class="color-beizhu-title">
					<text>备注：</text>
				</view>
				<view class="color-beizhu-list">
					<view>
						<text>超期完成：</text>
						<image class="calendar-jiaobiao" src="../../static/img/jiaobiao-yellow.png"/>
					</view>
					<view>
						<text>超期：</text>
						<image class="calendar-jiaobiao" src="../../static/img/jiaobiao-red.png"/>
					</view>
					<view>
						<text>完成：</text>
						<image class="calendar-jiaobiao" src="../../static/img/jiaobiao-green.png"/>
					</view>
					<view>
						<text>待完成：</text>
						<image class="calendar-jiaobiao" src="../../static/img/jiaobiao-gray.png"/>
					</view>
				</view>
			</view>
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
								<view class="list-font-three" :data-id="item.id" @click.stop="onpenModal">
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
import calendar from '../../components/mehaotian-calendar/mehaotian-calendar.vue';
export default {
    components: {
        calendar
    },
    data() {
        return {
			id:0,
			loadType: "more",
			chooseObj:{},
			chooseIndex:-1,
			show:false,
			checkList:[]
        };
    },
	computed:{
		selected(){
			return helper.mission.checkList;
		}
	},
	onLoad() {
		
	},
    methods: {
		compareTime(){
			
		},
		chooseOneChange:function(e){
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
			this.id = e.currentTarget.dataset.id;
			let checkList = helper.mission.checkList;
			
			for(let i in checkList){
				if(this.id == checkList[i].id){
					this.chooseObj = checkList[i];
				}
			}
			this.show = true;
		},
		closeModal:function (e) {
			this.show = !this.show;
		},
		gotoDetail:function(e){
			let id = e.currentTarget.dataset.id;
			let index = e.currentTarget.dataset.index;
			uni.navigateTo({
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
        getdate(e) {
			let checkList = helper.mission.checkList;
			let year = e.year+'';
			let month = e.month <10 ? '0'+ e.month: e.month +'';
			let day = e.date <10 ? '0' + e.date: e.date + '';
			let date = year +'-'+ month +'-' + day;
			this.checkList = [];
			for(let i in checkList){
				if(date == checkList[i].date){
					this.checkList.push(checkList[i])
				}
			}
        }
    }
};
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
		padding:30upx 0 30upx 30upx;
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
	.list-type-four{
		background:rgb(68,187,0);
		color:rgb(255,255,255);
		padding:3upx 8upx;
		margin-right: 20upx;
	}
	.check-main-list{
		display: flex;
	}
	.calendar-jiaobiao{
		width: 16upx;
		height: 16upx;
	}
	.beizhu-list-yellow{
		width: 30upx;
		height: 30upx;
		background: #ffde00;
	}
	.color-beizhu-list>view{
		display: flex;
		align-items: center;
		margin-right: 30upx;
	}
	.color-beizhu-list{
		display: flex;
		align-items: center;
		margin-top: 20upx;
	}
	.color-beizhu-title{
		font-size: 30upx;
		font-weight: 600;
	}
	.calendar-color-beizhu{
		font-size: 26upx;
		display: flex;
		flex-direction: column;
		padding: 30upx;
	}
</style>