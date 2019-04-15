import Vue from 'vue'
import App from './App'

import store from './store'

import faicon from './components/fa-icon/fa-icon.vue'

import uniIcon from "./components/uni-icon/uni-icon.vue"

import uniList from './components/uni-list/uni-list.vue'

import uniListItem from './components/uni-list-item/uni-list-item.vue'

import neilModal from './components/neil-modal/neil-modal.vue';

import uniTag from "@/components/uni-tag/uni-tag.vue"

import uniSegmentedControl from "@/components/uni-segmented-control/uni-segmented-control.vue"

// import mpvuePicker from '@/components/mpvue-picker/mpvuePicker.vue';

import mpvueCityPicker from '@/components/mpvue-citypicker/mpvueCityPicker.vue'

// Vue.component('mpvue-picker',mpvuePicker)

Vue.component('mpvue-city-picker',mpvueCityPicker)

Vue.component('uni-segmented-control',uniSegmentedControl)

Vue.component('uni-tag',uniTag)

Vue.component('neil-modal',neilModal)

Vue.component('uni-list',uniList)

Vue.component('uni-list-item',uniListItem)

Vue.component('faicon',faicon)

Vue.component('uni-icon',uniIcon)

Vue.config.productionTip = false

Vue.prototype.$store = store

App.mpType = 'app'

const app = new Vue({
    store,
    ...App
})
app.$mount()
