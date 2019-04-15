<template>
		<view class="check-main">
			<view class="mission-list-top">
				<block v-if="changeObj.doneIndex ==1">
					<view class="mission-left-hr"
					:class="'nok-color-'+changeObj.updateIndex"></view>
				</block>
				<block v-else>
					<view class="mission-left-hr"
					:class="'tab-color-'+changeObj.doneIndex"></view>
				</block>
				<view class="mission-list-title">
					<view class="mission-list-name">
						<view class="list-name-left">
							<text>{{changeObj.name}}</text>
						</view>
						<view class="list-name-right">
							<text class="icon-questionfill"  @click='openHelp' style='color:#178ed7;font-size: 48upx;'></text>
							<!-- <uni-icon type='help' color="#178ed7" @click='openHelp' size='24'>
							</uni-icon> -->
						</view>
					</view>
					<view class="record-detail-choose">
						<block v-for="(done,dIndex) in changeObj.doneArray" :key='dIndex'>
							<view class="detail-choose-item" :data-dindex='dIndex' :data-index='index' :data-id='changeObj.id' @click="doneChange"
							:style="{width: 100/changeObj.doneArray.length+'%'}">
								<view class="mission-choose-item" :class="changeObj.doneIndex !=dIndex?'choose-item-word':'tab-color-'+changeObj.doneIndex">
									{{done}}
								</view>
							</view>
							<block v-if="(dIndex+1)< changeObj.doneArray.length">	
								<view class="choose-item-hr"></view>
							</block>
						</block>
					</view>
				</view>
			</view>
			<!--间距-->
			<view class="check-div">
				
			</view>
		<block v-if="changeObj.doneIndex ==1">
			<view class="check-image-top check-background">
				<view class="check-image-title">分类</view>
				<view class="check-type-list">
					<block v-for="(item,index) in typeList" :key="index">
						<view @click="changeType" :data-index="index" 
						:style="index!=typeIndex?{color:'#cacaca'}:{color:'#74bbe6'}">
							<view>
								<image :class="'type-img-'+item.name" 
								:src="index!=typeIndex?item.img:item.choose"></image>
							</view>
							<view class="type-text">
								{{item.text}}
							</view>
						</view>
					</block>
					<!-- <radio-group class="check-radio-group">
						<label v-for="(item,index) in typeList" :key="index" class="radio-list">
							<view class="check-option-right">
								<text>{{item}}</text>
							</view>
							<view class="check-option-left">
								<radio/>
							</view>
						</label>
					</radio-group> -->
				</view>
			</view>
			<view class="check-image-top check-background">
				<view class="check-image-title">审核发现</view>
				<view class="check-textarea-top">
					<block v-if="textShow">
						<textarea class="check-textarea" placeholder="请输入审核发现"></textarea>
					</block>
				</view>
			</view>
			<view class="record-modal-list" style="background:#ffffff;color:#787878;font-size:30rpx;">
				<view>
					<text>责任区域</text>
				</view>
				<view>
					<picker @change="changeRegin" mode = "multiSelector" :range="region">
						<view>{{region[0]}} - {{region[1]}} - {{region[2]}}</view>
					</picker>
				</view>
			</view>
			<view class="record-modal-list" style="background:#ffffff;color:#787878;font-size:30rpx;">
				<view>
					<text>责任产线</text>
				</view>
				<view>
					<picker @change="changeMake" :range="makeArray" mode = "selector">
						<view>{{makeArray[makeIndex]}}</view>
					</picker>
				</view>
			</view>
			<view class="record-modal-list" style="background:#ffffff;color:#787878;font-size:30rpx;">
				<view>
					<text>责任工位</text>
				</view>
				<view>
					<picker @change="changeNumber" :range="numberArray" mode = "selector">
						<view>{{numberArray[numberIndex]}}</view>
					</picker>
				</view>
			</view>
			<view class="record-modal-list" style="background:#ffffff;color:#787878;font-size:30rpx;">
				<view>
					<text>责任设备</text>
				</view>
				<view>
					<picker @change="changeFix" :range="fixArray" mode = "selector">
						<view>{{fixArray[fixIndex]}}</view>
					</picker>
				</view>
			</view>
			<view class="record-modal-list" style="background:#ffffff;color:#787878;font-size:30rpx;">
				<view>
					<text>责任人员</text>
				</view>
				<view>
					<picker @change="changePerson" :range="personArray" mode = "selector">
						<view>{{personArray[personIndex]}}</view>
					</picker>
				</view>
			</view>
			<view class="check-image-top check-background">
				<view class="check-image-title">标准做法</view>
				<view @click="changeTextShow">
					<upload-img></upload-img>
				</view>
				<!-- <sunsin-upimg :count='1' :autoup='false'></sunsin-upimg> -->
			</view>
			<view class="check-image-top check-background">
				<view class="check-image-title">图片证据</view>
				<view @click="changeTextShow">
					<upload-img></upload-img>
				</view>
				<!-- <sunsin-upimg :count='1' :autoup='false'></sunsin-upimg> -->
			</view>
			<view class="check-image-top check-background">
				<view class="check-image-title">录音</view>
				<view class="check-record">
					<view class="check-record-button" @touchstart='startRecord()' @touchend='endRecord()'>
						<image :src="micSrc" class="mic-img"/>
						<view class="check-mic-div" :style="micCss">
							<text>按住 说话</text>
						</view>
					</view>
					<block v-if="voicePath">
						<view @click='playVoice()' class="check-record-play">
							<view style="display: flex;align-items: center;">
								<faicon type='volume-up'></faicon>
								<text class="voice-seconds">{{seconds}}''</text>
							</view>
							<view @click.stop="clearVoice">
								<text class='icon-roundclosefill' style='font-size: 50upx;'></text>
								<!-- <uni-icon type='clear' size='25'></uni-icon> -->
							</view>
						</view>
					</block>
				</view>
				<!-- <sunsin-upimg :count='1' :autoup='false'></sunsin-upimg> -->
			</view>
			<view class="check-image-top check-background">
				<view class="check-image-title">备注</view>
				<view class="check-textarea-top">
					<block v-if="textShow">
						<textarea class="check-textarea" placeholder="请输入备注内容"></textarea>
					</block>
				</view>
			</view>
			<!--间距-->
			<view class="check-div">
				
			</view>
		</block>
		<view class="bottom-kongbai"></view>
			<view class="check-background check-bottom">
				<block v-if="changeObj.doneIndex ==1">
					<view class="bottom-menu-right">
						<block v-for="(item,index) in changeObj.updateArray" :key='index'>
							<view @click="openModal" :data-index="index">
								<view class="check-detail-tag" :style="index ==0?'background:#ffde00':index==1?'background:#ff9000':index==2?'background:#f46666':''">
									{{item}}
								</view>
								<!-- <uni-tag :text="item" :type="index ==0?'primary':index ==1?'success':'warning'" :circle="true"></uni-tag> -->
							</view>
						</block>
						<!-- <radio-group @change="closeModal">
								<label class="check-option" v-for="(item,index) in radioList" :key='index'>
									<view class="check-option-left">
										<radio :value="index"/>
									</view>
									<view class="check-option-right">
										<text>{{item}}</text>
									</view>
								</label>
						</radio-group> -->
					</view>
				</block>
			</view>
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
				<view class="detail-modal-submit" @click="modalSubmit">
					确定
				</view>
			</neil-modal>
			<neil-modal :show="helpShow" 
			    @close="openHelp" 
			    title="帮助" 
				:show-cancel="false">
			</neil-modal>
		</view>
