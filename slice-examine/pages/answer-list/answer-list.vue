<template>
	<view class="record-detail-main">
		<view id="answer-list-top">
			<view class="answer-list-title">
				<block v-for="(item,index) in tabList" :key='index'>
					<view class="answer-list-item" :class="index == current ?'item-active':''">
						<text>{{item}}</text>
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
					<scroll-view scroll-y="true" :style="{height:windowHeight}">
						<block v-for="(item,index) in list" :key='index'>
							<view>
								<view class="record-detail-list">
									<view class="detail-list-left">
										<view class="list-left-one">
											<view class="record-detail-heard">
												<image src="../../static/img/heard-img.jpg"></image>
											</view>
											<view class="detail-heard-font">
												<text>测试1</text>
											</view>
										</view>
										<view class="list-left-two">
											<view class="detail-list-manager">
												<text>管理员</text>
											</view>
											<view class="detail-list-date">
												<text>三周前</text>
											</view>
										</view>
									</view>
									<view class="detail-list-left">
										<view>
											<text class="list-left-tap">open</text>
										</view>
									</view>
								</view>
								<view @click="closeModal" class="record-detail-personal">
									<image src="../../static/img/user.png"/>
									<text>责任人</text>
								</view>
							</view>
							<!--间距-->
							<view class="check-div">
								
							</view>
						</block>
					</scroll-view>
				</swiper-item>
			</block>
		</swiper>
		<neil-modal 
		    :show="show" 
		    @close="closeModal" 
		    title="指定责任人" 
			:show-cancel="false"
		    confirm-color="rgb(255,255,255)"
			confirm-text="rgb(255,255,255)"
			>
			<view class="record-modal-list">
				<view>
					<text>问题点</text>
				</view>
				<view>
					<text>测试1</text>
				</view>
			</view>
			<view class="record-modal-list">
				<view>
					<text>紧急程度</text>
				</view>
				<view>
					<picker mode="selector" :range="dangerArray" @change="dangerChange">
						<view>{{dangerArray[dangerIndex]}}</view>
					</picker>
				</view>
			</view>
			<view class="record-modal-list">
				<view>
					<text>责任人</text>
				</view>
				<view>
					<picker mode="selector" :range="managerArray" @change="mangerChange">
						<view>{{managerArray[managerIndex]}}</view>
					</picker>
				</view>
			</view>
			<view class="record-modal-list">
				<view>
					<text>截至日期</text>
				</view>
				<view>
					<picker mode="date" :value="date" :start="startDate" :end="endDate" @change="bindDateChange">
                        <view class="uni-input">{{date}}</view>
                    </picker>
				</view>
			</view>
			<view class="detail-modal-submit">
				确定
			</view>
		</neil-modal>
	</view>
</template>

<script>
	import neilModal from '@/components/neil-modal/neil-modal.vue';
	export default {
		components: {neilModal},
		data(){
			const currentDate = this.getDate({
				format: true
			})
			return {
				current:0,
				tabList:['我发现的','我负责的'],
				show:false,
				list:[1,2,3,4,5],
				dangerArray:['一级','二级','三级'],
				dangerIndex:0,
				managerArray:['责任人1','责任人2','责任人3'],
				managerIndex:0,
				date: currentDate
			}
		},
		computed:{
			windowHeight(){
				var height = 0;
				uni.getSystemInfo({
					success:function (res) {
						height = res.windowHeight;
					}
				})
				return (height-75)+'px';
			}
		},
		methods:{
			changSwiper:function(e){
				this.current = e.detail.current
			},
			closeModal:function (e) {
				this.show = !this.show;
			},
			dangerChange:function(e){
				this.dangerIndex = e.target.value
			},
			mangerChange:function(e){
				this.managerIndex = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();

				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			bindDateChange: function(e) {
				this.date = e.target.value
			},
		}
	}
</script>

<style>
.answer-list-title{
	display: flex;
	justify-content: space-around;
	background:rgb(255,255,255);
	font-size:30upx;
	height:120upx;
	align-items:center;
}
.item-active{
	color:rgb(38,192,248);
	border-bottom:2rpx solid;
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
	justify-content:space-between;
	background:rgb(255,255,255);
	padding:30upx;
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
	background:rgb(255,108,2);
	padding:5upx;
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
