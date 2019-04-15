<template>
	<view class="record-main">
		<view class="record-top">
			<view class="record-top-one">
				<text class="record-top-font">审</text>
				<text>审核记录</text>
			</view>
			<view class="record-top-two">
				<text>您共完成了9个审核</text>
			</view>
		</view>
		<!--间距-->
		<view class="record-div">
			
		</view>
		<block v-for="(item,index) in items" :key='index'>
			<view class="touch-item" :class="item.isTouchMove ? 'touch-move-active' : ''" @touchstart="touchstart" 
			@touchmove="touchmove" :data-index='index'>
				<view class="content">
					<view class="content-div">
						<view>
							<text>LPA_PQ</text>
							<text class="content-tab">暂存</text>
						</view>
						<view>
							<text class="record-date-font">一个月前</text>
						</view>
					</view>
				</view>
				<view class="del">
					<view @click.stop="gotoRecordDetail" class="first-option">不符合项</view>
					<view @click.stop="del" :data-index="index" class="seccond-option">删除</view>
				</view>
			</view>
		</block>
	</view>
</template>

<script>
	export default {
		data(){
			return {
				items:[
					{
					isTouchMove:false
					},
					{
					isTouchMove:false
					},
					{
					isTouchMove:false
					},
					{
					isTouchMove:false
					},
				]
			}
		},
		methods:{
			 //手指触摸动作开始 记录起点X坐标
		  touchstart: function (e) {
			//开始触摸时 重置所有删除
			this.items.forEach(function (v, i) {
			  if (v.isTouchMove)//只操作为true的
				v.isTouchMove = false;
			})
			this.startX = e.mp.changedTouches[0].clientX;
			this.startY = e.mp.changedTouches[0].clientY;
		  },
		  //滑动事件处理
		  touchmove: function (e) {
			var that = this;
			  let index = e.currentTarget.dataset.index;//当前索引
			  let startX = that.startX;//开始X坐标
			  let startY = that.startY;//开始Y坐标
			  let touchMoveX = e.mp.changedTouches[0].clientX;//滑动变化坐标
			  let touchMoveY = e.mp.changedTouches[0].clientY;//滑动变化坐标
			  //获取滑动角度
			  let angle = that.angle({ X: startX, Y: startY }, { X: touchMoveX, Y: touchMoveY });
			that.items.forEach(function (v, i) {
			  v.isTouchMove = false
			  //滑动超过30度角 return
			  if (Math.abs(angle) > 30) return;
			  if (i == index) {
				if (touchMoveX > startX) //右滑
				  v.isTouchMove = false
				else //左滑
				  v.isTouchMove = true
			  }
			})
		  },
		  /**
		   * 计算滑动角度
		   * @param {Object} start 起点坐标
		   * @param {Object} end 终点坐标
		   */
		  angle: function (start, end) {
			var _X = end.X - start.X,
			  _Y = end.Y - start.Y
			//返回角度 /Math.atan()返回数字的反正切值
			return 360 * Math.atan(_Y / _X) / (2 * Math.PI);
		  },
		  //删除事件
		  del: function (e) {
			this.items.splice(e.currentTarget.dataset.index, 1);
		  },
		  gotoRecordDetail:function(e){
			  uni.navigateTo({
			  	url: '../record-detail/record-detail'
			  })
		  }
		}
	}
</script>

<style>
	.record-main{
		width: 100%;
	}
	.record-top{
		background:rgb(73,90,128);
		color:rgb(255,255,255);
		font-weight:600;
		padding:50upx;
	}
	.record-top-one{
		font-size: 35upx;
		margin-bottom: 30upx;
	}
	.record-top-two{
		font-size: 40upx;
	}
	.record-top-font{
		border-radius:50%;
		background:rgb(255,255,255);
		color:rgb(73,90,128);
		padding:0upx 8upx;
		margin-right:10upx;
		font-size:26upx;
		font-weight:100upx;
	}
	.record-div{
		height: 30upx;
		background:rgb(241,241,241);
	}
	.content {
	  width: 100%;
	  -webkit-transition: all 0.4s;
	  transition: all 0.4s;
	  -webkit-transform: translateX(280upx);
	  transform: translateX(280upx);
	  margin-left: -280upx;
	  background: rgb(255,255,255);
	}
	.content-div{
		display: flex;
		justify-content: space-between;
		padding:20rpx 0rpx;
	}
	.touch-item {
	  font-size: 28upx;
	  display: flex;
	  justify-content: space-between;
	  width: 100%;
	  overflow: hidden;
	  border-bottom: 2upx solid rgb(241,241,241);
	}
	.touch-move-active .content,
	.touch-move-active .del {
	  -webkit-transform: translateX(0);
	  transform: translateX(0);
	}
	.del {
	  width: 280upx;
	  display: flex;
	  color: #fff;
	  -webkit-transform: translateX(280upx);
	  transform: translateX(280upx);
	  -webkit-transition: all 0.4s;
	  transition: all 0.4s;
	}
	.del .first-option{
		background: #C8C7CC;
		width: 50%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.del .seccond-option{
		background: #FF0000;
		width: 50%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.content-tab{
		background:red;
		border-radius:25rpx;
		padding:0rpx 10rpx;
		color:rgb(255,255,255);
		margin-left:30rpx;
	}
	.record-date-font{
		font-size: 26upx;
		color: #C8C7CC;
	}
</style>
