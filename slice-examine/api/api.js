/**
 *
 * @ClassName: api.js
 * @Description: 请求API
 * @author acai
 * @date 2018年9月7日 下午1:20:55
 *
 */
import request from './request.js';
const url ='123123';
class api {

  constructor() {
    this._baseUrl = 'http://192.168.1.112:8887/'
    this._defaultHeader = {
      'data-type': 'application/json' 
    }
    this._request = new request()
  }
 /**
   * 首页轮播图
   */
  homePageBanner() {
    let data = {
      page: 0,
      rows: 4
    }
    return this._request.postRequest(this._baseUrl + 'frontBanner/selectSmallAppBannerList', data).then(res => res.data)
  }
  /**
    * 登陸
    */
   login(code) {
     let data = {
       code:code
     }
     return this._request.postRequest(this._baseUrl + 'YsspUser/login', data).then(res => res.data)
   }
   /**
     * 分享文字
     */
    Sharetext(text) {
      let data = {
        text:text
      }
      return this._request.postRequest(this._baseUrl + 'YsspUser/login', data).then(res => res.data)
    }
	ss() {
	  return this._request.getRequest(this._baseUrl + 'kai/ss').then(res => res.data)
	}

}
export default api