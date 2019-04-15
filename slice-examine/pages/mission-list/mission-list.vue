<template>
	<view class="record-detail-main">
		<view class="main-list-top">
			<view class="main-list">
				<view class="out-main">
					<view class="out-top">{{checkData.day}}</view>
					<view class="out-bottom">{{checkData.week}}</view>
				</view>
				<view class="check-list-tittle">
					<view>
						<view class="list-font-one">
							{{checkData.name}}
						</view>
						<view class="font-three-top">
							<view class="list-font-three" :data-index="index" @click.stop="onpenModal">
								<view v-if="checkData.chooseOne[checkData.oneIndex]" class="list-type-four">
									<text>{{checkData.chooseOne[checkData.oneIndex]}}</text>
								</view>
								<view v-if="checkData.chooseTwo[checkData.twoIndex]" class="list-type-four">
									<text>{{checkData.chooseTwo[checkData.twoIndex]}}</text>
								</view>
								<view v-if="checkData.chooseThree[checkData.threeIndex]" class="list-type-four">
									<text>{{checkData.chooseThree[checkData.threeIndex]}}</text>
								</view>
								<view v-if="checkData.chooseFour[checkData.fourIndex]" class="list-type-four">
									<text>{{checkData.chooseFour[checkData.fourIndex]}}</text>
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
		<view id="answer-list-top">
			<view class="answer-list-title">
				<block v-for="(item,index) in tabList" :key='index'>
					<view class="answer-list-item" :class="index == current ?'item-active':''"
					@click="clickChange" :data-current='index'>
						<text>{{item.name}}({{item.count}})</text>
					</view>
				</block>
			</view>
			<!--间距-->
			<view class="check-div">
				
			</view>
		</view>
		<swiper :current="current" :style="{height:windowHeight}" @change="changSwiper">
			<block v-for="(tab,tabIndex) in tabList" :key='tabIndex'>
				<swiper-item>
					<scroll-view style="background: rgb(255,255,255);" scroll-y="true" :style="{height:windowHeight}">
						<block v-for="(group,groupIndex) in groupList" :key='groupIndex'>
							<view>
								<view class="group-top" @click="closeGroup" :data-index='groupIndex'>
									<view class="group-name">
										<text>{{group.name}}</text>
										<image @click.stop="openAdd()" class="group-name-image" src="../../static/img/small-add.png" />
									</view>
									<view>
										<uni-icon :type='group.iconType' size='15'></uni-icon>
									</view>
								</view>
								<block v-for="(item,index) in changeList" :key='index'>
									<view v-show="group.show" v-if="item.groupIndex == groupIndex" class="detail-list-top">
										<view v-if="item.doneIndex ==1" class="check-nok-image">
											<image 
											:src="item.updateIndex ==0?'../../static/img/update-now.png':item.updateIndex ==1?'../../static/img/update-date.png':item.updateIndex ==2?'../../static/img/update-up.png':''"/>
										</view>
										<view class="mission-list-top">
											<block v-if="item.doneIndex ==1">
												<view class="mission-left-hr"
												:class="'nok-color-'+item.updateIndex"></view>
											</block>
											<block v-else>
												<view class="mission-left-hr"
												:class="'tab-color-'+item.doneIndex"></view>
											</block>
											<view class="mission-list-title">
												<view class="mission-list-name">
													<view class="list-name-left">
														<text>{{item.name}}</text>
													</view>
													<view class="list-name-right">
														<uni-icon type='help' color="#178ed7" @click='openHelp' size='24'>
														</uni-icon>
													</view>
												</view>
												<view class="record-detail-choose">
													<block v-for="(done,dIndex) in item.doneArray" :key='dIndex'>
														<view class="detail-choose-item" :data-dindex='dIndex' :data-index='index' :data-id='item.id' @click="doneChange"
														:style="{width: 100/item.doneArray.length+'%'}">
															<view class="mission-choose-item" :class="item.doneIndex !=dIndex?'choose-item-word':'tab-color-'+item.doneIndex">
																{{done}}
															</view>
														</view>
														<block v-if="(dIndex+1)< item.doneArray.length">	
															<view class="choose-item-hr"></view>
														</block>
													</block>
												</view>
												<view class="mission-check-count">
													<view class="record-detail-count">
														<view>
															<image class="detail-count-img" src="../../static/img/small-car.png"/>
															<text>
																不合格率：{{item.nokCount}}%
															</text>
														</view>
														<view>
															<image class="detail-count-img" src="../../static/img/small-person.png"/>
															<text>
																发现率：{{item.nokCount}}%
															</text>
														</view>
														<view>
															<image class="detail-count-img" src="../../static/img/small-time.png"/>
															<text>
																历史问题：{{item.nokCount}}
															</text>
														</view>
													</view>
													<view>
														<image class="detail-fire-img"  src="../../static/img/fire.png"/>
													</view>
												</view>
											</view>
										</view>
									</view>
								</block>
							</view>
							<!--间距-->
							<view class="check-div">
								
							</view>
						</block>
					</scroll-view>
				</swiper-item>
			</block>
		</swiper>
		<view class="mission-kongbai"></view>
		<view class="check-background check-bottom">
			<view class="check-bottom-menu">
				<view class="bottom-menu-left" @click="gotoCheckMain">
					<view class="bottom-submit-img">
						<image src="../../static/img/small-cloud.png"></image>
					</view>
					<view>提交</view>
				</view>
				<view class="bottom-menu-right">
					<block v-for="(item,index) in tabList" :key='index'>
						<view class="bottom-menu-list">
							<text class="check-icon">{{item.name}}</text>
							<text>{{item.count}}</text>
						</view>
						
					</block>
				</view>
			</view>
		</view>
		<neil-modal :show="helpShow" 
		    @close="openHelp" 
		    title="帮助" 
			:show-cancel="false">
		</neil-modal>
		<neil-modal :show="addShow" 
		    @close="openAdd" 
		    title="添加临时审核项" 
			:show-cancel="false">
		</neil-modal>
	</view>
