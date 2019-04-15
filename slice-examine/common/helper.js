var mission = {
	checkList:[
		{
			date:'2019-03-05',
			type:'2',
			id:1,
			name:'车间主任-挤出检查表',
			month:'三',
			day:'05',
			week: '星期二',
			chooseArray:[
				{name:"表头1",checked:false,},
				{name:"表头2",checked:false,},
				{name:"表头3",checked:false,},
				{name:"表头4",checked:false,}],
				chooseIndex:-1,
				count:30,
				doneCount:25,
				chooseOne:["一二三四五六七八九十1","一二三四五","一二三四五六七八九十3","一二三四五六七八九十4"],
				chooseTwo:["区域1","区域","区域3","区域4"],
				chooseThree:["产线1","产线2","产线3","产线4"],
				chooseFour:["工位1","工位2","工位3","工位4"],
				oneIndex:0,
				twoIndex:0,
				threeIndex:0,
				fourIndex:0
		},
		{
			date:'2019-03-06',
			type:'2',
			id:2,
			name:'部长-挤出检查表',
			month:'十二',
			day:'06',
			week: '星期三',
			chooseArray:[
				{name:"表头1",checked:false,},
				{name:"表头2",checked:true,},
				{name:"表头3",checked:false,},
				{name:"表头4",checked:false,}],
			chooseIndex:-1,
			count:30,
			doneCount:25,
			chooseOne:["车间1","车间2","车间3","车间4"],
			chooseTwo:["区域1","区域","区域3","区域4"],
			chooseThree:["产线1","产线2","产线3","产线4"],
			chooseFour:["工位1","工位2","工位3","工位4"],
			oneIndex:0,
			twoIndex:0,
			threeIndex:0,
			fourIndex:0,
		},
		{
			date:'2019-03-07',
			type:'-1',
			id:3,
			name:'班组长-硫化检查表',
			month:'十二',
			day:'07',
			week: '星期四',
			chooseArray:[
				{name:"表头1",checked:false,},
				{name:"表头2",checked:false,},
				{name:"表头3",checked:true,},
				{name:"表头4",checked:false,}],
			chooseIndex:-1,
			count:30,
			doneCount:25,
			chooseOne:["车间1","车间2","车间3","车间4"],
			chooseTwo:["区域1","区域","区域3","区域4"],
			chooseThree:["产线1","产线2","产线3","产线4"],
			chooseFour:["工位1","工位2","工位3","工位4"],
			oneIndex:0,
			twoIndex:0,
			threeIndex:0,
			fourIndex:0,
		},
		{
			date:'2019-03-08',
			type:'-1',
			id:4,
			name:'车间主任-硫化检查表',
			month:'十二',
			day:'08',
			week: '星期五',
			chooseArray:[
				{name:"表头1",checked:false,},
				{name:"表头2",checked:false,},
				{name:"表头3",checked:false,},
				{name:"表头4",checked:true,}],
			chooseIndex:-1,
			count:30,
			doneCount:25,
			chooseOne:["车间1","车间2","车间3","车间4"],
			chooseTwo:["区域1","区域","区域3","区域4"],
			chooseThree:["产线1","产线2","产线3","产线4"],
			chooseFour:["工位1","工位2","工位3","工位4"],
			oneIndex:0,
			twoIndex:0,
			threeIndex:0,
			fourIndex:0,
		},
		{
			date:'2019-03-11',
			type:'-1',
			id:5,
			name:'部长-硫化检查表',
			month:'十二',
			day:'11',
			week: '星期一',
			chooseArray:[
				{name:"表头1",checked:false,},
				{name:"表头2",checked:true,},
				{name:"表头3",checked:false,},
				{name:"表头4",checked:false,}],
			chooseIndex:-1,
			count:30,
			doneCount:25,
			chooseOne:["车间1","车间2","车间3","车间4"],
			chooseTwo:["区域1","区域","区域3","区域4"],
			chooseThree:["产线1","产线2","产线3","产线4"],
			chooseFour:["工位1","工位2","工位3","工位4"],
			oneIndex:0,
			twoIndex:0,
			threeIndex:0,
			fourIndex:0,
		}
	],
	changeObj:{},
	lastUpdate:-1,
	changeList:[],
	current:0,
	tabList:[
		{name:'全部',count:0},
		{name:'NOK',count:0},
		{name:'未审核',count:0}
		],
	groupList:[
		{name:'材料/设备/装置',count:0,show:false,iconType:'arrowup'},
		{name:'工艺',count:0,show:false,iconType:'arrowup'},
		// {name:'分组3',count:0,show:false,iconType:'arrowup'}
	],
	list:[
		{
			id:1,
			name:'检查账上每天5个零件与现场实物是否相符（零件号，描述，帐数量，现场数量，库位）仅适用物料部员工审核项：AGV配料零件是否ODS要求放置，没有请记录问题？',
			doneArray:['OK','NOK','N/A'],
			doneIndex:-1,
			groupIndex:0,
			nokCount:20,
			fondCount:10,
			lastCount:30,
			updateArray:['当即整改','限期整改','问题解决'],
			updateIndex:-1
		},
		{
			id:2,
			name:'AGV配料零件是否ODS要求放置，没有请记录问题？',
			doneArray:['OK','NOK','N/A'],
			doneIndex:-1,
			groupIndex:0,
			nokCount:20,
			fondCount:10,
			lastCount:30,
			updateArray:['当即整改','限期整改','问题解决'],
			updateIndex:-1
		},
		{
			id:3,
			name:'生产控制中的异常有被有效记录：1)流量测试记录表（开机时填写）2)喷房风速记录单（开机时填写）3)喷房颗粒数量测试记录单（开机时填写）4)定喷测试记录表 5)产品检测记录表(色差、桔皮、光泽、膜厚、附着力）',
			doneArray:['OK','NOK','N/A'],
			doneIndex:-1,
			groupIndex:1,
			nokCount:19,
			fondCount:29,
			lastCount:39,
			updateArray:['当即整改','限期整改','问题解决'],
			updateIndex:-1
		},
		{
			id:4,
			name:'炉温曲线是否在控制范围内？',
			doneArray:['OK','NOK','N/A'],
			doneIndex:-1,
			groupIndex:1,
			nokCount:20,
			fondCount:10,
			lastCount:30,
			updateArray:['当即整改','限期整改','问题解决'],
			updateIndex:-1
		},
	],
	getCheckData:function(id,that){
		var checkList = mission.checkList;
		for(let i in checkList){
			if(id == checkList[i].id){
				console.log("checkList[i]:",checkList[i]);
				that.checkData = checkList[i];
			}
		}
	},
	//切换changelist内容
	updateChangeList:function(current,that){
		var list = mission.list;
		if(current ==0){
			that.changeList = list
			mission.changeList = list
		}else if(current ==1){
			mission.changeList =[];
			that.changeList =[];
			let changeList = []
			for(let i in list){
				let doneIndex = list[i].doneIndex;
				
				if(list[i].doneIndex == 1){
					changeList.push(list[i])
				}
			}
			mission.changeList = changeList
			that.changeList =changeList
		}else if(current ==2){
			mission.changeList =[];
			that.changeList =[];
			let changeList = []
			for(let i in list){
				let doneIndex = list[i].doneIndex;
				if(list[i].doneIndex == -1){
					changeList.push(list[i])
				}
			}
			mission.changeList = changeList
			that.changeList =changeList
		}
	},
	//获取所有tab栏的个数
	getChangeCount:function(that){
		let list = mission.list;
		let tabList = mission.tabList;
		for(let i in tabList){
			if(i == 0){
				tabList[i].count = list.length
			}else if(i == 1){
				let count =0
				for(let j in list){
					if(list[j].doneIndex ==1){
						count++
					}
				}
				tabList[i].count = count
			}else if(i ==2){
				let count =0
				for(let j in list){
					if(list[j].doneIndex == -1){
						count++
					}
				}
				tabList[i].count = count
			}
		}
		mission.tabList = tabList;
		that.tabList = tabList;
		that.groupList = mission.groupList;
	},
	changSwiper:function(e,that){
		mission.current = e.detail.current;
		that.current = e.detail.current;
		mission.updateChangeList(e.detail.current,that);
		mission.getChangeCount(that);
	},
	doneChange:function(e,that){
		let missonIndex = -1;
		let doneIndex = e.currentTarget.dataset.dindex;
		let item = mission.changeList[missonIndex];
		let id = e.currentTarget.dataset.id;
		let current= mission.current;
		mission.changeList.forEach(function(v,i){
			if(v.id == id){
				v.doneIndex =parseInt(doneIndex);
				missonIndex = i;
			}
		})
		mission.list.forEach(function(v,i){
			if(v.id == id){
				v.doneIndex =parseInt(doneIndex);
			}
		})
		if(current !=0){
			mission.changeList.splice(missonIndex,1);
		}
		that.changeList = mission.changeList
		mission.getChangeCount(that);
		console.log("mission.changeList:",mission.changeList)
		console.log("that.changeList:",that.changeList)
	},
	detailDoneChange:function(e,that){
		let missonIndex = -1;
		let doneIndex = e.detail.value;
		let item = mission.changeList[missonIndex];
		let id = e.currentTarget.dataset.id;
		let current= mission.current;
		mission.changeList.forEach(function(v,i){
			if(v.id == id){
				v.doneIndex =	parseInt(doneIndex);
				missonIndex = i;
			}
		})
		if(current !=0){
			mission.changeList.splice(missonIndex,1);
		}
		that.changeList = mission.changeList
		mission.lastUpdate = id;
	},
	getLastPageData(id,that){
		for(let i in mission.list){
			if(mission.list[i].id == id){
				mission.changeObj = mission.list[i];
				that.changeObj = mission.list[i];
			}
		}
	},
	getLastUpdate(that,id){
		if(id !=null){
			mission.lastUpdate =id;
		}
		that.lastUpdate = mission.lastUpdate;
	},
	gotoNext(id){
		uni.navigateTo({
			url: '../check-detail/check-detail?id='+id
		})
	}
};
var questionData = {
	checkList:[
		{
			startDate:'2019-03-05',
			endDate:'2019-04-02',
			count:'5',
			unit: '个',
			id:1,
			list:2,//完成进度
			code:'PD-LPA-LPA-LPA-20181114-002',
			name:'客户，平台，零件',
			come: '问题来源',
			user:'部门，员工',
			progress: 1,//进度:1、待完成 2、错误 3、未完成
			tabList:[
				{
					name:'紧急遏制',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'分析小组',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'问题描述',
					isDone: "2",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'临时措施',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'根本原因',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施1',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施2',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施3',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				}
			],
		},
		{
			startDate:'2019-03-05',
			endDate:'2019-04-02',
			count:'5',
			unit: '个',
			id:1,
			list:3,//完成进度
			code:'PD-LPA-LPA-LPA-20181114-002',
			name:'客户，平台，零件',
			come: '问题来源',
			user:'部门，员工',
			progress: 2,//进度:1、待完成 2、错误 3、未完成
			tabList:[
				{
					name:'紧急遏制',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'分析小组',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'问题描述',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'临时措施',
					isDone: "-1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'根本原因',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施1',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施2',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施3',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				}
			],
		},
		{
			startDate:'2019-03-05',
			endDate:'2019-04-02',
			count:'5',
			unit: '个',
			id:1,
			list:0,//完成进度
			code:'PD-LPA-LPA-LPA-20181114-002',
			name:'客户，平台，零件',
			come: '问题来源',
			user:'部门，员工',
			progress: 3,//进度:1、待完成 2、错误 3、已完成
			tabList:[
				{
					name:'紧急遏制',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'分析小组',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'问题描述',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'临时措施',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'根本原因',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施1',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施2',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施3',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				}
			],
		},
		{
			startDate:'2019-03-05',
			endDate:'2019-04-02',
			count:'5',
			unit: '个',
			id:1,
			list:6,//完成进度
			code:'PD-LPA-LPA-LPA-20181114-002',
			name:'客户，平台，零件',
			come: '问题来源',
			user:'部门，员工',
			progress: 1,//进度:1、待完成 2、错误 3、已完成
			tabList:[
				{
					name:'紧急遏制',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'分析小组',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'问题描述',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'临时措施',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'根本原因',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施1',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施2',
					isDone: "2",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施3',
					isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				}
			],
		},
		{
			startDate:'2019-03-05',
			endDate:'2019-04-02',
			count:'5',
			unit: '个',
			id:1,
			list:7,//完成进度
			code:'PD-LPA-LPA-LPA-20181114-002',
			name:'客户，平台，零件',
			come: '问题来源',
			user:'部门，员工',
			progress: 3,//进度:1、待完成 2、错误 3、已完成
			tabList:[
				{
					name:'紧急遏制',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'分析小组',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'问题描述',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'临时措施',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'根本原因',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施1',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施2',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				},
				{
					name:'永久措施3',
					isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
					icon: "usefullfill"
				}
			],
		}
	],
	tabList:[
		{
			name:'紧急遏制',
			isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
			icon: "usefullfill"
		},
		{
			name:'分析小组',
			isDone: "1",//1:完成 2:待完成 3: 未完成 -1:错误
			icon: "usefullfill"
		},
		{
			name:'问题描述',
			isDone: "2",//1:完成 2:待完成 3: 未完成 -1:错误
			icon: "usefullfill"
		},
		{
			name:'临时措施',
			isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
			icon: "usefullfill"
		},
		{
			name:'根本原因',
			isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
			icon: "usefullfill"
		},
		{
			name:'永久措施',
			isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
			icon: "usefullfill"
		},
		{
			name:'永久措施',
			isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
			icon: "usefullfill"
		},
		{
			name:'永久措施',
			isDone: "3",//1:完成 2:待完成 3: 未完成 -1:错误
			icon: "usefullfill"
		}
	],
	arr:[
		{
			name: '人',
			code: '001',
			level: 1,
			children:[]      
		},
		{
			name: '机',
			code: '001',
			level: 1,
			children:[]      
		},
		{
			name: '料',
			code: '001',
			level: 1,
			children:[]      
		},
		{
			name: '法',
			code: '001',
			level: 1,
			children:[]      
		},
		{
			name: '环',
			code: '001',
			level: 1,
			children:[]      
		},
		{
			name: '测',
			code: '001',
			level: 1,
			children:[]      
		}
	],
	esayQuestion:
	[
		{
			name: "是否遵循正常的工艺",
			optionIndex:-1,
			buttonOption:[
				{name:"是"}, 
				{name:"否"},
				{name:"不适用"},
				],
			inputOption:[{name:'说明'}]
		},
		{
			name: "是否使用正确的工具",
			optionIndex:-1,
			buttonOption:[
				{name:"是"}, 
				{name:"否"},
				{name:"不适用"},
				],
			inputOption:[{name:'说明'}]
		},
		{
			name: "是否使用正确的零件",
			optionIndex:-1,
			buttonOption:[
				{name:"是"}, 
				{name:"否"},
				{name:"不适用"},
				],
			inputOption:[{name:'说明'}]
		},
		{
			name: "是否符合图纸的要求",
			optionIndex:-1,
			buttonOption:[
				{name:"是"}, 
				{name:"否"},
				{name:"不适用"},
				],
			inputOption:[{name:'说明'}]
		}
	],
	hardQuestion:
	[
		{
			name: "工艺改变能否解决",
			optionIndex:-1,
			buttonOption:[
				{name:"是"}, 
				{name:"否"},
				{name:"不适用"},
				],
			inputOption:[{name:'说明'}]
		},
		{
			name: "是否需要产品更改",
			optionIndex:-1,
			buttonOption:[
				{name:"是"}, 
				{name:"否"},
				{name:"不适用"},
				],
			inputOption:[{name:'说明'}]
		},
		{
			name: "长期存在或者非常负责的问题",
			optionIndex:-1,
			buttonOption:[
				{name:"是"}, 
				{name:"否"},
				{name:"不适用"},
				],
			inputOption:[{name:'说明'}]
		},
	],
}
 var formDefinition= {
                    fields: [
                        {
                            label: '姓名', // 表单显示名称
                            name: 'name', // 每个表单项的唯一标识(不能重复)
                            type: 'input', // 表单项的类型 这里是输入框
                            inputType: 'text', // 输入框的类型,有 text number digit textarea
                            password: false, // 是否为密码输入框
                            placeholder: '请输入您的姓名', // 提示信息
                            disabled: false, // 是否禁用
                            maxLength: -1  // 最大输入长度
                        },
                        {
                            label: '个人简介', // 表单显示名称
                            name: 'desc', // 每个表单项的唯一标识(不能重复)
                            type: 'input', // 表单项的类型 这里是输入框
                            inputType: 'textarea',
                            password: false,
                            placeholder: '请输入您的个人简介',
                            disabled: false,
                            maxLength: -1
                        },
                        {
                            label: '爱好',
                            name: 'hobby',
                            type: 'select', // 表单项的类型 这里是选择类型 使用的是mpvue-picker
                            disabled: true,
                            placeholder: '请选择爱好',
                            picker: { // 这里是mpvuepicker的全部配置,具体使用可参考 https://github.com/zhetengbiji/mpvue-picker
                                themeColor: '#007AFF',
                                mode: 'selector',
                                deepLength: 2,
                                pickerValueDefault: [0],
                                pickerValueArray: [
                                    {
                                        label: '中国2222',
                                        value: 1
                                    },
                                    {
                                        label: '俄罗斯2222',
                                        value: 2
                                    },
                                    {
                                        label: '美国2222',
                                        value: 3
                                    },
                                    {
                                        label: '日本2222',
                                        value: 4
                                    }
                                ]
                            }
                        },
                        {
                            label: '生日',
                            name: 'birthday',
                            type: 'date', // 表单项的类型 这里是日期选择类型 使用的是原生picker
                            startDate: '', // 这是日期范围限制
                            endDate: '', // 这是日期范围限制
                            disabled: false,
                            placeholder: '请选择生日'
                        },
                        {
                            label: '是否同意',
                            name: 'accept',
                            type: 'switch' // 表单项的类型 这里是开关类型
                        },
                        {
                            label: '是否知道',
                            name: 'know',
                            type: 'radio', // 表单项的类型 这里是单选类型
                            options: [
                                {
                                    label: '知道', // 展示的名称
                                    value: 1 // 表单提交的值
                                },
                                {
                                    label: '不知道',
                                    value: 2
                                }
                            ]
                        },
                        {
                            label: '你的能力',
                            name: 'capa',
                            type: 'checkbox', // 表单项的类型 这里是多选框类型
                            options: [
                                {
                                    label: '变成', // 展示的名称
                                    value: 1  // 表单提交的值
                                },
                                {
                                    label: '游戏',
                                    value: 2
                                },
                                {
                                    label: '又晕',
                                    value: 3
                                },
                                {
                                    label: '上述',
                                    value: 4
                                }
                            ]
                        }
                    ],
                    showSubmitBtn: true, // 是否显示提交按钮
                    showResetBtn: true   // 是否显示重置按钮
                }
export default {  
	mission,
	questionData,
	formDefinition
}  