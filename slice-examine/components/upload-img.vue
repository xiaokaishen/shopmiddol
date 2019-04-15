<template>
	<view class="choose-img-main">
		<view class="image-choose">
			<block v-for="(item,index) in imgArray" :key="index">
				
				<view class="choose-img-top">
					<view>
						<image class="upload-img" :src="item"/>
						<text class="close-img" :data-index="index" @click="closeImg">X</text>
					</view>
				</view>
			</block>
			<view v-if="count >0">
				<image src="../../static/img/camera.png" @click='toshow' class="image-camera"/>
			</view>
		</view>
		<view v-if="videoSrc">
			<view>
				<video class="img-video" controls :src="videoSrc"></video>
			</view>
			<view>
				<uni-tag @click="clearVideo" text="删除视频" :circle="true" type="primary"></uni-tag>
			</view>
		</view>
			<!-- <text class="icon-cameraadd" ></text>  -->
			<!-- <image class="upload-img" src="../../static/img/plus.png"/> -->
		<lvv-popup position="bottom" 
		:imgCount="imgArray.length" :imgMaxCount="maxCount" 
		:videoCount="videoSrc.length" :videoMaxCount="videoMaxCount"
		ref="lvvpopref">
			<view class="img-popup">
				<view @click="chooseImg" data-type="camera">
					<text>拍摄照片（{{imgCount}}/{{imgMaxCount}}）</text>
				</view>
				<view @click="chooseVideo" data-type="camera">
					<text>拍摄视频（{{videoCount}}/{{videoMaxCount}}）</text>
				</view>
				<view @click="chooseImg" data-type="album">
					<text>从手机相册选择照片（{{imgCount}}/{{imgMaxCount}}）</text>
				</view>
				<view @click="chooseVideo" data-type="album">
					<text>从手机相册选择视频（{{videoCount}}/{{videoMaxCount}}）</text>
				</view>
			</view>
		</lvv-popup>
	</view>
</template>

<script>
	import lvvPopup from './lvv-popup/lvv-popup.vue'
	export default {
		props:{
		},
		components:{
			lvvPopup
		},
		data() {
			return {
				videoMaxCount:1,
				maxCount: 9,
				count: 9,
				videoSrc:'',
				imgArray:[],
				imgSrc:''
			}
		},
		methods: {
			// 显示modal弹出框
			toshow(){
				this.$refs.lvvpopref.show();
			},
			// 关闭modal弹出框
			toclose(){
				this.$refs.lvvpopref.close();
			},
			chooseImg:function(e){
				var type = e.currentTarget.dataset.type;
				var _that =this;
				var count = _that.count;
				uni.chooseImage({
					count: count,
					sourceType:[type],
					success:function(res){
						for(let i in res.tempFilePaths){
							_that.imgArray.push(res.tempFilePaths[i]);
						}
						_that.count = count - res.tempFilePaths.length;
						_that.toclose();
					}
				})
			},
			closeImg:function(e){
				let index = e.currentTarget.dataset.index;
				this.imgArray.splice(index,1);
				this.count = this.count +1;
			},
			chooseVideo:function(e){
				var type = e.currentTarget.dataset.type;
				var _that =this;
				uni.chooseVideo({
					count:_that.videoMaxCount,
					sourceType:[type],
					success: function (res) {
						_that.videoSrc = res.tempFilePath;
						_that.toclose();
					}
				})
			},
			clearVideo:function(e){
				this.videoSrc = ""
			}
		}
	}
</script>

<style>
	.image-camera{
		width: 74upx;
		height: 63upx;
	}
	.img-video{
		width: 100%;
	}
	.image-choose{
		display: flex;
		align-items: center;
		flex-wrap: wrap;
	}
	.choose-img-main{
		width: 100%;
	}
	.img-popup{
		width: 100%;
		height: 375upx;
		background: #FFFFFF;
		position: absolute;
		bottom:0;
		z-index:10000;
	}
	.img-popup >view{
		height: 25%;
		display: flex;
		justify-content: center;
		align-items: center;
		font-size: 30upx;
		border-bottom:1rpx solid rgb(241,241,241);
	}
	.upload-img{
		position:absolute;
		width: 150upx;
		height: 150upx;
	}
	.close-img{
		position:absolute;
		font-size:20upx;
		background:black;
		border-radius:50%;
		width:30upx;
		height:30upx;
		text-align:center;
		right:-5upx;
		top:-5upx;
		color:#ffffff;
	}
	.choose-img-top{
		position:relative;
		width:150upx;
		height:150upx;
		margin: 30upx;
	}
</style>