</template>

<script>
	import helper from '../../common/helper.js';
	export default {
		data(){
			return {
				addShow: false,
				helpShow: false,
				checkData:{},
				groupShow:false,
				groupList:[],
				changeList:[],
				tabList:[],
				current:0,
				lastUpdate:-1
			}
		},
		computed:{
// 			lastUpdate(){
// 				return helper.mission.lastUpdate;
// 			},
			list(){
				return helper.mission.list;
			},
			windowHeight(){
				var height = 0;
				uni.getSystemInfo({
					success:function (res) {
						height = res.windowHeight;
					}
				})
				return (height-135)+'px';
			}
		},
		onLoad(option){
			helper.mission.getChangeCount(this);
			helper.mission.updateChangeList(0,this);
			if(option && option.id){
				helper.mission.getCheckData(option.id,this);
			}
		},
		onShow(){
			helper.mission.getLastUpdate(this);
		},
		methods:{
			openAdd(){
				this.addShow = !this.addShow;
			},
			openHelp(){
				this.helpShow = !this.helpShow;
			},
			gotoCheckMain(e){
				console.log("gotoCheckMain")
				uni.switchTab({
					url:'../check-main/check-main'
				})
			},
			closeGroup(e){
				console.log("closeGroup",e)
				var index = e.currentTarget.dataset.index;
				console.log(index)
				this.groupList[index].show = !this.groupList[index].show;
				console.log("this.groupList===",this.groupList)
				if(this.groupList[index].show){
					this.groupList[index].iconType = 'arrowdown'
				}else{
					this.groupList[index].iconType = 'arrowup'
				}
			},
			//切换changelist内容
			updateChangeList:function(current){
				helper.mission.updateChangeList(current);
			},
			//获取所有tab栏的个数
			getChangeCount:function(){
				helper.mission.getChangeCount();
			},
			clickChange:function(e){
				let current = e.currentTarget.dataset.current;
				e.detail.current = current;
				console.log(e)
				helper.mission.changSwiper(e,this);
			},
			changSwiper:function(e){
				helper.mission.changSwiper(e,this);
			},
			doneChange:function(e){
				let doneIndex = e.currentTarget.dataset.dindex;
				let id = e.currentTarget.dataset.id;
				helper.mission.doneChange(e,this);
				if(doneIndex == 1){
					helper.mission.gotoNext(id);
				}
			},
			getLastUpdate:function(){
				helper.mission.getLastUpdate(this);
			}
		}
	}
</script>