</template>

<script>
	import uploadImg from '../../components/upload-img.vue'
	import helper from '../../common/helper.js';
	const recorderManager = uni.getRecorderManager();
	const innerAudioContext = uni.createInnerAudioContext();

	innerAudioContext.autoplay = true;
	export default {
		data(){
			const currentDate = this.getDate({
				format: true
			})
			return {
				textShow: true,
				personIndex:0,
				personArray:['人员1','人员2','人员3'],
				fixIndex:0,
				fixArray:['设备1','设备2','设备3'],
				numberIndex:0,
				numberArray:['工位1','工位2','工位3'],
				makeIndex:0,
				makeArray:['产线1','产线2','产线3'],
				region:['A','B','C'],
				micCss: 'background:#f7f7f7',
				micSrc: '../../static/img/mic-close.png',
				typeIndex:-1,
				tagFlag:true,
				updateIndex:-1,
				submitColor:'green',
				seconds:0,
				micType:'mic',
				typeList:[
					{
						name: 'person',
						text: '人',
						img: '../../static/img/person.png',
						choose: '../../static/img/person-after.png'
					},
					{
						name: 'machine',
						text: '机',
						img: '../../static/img/machine.png',
						choose: '../../static/img/machine-after.png'
					},
					{	
						name: 'material',
						text: '料',
						img: '../../static/img/material.png',
						choose: '../../static/img/material-after.png'
					},
					{
						name: 'function',
						text: '法',
						img: '../../static/img/function.png',
						choose: '../../static/img/function-after.png'
					},
					{
						name: 'ambient',
						text: '环',
						img: '../../static/img/ambient.png',
						choose: '../../static/img/ambient-after.png'
					},
					{
						name: 'test',
						text: '测',
						img: '../../static/img/test.png',
						choose: '../../static/img/test-after.png'
					}
					],
				helpShow:false,
				dangerArray:['一级','二级','三级'],
				dangerIndex:0,
				managerArray:['责任人1','责任人2','责任人3'],
				managerIndex:0,
				date: currentDate,
				show:false,
				radioList:['当即整改','限期整改','不确定上升问题解决',],
				changeObj:{},
				lastUpdate:-1,
				changeList:[],
				current:0,
				tabList:[],
				list:[],
				voicePath:''
			}
		},
		components:{
			uploadImg
		},
		computed:{
		},
		onLoad(option) {
			this.id = option.id;
			helper.mission.getLastUpdate(this,option.id);
			helper.mission.getLastPageData(option.id,this);
			 let self = this;
			recorderManager.onStop(function (res) {
				console.log('recorder stop' + JSON.stringify(res));
				var seconds = parseInt((res.duration % (1000 * 60)) / 1000);
				if(seconds ==0){
					seconds =1;
				}
				self.seconds = seconds;
				self.voicePath = res.tempFilePath;
			});
		},
		watch:{
		},
		methods:{
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
			changeTextShow(e){
				this.textShow = !this.textShow;
			},
			changePerson(e){
				this.personIndex = e.detail.value;
			},
			changeFix(e){
				this.fixIndex = e.detail.value;
			},
			changeNumber(e){
				this.numberIndex = e.detail.value;
			},
			changeMake(e){
				this.makeIndex = e.detail.value;
			},
// 			changeRegin(e){
// 				this.region = e.detail.value;
// 			},
			changeType(e){
				this.typeIndex = e.currentTarget.dataset.index;
			},
			submit(){
				let id = this.changeObj.id;
				this.getNextData(id);
			},
			modalSubmit(){
				var that = this;
				let id = that.changeObj.id;
				let index= that.updateIndex;
				helper.mission.list.forEach(function(v,i){
					if(v.id == that.changeObj.id){
						v.updateIndex = index;
					}
				})
				helper.mission.changeList.forEach(function(v,i){
					if(v.id == that.changeObj.id){
						v.updateIndex = index;
					}
				})
				that.closeModal();
				that.getNextData(id);
			},
			clearVoice(){
				this.voicePath =''
			},
			startRecord() {
				console.log('开始录音');
				this.micSrc = '../../static/img/mic-open.png';
				this.micCss = 'background:#74bbe6';
				this.tagFlag = false;
				recorderManager.start();
			},
			endRecord() {
				var that = this;
				console.log('录音结束');
				that.micSrc = '../../static/img/mic-close.png';
				that.micCss = 'background:#f7f7f7';
				that.tagFlag = true;
				setTimeout(function(){
					recorderManager.stop();
				},500)
			},
			playVoice() {
				console.log('播放录音');
				if (this.voicePath) {
					innerAudioContext.src = this.voicePath;
					innerAudioContext.play();
					console.log("innerAudioContext:",innerAudioContext)
				}
			},
			openHelp(){
				this.helpShow = !this.helpShow;
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
			openModal:function (e){
				var that = this;
				let index = e.currentTarget.dataset.index;
				if(index ==0){
					helper.mission.list.forEach(function(v,i){
						if(v.id == that.changeObj.id){
							v.updateIndex = index;
						}
					})
					helper.mission.changeList.forEach(function(v,i){
						if(v.id == that.changeObj.id){
							v.updateIndex = index;
						}
					})
					that.getNextData(that.changeObj.id);
				}else{
					that.updateIndex = index;
					that.show = !that.show;
				}
			},
			closeModal:function (e) {
				this.show = !this.show;
			},
			//切换changelist内容
			updateChangeList:function(current){
				helper.mission.updateChangeList(current);
			},
			//获取所有tab栏的个数
			getChangeCount:function(){
				helper.mission.getChangeCount();
			},
			changSwiper:function(e){
				helper.mission.changSwiper(e);
			},
			doneChange:function(e){
				let doneIndex = e.currentTarget.dataset.dindex;
				let id = e.currentTarget.dataset.id;
				helper.mission.doneChange(e,this);
				console.log("doneIndex===",doneIndex)
				if(doneIndex == 0 ||doneIndex == 2){
					this.getNextData(id);
				}
			},
			getNextData(id){
				Object.assign(this.$data, this.$options.data())
				let list = helper.mission.list;
				let index = -1;
				for(let i in list){
					if(id == list[i].id){
						index = parseInt(i)+1;
					}
				}
				if(list[index]){
					this.changeObj =list[index];
					helper.mission.getLastUpdate(this,list[index].id);
				}
			},
// 			getLastPageData(){
// 				var pages = getCurrentPages();
// 				var prevPage = pages[pages.length - 2];
// 				this.lastData = pages[pages.length - 2].data.$root[0];
// 				var changeList = this.lastData.changeList;
// 				this.changeList = changeList;
// 				console.log(changeList)
// 				for(let i in changeList){
// 					if(changeList[i].id == this.id){
// 						this.changeObj = changeList[i]
// 					}
// 				}
// 				console.log(this.changeObj)
// 			},
			radioChange(e){
				console.log(e)
			}
		}
	}
</script>

<style>
	.check-detail-tag{
		color:#ffffff;
		padding:15upx 36upx;
		border-radius:35upx;
		opacity:0.6;
	}
	.nok-color-0{
		background: #ffde00;
		color: #fefefe;
	}
	.nok-color-1{
		background: #ff9000;
		color: #fefefe;
	}
	.nok-color-2{
		background: #f46666;
		color: #fefefe;
	}
	.check-mic-div{
		width:160upx;
		height:44upx;
		border-radius:8upx;
		color:#787878;
		font-size:24upx;
		display:flex;
		justify-content:center;
		align-items:center;
		margin-left:27upx;
	}
	.mic-img{
		width: 52upx;
		height: 70upx;
	}
	.type-text{
		text-align: center;
		margin-top: 11upx;
	}
	.type-img-test{
		width: 52upx;
		height: 50upx;
	}
	.type-img-ambient{
		width: 39upx;
		height: 60upx;
	}
	.type-img-function{
		width: 67upx;
		height: 51upx;
	}
	.type-img-material{
		width: 71upx;
		height: 52upx;
	}
	.type-img-machine{
		width: 64upx;
		height: 52upx;
	}
	.type-img-person{
		width: 51upx;
		height: 51upx;
	}
	.check-type-list{
		display: flex;
		justify-content: space-around;
		align-items: center;
		font-size: 18upx;
	}
	.choose-item-hr{
		height: auto;
		width: 2upx;
		background: #f2f2f2;
	}
	.mission-choose-item{
		padding:15upx 40upx;
		border-radius:35upx;
		font-size:30upx;
		font-weight: bold;
	}
	.choose-item-word{
		color: #dedede;
	}
	.choose-item-color{
		background:#1398dc;
		color: #fefefe;
		padding:15upx 40upx;
		border-radius:35upx;
		font-size:30upx;
	}
	.list-name-left{
		word-break: break-all;
	}
	.mission-list-name{
		display: flex;
		justify-content: space-between;
		color: #878787;
		font-size: 24upx;
	}
	.mission-list-title{
		width: 100%;
		padding:20upx;
	}
	.mission-left-hr{
		width: 20upx;
		height: auto;
	}
	.mission-list-top{
		display: flex;
		background: #ffffff;
	}
	.check-record-button{
		display: flex;
		align-items: center;
	}
	.record-detail-count{
		margin-left: 30upx;
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
	.tab-color-3{
		background: rgb(255,108,2);
		color: rgb(255,255,255);
	}
	.tab-color-4{
		background: #007AFF;
		color: rgb(255,255,255);
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
	}
	.bottom-kongbai{
		width: 100%;
		height: 210upx;
	}
	.voice-seconds{
		font-size: 26upx;
		margin-left: 20upx;
	}
	.check-record-play{
		width:240upx;
		background:rgb(241,241,241);
		padding:10upx;
		border-radius:35upx;
		display:flex;
		align-items:center;
		justify-content: space-between;
	}
	.check-record{
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.check-radio-group .radio-list{
		width: 30%;
	}
	.check-radio-group{
		display: flex;
		flex-wrap:wrap;
		justify-content:center;
	}
	.check-help{
		display: flex;
		justify-content: flex-end;
		margin-right: 30upx;
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
	.radio-list{
		display: flex;
		align-items: center;
		font-size: 26upx;
		margin-bottom: 30upx;
	}
	.check-option-top{
		display:flex;
		flex-wrap: wrap;
	}
	.check-background{
		background: rgb(255,255,255);
	}
	.check-main{
		width: 100%;
		background: rgb(241,241,241);
	}
	.check-top{
		display:flex;
		font-size:26upx;
		padding: 30upx;
	}
	.check-top-number{
		display: flex;
		justify-content:center;
		align-items:center;
		background:rgb(1,184,213);
		color:rgb(255,255,255);
		padding:0upx 40upx;
		margin-right:20upx;
		border-radius:10upx;
	}
	.check-option{
		display:flex;
		height:80upx;
		font-size:26upx;
		align-items:center;
		border-bottom:1upx solid rgb(241,241,241);
	}
	.check-option-left{
		margin:0upx 30upx;
	}
	.check-image-top{
		padding: 30upx;
	}
	.check-image-title{
		font-size:30upx;
		color:#787878;
		margin-bottom: 30upx;
	}
	.check-textarea-top{
		width: 100%;
		height: 80upx;
	}
	.check-textarea{
		width:100%;
		border:1upx solid rgb(241,241,241);
		height:80upx;
	}
	.check-bottom{
		position:fixed;
		width:100%;
		bottom:0upx;
		height: 120upx;
		background: rgb(255,255,255);
		font-size: 26upx;
	}
	.check-bottom-menu{
		padding:30upx;
		font-size:30upx;
		display:flex;
		justify-content:space-between;
	}
	.bottom-menu-left{
		display: flex;
		align-items: center;
		/* background:#8F8F94; */
		color:rgb(255,255,255);
		border-radius:25upx;
		font-size: 26upx;
		padding:10upx 20upx;
	}
	.bottom-menu-right{
		display: flex;
		align-items: center;
		height: 100%;
		justify-content: space-around;
	}
	.bottom-menu-right >radio-group{
		display: flex;
		align-items: center;
	}
	.bottom-menu-list{
		display: flex;
		align-items: center;
		margin-right: 20upx;
	}
	.check-icon{
		margin-right: 10upx;
	}
	.bottom-submit-img{
		margin-right: 20upx;
	}
	.bottom-submit-img >image{
		width:30upx;
		height:50upx;
	}
	.bottom-menu-img{
		width: 50upx;
		height: 50upx;
		margin-right: 20upx;
	}
</style>
