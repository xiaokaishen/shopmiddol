<template>
	<view class="swiper-item">
		<view class="tree-main">
			<view class="tree-first-top" @click="changeShow" :data-level="arrObj.level">
				<view class="tree-level-icon">
					<view v-if="index==0" class="tree-level-circle circle-top"></view>
					<view class="tree-level-line"></view>
					<view v-if="index==(length-1)" class="tree-level-circle circle-bottom"></view>
				</view>
				<view class="tree-level-text">
					<view class="second-input-line">
						<view>
							<text>{{arrObj.name}}</text>
						</view>
						<view class="input-line-input">
							<input />
						</view>
					</view>
					<view @click.stop="addTwoLevel">
						<uni-icon type="plus" size="20"></uni-icon>
					</view>
				</view>
			</view>
			<view>
				<tree-scond v-for="(child,childIndex) in arrObj.children" 
				:key="childIndex" v-on:listenTochild="deleteChild" :arrObj="child" 
				:lastIndex="index" :index="childIndex"></tree-scond>
			</view>
			<!-- <block v-for="(child,childIndex) in arrObj.children" :key="childIndex">
				<view class="tree-second-top" v-show="show1" @click="changeShow" :data-level="child.level">
					<view class="second-level-icon">
						<view class="tree-level-line"></view>
					</view>
					<view class="second-level-text">
						<view class="second-next-level">
							<view :class="show2?'second-right-line':''" class="second-next-line"></view>
						</view>
						<view class="tree-level-text">
							<text>{{child.name}}</text>
						</view>
					</view>
				</view>
				<block v-for="(chi,chiIndex) in child.children" :key="chiIndex">
					<view class="tree-second-top" v-show="show2&&show1" @click="changeShow" :data-level="child.level">
						<view class="second-level-icon">
							<view class="tree-level-line"></view>
						</view>
						<view class="third-level-text">
							<view class="third-level-line"></view>
							<view class="tree-level-text">
								<text>{{chi.name}}</text>
							</view>
						</view>
					</view>
				</block>
			</block> -->
		</view>
	</view>
</template>

<script>
	import helper from '../../common/helper.js'
	import treeScond from './tree-scond-item.vue'
	export default {
		components:{
			treeScond
		},
		props:{
			arrObj:{
				type:Array,
				default:() => []
			},
			index:{
				type: Number,
				value: 0
			},
			length:{
				type: Number,
				value: 0
			}
		},
		data() {
			return {
				show1:false,
				show2:false
			};
		},
		methods:{
			deleteChild(){
				this.show1 = false;
				this.show1 = true;
			},
			addTwoLevel(e){
				var that = this;
				let arrObj = that.arrObj;
				let level = arrObj.level;
				let index = that.index;
				let data ={
					name: "",
					level: level+1,
					children:[]
				}
				arrObj.children.push(data);
				this.arrObj = arrObj;
				helper.questionData.arr[index] = arrObj;
				this.show1 = false;
				this.show1 = true;
			},
			changeShow(e){
				var that = this;
				let level = e.currentTarget.dataset.level;
				if(level ==1){
					this.show1 =!this.show1
				}else if(level ==2){
					this.show2 =!this.show2
				}
			}
		}
	}
</script>

<style>
	.second-icon-minus{
		margin-left: 20upx;
	}
	.second-icon-top{
		display: flex;
	}
	.second-input-line{
		display: flex;
		align-items: center;
	}
	.input-line-text{
		border:2upx solid #333333;
		border-radius:50%;
		width:35upx;
		height:35upx;
		text-align:center;
	}
	.input-line-input{
		border: 2upx solid #333333;
		margin-left: 30upx;
	}
	.third-level-text{
		display: flex;
		width: 100%;
	}
	.third-level-line{
		margin-left: 20upx;
		height: 50%;
		width: 20upx;
		border-left: 4upx solid #ED0000;
		border-bottom: 4upx solid #ED0000;
	}
	.second-level-line{
		width: 20upx;
		height: 50upx;
		border-top: #509c82;
	}
	.second-level-text{
		display: flex;
		align-items: flex-end;
		width: 100%;
	}
	.tree-level-text{
		padding: 20upx;
		display: flex;
		justify-content: space-between;
		align-items: center;
		width: 100%;
	}
	.second-right-line{
		border-right:4upx solid #ED0000;
	}
	.second-next-line{
		height: 100%;
		width: 20upx;
		border-top:4upx solid #509c82;
	}
	.second-next-level{
		display: flex;
		justify-content: flex-end;
		height: 50%;
	}
	.second-level-icon{
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 10upx;
	}
	.tree-second-top{
		background: #CACACA;
		padding: 0upx 30upx;
		border-bottom: 2upx solid #FFFFFF;
		display: flex;
	}
	.circle-top{
		margin-top: 20upx;
	}
	.circle-bottom{
		margin-bottom: 20upx;
	}
	.tree-level-line{
		width: 2upx;
		height: 100%;
		background: #509c82;
	}
	.tree-level-circle{
		width: 100%;
		height: 10upx;
		background: #509c82;
		border-radius: 50%;
	}
	.tree-level-icon{
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 10upx;
	}
	.tree-first-top{
		background: #ffffff;
		padding: 0upx 30upx;
		border-bottom: 2upx solid #CACACA;
		display: flex;
	}
	.tree-two-top{
		background: #acafb2;
	}
	.tree-main{
		width: 100%;
		font-size: 30upx;
	}
</style>
