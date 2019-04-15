<template>
	<view class="tree-second-top">
		<view class="second-level-icon">
			<view class="tree-level-line"></view>
		</view>
		<view class="third-level-text">
			<view class="third-level-line"></view>
			<view class="tree-level-text">
				<view class="second-input-line">
					<view class="input-line-text">
						<text>{{index+1}}</text>
					</view>
					<view class="input-line-input">
						<input />
					</view>
				</view>
				<view  class="second-icon-top">
					<view class="second-icon-minus" :data-index="index" @click.stop="deteleThirdLevel">
						<uni-icon type="minus" size="20"></uni-icon>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import helper from '../../common/helper.js'
	export default {
		
		props:{
			arrObj:{
				type:Array,
				default:() => []
			},
			firstIndex:{
				type: Number,
				value: 0
			},
			secondIndex:{
				type: Number,
				value: 0
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
			changeShow(e){
				var that = this;
				let level = e.currentTarget.dataset.level;
				if(level ==1){
					this.show1 =!this.show1
				}else if(level ==2){
					this.show2 =!this.show2
				}
			},
			deteleThirdLevel(e){
				var that = this;
				let firstIndex = that.firstIndex;
				let secondIndex = that.secondIndex;
				let index = that.index;
				console.log("helper.questionData.arr:",helper.questionData.arr[firstIndex])
				helper.questionData.arr[firstIndex].children[secondIndex].children.splice(index,1);
				that.$emit("listenToTchild")
				// this.show1 = true;
			},
			
		}
	}
</script>

<style>
</style>