<style>
	.group-name-image {
		width: 34upx;
		height: 34upx;
		margin-left: 30upx;
	}
	.check-nok-image{
		position:absolute;
		bottom:31upx;
		right:10upx;
	}
	.check-nok-image >image{
		width: 283upx;
		height: 130upx;
	}
	.nok-color-0{
		background: #ffde00;
		color: #fefefe;
	}
	.nok-color-1{
		background: #ff9000;
		color: #fefefe;
	}
	.nok-color-2{
		background: #f46666;
		color: #fefefe;
	}
	.detail-fire-img{
		width: 38upx;
		height: 44upx;
	}
	.mission-check-count{
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.detail-count-img{
		width: 31upx;
		height: 31upx;
		margin-right: 8upx;
	}
	.mission-choose-item{
		padding:15upx 40upx;
		border-radius:35upx;
		font-size:30upx;
		font-weight: bold;
	}
	.choose-item-color{
		background:#1398dc;
		color: #fefefe;
		padding:15upx 40upx;
		border-radius:35upx;
		font-size:30upx;
	}
	.choose-item-word{
		color: #dedede;
	}
	.choose-item-hr{
		height: auto;
		width: 2upx;
		background: #f2f2f2;
	}
	.list-name-left{
		word-break: break-all;
	}
	.mission-list-title{
		width: 100%;
		padding:20upx;
	}
	.mission-list-name{
		display: flex;
		justify-content: space-between;
		color: #878787;
		font-size: 24upx;
	}
	.mission-list-top{
		display: flex;
	}
	.mission-left-hr{
		width: 20upx;
		height: auto;
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
	.record-detail-count{
		display: flex;
		align-items: center;
		padding-top: 20upx;
		font-size: 20upx;
		color: #b6b6b6;
		width: 100%;
	}
	.record-detail-count>view{
		display: flex;
		align-items: center;
		margin-right: 40upx;
	}
	.mission-kongbai{
		width: 100%;
		height: 98upx;
	}
	.bottom-menu-hr{
		
	}
	.detail-choose-item{
		display: flex;
		justify-content: center;
		align-items: center;
		z-index: 100;
	}
	.record-detail-choose{
		display: flex;
		justify-content: space-around;
		padding-top: 20upx;
	}
	.main-list-right{
		display: flex;
		flex-direction: column;
		align-items: center;
		font-size: 18upx;
		color: #b6b6b6;
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
	.check-list-tittle{
		display: flex;
		align-items: center;
		width:560upx;
		word-break:break-all;
		margin-left:14upx;
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
	.main-list{
		display: flex;
	}
	.main-list-top{
		font-size: 26upx;
		display: flex;
		justify-content: space-between;
		padding:30upx;
		background: rgb(255,255,255);
		margin-bottom: 2upx;
	}
	.detail-list-div{
		width: 20upx;
		margin-right: 10upx;
	}
	.detail-list-top{
		position: relative;
		border-bottom: 2upx solid rgb(241,241,241);
		font-size: 26upx;
	}
	.group-name{
		display: flex;
		align-items: center;
		margin-right: 20upx;
	}
	.group-top{
		height: 80upx;
		font-size: 30upx;
		display: flex;
		align-items: center;
		justify-content: space-between;
		border-bottom: 2upx solid rgb(241,241,241);
		color: #787878;
		padding: 0 40upx;
		font-weight:600;
	}
	.tab-color{
		
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
	.tab-color-3{
		background: rgb(255,108,2);
		color: rgb(255,255,255);
	}
	.tab-color-4{
		background: #007AFF;
		color: rgb(255,255,255);
	}
	.check-top{
		display:flex;
		font-size:26upx;
		align-items:center;
		justify-content: space-between;
	}
	.check-top-number{
		display: flex;
		justify-content:center;
		align-items:center;
		background:rgb(1,184,213);
		color:rgb(255,255,255);
		padding:0upx 40upx;
		margin-right:20upx;
		border-radius:10upx;
	}
	.check-background{
		background: rgb(255,255,255);
		font-size: 26upx;
	}
	.check-bottom{
		position:fixed;
		width:100%;
		bottom:0upx;
		height: 98upx;
	}
	.check-bottom-menu{
		font-size:30upx;
		display:flex;
		justify-content:space-between;
		align-items: center;
		height: 100%;
	}
	.bottom-menu-left{
		display: flex;
		align-items: center;
		color:#ffffff;
		font-size: 25upx;
		margin-left: 50upx;
		width: 131upx;
		height: 44upx;
		background: #188bd5;
		justify-content:center;
		border-radius:25rpx;
	}
	.bottom-menu-right{
		display: flex;
		justify-content: flex-end;
		align-items: center;
		color: #1690d8;
		font-size: 24upx;
	}
	.bottom-menu-list{
		display: flex;
		align-items: center;
		margin-right: 20upx;
	}
	.check-icon{
		margin-right: 10upx;
	}
	.bottom-submit-img{
		margin-right: 8upx;
	}
	.bottom-submit-img >image{
		width:47upx;
		height:31upx;
	}
	.bottom-menu-img{
		width: 50upx;
		height: 50upx;
		margin-right: 20upx;
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
.record-detail-main{
	width: 100%;
}
.record-detail-top{
	display:flex;
	background:rgb(255,255,255);
	padding:30upx 0;
	font-size:30upx;
	justify-content:center;
}
.record-detail-list{
	display:flex;
	background:rgb(255,255,255);
	padding:30upx 30upx 30upx 0;
}
.record-detail-heard >image{
	width: 100upx;
	height: 100upx;
}
.detail-heard-font{
	font-size: 26upx;
}
.detail-list-left{
	display: flex;
	justify-content: flex-end;
}
.last-font{
	font-size:26upx;
	color: #E54D42;
}
.list-left-one{
}
.list-left-two{
	margin-left: 30upx;
}
.detail-list-manager{
	color:rgb(242,179,2);
	font-size:26upx;
	margin-bottom: 10upx;
}
.detail-list-date{
	color:#C8C7CC;
	font-size: 26upx;
}
.list-left-tap{
	font-size:26upx;
	padding:0 15upx;
	border-radius:10upx;
	color:rgb(255,255,255);
}
.record-detail-personal{
	background: rgb(255,255,255);
	display:flex;
	justify-content:flex-end;
	align-items:center;
	padding: 30upx;
}
.record-detail-personal>image{
	width: 50upx;
	height: 50upx;
}
.record-detail-personal>text{
	color: #C8C7CC;
	font-size: 30upx;
}
.record-modal-list{
	display: flex;
	justify-content: space-between;
	padding:20upx 30upx;
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
</style>
