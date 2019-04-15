<template>
	<view style="width: 100%;background: rgb(255,255,255);">
		<!--页面顶部-->
		<view class="main-top">
			<view>
				<text class="main-top-font">最新计划</text>
			</view>
			<!--#ifndef H5-->
			<view @click="getCode" class="top-image-margin">
				<text class='icon-scan' style='font-size: 60upx;'></text>
				<!-- <uni-icon type="scan" size="30"></uni-icon> -->
				<!-- <image class="main-top-image" src="../../static/img/camera.png"/> -->
			</view>
			<!--#endif-->
		</view>
		<!--列表-->
		<scroll-view scroll-y="true" class="main-scroll">
			<block v-for="(item,index) in list" :key="index">			
				<view @click="gotoDetail" :data-id='item.id' class="main-list">
					<view class="main-list-heard">
						<image class="heard-image" src="../../static/img/heard-img.jpg"/>
					</view>
					<view>
						<view class="list-font-one">
							<text>分层审核表</text>
						</view>
						<view class="list-font-two">
							<text>添加1个分层审核表</text>
						</view>
						<view class="list-font-three">
							<view class="list-type-one">
								<text>默认分类</text>
							</view>
							<view class="list-type-two">
								<text>到期</text>
							</view>
							<view class="list-type-three">
								<text>6天后</text>
							</view>
							<view class="list-type-four">
								<text>开始</text>
							</view>
						</view>
					</view>
				</view>
			</block>
		</scroll-view>
		<neil-modal 
		    :show="show" 
		    @close="closeModal" 
		    title="标题" 
		    :show-cancel="false"
			:content="message"
		    @confirm="closeModal">
		</neil-modal>
	</view>
</template>

<script>
    import {
        mapState
    } from 'vuex'
	import neilModal from '@/components/neil-modal/neil-modal.vue';
    export default {
		data (){
			return {
				message:'',
				show:false,
				list:[]
			}
		},
		components: {neilModal},
        computed: mapState(['forcedLogin', 'hasLogin', 'userName']),
        onLoad() {
			let list = [];
			for(let i =0;i<20;i++){
				list.push(i);
			}
			this.list = list;
        },
		methods: {
			closeModal(){
				this.show = !this.show
			},
			//检查是否登录
			checkLogin() {
				if (!this.hasLogin) {
				    uni.showModal({
				        title: '未登录',
				        content: '您未登录，需要登录后才能继续',
				        /**
				         * 如果需要强制登录，不显示取消按钮
				         */
				        showCancel: !this.forcedLogin,
				        success: (res) => {
				            if (res.confirm) {
								/**
								 * 如果需要强制登录，使用reLaunch方式
								 */
				                if (this.forcedLogin) {
				                    uni.reLaunch({
				                        url: '../login/login'
				                    });
				                } else {
				                    uni.navigateTo({
				                        url: '../login/login'
				                    });
				                }
				            }
				        }
				    });
				}
			},
			gotoDetail:function(e){
				let id = e.currentTarget.dataset.id
				uni.navigateTo({
					// url: '../check-detail/check-detail'
					url: '../mission-list/mission-list?id='+id
				})
			},
			//#ifndef H5
			// 允许从相机和相册扫码
			getCode:function(){
				var _that = this;
				uni.scanCode({
					success: function (res) {
						console.log('扫码返回的内容：',res)
						console.log('条码类型：' + res.scanType);
						console.log('条码内容：' + res.result);
						_that.message = '条码类型：' + res.scanType + ',' + '条码内容：' + res.result;
						_that.closeModal();
					}
				});
			}
			//#endif
		},
    }
</script>
	
<style>
	.main-top{
		/* width: 100%; */
		display:flex;
		justify-content: space-between;
		padding: 40upx;
		border-bottom:1upx solid #C8C7CC
	}
	.main-top-font{
		font-size:40upx;
		color:rgb(109,109,109);
	}
	.main-top-image{
		width: 80upx;
		height: 80upx;
	}
	.top-image-margin{
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.main-list{
		display: flex;
		padding:30upx 0upx;
		border-bottom:0.5upx solid #C8C7CC;
	}
	.heard-image{
		width: 120upx;
		height: 120upx;
	}
	.main-list-heard{
		margin:0 30upx;
	}
	.list-font-one{
		font-size: 30upx;
	}
	.list-font-two{
		font-size: 26upx;
		color: rgb(155,155,155);
	}
	.list-font-three{
		display: flex;
		font-size: 26upx;
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
		margin-left: 20upx;
	}
	.main-scroll{
		height: 1000upx;
	}
</style>
