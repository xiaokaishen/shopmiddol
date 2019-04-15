<template>
	<view class="check-show-main">
		<swiper class="check-show-swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
            <block v-for="(item,index) in showArray" :key="index">
				<swiper-item>
					<view class="swiper-item uni-bg-red">
						<view class="check-show-title">告示标题</view>
						<view class="check-show-text"></view>
					</view>
				</swiper-item>
			</block>
        </swiper>
		<view class="check-submit-top">
			<view class="check-show-submit" @click="gotoCheckMain">
				<text>我已同意</text>
			</view>
		</view>
	</view>
</template>

<script>
	import api from '../../api/api.js';
	var app = new api();
	export default {
		data(){
			return {
				showArray:[1,2,3],
				background: ['color1', 'color2', 'color3'],
				indicatorDots: true,
				autoplay: true,
				interval: 2000,
				duration: 500
			}
		},
		onLoad() {
			this.testapi();
		},
		onShareAppMessage(res) {
		},
		methods: {
			testapi(){
				console.log("testapi")
				
				app.homePageBanner().then(res =>{
					console.log(res)
				})
			},
			gotoCheckMain(e){
// 				uni.switchTab({
// 					url: "../check-main/check-main"
// 				})
				
				uni.login({
				  provider: 'weixin',
				  success: function (logifile){///C:/Users/Admin/Documents/WeChat Files/lk18203584205/Files/user-info-new.vuenRes) {
					console.log(loginRes.code);
					console.log("======");
					app.login(loginRes.code).then(res =>{
						console.log(res)
					})

				  }
				});
				/* app.ss().then(res =>{
					console.log(res)
				}) */
				
				//分享文字
				/* uni.share({
					provider: "weixin",
					scene: "WXSceneSession",
					type: 1,
					success: function (res) {
						console.log("success:" + JSON.stringify(res));
						api.Sharetext().then(res=>{
							
						})
					},
					fail: function (err) {
						console.log("fail:" + JSON.stringify(err));
					}
				}); */
				
				//支付
				/* uni.requestPayment({
					provider: 'wxpay',
					timeStamp: String(Date.now()),
					nonceStr: 'A1B2C3D4E5',
					package: 'prepay_id=wx20180101abcdefg',
					signType: 'MD5',
					paySign: '',
					success: function (res) {
						console.log('success:' + JSON.stringify(res));
					},
					fail: function (err) {
						console.log('fail:' + JSON.stringify(err));
					}
				}); */
				
			},
			changeIndicatorDots(e) {
				this.indicatorDots = !this.indicatorDots
			},
			changeAutoplay(e) {
				this.autoplay = !this.autoplay
			},
			intervalChange(e) {
				this.interval = e.target.value
			},
			durationChange(e) {
				this.duration = e.target.value
			}
		}
	}
</script>

<style>
	.check-show-title{
		font-size: 35upx;
		display: flex;
		align-items: center;
		justify-content: center;
		font-weight: bold;
		margin-top: 30upx;
	}
	.check-show-text{
		width: 80%;
		height: 580upx;
		border:2upx solid #cacaca;
		margin:50upx auto;
	}
	.check-show-main{
		width: 100%;
	}
	.check-show-swiper{
		height: 90%;
	}
	.check-submit-top{
		height: 10%;
		display: flex;
		justify-content: center;
	}
	.check-show-submit{
		background:rgb(73,90,128);
		display:flex;
		justify-content:center;
		align-items:center;
		border-radius:15rpx;
		color:rgb(255,255,255);
		font-size:32rpx;
		height:80rpx;
		width:360rpx;
	}
</style>
