<template>
	<view class="question-diamond-top">
		<view>
			<text>{{dataName}}</text>
		</view>
		<view class="record-detail-choose">
			<block v-for="(done,dIndex) in buttonOption" :key='dIndex'>
				<view class="detail-choose-item" :data-choose-index="dIndex" :data-index="index" @click="changeChoose" :style="{width: 100/doneArray.length+'%'}">
					<view class="mission-choose-item" :class="dIndex !=chooseIndex?'choose-item-word':'tab-color-'+dIndex">
						{{done.name}}
					</view>
				</view>
				<block v-if="(dIndex+1)< doneArray.length">
					<view class="choose-item-hr"></view>
				</block>
			</block>
		</view>
		<block v-for="(input,inputIndex) in inputOption" :key="inputIndex">
			<view class="record-detail-input">
				<view class="detail-input-text">
					<text>{{input.name}}</text>
				</view>
				<view class="detail-input">
					<input type="text"/>
				</view>
			</view>
		</block>
	</view>
</template>

<script>
	import helper from '../../common/helper.js'
	export default{
		props:{
			type:{
				type: Number,
				default: -1
			},
			questionArr:{
				type:Array,
				default:() => []
			},
			chooseIndex:{
				type: Number,
				default: -1
			},
			index:{
				type: Number,
				default: -1
			},
			buttonOption:{
				type:Array,
				default:() => []
			},
			inputOption:{
				type:Array,
				default:() => []
			},
			dataName:{
				type: String,
				default: ""
			},
			isBottom:{
				type: Boolean,
				default: false
			}
		},
		data(){
			return{
				doneArray:["是","否","不适用"],
			}
		},
		methods:{
			changeChoose(e){
				let index = this.index;
				let type = this.type;
				let chooseIndex = e.currentTarget.dataset.chooseIndex;
				this.chooseIndex = chooseIndex;
				if(type ==1){
					helper.questionData.esayQuestion[index].optionIndex
					=chooseIndex;
				}else{
					helper.questionData.hardQuestion[index].optionIndex
					=chooseIndex;
				}
				this.$emit("diamondTochild",this.type);
			},
		}
	}
</script>

<style>
	.detail-input{
		border:2upx solid #cacaca;
		text-align: right;
	}
	.record-detail-input{
		display: flex;
		justify-content: space-between;
		margin-top: 20upx;
	}
	.choose-item-hr{
		height: auto;
		width: 2upx;
		background: #f2f2f2;
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
	.choose-item-word{
		color: #dedede;
	}
	.mission-choose-item{
		padding:15upx 40upx;
		border-radius:35upx;
		font-size:30upx;
		font-weight: bold;
	}
	.detail-choose-item{
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.record-detail-choose{
		display: flex;
		justify-content: space-around;
		padding-top: 20upx;
		border-bottom: 2upx solid #DEDEDE;
	}
	.question-diamond-top{
		font-size: 30upx;
		padding:20upx 30upx;
		border-bottom: 30upx solid #DEDEDE;
	}	
</style>
