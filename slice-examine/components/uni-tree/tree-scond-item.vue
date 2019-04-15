<template>
	<view class="tree-main">
		<view class="tree-second-top" :data-level="arrObj.level">
			<view class="second-level-icon">
				<view class="tree-level-line"></view>
			</view>
			<view class="second-level-text">
				<view class="second-next-level">
					<view :class="show2?'second-right-line':''" class="second-next-line"></view>
				</view>
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
						<view class="second-icon-plus" @click.stop="addThreeLevel">
							<uni-icon type="plus" size="20"></uni-icon>
						</view>
						<view class="second-icon-minus" :data-index="index" @click.stop="deteleTwoLevel">
							<uni-icon type="minus" size="20"></uni-icon>
						</view>
					</view>
				</view>
			</view>
		</view>
		<view>
			<tree-third v-for="(chi,chiIndex) in arrObj.children" 
			:key="chiIndex" v-on:listenToTchild="deleteThirdChild" 
			:arrObj="chi" :index="chiIndex" :firstIndex="lastIndex" :secondIndex="index"/>
		</view>
	</view>
</template>

<script>
	import helper from '../../common/helper.js'
	import treeThird from './tree-third-item.vue'
	export default {
		components:{
			treeThird
		},
		props:{
			arrObj:{
				type:Array,
				default:() => []
			},
			lastIndex:{
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
					that.show1 =!that.show1
				}else if(level ==2&&that.arrObj.children.length>0){
					that.show2 =!that.show2
				}
			},
			addThreeLevel(e){
				var that = this;
				let arrObj = that.arrObj;
				let level = arrObj.level;
				let lastIndex = that.lastIndex;
				let index = that.index;
				let data ={
					name: "第三级",
					level: level+1,
					children:[]
				}
				arrObj.children.push(data);
				this.arrObj = arrObj;
				console.log("arr[lastIndex]:",helper.questionData.arr[lastIndex]);
				helper.questionData.arr[lastIndex].children[index] = arrObj;
				console.log("children[index]:",helper.questionData.arr[lastIndex].children[index])
				this.show2 = false;
				this.show2 = true;
			},
			deteleTwoLevel(e){
				var that = this;
				let lastIndex = that.lastIndex;
				let index = that.index;
				helper.questionData.arr[lastIndex].children.splice(index,1);
				that.$emit("listenTochild")
			},
			deleteThirdChild(){
				this.show2 = false;
				if(this.arrObj.children.length>0){
					this.show2 = true;
				}
			},
		}
	}
</script>

<style>

</style>
