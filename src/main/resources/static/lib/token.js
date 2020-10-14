
function setCookie(name, value) {
    var time = 24 * 60 * 60 * 1000;
    var exp = new Date().setHours(0, 0, 0, 0);
    var expires = new Date(exp + time);
    document.cookie=name+'=' + escape(value) + ';expires='+expires.toGMTString()+';path=/';
}

function getCookie(name) {
    var arr = null;
    var reg = new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    var arr=document.cookie.match(reg);
    if(arr) {
        return unescape(arr[2]);
    } else {
        return null; 
    }
}
//     url: 'http://14.116.223.88:9802'+ url,
//axios封装post请求
function axiosPostRequst(url,data) {
    let result = axios({
        method: 'post',
        url: 'http://192.168.43.214/APS/API/APSData'+ url,
        data: data,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }).then(resp=> {
        return resp.data;
    }).catch(error=>{
        return "exception="+error;
    });
    return result;
}
 
//get请求
function axiosGetRequst(url,params) {
    var result = axios({
        method: 'get',
        url: 'http://192.168.119.34:9802'+ url,
        headers: {
            'Authorization': 'Bearer ' + getCookie('token') 
        },
        params:params
    }).then(function (resp) {
        return resp.data;
    }).catch(function (error) {
        return "exception=" + error;
    });
    return result;
}