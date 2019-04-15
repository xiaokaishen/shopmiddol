<template>
    <!-- <view class="content">
        <view class="btn-row">
            <button v-if="!hasLogin" type="primary" class="primary" @tap="bindLogin">登录</button>
            <button v-if="hasLogin" type="default" @tap="bindLogout">退出登录</button>
        </view>
    </view> -->
	<view class="user-main">
		<view class="user-top">
			<view class="user-top-left">
				<view class="user-heard-img">
					<image src="../../static/img/heard-img.jpg"></image>
				</view>
				<view>
					<text>管理员</text>
				</view>
			</view>
			<view class="user-top-right">
				<uni-icon type="forward" size="20"></uni-icon>
			</view>
		</view>
		<uni-list>
			<uni-list-item title='审核记录' @click="gotoRecord" thumb='../../static/img/shape.png'></uni-list-item>
			<uni-list-item title='问题清单' @click="gotoAnswetList" thumb='../../static/img/shape.png'></uni-list-item>
			<uni-list-item title='图片计划' @click="gotoCheckPlan" thumb='../../static/img/shape.png'></uni-list-item>
		</uni-list>
		<!--间距-->
		<view class="user-div">
			
		</view>
		<uni-list>
			<uni-list-item title='联系我们' thumb='../../static/img/shape.png'></uni-list-item>
			<uni-list-item title='建议反馈' thumb='../../static/img/shape.png'></uni-list-item>
		</uni-list>
		<!--间距-->
		<view class="user-div">
			
		</view>
		<uni-list>
			<uni-list-item title='关于我们' thumb='../../static/img/shape.png'></uni-list-item>
		</uni-list>
	</view>
</template>

<script>
    import {
        mapState,
        mapMutations
    } from 'vuex'

    export default {
        computed: {
            ...mapState(['hasLogin', 'forcedLogin'])
        },
        methods: {
            ...mapMutations(['logout']),
            bindLogin() {
                uni.navigateTo({
                    url: '../login/login',
                });
            },
            bindLogout() {
                this.logout();
                /**
                 * 如果需要强制登录跳转回登录页面
                 */
                if (this.forcedLogin) {
                    uni.reLaunch({
                        url: '../login/login',
                    });
                }
            },
			gotoRecord:function(e){
				uni.navigateTo({
					url: '../check-record/check-record'
				})
			},
			gotoCheckPlan:function(e){
				uni.navigateTo({
					url: '../ckeck-plan/ckeck-plan'
				})
			},
			gotoAnswetList:function(e){
				uni.navigateTo({
					url: '../answer-list/answer-list'
				})
			},
			gotoQuestion:function(e){
				uni.navigateTo({
					url: '../check-question/check-question'
				})
			}
        }
    }
</script>

<style>
	.user-main{
		width: 100%;
		background: rgb(241,241,241);
	}
	.user-top{
		background: rgb(128,125,110);
		display: flex;
		align-items: center;
		justify-content: space-between;
		padding: 30upx;
		font-size:30upx;
		color: rgb(255,255,255);
	}
	.user-heard-img{
		margin-right: 30upx;
	}
	.user-heard-img >image{
		width: 120upx;
		height: 120upx;
		border-radius: 50%;
	}
	.user-top-left{
		display: flex;
		align-items: center;
		margin-left: 20upx;
	}
	.user-div{
		height: 30upx;
		background:rgb(241,241,241);
	}
	.user-option-list{
		display: flex;
		justify-content: space-between;
		padding: 30upx;
		font-size:30upx;
		background: rgb(255,255,255);
		border-bottom: 1upx solid rgb(241,241,241);
	}
	.user-option-left{
		display: flex;
		align-items: center;
	}
	.user-option-image{
		margin-right: 30upx;
	}
	.user-option-image >image{
		width: 35upx;
		height: 50upx;
	}
	.uni-list-cell__content-title{
		font-size: 30upx;
	}
	.uni-list-cell__icon-img{
		width: 35upx;
		height: 50upx;
	}
</style>
